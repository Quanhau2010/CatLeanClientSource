package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.class_1661;
import net.minecraft.class_2879;
import net.minecraft.class_761;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.LightMapUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.render.XRayBlockEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.ItemServiceComponent4;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class XRayModule extends Module {

    public static final XRayModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl3 selectedBlocksSetting;
    private static final VisibleVisibleSettingPropertyImpl brutForceSetting;
    private static final VisibleVisibleSettingPropertyImpl fastSetting;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final RangeVisibleSettingPropertyImpl radiusSetting;
    private static final RangeVisibleSettingPropertyImpl upSetting;
    private static final RangeVisibleSettingPropertyImpl downSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static final ArrayList arrayList;
    private static BlockPos blockPos;
    private static Box minecraftRef;
    private static boolean enabledFlag;

    private XRayModule() {
        super("x-ray", SubCategoriesKt.getEspCategory());
    }

    private BlocksServiceComponent getSelectedBlocks() {
        return (BlocksServiceComponent) selectedBlocksSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setSelectedBlocks(BlocksServiceComponent value) {
        selectedBlocksSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getBrutForce() {
        return (Boolean) brutForceSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getFast() {
        return (Boolean) fastSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private int getRadius() {
        return (Number) radiusSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private int getUp() {
        return (Number) upSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private int getDown() {
        return (Number) downSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        GofraState.INSTANCE.setXray(1);
        if (this.getBrutForce() && !(enabledFlag)) {
            arrayList.clear();
            arrayList.addAll((Collection) this.resolveArrayList());
            minecraftRef = this.resolveMinecraftObject();
        }
        enabledFlag = this.getBrutForce();
    }

    private void onXRayBlockEvent(XRayBlockEvent arg0) {
        arg0.cancel();
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = ((arg0 ^ 42464098356882L) >>> 16);
        long var7 = (((arg0 ^ 42464098356882L) << 48) >>> 48);
        if (var8 == null) {
        }
        if (SharedKt.getMc().player == null || var8 == null) {
            return;
        }
        SharedKt.getMc().field_1769.method_3279();
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 64129331416845L);
        if (var5 == null) {
        }
        if (SharedKt.getMc().player == null || var5 == null) {
            return;
        }
        SharedKt.getMc().field_1769.method_3279();
        GofraState.INSTANCE.setXray(0);
    }

    private void onMoveEvent(MoveEvent arg0) {
        arg0.setZ(0.0D);
        arg0.setX(0.0D);
        arg0.cancel();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (!(this.getBrutForce())) {
            return;
        }
        if (blockPos != null && !((Collection) arrayList.isEmpty())) {
            int var29 = 4;
            Color var31 = NewThemeRenderHelper.INSTANCE.resolveColor(0);
            Box var32 = new Box(blockPos);
            TextShaderComponent2.checkCondition();
        }
        TextShaderComponent2.checkCondition(minecraftRef, NewThemeRenderHelper.INSTANCE.resolveColor(0));
        if (arrayList.isEmpty()) {
            return;
        }
        if (ItemServiceComponent4.checkCondition2(SharedKt.getPlayer().method_6047())) {
            ItemPacketHelper.INSTANCE.executeAction(((SharedKt.getPlayer().method_31548().method_67532() % 8) + 1));
        }
        if ((arrayList.size() - 1) <= 1) {
        } else {
        }
        BlockPos blockPos = (BlockPos) 0.remove(RangeServiceComponent.P(0, (arrayList.size() - 1)));
        Object var35 = blockPos;
        Object var36 = var35;
        ClientPlayerInteractionManager var38 = SharedKt.getInteractionManager();
        int var37 = 0;
        blockPos = var36;
        var38.method_2910(SharedKt.getPlayer().method_5735());
        SharedKt.getInteractionManager().method_2925();
        PacketPacketHelper.handlePacket((Packet) new class_2879(Hand.field_5808));
    }

    private void onLightMapUpdateEvent(LightMapUpdateEvent arg0) {
        arg0.cancel();
    }

    private Box resolveMinecraftObject() {
        return new Box((SharedKt.getPlayer().getX() - this.getRadius()), (SharedKt.getPlayer().getY() - this.getDown()), (SharedKt.getPlayer().getZ() - this.getRadius()), (SharedKt.getPlayer().getX() + this.getRadius()), (SharedKt.getPlayer().getY() + this.getUp()), (SharedKt.getPlayer().getZ() + this.getRadius()));
    }

    private ArrayList resolveArrayList(long arg0, short arg1) {
        BlockPos blockPos = BlockPos.ofFloored(this.resolveMinecraftObject(SharedKt.getPlayer()));
        List<BlockPos> positions = new ArrayList();
        int var25 = (blockPos.method_10263() - this.getRadius());
        int var26 = (blockPos.method_10263() + this.getRadius());
        if (var25 <= var26) {
            int var27 = (blockPos.method_10264() - this.getDown());
            int var28 = (blockPos.method_10264() + this.getUp());
            if (arg1 < 0) {
                if (var27 <= var28) {
                    int var29 = (blockPos.method_10260() - this.getRadius());
                    int var30 = (blockPos.method_10260() + this.getRadius());
                    if (var29 <= var30) {
                        BlockPos blockPos2 = new BlockPos();
                        if (arg1 < 0) {
                            if (this.getFast()) {
                                if (arg1 <= 0) {
                                    if (!((var29 % 2))) {
                                        if (!(SharedKt.getWorld().method_22347(blockPos2)) && (var25 % 2) && (var27 % 2) && arg0 <= 0L) {
                                        }
                                    }
                                }
                                positions.add(blockPos2);
                            }
                        }
                        if (arg0 >= 0L) {
                            if (var22 == null) {
                                if (var29 != var30) {
                                }
                            }
                        }
                        if (arg0 > 0L) {
                        }
                        if (var27 != var28) {
                        }
                    }
                }
            }
            if (var25 != var26) {
            }
        }
        return positions;
    }

    private static boolean isActive() {
        return INSTANCE.getBrutForce();
    }

    private static boolean isActive2() {
        return INSTANCE.getBrutForce();
    }

    private static boolean isActive3() {
        return INSTANCE.getBrutForce();
    }

    private static boolean isActive4() {
        return INSTANCE.getBrutForce();
    }

    private static boolean isActive5() {
        return INSTANCE.getBrutForce();
    }

    static {
        KProperty[] var37 = new KProperty[7];
        INSTANCE = new XRayModule();
        var37 = new Block[3];
        var37[0] = Blocks.field_10442;
        var37[1] = Blocks.field_29029;
        var37[2] = Blocks.NETHERITE_BLOCK;
        int var33 = 12;
        BlocksServiceComponent var36 = new BlocksServiceComponent(CollectionsKt.mutableListOf());
        selectedBlocksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks");
        brutForceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "deobfuscator");
        fastSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fast", 0, null, this::isActive);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 25, new IntRange(1, 100), null, this::isActive2);
        radiusSetting = VisibleRenderHelper.registerSetting(INSTANCE, "radius", 5, new IntRange(1, 64), null, this::isActive3);
        upSetting = VisibleRenderHelper.registerSetting(INSTANCE, "radius", 5, new IntRange(1, 32), null, this::isActive4);
        downSetting = VisibleRenderHelper.registerSetting(INSTANCE, "down", 5, new IntRange(1, 32), null, this::isActive5);
        serviceComponent10 = new ServiceComponent10();
        arrayList = new ArrayList();
        minecraftRef = new Box(BlockPos.field_10980);
    }

}
