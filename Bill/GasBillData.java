package Bill;

import java.util.Random;

public class GasBillData implements BillData {
    private double billPrice;
    private String companyName;
    private String consumption ;
    private String address;

    public GasBillData(double billPrice, String companyName, String consumption, String address) {
        this.billPrice = billPrice;
        this.companyName = companyName;
        this.consumption = consumption;
        this.address = address;
    }
    public void setBillData(String subscriptonID){
        double[] randomValues = {80.50, 90.20, 100.0, 120.75,160.5,21000};
        String[] companyNames = {"GasCo", "EnergyGas", "PowerFuel"};
        String[] addresses = {"123 Main Street, Cityville", "456 Oak Avenue, Townsville", "789 Pine Road, Villagetown"};
        Random rand = new Random();

        
        this.billPrice = randomValues[rand.nextInt(randomValues.length)];

        
        this.companyName = companyNames[rand.nextInt(companyNames.length)];

        
        this.consumption = String.valueOf(rand.nextInt(200) + 50); 

        
        this.address = addresses[rand.nextInt(addresses.length)];
    }
    public double getBillPrice(){
        return billPrice;
    }
    public void displayBill(){
        String gasBillMessage = String.format("Gas Bill Details\n\n" +
        "Bill Price: $%.2f\n" +
        "Company Name: %s\n" +
        "Consumption: %d units\n" +
        "Address: %s", billPrice, companyName, consumption, address);

        System.out.println(gasBillMessage);
    }
}
