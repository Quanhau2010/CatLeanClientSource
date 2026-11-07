package su.catlean.client.features.modules.movement.basic;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2440;
import net.minecraft.class_2537;
import net.minecraft.class_2538;
import net.minecraft.class_2542;
import net.minecraft.class_2769;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.CollisionEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AvoidModule extends Module {

    public static final AvoidModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl unloadedSetting;
    private static final VisibleVisibleSettingPropertyImpl voidAirSetting;
    private static final VisibleVisibleSettingPropertyImpl cactusSetting;
    private static final VisibleVisibleSettingPropertyImpl fireSetting;
    private static final VisibleVisibleSettingPropertyImpl berryBushSetting;
    private static final VisibleVisibleSettingPropertyImpl powderSnowSetting;
    private static final VisibleVisibleSettingPropertyImpl lavaSetting;
    private static final VisibleVisibleSettingPropertyImpl trapStringSetting;
    private static final VisibleVisibleSettingPropertyImpl plateSetting;
    private static final VisibleVisibleSettingPropertyImpl turtleEggsSetting;

    private AvoidModule() {
        super("avoid", SubCategoriesKt.getBasicMovementCategory());
    }

    private boolean getUnloaded() {
        return ((Boolean) unloadedSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getVoidAir() {
        return ((Boolean) voidAirSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getCactus() {
        return ((Boolean) cactusSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getFire() {
        return ((Boolean) fireSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getBerryBush() {
        return ((Boolean) berryBushSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getPowderSnow() {
        return ((Boolean) powderSnowSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getLava() {
        return ((Boolean) lavaSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getTrapString() {
        return ((Boolean) trapStringSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getPlate() {
        return ((Boolean) plateSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getTurtleEggs() {
        return ((Boolean) turtleEggsSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private void onCollisionEvent(CollisionEvent arg0) {
        BlockState state = arg0.getState();
        boolean flag = INSTANCE.getUnloaded();
        if (arg0.getPos().method_10264() < SharedKt.getWorld().method_31607()) {
        } else {
            boolean flag2 = INSTANCE.getVoidAir();
        }
        if (Intrinsics.areEqual(state.getBlock(), Blocks.field_10029)) {
        } else {
            boolean flag3 = INSTANCE.getCactus();
        }
        if (!(Intrinsics.areEqual(state.getBlock(), Blocks.field_10036))) {
            if (Intrinsics.areEqual(state.getBlock(), Blocks.field_22089)) {
            } else {
                boolean flag4 = INSTANCE.getFire();
            }
        }
        if (Intrinsics.areEqual(state.getBlock(), Blocks.field_16999)) {
        } else {
            boolean flag5 = INSTANCE.getBerryBush();
        }
        if (Intrinsics.areEqual(state.getBlock(), Blocks.field_27879)) {
        } else {
            boolean flag6 = INSTANCE.getPowderSnow();
        }
        if (Intrinsics.areEqual(state.getBlock(), Blocks.field_10164)) {
        } else {
            boolean flag7 = INSTANCE.getLava();
        }
        if (!(state.getBlock() instanceof class_2440)) {
            if (!(Intrinsics.areEqual(state.getBlock(), Blocks.field_10224))) {
                if (Intrinsics.areEqual(state.getBlock(), Blocks.field_10582)) {
                } else {
                    boolean flag8 = INSTANCE.getPlate();
                }
            }
        }
        if (state.getBlock() instanceof class_2538) {
            if (((Boolean) state.method_11654(((class_2769) class_2537.field_11669)))) {
            } else {
                boolean flag9 = INSTANCE.getTrapString();
            }
        } else {
        }
        if (state.getBlock() instanceof class_2542) {
        } else {
            boolean flag10 = INSTANCE.getTurtleEggs();
        }
        if (!(flag)) {
            if (!(flag4)) {
                if (!(flag3)) {
                    if (!(flag7)) {
                        if (!(flag5)) {
                            if (!(flag6)) {
                                if (!(flag8)) {
                                    if (!(flag9)) {
                                        if (!(flag2)) {
                                            if (flag10) {
                                                arg0.setState(Blocks.field_10566.method_9564());
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

    static {
        KProperty[] items = new KProperty[10];
        INSTANCE = new AvoidModule();
        unloadedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "unloaded", false);
        voidAirSetting = VisibleRenderHelper.registerSetting(INSTANCE, "void-air", false);
        cactusSetting = VisibleRenderHelper.registerSetting(INSTANCE, "cactus", false);
        fireSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fire", false);
        berryBushSetting = VisibleRenderHelper.registerSetting(INSTANCE, "berry-bush", false);
        powderSnowSetting = VisibleRenderHelper.registerSetting(INSTANCE, "powder-snow", false);
        lavaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lava", false);
        trapStringSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trap-string", false);
        plateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "plate", false);
        turtleEggsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "turtle-eggs", false);
    }

}
