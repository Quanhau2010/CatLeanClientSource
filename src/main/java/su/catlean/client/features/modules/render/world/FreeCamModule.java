package su.catlean.client.features.modules.render.world;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_10209;
import net.minecraft.class_239;
import net.minecraft.class_2851;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_3695;
import net.minecraft.class_3928;
import net.minecraft.class_8671;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.FreecamStateEvent;
import su.catlean.api.event.events.player.KeyboardInputEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.UpdateCrosshairTarget;
import su.catlean.api.event.events.render.SetupTerrainEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.mixins.accessors.KeyMappingAccessor;

public class FreeCamModule extends Module {

    public static final FreeCamModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final RangeVisibleSettingPropertyImpl2 hspeedSetting;
    private static final VisibleVisibleSettingPropertyImpl freezeSetting;
    private static float factorValue;
    private static float factorValue2;
    private static float factorValue3;
    private static float factorValue4;
    private static Vec3d vec3d;
    private static Vec3d vec3d2;
    private static float factorValue5;
    private static float factorValue6;
    private static float factorValue7;
    private static Vec3d vec3d3;
    private static MoveFixServiceComponent moveFixServiceComponent;

    private FreeCamModule() {
        super("free-cam", SubCategoriesKt.getWorldRenderCategory());
    }

