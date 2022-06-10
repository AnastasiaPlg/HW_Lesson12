package extraTask;

public class ParametersException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong parameters were added in method!";
    }

    @Override
    public String toString() {
        return "extraTask.SumMatricesException: " + getMessage();
    }
}
