package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_2620;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent128;
import su.catlean.client.services.client.ServiceComponent39;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.mixins.accessors.InteractionManagerAccessor;

public class BreakEspModule extends Module {

    public static final BreakEspModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl externalSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 primarySetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 secondarySetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 textSetting;
    private static float factorValue;
    private static float factorValue2;
    private static final CopyOnWriteArrayList copyOnWriteArrayList;

    private BreakEspModule() {
        super("break-esp", SubCategoriesKt.getEspCategory());
    }

    private boolean getExternal() {
        return (Boolean) externalSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private BreakEspMode getMode() {
        return (BreakEspMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private Color getPrimary() {
        return (Color) primarySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private Color getSecondary() {
        return (Color) secondarySetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private Color getText() {
        return (Color) textSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (var19 == null) {
        }
        if (var19 == null) {
        }
        Iterable var20 = (Iterable) copyOnWriteArrayList;
        int var21 = 0;
        if (var20 instanceof Collection) {
            if (var19 == null && var19 == null) {
                if ((Collection) var20.isEmpty()) {
                }
            }
        }
        Iterator iterator = var20.iterator();
        if (iterator.hasNext()) {
            Object var23 = iterator.next();
            ServiceComponent128 var24 = (ServiceComponent128) var23;
            int var25 = 0;
        } else {
        }
        int var15 = 6;
        float var16 = 0.0F;
        float var17 = 0.0F;
        BlockPos blockPos = (class_2620) arg0.getPacket().method_11277();
        copyOnWriteArrayList.add(new ServiceComponent128(blockPos));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        copyOnWriteArrayList.removeIf(this::checkCondition);
        factorValue2 = factorValue;
        factorValue = (InteractionManagerAccessor) SharedKt.getInteractionManager().getCurBlockDamageMP();
    }

    public void onRender3DEvent(Render3DEvent e) {
        if (var15 == null) {
        }
        if (var15 == null) {
            if (SharedKt.getMc().field_1765 != null && SharedKt.getMc().field_1765 instanceof class_3965) {
            }
            BlockPos blockPos = (class_3965) SharedKt.getMc().field_1765.method_17777();
            if (var15 == null) {
            }
            if (SharedKt.getInteractionManager().method_2923() && !(SharedKt.getWorld().method_22347(blockPos))) {
                this.executeAction(blockPos, RangesKt.coerceIn(PolygonShaderComponent.INSTANCE.computeValue(factorValue2, factorValue, PolygonShaderComponent.INSTANCE.computeValue()), 0.0F, 1.0F));
            }
        }
        blockPos = (Iterable) copyOnWriteArrayList;
        int var17 = 0;
        Iterator iterator = blockPos.iterator();
        if (iterator.hasNext()) {
            Object var19 = iterator.next();
            ServiceComponent128 var20 = (ServiceComponent128) var19;
            int var21 = 0;
            INSTANCE.executeAction(var20.getMinecraftObject(), RangesKt.coerceIn(PolygonShaderComponent.INSTANCE.computeValue(var20.getNumericValue2(), var20.getNumericValue(), PolygonShaderComponent.INSTANCE.computeValue()), 0.0F, 1.0F));
        }
    }

    private void executeAction(BlockPos arg0, float arg1) {
        Box var25 = this.resolveMinecraftObject(arg0, arg1);
        TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor(this.getPrimary(), this.getSecondary(), arg1));
        TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor(PolygonShaderComponent.INSTANCE.resolveColor(this.getPrimary(), this.getSecondary(), arg1), 1.0F));
        TextShaderComponent2.executeAction(((arg1 * 100)), var25.method_1005(), this.getText(), 0.0F, 0.0F);
    }

    private Box resolveMinecraftObject(BlockPos arg0, float arg1) {
        float var9 = (1.0F - arg1);
        Box var8 = new Box(arg0).method_1002().method_989((var9 / 2.0F), (var9 / 2.0F), (var9 / 2.0F));
        var8 = new Box(arg0).method_1002(arg1, arg1, arg1).method_989((arg1 / 2.0F), (arg1 / 2.0F), (arg1 / 2.0F));
        var8 = new Box(arg0).method_35578((arg0.method_10264() + arg1));
        var8 = new Box(arg0).method_35578((arg0.method_10264() + (1.0F - arg1)));
        return new NoWhenBranchMatchedException();
    }

    private static boolean checkCondition(ServiceComponent128 arg0) {
        return arg0.checkCondition();
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var32 = new KProperty[5];
        INSTANCE = new BreakEspModule();
        externalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "external");
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", BreakEspMode.SHRINK);
        primarySetting = VisibleRenderHelper.registerSetting(INSTANCE, "primary", new Color(255, 255, 255, 100));
        secondarySetting = VisibleRenderHelper.registerSetting(INSTANCE, "secondary", new Color(255, 255, 255, 100));
        textSetting = VisibleRenderHelper.registerSetting(INSTANCE, "text", new Color(255, 255, 255, 255));
        copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

}
