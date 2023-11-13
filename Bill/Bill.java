package Bill;

public class Bill {
    private BillData data;
    
    public void createBill(String subsciption ){
        data.setBillData(subsciption);
    }
    public void printBill(){
        data.displayBill();
    }
    public double getBillPrice(){
        return data.getBillPrice();
    }
}
