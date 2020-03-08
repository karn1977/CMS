package com.merajeev.cms.service;

import com.merajeev.cms.dao.CustomerDAO;
import com.merajeev.cms.exception.CustomerNotFoundException;
import com.merajeev.cms.exception.CustomerNotFoundException;
import com.merajeev.cms.model.Customer;
import org.apache.logging.log4j.spi.CopyOnWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> customerList=new CopyOnWriteArrayList<> (  );

    public Customer addCustomer (Customer customer){
/*        customer.setCustomerid (customerIdCount);
        customerList.add (customer);
        customerIdCount++;*/
        return customerDAO.save(customer);
      //  return customer;
    }

    public List<Customer> getCustomers(){

        return customerDAO.findAll();
        //return customerList;
    }

    public Customer getCustomer(int customerid){
       /*return customerList
                .stream()
                .filter(c -> c.getCustomerid() == customerid)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDAO.findById(customerid);

       if(!optionalCustomer.isPresent())
           throw new CustomerNotFoundException("Customer Record is not available.....");
       return optionalCustomer.get();
        }

        public Customer updateCustomer(int customerId, Customer customer) {
            customer.setCustomerid(customerId);
/*        customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerid() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCutomerLastName(customer.getCutomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
             return customerList
                     .stream()
                     .filter(c -> c.getCustomerid() == customerId)
                     .findFirst()
                     .get();*/
            return customerDAO.save(customer);
                }
            public void deleteCustomer(int customerId){

                   /* customerList
                            .stream()
                            .forEach(c -> {
                                if (c.getCustomerid() == customerId) {
                                    customerList.remove(c);
                                }
                            });*/
                   customerDAO.deleteById(customerId);

        }

        }
