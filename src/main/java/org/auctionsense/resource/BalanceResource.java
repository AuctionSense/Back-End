package org.auctionsense.resource;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.auctionsense.service.BalanceService;

import io.quarkus.security.Authenticated;

@Path("/api/user/balance")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BalanceResource {
    @Inject
    BalanceService balanceService;

    @GET
    @Path("/{email}")
    public BigDecimal GetUserBalance(String email)
    {
        return balanceService.getBalanceByEmail(email);
    }
}

