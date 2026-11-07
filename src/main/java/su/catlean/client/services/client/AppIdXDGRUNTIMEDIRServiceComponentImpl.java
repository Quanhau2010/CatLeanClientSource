package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import su.catlean.api.setting.PropertySettingProperty;
import su.catlean.client.services.client.config.models.DetailsRecord;
import su.catlean.client.services.client.config.models.LabelRecord;
import su.catlean.client.services.client.config.models.LargeImageRecord;
import su.catlean.client.services.client.config.models.StartRecord;

public class AppIdXDGRUNTIMEDIRServiceComponentImpl extends XDGRUNTIMEDIRServiceComponent {

    public static final AppIdXDGRUNTIMEDIRServiceComponentImpl INSTANCE;
    private static final ReadWriteProperty appIdSetting;
    private static final ReadWriteProperty detailsSetting;
    private static final ReadWriteProperty stateSetting;
    private static final ReadWriteProperty largeImageSetting;
    private static final ReadWriteProperty smallImageSetting;
    private static final ReadWriteProperty button1Setting;
    private static final ReadWriteProperty button2Setting;
    private static String[] textValueArray;

    private AppIdXDGRUNTIMEDIRServiceComponentImpl() {
        super();
    }

    public Long getAppId() {
        return ((Long) appIdSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void setAppId(Long value) {
        appIdSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    public String getDetails() {
        return ((String) detailsSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public void setDetails(String value) {
        detailsSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    public String getState() {
        return ((String) stateSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    public void setState(String value) {
        stateSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    public Pair getLargeImage() {
        return ((Pair) largeImageSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public void setLargeImage(Pair value) {
        largeImageSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    public Pair getSmallImage() {
        return ((Pair) smallImageSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    public void setSmallImage(Pair value) {
        smallImageSetting.setValue(this, DELEGATED_PROPERTIES[4], value);
    }

    public Pair getButton1() {
        return ((Pair) button1Setting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    public void setButton1(Pair value) {
        button1Setting.setValue(this, DELEGATED_PROPERTIES[5], value);
    }

    public Pair getButton2() {
        return ((Pair) button2Setting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    public void setButton2(Pair value) {
        button2Setting.setValue(this, DELEGATED_PROPERTIES[6], value);
    }

    public DetailsRecord resolveDetailsRecord() {
        List list = new ArrayList();
        if (this.getButton1() != null) {
            Pair pair = this.getButton1();
            int index = 0;
            list.add(new LabelRecord(((String) pair.getFirst()), ((String) pair.getSecond())));
        } else {
        }
        if (this.getButton2() != null) {
            pair = this.getButton2();
            index = 0;
            list.add(new LabelRecord(((String) pair.getFirst()), ((String) pair.getSecond())));
        } else {
        }
        String text = this.getDetails();
        String text2 = this.getState();
        if (this.getLargeImage() == null) {
            if (this.getSmallImage() != null) {
                if (this.getLargeImage() != null) {
                } else {
                }
                if (this.getLargeImage() != null) {
                } else {
                }
                if (this.getSmallImage() != null) {
                } else {
                }
                if (this.getSmallImage() != null) {
                } else {
                }
            } else {
            }
        }
        index = new StartRecord(this.getNumericValue());
        return null;
    }

    private ReadWriteProperty resolveReadWriteProperty(boolean arg0, Object arg1) {
        return ((ReadWriteProperty) new PropertySettingProperty(arg1, arg0));
    }

    public void executeAction() {
        ServiceComponent76.INSTANCE.updateValue(0);
        ServiceComponent76.INSTANCE.updateValue(true);
    }

    public void executeAction2() {
        ServiceComponent76.INSTANCE.updateValue(false);
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new AppIdXDGRUNTIMEDIRServiceComponentImpl();
        appIdSetting = F(INSTANCE, true);
        detailsSetting = F(INSTANCE, false);
        stateSetting = F(INSTANCE, false);
        largeImageSetting = F(INSTANCE, false);
        smallImageSetting = F(INSTANCE, false);
        button1Setting = F(INSTANCE, false);
        button2Setting = F(INSTANCE, false);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
