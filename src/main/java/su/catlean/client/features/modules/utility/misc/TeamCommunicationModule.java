package su.catlean.client.features.modules.utility.misc;

import com.mojang.authlib.GameProfile;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.class_2561;
import net.minecraft.class_2797;
import net.minecraft.class_640;
import net.minecraft.class_7439;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.WHITEServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class TeamCommunicationModule extends Module {

    public static final TeamCommunicationModule INSTANCE;
    private static final SettingIdVisibleSettingPropertyImpl xorKeySetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 sendCoordsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl2 tpHereSetting;
    private static final VisibleVisibleSettingPropertyImpl marryTpSetting;
    private static final AtomicBoolean atomicBoolean;

    private TeamCommunicationModule() {
        super("team-communication", SubCategoriesKt.getMiscUtilityCategory());
    }

    private String getXorKey() {
        return ((String) xorKeySetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private KeyRecord getSendCoords() {
        return ((KeyRecord) sendCoordsSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private KeyRecord getTpHere() {
        return ((KeyRecord) tpHereSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getMarryTp() {
        return ((Boolean) marryTpSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public AtomicBoolean getAtomicBoolean() {
        return atomicBoolean;
    }

    private void onSendPacket(SendPacket arg0) {
        if (atomicBoolean.get()) {
            return;
        }
        class_2797 class2797 = ((class_2797) arg0.getPacket());
        atomicBoolean.set(true);
        MessageServiceComponent.executeAction(this, this.resolveString(class2797.comp_945), true);
        atomicBoolean.set(false);
        arg0.cancel();
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() == this.getTpHere().getNumericValue()) {
            if (this.getMarryTp()) {
            } else {
            }
            MessageServiceComponent.executeAction("action_marry_tp", "action_tp", true);
        }
        MessageServiceComponent.executeAction(this, (this + SharedKt.getPlayer().getX() + "zCoord" + SharedKt.getPlayer().getZ() + "end"), true);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        class_7439 class7439 = ((class_7439) arg0.getPacket());
        String text = class7439.comp_763().getString();
        String text2 = this.resolveString(StringsKt.substringBefore$default(StringsKt.substringAfter$default(text, "cat_"), "_lean"));
        String text3 = this.resolveString2(text);
        if (Intrinsics.areEqual(text3, SharedKt.getPlayer().method_7334().name())) {
            return;
        }
        if (StringsKt.contains$default(((CharSequence) text2), ((CharSequence) "xCoord"), false)) {
            int index = Integer.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default(text2, "xCoord"), "zCoord"));
            int index2 = Integer.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default(text2, "zCoord"), "end"));
            WHITEServiceComponent.INSTANCE.updateValue(new BlockPos(index, 0, index2));
            return;
        }
        if (StringsKt.contains$default(((CharSequence) text2), ((CharSequence) "action_marry_tp"), false)) {
            PacketPacketHelper.executeAction(("marry tp " + text3));
            return;
        }
        if (StringsKt.contains$default(((CharSequence) text2), ((CharSequence) "action_tp"), false)) {
            PacketPacketHelper.executeAction(("tpa " + text3));
            return;
        }
        MessageServiceComponent.S(this, (text3 + ": " + text2), false);
        arg0.cancel();
    }

    public String resolveString(String input) {
        String text = input;
        byte[] items = text.getBytes(Charsets.UTF_8);
        String text2 = this.getXorKey();
        text = text2.getBytes(Charsets.UTF_8);
        text2 = new byte[items];
        int index = 0;
        if (index < items) {
            text2[index] = (items[index] ^ text[(index % text)]);
        }
        return ("!cat_" + this.resolveString(text2) + "_lean");
    }

    public String resolveString(String input) {
        byte[] items = this.process(input);
        String text = this.getXorKey();
        byte[] items2 = text.getBytes(Charsets.UTF_8);
        text = new byte[items];
        int index = 0;
        if (index < items) {
            text[index] = (items[index] ^ items2[(index % items2)]);
        }
        if (new String(text, Charsets.UTF_8) != null) {
        }
        return null;
    }

    public String resolveString(byte[] bytes) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(Base64.getEncoder().encodeToString(bytes), 43, 40, false), 47, 41, false), 61, 37, false);
    }

    public byte[] process(String string) {
        return Base64.getDecoder().decode(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, 40, 43, false), 41, 47, false), 37, 61, false));
    }

    public String resolveString2(String notSolved) {
        AtomicReference atomicReference = new AtomicReference("FATAL ERROR");
        Iterable iterable = ((Iterable) SharedKt.getNetwork().method_45732());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            class_640 class640 = ((class_640) element);
            if (__UNDEF_KEY__) {
                if (__UNDEF_KEY__) {
                    if (StringsKt.contains$default(((CharSequence) notSolved), ((CharSequence) class640.method_2966().name()), false)) {
                        atomicReference.set(class640.method_2966().name());
                    }
                }
            }
        }
        return ((String) atomicReference.get());
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new TeamCommunicationModule();
        xorKeySetting = VisibleRenderHelper.registerSetting(INSTANCE, "key", "catlean");
        sendCoordsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "send-coords", new KeyRecord(0, false, false));
        tpHereSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tp-here", new KeyRecord(0, false, false));
        marryTpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "marry-tp", false);
        atomicBoolean = new AtomicBoolean(false);
    }

}
