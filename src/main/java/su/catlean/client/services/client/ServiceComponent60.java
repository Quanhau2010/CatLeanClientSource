package su.catlean.client.services.client;

public class ServiceComponent60 {

    private static int[] countValueArray;

    private ServiceComponent60() {
    }

    public ReaderServiceComponent2 getReaderServiceComponent2() {
        return new ReaderServiceComponent2();
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
