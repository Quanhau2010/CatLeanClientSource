package su.catlean.client.services.client;

import java.util.List;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;

public class StringServiceComponent {

    public static RangeVisibleSettingPropertyImpl resolveRangeVisibleSettingPropertyImpl(RangeVisibleSettingPropertyImpl receiver, int i, String string) {
        MinValueServiceComponent.INSTANCE.getList().add(new OverrideNameServiceComponent(receiver.getString(), (Number) Integer.valueOf(i), string));
        return receiver;
    }

    public static RangeVisibleSettingPropertyImpl2 resolveRangeVisibleSettingPropertyImpl2(RangeVisibleSettingPropertyImpl2 receiver, float i, String string) {
        MinValueServiceComponent.INSTANCE.getList().add(new OverrideNameServiceComponent(receiver.getString(), (Number) Float.valueOf(i), string));
        return receiver;
    }

}
