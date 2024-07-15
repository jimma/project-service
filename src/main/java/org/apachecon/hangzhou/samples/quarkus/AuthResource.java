package org.apachecon.hangzhou.samples.quarkus;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.net.URI;

@Path("/auth")
@RequestScoped
public class AuthResource {

    @Inject
    @ConfigProperty(name = "quarkus.oidc.auth-server-url")
    String authServerUrl;

    @Inject
    @ConfigProperty(name = "quarkus.oidc.client-id")
    String clientId;

    @Context 
    jakarta.servlet.http.HttpServletRequest request;

    @GET
    @Path("/logout")
    public Response logout() {
        try {
            String logoutUri = UriBuilder.fromUri(authServerUrl + "/protocol/openid-connect/logout")
                    .queryParam("client_id", clientId)
                    .queryParam("post_logout_redirect_uri", "http://localhost:8080/")
                    .build()
                    .toString();
            request.logout();
            return Response.seeOther(URI.create(logoutUri)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Logout failed").build();
        }
    }


    @GET
    @Path("/login")
    public Response login() {
        try {
            String logoutUri = UriBuilder.fromUri(authServerUrl + "/protocol/openid-connect/auth")
                    .queryParam("client_id", clientId)
                    .queryParam("redirect_uri", "http://localhost:8080/")
                    .queryParam("response_type","code")
                    .queryParam("scope", "openid")
                    .build()
                    .toString();
            
            return Response.seeOther(URI.create(logoutUri)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Logout failed").build();
        }
    }

}