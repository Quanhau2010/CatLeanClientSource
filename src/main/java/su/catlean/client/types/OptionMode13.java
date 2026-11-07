package su.catlean.client.types;

import java.util.Map;

public enum OptionMode13 {

    INSTANCE,
    INSTANCE2,
    INSTANCE3;

    private final String textValue;
    private final Map lookupMap;

    public String getString() {
        return this.textValue;
    }

    public Map getMap() {
        return this.lookupMap;
    }

}
