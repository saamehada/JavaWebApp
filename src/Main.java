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


        Map<CurrencyType, Map<Denomination, Integer>> currencies = new HashMap<>();

        Map<Denomination, Integer> dollar = new HashMap<>();
        dollar.put(Denomination.ONE_THOUSAND, 10);
        dollar.put(Denomination.FIVE_HUNDRED, 20);
        dollar.put(Denomination.ONE_HUNDRED, 100);
        dollar.put(Denomination.FIFTY, 100);
        dollar.put(Denomination.TWENTY, 100);
        dollar.put(Denomination.TEN, 100);
        currencies.put(CurrencyType.DOLLAR, dollar);

        Map<Denomination, Integer> euro = new HashMap<>();
        euro.put(Denomination.ONE_THOUSAND, 15);
        euro.put(Denomination.FIVE_HUNDRED, 25);
        euro.put(Denomination.ONE_HUNDRED, 105);
        euro.put(Denomination.FIFTY, 300);
        euro.put(Denomination.TWENTY, 100);
        euro.put(Denomination.TEN, 200);
        currencies.put(CurrencyType.EURO, euro);

        Map<Denomination, Integer> ruble = new HashMap<>();
        ruble.put(Denomination.FIVE_THOUSAND, 300);
        ruble.put(Denomination.ONE_THOUSAND, 200);
        ruble.put(Denomination.FIVE_HUNDRED, 100);
        ruble.put(Denomination.ONE_HUNDRED, 3000);
        ruble.put(Denomination.FIFTY, 20000);
        currencies.put(CurrencyType.RUBLE, ruble);

        ATM atm = new ATM(currencies);
        atm.withdraw(amount, CurrencyType.RUBLE);
    }
}

