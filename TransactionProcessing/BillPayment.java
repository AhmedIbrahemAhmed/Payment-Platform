package TransactionProcessing;

import Bill.*;

public class BillPayment implements Recipient {
    private Bill bill;
    @Override
    public void pay(double amount, String ID) {
        if(ID.equals(bill.getBillID())){
            
        bill.pay(amount, ID);
        
        }
        else System.out.println("worng Bill ID");
    }
    public boolean check(String ID){
        String []parts=ID.split(" ");
        if(parts[1].equals("GasBill")){
            this.bill =new GasBill();
        }
        else if(parts[1].equals("WaterBill")){
            this.bill =new WaterBill();
        }
        else if(parts[1].equals("ElectricityBill")){
            this.bill =new ElectricityBill();
        }
        if(bill.setBillData(parts[0])){
        bill.displayBill();
        return true;
        }
        else return false;
    }
    public void setBill(String billtype) {
        if(billtype.equals("Gasbill")){
            this.bill =new GasBill();
        }
        else if(billtype.equals("WaterBill")){
            this.bill =new WaterBill();
        }
        else if(billtype.equals("ElectricityBill")){
            this.bill =new ElectricityBill();
        }

    }
}
