package su.catlean.client.services.network;

import net.minecraft.class_239.class_240;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_6880;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class ElytraDurabilityPacketHelper implements Contract6 {

    public static final ElytraDurabilityPacketHelper INSTANCE;
    private static boolean enabledFlag;
    private static float factorValue;
    private static float factorValue2;

    private ElytraDurabilityPacketHelper() {
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    public void executeAction(PreSyncEvent e) {
        long var4 = (0L ^ 108052155071832L);
        long var6 = ((0L ^ 102830384802247L) >>> 32);
        long var7 = (((0L ^ 102830384802247L) << 32) >>> 40);
        long var8 = (((0L ^ 102830384802247L) << 56) >>> 56);
        long var9 = (0L ^ 93229743192781L);
        long var11 = (0L ^ 95510200616042L);
        ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
        SharedKt.getPlayer().method_36457(factorValue2);
        if (0L > 0L) {
        }
        if (0L >= 0L) {
        }
        TitleRenderHelper.executeAction("Elytra+", ElytraPlusModule.INSTANCE.resolveString("elytra-durability", new Object[0]), 2, OptionMode16.WARNING);
        ClientPlayerEntity player = SharedKt.getPlayer();
        int var16 = 0;
        SharedKt.getWorld().method_8465(player, player.getX(), player.getY(), player.getZ(), (class_6880) class_3417.field_15152, class_3419.field_15256, 10.0F, 1.0F);
    }

    public void executeAction(PreElytraEvent e) {
        long var4 = (0L ^ 79805115683167L);
        ElytraPlusModule.INSTANCE.updateValue3(SharedKt.getPlayer().method_36455());
        SharedKt.getPlayer().method_36457(factorValue2);
    }

    public void executeAction(AfterElytraEvent e) {
        long var4 = (0L ^ 18213801518595L);
        SharedKt.getPlayer().method_36457(ElytraPlusModule.INSTANCE.getNumericValue3());
    }

    public void executeAction(MoveEvent e) {
    }

    public void executeAction(AfterSendPacket event) {
    }

    public void executeAction(ReceivePacket e) {
    }

    public void executeAction(PlayerUpdateEvent e) {
        int var5 = (((0L << 32) | ((0L << 48) >>> 32)) | ((0L << 48) >>> 48));
        long var7 = ((var5 ^ 73283691515063L) >>> 48);
        long var8 = (((var5 ^ 73283691515063L) << 16) >>> 48);
        long var9 = (((var5 ^ 73283691515063L) << 32) >>> 32);
        factorValue2 = this.computeValue();
    }

    public void executeAction(char arg0, int arg1, short arg2) {
        int var4 = (((arg0 << 48) | ((arg1 << 32) >>> 16)) | ((arg2 << 48) >>> 48));
        long var6 = (var4 ^ 16238893981878L);
        long var8 = (var4 ^ 99743207150509L);
        long var10 = (var4 ^ 96087070894725L);
        if (SharedKt.getPlayer().getY() < ElytraPlusModule.INSTANCE.getInfiniteMaxHeight()) {
            ElytraPlusModule.INSTANCE.updateValue();
        }
        enabledFlag = 0;
    }

    public void updateValue() {
    }

    public void executeAction(FireWorkVelocityEvent e) {
    }

    public void onSetPoseEvent(SetPoseEvent e) {
    }

    public void executeAction(ReceivePacket e) {
    }

    private float computeValue(char arg0, short arg1) {
        if (SharedKt.getPlayer().getY() < ElytraPlusModule.INSTANCE.getInfiniteMaxHeight()) {
            if (arg1 >= 0) {
                if (var15 == null) {
                    if ((EventPacketHelper2.INSTANCE.getNumericValue() * 72.0F) < 25.0F && !(enabledFlag)) {
                        enabledFlag = 1;
                    }
                }
            }
            if (arg0 >= 0) {
                if ((EventPacketHelper2.INSTANCE.getNumericValue() * 72.0F) > 150.0F && enabledFlag) {
                    enabledFlag = 0;
                } else {
                    enabledFlag = 1;
                }
            }
        }
        if (enabledFlag) {
            factorValue = (factorValue + 3.0F);
        } else {
            factorValue = (factorValue - 3.0F);
        }
        class_3965 var16 = SharedKt.getWorld().method_17742(new class_3959(SharedKt.getPlayer().getEyePos(), SharedKt.getPlayer().getEyePos().method_1031((SharedKt.getPlayer().method_18798().field_1352 * 10.0D), (SharedKt.getPlayer().method_18798().field_1351 * 10.0D), (SharedKt.getPlayer().method_18798().field_1350 * 10.0D)), class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
        if (var16.method_17783() == class_240.field_1332) {
            SharedKt.getPlayer().method_36457(-33.0F);
            ElytraPlusModule.executeAction();
        }
        factorValue = Math.clamp(factorValue, -40.0F, 40.0F);
        return factorValue;
    }

    static {
        INSTANCE = new ElytraDurabilityPacketHelper();
    }

}
