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
        return (Boolean) bpsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void render(DrawContext context) {
        long var4 = ((0L ^ 86294490406460L) >>> 48);
        long var5 = (((0L ^ 86294490406460L) << 16) >>> 32);
        long var6 = (((0L ^ 86294490406460L) << 48) >>> 48);
        long var7 = (0L ^ 116853176505585L);
        long var9 = ((0L ^ 28405077213452L) >>> 48);
        long var10 = (((0L ^ 28405077213452L) << 16) >>> 48);
        long var11 = (((0L ^ 28405077213452L) << 32) >>> 32);
        long var12 = (0L ^ 95236895637490L);
        if (var14) {
            if (!(this.getBps())) {
                String var16 = "%.1f";
                Object[] var17 = new Object[1];
                var17[0] = Double.valueOf((Math.rint((this.computeValue() * ServiceComponent98.INSTANCE.getNumericValue())) * 0.1D));
            } else {
            }
            var16 = "%.1f";
            var17 = new Object[1];
            var17[0] = Double.valueOf((Math.rint((this.computeValue() * ServiceComponent98.INSTANCE.getNumericValue())) * 0.1D));
        }
        String var15 = (String.format(Arrays.copyOf()) + " b/s");
        this.render(context);
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
        KProperty[] var23 = new KProperty[1];
        INSTANCE = new SpeedWidgetCheckRenderHelperImpl();
        bpsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "bps");
    }

}
