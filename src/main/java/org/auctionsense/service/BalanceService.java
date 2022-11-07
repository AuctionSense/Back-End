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
    public String UpdateBalance(String email, BigDecimal balance)
    {
        if (!userService.checkIfUserExists(email))
        {
            return "{\"message\": \"User doesn't exist.\"}";
        }

        userRepository.update("#User.updateBalance", Parameters.with("email", email).and("balance", balance));
        return "{\"message\": \"Balance succesfully updated.\"}";
    }
}
