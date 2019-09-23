package service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import pojo.Customer;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputeDistanceServiceImplTest {

    @Test
    public void computeDistance() {
        ComputeDistanceServiceImpl computeDistanceServiceImpl = new ComputeDistanceServiceImpl();
        double distance = computeDistanceServiceImpl.computeDistance(53.339428,-6.257664,52.986375,-6.043701);
        assertEquals(distance,41.768,2);
    }

    @Test
    public void getCustomers() throws Exception {
        ComputeDistanceServiceImpl computeDistanceServiceImpl = new ComputeDistanceServiceImpl();
        CustomerRepository repoMock = Mockito.mock(CustomerRepository.class);
        computeDistanceServiceImpl.setCustomerRepository(repoMock);
        Mockito.when(repoMock.getCustomersFromJson()).thenReturn(getCustomerList());
        List<Customer> dummyResponse = computeDistanceServiceImpl.getCustomers();
        Assert.assertEquals(dummyResponse.size(),1);
    }

    public List<Customer> getCustomerList() {
        Customer one = new Customer.CustomerBuilder()
                .name("John")
                .userId(23l)
                .latitude(54.1225)
                .longitude(-8.143333)
                .build();
        Customer two = new Customer.CustomerBuilder()
                .name("Lisa")
                .userId(23l)
                .latitude(53.0033946)
                .longitude(-6.3877505)
                .build();
        List<Customer> customers =  new ArrayList<>();
        customers.add(one);
        customers.add(two);
        return customers;
    }
}