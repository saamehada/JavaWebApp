import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private final Map<String, Map<Denomination, Integer>> currencies = new HashMap<>();


    public ATM() {
        Map<Denomination, Integer> dollar = new HashMap<>();
        dollar.put(Denomination.ONE_THOUSAND, 10);
        dollar.put(Denomination.FIVE_HUNDRED, 20);
        dollar.put(Denomination.ONE_HUNDRED, 100);
        dollar.put(Denomination.FIFTY, 100);
        dollar.put(Denomination.TWENTY, 100);
        dollar.put(Denomination.TEN, 100);
        currencies.put("DOLLAR", dollar);


        Map<Denomination, Integer> euro = new HashMap<>();
        dollar.put(Denomination.ONE_THOUSAND, 15);
        dollar.put(Denomination.FIVE_HUNDRED, 25);
        dollar.put(Denomination.ONE_HUNDRED, 105);
        euro.put(Denomination.FIFTY, 300);
        euro.put(Denomination.TWENTY, 100);
        euro.put(Denomination.TEN, 200);
        currencies.put("EURO", euro);


        Map<Denomination, Integer> ruble = new HashMap<>();
        ruble.put(Denomination.FIVE_THOUSAND, 300);
        ruble.put(Denomination.ONE_THOUSAND, 200);
        ruble.put(Denomination.FIVE_HUNDRED, 100);
        ruble.put(Denomination.ONE_HUNDRED, 3000);
        ruble.put(Denomination.FIFTY, 20000);
        currencies.put("RUBLE", ruble);
    }

    public void withdraw(int amount, String currency) {
        System.out.println("Изначальное кол-во купюр в банкомате: ");
        System.out.println(currencies);
        System.out.println();

        if (amount <= 0) {
            throw new InvalidAmount("Неверная сумма. Ваша сумма отрицательна или равна нулю");
        }

        if (currency == null || currency.isEmpty()) {
            throw new mistakeCurrency("Валюта не выбрана или выбрана неверно");
        }

        Map<Denomination, Integer> availableNotes = currencies.get(currency);
        Map<Denomination, Integer> result = new HashMap<>();

        List<Map.Entry<Denomination, Integer>> denominations = new ArrayList<>(availableNotes.entrySet());
        denominations.sort((a, b) -> b.getKey().getKeyEnum() - a.getKey().getKeyEnum());

        for (Map.Entry<Denomination, Integer> entry : denominations) {
            Denomination nominal = entry.getKey();
            int availableCount = entry.getValue();
            int k = Math.min(availableCount, amount / nominal.getKeyEnum());
            amount -= nominal.getKeyEnum() * k;

            if (k > 0) {
                result.put(nominal, k);
                availableNotes.put(nominal, availableCount - k);

                System.out.println("Какие купюры и их кол-во мы выдали: ");
                System.out.println(result);
                System.out.println();
                System.out.println("Остаток в банкомате: ");
                System.out.println(currencies);
                System.out.println();

            }
        }

        if (amount != 0) {
            for (Map.Entry<Denomination, Integer> resultEntry : result.entrySet()) {
                Denomination nominal = resultEntry.getKey();
                int currentCount = availableNotes.get(nominal);
                availableNotes.put(nominal, currentCount + resultEntry.getValue());
            }
            throw new ExceptionATM("Недостаточное кол-во купюр в банкомате");
        }

    }
}
