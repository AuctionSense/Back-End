package org.auctionsense.service;

import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.auctionsense.domain.User;
import org.auctionsense.repository.UserRepository;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    @Inject
    Validator validator;
    

    public UserService()
    {

    }

    public Result addUser(@Valid User user)
    {
        if (checkIfUserExists(user))
        {
            return new Result("Username already exists.", false);
        }
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        userRepository.persist(user);
        return new Result("Username succesfully created.", true);
    }

    private boolean checkIfUserExists(User user){
        long count = userRepository.find("#User.checkIfAlreadyExists", Parameters.with("username", user.getUsername())).count();

        if (count == 0)
        {
            return false;
        }
        
        return true;
    }

    public static class Result {
        private String message;
        private boolean success;
    
        public Result(String message, boolean success) {
            this.success = success;
            this.message = message;
        }
    
        public Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                 .map(cv -> cv.getMessage())
                 .collect(Collectors.joining(", "));
        }
    
        public String getMessage() {
            return message;
        }
    
        public boolean isSuccess() {
            return success;
        }
    }
}
