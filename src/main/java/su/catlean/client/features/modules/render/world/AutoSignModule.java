package su.catlean.client.features.modules.render.world;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_2625;
import net.minecraft.class_2877;
import net.minecraft.class_2879;
import net.minecraft.class_320;
import net.minecraft.class_3965;
import net.minecraft.class_498;
import net.minecraft.class_8242;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.ScreenEvent;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.ViafabricplusServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.mixins.accessors.SignEditScreenAccessor;

public class AutoSignModule extends Module {

    public static final AutoSignModule INSTANCE;
    private static final SettingIdVisibleSettingPropertyImpl line1Setting;
    private static final SettingIdVisibleSettingPropertyImpl line2Setting;
    private static final SettingIdVisibleSettingPropertyImpl line3Setting;
    private static final SettingIdVisibleSettingPropertyImpl line4Setting;
    private static final SettingIdVisibleSettingPropertyImpl dateFormatSetting;
    private static final VisibleVisibleSettingPropertyImpl glowSetting;

    private AutoSignModule() {
        super("auto-sign", SubCategoriesKt.getWorldRenderCategory());
    }

    private String getLine1() {
        return (String) line1Setting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private String getLine2() {
        return (String) line2Setting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private String getLine3() {
        return (String) line3Setting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private String getLine4() {
        return (String) line4Setting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private String getDateFormat() {
        return (String) dateFormatSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getGlow() {
        return (Boolean) glowSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    public void onScreenEvent(ScreenEvent e) {
        SignEditScreenAccessor var41 = (SignEditScreenAccessor) e.getScreen();
        e.cancel();
        PacketPacketHelper.handlePacket((Packet) new class_2877(var41.getSign().method_11016(), var41.isIsFrontText(), this.resolveString(this.getLine1()), this.resolveString(this.getLine2()), this.resolveString(this.getLine3()), this.resolveString(this.getLine4())));
        var43[0] = Items.field_28410;
        StackServiceComponent2 var42 = new Item[1].resolveStackServiceComponent2();
        boolean var44 = SharedKt.getMc().player.method_5715();
        if (!(var42.isActive())) {
        }
        ItemPacketHelper.INSTANCE.updateValue();
        var42.updateValue();
        if (var44) {
            ViafabricplusServiceComponent.INSTANCE.executeAction(0);
        }
        SharedKt.getPlayer().method_2896(Hand.field_5810, Hand.field_5808, new class_3965(var41.getSign().method_11016().toCenterPos().method_1031(0.0D, 0.5D, 0.0D), Direction.UP, var41.getSign().method_11016(), 0));
        if (var44) {
            ViafabricplusServiceComponent.INSTANCE.executeAction(1);
        }
        Hand.field_5810.<init>(Hand.field_5808);
        PacketPacketHelper.handlePacket((Packet) new class_2879);
        ItemPacketHelper.INSTANCE.updateValue2();
    }

    private String resolveString(String arg0) {
        String var13 = "dd/MM/yyyy";
        var13 = new SimpleDateFormat(this.getDateFormat()).format(new Date());
        MessageServiceComponent.S(this, (class_124.field_1061 + "Your date format is wrong!"));
        return StringsKt.replace$default(StringsKt.replace$default(arg0, "<player>", SharedKt.getMc().method_1548().method_1676()), "<date>");
    }

    private boolean checkCondition() {
        if (!(StringsKt.contains$default((CharSequence) this.getLine1(), (CharSequence) "<date>")) && !(StringsKt.contains$default((CharSequence) this.getLine2(), (CharSequence) "<date>")) && !(StringsKt.contains$default((CharSequence) this.getLine3(), (CharSequence) "<date>"))) {
            if (StringsKt.contains$default((CharSequence) this.getLine4(), (CharSequence) "<date>")) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive() {
        return INSTANCE.checkCondition();
    }

    static {
        KProperty[] var28 = new KProperty[-1878568491397677050L];
        INSTANCE = new AutoSignModule();
        line1Setting = VisibleRenderHelper.registerSetting(INSTANCE, "line1", "<player>", null, null, -3804141311041208308L);
        line2Setting = VisibleRenderHelper.registerSetting(INSTANCE, "line2", "was here", null, null, -5193130229874294772L);
        line3Setting = VisibleRenderHelper.registerSetting(INSTANCE, "line3", "<------------->", null, null, -5193130229874294772L);
        line4Setting = VisibleRenderHelper.registerSetting(INSTANCE, "line4", "<date>", null, null, -5193130229874294772L);
        dateFormatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "date-format", "dd/MM/yyyy", null, this::isActive);
        glowSetting = VisibleRenderHelper.registerSetting(INSTANCE, "glowing", 0, null, null, -5193130229874294772L);
    }

}
