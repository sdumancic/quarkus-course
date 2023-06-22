package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.quarkus.jpa.Customer;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> listAllCustomerDan(){
        return list("fistName = 'Dan'", Sort.by("lastName"));
    }

}
