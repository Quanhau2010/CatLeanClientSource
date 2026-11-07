package su.catlean.client.features.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.class_1747;
import net.minecraft.class_2815;
import net.minecraft.class_2824;
import net.minecraft.class_3944;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.movement.rage.BlinkModule;
import su.catlean.client.features.modules.utility.player.AutoMendModule;
import su.catlean.client.features.modules.utility.player.BoxShrinkerModule;
import su.catlean.client.features.modules.utility.player.SpeedMineModule;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent93;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.VecPacketHelper;
import su.catlean.client.services.render.MatrixStackRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.OptionMode15;

public abstract class BlockPlacementModule extends Module {

    private final int countValue;
    private boolean enabledFlag;
    private final DefaultValueVisibleSettingPropertyImpl10 timingSetting;
    private final RangeVisibleSettingPropertyImpl blocksPerActionSetting;
    private final RangeVisibleSettingPropertyImpl delayPerActionSetting;
    private final VisibleVisibleSettingPropertyImpl rotateSetting;
    private final VisibleVisibleSettingPropertyImpl grimSilentSetting;
    private final DefaultValueVisibleSettingPropertyImpl10 placeModeSetting;
    private final DefaultValueVisibleSettingPropertyImpl10 interactSetting;
    private final DefaultValueVisibleSettingPropertyImpl10 switchSetting;
    private final RangeVisibleSettingPropertyImpl2 rangeSetting;
    private final RangeVisibleSettingPropertyImpl2 wallRangeSetting;
    private final DefaultValueVisibleSettingPropertyImpl7 pauseGroupSetting;
    private final VisibleVisibleSettingPropertyImpl miningSetting;
    private final VisibleVisibleSettingPropertyImpl eatingSetting;
    private final VisibleVisibleSettingPropertyImpl inventorySetting;
    private final VisibleVisibleSettingPropertyImpl blinkSetting;
    private final DefaultValueVisibleSettingPropertyImpl10 renderSetting;
    private final DefaultValueVisibleSettingPropertyImpl10 renderAnimationSetting;
    private final VisibleVisibleSettingPropertyImpl syncColorsSetting;
    private final DefaultValueVisibleSettingPropertyImpl9 fillColorSetting;
    private final DefaultValueVisibleSettingPropertyImpl9 outlineColorSetting;
    private final ServiceComponent10 serviceComponent10;
    private int countValue2;
    private static int[] countValueArray;

    public BlockPlacementModule(String id, SubCategory category, int priority, boolean withRange) {
        super(id, category);
        this.countValue = priority;
        this.enabledFlag = withRange;
        this.timingSetting = VisibleRenderHelper.registerSetting(this, "timing", BlockPlacementTimingMode.Vanilla);
        this.blocksPerActionSetting = VisibleRenderHelper.registerSetting(this, "blocks-per-action", 6, new IntRange(2, 20), null, this::checkCondition);
        this.delayPerActionSetting = VisibleRenderHelper.registerSetting(this, "delay-per-action", 0, new IntRange(0, 10), null, this::checkCondition2);
        this.rotateSetting = VisibleRenderHelper.registerSetting(this, "rotate");
        this.grimSilentSetting = VisibleRenderHelper.registerSetting(this, "grim-silent", 0, null, this::checkCondition3);
        this.placeModeSetting = VisibleRenderHelper.registerSetting(this, "place-mode", BlockPlacementPlaceMode.Normal);
        this.interactSetting = VisibleRenderHelper.registerSetting(this, "interact", BlockPlacementInteractMode.Strict);
        this.switchSetting = VisibleRenderHelper.registerSetting(this, "switch", BlockPlacementSwitchMode.Silent);
        this.rangeSetting = VisibleRenderHelper.registerSetting(this, "range", 4.0F, RangesKt.rangeTo(2.0F, 10.0F), null, this::checkCondition4);
        this.wallRangeSetting = VisibleRenderHelper.registerSetting(this, "wall-range", 4.0F, RangesKt.rangeTo(2.0F, 10.0F), null, this::checkCondition5);
        this.pauseGroupSetting = VisibleRenderHelper.registerSetting(this, "pause", OptionMode14.BOOLS);
        this.miningSetting = VisibleRenderHelper.registerSetting(this, "mining", 0, this.getPauseGroup());
        this.eatingSetting = VisibleRenderHelper.registerSetting(this, "eating", 0, this.getPauseGroup());
        this.inventorySetting = VisibleRenderHelper.registerSetting(this, "inventory", 0, this.getPauseGroup());
        this.blinkSetting = VisibleRenderHelper.registerSetting(this, "blink", 0, this.getPauseGroup());
        this.renderSetting = VisibleRenderHelper.registerSetting(this, "render", BlockPlacementRenderMode.BOTH);
        this.renderAnimationSetting = VisibleRenderHelper.registerSetting(this, "animation", BlockPlacementRenderAnimationMode.Fade);
        this.syncColorsSetting = VisibleRenderHelper.registerSetting(this, "sync-colors");
        this.fillColorSetting = VisibleRenderHelper.registerSetting(this, "fill-color", Color.WHITE, null, this::checkCondition6);
        this.outlineColorSetting = VisibleRenderHelper.registerSetting(this, "outline-color", Color.WHITE, null, this::checkCondition7);
        this.serviceComponent10 = new ServiceComponent10();
    }

