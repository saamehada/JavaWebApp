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
        Map<Denomination, Integer> money = new HashMap<>();
        money.put(Denomination.ONE_THOUSAND, 12);
        money.put(Denomination.FIVE_HUNDRED, 1);
        money.put(Denomination.ONE_HUNDRED, 2);

        int amount = 0;
        for (Map.Entry<Denomination, Integer> entry : money.entrySet()) {
            amount += entry.getKey().getKeyEnum() * entry.getValue();
        }

        ATM atm = new ATM(Curr.RUBLE);
        atm.withdraw(amount, Curr.RUBLE);
    }
}

