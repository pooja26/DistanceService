package repository;

import org.junit.Assert;
import org.junit.Test;
import pojo.Customer;
import java.util.List;

public class CustomerRepositoryTest {

    @Test
    public void getCustomersFromJson() {
        CustomerRepository repo = new CustomerRepository();
        List<Customer> customers = repo.getCustomersFromJson();
        Assert.assertNotNull(customers);
    }
}