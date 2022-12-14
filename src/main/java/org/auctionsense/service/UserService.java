package org.auctionsense.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.User;
import org.auctionsense.repository.UserRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public boolean checkIfUserExists(String email)
    {
        long count = userRepository.find("#User.getByEmail", Parameters.with("email", email)).count();

        if (count == 0)
        {
            return false;
        }

        return true;
    }

    public User getUserByEmail(String email)
    {
        return userRepository.find("#User.getByEmail", Parameters.with("email", email)).firstResult();
    }
}
