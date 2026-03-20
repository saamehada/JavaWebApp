import java.util.HashMap;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 * <p>
 * Другие валюты и номиналы должны легко добавляться разработчиками в будущем.
 * Многопоточные сценарии могут быть добавлены позже (например резервирование).
 */


public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> cash = new HashMap<>();
        cash.put(5000, 2);
        cash.put(1000, 2);
        cash.put(500, 2);
        cash.put(100, 2);
        cash.put(50, 0);

        ATM atm = new ATM(cash, Enum.EURO);
        atm.withdraw(2300);

        System.out.println("валюта: " + atm.getCurrency());
    }
}

