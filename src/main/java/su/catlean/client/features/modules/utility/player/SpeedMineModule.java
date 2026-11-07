package su.catlean.client.features.modules.utility.player;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1324;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1893;
import net.minecraft.class_1922;
import net.minecraft.class_2189;
import net.minecraft.class_2626;
import net.minecraft.class_2815;
import net.minecraft.class_2868;
import net.minecraft.class_5134;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterReceivePacket;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.player.AttackBlockEvent;
import su.catlean.api.event.events.player.CollisionEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.UpdateBlockBreakingProgressEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.features.modules.render.world.FreeCamModule;
import su.catlean.client.features.modules.utility.equip.ToolSaverModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.network.ReasonPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode9;
import su.catlean.client.types.mappings.SpeedMineRenderModeWhenMappings;
import su.catlean.mixins.accessors.InteractionManagerAccessor;

public class SpeedMineModule extends Module {

    public static final SpeedMineModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 timingSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 rebreakSetting;
    private static final VisibleVisibleSettingPropertyImpl awaitAutoCrystalSetting;
    private static final VisibleVisibleSettingPropertyImpl instantAsyncSetting;
    private static final VisibleVisibleSettingPropertyImpl doubleMineSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 doubleMinePacketOrderSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 startModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 switchModeSetting;
    private static final VisibleVisibleSettingPropertyImpl swapDelaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 swapTimingSetting;
    private static final RangeVisibleSettingPropertyImpl2 factorSetting;
    private static final RangeVisibleSettingPropertyImpl2 speedSetting;
    private static final VisibleVisibleSettingPropertyImpl rotateSetting;
    private static final VisibleVisibleSettingPropertyImpl awaitSetting;
    private static final VisibleVisibleSettingPropertyImpl phaseSetting;
    private static final VisibleVisibleSettingPropertyImpl resetOnSwitchSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pauseEatSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 renderGroupSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 renderModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 selectionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 startColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 endColorSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static BlockPos blockPos;
    private static BlockPos blockPos2;
    private static AtomicBoolean atomicBoolean;
    private static LinkedList linkedList;
    private static ConcurrentHashMap concurrentHashMap;
    private static String textValue;

    private SpeedMineModule() {
        super("speed-mine", SubCategoriesKt.getPlayerUtilityCategory());
    }

