package Bill;

import java.util.Random;

public class WaterBill extends Bill {
    private String companyName;
    private String consumption;
    private String address;
    private String meterType;

    public boolean setBillData(String subscriptonID) {
        double[] randomValues = {25.75, 30.0, 35.50, 40.25, 50.0, 60.0};
        String[] companyNames = {"AquaServices", "PureWater", "HydroFlow"};
        String[] addresses = {"321 Lakeview Drive, Watertown", "555 River Road, Aquaville", "876 Stream Lane, Waterland"};
        String[] billID = {"#2", "#32", "#45"};
        String[] METER_TYPES = {"Standard", "Digital", "Smart"};
        Random rand = new Random();
        setBillID(billID[rand.nextInt(billID.length)]);
        setBillPrice(randomValues[rand.nextInt(randomValues.length)]);
        this.meterType = METER_TYPES[rand.nextInt(METER_TYPES.length)];
        this.companyName = companyNames[rand.nextInt(companyNames.length)];
        this.consumption = String.valueOf(rand.nextInt(100) + 20); 
        this.address = addresses[rand.nextInt(addresses.length)];
        return true;
    }


    public void displayBill() {
        String waterBillMessage = String.format("Gas Bill Details\n\n" +
        "Bill ID: %s\n" +
        "Bill Price: $%.2f\n" +
        "Company Name: %s\n" +
        "Consumption: %s units\n" +
        "Meter Type: %s"+
        "Address: %s", getBillID(), getBillPrice(), companyName, consumption,meterType, address);
       
        System.out.println(waterBillMessage);
    }
    public void pay(double amonut,String billID){
        //fake part;
    }
}
