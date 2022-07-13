package org.acme.Services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.Entities.Subject;
import org.acme.Repositories.SubjectRepository;

@ApplicationScoped
public class SubjectImpService implements SubjectIService {

    private final SubjectRepository subjectRepository;

    @Inject
    public SubjectImpService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
	@Override
	public Subject getSubjectById(long id) {
		return subjectRepository.findByIdOptional(id).get();
	}

	@Override
	public List<Subject> retrieveSubjects() {
		return subjectRepository.listAll();
	}
	
	@Transactional
	@Override
	public Subject addSubject(Subject s) {
		subjectRepository.persistAndFlush(s);
        return s;
	}

	@Transactional
	@Override
	public Subject updateSubject(Long id, Subject s) {
		Subject existingSubject = getSubjectById(id);
		existingSubject.setNumber(s.getNumber());
		existingSubject.setTitle(s.getTitle());
		existingSubject.setDescription(s.getDescription());
		existingSubject.setField(s.getField());
		existingSubject.setStartingDate(s.getStartingDate());
		existingSubject.setPeriod(s.getPeriod());
		existingSubject.setInterns(s.getInterns());
		
		subjectRepository.persist(existingSubject);
        return existingSubject;
	}

	@Transactional
	@Override
	public void removeSubject(Long id) {
		subjectRepository.delete(getSubjectById(id));
	}

}
