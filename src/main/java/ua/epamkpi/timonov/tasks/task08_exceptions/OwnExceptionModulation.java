package ua.epamkpi.timonov.tasks.task08_exceptions;

public class OwnExceptionModulation {

    public void handleException() {
        try {
            generateException();
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Exception was caught");
        }
    }

    private void generateException() throws MyOwnException {
        throw new MyOwnException("I'm throwing MyOwnException!");
    }

    public void generateExceptionInOneMethod(String string) {
        try {
            if (string == null) {
                throw new MyOwnException("Null is founded");
            }
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Block finally works");
        }
    }
}
