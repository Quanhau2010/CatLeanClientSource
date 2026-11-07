package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.class_1533;
import net.minecraft.class_1694;
import net.minecraft.class_1696;
import net.minecraft.class_1700;
import net.minecraft.class_1767;
import net.minecraft.class_1922;
import net.minecraft.class_2586;
import net.minecraft.class_2587;
import net.minecraft.class_2589;
import net.minecraft.class_2595;
import net.minecraft.class_2601;
import net.minecraft.class_2609;
import net.minecraft.class_2611;
import net.minecraft.class_2614;
import net.minecraft.class_2627;
import net.minecraft.class_2646;
import net.minecraft.class_265;
import net.minecraft.class_3719;
import net.minecraft.class_4184;
import net.minecraft.class_757;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class StorageEspModule extends Module {

    public static final StorageEspModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 shaderModeSetting;
    private static final VisibleVisibleSettingPropertyImpl tracersSetting;
    private static final VisibleVisibleSettingPropertyImpl chestsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 chestSetting;
    private static final VisibleVisibleSettingPropertyImpl trappedChestsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 trappedChestSetting;
    private static final VisibleVisibleSettingPropertyImpl enderChestsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 enderChestSetting;
    private static final VisibleVisibleSettingPropertyImpl furnacesSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 furnaceSetting;
    private static final VisibleVisibleSettingPropertyImpl dispencersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 dispencerSetting;
    private static final VisibleVisibleSettingPropertyImpl hoppersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 hopperSetting;
    private static final VisibleVisibleSettingPropertyImpl shulkersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 shulkerSetting;
    private static final VisibleVisibleSettingPropertyImpl brewingStandsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 brewingStandSetting;
    private static final VisibleVisibleSettingPropertyImpl barrelsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 barrelSetting;
    private static final VisibleVisibleSettingPropertyImpl chestMinecartsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 chestMinecartSetting;
    private static final VisibleVisibleSettingPropertyImpl furnaceMinecartsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 furnaceMinecartSetting;
    private static final VisibleVisibleSettingPropertyImpl hopperMinecartsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 hopperMinecartSetting;
    private static final VisibleVisibleSettingPropertyImpl framesSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 emptyFrameSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 itemFrameSetting;
    private static final VisibleVisibleSettingPropertyImpl bedsSetting;

    private StorageEspModule() {
        super("storage-esp", SubCategoriesKt.getEspCategory());
    }

    public StorageEspShaderMode getShaderMode() {
        if (var5 == null) {
        }
        return (StorageEspShaderMode) shaderModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getTracers() {
        return (Boolean) tracersSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getChests() {
        return (Boolean) chestsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private Color getChest() {
        return (Color) chestSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getTrappedChests() {
        return (Boolean) trappedChestsSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private Color getTrappedChest() {
        return (Color) trappedChestSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getEnderChests() {
        return (Boolean) enderChestsSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private Color getEnderChest() {
        return (Color) enderChestSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getFurnaces() {
        return (Boolean) furnacesSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private Color getFurnace() {
        return (Color) furnaceSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getDispencers() {
        return (Boolean) dispencersSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private Color getDispencer() {
        return (Color) dispencerSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private boolean getHoppers() {
        return (Boolean) hoppersSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private Color getHopper() {
        return (Color) hopperSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getShulkers() {
        return (Boolean) shulkersSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private Color getShulker() {
        return (Color) shulkerSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private boolean getBrewingStands() {
        return (Boolean) brewingStandsSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private Color getBrewingStand() {
        return (Color) brewingStandSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private boolean getBarrels() {
        return (Boolean) barrelsSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private Color getBarrel() {
        return (Color) barrelSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private boolean getChestMinecarts() {
        return (Boolean) chestMinecartsSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private Color getChestMinecart() {
        return (Color) chestMinecartSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private boolean getFurnaceMinecarts() {
        return (Boolean) furnaceMinecartsSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    private Color getFurnaceMinecart() {
        return (Color) furnaceMinecartSetting.getValue(this, DELEGATED_PROPERTIES[23]);
    }

    private boolean getHopperMinecarts() {
        return (Boolean) hopperMinecartsSetting.getValue(this, DELEGATED_PROPERTIES[24]);
    }

    private Color getHopperMinecart() {
        return (Color) hopperMinecartSetting.getValue(this, DELEGATED_PROPERTIES[25]);
    }

    private boolean getFrames() {
        return (Boolean) framesSetting.getValue(this, DELEGATED_PROPERTIES[26]);
    }

    private Color getEmptyFrame() {
        return (Color) emptyFrameSetting.getValue(this, DELEGATED_PROPERTIES[27]);
    }

    private Color getItemFrame() {
        return (Color) itemFrameSetting.getValue(this, DELEGATED_PROPERTIES[28]);
    }

    private boolean getBeds() {
        return (Boolean) bedsSetting.getValue(this, DELEGATED_PROPERTIES[29]);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            class_2586 var24 = (class_2586) iterator.next();
            Color var25 = this.resolveColor();
            if (var24 instanceof class_2589) {
                Box var26 = new Box((class_2589) var24.method_11016());
                TextShaderComponent2.checkCondition(var26.method_1002(0.1D, 0.9D, 0.1D).method_989(0.05D, 0.0D, 0.05D));
            } else {
                if (var24 instanceof class_2614) {
                    var26 = new Box((class_2614) var24.method_11016());
                    TextShaderComponent2.checkCondition(var26.method_1002(0.0D, 0.62D, 0.0D).method_989(0.0D, 0.62D, 0.0D));
                    TextShaderComponent2.checkCondition(var26.method_1002(0.5D, 0.63D, 0.5D).method_989(0.25D, 0.25D, 0.25D));
                } else {
                    var26 = var24.method_11010().method_26218((class_1922) SharedKt.getWorld(), var24.method_11016()).method_1107().method_996(var24.method_11016());
                }
            }
            TextShaderComponent2.checkCondition();
            var26 = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
            TextShaderComponent2.checkCondition(var24.method_11016().toCenterPos(), PolygonShaderComponent.INSTANCE.resolveColor(1.0F));
        }
        iterator = SharedKt.getWorld().method_18112().iterator();
        while (iterator.hasNext()) {
            var24 = iterator.next();
            var25 = this.resolveColor();
            TextShaderComponent2.checkCondition(var24.method_5829());
            var26 = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
            TextShaderComponent2.checkCondition(var24.method_5829().method_1005(), PolygonShaderComponent.INSTANCE.resolveColor(1.0F));
        }
    }

    private Color resolveColor(class_2586 arg0) {
        if (arg0 instanceof class_2646) {
            if (this.getTrappedChests()) {
            } else {
            }
            return Color.WHITE;
        }
        if (arg0 instanceof class_2595 && this.getChests()) {
            return this.getChest();
        }
        if (arg0 instanceof class_2611 && this.getEnderChests()) {
            return this.getEnderChest();
        }
        if (arg0 instanceof class_2609 && this.getFurnaces()) {
            return this.getFurnace();
        }
        if (arg0 instanceof class_2601 && this.getDispencers()) {
            return this.getDispencer();
        }
        if (arg0 instanceof class_2614 && this.getHoppers()) {
            return this.getHopper();
        }
        if (arg0 instanceof class_2627 && this.getShulkers()) {
            return this.getShulker();
        }
        if (arg0 instanceof class_2589 && this.getBrewingStands()) {
            return this.getBrewingStand();
        }
        if (arg0 instanceof class_3719 && this.getBarrels()) {
            return this.getBarrel();
        }
        if (arg0 instanceof class_2587 && this.getBeds()) {
            return new Color((class_2587) arg0.method_11018().method_7787());
        }
        return Color.WHITE;
    }

    private Color resolveColor(Entity arg0) {
        if (arg0 instanceof class_1694 && this.getChestMinecarts()) {
            return this.getChestMinecart();
        }
        if (arg0 instanceof class_1696 && this.getFurnaceMinecarts()) {
            return this.getFurnaceMinecart();
        }
        if (arg0 instanceof class_1700 && this.getHopperMinecarts()) {
            return this.getHopperMinecart();
        }
        if (arg0 instanceof class_1533 && this.getFrames()) {
            if ((class_1533) arg0.method_6940().isEmpty()) {
            } else {
            }
            return this.getItemFrame();
        }
        return Color.WHITE;
    }

    private static boolean isActive() {
        return INSTANCE.getChests();
    }

    private static boolean isActive2() {
        return INSTANCE.getTrappedChests();
    }

    private static boolean isActive3() {
        return INSTANCE.getEnderChests();
    }

    private static boolean isActive4() {
        return INSTANCE.getFurnaces();
    }

    private static boolean isActive5() {
        return INSTANCE.getDispencers();
    }

    private static boolean isActive6() {
        return INSTANCE.getHoppers();
    }

    private static boolean isActive7() {
        return INSTANCE.getShulkers();
    }

    private static boolean isActive8() {
        return INSTANCE.getBrewingStands();
    }

    private static boolean isActive9() {
        return INSTANCE.getBarrels();
    }

    private static boolean isActive10() {
        return INSTANCE.getChestMinecarts();
    }

    private static boolean isActive11() {
        return INSTANCE.getFurnaceMinecarts();
    }

    private static boolean isActive12() {
        return INSTANCE.getHopperMinecarts();
    }

    private static boolean isActive13() {
        return INSTANCE.getFrames();
    }

    private static boolean isActive14() {
        return INSTANCE.getFrames();
    }

    static {
        KProperty[] var31 = new KProperty[30];
        INSTANCE = new StorageEspModule();
        shaderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-mode", StorageEspShaderMode.DEFAULT);
        tracersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tracers");
        chestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "chests");
        chestSetting = VisibleRenderHelper.registerSetting(INSTANCE, "chest", new Color(255, 155, 75, 100), null, this::isActive);
        trappedChestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trapped-chests");
        trappedChestSetting = VisibleRenderHelper.registerSetting(INSTANCE, "trapped-chest", new Color(255, 255, 12, 100), null, this::isActive2);
        enderChestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ender-chests");
        enderChestSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ender-chest", new Color(255, 13, 255, 100), null, this::isActive3);
        furnacesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "furnaces");
        furnaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "furnace", new Color(128, 128, 128, 100), null, this::isActive4);
        dispencersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "dispencers");
        dispencerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "dispencer", new Color(140, 140, 178, 100), null, this::isActive5);
        hoppersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hoppers");
        hopperSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hopper", new Color(115, 115, 155, 100), null, this::isActive6);
        shulkersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shulkers");
        shulkerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shulker", new Color(128, 50, 255, 100), null, this::isActive7);
        brewingStandsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "brewing-stands");
        brewingStandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "brewing-stand", new Color(128, 100, 50, 100), null, this::isActive8);
        barrelsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "barrels");
        barrelSetting = VisibleRenderHelper.registerSetting(INSTANCE, "barrel", new Color(255, 155, 75, 100), null, this::isActive9);
        chestMinecartsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "chest-minecarts");
        chestMinecartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "chest-minecart", new Color(255, 165, 75, 100), null, this::isActive10);
        furnaceMinecartsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "furnace-minecarts");
        furnaceMinecartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "furnace-minecart", new Color(128, 128, 128, 100), null, this::isActive11);
        hopperMinecartsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hopper-minecarts");
        hopperMinecartSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hopper-minecart", new Color(115, 115, 155, 100), null, this::isActive12);
        framesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "frames");
        emptyFrameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "empty-frame", new Color(115, 25, 25, 100), null, this::isActive13);
        itemFrameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "item-frame", new Color(115, 25, 25, 100), null, this::isActive14);
        bedsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "beds");
    }

}
