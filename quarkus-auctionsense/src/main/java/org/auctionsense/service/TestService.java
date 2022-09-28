package org.auctionsense.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.Test;
import org.auctionsense.repository.TestRepository;

@ApplicationScoped
public class TestService {

    @Inject
    TestRepository testRepository;

    public TestService()
    {

    }

    public List<Test> allTests()
    {
        return testRepository.listAll();
    }
}
