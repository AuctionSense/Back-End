package org.auctionsense.service;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.auctionsense.domain.User;
import org.auctionsense.repository.UserRepository;

import io.quarkus.elytron.security.common.BcryptUtil;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public UserService()
    {

    }

    public Response addUser(User user)
    {
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        userRepository.persist(user);
        return Response.created(URI.create("/items/" + user.getId())).build();
    }
}
