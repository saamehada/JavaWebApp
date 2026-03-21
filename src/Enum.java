import java.util.HashMap;
import java.util.Map;

public enum Enum {
    EURO,
    DOLLAR,
    RUBLE;

    public Map<Denomination, Integer> getNotes() {
        Map<Denomination, Integer> notes = new HashMap<>();

        switch (this) {
            case EURO:
                notes.put(Denomination.FIFTY, 3);
                notes.put(Denomination.TWENTY, 2);
                notes.put(Denomination.TEN, 1);
                break;
            case DOLLAR:
                notes.put(Denomination.FIFTY, 5);
                notes.put(Denomination.TWENTY, 0);
                notes.put(Denomination.TEN, 3);
                break;
            case RUBLE:
                notes.put(Denomination.FIVE_THOUSAND, 3);
                notes.put(Denomination.ONE_THOUSAND, 2);
                notes.put(Denomination.FIVE_HUNDRED, 1);
                notes.put(Denomination.ONE_HUNDRED, 3);
                notes.put(Denomination.FIFTY, 2);
                break;
        }
        return notes;
    }
}