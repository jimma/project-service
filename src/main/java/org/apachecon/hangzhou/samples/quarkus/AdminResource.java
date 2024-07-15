package org.apachecon.hangzhou.samples.quarkus;
import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.apachecon.hangzhou.samples.quarkus.ProjectRepository;
import org.jboss.resteasy.annotations.cache.NoCache;

import io.quarkus.security.identity.SecurityIdentity;
@Path("/admin")
public class AdminResource {
    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    ProjectRepository projectRepository;

    @GET
    @RolesAllowed("admin")
    @NoCache
    public List<Project> getAllProjects() {
        return projectRepository.listAll();
    }

}