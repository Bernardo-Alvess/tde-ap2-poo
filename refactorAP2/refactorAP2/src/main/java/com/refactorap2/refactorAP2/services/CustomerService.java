package com.refactorap2.refactorAP2.services;

import com.refactorap2.refactorAP2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.refactorap2.refactorAP2.entities.Customer;

import javax.swing.text.DefaultEditorKit;

@Service
public class CustomerService {


    CustomerRepository repository;
    @Autowired
    public CustomerService(CustomerRepository repository){ this.repository = repository; }


    public Iterable<Customer> getAllCustomers(Integer age) {
        if(age == null){
            return this.repository.findAll();
        }else{
            return getCustomerByAge(age);
        }
    }

    public ArrayList<Customer> getCustomerByAge(int age){
       ArrayList<Customer> filteredCustomers = new ArrayList<>();

       Iterable<Customer> list = getAllCustomers(null);

        for(Customer customer : list){
            if(customer.getAge() == age){
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }
    public void addCustomer(Customer customer){
        this.repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id){
        return this.repository.findById(id);
    }

    public Optional<Customer> updateCustomer(Long id, Customer customer){
        Optional<Customer> customer1 = this.repository.findById(id);
        customer1.get().setAge(customer.getAge());
        customer1.get().setName(customer.getName());
        customer1.get().setProfession(customer.getProfession());

        this.repository.s
        return customer1;
    }

    public String deleteCustomerById(Long id){
        try {
            this.repository.deleteById(id);
            return "sucesso";

        } catch (IllegalArgumentException e){
            return null;
        }
    }
}
