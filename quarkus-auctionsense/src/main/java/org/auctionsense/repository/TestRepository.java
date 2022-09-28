package org.auctionsense.repository;

import javax.enterprise.context.ApplicationScoped;

import org.auctionsense.domain.Test;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TestRepository implements PanacheRepository<Test> {
    
}
