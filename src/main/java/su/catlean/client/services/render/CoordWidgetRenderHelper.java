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
        return ((Boolean) secondaryCoordsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSecondaryCoords(boolean value) {
        secondaryCoordsSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private boolean getOnlyNether() {
        return ((Boolean) onlyNetherSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setOnlyNether(boolean value) {
        onlyNetherSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    public void render(DrawContext context) {
        float factor = 8.0F;
        if (this.getOnlyNether()) {
            if (this.getSecondaryCoords() && 0.125F) {
            } else {
            }
        }
        String text = (0 + SharedKt.getPlayer().getX() + SharedKt.getPlayer().getY() + "  " + SharedKt.getPlayer().getZ());
        String text2 = (1 + (SharedKt.getPlayer().getX() * factor) + "  " + (SharedKt.getPlayer().getZ() * factor) + "]");
        if (SharedKt.getPlayer().field_6012 < 100) {
            text = ("wait " + ((100 - SharedKt.getPlayer().field_6012) / 20) + " seconds");
            text2 = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text);
        stringBuilder.append((text2));
        String text3 = stringBuilder.toString();
        this.render(context, text3);
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new CoordWidgetRenderHelper();
        secondaryCoordsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "secondary", true);
        onlyNetherSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-nether", true);
    }

}
