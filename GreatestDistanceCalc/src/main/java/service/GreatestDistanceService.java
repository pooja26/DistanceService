package service;

import pojo.Customer;
import repository.CustomerRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestDistanceService {

    private static final double officeLatitude = 53.339428;
    private static final double officeLongitude = -6.257664;

    public void getCustomers() throws IOException {
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customersNearToOffice =  customerRepository.getCustomersFromJson().stream()
                .filter(x -> computeDistance(officeLatitude,officeLongitude,x.getLatitude(),x.getLongitude(),x) <= 100)
                .sorted(Comparator.comparingDouble(Customer::getDistanceFromOffice))
                .collect(Collectors.toList());
        customerRepository.writeToFile(customersNearToOffice);
    }

    /**
     * This method uses the haversine formula to compute the distance
     * between two points.
     *
     * @param lat1 The latitude of first point.
     * @param lon1 The longitude of fir st point.
     * @param lat2 The latitude of second point.
     * @param lon2 The longitude of second point.
     *
     * @return The distance between two points in km.
     **/
    static double computeDistance(double lat1, double lon1, double lat2, double lon2, Customer customer) {
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
        customer.setDistanceFromOffice(distance);
        return distance;
    }
}
