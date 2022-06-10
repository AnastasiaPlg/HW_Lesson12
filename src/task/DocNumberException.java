package task;

public class DocNumberException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong document number!";
    }

    @Override
    public String toString() {
        return "DocNumberException: " + getMessage();
    }

    public static String controlDocNumber(String number) {
        StringBuilder sb = new StringBuilder();
        String line1;
        String line2;
        String line3;
        if (number.length() != 15) {
            line1 = "Wrong length! ";
            sb.append(line1);
        }
        if (!(number.startsWith("docnum") || number.startsWith("contract"))) {
            line2 = "Document numbers must starts with \"docnum\" or \"contract\"! ";
            sb.append(line2);
        }
        if (!number.matches("[a-zA-Z0-9]+")) {
            line3 = "Document numbers must be composed of letters and numbers! ";
            sb.append(line3);
        }
        return sb.toString();
    }
}
