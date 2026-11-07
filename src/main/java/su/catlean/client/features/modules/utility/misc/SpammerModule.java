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
        return (ActionServiceComponent2) openFileSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setOpenFile(ActionServiceComponent2 value) {
        openFileSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private SpammerMode getMode() {
        return (SpammerMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setMode(SpammerMode value) {
        modeSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    private String getWhisperPrefix() {
        return (String) whisperPrefixSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private void setWhisperPrefix(String value) {
        whisperPrefixSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private boolean getAntiSpam() {
        return (Boolean) antiSpamSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setAntiSpam(boolean value) {
        antiSpamSetting.setValue(this, DELEGATED_PROPERTIES[3], Boolean.valueOf(value));
    }

    private float getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setDelay(float value) {
        delaySetting.setValue(this, DELEGATED_PROPERTIES[4], Float.valueOf(value));
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 80685729543634L) >>> 32);
        long var4 = (((arg0 ^ 80685729543634L) << 32) >>> 48);
        long var5 = (((arg0 ^ 80685729543634L) << 48) >>> 48);
        itemList = this.resolveList();
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent event) {
        if (!((SharedKt.getPlayer().field_6012 % 60))) {
            if (file.exists()) {
                if (var31 && var31 && var31) {
                    if (file.lastModified() > timestampValue) {
                        itemList = this.resolveList();
                    }
                }
            }
        }
        if (var31) {
            if (var31) {
                if (!((Collection) itemList.isEmpty())) {
                }
            } else {
            }
            if (serviceComponent10.checkCondition((this.getDelay() * 1000)) && 0) {
                if (var31) {
                    if (this.getAntiSpam()) {
                    }
                } else {
                }
                String var32 = ((this.resolveString()) + "");
                if (var31) {
                    if (StringsKt.startsWith$default("/")) {
                        Object var33 = var32;
                        int var34 = 0;
                        int var35 = 1;
                        var32 = StringsKt.removeRange((CharSequence) var33).toString();
                        SharedKt.getNetwork().method_45730();
                    }
                }
                SharedKt.getNetwork().method_45729((var32));
                SharedKt.getNetwork().method_45729();
                SharedKt.getNetwork().method_45730((this.getWhisperPrefix() + this.resolveString() + var32));
                if (!(var31) && !(var31) && !(var31) && !(var31)) {
                }
                serviceComponent10.executeAction();
            }
        }
        this.executeAction(MessageServiceComponent.Z(this, "empty", new Object[0]));
    }

    private String resolveString() {
        return (String) CollectionsKt.randomOrNull((Collection) SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) SharedKt.getNetwork().method_2880()), this::resolveString), this::checkCondition)), (Random) Random.Default);
    }

    private String resolveString() {
        return ((Random.Default.nextInt(26) + 97) + Random.Default.nextInt(10) + (Random.Default.nextInt(26) + 97));
    }

    private List resolveList(int arg0, short arg1) {
        if (var6) {
            if (file.createNewFile()) {
                return CollectionsKt.emptyList();
            }
            timestampValue = file.lastModified();
        }
        File var7 = file;
        Object var8 = var7;
        int var9 = 0;
        if (var6) {
            if (!(var8.exists())) {
                var8.createNewFile();
            }
        }
        var7 = (Iterable) FilesKt.readLines$default(null, 1, null);
        var8 = 0;
        var9 = var7;
        Collection var10 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var11 = 0;
        Iterator iterator = var9.iterator();
        if (iterator.hasNext()) {
            Object var13 = iterator.next();
            String var14 = (String) var13;
            if (arg1 >= 0) {
                Object var16 = var10;
                int var15 = 0;
                var16.add(StringsKt.trim((CharSequence) var14).toString());
                if (var6) {
                }
                var7 = (Iterable) var10;
                var8 = 0;
                var9 = var7;
                var10 = (Collection) new ArrayList();
                var11 = 0;
            }
        }
        iterator = var9.iterator();
        if (iterator.hasNext()) {
            var13 = iterator.next();
            var14 = (String) var13;
            var15 = 0;
            if (var6) {
                if (!(StringsKt.isBlank((CharSequence) var14))) {
                }
            } else {
            }
            if (arg1 > 0) {
                if (var6) {
                }
                var10.add();
            }
        }
        return var10;
    }

    private static Unit getUnit() {
        File var3 = file;
        Object var4 = var3;
        class_158 var6 = class_156.method_668();
        int var5 = 0;
        if (var2) {
            if (!(var4.exists())) {
                var4.createNewFile();
            }
            var6.method_672();
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
        return Pattern.matches("^\\w{3,16}$", (CharSequence) arg0);
    }

    static {
        KProperty[] var35 = new KProperty[5];
        INSTANCE = new SpammerModule();
        openFileSetting = VisibleRenderHelper.registerSetting(INSTANCE, "open-file", this::getUnit);
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", SpammerMode.GLOBAL);
        whisperPrefixSetting = VisibleRenderHelper.registerSetting(INSTANCE, "prefix", "msg", null, this::isActive);
        antiSpamSetting = VisibleRenderHelper.registerSetting(INSTANCE, "anti-spam");
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 5.0F, RangesKt.rangeTo(0.0F, 30.0F));
        serviceComponent10 = new ServiceComponent10();
        itemList = CollectionsKt.emptyList();
        file = new File(ServiceComponent65.getFile(), "spammer.txt");
    }

}
