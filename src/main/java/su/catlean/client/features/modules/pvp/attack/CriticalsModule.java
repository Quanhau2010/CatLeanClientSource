package su.catlean.client.features.modules.pvp.attack;

import io.netty.buffer.Unpooled;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_2540;
import net.minecraft.class_2824;
import net.minecraft.class_2824.class_5907;
import net.minecraft.class_2828.class_2829;
import net.minecraft.class_2828.class_2830;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.mappings.CriticalsModeWhenMappings;
import su.catlean.mixins.accessors.LocalPlayerAccessor;

public class CriticalsModule extends Module {

    public static final CriticalsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 ncpModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 packet1Setting;
    private static final VisibleVisibleSettingPropertyImpl sendPacket1Setting;
    private static final VisibleVisibleSettingPropertyImpl ground1Setting;
    private static final VisibleVisibleSettingPropertyImpl full1Setting;
    private static final RangeVisibleSettingPropertyImpl2 offset1Setting;
    private static final DefaultValueVisibleSettingPropertyImpl7 packet2Setting;
    private static final VisibleVisibleSettingPropertyImpl sendPacket2Setting;
    private static final VisibleVisibleSettingPropertyImpl ground2Setting;
    private static final VisibleVisibleSettingPropertyImpl full2Setting;
    private static final RangeVisibleSettingPropertyImpl2 offset2Setting;
    private static final DefaultValueVisibleSettingPropertyImpl7 packet3Setting;
    private static final VisibleVisibleSettingPropertyImpl sendPacket3Setting;
    private static final VisibleVisibleSettingPropertyImpl ground3Setting;
    private static final VisibleVisibleSettingPropertyImpl full3Setting;
    private static final RangeVisibleSettingPropertyImpl2 offset3Setting;
    private static final DefaultValueVisibleSettingPropertyImpl7 packet4Setting;
    private static final VisibleVisibleSettingPropertyImpl sendPacket4Setting;
    private static final VisibleVisibleSettingPropertyImpl ground4Setting;
    private static final VisibleVisibleSettingPropertyImpl full4Setting;
    private static final RangeVisibleSettingPropertyImpl2 offset4Setting;
    private static final DefaultValueVisibleSettingPropertyImpl7 packet5Setting;
    private static final VisibleVisibleSettingPropertyImpl sendPacket5Setting;
    private static final VisibleVisibleSettingPropertyImpl ground5Setting;
    private static final VisibleVisibleSettingPropertyImpl full5Setting;
    private static final RangeVisibleSettingPropertyImpl2 offset5Setting;
    private static String[] textValueArray;

    private CriticalsModule() {
        super("criticals", SubCategoriesKt.getAttackCategory());
    }

