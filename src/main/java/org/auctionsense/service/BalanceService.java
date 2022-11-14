package org.auctionsense.service;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.auctionsense.domain.User;
import org.auctionsense.repository.UserRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class BalanceService {
    @Inject
    UserRepository userRepository;

    @Inject
    UserService userService;

    public BalanceService() {

    }

    public BigDecimal getBalanceByEmail(String email)
    {
        User user = userRepository.find("#User.getByEmail", Parameters.with("email", email).map()).firstResult();
        return user.getPrice();
    }

    @Transactional
    public String UpdateBalance(String email, BigDecimal amount)
    {
        if (!userService.checkIfUserExists(email))
        {
            return "{\"message\": \"User doesn't exist.\"}";
        }

        if (amount.intValue() < 10)
        {
            return "{\"message\": \"Minimum amount is €10,-\"}";
        }
        
        if (amount.intValue() > 1000)
        {
            return "{\"message\": \"Maximum amount is €1000,-\"}";
        }

        BigDecimal newBalance = amount.add(getBalanceByEmail(email));

        try {
            userRepository.update("#User.updateBalance", Parameters.with("email", email).and("balance", newBalance));
            return "{\"message\": \"Balance succesfully updated.\", \"newBalance\": \"" + newBalance.toString() + "\"}";
        }
        catch (Exception error) {
            return String.format("{\"message\": \"%s\"}", error.getMessage());
        }
    }
}
