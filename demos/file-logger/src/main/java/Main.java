import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        FileLogger.getFileLogger().log("This is our message!");
        methodOne();
    }

    public static void methodOne() {
        methodTwo();
    }

    public static void methodTwo() {
        methodThree();
    }

    public static void methodThree() {
        logException(new SQLException("Three methods deep"));
    }

    public static void logMessage(String msg) {
        FileLogger.getFileLogger().log(msg);
    }

    public static void logException(Exception e) {
        FileLogger.getFileLogger().log(e);
    }
}