    public BlockPlacementModule(String arg0, SubCategory arg1, int arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 4)) {
            arg2 = 150;
        }
        if ((arg4 & 8)) {
            arg3 = 1;
        }
        this(arg0, arg1, arg2, arg3);
    }

    public int getNumericValue() {
        return this.countValue;
    }

    private BlockPlacementTimingMode getTiming() {
        return (BlockPlacementTimingMode) this.timingSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setTiming(BlockPlacementTimingMode value) {
        this.timingSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private int getBlocksPerAction() {
        return (Number) this.blocksPerActionSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setBlocksPerAction(int value) {
        this.blocksPerActionSetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
    }

    private int getDelayPerAction() {
        return (Number) this.delayPerActionSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setDelayPerAction(int value) {
        this.delayPerActionSetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    protected boolean getRotate() {
        return (Boolean) this.rotateSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    protected void setRotate(boolean value) {
        this.rotateSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    protected boolean getGrimSilent() {
        return (Boolean) this.grimSilentSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    protected void setGrimSilent(boolean value) {
        this.grimSilentSetting.setValue(this, DELEGATED_PROPERTIES[4], Boolean.valueOf(value));
    }

    protected BlockPlacementPlaceMode getPlaceMode() {
        return (BlockPlacementPlaceMode) this.placeModeSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    protected void setPlaceMode(BlockPlacementPlaceMode value) {
        this.placeModeSetting.setValue(this, DELEGATED_PROPERTIES[5], value);
    }

    protected BlockPlacementInteractMode getInteract() {
        return (BlockPlacementInteractMode) this.interactSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    protected void setInteract(BlockPlacementInteractMode value) {
        this.interactSetting.setValue(this, DELEGATED_PROPERTIES[6], value);
    }

    protected BlockPlacementSwitchMode getSwitch() {
        return (BlockPlacementSwitchMode) this.switchSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    protected void setSwitch(BlockPlacementSwitchMode value) {
        this.switchSetting.setValue(this, DELEGATED_PROPERTIES[7], value);
    }

    protected float getRange() {
        return (Number) this.rangeSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    protected void setRange(float value) {
        this.rangeSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    protected float getWallRange() {
        return (Number) this.wallRangeSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    protected void setWallRange(float value) {
        this.wallRangeSetting.setValue(this, DELEGATED_PROPERTIES[9], Float.valueOf(value));
    }

    protected SettingGroup getPauseGroup() {
        return (SettingGroup) this.pauseGroupSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    protected boolean getMining() {
        return (Boolean) this.miningSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    protected boolean getEating() {
        return (Boolean) this.eatingSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    protected boolean getInventory() {
        return (Boolean) this.inventorySetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    protected boolean getBlink() {
        return (Boolean) this.blinkSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    protected BlockPlacementRenderMode getRender() {
        return (BlockPlacementRenderMode) this.renderSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    protected void setRender(BlockPlacementRenderMode value) {
        this.renderSetting.setValue(this, DELEGATED_PROPERTIES[15], value);
    }

    protected BlockPlacementRenderAnimationMode getRenderAnimation() {
        return (BlockPlacementRenderAnimationMode) this.renderAnimationSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    protected void setRenderAnimation(BlockPlacementRenderAnimationMode value) {
        this.renderAnimationSetting.setValue(this, DELEGATED_PROPERTIES[16], value);
    }

    protected boolean getSyncColors() {
        return (Boolean) this.syncColorsSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    protected Color getFillColor() {
        return (Color) this.fillColorSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    protected Color getOutlineColor() {
        return (Color) this.outlineColorSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    protected ServiceComponent10 getServiceComponent10() {
        return this.serviceComponent10;
    }

    protected void onReceivePacket(ReceivePacket e) {
        PacketPacketHelper.handlePacket((Packet) new class_2815((class_3944) e.getPacket().method_17592()));
        e.cancel();
    }

    protected boolean placeBlocks(List positions, boolean async, boolean ignoreStrict, List blocks, boolean invertSelection) {
        Iterable var11 = (Iterable) blocks;
        int var23 = ignoreStrict;
        int var22 = async;
        Object var21 = positions;
        Object var20 = this;
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var15 = 0;
        Iterator iterator = var13.iterator();
        if (iterator.hasNext()) {
            Object var17 = iterator.next();
            Block var18 = (Block) var17;
            if (var10 == null) {
                Object var24 = var14;
                int var19 = 0;
                var24.add(var18.method_8389());
            }
        }
        var24 = var14;
        return var20.placeBlocks(invertSelection);
    }

    public static boolean placeBlocks(BlockPlacementModule arg0, List arg1, boolean arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if (arg7 != null) {
        }
        if (var14 == null) {
            if ((arg6 & 2)) {
                arg2 = 0;
            }
        }
        if (var14 == null) {
            if ((arg6 & 4)) {
                arg3 = 0;
            }
        }
        if (var14 == null) {
            if ((arg6 & 8)) {
                arg4 = arg0.resolveList();
            }
        }
        if (var14 == null) {
            if ((arg6 & 16)) {
                arg5 = 0;
            }
        }
        return arg0.placeBlocks(arg1, arg2, arg3, arg4, arg5);
    }

    protected boolean placeBlocks(List positions, boolean async, boolean ignoreStrict, List blocks, boolean invertSelection) {
        if (this.countValue2 > 0) {
            int var17 = this.countValue2;
            this.countValue2 = (var17 + -1);
            return false;
        }
        if (positions.isEmpty()) {
            return false;
        }
        var17 = this.getBlocksPerAction();
        int var18 = 0;
        Iterator iterator = positions.iterator();
        while (iterator.hasNext()) {
            BlockPos blockPos = (BlockPos) iterator.next();
            if (var17 <= 0) {
            } else {
                var18 = 1;
                if (this.getTiming() == BlockPlacementTimingMode.Instant) {
                    this.countValue2 = this.getDelayPerAction();
                }
            }
        }
        return var18;
    }

    public static boolean placeBlocks(BlockPlacementModule arg0, List arg1, boolean arg2, boolean arg3, List arg4, boolean arg5, int arg6, Object arg7) {
        if (arg7 != null) {
        }
        if (var14 == null) {
            if ((arg6 & 2)) {
                arg2 = 0;
            }
        }
        if (var14 == null) {
            if ((arg6 & 4)) {
                arg3 = 0;
            }
        }
        if (var14 == null) {
            if ((arg6 & 8)) {
                arg4 = arg0.resolveList2();
            }
        }
        if (var14 == null) {
            if ((arg6 & 16)) {
                arg5 = 0;
            }
        }
        return arg0.placeBlocks(arg1, arg2, arg3, arg4, arg5);
    }

    private boolean placeBlocks(BlockPos arg0, List arg1, boolean arg2, boolean arg3, boolean arg4) {
        if (arg4) {
        } else {
        }
        StackServiceComponent2 var79 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(arg1);
        if (!(var79.isActive())) {
            return false;
        }
        if (this.placeBlocks()) {
            return false;
        }
        RotationServiceComponent4 var80 = VecPacketHelper.resolveRotationServiceComponent4(arg0, var79.getNumericValue(), BlockPlacementInteractMode.Vanilla, this.getInteract(), this.getPlaceMode(), this.getOptionMode15(), this.getRange(), this.getWallRange(), this.countValue, this.getSwitch(), null, this.getGrimSilent());
        if (var80 != null) {
            Object var81 = var80;
            int var82 = 0;
            Entity entity = this.resolveMinecraftObject(arg0);
            if (entity != null) {
                if (this.placeBlocks(entity)) {
                    class_2824 var84 = class_2824.method_34206(SharedKt.getPlayer(), SharedKt.getPlayer().method_5715());
                    ServiceComponent93.executeAction(entity.method_5628());
                    PacketPacketHelper.handlePacket((Packet) var84);
                    SharedKt.getPlayer().method_6104(Hand.field_5808);
                } else {
                    return false;
                }
            }
            if (this.getRotate()) {
                if (this.getTiming() == BlockPlacementTimingMode.Instant) {
                    SequenceServiceComponent.INSTANCE.executeAction();
                } else {
                    SequenceServiceComponent.INSTANCE.executeAction();
                }
            }
            if (!(arg2)) {
                if (!(this.getRotate())) {
                }
                if (this.getRotate() && this.getGrimSilent() && this.getTiming() == BlockPlacementTimingMode.Instant) {
                    SequenceServiceComponent.INSTANCE.executeAction(var81.getMoveFixServiceComponent().getNumericValue(), var81.getMoveFixServiceComponent().getNumericValue2());
                }
                var80.getFunction0().invoke();
                if (this.getRotate() && this.getGrimSilent() && this.getTiming() == BlockPlacementTimingMode.Instant) {
                    SequenceServiceComponent.INSTANCE.executeAction(SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455());
                }
                var80.executeAction(this::getUnit);
            }
            if (this.getRender() != BlockPlacementRenderMode.NONE) {
                if (this.getSyncColors()) {
                } else {
                }
                if (this.getSyncColors()) {
                } else {
                }
                BlockPlacementRenderMode var74 = this.getRender();
                BlockPlacementRenderAnimationMode var75 = this.getRenderAnimation();
                Color var76 = this.getFillColor();
                Color var77 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F);
                PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 1.0F).executeAction(this.getOutlineColor());
            }
            AutoMendModule.INSTANCE.getServiceComponent10().executeAction();
            this.serviceComponent10.executeAction();
            return true;
        }
        return false;
    }

    private static boolean placeBlocks(BlockPlacementModule arg0, BlockPos arg1, List arg2, boolean arg3, boolean arg4, boolean arg5, int arg6, Object arg7) {
        if (arg7 != null) {
        }
        if ((arg6 & 16)) {
            arg5 = 0;
        }
        return arg0.placeBlocks(arg1, arg2, arg3, arg4, arg5);
    }

    protected boolean placeBlocks(Entity crystal) {
        long var4 = (0L ^ 79616959566951L);
        return !(this.placeBlocks());
    }

    private Entity resolveMinecraftObject(BlockPos arg0) {
        Iterable var7 = (Iterable) SharedKt.getWorld().method_18467(Entity.class, new Box(arg0));
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            Entity entity = var10;
            int var12 = 0;
        } else {
        }
        return null;
    }

    protected boolean placeBlocks(BlockPos bp) {
        if (BoxShrinkerModule.INSTANCE.getEnabled()) {
        } else {
        }
        return !((Collection) LivingEntity.class.method_18467(new Box(bp).method_1009(-1.0E-12D, 0.0D, -1.0E-12D), new Box(bp)).isEmpty());
    }

    protected List resolveList() {
        Block[] var3 = new Block[4];
        var3[0] = Blocks.OBSIDIAN;
        var3[1] = Blocks.ENDER_CHEST;
        var3[2] = Blocks.field_22108;
        var3[3] = Blocks.field_23152;
        return CollectionsKt.listOf();
    }

    protected List resolveList2() {
        return CollectionsKt.emptyList();
    }

    protected OptionMode15 getOptionMode15() {
        return OptionMode15.ONLY_CRYSTALS;
    }

    protected boolean placeBlocks() {
        if (SharedKt.getInteractionManager().method_2923() && this.getMining()) {
            return true;
        }
        if (BlinkModule.INSTANCE.getEnabled() && this.getBlink()) {
            return true;
        }
        if (SharedKt.getPlayer().method_6115() && this.getEating()) {
            return true;
        }
        if (SpeedMineModule.INSTANCE.getAtomicBoolean().get()) {
            return true;
        }
        if (EventPacketHelper2.INSTANCE.isActive2() && this.getInventory()) {
            return true;
        }
        return false;
    }

    private static boolean placeBlocks(BlockPlacementModule arg0) {
        return arg0.getTiming() == BlockPlacementTimingMode.Instant;
    }

    private static boolean checkCondition2(BlockPlacementModule arg0) {
        return arg0.getTiming() == BlockPlacementTimingMode.Instant;
    }

    private static boolean checkCondition3(BlockPlacementModule arg0) {
        if (var7 == null) {
        }
        return arg0.getTiming() == BlockPlacementTimingMode.Instant;
    }

    private static boolean checkCondition4(BlockPlacementModule arg0) {
        return arg0.enabledFlag;
    }

    private static boolean checkCondition5(BlockPlacementModule arg0) {
        return arg0.enabledFlag;
    }

    private static boolean checkCondition6(BlockPlacementModule arg0) {
        return !(arg0.getSyncColors());
    }

    private static boolean checkCondition7(BlockPlacementModule arg0) {
        return !(arg0.getSyncColors());
    }

    private static boolean placeBlocks(List arg0, ItemStack arg1) {
        return !(arg0.contains(arg1.getItem()));
    }

    private static Unit getUnit() {
        return Unit.INSTANCE;
    }

    static {
        KProperty[] var22 = new KProperty[20];
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
