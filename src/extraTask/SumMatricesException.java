package extraTask;

public class SumMatricesException extends Exception {
    @Override
    public String getMessage() {
        return "These matrices can't be summed because of different size";
    }

    @Override
    public String toString() {
        return "extraTask.SumMatricesException: " + getMessage();
    }
}
