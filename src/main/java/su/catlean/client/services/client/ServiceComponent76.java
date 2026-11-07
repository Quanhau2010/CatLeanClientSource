package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.List;

public class ServiceComponent76 {

    public static final ServiceComponent76 INSTANCE;
    private static final List itemList;
    private static boolean enabledFlag;
    private static int countValue;
    private static String[] textValueArray;

    private ServiceComponent76() {
    }

    public List getList() {
        return itemList;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public void updateValue() {
        BlockServiceComponent.executeAction(AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE, ((DraftIdServiceComponent) itemList.get(countValue)).getObject());
        countValue = ((countValue + 1) % itemList.size());
    }

    static {
        INSTANCE = new ServiceComponent76();
        itemList = new ArrayList();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
