import controller.ComputeDistanceController;

public class Application {
    public static void main(String args[]) throws Exception {
        ComputeDistanceController controller = new ComputeDistanceController();
        controller.writeToFile();
    }
}