    private float getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private float getHspeed() {
        return (Number) hspeedSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getFreeze() {
        return (Boolean) freezeSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = (arg0 ^ 62698557940930L);
        long var7 = (arg0 ^ 67464996320865L);
        if (SharedKt.getMc().world == null || SharedKt.getMc().player == null) {
            return;
        }
        SharedKt.getMc().field_1730 = 0;
        factorValue2 = SharedKt.getPlayer().method_36455();
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue4 = factorValue2;
        factorValue3 = factorValue;
        vec3d = new Vec3d(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376())), SharedKt.getPlayer().getZ());
        vec3d2 = new Vec3d(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ());
        vec3d3 = SharedKt.getPlayer().method_18798();
        moveFixServiceComponent = new MoveFixServiceComponent(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        long var5 = (arg0 ^ 60471910827463L);
        long var7 = (arg0 ^ 65044256163258L);
        long var9 = (arg0 ^ 29647348875563L);
        if (!(this.checkCondition())) {
            return;
        }
        if (arg0 >= 0L) {
            SharedKt.getMc().field_1730 = 1;
            SharedKt.getPlayer().method_18799(vec3d3);
        }
        SharedKt.getPlayer().method_64578(moveFixServiceComponent.getNumericValue(), 0, moveFixServiceComponent.getNumericValue2(), 0);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (SharedKt.getMc().player == null) {
            }
            this.updateValue2();
            return;
        }
        if (!(SharedKt.getMc().currentScreen instanceof class_3928)) {
            if (SharedKt.getMc().currentScreen instanceof class_8671) {
            }
            this.updateValue2();
        }
        factorValue3 = factorValue;
        factorValue4 = factorValue2;
        factorValue = SharedKt.getPlayer().method_36454();
        factorValue2 = SharedKt.getPlayer().method_36455();
        double[] var21 = EventPacketHelper2.process(this.getSpeed(), 0, factorValue5, factorValue6, 0.0F);
        vec3d2 = vec3d;
        vec3d = vec3d.method_1031(var21[0], factorValue7, var21[1]);
        SequenceServiceComponent.INSTANCE.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(SharedKt.getMc().field_1765.method_17784()), 0);
    }

    private void onSetupTerrainEvent(SetupTerrainEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (var8 != null || SharedKt.getMc().player == null) {
                return;
            }
        }
        arg0.cancel();
    }

    private void onFreecamStateEvent(FreecamStateEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (var19 != null || SharedKt.getMc().player == null) {
                return;
            }
        }
        arg0.cancel();
        arg0.setX(this.computeValue());
        arg0.setY(this.computeValue2());
        arg0.setZ(this.computeValue());
        arg0.setYaw(this.computeValue());
        arg0.setPitch(this.computeValue2());
    }

    private void onUpdateCrosshairTarget(UpdateCrosshairTarget arg0) {
        if (SharedKt.getMc().world != null) {
            if (SharedKt.getMc().player == null) {
            }
            this.updateValue2();
            return;
        }
        class_10209.method_64146().method_15407();
        arg0.cancel();
        SharedKt.getMc().field_1765 = EventPacketHelper2.INSTANCE.resolveMinecraftObject(this.computeValue(), this.computeValue2(), this.computeValue(), this.computeValue2(), this.computeValue());
    }

    private void onInputEvent(InputEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (SharedKt.getMc().player == null) {
            }
            this.updateValue2();
            return;
        }
        if (arg0.getKey() == -1) {
            return;
        }
        boolean var13 = (KeyMappingAccessor) SharedKt.getMc().options.field_1894.getKey().method_1444() == arg0.getKey();
        boolean var14 = (KeyMappingAccessor) SharedKt.getMc().options.field_1881.getKey().method_1444() == arg0.getKey();
        boolean var15 = (KeyMappingAccessor) SharedKt.getMc().options.field_1913.getKey().method_1444() == arg0.getKey();
        boolean var16 = (KeyMappingAccessor) SharedKt.getMc().options.field_1849.getKey().method_1444() == arg0.getKey();
        boolean var17 = (KeyMappingAccessor) SharedKt.getMc().options.field_1903.getKey().method_1444() == arg0.getKey();
        boolean var18 = (KeyMappingAccessor) SharedKt.getMc().options.field_1832.getKey().method_1444() == arg0.getKey();
        if (arg0.getAction() != Action.Press) {
            if (arg0.getAction() == Action.Hold) {
            }
            if (var13) {
                factorValue5 = 1.0F;
            }
            if (var14) {
                factorValue5 = -1.0F;
            }
            if (var15) {
                factorValue6 = 1.0F;
            }
            if (var16) {
                factorValue6 = -1.0F;
            }
            if (var17) {
                factorValue7 = this.getHspeed();
            }
            if (var18) {
                factorValue7 = this.getHspeed();
            }
        }
        if (arg0.getAction() == Action.Release) {
            if (var13) {
                factorValue5 = 0.0F;
            }
            if (var14) {
                factorValue5 = 0.0F;
            }
            if (var15) {
                factorValue6 = 0.0F;
            }
            if (var16) {
                factorValue6 = 0.0F;
            }
            if (var17) {
                factorValue7 = 0.0F;
            }
            if (var18) {
                factorValue7 = 0.0F;
            }
        }
        EventPacketHelper2.INSTANCE.updateValue5();
        if (!(var13) && !(var14) && !(var15) && !(var16) && !(var17)) {
        }
        arg0.cancel();
    }

    public void onKeyboardInputEvent(KeyboardInputEvent e) {
        e.cancel();
    }

    private void onMoveEvent(MoveEvent arg0) {
        if (SharedKt.getMc().world != null) {
            if (var10 != null || SharedKt.getMc().player == null) {
                return;
            }
        }
        arg0.setX(0.0D);
        arg0.setY(0.0D);
        arg0.setZ(0.0D);
        arg0.cancel();
    }

    private void onSendPacket(SendPacket arg0) {
        if (!(arg0.getPacket() instanceof PlayerMoveC2SPacket)) {
        }
        arg0.cancel();
    }

    private float computeValue() {
        return PolygonShaderComponent.INSTANCE.computeValue(factorValue3, factorValue, TextShaderComponent2.INSTANCE.computeValue());
    }

    private float computeValue2() {
        return PolygonShaderComponent.INSTANCE.computeValue(factorValue4, factorValue2, TextShaderComponent2.INSTANCE.computeValue());
    }

    private double computeValue() {
        return PolygonShaderComponent.INSTANCE.computeValue(vec3d2.field_1352, vec3d.field_1352, TextShaderComponent2.INSTANCE.computeValue());
    }

    private double computeValue2() {
        return PolygonShaderComponent.INSTANCE.computeValue(vec3d2.field_1351, vec3d.field_1351, TextShaderComponent2.INSTANCE.computeValue());
    }

    private double computeValue() {
        return PolygonShaderComponent.INSTANCE.computeValue(vec3d2.field_1350, vec3d.field_1350, TextShaderComponent2.INSTANCE.computeValue());
    }

    static {
        KProperty[] var31 = new KProperty[3];
        INSTANCE = new FreeCamModule();
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "h-speed", 1.0F, RangesKt.rangeTo(0.1F, 3.0F));
        hspeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "v-speed", 0.42F, RangesKt.rangeTo(0.1F, 3.0F));
        freezeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "freeze");
        vec3d = Vec3d.ZERO;
        vec3d2 = Vec3d.ZERO;
        vec3d3 = Vec3d.ZERO;
        moveFixServiceComponent = new MoveFixServiceComponent(0.0F, 0.0F);
    }

}
