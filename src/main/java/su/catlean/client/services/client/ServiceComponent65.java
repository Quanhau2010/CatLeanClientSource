package su.catlean.client.services.client;

import java.io.File;

public class ServiceComponent65 {

    private static final File file;
    private static final File file2;
    private static final File file3;
    private static final File[] fileArray;
    private static String[] textValueArray;

    public static File getFile() {
        return file;
    }

    public static File getFile2() {
        return file2;
    }

    public static File getFile3() {
        return file3;
    }

    public static File[] process() {
        return fileArray;
    }

    static {
        file = new File((System.getProperty("user.home") + "/.ctl"));
        file2 = new File((file + "/inventories"));
        file3 = new File((file + "/stashes"));
        File[] items = new File[3];
        items[0] = file;
        items[1] = file2;
        items[2] = file3;
        fileArray = items;
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
