package su.catlean.client.services.network;

import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_241;
import net.minecraft.class_2708;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract6;
import su.catlean.api.event.events.network.AfterSendPacket;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.AfterElytraEvent;
import su.catlean.api.event.events.player.MoveEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.player.PreElytraEvent;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.event.events.player.SetPoseEvent;
import su.catlean.api.event.events.world.FireWorkVelocityEvent;
import su.catlean.client.features.modules.movement.rage.ElytraPlusAntiKickMode;
import su.catlean.client.features.modules.movement.rage.ElytraPlusMode;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.types.mappings.ElytraPlusAntiKickModeWhenMappings;
import su.catlean.mixins.accessors.ClientInputAccessor;

public class EventPacketHelper4 implements Contract6 {

    public static final EventPacketHelper4 INSTANCE;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;
    private static float factorValue;
    private static ItemStack itemStack;
    private static ItemStack itemStack2;
    private static Item minecraftRef;
    private static Item minecraftRef2;
    private static int countValue;
    private static int countValue2;

    private EventPacketHelper4() {
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public boolean isActive2() {
        return enabledFlag2;
    }

    public void updateValue2(boolean value) {
        enabledFlag2 = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public ItemStack getMinecraftObject() {
        return itemStack;
    }

    public void updateValue(ItemStack value) {
        itemStack = value;
    }

    public ItemStack getMinecraftObject2() {
        return itemStack2;
    }

    public void updateValue2(ItemStack value) {
        itemStack2 = value;
    }

    public Item getMinecraftObject() {
        return minecraftRef;
    }

    public void executeAction(Item value) {
        minecraftRef = value;
    }

    public Item getMinecraftObject2() {
        return minecraftRef2;
    }

    public void executeAction(Item value) {
        minecraftRef2 = value;
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    public int getNumericValue2() {
        return countValue2;
    }

    public void updateValue2(int value) {
        countValue2 = value;
    }

    public long getNumericValue() {
        return timestampValue;
    }

    public void updateValue(long value) {
        timestampValue = value;
    }

    public void executeAction(PreSyncEvent e) {
        long var4 = (0L ^ 130258743495244L);
        long var6 = (0L ^ 45837667436396L);
        long var8 = (0L ^ 103154035415969L);
        long var10 = ((0L ^ 39778333166276L) >>> 32);
        long var11 = (((0L ^ 39778333166276L) << 32) >>> 32);
        long var13 = (0L ^ 95510200616042L);
        if (var15 == null) {
            if (ElytraPlusModule.INSTANCE.getRotate()) {
                if (SharedKt.getMc().options.field_1903.method_1434()) {
                    if (SharedKt.getPlayer().isFallFlying()) {
                        if (0L > 0L) {
                            if (var15 == null && var15 == null && var15 == null) {
                                if (enabledFlag) {
                                    SharedKt.getPlayer().method_36457(-45.0F);
                                }
                            }
                        }
                    }
                }
                if (0L >= 0L && var15 == null) {
                    if (var15 == null) {
                    }
                    if (0L > 0L) {
                    }
                    if (SharedKt.getMc().options.field_1832.method_1434() && SharedKt.getPlayer().isFallFlying() && enabledFlag) {
                        SharedKt.getPlayer().method_36457(45.0F);
                    }
                }
                SharedKt.getPlayer().method_36456(EventPacketHelper2.INSTANCE.computeValue());
            }
        }
        if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
            if (SharedKt.getMc().options.field_1903.method_1434()) {
                if (SharedKt.getPlayer().isFallFlying()) {
                    if (0L >= 0L) {
                        if (var15 == null && var15 == null && var15 == null && var15 == null) {
                            if (enabledFlag) {
                                SharedKt.getPlayer().method_36457(-90.0F);
                            }
                        }
                    }
                }
            }
        }
        if (0L > 0L && var15 == null) {
            if (var15 == null) {
            }
        }
        SharedKt.getPlayer().method_36457(-45.0F);
    }

    public void executeAction(PreElytraEvent e) {
        long var4 = (0L ^ 79805115683167L);
        if (var6 == null) {
            ElytraPlusModule.INSTANCE.updateValue3(SharedKt.getPlayer().method_36455());
        }
        SharedKt.getPlayer().method_36457(-45.0F);
    }

    public void executeAction(AfterElytraEvent e) {
        long var4 = (0L ^ 18213801518595L);
        SharedKt.getPlayer().method_36457(ElytraPlusModule.INSTANCE.getNumericValue3());
    }

    public void executeAction(MoveEvent e) {
        long var4 = (0L ^ 52389835191008L);
        long var6 = (0L ^ 116402100060533L);
        long var8 = (0L ^ 100790074306642L);
        long var10 = ((0L ^ 79012752166395L) >>> 32);
        long var11 = (((0L ^ 79012752166395L) << 32) >>> 48);
        long var12 = (((0L ^ 79012752166395L) << 48) >>> 48);
        long var13 = (0L ^ 101872121627510L);
        long var15 = (0L ^ 4452337967885L);
        long var17 = (0L ^ 123833832724325L);
        long var19 = (0L ^ 100179738131501L);
        long var21 = (0L ^ 16494758083782L);
        if (var23 == null) {
        }
        if (0L >= 0L) {
            if (var23 == null) {
            }
        }
        if (0L > 0L) {
            if (var23 == null) {
                if (!(SharedKt.getPlayer().field_5976)) {
                }
            }
            if (0L >= 0L) {
                if (var23 == null) {
                    if (SharedKt.getPlayer().field_5992) {
                    }
                    ElytraPlusModule.INSTANCE.updateValue(0.0F);
                    factorValue = 0.0F;
                }
            }
        }
        if (0L > 0L) {
            if (var23 == null) {
                if (EventPacketHelper2.INSTANCE.getNumericValue() < 4) {
                    e.setY(0.2D);
                    e.cancel();
                    return;
                }
            }
        }
        if (0L >= 0L) {
            if (var23 == null) {
                if (SharedKt.getMc().options.field_1903.method_1434()) {
                    int var25 = 9;
                    float var29 = ElytraPlusModule.INSTANCE.getYSpeed();
                    Object var28 = e;
                    int var26 = 0;
                    factorValue = (factorValue + var25);
                    float var31 = factorValue;
                    float var24 = (var31 / 100.0F);
                    var26 = 1.0D;
                    var28.setY((var29 * Math.min()));
                    if (0L >= 0L && var23 != null) {
                    }
                }
            }
            if (0L >= 0L && var23 == null) {
                if (SharedKt.getMc().options.field_1832.method_1434()) {
                    var25 = 9;
                    var29 = ElytraPlusModule.INSTANCE.getYSpeed();
                    var28 = e;
                    var26 = 0;
                    factorValue = (factorValue + var25);
                    var31 = factorValue;
                    var24 = (var31 / 100.0F);
                    var26 = 1.0D;
                    var28.setY((var29 * Math.min()));
                }
            }
            if (!((SharedKt.getPlayer().field_6012 % 2))) {
            }
            0.08D.setY(-0.08D);
            e.setY(-0.08D);
            e.setY(0.0D);
            if (0L >= 0L && var23 != null && 0L >= 0L && var23 != null && 0L >= 0L && var23 != null && 0L >= 0L && var23 != null) {
            }
        }
        if (0L > 0L) {
            if (var23 == null) {
                if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
                    ElytraPlusModule.INSTANCE.updateValue(0.0F);
                }
            }
        }
        if (0L >= 0L && var23 == null) {
            if (SharedKt.getPlayer().field_3913.method_3128().field_1343 > 0.0F) {
                (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241(1.0F, SharedKt.getPlayer().field_3913.method_3128().field_1342));
            }
            if (var23 == null) {
            }
            if (var23 != null && SharedKt.getPlayer().field_3913.method_3128().field_1343 < 0.0F) {
            }
            (ClientInputAccessor) SharedKt.getPlayer().field_3913.setMoveVector(new class_241(-1.0F, SharedKt.getPlayer().field_3913.method_3128().field_1342));
        }
        var25 = 9;
        float var30 = ElytraPlusModule.INSTANCE.getXzSpeed();
        var29 = e;
        var28 = EventPacketHelper2.INSTANCE;
        var26 = 0;
        ElytraPlusModule.INSTANCE.updateValue((ElytraPlusModule.INSTANCE.getNumericValue() + var25));
        float var32 = ElytraPlusModule.INSTANCE.getNumericValue();
        var24 = (var32 / 100.0F);
        var26 = 1.0D;
        new NoWhenBranchMatchedException().executeAction((var30 * Math.min()));
        if (0L >= 0L) {
            if (var23 == null) {
            }
            if (0L >= 0L) {
            }
            if (var23 == null) {
            }
        }
        if (ElytraPlusModule.INSTANCE.getStayMad() && !(this.checkCondition2()) && EventPacketHelper2.INSTANCE.getNumericValue() > 10) {
            e.setY(0.42D);
        }
        e.cancel();
    }

    public void executeAction(AfterSendPacket event) {
        long var4 = (0L ^ 100112727355052L);
        long var6 = (0L ^ 36138565521496L);
        this.executeAction(0);
    }

    private void executeAction(boolean arg0) {
        if (arg0) {
            if (var15 == null && var15 == null) {
                if ((System.currentTimeMillis() - timestampValue) < (ElytraPlusModule.INSTANCE.getFireDelay() * 1000.0F)) {
                    return;
                }
            }
        }
        if (arg0) {
            if (var15 == null && var15 == null) {
                if (!(SharedKt.getPlayer().isFallFlying())) {
                    return;
                }
            }
        }
        if (!(arg0)) {
            if (var15 == null && var15 == null) {
                if (EventPacketHelper2.INSTANCE.getNumericValue() > 1) {
                    return;
                }
            }
        }
        int var16 = this.computeValue();
        if (var15 == null) {
            if (var16 == -1) {
                countValue2 = -1;
                return;
            }
            countValue2 = var16;
        }
        boolean var17 = Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET);
        int var18 = SharedKt.getPlayer().method_31548().method_67532();
        if (!(var17)) {
            if (var15 == null && var15 == null) {
                if (var18 != var16) {
                    ItemPacketHelper.INSTANCE.executeAction();
                }
            }
        }
        if (var17) {
        }
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        if (!(var17)) {
            if (var15 == null && var15 == null) {
                if (var18 != var16) {
                    ItemPacketHelper.INSTANCE.executeAction();
                }
            }
        }
        enabledFlag = 1;
        timestampValue = System.currentTimeMillis();
    }

