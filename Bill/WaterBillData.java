package Bill;

import java.util.Random;

public class WaterBillData implements BillData {
    private double billPrice;
    private String companyName;
    private String consumption;
    private String address;

    public WaterBillData(double billPrice, String companyName, String consumption, String address) {
        this.billPrice = billPrice;
        this.companyName = companyName;
        this.consumption = consumption;
        this.address = address;
    }

    public void setBillData(String subscriptonID) {
        double[] randomValues = {25.75, 30.0, 35.50, 40.25, 50.0, 60.0};
        String[] companyNames = {"AquaServices", "PureWater", "HydroFlow"};
        String[] addresses = {"321 Lakeview Drive, Watertown", "555 River Road, Aquaville", "876 Stream Lane, Waterland"};
        Random rand = new Random();

        this.billPrice = randomValues[rand.nextInt(randomValues.length)];
        this.companyName = companyNames[rand.nextInt(companyNames.length)];
        this.consumption = String.valueOf(rand.nextInt(100) + 20); 
        this.address = addresses[rand.nextInt(addresses.length)];
    }

    public double getBillPrice() {
        return billPrice;
    }

    public void displayBill() {
        String waterBillMessage = String.format("Water Bill Details\n\n" +
                "Bill Price: $%.2f\n" +
                "Company Name: %s\n" +
                "Consumption: %s units\n" +
                "Address: %s", billPrice, companyName, consumption, address);

       
        System.out.println(waterBillMessage);
    }
}
