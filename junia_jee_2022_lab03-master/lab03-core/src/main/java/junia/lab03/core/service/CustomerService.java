package junia.lab03.core.service;

import junia.lab03.core.dao.CustomerDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab03.core.entity.Customer;

@Service
@Transactional
public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void deleteAll() {
        //TODO implement
        customerDAO.deleteAll();
    }


    public void save(Customer customer) {
        //TODO implement
        customerDAO.save(customer);
    }


    public long countAll() {
        //TODO implement
        return customerDAO.count();
    }
}
