package Bill;

import java.util.Random;

public class ElectricityBillData implements BillData {
    private double billPrice;
    private String companyName;
    private String consumption;
    private String address;

    public ElectricityBillData(double billPrice, String companyName, String consumption, String address) {
        this.billPrice = billPrice;
        this.companyName = companyName;
        this.consumption = consumption;
        this.address = address;
    }

    public void setBillData(String subscriptonID) {
        double[] randomValues = {50.75, 60.0, 70.50, 80.25, 90.0, 100.0};
        String[] companyNames = {"PowerCo", "EcoEnergy", "ElectricSource"};
        String[] addresses = {"234 High Voltage Street, Powercity", "567 Energy Lane, Electricville", "890 Generator Road, Wattstown"};
        Random rand = new Random();

        this.billPrice = randomValues[rand.nextInt(randomValues.length)];
        this.companyName = companyNames[rand.nextInt(companyNames.length)];
        this.consumption = String.valueOf(rand.nextInt(150) + 30);
        this.address = addresses[rand.nextInt(addresses.length)];
    }

    public double getBillPrice() {
        return billPrice;
    }

    public void displayBill() {
        String electricityBillMessage = String.format("Electricity Bill Details\n\n" +
                "Bill Price: $%.2f\n" +
                "Company Name: %s\n" +
                "Consumption: %s units\n" +
                "Address: %s", billPrice, companyName, consumption, address);

        System.out.println(electricityBillMessage);
    }
}
