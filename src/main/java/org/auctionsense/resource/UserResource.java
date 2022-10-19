package org.auctionsense.resource;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.auctionsense.domain.User;
import org.auctionsense.service.UserService;
import org.auctionsense.service.UserService.Result;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;    

    public UserResource() {

    }

    @POST
    @Transactional
    @PermitAll
    public Result addUser(User user)
    {
        User userCreate = new User();
        userCreate.setUsername(user.getUsername());
        userCreate.setPassword(user.getPassword());

        try {
            Result result = userService.addUser(userCreate);
            return result;
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }
}
