public class GenericPrinter<T> {
    private T data;

    public GenericPrinter(T data) {
        this.data = data;
    }

    public void printData() {
        System.out.println("Generic Data: " + data);
    }
}