    public SpeedMineMode getMode() {
        return (SpeedMineMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public SpeedMineTimingMode getTiming() {
        return (SpeedMineTimingMode) timingSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public SpeedMineRebreakMode getRebreak() {
        return (SpeedMineRebreakMode) rebreakSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getAwaitAutoCrystal() {
        return (Boolean) awaitAutoCrystalSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getInstantAsync() {
        return (Boolean) instantAsyncSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    public boolean getDoubleMine() {
        return (Boolean) doubleMineSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private SpeedMineDoubleMinePacketOrderMode getDoubleMinePacketOrder() {
        return (SpeedMineDoubleMinePacketOrderMode) doubleMinePacketOrderSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private SpeedMineStartMode getStartMode() {
        return (SpeedMineStartMode) startModeSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    public SpeedMineSwitchMode getSwitchMode() {
        return (SpeedMineSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getSwapDelay() {
        return (Boolean) swapDelaySetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private SpeedMineSwapTimingMode getSwapTiming() {
        return (SpeedMineSwapTimingMode) swapTimingSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private float getFactor() {
        return (Number) factorSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private float getSpeed() {
        return (Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getRotate() {
        return (Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getAwait() {
        return (Boolean) awaitSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private boolean getPhase() {
        return (Boolean) phaseSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    public boolean getResetOnSwitch() {
        return (Boolean) resetOnSwitchSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private SpeedMinePauseEatMode getPauseEat() {
        return (SpeedMinePauseEatMode) pauseEatSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private SettingGroup getRenderGroup() {
        return (SettingGroup) renderGroupSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private SpeedMineRenderMode getRenderMode() {
        return (SpeedMineRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private SpeedMineSelectionMode getSelection() {
        return (SpeedMineSelectionMode) selectionSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    private Color getStartColor() {
        return (Color) startColorSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private Color getEndColor() {
        return (Color) endColorSetting.getValue(this, DELEGATED_PROPERTIES[22]);
    }

    public AtomicBoolean getAtomicBoolean() {
        return atomicBoolean;
    }

    public void executeAction(AtomicBoolean value) {
        atomicBoolean = value;
    }

    public LinkedList getLinkedList() {
        return linkedList;
    }

    public void executeAction(LinkedList value) {
        linkedList = value;
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 37449534539012L);
        this.executeAction(OptionMode9.TOGGLE);
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 6194460963406L);
        this.executeAction(OptionMode9.TOGGLE);
    }

    private void executeAction(OptionMode9 arg0) {
        Iterable var7 = (Iterable) linkedList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var10 = iterator.next();
            ReasonPacketHelper var11 = (ReasonPacketHelper) var10;
            int var12 = 0;
            var11.executeAction(arg0);
        }
        linkedList.clear();
        blockPos = null;
        atomicBoolean.set(0);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var21) {
        }
        if (SharedKt.getPlayer().method_31549().field_7477 || var21) {
            return;
        }
        if (atomicBoolean.get()) {
            if (var21) {
                if (this.getPauseEat() == SpeedMinePauseEatMode.PAUSE) {
                    return;
                }
                if (var21) {
                }
                if (this.getPauseEat() == SpeedMinePauseEatMode.RESET) {
                    this.executeAction(OptionMode9.EATING);
                }
            }
        }
        if (var21) {
            if (this.getMode() == SpeedMineMode.DAMAGE && (InteractionManagerAccessor) SharedKt.getInteractionManager().getCurBlockDamageMP() < this.getSpeed()) {
            }
            (InteractionManagerAccessor) SharedKt.getInteractionManager().setCurBlockDamageMP(this.getSpeed());
        }
        Iterator iterator = (Map) concurrentHashMap.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var23 = (Entry) iterator.next();
            if (var21) {
                if (var21) {
                    if ((SharedKt.getNumericValue() - (Number) var23.getValue().longValue()) <= 200L) {
                        if (var21) {
                        }
                    }
                    concurrentHashMap.remove(var23.getKey());
                }
            }
        }
        linkedList.removeIf(this::checkCondition);
    }

    private void onUpdateBlockBreakingProgressEvent(UpdateBlockBreakingProgressEvent arg0) {
        arg0.cancel();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getMode() == SpeedMineMode.DAMAGE) {
            return;
        }
        Iterable var43 = (Iterable) linkedList;
        int var44 = 0;
        Iterator iterator = var43.iterator();
        if (iterator.hasNext()) {
            Object var46 = iterator.next();
            ReasonPacketHelper var47 = (ReasonPacketHelper) var46;
            int var48 = 0;
            if (!(var42)) {
            }
            if (!(var42)) {
                if (INSTANCE.getSelection() == SpeedMineSelectionMode.REBREAK) {
                    if (!(var42)) {
                        if (INSTANCE.getSelection() != SpeedMineSelectionMode.ALWAYS && INSTANCE.getRebreak() == SpeedMineRebreakMode.OFF) {
                        }
                    }
                    if (!(var42)) {
                    }
                }
                if (!(var42)) {
                    if (INSTANCE.getSelection() == SpeedMineSelectionMode.AIR_REBREAK && INSTANCE.getRebreak() != SpeedMineRebreakMode.OFF && SharedKt.getWorld().method_22347(var47.getMinecraftObject())) {
                    }
                    int var38 = 4;
                    Color var40 = PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getStartColor(), 1.0F);
                    Box var41 = new Box(var47.getMinecraftObject());
                    TextShaderComponent2.checkCondition();
                }
            }
            if (!(SharedKt.getWorld().method_22347(var47.getMinecraftObject()))) {
                float var49 = Math.clamp(PolygonShaderComponent.INSTANCE.computeValue(var47.getNumericValue2(), var47.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()), 0.0F, 1.0F);
                if (!(var42)) {
                    if (INSTANCE.getPauseEat() == SpeedMinePauseEatMode.PAUSE && SharedKt.getPlayer().method_6115()) {
                        var49 = var47.getNumericValue();
                    }
                }
                if (!(var42)) {
                    if (var47.getNumericValue() >= 1.0F) {
                        var49 = 1.0F;
                    }
                }
                NoWhenBranchMatchedException var50 = new NoWhenBranchMatchedException();
                TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getStartColor(), INSTANCE.getEndColor()));
                TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor(PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getStartColor(), 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getEndColor(), 1.0F)));
            }
        }
    }

    private void onAttackBlockEvent(AttackBlockEvent arg0) {
        if (!(var13)) {
        }
        if (!(this.checkCondition2(arg0.getPos())) || SharedKt.getPlayer().method_31549().field_7477 || !(var13)) {
            return;
        }
        this.executeAction(arg0.getPos(), arg0.getDirection());
    }

    public void executeAction(BlockPos pos, Direction direction) {
        if (!(var22)) {
        }
        if (!(this.checkCondition2(pos)) || SharedKt.getPlayer().method_31549().field_7477 || !(var22)) {
            return;
        }
        if (!(var22)) {
        }
        if (!(var22)) {
            if (!(var22)) {
                if (!((Collection) linkedList.isEmpty())) {
                }
            } else {
            }
            if (!(this.getDoubleMine()) && 0) {
                (ReasonPacketHelper) linkedList.removeFirst().executeAction();
            }
        }
        if (!(var22)) {
            if (!(var22)) {
                if (this.getDoubleMine() && linkedList.size() >= 2) {
                    Iterable var23 = (Iterable) linkedList;
                    int var24 = 0;
                    Iterator iterator = var23.iterator();
                    if (iterator.hasNext()) {
                        Object var26 = iterator.next();
                        ReasonPacketHelper var27 = (ReasonPacketHelper) var26;
                        int var28 = 0;
                    } else {
                    }
                    var24 = (ReasonPacketHelper) new NoSuchElementException("Collection contains no element matching the predicate.");
                    iterator = 0;
                    var24.executeAction();
                    linkedList.remove();
                }
                blockPos2 = pos;
            }
            if (!(var22)) {
            }
            if (linkedList.size() >= 2) {
            }
        }
        linkedList.add(new ReasonPacketHelper(pos, direction));
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        if (!(var17)) {
        }
        if (!(var17)) {
        }
        Iterator iterator = linkedList.iterator();
        ReasonPacketHelper var19 = (ReasonPacketHelper) iterator.next();
        if (!(var17)) {
        }
        if (!(var17)) {
        }
        if (this.checkCondition((class_2626) arg0.getPacket().method_11309())) {
            if (!(var17) && !(var17)) {
            }
        }
        var19.checkCondition(1);
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        if (var14) {
            if (var14) {
            }
        }
        if (var14) {
        }
        RunnableServiceComponent2.executeAction(0, 0, 0, this::executeAction);
    }

    private void onCollisionEvent(CollisionEvent arg0) {
        Map var8 = (Map) concurrentHashMap;
        int var9 = 0;
        Object var10 = var8;
        Map var11 = (Map) new LinkedHashMap();
        int var12 = 0;
        Iterator iterator = var10.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var14 = (Entry) iterator.next();
            Object var15 = var14;
            int var16 = 0;
            if (!(var6)) {
            }
            var11.put(var14.getKey(), var14.getValue());
        }
        Iterator iterator2 = var11.entrySet().iterator();
        var8 = (Entry) iterator2.next();
        if (!(var6)) {
        }
        arg0.setState(Blocks.AIR.method_9564());
    }

    public boolean checkCondition() {
        if (var7) {
        }
        if (this.getEnabled() && this.getPhase()) {
            Map var8 = (Map) concurrentHashMap;
            int var9 = 0;
            if (var7) {
                if (var8.isEmpty()) {
                }
            }
            Iterator iterator = var8.entrySet().iterator();
            if (iterator.hasNext()) {
                Entry var11 = (Entry) iterator.next();
                Object var12 = var11;
                int var13 = 0;
                if (var7) {
                    if ((SharedKt.getNumericValue() - (Number) var12.getValue().longValue()) < 200L) {
                    }
                } else {
                }
            } else {
            }
        }
        return false;
    }

    public boolean checkCondition(BlockPos blockPos) {
        Iterable var8 = (Iterable) linkedList;
        int var9 = 0;
        if (var8 instanceof Collection) {
            if (!(var7) && !(var7)) {
                if ((Collection) var8.isEmpty()) {
                }
            }
        }
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            ReasonPacketHelper var12 = (ReasonPacketHelper) var11;
            int var13 = 0;
        } else {
        }
        return false;
    }

    private void updateValue() {
        PacketPacketHelper.handlePacket((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763));
    }

    private float computeValue(BlockState arg0, BlockPos arg1, int arg2, boolean arg3) {
        if (!(var13)) {
            if (Intrinsics.areEqual(arg0, Blocks.AIR.method_9564())) {
                return 0.0F;
            }
        }
        float var14 = arg0.method_26214((class_1922) SharedKt.getWorld(), arg1);
        if (!(var13)) {
            if (var14 < 0.0F) {
                return 0.0F;
            }
        }
        if (arg2 == -1) {
        }
        ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(arg2);
        Object var15 = stack;
        if (!(var13)) {
            if (arg0.method_29291()) {
                if (var15.method_7951(arg0)) {
                }
            }
        } else {
        }
        return (30.0F / 100.0F);
    }

    private boolean checkCondition(BlockPos arg0) {
        if (!(var6)) {
        }
        if (!(var6)) {
            if (AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null && arg0.method_10264() > (AutoCrystalModule.INSTANCE.getTarget().getY() + 1)) {
            }
        } else {
        }
        return false;
    }

    private float computeValue(BlockState arg0, int arg1) {
        float var8 = 1.0F;
        if (!(var7)) {
        }
        if (arg1 != -1 && !(SharedKt.getPlayer().method_31548().method_5438(arg1).isEmpty())) {
            var8 = (var8 * SharedKt.getPlayer().method_31548().method_5438(arg1).method_7924(arg0));
        }
        return var8;
    }

    private float computeValue(BlockState arg0, int arg1, boolean arg2) {
        float var17 = this.computeValue(arg0, arg1);
        if (var17 > 1.0F) {
            if (!(var16) && !(var16)) {
                if (arg1 != -1) {
                    ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(arg1);
                    int var19 = StackServiceComponent3.computeValue(stack, class_1893.field_9131);
                    if (var19 > 0) {
                        if (!(var16) && !(var16)) {
                            if (!(stack.isEmpty())) {
                                var17 = (var17 + (StrictMath.pow(2.0D) + 1));
                            }
                        }
                    }
                }
            }
        }
        if (!(var16)) {
            if (SharedKt.getPlayer().method_6059(class_1294.field_5917)) {
                var17 = (var17 * (1 + ((SharedKt.getPlayer().method_6112(class_1294.field_5917).method_5578() + 1) * 0.2F)));
            }
        }
        if (!(var16)) {
            if (SharedKt.getPlayer().method_6059(class_1294.field_5901)) {
                var17 = (var17 * Math.pow(0.3F, (SharedKt.getPlayer().method_6112(class_1294.field_5901).method_5578() + 1)));
            }
        }
        if (!(var16)) {
            if (SharedKt.getPlayer().method_5869()) {
                var17 = (var17 * SharedKt.getPlayer().method_5996(class_5134.field_51576).method_6194());
            }
        }
        if (!(arg2)) {
            if (!(var16) && !(var16)) {
                if (!(FreeCamModule.INSTANCE.getEnabled())) {
                    var17 = (var17 / 5.0F);
                }
            }
            if (!(var16)) {
            }
            if (var17 < 0.0F) {
            }
        }
        return (var17 * this.getFactor());
    }

    private int computeValue(BlockPos arg0) {
        int var7 = this.computeValue(arg0, 1);
        if (var6) {
            if (var7 != -1) {
                return var7;
            }
        }
        return this.computeValue(arg0, 0);
    }

    private int computeValue(BlockPos arg0, boolean arg1) {
        int var14 = -1;
        if (arg1) {
        }
        float var15 = 1.4E-45F;
        BlockState state = SharedKt.getWorld().getBlockState(arg0);
        if (!(var13)) {
            if (state.getBlock() instanceof class_2189) {
                return -1;
            }
        }
        int var17 = 9;
        if (var17 < 45) {
            if (!(var13)) {
                if (!(var13)) {
                    if (var17 >= 36) {
                    }
                } else {
                }
                ItemStack stack = (var17 - 36).method_5438();
                if (!(var13)) {
                    if (!(var13)) {
                        if (!(stack.method_7951(state))) {
                            if (!(var13)) {
                                if (arg1) {
                                }
                            }
                        }
                    }
                    if (!(var13)) {
                        if ((stack.method_7936() - stack.method_7919()) <= 4) {
                            if (!(var13)) {
                                if (ToolSaverModule.INSTANCE.getEnabled()) {
                                    if (!(Intrinsics.areEqual(stack, ItemStack.field_8037)) && var13 && var13) {
                                    }
                                }
                            }
                        }
                        int var19 = (StackServiceComponent3.computeValue(stack, class_1893.field_9131) + stack.method_7924(SharedKt.getWorld().getBlockState(arg0)));
                        if (!(var13)) {
                            if (!(arg1)) {
                                if (!(var13)) {
                                    if (var19 > var15) {
                                        var15 = var19;
                                    }
                                    var14 = var17;
                                }
                            }
                            if (!(var13)) {
                                if (var13 && var19 < var15) {
                                    var15 = var19;
                                }
                                var14 = var17;
                            }
                        }
                    }
                }
            }
            if (!(var13)) {
                if (var14 >= 36) {
                }
            }
        } else {
        }
        }
        return var14;
    }

    private boolean checkCondition2(BlockPos arg0) {
        BlockState state = SharedKt.getWorld().getBlockState(arg0);
        if (!(var10)) {
            if (state.getBlock().method_36555() == -1.0F) {
            }
        } else {
        }
        if (!(var10)) {
            if (SharedKt.getPlayer().getEyePos().method_1022(arg0.toCenterPos()) > (SharedKt.getPlayer().method_55754() + 0.5F)) {
                if (!(var10)) {
                }
                if (!(var10)) {
                    if (!(0) && this.getDoubleMine() && !(Intrinsics.areEqual(arg0, blockPos2))) {
                    }
                }
            }
        } else {
        }
        return false;
    }

    private void executeAction(int arg0, int arg1) {
        if (this.getSwitchMode() != SpeedMineSwitchMode.Alternative) {
            if (var18) {
                if (arg0 >= 9) {
                }
            }
            if (var18) {
                if (arg1 == -1) {
                    if (var18) {
                        if (arg0 < 9) {
                        }
                    } else {
                    }
                    HandServiceComponent.e(arg0, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
                    if (!(var18)) {
                    }
                }
                if (var18) {
                    if (arg1 < 9) {
                    }
                } else {
                }
                HandServiceComponent.e(arg1, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
            }
            this.updateValue();
        }
        if (this.getSwitchMode() == SpeedMineSwitchMode.Silent) {
            ItemPacketHelper.INSTANCE.executeAction2(arg0);
            if (!(var18) && !(var18)) {
            }
            ItemPacketHelper.INSTANCE.executeAction(arg0);
        }
        AutoCrystalModule.INSTANCE.getAtomicBoolean().set(0);
        atomicBoolean.set(0);
    }

    public boolean checkCondition2() {
        if (var5) {
            if (this.getDoubleMine()) {
                if (var5) {
                    if (linkedList.size() > 1) {
                    }
                }
            } else {
            }
            if (var5) {
                if (!((Collection) linkedList.isEmpty())) {
                }
            } else {
            }
            if (var5) {
                if ((ReasonPacketHelper) CollectionsKt.first(linkedList).getNumericValue2() == -1.0F) {
                }
            } else {
            }
        }
        return !(0);
    }

    public List resolveList(boolean targetAfter) {
        if (var11) {
            if (linkedList.isEmpty()) {
                return CollectionsKt.emptyList();
            }
        }
        if (var11) {
            if (linkedList.size() == 1) {
                ReasonPacketHelper var13 = (ReasonPacketHelper) CollectionsKt.first(linkedList);
                int var14 = 0;
                if (0L > 0) {
                    if (INSTANCE.checkCondition()) {
                        return CollectionsKt.listOf(var13.getMinecraftObject());
                    }
                }
                if (0L > 0) {
                }
            }
            if (var11) {
            }
            if (!(var11) && linkedList.size() == 2) {
                var13 = (Iterable) linkedList;
                var14 = 0;
                Iterator iterator = var13.iterator();
                if (iterator.hasNext()) {
                    Object var16 = iterator.next();
                    ReasonPacketHelper var17 = (ReasonPacketHelper) var16;
                    int var18 = 0;
                } else {
                }
                ReasonPacketHelper var12 = (ReasonPacketHelper) new NoSuchElementException("Collection contains no element matching the predicate.");
                if (0L >= 0 && var11) {
                    if (this.checkCondition()) {
                        var13 = new BlockPos[2];
                        var13[0] = (ReasonPacketHelper) CollectionsKt.first(linkedList).getMinecraftObject();
                        var13[1] = var12.getMinecraftObject();
                        return CollectionsKt.listOf();
                    }
                }
            }
        }
        if (!(serviceComponent10.checkCondition(200)) && blockPos != null && targetAfter) {
            return CollectionsKt.listOf(blockPos);
        }
        return CollectionsKt.emptyList();
    }

    public static List resolveList(SpeedMineModule arg0, boolean arg1, int arg2, Object arg3) {
        if (var9) {
            if ((arg2 & 1)) {
            }
            arg1 = 1;
        }
        return arg0.resolveList(arg1);
    }

    private boolean checkCondition(ReasonPacketHelper arg0) {
        if (!(var6)) {
        }
        if (!(var6)) {
        }
        if (!(var6)) {
            if (arg0.getNumericValue() < 1.0F && (arg0.getNumericValue() + ((arg0.getNumericValue() - arg0.getNumericValue2()) * 2.5F)) >= 1.0F && !(SharedKt.getWorld().method_22347(arg0.getMinecraftObject()))) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive() {
        if (var7) {
        }
        if (var7) {
            if (INSTANCE.getMode() != SpeedMineMode.DAMAGE && INSTANCE.getRotate()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive3() {
        if (!(var7)) {
        }
        return INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM;
    }

    private static boolean isActive4() {
        if (var7) {
        }
        return INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive6() {
        if (var7) {
        }
        if (var7) {
            if (INSTANCE.getMode() != SpeedMineMode.DAMAGE && INSTANCE.getDoubleMine()) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive7() {
        if (!(var7)) {
        }
        if (!(var7)) {
            if (INSTANCE.getMode() != SpeedMineMode.DAMAGE && !(INSTANCE.getDoubleMine())) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive8() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive9() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive10() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive11() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive12() {
        return INSTANCE.getMode() == SpeedMineMode.DAMAGE;
    }

    private static boolean isActive13() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive14() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive15() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive16() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive17() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive18() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive19() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive20() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive21() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive22() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean checkCondition(ReasonPacketHelper arg0) {
        return ReasonPacketHelper.checkCondition(arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static void executeAction() {
        Iterable var5 = (Iterable) linkedList;
        int var6 = 0;
        Iterator iterator = var5.iterator();
        if (iterator.hasNext()) {
            Object var8 = iterator.next();
            ReasonPacketHelper var9 = (ReasonPacketHelper) var8;
            int var10 = 0;
            var9.executeAction(OptionMode9.SWITCH);
        }
    }

    public static int computeValue(SpeedMineModule $this, BlockPos pos) {
        return $this.computeValue(pos);
    }

    public static SpeedMineSwapTimingMode resolveSpeedMineSwapTimingMode(SpeedMineModule $this) {
        return $this.getSwapTiming();
    }

    public static void executeAction(SpeedMineModule $this, int slot, int from) {
        $this.executeAction(slot, from);
    }

    public static SpeedMineDoubleMinePacketOrderMode resolveSpeedMineDoubleMinePacketOrderMode(SpeedMineModule $this) {
        return $this.getDoubleMinePacketOrder();
    }

    public static SpeedMineStartMode resolveSpeedMineStartMode(SpeedMineModule $this) {
        return $this.getStartMode();
    }

    public static boolean checkCondition(SpeedMineModule $this) {
        return $this.getSwapDelay();
    }

    public static BlockPos getMinecraftObject() {
        return blockPos2;
    }

    public static boolean checkCondition(SpeedMineModule $this, BlockPos pos) {
        return $this.checkCondition2(pos);
    }

    public static SpeedMinePauseEatMode resolveSpeedMinePauseEatMode(SpeedMineModule $this) {
        return $this.getPauseEat();
    }

    public static float computeValue(SpeedMineModule $this, BlockState state, BlockPos position, int slot, boolean ground) {
        return $this.computeValue(state, position, slot, ground);
    }

    public static ConcurrentHashMap getConcurrentHashMap() {
        return concurrentHashMap;
    }

    public static boolean checkCondition2(SpeedMineModule $this) {
        return $this.getAwait();
    }

    public static boolean checkCondition(SpeedMineModule $this) {
        return $this.getRotate();
    }

    public static boolean checkCondition(SpeedMineModule $this, BlockPos bp) {
        return $this.checkCondition(bp);
    }

    public static boolean checkCondition3(SpeedMineModule $this) {
        return $this.getAwaitAutoCrystal();
    }

    public static ServiceComponent10 getServiceComponent10() {
        return serviceComponent10;
    }

    public static void updateValue(BlockPos value) {
        blockPos = value;
    }

    static {
        KProperty[] var51 = new KProperty[23];
        INSTANCE = new SpeedMineModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpeedMineMode.PACKET);
        timingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timing", SpeedMineTimingMode.SEQUENTIAL, null, this::isActive);
        rebreakSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rebreak", SpeedMineRebreakMode.OFF, null, this::isActive2);
        awaitAutoCrystalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "await-auto-crystal", 1, null, this::isActive3);
        instantAsyncSetting = VisibleRenderHelper.registerSetting(INSTANCE, "instant-async", 1, null, this::isActive4);
        doubleMineSetting = VisibleRenderHelper.registerSetting(INSTANCE, "double-mine", 0, null, this::isActive5);
        doubleMinePacketOrderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-order", SpeedMineDoubleMinePacketOrderMode.NEW, null, this::isActive6);
        startModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "start-mode", SpeedMineStartMode.ABORT, null, this::isActive7);
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-mode", SpeedMineSwitchMode.Alternative, null, this::isActive8);
        swapDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "1.21", 0, null, this::isActive9);
        swapTimingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-timing", SpeedMineSwapTimingMode.ONCE, null, this::isActive10);
        factorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "factor", 1.0F, RangesKt.rangeTo(0.5F, 2.0F), null, this::isActive11);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 0.5F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive12);
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", 1, null, this::isActive13);
        awaitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "await", 1, null, this::isActive14);
        phaseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "phase", 1, null, this::isActive15);
        resetOnSwitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reset-on-switch", 1, null, this::isActive16);
        pauseEatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-eating", SpeedMinePauseEatMode.NONE, null, this::isActive17);
        renderGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render", null, this::isActive18);
        renderModeSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(INSTANCE, "render-mode", SpeedMineRenderMode.Shrink, INSTANCE.getRenderGroup(), this::isActive19);
        selectionSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(INSTANCE, "selection", SpeedMineSelectionMode.AIR_REBREAK, INSTANCE.getRenderGroup(), this::isActive20);
        startColorSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl9(INSTANCE, "start", new Color(255, 0, 0, 200), INSTANCE.getRenderGroup(), this::isActive21);
        endColorSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl9(INSTANCE, "end", new Color(47, 255, 0, 200), INSTANCE.getRenderGroup(), this::isActive22);
        serviceComponent10 = new ServiceComponent10();
        atomicBoolean = new AtomicBoolean(0);
        linkedList = new LinkedList();
        concurrentHashMap = new ConcurrentHashMap();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
