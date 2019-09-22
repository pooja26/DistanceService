package repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pojo.Customer;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private JSONObject obj;
    private final static String FILESEPARATOR = "/";

    public List<Customer> getCustomersFromJson() {
        List<Customer> customerList = new ArrayList<Customer>();
        JSONParser parser = new JSONParser();
        String line;
        try {
            URL urlReader = new URL("https://s3.amazonaws.com/intercom-take-home-test/customers.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlReader.openStream()));
            while((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) parser.parse(line);
                customerList.add(getCustomer());
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to open the file...");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading the file...");
            e.printStackTrace();
        }
        return customerList;
    }

    public void writeToFile(List<Customer> customersNearToOffice) throws IOException {
        File f = new File(System.getProperty("user.home")+FILESEPARATOR+"output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
        bufferedWriter.write("UserId        Name"+"\n");
        customersNearToOffice.stream().forEach(customer -> {
            try {
                bufferedWriter.write(customer.getUserId()+"        "+customer.getName()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
        System.out.println("output to file...");
    }


    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setUserId((Long) obj.get("user_id"));
        customer.setName((String) obj.get("name"));
        customer.setLongitude(Double.valueOf((String) obj.get("longitude")));
        customer.setLatitude(Double.valueOf((String) obj.get("latitude")));
        return customer;
    }
}
