package Provider;

public interface Provider {

    public abstract boolean verify(String phoneNumber) ;
    public abstract double getBalance(String phoneNumber);
    public abstract void setBalance(double balance,String phoneNumber);
    public abstract void addBalance(double balance,String phoneNumber);
    public abstract void deduceBalance(double balance,String phoneNumber);

}
