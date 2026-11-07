package su.catlean.client.services.client;

import su.catlean.client.features.modules.Module;

public class ServiceComponent40 {

    private final String textValue;
    private Object object;
    private static Module[] moduleArray;

    public ServiceComponent40(String name) {
        this.textValue = name;
    }

    public String getString() {
        return this.textValue;
    }

    public Object getObject() {
        return this.object;
    }

    public void updateValue(Object value) {
        this.object = value;
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
