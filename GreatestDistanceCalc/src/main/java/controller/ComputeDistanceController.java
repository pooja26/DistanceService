package controller;

import service.ComputeDistanceServiceImpl;

public class ComputeDistanceController {

    public void getCustomers() throws Exception {
        ComputeDistanceServiceImpl service = new ComputeDistanceServiceImpl();
        service.getCustomers();
    }

    public void writeToFile() throws Exception {
        ComputeDistanceServiceImpl service = new ComputeDistanceServiceImpl();
        service.writeToFile();
    }
}
