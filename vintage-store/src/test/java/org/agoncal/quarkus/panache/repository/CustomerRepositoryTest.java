package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.agoncal.quarkus.jpa.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    void shouldCreateAndFindCustomer(){
        Customer customer = new Customer("first name","last name","email");
        repository.persist(customer);
        assertNotNull(customer.getId());
        customer = repository.findById(customer.getId());
        assertEquals("first name", customer.getFirstName());
        assertEquals("last name", customer.getLastName());
    }
}
