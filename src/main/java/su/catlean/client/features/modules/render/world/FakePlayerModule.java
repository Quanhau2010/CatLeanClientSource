package su.catlean.client.features.modules.render.world;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297.class_5529;
import net.minecraft.class_1661;
import net.minecraft.class_1935;
import net.minecraft.class_2663;
import net.minecraft.class_2664;
import net.minecraft.class_5131;
import net.minecraft.class_745;
import net.minecraft.class_8109;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PreSyncEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.ServiceComponent130;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class FakePlayerModule extends Module {

    public static final FakePlayerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl recordButtonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl buttonSetting;
    private static final VisibleVisibleSettingPropertyImpl copyInventorySetting;
    private static final SettingIdVisibleSettingPropertyImpl nameSetting;
    private static class_745 minecraftRef;
    private static final List itemList;
    private static int countValue;
    private static boolean enabledFlag;
    private static boolean enabledFlag2;

    private FakePlayerModule() {
        super("fake-player", SubCategoriesKt.getWorldRenderCategory());
    }

    private ActionServiceComponent2 getRecordButton() {
        return (ActionServiceComponent2) recordButtonSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private ActionServiceComponent2 getButton() {
        return (ActionServiceComponent2) buttonSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getCopyInventory() {
        return (Boolean) copyInventorySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private String getName() {
        return (String) nameSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    public class_745 getMinecraftObject() {
        return minecraftRef;
    }

    public void updateValue(class_745 value) {
        minecraftRef = value;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
        long var5 = (arg0 ^ 124491995633628L);
        long var7 = (arg0 ^ 76517038092751L);
        long var9 = (arg0 ^ 69599493015750L);
        long var11 = (arg0 ^ 67464996320865L);
        if (SharedKt.getMc().player == null) {
            return;
        }
        minecraftRef = new class_745(SharedKt.getWorld(), new GameProfile(UUID.fromString("66123666-6666-6666-6666-613376666600"), this.getName()));
        minecraftRef.method_5719(SharedKt.getPlayer());
        if (this.getCopyInventory()) {
            minecraftRef.method_6122(Hand.field_5808, SharedKt.getPlayer().method_6047().method_7972());
            minecraftRef.method_6122(Hand.field_5810, SharedKt.getPlayer().method_6079().method_7972());
            int var14 = 4;
            int var15 = 0;
            if (var15 < var14) {
                int var16 = var15;
                int var17 = 0;
                minecraftRef.method_31548().method_5447((35 + var16), SharedKt.getPlayer().method_31548().method_5438((35 + var16)).method_7972());
            }
            minecraftRef.method_6127().method_26846(SharedKt.getPlayer().method_6127());
        }
        SharedKt.getWorld().method_53875(minecraftRef);
        minecraftRef.method_6092(new class_1293(class_1294.field_5924, 9999, 2));
        minecraftRef.method_6092(new class_1293(class_1294.field_5898, 9999, 4));
        minecraftRef.method_6092(new class_1293(class_1294.field_5907, 9999, 1));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        class_745 var9 = minecraftRef;
        int var10 = 0;
        var9.method_48922(SharedKt.getWorld().method_48963().method_48830());
        var9.method_6033((var9.method_6032() + (var9.method_6067() - ExplosionPosEntityHelper.computeValue((class_2664) arg0.getPacket().comp_2883(), (PlayerEntity) var9))));
        if (arg0.getPacket() instanceof class_2664 && var9 != null && !(var9.field_6235) && var9.method_29504()) {
            var9.method_6033(10.0F);
            class_2663 var11 = new class_2663(minecraftRef, 35);
        }
    }

    private void onPreSyncEvent(PreSyncEvent arg0) {
        if (enabledFlag) {
            itemList.add(new ServiceComponent130(SharedKt.getPlayer().getX(), SharedKt.getPlayer().getY(), SharedKt.getPlayer().getZ(), SharedKt.getPlayer().method_36454(), SharedKt.getPlayer().method_36455()));
            return;
        }
        if (minecraftRef != null) {
            if (!((minecraftRef.field_6012 % 8))) {
                class_745 var13 = minecraftRef;
                var13.method_6033((var13.method_6032() + 0.5F));
            }
            Entity entity = minecraftRef;
            if (this.resolveMinecraftObject(entity).method_1025(this.resolveMinecraftObject(SharedKt.getPlayer())) > 400.0D) {
                this.updateValue2();
                return;
            }
            if (enabledFlag2 && !((Collection) itemList.isEmpty())) {
                var13 = countValue;
                countValue = (var13 + 1);
                if (countValue >= itemList.size()) {
                    countValue = 0;
                    return;
                }
                var13 = (ServiceComponent130) itemList.get(countValue);
                minecraftRef.method_36456(var13.getNumericValue());
                minecraftRef.method_36457(var13.getNumericValue2());
                minecraftRef.field_6241 = var13.getNumericValue();
                minecraftRef.method_43391(var13.getNumericValue(), var13.getNumericValue2(), var13.getNumericValue3());
                minecraftRef.method_66246(new Vec3d(var13.getNumericValue(), var13.getNumericValue2(), var13.getNumericValue3()), var13.getNumericValue(), var13.getNumericValue2());
            } else {
                countValue = 0;
            }
            minecraftRef.method_6122(Hand.field_5810, new ItemStack((class_1935) Items.field_8288));
        } else {
            this.updateValue2();
        }
    }

    public void updateValue2(long arg0) {
        if (minecraftRef == null) {
            return;
        }
        minecraftRef.method_31745(class_5529.field_26998);
        minecraftRef.method_36209();
        minecraftRef = null;
        itemList.clear();
    }

    private static Unit getUnit() {
        enabledFlag = !(enabledFlag);
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return !(enabledFlag2);
    }

    private static Unit getUnit2() {
        enabledFlag2 = !(enabledFlag2);
        return Unit.INSTANCE;
    }

    private static boolean isActive2() {
        return !(enabledFlag);
    }

    static {
        KProperty[] var30 = new KProperty[4];
        INSTANCE = new FakePlayerModule();
        recordButtonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "record-/-stop", this::getUnit, null, this::isActive);
        buttonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "play-/-stop", this::getUnit2, null, this::isActive2);
        copyInventorySetting = VisibleRenderHelper.registerSetting(INSTANCE, "copy-inventory");
        nameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "name", "OLD_GOD");
        itemList = new ArrayList();
    }

}
