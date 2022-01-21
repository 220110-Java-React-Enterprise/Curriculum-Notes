import java.util.ArrayList;
import java.util.List;

public class AutoCashRegister {
    public static List<Coin> dispenseChange(double changeAmtDbl) throws Exception {
        // Greedy algorithm:
        // a greedy algorithm is one which does the largest amount of work at every given opportunity
        // by does work, it reduces the problem. So we reduce the outstanding necessary steps by as much as possible.
        // This is basically the exact way we all intuitively give out change. You wouldn't start with pennies,
        // you start with quarters, because they represent the largest share of the outstanding change
        // you need to give.

        Integer changeAmt = new Double(changeAmtDbl * 100).intValue();

        List<Coin> denominations = new ArrayList<>();
        denominations.add(new Coin("quarter"));
        denominations.add(new Coin("dime"));
        denominations.add(new Coin("nickel"));
        denominations.add(new Coin("penny"));

        List<Coin> changeList = new ArrayList<>();

        while(changeAmt > 0) {
            for (Coin c : denominations) {
                if(c.value <= changeAmt) {
                    changeList.add(c);
                    changeAmt -= c.value;
                    break;
                }
            }
        }

        return changeList;

    }
}

class Coin {
    Integer value;
    String name;
    public Coin(String coin) throws Exception {
        name = coin;
        switch (coin) {
            case "quarter":
                value = 25;
                break;
            case "dime":
                value = 10;
                break;
            case "nickel":
                value = 05;
                break;
            case "penny":
                value = 01;
                break;
            default:
                throw new Exception("That's not an American coin...");
        }
    }
}
