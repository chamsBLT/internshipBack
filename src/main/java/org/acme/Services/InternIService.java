package org.acme.Services;

import java.util.List;

import org.acme.Entities.Intern;

public interface InternIService {
	
    Intern getInternById(long id) ;
    
	List<Intern> retrieveInterns();

	Intern addIntern(Intern i);

	Intern updateIntern (Long id ,Intern i);

	void removeIntern (Long id);
	
	Intern affectSubject(Long idi, Long ids);

}
