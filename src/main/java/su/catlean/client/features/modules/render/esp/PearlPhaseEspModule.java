package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_265;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class PearlPhaseEspModule extends Module {

    public static final PearlPhaseEspModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 rangeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 safeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 unsafeSetting;

    private PearlPhaseEspModule() {
        super("pearl-phase-esp", SubCategoriesKt.getEspCategory());
    }

    private float getRange() {
        return ((Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getSafe() {
        return ((Color) safeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private Color getUnsafe() {
        return ((Color) unsafeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (!(SharedKt.getPlayer().isOnGround()) || !(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, 0.21D, 0.0D))).method_45474())) {
            return;
        }
        Map map = this.resolveMap();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            TextShaderComponent2.checkCondition(((Box) entry.getKey()), ((Color) entry.getValue()));
            TextShaderComponent2.checkCondition(((Box) entry.getKey()), PolygonShaderComponent.INSTANCE.resolveColor(((Color) entry.getValue()), 1.0F));
        }
    }

    private Map resolveMap() {
        Map map = ((Map) new LinkedHashMap());
        Iterator iterator = SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(this.getRange(), 0.0D, this.getRange()).method_35575((SharedKt.getPlayer().getY() + 0.21D)).method_35578((SharedKt.getPlayer().getY() + 0.21D))).iterator();
        while (iterator.hasNext()) {
            class_265 class265 = ((class_265) iterator.next());
            if (__UNDEF_KEY__) {
                if (SharedKt.getWorld().getBlockState(BlockPos.ofFloored(class265.method_1107().method_1005()).down()).method_45474()) {
                } else {
                }
                class265.method_1107().method_35578(class265.method_1107().field_1322).put(this.getUnsafe(), this.getSafe());
            }
        }
        return map;
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new PearlPhaseEspModule();
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 1.0F, RangesKt.rangeTo(0.01F, 3.0F));
        safeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safe", new Color(255, 255, 255, 60));
        unsafeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "unsafe", new Color(255, 100, 100, 60));
    }

}
