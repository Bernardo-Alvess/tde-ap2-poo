package com.refactorap2.refactorAP2.controller;
import com.refactorap2.refactorAP2.entities.Customer;
import com.refactorap2.refactorAP2.services.CustomerService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    private CustomerService service;
    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getCustomers(@RequestParam @Nullable Integer age){
        return ResponseEntity.ok().body(service.getAllCustomers(age));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer){
        this.service.addCustomer(customer);
        return ResponseEntity.status(201).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClientById(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok().body(service.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok().body(service.deleteCustomerById(id));

    }
}
