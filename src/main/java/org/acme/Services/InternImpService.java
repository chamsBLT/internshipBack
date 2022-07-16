package org.acme.Services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.Entities.Intern;
import org.acme.Entities.Subject;
import org.acme.Repositories.InternRepository;
import org.acme.Repositories.SubjectRepository;

@ApplicationScoped
public class InternImpService implements InternIService {

	private final InternRepository internRepository;
	
	private final SubjectRepository subjectRepository;

	private final SubjectIService subjectIService;

	@Inject
	public InternImpService(InternRepository internRepository, SubjectIService subjectIService, SubjectRepository subjectRepository) {
		this.internRepository = internRepository;
		this.subjectIService = subjectIService;
		this.subjectRepository = subjectRepository;
	}

	@Override
	public List<Intern> retrieveInterns() {
		return internRepository.listAll();
	}

	@Transactional
	@Override
	public Intern addIntern(Intern i) {
		internRepository.persistAndFlush(i);
		return i;
	}

	@Transactional
	@Override
	public Intern updateIntern(Long id, Intern i) {
		Intern existingIntern = getInternById(id);
		existingIntern.setCIN(i.getCIN());
		existingIntern.setFirstName(i.getFirstName());
		existingIntern.setLastName(i.getLastName());
		existingIntern.setSchool(i.getSchool());
		existingIntern.setEmail(i.getEmail());
		existingIntern.setNum(i.getNum());
		existingIntern.setSubject(i.getSubject());

		internRepository.persist(existingIntern);
		return existingIntern;
	}

	@Transactional
	@Override
	public void removeIntern(Long id) {
		internRepository.delete(getInternById(id));
	}

	@Override
	public Intern getInternById(long id) {
		return internRepository.findByIdOptional(id).get();
	}

	@Transactional
	@Override
	public Intern affectSubject(Long idi, Long ids) {
		Intern i = getInternById(idi);
		Subject s = subjectIService.getSubjectById(ids);

		i.setSubject(s);

		internRepository.persist(i);
		return i;
	}

	@Override
	public Intern unaffectSubject(Long idi) {
		Intern i = getInternById(idi);
		Subject s = i.getSubject();
		List<Intern> interns = s.getInterns();
		
		for(int x = 0; x < interns.size(); x++) {
			Intern intern = interns.get(x);
			if(intern.getIdIntern() == i.getIdIntern()) {
				interns.remove(x);
				
				s.setInterns(interns);
				i.setSubject(s);
				
				subjectRepository.persist(s);
				internRepository.persist(i);
				break;
			}	
		}
		
		return i;
	}

}