    public void executeAction(ReceivePacket e) {
        long var5 = ((0L << 16) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 3733546473051L);
        long var9 = (var5 ^ 32332956399917L);
        long var11 = ((var5 ^ 59965465244143L) >>> 32);
        long var12 = (((var5 ^ 59965465244143L) << 32) >>> 48);
        long var13 = (((var5 ^ 59965465244143L) << 48) >>> 48);
        long var14 = (var5 ^ 113746228604004L);
        if (var16 == null) {
            ElytraPlusModule.INSTANCE.updateValue(0.0F);
            factorValue = 0.0F;
            if (0L >= 0) {
                if (var16 == null) {
                }
            }
        }
        if (var16 == null) {
        }
        ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.flag-disable", new Object[0]));
    }

    public void executeAction(PlayerUpdateEvent e) {
        int var5 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var7 = (var5 ^ 110443321443084L);
        long var9 = (var5 ^ 137606229105562L);
        long var11 = (var5 ^ 17991996193528L);
        long var13 = (var5 ^ 58820124427973L);
        long var15 = (var5 ^ 87805362475745L);
        long var17 = (var5 ^ 77790739854221L);
        long var19 = (var5 ^ 75341532821871L);
        long var21 = (var5 ^ 46515859238589L);
        long var23 = ((var5 ^ 46251444692251L) >>> 32);
        long var24 = (((var5 ^ 46251444692251L) << 32) >>> 48);
        long var25 = (((var5 ^ 46251444692251L) << 48) >>> 48);
        long var26 = (var5 ^ 75690733423914L);
        boolean var29 = SharedKt.getWorld().method_22347(BlockPos.ofFloored(EntityHelper.resolveMinecraftObject(SharedKt.getPlayer())));
        if (var28 == null) {
        }
        if (0L >= 0) {
            if (var28 == null) {
            }
        }
        if (var28 == null) {
            if (this.checkCondition3() && var29 && SharedKt.getPlayer().method_18798().method_10214() < 0.0D) {
            }
        } else {
        }
        int var30 = 0;
        if (EventPacketHelper2.INSTANCE.getNumericValue() > 0.0D) {
            if (0L > 0) {
                if (var28 == null && var28 == null) {
                    if (!(var29)) {
                    }
                }
            }
            if (0L >= 0) {
                if (var28 == null) {
                    if (var30) {
                    }
                    this.updateValue5();
                }
            }
        }
        if (0L >= 0) {
            if (var28 == null) {
                if (var28 != null && SharedKt.getPlayer().isOnGround()) {
                    enabledFlag2 = 0;
                    return;
                }
            }
        }
        if (0L >= 0) {
            if (var28 == null) {
                if (!(EventPacketHelper2.INSTANCE.checkCondition())) {
                    ElytraPlusModule.INSTANCE.updateValue(0.0F);
                }
            }
        }
        if (0L >= 0) {
            if (var28 == null) {
                if (!(this.checkCondition())) {
                    return;
                }
            }
        }
        if (!(SharedKt.getPlayer().isFallFlying())) {
            if (!(enabledFlag2)) {
                if (var28 == null && var28 == null && 0L > 0 && var28 == null) {
                    if (SharedKt.getPlayer().method_18798().method_10214() < 0.0D) {
                        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
                        enabledFlag2 = 1;
                    }
                }
            }
        }
        if (EventPacketHelper2.INSTANCE.getNumericValue() < 4) {
            SharedKt.getMc().options.field_1903.method_23481(0);
        }
        this.executeAction(1);
    }

