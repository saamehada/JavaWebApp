import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {


    private final Map<Integer, Integer> cashForTask;
    private final Enum money;

    public ATM(Map<Integer, Integer> cash, Enum money) {
        cashForTask = new HashMap<>(cash);
        this.money = money;
    }

    public Map<Integer, Integer> withdraw(int amount) {

        if (amount <= 0) {
            throw new InvalidAmount("Сумма должна быть положительной. Измените сумму");
        }

        int sumOfKeys = cashForTask.keySet().stream().mapToInt(Integer::intValue).sum();
        if (amount > sumOfKeys) {
            throw new InvalidAmount("Не хватает купюр для выдачи");
        }

        if (amount % 50 != 0) {
            throw new InvalidAmount("Введите корректную сумму");
        }

        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> availableNominals = cashForTask.keySet().stream().sorted().toList().reversed();

        for (Integer nominal : availableNominals) {
            int availableCount = cashForTask.get(nominal);
            int k = Math.min(availableCount, amount / nominal);
            amount -= nominal * k;

            if (k > 0) {
                result.put(nominal, k);
                cashForTask.put(nominal, availableCount - k);
                System.out.println(k + " шт по " + nominal);
            }
        }

        if (amount != 0) {
            for (Map.Entry<Integer, Integer> resultEntry : result.entrySet()) {
                Integer availableCount = cashForTask.get(resultEntry.getKey());
                cashForTask.put(resultEntry.getKey(), availableCount + resultEntry.getValue());
            }
            throw new InvalidAmount();
        }

        return result;
    }

    public Enum getCurrency() {
        return money;
    }
}
