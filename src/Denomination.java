public enum Denomination {
    FIVE_THOUSAND(5000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10);

    private final int keyEnum;

    Denomination(int keyEnum) {
        this.keyEnum = keyEnum;
    }

    public int getKeyEnum() {
        return keyEnum;
    }
}
