package su.catlean.client.features.modules.utility.misc;

import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_2639;
import net.minecraft.class_2805;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.PostTasksProcessEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode16;

public class FastLatencyModule extends Module {

    public static final FastLatencyModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl delaySetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 spikeDetectorSetting;
    private static final RangeVisibleSettingPropertyImpl messageDelaySetting;
    private static final ArrayDeque arrayDeque;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;
    private static final ServiceComponent10 serviceComponent103;
    private static int countValue;
    private static final long timestampValue2;

    private FastLatencyModule() {
        super("fast-latency", SubCategoriesKt.getMiscUtilityCategory());
    }

    private int getDelay() {
        return (Number) delaySetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private FastLatencySpikeDetectorMode getSpikeDetector() {
        return (FastLatencySpikeDetectorMode) spikeDetectorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private int getMessageDelay() {
        return (Number) messageDelaySetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    public int getNumericValue() {
        return countValue;
    }

    public void updateValue(int value) {
        countValue = value;
    }

    private void onPostTasksProcessEvent(PostTasksProcessEvent arg0) {
        PacketPacketHelper.handlePacket((Packet) new class_2805(1337, "w "));
        timestampValue = System.currentTimeMillis();
        serviceComponent10.executeAction();
    }

    private void onReceivePacket(ReceivePacket arg0) {
        countValue = RangesKt.coerceIn((System.currentTimeMillis() - timestampValue), (ClosedRange) new LongRange(timestampValue2));
        if (arrayDeque.size() >= 20) {
            arrayDeque.removeFirst();
        }
        arrayDeque.add(Integer.valueOf(countValue));
        if (countValue > (CollectionsKt.averageOfInt((Iterable) arrayDeque) * 1.15F) && arrayDeque.size() >= 20 && serviceComponent103.checkCondition2(this.getMessageDelay())) {
            Object[] var21 = new Object[2];
            var21[0] = Integer.valueOf(CollectionsKt.averageOfInt((Iterable) arrayDeque));
            var21[1] = Integer.valueOf(countValue);
            String var20 = MessageServiceComponent.Z(this, "spike");
            if (this.getSpikeDetector() != FastLatencySpikeDetectorMode.BOTH) {
                if (this.getSpikeDetector() == FastLatencySpikeDetectorMode.NOTIFICATION) {
                }
                MessageServiceComponent.e(this, OptionMode16.WARNING);
            }
            if (this.getSpikeDetector() != FastLatencySpikeDetectorMode.BOTH) {
                if (this.getSpikeDetector() == FastLatencySpikeDetectorMode.CHAT) {
                }
                MessageServiceComponent.S(this);
            }
        }
        serviceComponent10.updateValue(5000);
    }

    static {
        KProperty[] var34 = new KProperty[3];
        INSTANCE = new FastLatencyModule();
        delaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "delay", 80, new IntRange(0, 1000));
        spikeDetectorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "spike-detector", FastLatencySpikeDetectorMode.CHAT);
        messageDelaySetting = VisibleRenderHelper.registerSetting(INSTANCE, "message-delay", 500, new IntRange(0, 10000));
        arrayDeque = new ArrayDeque(20);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
        serviceComponent103 = new ServiceComponent10();
    }

}
