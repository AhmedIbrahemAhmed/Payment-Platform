package Bill;

import java.util.Random;

public class GasBill extends Bill {
    private String companyName;
    private String consumption ;
    private String address;

    public boolean setBillData(String subscriptonID){
        double[] randomValues = {80.50, 90.20, 100.0, 120.75,160.5,21000};
        String[] companyNames = {"GasCo", "EnergyGas", "PowerFuel"};
        String[] addresses = {"123 Main Street, Cityville", "456 Oak Avenue, Townsville", "789 Pine Road, Villagetown"};
        String[] billID = {"#20", "#324", "#4"};
        Random rand = new Random();

        setBillID(billID[rand.nextInt(billID.length)]);
        setBillPrice(randomValues[rand.nextInt(randomValues.length)]); 

        
        this.companyName = companyNames[rand.nextInt(companyNames.length)];

        
        this.consumption = String.valueOf(rand.nextInt(200) + 50); 

        
        this.address = addresses[rand.nextInt(addresses.length)];
        return true;
    }
    public void displayBill(){
        String gasBillMessage = String.format("Gas Bill Details\n\n" +
        "Bill ID: %s\n" +
        "Bill Price: $%.2f\n" +
        "Company Name: %s\n" +
        "Consumption: %d units\n" +
        "Address: %s", getBillID(), getBillPrice(), companyName, consumption, address);


        System.out.println(gasBillMessage);
    }
    public void pay(double amonut,String billID){
        //fake part;
    }

}
