package su.catlean.client.features.modules.utility.equip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1661;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2189;
import net.minecraft.class_2336;
import net.minecraft.class_3965;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.CalcBlockBreakingDeltaEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoToolModule extends Module {

    public static final AutoToolModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl silentSetting;
    private static final VisibleVisibleSettingPropertyImpl swapBackSetting;
    private static final VisibleVisibleSettingPropertyImpl saveItemSetting;
    private static final VisibleVisibleSettingPropertyImpl echestSilkSetting;
    private static int countValue;
    private static boolean enabledFlag;
    private static final List itemList;

    private AutoToolModule() {
        super("auto-tool", SubCategoriesKt.getEquipCategory());
    }

    private boolean getSilent() {
        return (Boolean) silentSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getSwapBack() {
        return (Boolean) swapBackSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getSaveItem() {
        return (Boolean) saveItemSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getEchestSilk() {
        return (Boolean) echestSilkSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        if (!(SharedKt.getMc().field_1765 instanceof class_3965)) {
            return;
        }
        class_3965 var19 = (class_3965) SharedKt.getMc().field_1765;
        BlockPos blockPos = var19.method_17777();
        if (SharedKt.getWorld().getBlockState(blockPos).method_26215()) {
            return;
        }
        if (this.computeValue(blockPos) != -1 && SharedKt.getMc().options.field_1886.method_1434()) {
            itemList.add(Integer.valueOf(SharedKt.getPlayer().method_31548().method_67532()));
            if (this.getSilent()) {
                ItemPacketHelper.INSTANCE.executeAction(this.computeValue(blockPos));
            } else {
                SharedKt.getPlayer().method_31548().method_61496(this.computeValue(blockPos));
            }
            countValue = this.computeValue(blockPos);
            enabledFlag = 1;
            timestampValue = SharedKt.getNumericValue();
        } else {
            if (!(this.getSwapBack())) {
                if (enabledFlag && !((Collection) itemList.isEmpty()) && SharedKt.getNumericValue() >= (timestampValue + 300) && this.getSilent()) {
                }
                if (this.getSilent()) {
                    ItemPacketHelper.INSTANCE.executeAction((Number) itemList.get(0));
                } else {
                    SharedKt.getPlayer().method_31548().method_61496((Number) itemList.get(0));
                }
                countValue = (Number) itemList.get(0);
                itemList.clear();
                enabledFlag = 0;
            }
        }
    }

    public void onCalcBlockBreakingDeltaEvent(CalcBlockBreakingDeltaEvent event) {
        float var13 = event.getState().method_26214((class_1922) SharedKt.getWorld(), event.getBlockPos());
        if (var13 < 0.0F) {
            event.setDelta(0.0F);
        }
        float var14 = (this.computeValue(event.getState(), SharedKt.getPlayer().method_31548().method_5438(countValue)) / var13);
        if (SharedKt.getPlayer().method_31548().method_5438(countValue).method_7951(event.getState())) {
        } else {
        }
        (var14 / 30.0F).setDelta((var14 / 100.0F));
        event.cancel();
    }

    private float computeValue(BlockState arg0, ItemStack arg1) {
        float var8 = arg1.method_7924(arg0);
        int var10 = StackServiceComponent3.computeValue(arg1, class_1893.field_9131);
        if (var8 > 1.0D) {
        } else {
        }
        return Math.max((((var10 * var10) + 1.0D) + 0.0D), 0.0D);
    }

    private int computeValue(int arg0, int arg1, BlockPos arg2) {
        int var19 = -1;
        float var20 = 1.0F;
        int var21 = 0;
        if (var21 < 9) {
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
            if (!(Intrinsics.areEqual(stack, ItemStack.field_8037))) {
                if (arg1 >= 0) {
                }
                if (arg1 > 0) {
                    if ((SharedKt.getPlayer().method_31548().method_5438().method_7936() - SharedKt.getPlayer().method_31548().method_5438().method_7919()) <= 10 && this.getSaveItem()) {
                    }
                } else {
                    BlockState state = SharedKt.getWorld().getBlockState(arg2);
                    int var24 = StackServiceComponent3.computeValue(stack, class_1893.field_9131);
                    float var25 = stack.method_7924(state);
                    if (arg1 > 0 && !(var18)) {
                        if (state.getBlock() instanceof class_2189) {
                            return -1;
                        }
                    }
                    if (arg0 >= 0) {
                        if (!(var18)) {
                            if (arg0 >= 0) {
                                if (state.getBlock() instanceof class_2336 && this.getEchestSilk()) {
                                    if (arg0 >= 0) {
                                        if (!(var18)) {
                                        }
                                        if (arg1 > 0) {
                                        }
                                        if (StackServiceComponent3.checkCondition(stack, class_1893.field_9099) && (var24 + var25) > var20) {
                                            var20 = (var24 + var25);
                                            var19 = var21;
                                        }
                                        if (arg0 >= 0) {
                                        }
                                    }
                                }
                            }
                        }
                        if (var18 && (var24 + var25) > var20) {
                            var20 = (var24 + var25);
                            var19 = var21;
                        }
                    }
                }
            }
        }
        return var19;
    }

    private static boolean isActive() {
        return !(INSTANCE.getSilent());
    }

    static {
        KProperty[] var26 = new KProperty[4];
        INSTANCE = new AutoToolModule();
        silentSetting = VisibleRenderHelper.registerSetting(INSTANCE, "silent");
        swapBackSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-back", 1, null, this::isActive);
        saveItemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "save-item");
        echestSilkSetting = VisibleRenderHelper.registerSetting(INSTANCE, "echest-silk");
        itemList = new ArrayList();
    }

}
