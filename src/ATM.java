import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private final Map<Integer, Integer> cashForTask;

    public ATM (Map<Integer, Integer> cash) {
        cashForTask = new HashMap<>(cash);
    }

    public Map<Denomination, Integer> withdraw(int amount, Enum currency) {
        Map<Denomination, Integer> availableNotes = currency.getNotes();
        Map<Denomination, Integer> result = new HashMap<>();

        if (amount <= 0) {
            throw new InvalidAmount("Неверная сумма. Ваша сумма отрицательна или равна нулю");
        }

        if (currency == null) {
            throw new mistakeCurrency("Валюта не выбрана или выбрана неверно");
        }


        List<Denomination> denominations = Arrays.asList(Denomination.values());
        denominations.sort((a, b) -> b.getKeyEnum() - a.getKeyEnum());


        for (Denomination nominal : denominations) {
            int availableCount = availableNotes.getOrDefault(nominal, 0);
            int k = Math.min(availableCount, amount / nominal.getKeyEnum());
            amount -= nominal.getKeyEnum() * k;

            if (k > 0) {
                result.put(nominal, k);
                cashForTask.put(nominal.getKeyEnum(), cashForTask.getOrDefault(nominal.getKeyEnum(), 0) - k);
                System.out.println(k + " шт по " + nominal + " валюта: " + currency);
            }
        }

        if (amount != 0) {
            for (Map.Entry<Denomination, Integer> resultEntry : result.entrySet()) {
                Integer availableCount = cashForTask.get(resultEntry.getKey().getKeyEnum());
                cashForTask.put(resultEntry.getKey().getKeyEnum(), availableCount + resultEntry.getValue());
            }
            throw new ExceptionATM("Неверное списание");
        }

        return result;
    }
}
