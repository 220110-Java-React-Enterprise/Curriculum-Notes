import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String ...args) throws Exception {
        Double amountOwed = 0.99;
        List<Coin> change =  AutoCashRegister.dispenseChange(amountOwed);

        for (Coin c : change) {
            System.out.println(c.name);
        }

        Map<String, String> myMap = new HashMap<>();
        myMap.put("kplummer", "password");
        myMap.put("tobi", "password");

        System.out.println("Filling map with ten million pieces of junk");
        for (int i = 0; i < 10000000; i++) {
            myMap.put(Double.toString(Math.random() * 10000), "junk");
        }

        System.out.println("Map filled...");
        System.out.println("Kyle's Password: " + myMap.get("kplummer"));

        String sql = "SELECT * FROM accounts WHERE username = ?";



    }
}
