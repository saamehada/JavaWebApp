import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private final Map<CurrencyType, Map<Denomination, Integer>> currencies;

    public ATM(Map<CurrencyType, Map<Denomination, Integer>> currencies) {
        this.currencies = currencies;
    }

    public void withdraw(int amount, CurrencyType currency) {
        System.out.println("Изначальное кол-во купюр в банкомате: ");
        System.out.println(currencies);
        System.out.println();

        if (amount <= 0) {
            throw new InvalidAmount("Неверная сумма. Ваша сумма отрицательна или равна нулю");
        }

        if (currency == null) {
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
