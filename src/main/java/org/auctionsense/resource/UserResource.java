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
        if (user.getId() != null|| user.getRole() != "user")
        {
            return new Result("Cannot set id or role.", false);
        }
        try {
            Result result = userService.addUser(user);
            return result;
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }
}
