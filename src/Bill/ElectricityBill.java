package Bill;

import java.util.Random;

public class ElectricityBill extends Bill {
    private String companyName;
    private String address;

    public boolean setBillData(String subscriptonID) {
        double[] randomValues = {50.75, 60.0, 70.50, 80.25, 90.0, 100.0};
        String[] companyNames = {"PowerCo", "EcoEnergy", "ElectricSource"};
        String[] addresses = {"234 High Voltage Street, Powercity", "567 Energy Lane, Electricville", "890 Generator Road, Wattstown"};
        String[] billID = {"#5", "#12", "#27"};
        Random rand = new Random();
        setBillID(billID[rand.nextInt(billID.length)]);
        setBillPrice(randomValues[rand.nextInt(randomValues.length)]);
        this.companyName = companyNames[rand.nextInt(companyNames.length)];
        this.address = addresses[rand.nextInt(addresses.length)];
        return true;
    }

    public void displayBill() {
        String electricityBillMessage = String.format("Electricity Bill Details\n\n" +
                "Bill ID: %s\n" +
                "Bill Price: $%.2f\n" +
                "Company Name: %s\n" +
                "Address: %s", getBillID(), getBillPrice(), companyName, address);

        System.out.println(electricityBillMessage);
    }
    public void pay(double amonut,String billID){
        //fake part;
    }
}
