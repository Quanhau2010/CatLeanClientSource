package su.catlean.client.features.modules.render.cosmetic;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.EntityEntityHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class DamageParticlesModule extends Module {

    public static final DamageParticlesModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl9 color1Setting;
    private static final DefaultValueVisibleSettingPropertyImpl9 color2Setting;
    private static final RangeVisibleSettingPropertyImpl2 sizeSetting;
    private static final RangeVisibleSettingPropertyImpl ticksSetting;
    private static final HashMap hashMap;
    private static final ArrayList arrayList;
    private static final DecimalFormat decimalFormat;

    private DamageParticlesModule() {
        super("damage-particles", SubCategoriesKt.getCosmeticCategory());
    }

    private Color getColor1() {
        return ((Color) color1Setting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getColor2() {
        return ((Color) color2Setting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private float getSize() {
        return ((Number) sizeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private int getTicks() {
        return ((Number) ticksSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void updateValue() {
        arrayList.clear();
        hashMap.clear();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (!(entity instanceof LivingEntity)) {
            }
            if (((Float) hashMap.getOrDefault(Integer.valueOf(((LivingEntity) entity).method_5628()), Float.valueOf(((LivingEntity) entity).method_6063()))) != null) {
            } else {
            }
            float factor = 20.0F;
            float factor2 = (((LivingEntity) entity).method_6032() + ((LivingEntity) entity).method_6067());
            if (factor == factor2) {
            }
            arrayList.add(new EntityEntityHelper(entity, (factor2 - factor), (((LivingEntity) entity).getX() + RangeServiceComponent.a(-0.5D, 0.5D, false)), (((LivingEntity) entity).getY() + (((LivingEntity) entity).method_5829().method_17940() / 2.0F)), (((LivingEntity) entity).getZ() + RangeServiceComponent.a(-0.5D, 0.5D, false))));
        }
        arrayList.removeIf(this::checkCondition);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterable iterable = ((Iterable) arrayList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            EntityEntityHelper entityEntityHelper = ((EntityEntityHelper) element);
            int index = (INSTANCE.getTicks() / 2.0F);
            if (entityEntityHelper.getNumericValue() < index) {
            } else {
            }
            float factor = (1.0F - ((entityEntityHelper.getNumericValue() - index) / index));
            if (entityEntityHelper.getNumericValue() > 0.0F) {
            } else {
            }
            int index2 = 24;
            FontRenderHelper fontRenderHelper = SFMServiceComponent.resolveFontRenderHelper8();
            int index3 = 1;
            float factor2 = 0.0F;
            float factor3 = 0.0F;
            Color color = INSTANCE.getColor1().resolveColor(INSTANCE.getColor2(), factor);
            PolygonShaderComponent polygonShaderComponent = PolygonShaderComponent.INSTANCE;
            Vec3d vec = new Vec3d(entityEntityHelper.getNumericValue(), entityEntityHelper.getNumericValue2(), entityEntityHelper.getNumericValue3());
            TextShaderComponent2.executeAction(decimalFormat.format(Float.valueOf(entityEntityHelper.getNumericValue())), vec, polygonShaderComponent, color, factor3, factor2, index3, fontRenderHelper, index2);
        }
    }

    private static boolean checkCondition(EntityEntityHelper arg0) {
        int index = arg0.getNumericValue();
        arg0.updateValue((index + 1));
        if (__UNDEF_KEY__ != null) {
            if (index >= INSTANCE.getTicks()) {
            } else {
            }
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new DamageParticlesModule();
        color1Setting = VisibleRenderHelper.registerSetting(INSTANCE, "heal-color", Color.GREEN);
        color2Setting = VisibleRenderHelper.registerSetting(INSTANCE, "damage-color", Color.RED);
        sizeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "size", 0.5F, RangesKt.rangeTo(0.1F, 3.0F));
        ticksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ticks", 35, new IntRange(5, 60));
        hashMap = new HashMap();
        arrayList = new ArrayList();
        decimalFormat = new DecimalFormat("#.#");
    }

}
