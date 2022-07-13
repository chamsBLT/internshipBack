package org.acme.Repositories;

import javax.enterprise.context.ApplicationScoped;

import org.acme.Entities.Intern;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class InternRepository implements PanacheRepository<Intern>{

}
