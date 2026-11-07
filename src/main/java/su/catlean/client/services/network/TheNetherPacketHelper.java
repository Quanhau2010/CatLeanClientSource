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
        }
        if (StringsKt.contains$default((CharSequence) SharedKt.getNetwork().method_45734().field_3761, (CharSequence) "pvp.mioclient.me") == 1) {
        } else {
        }
        return (1000.0F / RangesKt.coerceAtLeast(timestampValue, 1.0F));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        itemList.clear();
        itemList.addAll((Collection) this.resolveList());
        if (var11 != null) {
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
                    float var11 = (20.0F * this.computeValue());
                    if (!(Float.isNaN()) && !(Float.isInfinite())) {
                        arrayDeque.add(Float.valueOf());
                    }
                    factorValue = CollectionsKt.averageOfFloat((Iterable) arrayDeque);
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
        if (0L > 0) {
            if (SharedKt.getMc().method_1562().method_2871(pl.method_5667()) == null) {
                SharedKt.getMc().method_1562().method_2871(pl.method_5667());
            }
            return 0;
        }
        int var14 = FastLatencyModule.INSTANCE.getNumericValue();
        return var14.method_2959();
    }

    public boolean checkCondition() {
        if (SharedKt.getMc().world != null && SharedKt.getMc().world.method_27983() != null && SharedKt.getMc().world.method_27983().method_29177() != null) {
            if (SharedKt.getMc().world.method_27983().method_29177().method_12832() == null) {
            }
            SharedKt.getMc().world.method_27983().method_29177().method_12832();
        }
        return Intrinsics.areEqual("", "the_nether");
    }

    private List resolveList(int arg0) {
        List positions = new ArrayList();
        Iterator iterator = this.resolveList().iterator();
        if (iterator.hasNext()) {
            class_2818 var11 = (class_2818) iterator.next();
            if (arg0 >= 0) {
            } else {
            }
        }
        return positions;
    }

    public List resolveList() {
        List positions = new ArrayList();
        int var11 = (Number) SharedKt.getMc().options.method_42503().method_41753();
        int var12 = var11;
        if (var12 <= var11) {
            int var13 = var11;
            if (var13 <= var11) {
                if (SharedKt.getWorld().method_2935().method_21730(((SharedKt.getPlayer().getX() / 16) + var12), ((SharedKt.getPlayer().getZ() / 16) + var13)) != null) {
                    class_2818 var14 = SharedKt.getWorld().method_2935().method_21730(((SharedKt.getPlayer().getX() / 16) + var12), ((SharedKt.getPlayer().getZ() / 16) + var13));
                    int var15 = 0;
                    positions.add();
                } else {
                }
                if (var13 != var11) {
                }
            }
            if (var12 != var11) {
            }
        }
        return positions;
    }

    public List resolveList2() {
        List positions = new ArrayList();
        int var9 = ((Number) SharedKt.getMc().options.method_42503().method_41753() + 2);
        double var10 = (SharedKt.getPlayer().getX() >> 4);
        double var11 = (SharedKt.getPlayer().getZ() >> 4);
        int var12 = var9;
        if (var12 <= var9) {
            int var13 = var9;
            positions.add(new class_1923((var10 + var12), (var11 + var13)));
            if (var13 <= var9 && var13 != var9) {
            }
            if (var12 != var9) {
            }
        }
        return positions;
    }

    public boolean checkCondition2() {
        if (var3 != null) {
            if (arrayDeque.size() < 20) {
            }
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
