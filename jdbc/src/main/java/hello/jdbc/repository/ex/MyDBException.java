package hello.jdbc.repository.ex;

public class MyDBException extends RuntimeException {

    public MyDBException() {
    }

    public MyDBException(String message) {
        super(message);
    }

    public MyDBException(String message, Throwable cause) { //감싸기 때문에 원인들 가져와야 함
        super(message, cause);
    }

    public MyDBException(Throwable cause) {
        super(cause);
    }
}
