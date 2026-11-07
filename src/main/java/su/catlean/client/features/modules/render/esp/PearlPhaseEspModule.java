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
        return (Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private Color getSafe() {
        return (Color) safeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private Color getUnsafe() {
        return (Color) unsafeSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (!(SharedKt.getPlayer().isOnGround()) || !(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()).method_1031(0.0D, 0.21D, 0.0D))).method_45474())) {
            return;
        }
        Map var22 = this.resolveMap();
        Iterator iterator = var22.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry var24 = (Entry) iterator.next();
            TextShaderComponent2.checkCondition((Box) var24.getKey(), (Color) var24.getValue());
            TextShaderComponent2.checkCondition((Box) var24.getKey(), PolygonShaderComponent.INSTANCE.resolveColor((Color) var24.getValue(), 1.0F));
        }
    }

    private Map resolveMap() {
        Map var18 = (Map) new LinkedHashMap();
        Iterator iterator = SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_1009(this.getRange(), 0.0D, this.getRange()).method_35575((SharedKt.getPlayer().getY() + 0.21D)).method_35578((SharedKt.getPlayer().getY() + 0.21D))).iterator();
        if (iterator.hasNext()) {
            class_265 var20 = (class_265) iterator.next();
            if (var17) {
                if (SharedKt.getWorld().getBlockState(BlockPos.ofFloored(var20.method_1107().method_1005()).down()).method_45474()) {
                } else {
                }
                var20.method_1107().method_35578(var20.method_1107().field_1322).put(this.getUnsafe(), this.getSafe());
            }
        }
        return var18;
    }

    static {
        KProperty[] var29 = new KProperty[3];
        INSTANCE = new PearlPhaseEspModule();
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 1.0F, RangesKt.rangeTo(0.01F, 3.0F), null, null, -3982960260070506472L);
        safeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "safe", new Color(-8422532185734512385L, 5485597045802664191L, 5485597045802664191L, -5060994796508676036L), null, null, 2352768743852998668L);
        unsafeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "unsafe", new Color(5485597045802664191L, 7632062915402530916L, -1914391830066102172L, -7735313005780402116L), null, null, -5163306204604137460L);
    }

}
