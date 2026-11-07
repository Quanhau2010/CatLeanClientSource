package su.catlean.client.features.modules.utility.player;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.ServiceComponent8;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ActionRecorderModule extends Module {

    public static final ActionRecorderModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl recordButtonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl buttonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl resetSetting;
    private static final VisibleVisibleSettingPropertyImpl rewindOnDoneSetting;
    private static final Map lookupMap;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static int countValue;
    private static boolean enabledFlag3;

    private ActionRecorderModule() {
        super("action-recorder", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private ActionServiceComponent2 getRecordButton() {
        return ((ActionServiceComponent2) recordButtonSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private ActionServiceComponent2 getButton() {
        return ((ActionServiceComponent2) buttonSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private ActionServiceComponent2 getReset() {
        return ((ActionServiceComponent2) resetSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getRewindOnDone() {
        return ((Boolean) rewindOnDoneSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void onTickEvent(TickEvent arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        if (enabledFlag) {
            lookupMap.put(Integer.valueOf(countValue), new ServiceComponent8(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455(), SharedKt.getMc().options.field_1894.method_1434(), SharedKt.getMc().options.field_1881.method_1434(), SharedKt.getMc().options.field_1913.method_1434(), SharedKt.getMc().options.field_1849.method_1434(), SharedKt.getMc().options.field_1832.method_1434(), SharedKt.getMc().options.field_1903.method_1434(), SharedKt.getMc().options.field_1904.method_1434(), SharedKt.getMc().options.field_1886.method_1434()));
            countValue = (__UNDEF_KEY__ + 1);
        }
        if (countValue >= lookupMap.size()) {
            enabledFlag3 = 1;
            countValue = lookupMap.size();
        }
        if (countValue < 0) {
            enabledFlag3 = 0;
            countValue = 0;
        }
        this.updateValue();
        SharedKt.getPlayer().method_64578(this.getNumericValue(), false, this.getNumericValue2(), false);
        SharedKt.getMc().options.field_1894.method_23481(this.isActive());
        SharedKt.getMc().options.field_1881.method_23481(this.isActive2());
        SharedKt.getMc().options.field_1913.method_23481(this.isActive3());
        SharedKt.getMc().options.field_1849.method_23481(this.isActive4());
        SharedKt.getMc().options.field_1832.method_23481(this.isActive5());
        SharedKt.getMc().options.field_1903.method_23481(this.isActive6());
        SharedKt.getMc().options.field_1904.method_23481(this.isActive7());
        SharedKt.getMc().options.field_1886.method_23481(this.isActive8());
        this.updateValue();
    }

    private void updateValue() {
        if (this.getRewindOnDone()) {
            if (enabledFlag3) {
                int index = countValue;
                countValue = (index + -1);
            } else {
                index = countValue;
                countValue = (index + 1);
            }
        } else {
            index = countValue;
            countValue = (index + 1);
            countValue = 0;
            enabledFlag3 = 0;
        }
    }

    private static Unit getUnit() {
        enabledFlag = !(enabledFlag);
        if (enabledFlag) {
            countValue = 0;
        }
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return !(enabledFlag2);
    }

    private static Unit getUnit2() {
        enabledFlag2 = !(enabledFlag2);
        if (enabledFlag2) {
            countValue = 0;
        }
        return Unit.INSTANCE;
    }

    private static boolean isActive2() {
        return !(enabledFlag);
    }

    private static Unit getUnit3() {
        lookupMap.clear();
        enabledFlag = 0;
        enabledFlag2 = 0;
        countValue = 0;
        enabledFlag3 = 0;
        return Unit.INSTANCE;
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new ActionRecorderModule();
        recordButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "record-/-stop", this::getUnit, null, this::isActive);
        buttonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "play-/-stop", this::getUnit2, null, this::isActive2);
        resetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reset", this::getUnit3);
        rewindOnDoneSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rewind-on-done", false);
        lookupMap = ((Map) new LinkedHashMap());
    }

}
