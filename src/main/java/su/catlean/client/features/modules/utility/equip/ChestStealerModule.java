package su.catlean.client.features.modules.utility.equip;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_1263;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2611;
import net.minecraft.class_3965;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl8;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent67;
import su.catlean.client.services.client.VectorServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class ChestStealerModule extends Module {

    public static final ChestStealerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 actionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 sortSetting;
    private static final DefaultValueVisibleSettingPropertyImpl8 itemsSetting;
    private static final RangeVisibleSettingPropertyImpl minDelayMsSetting;
    private static final RangeVisibleSettingPropertyImpl maxDelayMsSetting;
    private static final RangeVisibleSettingPropertyImpl minDelayTicksSetting;
    private static final RangeVisibleSettingPropertyImpl maxDelayTicksSetting;
    private static final VisibleVisibleSettingPropertyImpl randomizeSlotsSetting;
    private static final VisibleVisibleSettingPropertyImpl closeSetting;
    private static final VisibleVisibleSettingPropertyImpl autoOpenSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;
    private static final ServiceComponent10 serviceComponent103;
    private static int countValue;
    private static int countValue2;

    private ChestStealerModule() {
        super("chest-stealer", SubCategoriesKt.getEquipCategory());
    }

    private ChestStealerActionMode getAction() {
        return ((ChestStealerActionMode) actionSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private ChestStealerSortMode getSort() {
        return ((ChestStealerSortMode) sortSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private ItemsServiceComponent2 getItems() {
        return ((ItemsServiceComponent2) itemsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private int getMinDelayMs() {
        return ((Number) minDelayMsSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private int getMaxDelayMs() {
        return ((Number) maxDelayMsSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private int getMinDelayTicks() {
        return ((Number) minDelayTicksSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private int getMaxDelayTicks() {
        return ((Number) maxDelayTicksSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getRandomizeSlots() {
        return ((Boolean) randomizeSlotsSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getClose() {
        return ((Boolean) closeSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getAutoOpen() {
        return ((Boolean) autoOpenSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getRotate() {
        return ((Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        this.executeAction(false);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (this.getAutoOpen() && SharedKt.getMc().currentScreen == null && serviceComponent10.checkCondition(3000)) {
            Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
            while (iterator.hasNext()) {
                class_2586 class2586 = ((class_2586) iterator.next());
                double offset = PolygonShaderComponent.INSTANCE.computeValue(-0.4D, 0.4D, Random.Default.nextFloat());
                Vec3d vec = ((class_2611) class2586).method_11016().toCenterPos().method_1031(offset, 0.375D, offset);
                if (this.getRotate()) {
                    SequenceServiceComponent.executeAction(MoveFixServiceComponent.vectorServiceComponent.resolveMoveFixServiceComponent(vec));
                }
                SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, new class_3965(vec, Direction.UP, ((class_2611) class2586).method_11016(), false));
                SharedKt.getPlayer().method_6104(Hand.field_5808);
            }
        }
        this.executeAction(true);
    }

    private void executeAction(boolean arg0) {
        GuiMoveModule.INSTANCE.updateValue(true);
        if (SharedKt.getMc().player != null && SharedKt.getMc().world != null && SharedKt.getPlayer().field_7512 instanceof class_1707) {
            class_1707 class1707 = ((class_1707) SharedKt.getPlayer().field_7512);
            IntRange intRange = RangesKt.until(0, class1707.method_7629().method_5439());
            if (this.getRandomizeSlots()) {
            } else {
            }
            Iterator iterator = ((Iterable) intRange).iterator();
            while (iterator.hasNext()) {
                int index = ((Number) iterator.next());
                class_1735 class1735 = class1707.method_7611(index);
                String text = SharedKt.getMc().currentScreen.method_25440().getString();
                if (arg0) {
                } else {
                }
                HandServiceComponent.e(index, 0, class_1713.field_7794, false);
                serviceComponent10.executeAction();
                this.updateValue();
            }
            if (this.checkCondition(class1707) && this.getClose() && serviceComponent103.checkCondition((TheNetherPacketHelper.f() + 100))) {
                SharedKt.getPlayer().method_7346();
                serviceComponent103.executeAction();
            }
        } else {
        }
        GuiMoveModule.INSTANCE.updateValue(false);
    }

    private void updateValue() {
        countValue2 = RangeServiceComponent.f(((ClosedRange) new IntRange(this.getMinDelayMs(), this.getMaxDelayMs())), false);
        countValue = RangeServiceComponent.f(((ClosedRange) new IntRange(this.getMinDelayTicks(), this.getMaxDelayTicks())), false);
    }

    private boolean checkCondition(ItemStack arg0) {
        return !(this.getItems().getList().contains(arg0.getItem()));
    }

    private boolean checkCondition(class_1707 arg0, long arg1, char arg2) {
        int index = 0;
        if (arg0.method_7629().method_5439() == 90) {
        } else {
        }
        int index2 = 27;
        if (index < index2) {
            if (arg2 >= 0) {
                if (__UNDEF_KEY__ != null) {
                    if (arg0.method_7611(index).method_7681()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isActive() {
        return INSTANCE.getSort() != ChestStealerSortMode.NONE;
    }

    private static boolean isActive2() {
        return INSTANCE.getAction() == ChestStealerActionMode.FAST;
    }

    private static boolean isActive3() {
        return INSTANCE.getAction() == ChestStealerActionMode.FAST;
    }

    private static boolean isActive4() {
        return INSTANCE.getAction() == ChestStealerActionMode.ON_TICK;
    }

    private static boolean isActive5() {
        return INSTANCE.getAction() == ChestStealerActionMode.ON_TICK;
    }

    private static boolean isActive6() {
        return INSTANCE.getAutoOpen();
    }

    static {
        KProperty[] items = new KProperty[11];
        INSTANCE = new ChestStealerModule();
        actionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "action", ChestStealerActionMode.FAST);
        sortSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sort", ChestStealerSortMode.NONE);
        itemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "items", new ItemsServiceComponent2(), null, this::isActive);
        minDelayMsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-delay-ms", 80, new IntRange(0, 500), null, this::isActive2);
        maxDelayMsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-delay-ms", 80, new IntRange(0, 500), null, this::isActive3);
        minDelayTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-delay-ticks", 0, new IntRange(0, 30), null, this::isActive4);
        maxDelayTicksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-delay-ticks", 1, new IntRange(0, 30), null, this::isActive5);
        randomizeSlotsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "randomize-slots", false);
        closeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "close-if-empty", false);
        autoOpenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auto-open", false);
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", false, null, this::isActive6);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
        serviceComponent103 = new ServiceComponent10();
    }

}
