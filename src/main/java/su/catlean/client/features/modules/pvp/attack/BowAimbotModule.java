package su.catlean.client.features.modules.pvp.attack;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1676;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent92;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.player.PlayerEntityHelper2;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class BowAimbotModule extends Module {

    public static final BowAimbotModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl silentSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 predictSetting;
    private static final RangeVisibleSettingPropertyImpl predictTicksSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreNakedSetting;
    private static final VisibleVisibleSettingPropertyImpl ignoreCreativeSetting;

    private BowAimbotModule() {
        super("bow-aimbot", SubCategoriesKt.getAttackCategory());
    }

    private boolean getSilent() {
        return (Boolean) silentSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSilent(boolean value) {
        silentSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private BowAimbotPredictMode getPredict() {
        return (BowAimbotPredictMode) predictSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setPredict(BowAimbotPredictMode value) {
        predictSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private int getPredictTicks() {
        return (Number) predictTicksSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setPredictTicks(int value) {
        predictTicksSetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private boolean getIgnoreNaked() {
        return (Boolean) ignoreNakedSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setIgnoreNaked(boolean value) {
        ignoreNakedSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getIgnoreCreative() {
        return (Boolean) ignoreCreativeSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setIgnoreCreative(boolean value) {
        ignoreCreativeSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    private void onSendPacket(SendPacket arg0) {
        System.out.println(arg0.getPacket().getClass().getSimpleName());
    }

    private void onReceivePacket(ReceivePacket arg0) {
        System.out.println(arg0.getPacket().getClass().getSimpleName());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var23 != null || EntityPacketHelper.INSTANCE.findTarget(256.0F, AutoCrystalTargetSortMode.FOV, this.getIgnoreNaked(), this.getIgnoreCreative()) == null) {
            return;
        }
        PlayerEntity player = EntityPacketHelper.INSTANCE.findTarget(256.0F, AutoCrystalTargetSortMode.FOV, this.getIgnoreNaked(), this.getIgnoreCreative());
        NoWhenBranchMatchedException var25 = new NoWhenBranchMatchedException();
        var25 = var25.method_1031(0.0D, 0.9D, 0.0D);
        SequenceServiceComponent.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent());
    }

    public void executeAction(Item item, float yaw) {
        double var20 = SharedKt.getPlayer().getX();
        double var22 = (SharedKt.getPlayer().getY() + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()));
        double var24 = SharedKt.getPlayer().getZ();
        float var26 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6004, SharedKt.getPlayer().method_36455());
        double var27 = (Math.sin(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((var26 / 180.0F) * 3.1415927F)));
        double var29 = Math.sin(((var26 / 180.0F) * 3.141593F));
        double var31 = (Math.cos(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((var26 / 180.0F) * 3.1415927F)));
        float var33 = (PolygonShaderComponent.INSTANCE.computeValue(Math.max(0.0F, (SharedKt.getPlayer().method_6048() - 1.0F)), SharedKt.getPlayer().method_6048()) / 20.0F);
        var33 = (((var33 * var33) + (var33 * 2.0F)) / 3.0F);
        if (var19 == null) {
            if (var33 <= 1.0F) {
                if (var19 == null) {
                    if (var33 == 0.0F) {
                    }
                } else {
                }
                if (0) {
                }
            }
            var33 = 1.0F;
        }
        float var34 = class_3532.method_15355((((var27 * var27) + (var29 * var29)) + (var31 * var31)));
        var27 = (var27 / var34);
        var29 = (var29 / var34);
        var31 = (var31 / var34);
        float var35 = (var33 * 2.0F);
        var27 = (var27 * var35);
        var29 = (var29 * var35);
        var31 = (var31 * var35);
        var27 = (var27 + SharedKt.getPlayer().method_18798().field_1352);
        var29 = (var29 + SharedKt.getPlayer().method_18798().field_1351);
        var31 = (var31 + SharedKt.getPlayer().method_18798().field_1350);
        int var37 = 0;
        if (var37 < 300) {
            Vec3d vec = new Vec3d();
            var20 = (var20 + var27);
            var22 = (var22 + var29);
            var24 = (var24 + var31);
            var27 = (var27 * 0.99D);
            var29 = (var29 * 0.99D);
            var31 = (var31 * 0.99D);
            var29 = (var29 - 0.05D);
            Vec3d vec2 = new Vec3d();
            class_3965 var39 = SharedKt.getWorld().method_17742(new class_3959(vec, vec2, class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
            if (0L >= 0) {
                if (var39.method_17783() == class_240.field_1332) {
                }
                if (var19 != null) {
                }
                Iterable var41 = SharedKt.getWorld().method_18112();
                int var42 = 0;
                Object var43 = var41;
                Collection var44 = (Collection) new ArrayList();
                int var45 = 0;
                Iterator iterator = var43.iterator();
                if (iterator.hasNext()) {
                    Object var47 = iterator.next();
                    Entity entity = var47;
                    int var49 = 0;
                    if (0L > 0) {
                        if (var19 == null) {
                        }
                    }
                    if (0L >= 0) {
                        if (var19 == null) {
                        }
                    }
                    if (var19 == null) {
                        if (entity.method_5707(vec2) >= 25.0D) {
                            if (var19 == null) {
                                if (!(entity instanceof class_1676) && !(Intrinsics.areEqual(entity, SharedKt.getPlayer())) && entity.method_5707(vec) < 25.0D) {
                                }
                            }
                        }
                    } else {
                    }
                    var44.add();
                }
                List positions = var44;
                var41 = 0;
                var42 = (Iterable) positions;
                var43 = 0;
                var44 = var42.iterator();
                if (var44.hasNext()) {
                    var45 = var44.next();
                    iterator = var45;
                    var47 = 0;
                    entity = iterator.method_5829();
                    var49 = entity.method_992(vec, vec2);
                    int var50 = 0;
                    if (0L >= 0) {
                        if (var19 == null) {
                            if (0L >= 0) {
                                if (var19 == null) {
                                    if (var19 == null) {
                                        if (var49.isPresent() && !(var41)) {
                                            TextShaderComponent2.checkCondition(vec, (Vec3d) var49.get(), NewThemeRenderHelper.INSTANCE.resolveColor());
                                        }
                                        var41 = 1;
                                    }
                                }
                            }
                        }
                        if (0L > 0) {
                        }
                    }
                    if (0L >= 0) {
                        if (var19 == null) {
                            if (var41) {
                            }
                        }
                    }
                    if (0L >= 0) {
                        if (var19 == null) {
                            if (var19 != null && var22 > -65.0D) {
                            }
                        }
                        if (var19 == null) {
                            if (var27 == 0.0D) {
                            }
                        } else {
                        }
                        if (0L >= 0) {
                        }
                        if (var19 == null) {
                            if (var29 == 0.0D) {
                            }
                        } else {
                        }
                        if (0L > 0) {
                        }
                        if (var19 == null) {
                            if (var31 == 0.0D) {
                            }
                        } else {
                        }
                        if (0 && 0 && 0) {
                        }
                    }
                }
            }
        }
    }

    private static boolean isActive() {
        return INSTANCE.getPredict() == BowAimbotPredictMode.CUSTOM;
    }

    static {
        KProperty[] var30 = new KProperty[5];
        INSTANCE = new BowAimbotModule();
        silentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "silent");
        predictSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict", BowAimbotPredictMode.SMART);
        predictTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict-ticks", 1, new IntRange(1, 20), null, this::isActive);
        ignoreNakedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-naked");
        ignoreCreativeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-creative");
    }

}
