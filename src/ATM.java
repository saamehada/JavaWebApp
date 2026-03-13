import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ATM {
    public static void widthdraw(int count) {
        HashMap<Integer, Integer> cash = new LinkedHashMap<>();
        cash.put(5000, 4);
        cash.put(1000, 6);
        cash.put(500, 1);
        cash.put(100, 2);
        cash.put(50, 0);

        int k;
        if (count % 50 == 0) {
            for (Map.Entry<Integer, Integer> entry : cash.entrySet()) {
                int keyFromCash = entry.getKey();
                int valueFromCash = entry.getValue();

                if (count >= keyFromCash && valueFromCash != 0) {
                    k = count/keyFromCash;
                    count = count - k * keyFromCash;
                    valueFromCash = k;
                    System.out.println(valueFromCash + " шт по " + keyFromCash);
                }
            }

        } else System.out.println("Выберите верную сумму");
    }
}
