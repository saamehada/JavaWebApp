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
        test1(6750);
    }

    public static void test1(int count) {
        int[] array = {5000, 1000, 500, 100, 50};
        int k;

        if (count % 50 == 0) {
            for (int i = 0; i < array.length; i++) {
                if (count >= array[i]) {
                    k = count / array[i];
                    count = count - k * array[i];
                    System.out.println(k + " шт по " + array[i]);
                }
            }
        } else {
            System.out.println("error");
        }
    }
}
