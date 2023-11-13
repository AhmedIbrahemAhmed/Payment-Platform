package Provider;
import java.util.HashMap;

public interface Provider {

    public abstract boolean verify(String phoneNumber,HashMap<String,Double> dummyAPIS) ;
    public abstract double getBalance(String phoneNumber,HashMap<String,Double> dummyAPIS);
    public abstract void setBalance(double balance,String phoneNumber,HashMap<String,Double> dummyAPIS);
    public abstract void addBalance(double balance,String phoneNumber,HashMap<String,Double> dummyAPIS);
    public abstract void deduceBalance(double balance,String phoneNumber,HashMap<String,Double> dummyAPIS);

}
