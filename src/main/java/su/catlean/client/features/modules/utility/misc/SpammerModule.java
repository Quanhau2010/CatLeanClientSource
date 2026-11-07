package su.catlean.client.features.modules.utility.misc;

import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import net.minecraft.class_156;
import net.minecraft.class_156.class_158;
import net.minecraft.class_640;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent65;
import su.catlean.client.services.client.ServiceComponent97;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class SpammerModule extends Module {

    public static final SpammerModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl openFileSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final SettingIdVisibleSettingPropertyImpl whisperPrefixSetting;
    private static final VisibleVisibleSettingPropertyImpl antiSpamSetting;
    private static final RangeVisibleSettingPropertyImpl2 delaySetting;
    private static final ServiceComponent10 serviceComponent10;
    private static List itemList;
    private static final File file;

    private SpammerModule() {
        super("spammer", SubCategoriesKt.getMiscUtilityCategory());
    }

    private ActionServiceComponent2 getOpenFile() {
        return ((ActionServiceComponent2) openFileSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setOpenFile(ActionServiceComponent2 value) {
        openFileSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private SpammerMode getMode() {
        return ((SpammerMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setMode(SpammerMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private String getWhisperPrefix() {
        return ((String) whisperPrefixSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setWhisperPrefix(String value) {
        whisperPrefixSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private boolean getAntiSpam() {
        return ((Boolean) antiSpamSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setAntiSpam(boolean value) {
        antiSpamSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private float getDelay() {
        return ((Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setDelay(float value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[4], Float.valueOf(value));
    }

    public void updateValue() {
        itemList = this.resolveList();
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent event) {
        if (!((SharedKt.getPlayer().field_6012 % 60))) {
            if (file.exists()) {
                if (__UNDEF_KEY__ && __UNDEF_KEY__ && __UNDEF_KEY__) {
                    if (file.lastModified() > timestampValue) {
                        itemList = this.resolveList();
                    }
                }
            }
        }
        if (__UNDEF_KEY__) {
            if (__UNDEF_KEY__) {
                if (!(((Collection) itemList).isEmpty())) {
                } else {
                }
            }
            if (serviceComponent10.checkCondition((this.getDelay() * 1000)) && 0) {
                if (__UNDEF_KEY__) {
                    if (this.getAntiSpam()) {
                    } else {
                    }
                }
                String text = ((this.resolveString()) + "");
                if (__UNDEF_KEY__) {
                    if (StringsKt.startsWith$default(text, "/", false)) {
                        int index = 0;
                        int index2 = 1;
                        text = StringsKt.removeRange(((CharSequence) text), index, index2).toString();
                        SharedKt.getNetwork().method_45730(text);
                    }
                }
                SharedKt.getNetwork().method_45729((text));
                SharedKt.getNetwork().method_45729(text);
                SharedKt.getNetwork().method_45730((this.getWhisperPrefix() + this.resolveString() + text));
                if (!(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__) && !(__UNDEF_KEY__)) {
                }
                serviceComponent10.executeAction();
            }
        }
        this.executeAction(MessageServiceComponent.Z(this, "empty", new Object[0], false));
    }

    private String resolveString() {
        return ((String) CollectionsKt.randomOrNull(((Collection) SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(((Iterable) SharedKt.getNetwork().method_2880())), this::resolveString), this::checkCondition))), ((Random) Random.Default)));
    }

    private String resolveString() {
        return ((Random.Default.nextInt(26) + 97) + Random.Default.nextInt(10) + (Random.Default.nextInt(26) + 97));
    }

    private List resolveList(int arg0, short arg1) {
        if (file.createNewFile()) {
            return CollectionsKt.emptyList();
        }
        timestampValue = file.lastModified();
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
            if (arg1 >= 0) {
                collection.add(StringsKt.trim(((CharSequence) text)).toString());
                file = ((Iterable) collection);
                file2 = 0;
                index = file;
                collection = ((Collection) new ArrayList());
            }
        }
        iterator = index.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            text = ((String) element);
            if (arg1 > 0) {
                collection.add(element);
            }
        }
        return collection;
    }

    private static Unit getUnit() {
        class_158 class158 = class_156.method_668();
        if (__UNDEF_KEY__) {
            if (!(file.exists())) {
                file.createNewFile();
            }
            class158.method_672(file);
        }
        return Unit.INSTANCE;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == SpammerMode.WHISPERS;
    }

    private static String resolveString(class_640 arg0) {
        return arg0.method_2966().name();
    }

    private static boolean checkCondition(String arg0) {
        return Pattern.matches("^\\w{3,16}$", ((CharSequence) arg0));
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new SpammerModule();
        openFileSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-file", this::getUnit);
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpammerMode.GLOBAL);
        whisperPrefixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefix", "msg", null, this::isActive);
        antiSpamSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-spam", false);
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 5.0F, RangesKt.rangeTo(0.0F, 30.0F));
        serviceComponent10 = new ServiceComponent10();
        itemList = CollectionsKt.emptyList();
        file = new File(ServiceComponent65.getFile(), "spammer.txt");
    }

}
