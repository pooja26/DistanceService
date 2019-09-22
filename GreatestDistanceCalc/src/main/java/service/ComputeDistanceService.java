package service;

import pojo.Customer;

import java.util.List;

public interface ComputeDistanceService {
    public List<Customer> getCustomers() throws Exception;
    public void writeToFile() throws Exception;
    public double computeDistance(double lat1, double lon1, double lat2, double lon2);
}