    public CriticalsMode getMode() {
        return ((CriticalsMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private CriticalsNcpMode getNcpMode() {
        return ((CriticalsNcpMode) ncpModeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private SettingGroup getPacket1() {
        return ((SettingGroup) packet1Setting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getSendPacket1() {
        return ((Boolean) sendPacket1Setting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getGround1() {
        return ((Boolean) ground1Setting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getFull1() {
        return ((Boolean) full1Setting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private float getOffset1() {
        return ((Number) offset1Setting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private SettingGroup getPacket2() {
        return ((SettingGroup) packet2Setting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getSendPacket2() {
        return ((Boolean) sendPacket2Setting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getGround2() {
        return ((Boolean) ground2Setting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getFull2() {
        return ((Boolean) full2Setting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private float getOffset2() {
        return ((Number) offset2Setting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private SettingGroup getPacket3() {
        return ((SettingGroup) packet3Setting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private boolean getSendPacket3() {
        return ((Boolean) sendPacket3Setting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private boolean getGround3() {
        return ((Boolean) ground3Setting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private boolean getFull3() {
        return ((Boolean) full3Setting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private float getOffset3() {
        return ((Number) offset3Setting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private SettingGroup getPacket4() {
        return ((SettingGroup) packet4Setting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private boolean getSendPacket4() {
        return ((Boolean) sendPacket4Setting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private boolean getGround4() {
        return ((Boolean) ground4Setting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private boolean getFull4() {
        return ((Boolean) full4Setting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    private float getOffset4() {
        return ((Number) offset4Setting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private SettingGroup getPacket5() {
        return ((SettingGroup) packet5Setting.getValue(this, DELEGATED_PROPERTIES[22]));
    }

    private boolean getSendPacket5() {
        return ((Boolean) sendPacket5Setting.getValue(this, DELEGATED_PROPERTIES[23]));
    }

    private boolean getGround5() {
        return ((Boolean) ground5Setting.getValue(this, DELEGATED_PROPERTIES[24]));
    }

    private boolean getFull5() {
        return ((Boolean) full5Setting.getValue(this, DELEGATED_PROPERTIES[25]));
    }

    private float getOffset5() {
        return ((Number) offset5Setting.getValue(this, DELEGATED_PROPERTIES[26]));
    }

    private void onSendPacket(SendPacket arg0) {
        Entity entity = this.resolveMinecraftObject(((class_2824) arg0.getPacket()));
        if (!(arg0.getPacket() instanceof class_2824) || !(this.checkCondition(((class_2824) arg0.getPacket()))) || entity == null || entity instanceof EndCrystalEntity) {
            return;
        }
        this.updateValue();
    }

    private void updateValue() {
        if (!(SharedKt.getPlayer().isOnGround())) {
        }
        this.updateValue2();
        this.executeAction();
    }

    private void executeAction(char arg0) {
        if (this.getSendPacket1()) {
            this.executeAction(this.getOffset1(), this.getFull1(), this.getGround1());
        }
        if (arg0 > 0) {
            if (__UNDEF_KEY__ == null) {
                if (this.getSendPacket2()) {
                    this.executeAction(this.getOffset2(), this.getFull2(), this.getGround2());
                }
            }
        }
        if (arg0 > 0 && __UNDEF_KEY__ == null) {
            if (this.getSendPacket3()) {
                this.executeAction(this.getOffset3(), this.getFull3(), this.getGround3());
            }
        }
        if (this.getSendPacket4()) {
            this.executeAction(this.getOffset4(), this.getFull4(), this.getGround4());
        }
        this.executeAction(this.getOffset5(), this.getFull5(), this.getGround5());
    }

    private void updateValue2() {
        executeAction(this, 1.058293536E-5D, false, false);
        executeAction(this, 9.16580235E-6D, false, false);
        int index = 6;
        int index2 = 0;
        int index3 = 0;
        double offset = 1.0371854E-7D;
        executeAction(this, offset, index3, index2, index);
        executeAction(this, 0.0625D, false, false);
        executeAction(this, 0.0D, false, false);
        executeAction(this, 2.71875E-7D, false, false);
        executeAction(this, 0.0D, false, false);
        executeAction(this, 0.062600301692775D, false, false);
        executeAction(this, 0.07260029960661D, false, false);
        executeAction(this, 0.0D, false, false);
        executeAction(this, 0.0D, false, false);
    }

    private void executeAction(double arg0, boolean arg1, boolean arg2) {
        ClientPlayerEntity player = SharedKt.getPlayer();
        if (__UNDEF_KEY__ == null) {
            if (!(arg1)) {
                PacketPacketHelper.handlePacket(((Packet) new class_2829(player.getX(), (player.getY() + arg0), player.getZ(), arg2, player.field_5976)));
                if (__UNDEF_KEY__ != null) {
                    PacketPacketHelper.handlePacket(((Packet) new class_2830(player.getX(), (player.getY() + arg0), player.getZ(), ((LocalPlayerAccessor) SharedKt.getMc().player).getLastYaw(), ((LocalPlayerAccessor) SharedKt.getMc().player).getLastPitch(), arg2, player.field_5976)));
                }
            }
        }
    }

    private static void executeAction(CriticalsModule arg0, double arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if ((arg4 & 2) != 0) {
            arg2 = 0;
        }
        if ((arg4 & 4) != 0) {
            arg3 = 0;
        }
        arg0.executeAction(arg1, arg2, arg3);
    }

    public Entity resolveMinecraftObject(class_2824 packet) {
        class_2540 class2540 = new class_2540(Unpooled.buffer());
        packet.method_55976(class2540);
        if (SharedKt.getWorld().method_8469(class2540.method_10816()) != null) {
        }
        return null;
    }

    public class_5907 resolveMinecraftObject(class_2824 packet) {
        class_2540 class2540 = new class_2540(Unpooled.buffer());
        packet.method_55976(class2540);
        class2540.method_10816();
        if (__UNDEF_KEY__ != null) {
        }
        return ((class_5907) class2540.method_10818(class_5907.class));
    }

    public boolean checkCondition(class_2824 receiver) {
        return this.resolveMinecraftObject(receiver) == class_5907.field_29172;
    }

    private static boolean isActive() {
        return INSTANCE.getMode() == CriticalsMode.NCP;
    }

    private static boolean isActive2() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive3() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive4() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive5() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive6() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive7() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive8() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive9() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive10() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive11() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive12() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive13() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive14() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive15() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive16() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive17() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive18() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive19() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive20() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive21() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive22() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive23() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive24() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive25() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    private static boolean isActive26() {
        return INSTANCE.getMode() == CriticalsMode.CUSTOM;
    }

    static {
        KProperty[] items = new KProperty[27];
        INSTANCE = new CriticalsModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", CriticalsMode.NCP);
        ncpModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ncp-mode", CriticalsNcpMode.NEW, null, this::isActive);
        packet1Setting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-1", null, this::isActive2);
        sendPacket1Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "send-packet-1", true, INSTANCE.getPacket1(), this::isActive3);
        ground1Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "ground-1", true, INSTANCE.getPacket1(), this::isActive4);
        full1Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "full-1", true, INSTANCE.getPacket1(), this::isActive5);
        offset1Setting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "offset-1", 0.0F, RangesKt.rangeTo(0.0F, 1.5F), INSTANCE.getPacket1(), this::isActive6);
        packet2Setting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-2", null, this::isActive7);
        sendPacket2Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "send-packet-2", true, INSTANCE.getPacket2(), this::isActive8);
        ground2Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "ground-2", false, INSTANCE.getPacket2(), this::isActive9);
        full2Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "full-2", true, INSTANCE.getPacket2(), this::isActive10);
        offset2Setting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "offset-2", 0.0625F, RangesKt.rangeTo(0.0F, 1.5F), INSTANCE.getPacket2(), this::isActive11);
        packet3Setting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-3", null, this::isActive12);
        sendPacket3Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "send-packet-3", true, INSTANCE.getPacket3(), this::isActive13);
        ground3Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "ground-3", false, INSTANCE.getPacket3(), this::isActive14);
        full3Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "full-3", true, INSTANCE.getPacket3(), this::isActive15);
        offset3Setting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "offset-3", 0.04535F, RangesKt.rangeTo(0.0F, 1.5F), INSTANCE.getPacket3(), this::isActive16);
        packet4Setting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-4", null, this::isActive17);
        sendPacket4Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "send-packet-4", false, INSTANCE.getPacket4(), this::isActive18);
        ground4Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "ground-4", false, INSTANCE.getPacket4(), this::isActive19);
        full4Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "full-4", false, INSTANCE.getPacket4(), this::isActive20);
        offset4Setting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "offset-4", 0.0F, RangesKt.rangeTo(0.0F, 1.5F), INSTANCE.getPacket4(), this::isActive21);
        packet5Setting = VisibleRenderHelper.registerSetting(INSTANCE, "packet-5", null, this::isActive22);
        sendPacket5Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "send-packet-5", false, INSTANCE.getPacket5(), this::isActive23);
        ground5Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "ground-5", false, INSTANCE.getPacket5(), this::isActive24);
        full5Setting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "full-5", false, INSTANCE.getPacket5(), this::isActive25);
        offset5Setting = VisibleRenderHelper.resolveRangeVisibleSettingPropertyImpl2(INSTANCE, "offset-5", 0.0F, RangesKt.rangeTo(0.0F, 1.5F), INSTANCE.getPacket5(), this::isActive26);
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
