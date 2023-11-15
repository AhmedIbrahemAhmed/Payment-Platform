package Bill;

public abstract class Bill {
    private String billID;
    private double billPrice;

    public double getBillPrice() {
        return billPrice;
    }

    public String getBillID() {
        return billID;
    }
    public void setBillID(String billID){
        this.billID=billID;
    }
    public void setBillPrice(double billPrice){
        this.billPrice=billPrice;
    }
    
    public abstract void pay(double amonut,String billID); 

    public abstract void displayBill();

    public abstract boolean setBillData(String subscriptionid);

}
