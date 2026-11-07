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
        return (String) xorKeySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private KeyRecord getSendCoords() {
        return (KeyRecord) sendCoordsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private KeyRecord getTpHere() {
        return (KeyRecord) tpHereSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getMarryTp() {
        return (Boolean) marryTpSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    public AtomicBoolean getAtomicBoolean() {
        return atomicBoolean;
    }

    private void onSendPacket(SendPacket arg0) {
        if (atomicBoolean.get()) {
            return;
        }
        class_2797 var9 = (class_2797) arg0.getPacket();
        atomicBoolean.set(1);
        MessageServiceComponent.executeAction(this, this.resolveString(var9.comp_945), 1);
        atomicBoolean.set(0);
        arg0.cancel();
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() == this.getTpHere().getNumericValue()) {
            if (this.getMarryTp()) {
            } else {
            }
            MessageServiceComponent.executeAction("action_marry_tp", "action_tp", 1);
        }
        MessageServiceComponent.executeAction(this, (this + SharedKt.getPlayer().getX() + "zCoord" + SharedKt.getPlayer().getZ() + "end"), 1);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (!(var16)) {
        }
        class_7439 var17 = (class_7439) arg0.getPacket();
        String var18 = var17.comp_763().getString();
        if (!(var16)) {
            if (!(var16)) {
            }
        }
        String var19 = this.resolveString(StringsKt.substringBefore$default(StringsKt.substringAfter$default("cat_"), "_lean"));
        String var20 = this.resolveString2();
        if (!(var16)) {
            if (Intrinsics.areEqual(SharedKt.getPlayer().method_7334().name())) {
                return;
            }
        }
        if (!(var16)) {
            if (StringsKt.contains$default((CharSequence) var19, (CharSequence) "xCoord")) {
                int var21 = Integer.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default("xCoord"), "zCoord"));
                int var22 = Integer.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default("zCoord"), "end"));
                WHITEServiceComponent.INSTANCE.updateValue(new BlockPos(0));
                return;
            }
        }
        if (!(var16)) {
            if (StringsKt.contains$default((CharSequence) var19, (CharSequence) "action_marry_tp")) {
                PacketPacketHelper.executeAction(("marry tp " + var20));
                return;
            }
        }
        if (!(var16)) {
            if (StringsKt.contains$default((CharSequence) var19, (CharSequence) "action_tp")) {
                PacketPacketHelper.executeAction(("tpa " + var20));
                return;
            }
            MessageServiceComponent.S(this, (var20 + ": " + var19));
        }
        arg0.cancel();
    }

    public String resolveString(String input) {
        Object var11 = input;
        byte[] var10 = var11.getBytes(Charsets.UTF_8);
        String var12 = this.getXorKey();
        var11 = var12.getBytes(Charsets.UTF_8);
        var12 = new byte[var10];
        int var13 = 0;
        Object var14 = var10;
        if (var13 < var14) {
            var12[var13] = (var10[var13] ^ var11[(var13 % var11)]);
        }
        return ("!cat_" + this.resolveString() + "_lean");
    }

    public String resolveString(String input) {
        byte[] var10 = this.process(input);
        String var12 = this.getXorKey();
        byte[] var11 = var12.getBytes(Charsets.UTF_8);
        var12 = new byte[var10];
        int var13 = 0;
        Object var14 = var10;
        if (var13 < var14) {
            var12[var13] = (var10[var13] ^ var11[(var13 % var11)]);
        }
        if (new String(Charsets.UTF_8) != null) {
        }
        return null;
    }

    public String resolveString(byte[] bytes) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(Base64.getEncoder().encodeToString(bytes))));
    }

    public byte[] process(String string) {
        return Base64.getDecoder().decode(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string))));
    }

    public String resolveString2(String notSolved) {
        AtomicReference var7 = new AtomicReference("FATAL ERROR");
        Iterable var8 = (Iterable) SharedKt.getNetwork().method_45732();
        int var9 = 0;
        Iterator iterator = var8.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            class_640 var12 = (class_640) var11;
            int var13 = 0;
            if (var6) {
                if (var6) {
                    if (StringsKt.contains$default((CharSequence) notSolved, (CharSequence) var12.method_2966().name())) {
                        var7.set(var12.method_2966().name());
                    }
                }
            }
        }
        return (String) var7.get();
    }

    static {
        KProperty[] var33 = new KProperty[4];
        INSTANCE = new TeamCommunicationModule();
        xorKeySetting = VisibleRenderHelper.registerSetting(INSTANCE, "key", "catlean");
        sendCoordsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "send-coords", new KeyRecord());
        tpHereSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tp-here", new KeyRecord());
        marryTpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "marry-tp");
        atomicBoolean = new AtomicBoolean(0);
    }

}
