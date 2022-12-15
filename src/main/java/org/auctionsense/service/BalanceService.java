package org.auctionsense.service;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.auctionsense.domain.User;
import org.auctionsense.repository.UserRepository;

import io.quarkus.panache.common.Parameters;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class BalanceService {
    @Inject
    UserRepository userRepository;

    @Inject
    UserService userService;

    @Inject
    SecurityIdentity securityIdentity;

    public BalanceService() {

    }

    public String getBalanceByEmail(String email)
    {
        if (!securityIdentity.getPrincipal().getName().equals(email))
        {
            return "{\"message\": \"User and token aren't correct.\"}";
        }
        User user = userRepository.find("#User.getByEmail", Parameters.with("email", email).map()).firstResult();
        return user.getBalance().toString();
    }

    @Transactional
    public String UpdateBalance(String email, BigDecimal amount)
    {
        if (!userService.checkIfUserExists(email))
        {
            return "{\"message\": \"User doesn't exist.\"}";
        }

        if (!securityIdentity.getPrincipal().getName().equals(email))
        {
            return "{\"message\": \"User and token aren't correct.\"}";
        }

        if (amount.intValue() < 10 || amount.intValue() > 1000)
        {
            return "{\"message\": \"Minimum amount is €10,- and maximum amount is €1000,-\"}";
        }

        BigDecimal oldBalance = new BigDecimal(getBalanceByEmail(email));
        BigDecimal newBalance = amount.add(oldBalance);

        try {
            userRepository.update("#User.updateBalance", Parameters.with("email", email).and("balance", newBalance));
            return "{\"message\": \"Balance succesfully updated.\", \"newBalance\": \"" + newBalance.toString() + "\"}";
        }
        catch (Exception error) {
            return String.format("{\"message\": \"%s\"}", error.getMessage());
        }
    }

    @ConsumeEvent("UpdateProductPrice")
    @Transactional
    @Blocking
    public void UpdateBalanceOnPayment(JsonObject body)
    {
        User user = userService.getUserByEmail(body.getString("user"));
        BigDecimal amount = new BigDecimal(body.getString("amount"));
        BigDecimal newBalance = user.getBalance().subtract(amount);
        userRepository.update("#User.updateBalance", Parameters.with("email", body.getString("user")).and("balance", newBalance));
    }
}
