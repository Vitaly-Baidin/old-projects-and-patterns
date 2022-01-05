public class CustomerStorageException extends IllegalArgumentException {

    private String problem;

    public CustomerStorageException(String message, String problem) {
        super(message);
        this.problem = problem;
    }
}
