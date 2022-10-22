package org.auctionsense.repository;

import javax.enterprise.context.ApplicationScoped;

import org.auctionsense.domain.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    
}
