package su.catlean.client.services.render;

import java.util.Arrays;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.services.client.ServiceComponent98;
import su.catlean.client.services.network.EventPacketHelper2;

public class SpeedWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final SpeedWidgetCheckRenderHelperImpl INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl bpsSetting;

    private SpeedWidgetCheckRenderHelperImpl() {
        super("speed-widget");
    }

    private boolean getBps() {
        return ((Boolean) bpsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void render(DrawContext context) {
        if (__UNDEF_KEY__) {
            if (!(this.getBps())) {
                String text = "%.1f";
                Object[] items = new Object[1];
                items[0] = Double.valueOf((Math.rint((this.computeValue() * ServiceComponent98.INSTANCE.getNumericValue())) * 0.1D));
            } else {
                text = "%.1f";
                items = new Object[1];
                items[0] = Double.valueOf((Math.rint((this.computeValue() * ServiceComponent98.INSTANCE.getNumericValue())) * 0.1D));
            }
        }
        String text2 = (String.format(text, Arrays.copyOf(items, items)) + " b/s");
        this.render(context, text2);
    }

    private float computeValue() {
        if (SharedKt.getPlayer().isFallFlying()) {
        } else {
        }
        return (EventPacketHelper2.INSTANCE.getNumericValue() * 720.0F);
    }

    private float computeValue() {
        if (SharedKt.getPlayer().isFallFlying()) {
        } else {
        }
        return (EventPacketHelper2.INSTANCE.getNumericValue() * 200.0F);
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new SpeedWidgetCheckRenderHelperImpl();
        bpsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bps", false);
    }

}
