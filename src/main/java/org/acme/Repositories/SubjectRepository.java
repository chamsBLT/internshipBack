package org.acme.Repositories;

import javax.enterprise.context.ApplicationScoped;

import org.acme.Entities.Subject;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SubjectRepository implements PanacheRepository<Subject>{

}