    public void executeAction(char arg0, int arg1, short arg2) {
        int var4 = (((arg0 << 48) | ((arg1 << 32) >>> 16)) | ((arg2 << 48) >>> 48));
        long var6 = (var4 ^ 91144016260959L);
        long var8 = (var4 ^ 76409422996716L);
        long var10 = (var4 ^ 128037284970081L);
        long var12 = ((var4 ^ 8237046633915L) >>> 48);
        long var13 = (((var4 ^ 8237046633915L) << 16) >>> 48);
        long var14 = (((var4 ^ 8237046633915L) << 32) >>> 32);
        long var15 = ((var4 ^ 83214263772695L) >>> 48);
        long var16 = (((var4 ^ 83214263772695L) << 16) >>> 32);
        long var17 = (((var4 ^ 83214263772695L) << 48) >>> 48);
        long var18 = (var4 ^ 96087070894725L);
        factorValue = 0.0F;
        countValue2 = -1;
        minecraftRef2 = Items.field_8162;
        itemStack2 = null;
        enabledFlag = 0;
        if (!(Intrinsics.areEqual(SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST).getItem(), Items.ELYTRA))) {
            if (var20 == null && var20 == null) {
                if (arg2 <= 0) {
                    if (var20 == null) {
                        if (!(Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), Items.ELYTRA)) && ItemPacketHelper.INSTANCE.computeValue() == -1) {
                            this.updateValue2();
                            return;
                        }
                    }
                }
            }
        }
        if (var20 == null) {
            if (this.computeValue(0) == -1) {
                this.executeAction();
                return;
            }
        }
        if (this.computeValue(1) != -1) {
            return;
        }
        itemStack2 = SharedKt.getPlayer().method_31548().method_5438((ElytraPlusModule.INSTANCE.getFireSlot() - 1)).method_7972();
        minecraftRef2 = SharedKt.getPlayer().method_31548().method_5438((ElytraPlusModule.INSTANCE.getFireSlot() - 1)).getItem();
        if (arg2 <= 0) {
        }
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 115322306114422L);
        long var5 = (arg0 ^ 85510088156605L);
        enabledFlag2 = 0;
        if (ElytraPlusModule.INSTANCE.getKeepFlying()) {
            return;
        }
        SharedKt.getPlayer().method_18800(0.0D, SharedKt.getPlayer().method_18798().method_10214(), 0.0D);
        new Thread(this::executeAction).start();
    }

    public void executeAction(FireWorkVelocityEvent e) {
    }

    public void onSetPoseEvent(SetPoseEvent e) {
    }

    public void executeAction(ReceivePacket e) {
    }

    private int computeValue(boolean arg0) {
        if (arg0) {
            Item[] var10 = new Item[1];
            var10[0] = Items.FIREWORK_ROCKET;
        } else {
            var10 = new Item[1];
            var10[0] = Items.FIREWORK_ROCKET;
        }
        return ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().getNumericValue();
    }

    private void executeAction() {
        ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.no-fireworks", new Object[0]));
        enabledFlag = 0;
    }

    private void updateValue2() {
        ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.no-elytra", new Object[0]));
        enabledFlag = 0;
    }

    private void executeAction(int arg0) {
        HandServiceComponent.e(arg0);
        HandServiceComponent.e(((ElytraPlusModule.INSTANCE.getFireSlot() - 1) + 36));
        HandServiceComponent.e(arg0);
    }

    private void updateValue3() {
        if (var10 == null) {
        }
        if (countValue2 == -1 || itemStack2 == null || Intrinsics.areEqual(minecraftRef2, Items.FIREWORK_ROCKET) || var10 == null) {
            return;
        }
        boolean var11 = Intrinsics.areEqual(minecraftRef2, Items.field_8162);
        if (var10 == null) {
        }
        if (var10 == null) {
            if (var11 < 9 && var11 != -1) {
            }
        } else {
        }
        HandServiceComponent.e();
        HandServiceComponent.e(((ElytraPlusModule.INSTANCE.getFireSlot() - 1) + 36));
        HandServiceComponent.e();
    }

    private void updateValue4() {
        countValue = -1;
        minecraftRef = Items.field_8162;
        itemStack = null;
    }

    private int computeValue(ItemStack arg0, Item arg1) {
        if (arg0 == null) {
            return -1;
        }
        int var8 = 0;
        if (var8 < 45) {
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
            if (var7 == null) {
                if (var7 == null) {
                    if (ItemStack.method_7984(stack, arg0)) {
                        if (var7 == null) {
                            if (!(Intrinsics.areEqual(stack.getItem(), arg1))) {
                            } else {
                            }
                            return var8;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private int computeValue(short arg0, long arg1) {
        if (var26 == null) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_6079().getItem(), Items.FIREWORK_ROCKET)) {
                return -2;
            }
        }
        int var27 = this.computeValue(1);
        int var28 = this.computeValue(0);
        if (arg1 >= 0L && var26 == null) {
            if (var28 == -1) {
                this.executeAction();
                return -1;
            }
            if (var26 == null) {
            }
            if (var27 == -1) {
                if (var26 == null) {
                    if (arg0 >= 0) {
                        if (!(ElytraPlusModule.INSTANCE.getAllowFireSwap())) {
                            ElytraPlusModule.INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("modules.common.no-fireworks", new Object[0]));
                            return (ElytraPlusModule.INSTANCE.getFireSlot() - 1);
                        }
                        this.executeAction();
                    }
                }
                return (ElytraPlusModule.INSTANCE.getFireSlot() - 1);
            }
        }
        return var27;
    }

    private boolean checkCondition() {
        if (var11 == null) {
            if (this.checkCondition()) {
                return false;
            }
        }
        if (var11 == null) {
            if (this.computeValue() != -1) {
            }
        } else {
        }
        return false;
    }

    private boolean checkCondition() {
        ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
        if (Intrinsics.areEqual(stack.getItem(), Items.ELYTRA)) {
            if (var7 == null && var7 == null) {
                if (!(ElytraPlusModule.INSTANCE.checkCondition(stack))) {
                }
            }
        } else {
        }
        return false;
    }

    private void updateValue5() {
        int var14 = ItemPacketHelper.INSTANCE.computeValue();
        if (var14 == -1) {
            if (var13 == null && var13 == null) {
                if (!(Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), Items.ELYTRA))) {
                    this.updateValue2();
                    return;
                }
            }
        }
        if (var13 == null) {
            if (!(this.checkCondition())) {
                return;
            }
        }
        if (var13 == null) {
            if (countValue == -1) {
                ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
                countValue = var14;
                minecraftRef = stack.getItem();
                itemStack = stack.method_7972();
            }
            HandServiceComponent.e();
            HandServiceComponent.e();
        }
        if (countValue != -1) {
            HandServiceComponent.e(countValue);
        }
        ElytraPlusModule.INSTANCE.updateValue2(1);
    }

    private void updateValue6() {
        if (var18 == null) {
            if (countValue != -1 && !(Intrinsics.areEqual(minecraftRef, Items.field_8162))) {
            }
            if (!(ElytraPlusModule.INSTANCE.isActive2())) {
                return;
            }
            ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(countValue);
            if (var18 == null) {
            }
            if (var18 == null) {
                if (!(Intrinsics.areEqual(stack, ItemStack.field_8037)) && !(ItemStack.method_7984(stack, itemStack))) {
                }
            } else {
            }
            int var20 = 0;
            int var21 = this.computeValue(itemStack, minecraftRef);
            if (var18 == null) {
            }
            if (var18 == null) {
                if (var21 < 9 && var21 != -1) {
                }
            } else {
            }
            if (var18 == null) {
                if (!(Intrinsics.areEqual(SharedKt.getPlayer().field_7512.method_34255().getItem(), Items.field_8162))) {
                    HandServiceComponent.e();
                    if (var18 == null) {
                    }
                    int var14 = 14;
                    int var15 = 0;
                    int var17 = 0;
                    HandServiceComponent.e(countValue);
                    return;
                }
            }
            if (var18 != null || countValue == -1 || var18 == null) {
                return;
            }
            var14 = 14;
            var15 = 0;
            var17 = -1;
            HandServiceComponent.e();
            if (var18 == null) {
                if (!(var20)) {
                    HandServiceComponent.e();
                    if (var18 != null) {
                    }
                }
                int var22 = this.computeValue();
                if (var22 != -1) {
                    HandServiceComponent.e();
                }
            }
        }
        this.updateValue4();
    }

    private int computeValue() {
        int var6 = 9;
        if (var6 < 45) {
            if (var5 == null) {
                if (var5 == null) {
                    if (SharedKt.getPlayer().method_31548().method_5438().isEmpty()) {
                    }
                    return var6;
                }
            }
        }
        return -1;
    }

    public boolean checkCondition2() {
        if (var7 == null) {
            if (SharedKt.getPlayer().getY() < 0.0D) {
                return false;
            }
        }
        if (var7 == null) {
            if (!(SharedKt.getWorld().method_20812(SharedKt.getPlayer(), SharedKt.getPlayer().method_5829().method_989(0.0D, -3.0D, 0.0D)).iterator().hasNext())) {
            }
        } else {
        }
        return false;
    }

    public boolean checkCondition3() {
        return SharedKt.getWorld().getBlockState(BlockPos.method_49637(SharedKt.getPlayer().getX(), (SharedKt.getPlayer().getY() - 0.1D), SharedKt.getPlayer().getZ())).getBlock() instanceof FluidBlock;
    }

    private static void executeAction() {
        PacketPacketHelper.handlePacket((Packet) new ClientCommandC2SPacket(SharedKt.getPlayer(), class_2849.field_12982));
        INSTANCE.updateValue3();
        countValue2 = -1;
        minecraftRef2 = Items.field_8162;
        itemStack2 = null;
        INSTANCE.updateValue6();
        INSTANCE.updateValue4();
    }

    static {
        INSTANCE = new EventPacketHelper4();
        minecraftRef = Items.field_8162;
        minecraftRef2 = Items.field_8162;
        countValue = -1;
        countValue2 = -1;
    }

}
