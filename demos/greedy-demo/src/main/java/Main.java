import java.util.List;

public class Main {
    public static void main(String ...args) throws Exception {
        Double amountOwed = 0.99;
        List<Coin> change =  AutoCashRegister.dispenseChange(amountOwed);

        for (Coin c : change) {
            System.out.println(c.name);
        }
    }
}
