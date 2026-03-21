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
        Map<Denomination, Integer> notes = Enum.EURO.getNotes();

        Map <Integer, Integer> cash = new HashMap<>();
        for (Map.Entry<Denomination, Integer> entry: notes.entrySet()) {
            cash.put(entry.getKey().getKeyEnum(), entry.getValue());
        }

        ATM atm = new ATM(cash);
        atm.withdraw(70, Enum.DOLLAR);
    }
}

