package su.catlean.client.services.render;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class CoordWidgetRenderHelper extends CheckRenderHelper {

    public static final CoordWidgetRenderHelper INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl secondaryCoordsSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyNetherSetting;

    private CoordWidgetRenderHelper() {
        super("coord-widget");
    }

    private boolean getSecondaryCoords() {
        return (Boolean) secondaryCoordsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSecondaryCoords(boolean value) {
        secondaryCoordsSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private boolean getOnlyNether() {
        return (Boolean) onlyNetherSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setOnlyNether(boolean value) {
        onlyNetherSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 116853176505585L);
        long var6 = (0L ^ 57814021407262L);
        long var8 = (0L ^ 53664238460761L);
        long var10 = (0L ^ 105037015370739L);
        long var12 = (0L ^ 109580710346244L);
        float var16 = 8.0F;
        if (0L > 0L && var14) {
        }
        if (this.getOnlyNether()) {
            if (this.getSecondaryCoords() && 0.125F) {
            }
        } else {
        }
        String var18 = (0 + SharedKt.getPlayer().getX() + SharedKt.getPlayer().getY() + "  " + SharedKt.getPlayer().getZ());
        String var19 = (1 + (SharedKt.getPlayer().getX() * var16) + "  " + (SharedKt.getPlayer().getZ() * var16) + "]");
        if (0L > 0L) {
            if (SharedKt.getPlayer().field_6012 < 100) {
            }
            var18 = ("wait " + ((100 - SharedKt.getPlayer().field_6012) / 20) + " seconds");
            var19 = "";
        }
        StringBuilder var21 = new StringBuilder();
        Object var22 = var21;
        int var23 = 0;
        if (0L >= 0L) {
            var22.append();
            var22.append((var19));
        }
        String var20 = var21.toString();
        this.render(context);
    }

    static {
        KProperty[] var26 = new KProperty[2];
        INSTANCE = new CoordWidgetRenderHelper();
        secondaryCoordsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "secondary");
        onlyNetherSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-nether");
    }

}
