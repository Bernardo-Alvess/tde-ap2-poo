package com.refactorap2.refactorAP2.repositories;

import com.refactorap2.refactorAP2.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> { }
