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
        return ((TextServiceComponent) notationSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setNotation(TextServiceComponent value) {
        notationSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private ActionServiceComponent2 getOpenFile() {
        return ((ActionServiceComponent2) openFileSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setOpenFile(ActionServiceComponent2 value) {
        openFileSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private ActionServiceComponent2 getOpenFileTotem() {
        return ((ActionServiceComponent2) openFileTotemSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setOpenFileTotem(ActionServiceComponent2 value) {
        openFileTotemSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private AutoEzMode getMode() {
        return ((AutoEzMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setMode(AutoEzMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[3], value);
    }

    private String getWhisperPrefix() {
        return ((String) whisperPrefixSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setWhisperPrefix(String value) {
        whisperPrefixSetting.setValue(this, DELEGATED_PROPERTIES[4], value);
    }

    public void updateValue() {
        itemList2 = this.resolveList(file);
        itemList = this.resolveList(file2);
    }

    private void onTickEvent(TickEvent arg0) {
        if (!(this.checkCondition())) {
            return;
        }
        if (!((SharedKt.getPlayer().field_6012 % 60)) && file.exists() && file.lastModified() > timestampValue) {
            itemList2 = this.resolveList(file);
            timestampValue = file.lastModified();
        }
        if (!((SharedKt.getPlayer().field_6012 % 60)) && file2.exists() && file2.lastModified() > timestampValue2) {
            itemList = this.resolveList(file2);
            timestampValue2 = file2.lastModified();
        }
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            if (!(Intrinsics.areEqual(player, AutoCrystalModule.INSTANCE.getTarget()))) {
            }
            if (!(player.method_29504())) {
            }
            this.executeAction(player.method_7334().name(), itemList2);
        }
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (((class_2663) arg0.getPacket()).method_11470() != 3) {
            if (((class_2663) arg0.getPacket()).method_11470() == 60) {
                if (((class_2663) arg0.getPacket()).method_11469(((World) SharedKt.getWorld())) != null) {
                    Entity entity = ((class_2663) arg0.getPacket()).method_11469(((World) SharedKt.getWorld()));
                    if (!(Intrinsics.areEqual(entity, AutoCrystalModule.INSTANCE.getTarget()))) {
                    }
                    if (Intrinsics.areEqual(entity, AuraModule.INSTANCE.getTarget()) && entity instanceof PlayerEntity) {
                        INSTANCE.executeAction(String.valueOf(((PlayerEntity) entity).method_5477().method_54160()), itemList2);
                    }
                } else {
                }
            }
        }
        if (((class_2663) arg0.getPacket()).method_11469(((World) SharedKt.getWorld())) != null) {
            entity = ((class_2663) arg0.getPacket()).method_11469(((World) SharedKt.getWorld()));
            if (!(Intrinsics.areEqual(entity, AutoCrystalModule.INSTANCE.getTarget()))) {
                if (Intrinsics.areEqual(entity, AuraModule.INSTANCE.getTarget())) {
                    INSTANCE.executeAction(String.valueOf(entity.method_5477().method_54160()), itemList);
                }
            }
        } else {
        }
    }

    private void executeAction(String arg0, List arg1) {
        TeamCommunicationModule.INSTANCE.getAtomicBoolean().set(true);
        if (__UNDEF_KEY__ == null) {
            if (__UNDEF_KEY__ == null) {
                if (!(((Collection) arg1).isEmpty())) {
                } else {
                }
            }
            if (serviceComponent10.checkCondition(450) && 0) {
                String text = StringsKt.replace$default(StringsKt.replace$default(((String) CollectionsKt.random(((Collection) arg1), ((Random) Random.Default))), "%name%", arg0, false), "%count%", String.valueOf(EntityPacketHelper.INSTANCE.computeValue(arg0)), false);
                if (__UNDEF_KEY__ == null) {
                    if (StringsKt.startsWith$default(text, "/", false)) {
                        int index = 0;
                        int index2 = 1;
                        text = StringsKt.removeRange(((CharSequence) text), index, index2).toString();
                        SharedKt.getNetwork().method_45730(text);
                    }
                }
                SharedKt.getNetwork().method_45729((text));
                SharedKt.getNetwork().method_45729(text);
                SharedKt.getNetwork().method_45730((this.getWhisperPrefix() + arg0 + text));
                MessageServiceComponent.S(this, text, false);
                if (__UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null && __UNDEF_KEY__ != null) {
                }
                serviceComponent10.executeAction();
            }
        }
        if (__UNDEF_KEY__ != null && arg1.isEmpty()) {
            MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "empty", new Object[0], false), false);
        }
        TeamCommunicationModule.INSTANCE.getAtomicBoolean().set(false);
    }

    private List resolveList(File arg0) {
        if (arg0.createNewFile()) {
            return CollectionsKt.emptyList();
        }
        File file = arg0;
        File file2 = file;
        int index = 0;
        if (!(file2.exists())) {
            file2.createNewFile();
        }
        file = ((Iterable) FilesKt.readLines$default(file));
        file2 = 0;
        index = file;
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(file, 10)));
        Iterator iterator = index.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
            collection.add(StringsKt.trim(((CharSequence) text)).toString());
        }
        file = ((Iterable) collection);
        file2 = 0;
        index = file;
        collection = ((Collection) new ArrayList());
        iterator = index.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            text = ((String) element);
            if (!(StringsKt.isBlank(((CharSequence) text)))) {
            } else {
            }
            collection.add(element);
        }
        return collection;
    }

    private static Unit getUnit() {
        class_158 class158 = class_156.method_668();
        if (__UNDEF_KEY__ == null) {
            if (!(file.exists())) {
                file.createNewFile();
            }
            class158.method_672(file);
        }
        return Unit.INSTANCE;
    }

    private static Unit getUnit2() {
        class_158 class158 = class_156.method_668();
        if (__UNDEF_KEY__ == null) {
            if (!(file2.exists())) {
                file2.createNewFile();
            }
            class158.method_672(file2);
        }
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == AutoEzMode.WHISPERS;
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new AutoEzModule();
        file = new File(ServiceComponent65.getFile(), "autoez.txt");
        file2 = new File(ServiceComponent65.getFile(), "autoez_totem.txt");
        int index = 12;
        TextServiceComponent textServiceComponent = new TextServiceComponent("%name% will be replaced with player name");
        notationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "notation", textServiceComponent, index);
        openFileSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-death", this::getUnit);
        openFileTotemSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-totem-pop", this::getUnit2);
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", AutoEzMode.GLOBAL);
        whisperPrefixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefix", "msg", null, this::isActive);
        serviceComponent10 = new ServiceComponent10();
        itemList = CollectionsKt.emptyList();
        itemList2 = CollectionsKt.emptyList();
    }

}
