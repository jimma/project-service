package org.apachecon.hangzhou.samples.quarkus;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.apachecon.hangzhou.samples.quarkus.ProjectRepository;
import org.jboss.resteasy.annotations.cache.NoCache;

import io.quarkus.security.identity.SecurityIdentity;
@Path("/project")
public class ProjectResource {
    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    ProjectRepository projectRepository;

    @POST
    @Transactional
    public Project addProject(Project project) {
        projectRepository.persist(project);
        return project;
    }

    @GET
    public List<Project> getQuarkusProject() {
        return projectRepository.findByName("quarkus");
    }

    @GET
    @Path("/name/{name}")
    public List<Project> getProjectsByName(@PathParam("name") String name) {
        return projectRepository.findByName(name);
    }

    
    @GET
    @Path("/age/{age}")
    @RolesAllowed("user")
    @NoCache
    public List<Project> getProjectsGreeterThanAge(@PathParam("age") int age) {
        return projectRepository.findByAgeGreaterThan(age);
    }

    @GET
    @Path("/{id}")
    public Project getProjectById(@PathParam("id") Long id) {
        return projectRepository.findById(id);
    }

}