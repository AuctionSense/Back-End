package org.auctionsense.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.security.Authenticated;

@Authenticated
@Path("/api/admins")
public class AdminResource {
    @GET
    @Path("/admin")
    public String admin() {
        return "granted";
    }
}
