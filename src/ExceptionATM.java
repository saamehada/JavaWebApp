public class ExceptionATM extends RuntimeException {
    public ExceptionATM(String message) {
        super(message);
    }
}

class InvalidAmount extends ExceptionATM {
    public InvalidAmount(String message) {
        super(message);
    }
}

class mistakeCurrency extends ExceptionATM {
    public mistakeCurrency(String message) {
        super(message);
    }
}

