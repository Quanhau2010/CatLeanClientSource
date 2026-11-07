package su.catlean.client.features.modules.utility.misc;

import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_156;
import net.minecraft.class_156.class_158;
import net.minecraft.class_2561;
import net.minecraft.class_2663;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl4;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent59;
import su.catlean.client.services.client.ServiceComponent65;
import su.catlean.client.services.client.TextServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoEzModule extends Module {

    public static final AutoEzModule INSTANCE;
    private static final File file;
    private static final File file2;
    private static final DefaultValueVisibleSettingPropertyImpl4 notationSetting;
    private static final DefaultValueVisibleSettingPropertyImpl openFileSetting;
    private static final DefaultValueVisibleSettingPropertyImpl openFileTotemSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final SettingIdVisibleSettingPropertyImpl whisperPrefixSetting;
    private static final ServiceComponent10 serviceComponent10;
    private static long timestampValue2;
    private static List itemList;
    private static List itemList2;

    private AutoEzModule() {
        super("auto-ez", SubCategoriesKt.getMiscUtilityCategory());
    }

    private TextServiceComponent getNotation() {
        return (TextServiceComponent) notationSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setNotation(TextServiceComponent value) {
        notationSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private ActionServiceComponent2 getOpenFile() {
        return (ActionServiceComponent2) openFileSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setOpenFile(ActionServiceComponent2 value) {
        openFileSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private ActionServiceComponent2 getOpenFileTotem() {
        return (ActionServiceComponent2) openFileTotemSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setOpenFileTotem(ActionServiceComponent2 value) {
        openFileTotemSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private AutoEzMode getMode() {
        return (AutoEzMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setMode(AutoEzMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private String getWhisperPrefix() {
        return (String) whisperPrefixSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setWhisperPrefix(String value) {
        whisperPrefixSetting.setValue(this, DELEGATED_PROPERTIES[4], value);
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 49075368866138L);
        itemList2 = this.resolveList(file);
        itemList = this.resolveList(file2);
    }

    private void onTickEvent(TickEvent arg0) {
        if (var14 == null) {
            if (!(this.checkCondition())) {
                return;
            }
        }
        if (!((SharedKt.getPlayer().field_6012 % 60))) {
            if (file.exists()) {
                if (var14 == null && var14 == null && var14 == null) {
                    if (file.lastModified() > timestampValue) {
                        itemList2 = this.resolveList(file);
                        timestampValue = file.lastModified();
                    }
                }
            }
        }
        if (var14 == null) {
        }
        if (var14 == null) {
            if (var14 == null) {
            }
            if (!((SharedKt.getPlayer().field_6012 % 60)) && file2.exists() && file2.lastModified() > timestampValue2) {
                itemList = this.resolveList(file2);
            }
            timestampValue2 = file2.lastModified();
        }
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
        if (!(Intrinsics.areEqual(player, AutoCrystalModule.INSTANCE.getTarget()))) {
            if (var14 == null && var14 == null) {
            }
        }
        if (var14 == null) {
            if (!(player.method_29504())) {
            }
        }
        this.executeAction(player.method_7334().name(), itemList2);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (var10 == null) {
        }
        if (var10 == null) {
            if (var10 == null) {
            }
            if ((class_2663) arg0.getPacket().method_11470() != 3) {
                if (var10 == null) {
                    if ((class_2663) arg0.getPacket().method_11470() == 60) {
                    }
                }
                if ((class_2663) arg0.getPacket().method_11469((World) SharedKt.getWorld()) != null) {
                    Entity entity = (class_2663) arg0.getPacket().method_11469((World) SharedKt.getWorld());
                    int var12 = 0;
                    if (!(Intrinsics.areEqual(entity, AutoCrystalModule.INSTANCE.getTarget()))) {
                        if (var10 == null && var10 == null) {
                        }
                    }
                    if (Intrinsics.areEqual(entity, AuraModule.INSTANCE.getTarget()) && entity instanceof PlayerEntity) {
                        INSTANCE.executeAction(String.valueOf((PlayerEntity) entity.method_5477().method_54160()), itemList2);
                    }
                } else {
                }
            }
            if (var10 == null) {
            }
        }
        if ((class_2663) arg0.getPacket().method_11469((World) SharedKt.getWorld()) != null) {
            entity = (class_2663) arg0.getPacket().method_11469((World) SharedKt.getWorld());
            var12 = 0;
            if (var10 == null) {
                if (!(Intrinsics.areEqual(entity, AutoCrystalModule.INSTANCE.getTarget()))) {
                }
                if (Intrinsics.areEqual(entity, AuraModule.INSTANCE.getTarget())) {
                }
                INSTANCE.executeAction(String.valueOf(entity.method_5477().method_54160()), itemList);
            }
        } else {
        }
    }

    private void executeAction(String arg0, List arg1) {
        TeamCommunicationModule.INSTANCE.getAtomicBoolean().set(1);
        if (var21 == null) {
            if (var21 == null) {
                if (!((Collection) arg1.isEmpty())) {
                }
            } else {
            }
            if (serviceComponent10.checkCondition(450) && 0) {
                String var22 = StringsKt.replace$default(StringsKt.replace$default((String) CollectionsKt.random((Collection) arg1, (Random) Random.Default), "%name%", arg0), "%count%", String.valueOf(EntityPacketHelper.INSTANCE.computeValue(arg0)));
                if (var21 == null) {
                    if (StringsKt.startsWith$default("/")) {
                        Object var23 = var22;
                        int var24 = 0;
                        int var25 = 1;
                        var22 = StringsKt.removeRange((CharSequence) var23).toString();
                        SharedKt.getNetwork().method_45730();
                    }
                }
                SharedKt.getNetwork().method_45729((var22));
                SharedKt.getNetwork().method_45729();
                SharedKt.getNetwork().method_45730((this.getWhisperPrefix() + arg0 + var22));
                MessageServiceComponent.S(this);
                if (var21 != null && var21 != null && var21 != null && var21 != null && var21 != null) {
                }
                serviceComponent10.executeAction();
            }
        }
        if (var21 != null && arg1.isEmpty()) {
            MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "empty", new Object[0]));
        }
        TeamCommunicationModule.INSTANCE.getAtomicBoolean().set(0);
    }

    private List resolveList(File arg0) {
        if (var4 == null) {
            if (arg0.createNewFile()) {
                return CollectionsKt.emptyList();
            }
        }
        Object var5 = arg0;
        Object var6 = var5;
        int var7 = 0;
        if (var4 == null) {
            if (!(var6.exists())) {
                var6.createNewFile();
            }
        }
        var5 = (Iterable) FilesKt.readLines$default(null, 1, null);
        var6 = 0;
        var7 = var5;
        Collection var8 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var9 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            String var12 = (String) var11;
            Object var14 = var8;
            int var13 = 0;
            var14.add(StringsKt.trim((CharSequence) var12).toString());
            if (var4 == null) {
            }
            var5 = (Iterable) var8;
            var6 = 0;
            var7 = var5;
            var8 = (Collection) new ArrayList();
            var9 = 0;
        }
        iterator = var7.iterator();
        if (iterator.hasNext()) {
            var11 = iterator.next();
            var12 = (String) var11;
            var13 = 0;
            if (var4 == null) {
                if (!(StringsKt.isBlank((CharSequence) var12))) {
                }
            } else {
            }
            if (var4 == null) {
            }
            var8.add();
        }
        return var8;
    }

    private static Unit getUnit() {
        File var3 = file;
        Object var4 = var3;
        class_158 var6 = class_156.method_668();
        int var5 = 0;
        if (var2 == null) {
            if (!(var4.exists())) {
                var4.createNewFile();
            }
            var6.method_672();
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        File var3 = file2;
        Object var4 = var3;
        class_158 var6 = class_156.method_668();
        int var5 = 0;
        if (var2 == null) {
            if (!(var4.exists())) {
                var4.createNewFile();
            }
            var6.method_672();
        }
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == AutoEzMode.WHISPERS;
    }

    static {
        KProperty[] var39 = new KProperty[5];
        INSTANCE = new AutoEzModule();
        file = new File(ServiceComponent65.getFile(), "autoez.txt");
        file2 = new File(ServiceComponent65.getFile(), "autoez_totem.txt");
        int var35 = 12;
        TextServiceComponent var38 = new TextServiceComponent("%name% will be replaced with player name");
        notationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "notation");
        openFileSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-death", this::getUnit);
        openFileTotemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-totem-pop", this::getUnit2);
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", AutoEzMode.GLOBAL);
        whisperPrefixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefix", "msg", null, this::isActive);
        serviceComponent10 = new ServiceComponent10();
        itemList = CollectionsKt.emptyList();
        itemList2 = CollectionsKt.emptyList();
    }

}
