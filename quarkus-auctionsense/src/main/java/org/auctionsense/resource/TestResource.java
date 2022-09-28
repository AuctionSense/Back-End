package org.auctionsense.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.auctionsense.domain.Test;
import org.auctionsense.service.TestService;

@Path("/api/tests")
public class TestResource {

    @Inject
    private TestService testService;

    public TestResource() {

    }

    @GET
    public List<Test> allTests()
    {
        return testService.allTests();
    }
}
