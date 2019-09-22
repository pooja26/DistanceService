package controller;

import service.ComputeDistanceService;

public class ComputeDistanceController {

    public void getCustomers() throws Exception {
        ComputeDistanceService service = new ComputeDistanceService();
        service.getCustomers();
    }

    public void writeToFile() throws Exception {
        ComputeDistanceService service = new ComputeDistanceService();
        service.writeToFile();
    }
}
