package org.agoncal.quarkus.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    EntityManager em;


    public void persist(Customer customer){
        em.persist(customer);
    }

    public Customer findById(Long id){
        return em.find(Customer.class, id);
    }
}
