package su.catlean.client.features.modules.render.cosmetic;

import java.awt.Color;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_2761;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import org.joml.Vector4f;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.ClearColorEvent;
import su.catlean.api.event.events.world.ApplyFogEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class WorldRendererModule extends Module {

    public static final WorldRendererModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl fogModifySetting;
    private static final RangeVisibleSettingPropertyImpl fogStartSetting;
    private static final RangeVisibleSettingPropertyImpl fogEndSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 fogColorSetting;
    private static final VisibleVisibleSettingPropertyImpl timeChangerSetting;
    private static final VisibleVisibleSettingPropertyImpl realTimeSetting;
    private static final RangeVisibleSettingPropertyImpl ctimeValSetting;

    private WorldRendererModule() {
        super("world-renderer", SubCategoriesKt.getCosmeticCategory());
    }

    private boolean getFogModify() {
        return ((Boolean) fogModifySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getFogStart() {
        return ((Number) fogStartSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getFogEnd() {
        return ((Number) fogEndSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private Color getFogColor() {
        return ((Color) fogColorSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getTimeChanger() {
        return ((Boolean) timeChangerSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getRealTime() {
        return ((Boolean) realTimeSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private int getCtimeVal() {
        return ((Number) ctimeValSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void setCtimeVal(int value) {
        ctimeValSetting.setValue(this, DELEGATED_PROPERTIES[6], Integer.valueOf(value));
    }

    public void updateValue() {
        timestampValue = SharedKt.getWorld().method_8532();
    }

    public void updateValue2() {
        SharedKt.getWorld().method_29089(timestampValue, timestampValue, true);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        Packet packet = arg0.getPacket();
        timestampValue = ((class_2761) packet).comp_3219();
        arg0.cancel();
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (this.getTimeChanger()) {
            if (this.getRealTime()) {
                this.setCtimeVal(this.computeValue());
            }
            SharedKt.getWorld().method_29089(this.getCtimeVal(), this.getCtimeVal(), false);
        }
    }

    private void onApplyFogEvent(ApplyFogEvent arg0) {
        arg0.setColorVec(new Vector4f(PolygonShaderComponent.INSTANCE.computeValue(this.getFogColor()), PolygonShaderComponent.INSTANCE.computeValue(this.getFogColor()), PolygonShaderComponent.INSTANCE.computeValue(this.getFogColor()), PolygonShaderComponent.INSTANCE.computeValue2(this.getFogColor())));
        arg0.setEStart(this.getFogStart());
        arg0.setEEnd(this.getFogEnd());
        arg0.setRStart(this.getFogStart());
        arg0.setREnd(this.getFogEnd());
        arg0.cancel();
    }

    private void onClearColorEvent(ClearColorEvent arg0) {
        if (!(this.getFogColor().getAlpha()) || !(this.getFogModify())) {
            return;
        }
        arg0.cancel();
    }

    public int computeValue() {
        int index = ZonedDateTime.now().toLocalTime().toSecondOfDay();
        int index2 = ((index / 86400.0D) * 24000.0D);
        if (__UNDEF_KEY__ == null) {
        }
        return 24000;
    }

    private static boolean isActive() {
        return INSTANCE.getFogModify();
    }

    private static boolean isActive2() {
        return INSTANCE.getFogModify();
    }

    private static boolean isActive3() {
        return INSTANCE.getFogModify();
    }

    private static boolean isActive4() {
        return INSTANCE.getTimeChanger();
    }

    private static boolean isActive5() {
        return INSTANCE.getTimeChanger();
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new WorldRendererModule();
        fogModifySetting = VisibleRenderHelper.registerSetting(INSTANCE, "fog-modify", true);
        fogStartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fog-start", 0, new IntRange(0, 256), null, this::isActive);
        fogEndSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fog-end", 64, new IntRange(10, 256), null, this::isActive2);
        fogColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fog-color", new Color(11075839), null, this::isActive3);
        timeChangerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time-changer", false);
        realTimeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "real-time", false, null, this::isActive4);
        ctimeValSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time", 21000, new IntRange(0, 23000), null, this::isActive5);
    }

}
