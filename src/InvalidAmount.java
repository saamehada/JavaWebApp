public class InvalidAmount extends RuntimeException {

    public InvalidAmount(String message) {
        super(message);
    }

    public InvalidAmount() {
        super("Неудачное списание");
    }

}
