package exception;

public class NotPromotableTierException extends RuntimeException {
    public NotPromotableTierException() {
        super("The tier is not promotable.");
    }
}
