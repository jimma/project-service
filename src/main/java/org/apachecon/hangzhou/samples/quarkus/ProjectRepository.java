package org.apachecon.hangzhou.samples.quarkus;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectRepository implements PanacheRepository<Project> {

    public List<Project> findByName(String name) {
        return find("name", name).list();
    }

    public List<Project> findByAgeGreaterThan(int age) {
        return find("age > ?1", age).list();
    }
}
