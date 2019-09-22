package service;

import com.google.common.annotations.VisibleForTesting;
import pojo.Customer;
import repository.CustomerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComputeDistanceService {

    private static final double officeLatitude = 53.339428;
    private static final double officeLongitude = -6.257664;

    private CustomerRepository customerRepository;
    public ComputeDistanceService() {
        customerRepository = new CustomerRepository();
    }

    @VisibleForTesting
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() throws Exception {
        List<Customer> customers = customerRepository.getCustomersFromJson();
        if (customers.isEmpty()) {
            throw new Exception("No customers present!!");
        }
        List<Customer> customersNearToOffice =  customers.stream()
                .map(customer -> {
                    double dist = computeDistance(officeLatitude,officeLongitude,customer.getLatitude(),customer.getLongitude());
                    return new Customer.CustomerBuilder()
                            .userId(customer.getUserId())
                            .longitude(customer.getLongitude())
                            .latitude(customer.getLatitude())
                            .name(customer.getName())
                            .distanceFromOffice(dist)
                            .build();
                })
                .filter(customer -> customer.getDistanceFromOffice() <= 100)
                .sorted(Comparator.comparingDouble(Customer::getDistanceFromOffice))
                .collect(Collectors.toList());
        return customersNearToOffice;
    }

    public void writeToFile() throws Exception {
        customerRepository.writeToFile(getCustomers());
    }

    /**
     * This method uses the haversine formula to compute the distance
     * between two points.
     *
     * @param lat1 The latitude of first point.
     * @param lon1 The longitude of first point.
     * @param lat2 The latitude of second point.
     * @param lon2 The longitude of second point.
     *
     * @return The distance between two points in km.
     **/
    public double computeDistance(double lat1, double lon1, double lat2, double lon2) {
        double rLat1 = Math.toRadians(lat1);
        double rLat2 = Math.toRadians(lat2);
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double sindLat = Math.sin(dLat / 2);
        double sindLon = Math.sin(dLon / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLon, 2)
                * Math.cos(rLat1) * Math.cos(rLat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double earthRadius = 6371.0;
        double distance = earthRadius*c;
        return distance;
    }
}
