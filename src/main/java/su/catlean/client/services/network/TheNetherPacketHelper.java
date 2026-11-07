package su.catlean.client.services.network;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.minecraft.class_1923;
import net.minecraft.class_2761;
import net.minecraft.class_2818;
import net.minecraft.class_2960;
import net.minecraft.class_315;
import net.minecraft.class_5321;
import net.minecraft.class_631;
import net.minecraft.class_640;
import net.minecraft.class_7172;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.utility.misc.FastLatencyModule;

public class TheNetherPacketHelper implements Contract9 {

    public static final TheNetherPacketHelper INSTANCE;
    private static final ArrayDeque arrayDeque;
    private static float factorValue;
    private static int countValue;
    private static List itemList;
    private static long timestampValue2;
    private static long timestampValue3;
    private static String textValue;

    private TheNetherPacketHelper() {
    }

    public List getList() {
        return itemList;
    }

    public void executeAction(List value) {
        itemList = value;
    }

    public long getNumericValue() {
        return timestampValue2;
    }

    public float getNumericValue() {
        return new BigDecimal(factorValue).setScale(2, RoundingMode.HALF_UP);
    }

    public float computeValue() {
        return new BigDecimal((20.0D * this.computeValue())).setScale(2, RoundingMode.HALF_UP);
    }

    public float computeValue() {
        if (SharedKt.getNetwork().method_45734() != null && SharedKt.getNetwork().method_45734().field_3761 != null) {
        } else {
            if (StringsKt.contains$default(((CharSequence) SharedKt.getNetwork().method_45734().field_3761), ((CharSequence) "pvp.mioclient.me"), false) == 1) {
            } else {
            }
        }
        return (1000.0F / RangesKt.coerceAtLeast(timestampValue, 1.0F));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        itemList.clear();
        itemList.addAll(((Collection) this.resolveList()));
        if (__UNDEF_KEY__ != null) {
            if (SharedKt.getMc().method_1562() != null && SharedKt.getMc().method_1562().method_2871(SharedKt.getPlayer().method_5667()) != null) {
            } else {
                SharedKt.getMc().method_1562().method_2871(SharedKt.getPlayer().method_5667()).method_2959();
            }
        }
        countValue = 0;
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2761) {
            if (timestampValue2 != 0L) {
                timestampValue = (SharedKt.getNumericValue() - timestampValue2);
                if (SharedKt.getMc().player != null && SharedKt.getPlayer().field_6012 < 20) {
                    arrayDeque.clear();
                    return;
                }
                if (timestampValue > 0L) {
                    if (arrayDeque.size() >= 20) {
                        arrayDeque.removeFirst();
                    }
                    float factor = (20.0F * this.computeValue());
                    if (!(Float.isNaN(factor)) && !(Float.isInfinite(factor))) {
                        arrayDeque.add(Float.valueOf(factor));
                    }
                    factorValue = CollectionsKt.averageOfFloat(((Iterable) arrayDeque));
                }
            }
            timestampValue2 = SharedKt.getNumericValue();
        }
        timestampValue3 = SharedKt.getNumericValue();
    }

    public int computeValue(PlayerEntity pl) {
        if (Intrinsics.areEqual(pl, SharedKt.getPlayer())) {
            if (FastLatencyModule.INSTANCE.getEnabled()) {
            } else {
            }
            return countValue;
        }
        if (__UNDEF_KEY__ > 0) {
            if (SharedKt.getMc().method_1562().method_2871(pl.method_5667()) == null) {
                SharedKt.getMc().method_1562().method_2871(pl.method_5667());
                return 0;
            }
        }
        int index = FastLatencyModule.INSTANCE.getNumericValue();
        return index.method_2959();
    }

    public boolean checkCondition() {
        if (SharedKt.getMc().world != null && SharedKt.getMc().world.method_27983() != null && SharedKt.getMc().world.method_27983().method_29177() != null) {
            if (SharedKt.getMc().world.method_27983().method_29177().method_12832() == null) {
                SharedKt.getMc().world.method_27983().method_29177().method_12832();
            }
        }
        return Intrinsics.areEqual("", "the_nether");
    }

    private List resolveList(int arg0) {
        List list = new ArrayList();
        Iterator iterator = this.resolveList().iterator();
        while (iterator.hasNext()) {
            if (arg0 >= 0) {
            } else {
            }
        }
        return list;
    }

    public List resolveList() {
        List list = new ArrayList();
        int index = ((Number) SharedKt.getMc().options.method_42503().method_41753());
        int index2 = index;
        if (index2 <= index) {
            int index3 = index;
            if (index3 <= index) {
                if (SharedKt.getWorld().method_2935().method_21730(((SharedKt.getPlayer().getX() / 16) + index2), ((SharedKt.getPlayer().getZ() / 16) + index3)) != null) {
                    class_2818 class2818 = SharedKt.getWorld().method_2935().method_21730(((SharedKt.getPlayer().getX() / 16) + index2), ((SharedKt.getPlayer().getZ() / 16) + index3));
                    list.add(class2818);
                } else {
                }
                if (index3 != index) {
                }
            }
            if (index2 != index) {
            }
        }
        return list;
    }

    public List resolveList2() {
        List list = new ArrayList();
        int index = (((Number) SharedKt.getMc().options.method_42503().method_41753()) + 2);
        double offset = (SharedKt.getPlayer().getX() >> 4);
        double offset2 = (SharedKt.getPlayer().getZ() >> 4);
        int index2 = index;
        if (index2 <= index) {
            int index3 = index;
            list.add(new class_1923((offset + index2), (offset2 + index3)));
            if (index3 <= index && index3 != index) {
            }
            if (index2 != index) {
            }
        }
        return list;
    }

    public boolean checkCondition2() {
        if (arrayDeque.size() < 20) {
        } else {
        }
        return false;
    }

    public long getNumericValue2() {
        return (timestampValue3 - timestampValue2);
    }

    static {
        INSTANCE = new TheNetherPacketHelper();
        arrayDeque = new ArrayDeque(20);
        timestampValue = 1L;
        itemList = new ArrayList();
    }

    public static void updateValue(String arg0) {
        textValue = arg0;
    }

    public static String getString() {
        return textValue;
    }

}
