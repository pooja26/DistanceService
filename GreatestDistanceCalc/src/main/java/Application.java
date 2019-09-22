import controller.GreatestDistanceController;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Application {
    public static void main(String args[]) throws IOException, ParseException {
        GreatestDistanceController controller = new GreatestDistanceController();
        controller.getCustomers();
    }
}
