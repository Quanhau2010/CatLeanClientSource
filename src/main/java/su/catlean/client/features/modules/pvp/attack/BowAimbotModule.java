package su.catlean.client.features.modules.pvp.attack;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
        return ((Boolean) silentSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSilent(boolean value) {
        silentSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private BowAimbotPredictMode getPredict() {
        return ((BowAimbotPredictMode) predictSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setPredict(BowAimbotPredictMode value) {
        predictSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private int getPredictTicks() {
        return ((Number) predictTicksSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setPredictTicks(int value) {
        predictTicksSetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private boolean getIgnoreNaked() {
        return ((Boolean) ignoreNakedSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setIgnoreNaked(boolean value) {
        ignoreNakedSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private boolean getIgnoreCreative() {
        return ((Boolean) ignoreCreativeSetting.getValue(this, DELEGATED_PROPERTIES[4]));
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
        if (EntityPacketHelper.INSTANCE.findTarget(256.0F, AutoCrystalTargetSortMode.FOV, this.getIgnoreNaked(), this.getIgnoreCreative()) == null) {
            EntityPacketHelper.INSTANCE.findTarget(256.0F, AutoCrystalTargetSortMode.FOV, this.getIgnoreNaked(), this.getIgnoreCreative());
            return;
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        noWhenBranchMatchedException = noWhenBranchMatchedException.method_1031(0.0D, 0.9D, 0.0D);
        SequenceServiceComponent.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(noWhenBranchMatchedException));
    }

    public void executeAction(Item item, float yaw) {
        double offset = SharedKt.getPlayer().getX();
        double offset2 = (SharedKt.getPlayer().getY() + SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()));
        double offset3 = SharedKt.getPlayer().getZ();
        float factor = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6004, SharedKt.getPlayer().method_36455());
        double offset4 = (Math.sin(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((factor / 180.0F) * 3.1415927F)));
        double offset5 = Math.sin(((factor / 180.0F) * 3.141593F));
        double offset6 = (Math.cos(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((factor / 180.0F) * 3.1415927F)));
        float factor2 = (PolygonShaderComponent.INSTANCE.computeValue(Math.max(0.0F, (SharedKt.getPlayer().method_6048() - 1.0F)), SharedKt.getPlayer().method_6048()) / 20.0F);
        factor2 = (((factor2 * factor2) + (factor2 * 2.0F)) / 3.0F);
        if (__UNDEF_KEY__ == null) {
            if (factor2 <= 1.0F) {
                if (__UNDEF_KEY__ == null) {
                    if (factor2 == 0.0F) {
                    } else {
                    }
                }
                if (0) {
                    factor2 = 1.0F;
                }
            }
        }
        float factor3 = class_3532.method_15355((((offset4 * offset4) + (offset5 * offset5)) + (offset6 * offset6)));
        offset4 = (offset4 / factor3);
        offset5 = (offset5 / factor3);
        offset6 = (offset6 / factor3);
        float factor4 = (factor2 * 2.0F);
        offset4 = (offset4 * factor4);
        offset5 = (offset5 * factor4);
        offset6 = (offset6 * factor4);
        offset4 = (offset4 + SharedKt.getPlayer().method_18798().field_1352);
        offset5 = (offset5 + SharedKt.getPlayer().method_18798().field_1351);
        offset6 = (offset6 + SharedKt.getPlayer().method_18798().field_1350);
        int index = 0;
        if (index < 300) {
            Vec3d vec = new Vec3d(offset, offset2, offset3);
            offset = (offset + offset4);
            offset2 = (offset2 + offset5);
            offset3 = (offset3 + offset6);
            offset4 = (offset4 * 0.99D);
            offset5 = (offset5 * 0.99D);
            offset6 = (offset6 * 0.99D);
            offset5 = (offset5 - 0.05D);
            Vec3d vec2 = new Vec3d(offset, offset2, offset3);
            class_3965 class3965 = SharedKt.getWorld().method_17742(new class_3959(vec, vec2, class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
            if (__UNDEF_KEY__ >= 0) {
                if (class3965.method_17783() == class_240.field_1332) {
                    if (__UNDEF_KEY__ != null) {
                        Iterable iterable = SharedKt.getWorld().method_18112();
                        int index2 = 0;
                        Iterable iterable2 = iterable;
                        Collection collection = ((Collection) new ArrayList());
                        int index3 = 0;
                        Iterator iterator = iterable2.iterator();
                        while (iterator.hasNext()) {
                            Object element = iterator.next();
                            Entity entity = element;
                            int index4 = 0;
                            if (__UNDEF_KEY__ > 0) {
                                if (__UNDEF_KEY__ == null) {
                                }
                            }
                            if (__UNDEF_KEY__ >= 0) {
                                if (__UNDEF_KEY__ == null) {
                                }
                            }
                            if (__UNDEF_KEY__ == null) {
                                if (entity.method_5707(vec2) >= 25.0D) {
                                    if (__UNDEF_KEY__ == null) {
                                        if (!(entity instanceof class_1676) && !(Intrinsics.areEqual(entity, SharedKt.getPlayer())) && entity.method_5707(vec) < 25.0D) {
                                        } else {
                                        }
                                    }
                                }
                            }
                            collection.add(element);
                        }
                        iterable = 0;
                        index2 = ((Iterable) collection);
                        iterable2 = 0;
                        collection = index2.iterator();
                        while (collection.hasNext()) {
                            index3 = collection.next();
                            iterator = index3;
                            element = 0;
                            entity = iterator.method_5829();
                            index4 = entity.method_992(vec, vec2);
                            if (__UNDEF_KEY__ >= 0) {
                                if (__UNDEF_KEY__ == null) {
                                    if (__UNDEF_KEY__ >= 0) {
                                        if (__UNDEF_KEY__ == null) {
                                            if (__UNDEF_KEY__ == null) {
                                                if (index4.isPresent() && !(iterable)) {
                                                    TextShaderComponent2.checkCondition(vec, ((Vec3d) index4.get()), NewThemeRenderHelper.INSTANCE.resolveColor(index), null, false);
                                                    iterable = 1;
                                                }
                                            }
                                            if (__UNDEF_KEY__ > 0) {
                                                if (__UNDEF_KEY__ >= 0) {
                                                    if (__UNDEF_KEY__ == null) {
                                                        if (iterable) {
                                                        }
                                                    }
                                                }
                                                if (__UNDEF_KEY__ >= 0) {
                                                    if (__UNDEF_KEY__ == null) {
                                                        if (__UNDEF_KEY__ != null && offset2 > -65.0D) {
                                                            if (__UNDEF_KEY__ == null) {
                                                                if (offset4 == 0.0D) {
                                                                } else {
                                                                }
                                                            }
                                                            if (__UNDEF_KEY__ >= 0) {
                                                            }
                                                            if (__UNDEF_KEY__ == null) {
                                                                if (offset5 == 0.0D) {
                                                                } else {
                                                                }
                                                            }
                                                            if (__UNDEF_KEY__ > 0) {
                                                            }
                                                            if (__UNDEF_KEY__ == null) {
                                                                if (offset6 == 0.0D) {
                                                                } else {
                                                                }
                                                            }
                                                            if (0 && 0 && 0) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
        KProperty[] items = new KProperty[5];
        INSTANCE = new BowAimbotModule();
        silentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "silent", true);
        predictSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict", BowAimbotPredictMode.SMART);
        predictTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "predict-ticks", 1, new IntRange(1, 20), null, this::isActive);
        ignoreNakedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-naked", true);
        ignoreCreativeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ignore-creative", true);
    }

}
