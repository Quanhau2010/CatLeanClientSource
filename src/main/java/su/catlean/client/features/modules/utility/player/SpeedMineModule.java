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
        return ((SpeedMineMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public SpeedMineTimingMode getTiming() {
        return ((SpeedMineTimingMode) timingSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public SpeedMineRebreakMode getRebreak() {
        return ((SpeedMineRebreakMode) rebreakSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getAwaitAutoCrystal() {
        return ((Boolean) awaitAutoCrystalSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getInstantAsync() {
        return ((Boolean) instantAsyncSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    public boolean getDoubleMine() {
        return ((Boolean) doubleMineSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private SpeedMineDoubleMinePacketOrderMode getDoubleMinePacketOrder() {
        return ((SpeedMineDoubleMinePacketOrderMode) doubleMinePacketOrderSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private SpeedMineStartMode getStartMode() {
        return ((SpeedMineStartMode) startModeSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    public SpeedMineSwitchMode getSwitchMode() {
        return ((SpeedMineSwitchMode) switchModeSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getSwapDelay() {
        return ((Boolean) swapDelaySetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private SpeedMineSwapTimingMode getSwapTiming() {
        return ((SpeedMineSwapTimingMode) swapTimingSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private float getFactor() {
        return ((Number) factorSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private float getSpeed() {
        return ((Number) speedSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private boolean getRotate() {
        return ((Boolean) rotateSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private boolean getAwait() {
        return ((Boolean) awaitSetting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private boolean getPhase() {
        return ((Boolean) phaseSetting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    public boolean getResetOnSwitch() {
        return ((Boolean) resetOnSwitchSetting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private SpeedMinePauseEatMode getPauseEat() {
        return ((SpeedMinePauseEatMode) pauseEatSetting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private SettingGroup getRenderGroup() {
        return ((SettingGroup) renderGroupSetting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private SpeedMineRenderMode getRenderMode() {
        return ((SpeedMineRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private SpeedMineSelectionMode getSelection() {
        return ((SpeedMineSelectionMode) selectionSetting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    private Color getStartColor() {
        return ((Color) startColorSetting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private Color getEndColor() {
        return ((Color) endColorSetting.getValue(this, DELEGATED_PROPERTIES[22]));
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

    public void updateValue2() {
        this.executeAction(OptionMode9.TOGGLE);
    }

    public void updateValue() {
        this.executeAction(OptionMode9.TOGGLE);
    }

    private void executeAction(OptionMode9 arg0) {
        Iterable iterable = ((Iterable) linkedList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
            reasonPacketHelper.executeAction(arg0);
        }
        linkedList.clear();
        blockPos = null;
        atomicBoolean.set(false);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().method_31549().field_7477 || SharedKt.getPlayer().method_6115()) {
            return;
        }
        if (this.getMode() == SpeedMineMode.DAMAGE && ((InteractionManagerAccessor) SharedKt.getInteractionManager()).getCurBlockDamageMP() < this.getSpeed()) {
            ((InteractionManagerAccessor) SharedKt.getInteractionManager()).setCurBlockDamageMP(this.getSpeed());
        }
        Iterator iterator = ((Map) concurrentHashMap).entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            if ((SharedKt.getNumericValue() - ((Number) entry.getValue()).longValue()) <= 200L) {
            }
            concurrentHashMap.remove(entry.getKey());
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
        Iterable iterable = ((Iterable) linkedList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
            if (INSTANCE.getSelection() == SpeedMineSelectionMode.REBREAK) {
                if (INSTANCE.getSelection() != SpeedMineSelectionMode.ALWAYS && INSTANCE.getRebreak() == SpeedMineRebreakMode.OFF) {
                    if (INSTANCE.getSelection() == SpeedMineSelectionMode.AIR_REBREAK && INSTANCE.getRebreak() != SpeedMineRebreakMode.OFF && SharedKt.getWorld().method_22347(reasonPacketHelper.getMinecraftObject())) {
                        int index = 4;
                        Color color = PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getStartColor(), 1.0F);
                        Box box = new Box(reasonPacketHelper.getMinecraftObject());
                        TextShaderComponent2.checkCondition(box, color, index);
                    }
                }
            }
            if (!(SharedKt.getWorld().method_22347(reasonPacketHelper.getMinecraftObject()))) {
                float factor = Math.clamp(PolygonShaderComponent.INSTANCE.computeValue(reasonPacketHelper.getNumericValue2(), reasonPacketHelper.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()), 0.0F, 1.0F);
                if (INSTANCE.getPauseEat() == SpeedMinePauseEatMode.PAUSE && SharedKt.getPlayer().method_6115()) {
                    factor = reasonPacketHelper.getNumericValue();
                }
                if (reasonPacketHelper.getNumericValue() >= 1.0F) {
                    factor = 1.0F;
                }
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                TextShaderComponent2.checkCondition(noWhenBranchMatchedException, PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getStartColor(), INSTANCE.getEndColor(), factor));
                TextShaderComponent2.checkCondition(noWhenBranchMatchedException, PolygonShaderComponent.INSTANCE.resolveColor(PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getStartColor(), 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getEndColor(), 1.0F), factor));
            }
        }
    }

    private void onAttackBlockEvent(AttackBlockEvent arg0) {
        if (!(this.checkCondition2(arg0.getPos())) || SharedKt.getPlayer().method_31549().field_7477 || this.getMode() == SpeedMineMode.DAMAGE) {
            return;
        }
        arg0.cancel();
        this.executeAction(arg0.getPos(), arg0.getDirection());
    }

    public void executeAction(BlockPos pos, Direction direction) {
        if (!(__UNDEF_KEY__)) {
        }
        if (!(this.checkCondition2(pos)) || SharedKt.getPlayer().method_31549().field_7477 || !(__UNDEF_KEY__)) {
            return;
        }
        if (!(__UNDEF_KEY__)) {
        }
        if (!(__UNDEF_KEY__)) {
            if (!(__UNDEF_KEY__)) {
                if (!(((Collection) linkedList).isEmpty())) {
                } else {
                }
            }
            if (!(this.getDoubleMine()) && 0) {
                ((ReasonPacketHelper) linkedList.removeFirst()).executeAction();
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (!(__UNDEF_KEY__)) {
                if (this.getDoubleMine() && linkedList.size() >= 2) {
                    Iterable iterable = ((Iterable) linkedList);
                    int index = 0;
                    Iterator iterator = iterable.iterator();
                    while (iterator.hasNext()) {
                        Object element = iterator.next();
                        ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
                    }
                    index = ((ReasonPacketHelper) new NoSuchElementException("Collection contains no element matching the predicate."));
                    iterator = 0;
                    index.executeAction();
                    linkedList.remove(index);
                }
                blockPos2 = pos;
                if (!(__UNDEF_KEY__)) {
                    if (linkedList.size() >= 2) {
                    }
                }
            }
        }
        linkedList.add(new ReasonPacketHelper(pos, direction));
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) iterator.next());
            if (this.checkCondition(((class_2626) arg0.getPacket()).method_11309())) {
            }
            reasonPacketHelper.checkCondition(true);
        }
    }

    private void onAfterSendPacket(AfterSendPacket arg0) {
        RunnableServiceComponent2.executeAction(0, 0, false, this::executeAction);
    }

    private void onCollisionEvent(CollisionEvent arg0) {
        Map map = ((Map) concurrentHashMap);
        Map map2 = ((Map) new LinkedHashMap());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            map2.put(entry.getKey(), entry.getValue());
        }
        Iterator iterator2 = map2.entrySet().iterator();
        while (iterator2.hasNext()) {
            map = ((Entry) iterator2.next());
            arg0.setState(Blocks.AIR.method_9564());
        }
    }

    public boolean checkCondition() {
        if (this.getEnabled() && this.getPhase()) {
            Map map = ((Map) concurrentHashMap);
            if (map.isEmpty()) {
            }
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry entry = ((Entry) iterator.next());
            }
        }
        return false;
    }

    public boolean checkCondition(BlockPos blockPos) {
        Iterable iterable = ((Iterable) linkedList);
        if (iterable instanceof Collection) {
            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                if (((Collection) iterable).isEmpty()) {
                }
            }
        }
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
        }
        return false;
    }

    private void updateValue() {
        PacketPacketHelper.handlePacket(((Packet) new class_2815(SharedKt.getPlayer().field_7512.field_7763)));
    }

    private float computeValue(BlockState arg0, BlockPos arg1, int arg2, boolean arg3) {
        if (Intrinsics.areEqual(arg0, Blocks.AIR.method_9564())) {
            return 0.0F;
        }
        float factor = arg0.method_26214(((class_1922) SharedKt.getWorld()), arg1);
        if (factor < 0.0F) {
            return 0.0F;
        }
        if (arg2 == -1) {
        }
        ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(arg2);
        if (arg0.method_29291()) {
            if (stack.method_7951(arg0)) {
            } else {
            }
        }
        return (30.0F / 100.0F);
    }

    private boolean checkCondition(BlockPos arg0) {
        if (AutoCrystalModule.INSTANCE.getEnabled() && AutoCrystalModule.INSTANCE.getTarget() != null && arg0.method_10264() > (AutoCrystalModule.INSTANCE.getTarget().getY() + 1)) {
        } else {
        }
        return false;
    }

    private float computeValue(BlockState arg0, int arg1) {
        float factor = 1.0F;
        if (!(__UNDEF_KEY__)) {
        }
        if (arg1 != -1 && !(SharedKt.getPlayer().method_31548().method_5438(arg1).isEmpty())) {
            factor = (factor * SharedKt.getPlayer().method_31548().method_5438(arg1).method_7924(arg0));
        }
        return factor;
    }

    private float computeValue(BlockState arg0, int arg1, boolean arg2) {
        float factor = this.computeValue(arg0, arg1);
        if (factor > 1.0F) {
            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                if (arg1 != -1) {
                    ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(arg1);
                    int index = StackServiceComponent3.computeValue(stack, class_1893.field_9131);
                    if (index > 0) {
                        if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                            if (!(stack.isEmpty())) {
                                factor = (factor + (StrictMath.pow(index, 2.0D) + 1));
                            }
                        }
                    }
                }
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getPlayer().method_6059(class_1294.field_5917)) {
                factor = (factor * (1 + ((SharedKt.getPlayer().method_6112(class_1294.field_5917).method_5578() + 1) * 0.2F)));
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getPlayer().method_6059(class_1294.field_5901)) {
                factor = (factor * Math.pow(0.3F, (SharedKt.getPlayer().method_6112(class_1294.field_5901).method_5578() + 1)));
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getPlayer().method_5869()) {
                factor = (factor * SharedKt.getPlayer().method_5996(class_5134.field_51576).method_6194());
            }
        }
        if (!(arg2)) {
            if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                if (!(FreeCamModule.INSTANCE.getEnabled())) {
                    factor = (factor / 5.0F);
                }
                if (!(__UNDEF_KEY__)) {
                    if (factor < 0.0F) {
                    }
                }
            }
        }
        return (factor * this.getFactor());
    }

    private int computeValue(BlockPos arg0) {
        int index = this.computeValue(arg0, true);
        if (__UNDEF_KEY__) {
            if (index != -1) {
                return index;
            }
        }
        return this.computeValue(arg0, false);
    }

    private int computeValue(BlockPos arg0, boolean arg1) {
        int index = -1;
        if (arg1) {
        }
        float factor = 1.4E-45F;
        BlockState state = SharedKt.getWorld().getBlockState(arg0);
        if (!(__UNDEF_KEY__)) {
            if (state.getBlock() instanceof class_2189) {
                return -1;
            }
        }
        int index2 = 9;
        if (index2 < 45) {
            if (!(__UNDEF_KEY__)) {
                if (!(__UNDEF_KEY__)) {
                    if (index2 >= 36) {
                    } else {
                    }
                }
                ItemStack stack = (index2 - 36).method_5438(index2);
                if (!(__UNDEF_KEY__)) {
                    if (!(__UNDEF_KEY__)) {
                        if (!(stack.method_7951(state))) {
                            if (!(__UNDEF_KEY__)) {
                                if (arg1) {
                                }
                            }
                        }
                    }
                    if (!(__UNDEF_KEY__)) {
                        if ((stack.method_7936() - stack.method_7919()) <= 4) {
                            if (!(__UNDEF_KEY__)) {
                                if (ToolSaverModule.INSTANCE.getEnabled()) {
                                    if (!(Intrinsics.areEqual(stack, ItemStack.field_8037)) && __UNDEF_KEY__ && __UNDEF_KEY__) {
                                        int index3 = (StackServiceComponent3.computeValue(stack, class_1893.field_9131) + stack.method_7924(SharedKt.getWorld().getBlockState(arg0)));
                                        if (!(__UNDEF_KEY__)) {
                                            if (!(arg1)) {
                                                if (!(__UNDEF_KEY__)) {
                                                    if (index3 > factor) {
                                                        factor = index3;
                                                        index = index2;
                                                        if (!(__UNDEF_KEY__)) {
                                                            if (__UNDEF_KEY__ && index3 < factor) {
                                                                factor = index3;
                                                                index = index2;
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
                if (!(__UNDEF_KEY__)) {
                    if (index >= 36) {
                    } else {
                    }
                }
            } else {
            }
        }
        return index;
    }

    private boolean checkCondition2(BlockPos arg0) {
        BlockState state = SharedKt.getWorld().getBlockState(arg0);
        if (!(__UNDEF_KEY__)) {
            if (state.getBlock().method_36555() == -1.0F) {
            } else {
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getPlayer().getEyePos().method_1022(arg0.toCenterPos()) > (SharedKt.getPlayer().method_55754() + 0.5F)) {
                if (!(__UNDEF_KEY__)) {
                }
                if (!(__UNDEF_KEY__)) {
                    if (!(0) && this.getDoubleMine() && !(Intrinsics.areEqual(arg0, blockPos2))) {
                    } else {
                    }
                }
            }
        }
        return false;
    }

    private void executeAction(int arg0, int arg1) {
        if (this.getSwitchMode() != SpeedMineSwitchMode.Alternative) {
            if (arg0 >= 9) {
                if (arg1 == -1) {
                    if (arg0 < 9) {
                    } else {
                    }
                    HandServiceComponent.e(arg0, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
                }
                if (arg1 < 9) {
                } else {
                }
                HandServiceComponent.e(arg1, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
                this.updateValue();
            }
        }
        if (this.getSwitchMode() == SpeedMineSwitchMode.Silent) {
            ItemPacketHelper.INSTANCE.executeAction2(arg0);
        }
        ItemPacketHelper.INSTANCE.executeAction(arg0);
        AutoCrystalModule.INSTANCE.getAtomicBoolean().set(false);
        atomicBoolean.set(false);
    }

    public boolean checkCondition2() {
        if (this.getDoubleMine()) {
            if (linkedList.size() > 1) {
            }
        } else {
            if (((ReasonPacketHelper) CollectionsKt.first(linkedList)).getNumericValue2() == -1.0F) {
            } else {
            }
        }
        return !(0);
    }

    public List resolveList(boolean targetAfter) {
        if (linkedList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) CollectionsKt.first(linkedList));
        if (__UNDEF_KEY__ > 0) {
            if (INSTANCE.checkCondition(reasonPacketHelper)) {
                return CollectionsKt.listOf(reasonPacketHelper.getMinecraftObject());
            }
        }
        if (__UNDEF_KEY__ > 0) {
        }
        if (!(__UNDEF_KEY__) && linkedList.size() == 2) {
            reasonPacketHelper = ((Iterable) linkedList);
            Iterator iterator = reasonPacketHelper.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                ReasonPacketHelper reasonPacketHelper2 = ((ReasonPacketHelper) element);
            }
            ReasonPacketHelper reasonPacketHelper3 = ((ReasonPacketHelper) new NoSuchElementException("Collection contains no element matching the predicate."));
            if (__UNDEF_KEY__ >= 0) {
                reasonPacketHelper = new BlockPos[2];
                reasonPacketHelper[0] = ((ReasonPacketHelper) CollectionsKt.first(linkedList)).getMinecraftObject();
                reasonPacketHelper[1] = reasonPacketHelper3.getMinecraftObject();
                return CollectionsKt.listOf(reasonPacketHelper);
            }
        }
        if (!(serviceComponent10.checkCondition(200)) && blockPos != null && targetAfter) {
            return CollectionsKt.listOf(blockPos);
        }
        return CollectionsKt.emptyList();
    }

    public static List resolveList(SpeedMineModule arg0, boolean arg1, int arg2, Object arg3) {
        arg1 = 1;
        return arg0.resolveList(arg1);
    }

    private boolean checkCondition(ReasonPacketHelper arg0) {
        if (arg0.getNumericValue() < 1.0F && (arg0.getNumericValue() + ((arg0.getNumericValue() - arg0.getNumericValue2()) * 2.5F)) >= 1.0F && !(SharedKt.getWorld().method_22347(arg0.getMinecraftObject()))) {
        } else {
        }
        return false;
    }

    private static boolean isActive() {
        if (INSTANCE.getMode() != SpeedMineMode.DAMAGE) {
        } else {
        }
        return false;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive3() {
        return INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM;
    }

    private static boolean isActive4() {
        return INSTANCE.getRebreak() == SpeedMineRebreakMode.GRIM;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() != SpeedMineMode.DAMAGE;
    }

    private static boolean isActive6() {
        if (INSTANCE.getMode() != SpeedMineMode.DAMAGE) {
        } else {
        }
        return false;
    }

    private static boolean isActive7() {
        if (INSTANCE.getMode() != SpeedMineMode.DAMAGE && !(INSTANCE.getDoubleMine())) {
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
        return ReasonPacketHelper.checkCondition(arg0, false);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static void executeAction() {
        Iterable iterable = ((Iterable) linkedList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ReasonPacketHelper reasonPacketHelper = ((ReasonPacketHelper) element);
            reasonPacketHelper.executeAction(OptionMode9.SWITCH);
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
        KProperty[] items = new KProperty[23];
        INSTANCE = new SpeedMineModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpeedMineMode.PACKET);
        timingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "timing", SpeedMineTimingMode.SEQUENTIAL, null, this::isActive);
        rebreakSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rebreak", SpeedMineRebreakMode.OFF, null, this::isActive2);
        awaitAutoCrystalSetting = VisibleRenderHelper.registerSetting(INSTANCE, "await-auto-crystal", true, null, this::isActive3);
        instantAsyncSetting = VisibleRenderHelper.registerSetting(INSTANCE, "instant-async", true, null, this::isActive4);
        doubleMineSetting = VisibleRenderHelper.registerSetting(INSTANCE, "double-mine", false, null, this::isActive5);
        doubleMinePacketOrderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-order", SpeedMineDoubleMinePacketOrderMode.NEW, null, this::isActive6);
        startModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "start-mode", SpeedMineStartMode.ABORT, null, this::isActive7);
        switchModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "switch-mode", SpeedMineSwitchMode.Alternative, null, this::isActive8);
        swapDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "1.21", false, null, this::isActive9);
        swapTimingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "swap-timing", SpeedMineSwapTimingMode.ONCE, null, this::isActive10);
        factorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "factor", 1.0F, RangesKt.rangeTo(0.5F, 2.0F), null, this::isActive11);
        speedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "speed", 0.5F, RangesKt.rangeTo(0.0F, 1.0F), null, this::isActive12);
        rotateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rotate", true, null, this::isActive13);
        awaitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "await", true, null, this::isActive14);
        phaseSetting = VisibleRenderHelper.registerSetting(INSTANCE, "phase", true, null, this::isActive15);
        resetOnSwitchSetting = VisibleRenderHelper.registerSetting(INSTANCE, "reset-on-switch", true, null, this::isActive16);
        pauseEatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "on-eating", SpeedMinePauseEatMode.NONE, null, this::isActive17);
        renderGroupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render", null, this::isActive18);
        renderModeSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(INSTANCE, "render-mode", SpeedMineRenderMode.Shrink, INSTANCE.getRenderGroup(), this::isActive19);
        selectionSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl10(INSTANCE, "selection", SpeedMineSelectionMode.AIR_REBREAK, INSTANCE.getRenderGroup(), this::isActive20);
        startColorSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl9(INSTANCE, "start", new Color(255, 0, 0, 200), INSTANCE.getRenderGroup(), this::isActive21);
        endColorSetting = VisibleRenderHelper.resolveDefaultValueVisibleSettingPropertyImpl9(INSTANCE, "end", new Color(47, 255, 0, 200), INSTANCE.getRenderGroup(), this::isActive22);
        serviceComponent10 = new ServiceComponent10();
        atomicBoolean = new AtomicBoolean(false);
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
