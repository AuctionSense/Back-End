package org.auctionsense.service;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.User;
import org.auctionsense.repository.UserRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class BalanceService {
    @Inject
    UserRepository userRepository;
    
    public BalanceService() {

    }

    public BigDecimal getBalanceByEmail(String email)
    {
        User user = userRepository.find("#User.getBalanceByEmail", Parameters.with("email", email).map()).firstResult();
        return user.getPrice();
    }
}
