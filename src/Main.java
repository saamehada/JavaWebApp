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
        test1(6100);
        test1(6750);
        test1(350);
    }

    public static int test1(int count) {
        int[] array = {5000, 1000, 500, 100, 50};

        if (count % 50 == 0) {
            for (int i = 0; i < array.length; i++) {
                if (count - array[i] > 0) {
                    count -= array[i];
                    if (count < 450) {
                        while (count >= 100) {
                            count -= array[3];
                            if (count == 50) {
                                count -= array[4];
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("error");
        }
        return count;
    }
}