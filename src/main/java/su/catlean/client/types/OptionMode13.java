package su.catlean.client.types;

import java.util.Map;

public enum OptionMode13 {

    private final String textValue;
    private final Map lookupMap;
    public static final OptionMode13 INSTANCE;
    public static final OptionMode13 INSTANCE2;
    public static final OptionMode13 INSTANCE3;

    OptionMode13(String arg0, int arg1, String arg2, Map arg3) {
        super(arg0, arg1);
        this.textValue = arg2;
        this.lookupMap = arg3;
    }

    public String getString() {
        return this.textValue;
    }

    public Map getMap() {
        return this.lookupMap;
    }

}
