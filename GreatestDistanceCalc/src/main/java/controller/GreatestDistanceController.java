package controller;

import service.GreatestDistanceService;

import java.io.IOException;

public class GreatestDistanceController {

    public void getCustomers() throws IOException {
        GreatestDistanceService service = new GreatestDistanceService();
        service.getCustomers();
    }
}
