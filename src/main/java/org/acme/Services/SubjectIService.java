package org.acme.Services;

import java.util.List;

import org.acme.Entities.Subject;

public interface SubjectIService {
	
	Subject getSubjectById(long id) ;
	
	List<Subject> retrieveSubjects();

	Subject addSubject(Subject s);

	Subject updateSubject (Long id, Subject s);

	void removeSubject (Long id);
	
}
