package org.auctionsense.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.security.Authenticated;

@Path("/api/user")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BalanceResource {
    @GET
    @Path("/balance")
    public Balance GetUserBalance()
    {
        return new Balance();
    }

    
    public static class Balance {
        private String balance = "10";

        public String getBalance() {
            return balance;
        }
    }
}

