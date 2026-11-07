package su.catlean.client.services.network;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_1934;
import net.minecraft.class_2561;
import net.minecraft.class_268;
import net.minecraft.class_270;
import net.minecraft.class_3544;
import net.minecraft.class_5250;
import net.minecraft.class_5900;
import net.minecraft.class_5900.class_5901;
import net.minecraft.class_5900.class_5902;
import net.minecraft.class_640;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AfterReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.services.client.ProfileServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent19;
import su.catlean.client.services.render.StaffWidgetCheckRenderHelperImpl;
import su.catlean.client.tools.comparators.Comparator16;

public class EntryPacketHelper {

    public static final EntryPacketHelper INSTANCE;
    private static final CopyOnWriteArrayList copyOnWriteArrayList;
    private static List itemList;
    private static final String[] textValueArray;

    private EntryPacketHelper() {
    }

    public List getList() {
        return itemList;
    }

    public void executeAction(List value) {
        itemList = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(StaffWidgetCheckRenderHelperImpl.INSTANCE.getEnabled())) {
            return;
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        copyOnWriteArrayList.removeIf(this::checkCondition);
        Iterable var8 = (Iterable) copyOnWriteArrayList;
        int var9 = 0;
        itemList = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith((Comparator) new Comparator16()));
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        if (!(StaffWidgetCheckRenderHelperImpl.INSTANCE.getEnabled())) {
            return;
        }
        class_5900 var14 = (class_5900) arg0.getPacket();
        Iterator iterator = var14.method_34178().iterator();
        while (iterator.hasNext()) {
            String var16 = (String) iterator.next();
            ProfileServiceComponent var17 = new ProfileServiceComponent(new GameProfile(UUID.fromString("66123666-622-6666-6666-666612366600")), 1);
            if (Intrinsics.areEqual(var17.getGameProfile().name(), SharedKt.getPlayer().method_7334().name())) {
                return;
            }
            String var20 = this.resolveMinecraftObject(var17.getMinecraftObject()).getString();
            CharSequence var19 = (CharSequence) class_3544.method_15440(var20.toLowerCase(Locale.getDefault()));
            var20 = new Regex(" ");
            int var21 = 0;
            var19 = var20.split();
            var20 = 0;
            if (!(var19.isEmpty())) {
                var21 = var19.listIterator(var19.size());
                if (var21.hasPrevious()) {
                    String var22 = (String) var21.previous();
                    int var23 = 0;
                }
            } else {
            }
        }
        var19 = (Collection) CollectionsKt.emptyList();
        var20 = 0;
        var21 = var19;
        String[] var18 = (String[]) var21.toArray(new String[0]);
        var19 = RunnableServiceComponent.INSTANCE;
        var20 = 250;
        var21 = 0;
        var19.getExecutorService().execute((Runnable) new ServiceComponent19());
        }
    }

    public class_5250 resolveMinecraftObject(class_640 entry) {
        if (entry.method_2971() != null) {
        } else {
        }
        return this.resolveMinecraftObject(entry, class_268.method_1142((class_270) entry.method_2955(), (class_2561) class_2561.method_43470(entry.method_2966().name())));
    }

    private class_5250 resolveMinecraftObject(class_640 arg0, class_5250 arg1) {
        if (arg0.method_2958() == class_1934.field_9219) {
        } else {
        }
        Object var5 = arg1;
        return var5;
    }

    private void executeAction(String[] arg0) {
    }

    private boolean checkCondition(String arg0) {
        Object var7 = arg0;
        var7 = class_3544.method_15440(var7.toLowerCase(Locale.ROOT));
        if (var6 != null) {
            if (StringsKt.contains$default((CharSequence) var7, (CharSequence) "\u00a7")) {
                return false;
            }
        }
        String[] var9 = new String[1];
        var9[0] = " ";
        Iterator iterator = StringsKt.split$default((CharSequence) var7).iterator();
        if (iterator.hasNext()) {
            var9 = (String) iterator.next();
            return true;
        }
        iterator = SharedKt.getPlayer().field_3944.method_2880().iterator();
        if (iterator.hasNext()) {
            var9 = (class_640) iterator.next();
            return true;
        }
        return false;
    }

    public PlayerEntity resolveMinecraftObject(String name) {
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        if (iterator.hasNext()) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
            return (PlayerEntity) player;
        }
        return null;
    }

    private int computeValue(ProfileServiceComponent arg0, long arg1) {
        Object var8 = new char[1];
        var8[0] = 32;
        List positions = StringsKt.split$default((CharSequence) class_3544.method_15440(arg0.resolveString().toLowerCase(Locale.ROOT)));
        var8 = 11;
        Iterator iterator = positions.iterator();
        while (iterator.hasNext()) {
            String var10 = (String) iterator.next();
            Object var12 = var10;
            if (!(var12.equals("st.helper"))) {
                if (!(var12.equals("ml.admin"))) {
                    if (!(var12.equals("\u0430\u0434\u043c\u0438\u043d")) && !(var12.equals("admin"))) {
                        if (!(var12.equals("gl.moder"))) {
                            if (!(var12.equals("j.moder"))) {
                                if (!(var12.equals("s.moder")) && !(var12.equals("st.moder"))) {
                                    if (!(var12.equals("yt+"))) {
                                        if (!(var12.equals("helper"))) {
                                            if (!(var12.equals("helper+"))) {
                                                if (!(var12.equals("yt"))) {
                                                    if (!(var12.equals("\u043c\u043e\u0434\u0435\u0440\u0430\u0442\u043e\u0440")) && !(var12.equals("moder"))) {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    } else {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int var11 = 11;
            var8 = var11;
        }
        return var8;
    }

    private static boolean checkCondition(ProfileServiceComponent arg0) {
        return arg0.isActive();
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(String arg0, String arg1) {
        return StringsKt.startsWith$default(arg0, arg1);
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    public static int computeValue(EntryPacketHelper $this, ProfileServiceComponent employee) {
        return $this.computeValue(employee);
    }

    public static boolean checkCondition(EntryPacketHelper $this, String name1) {
        return $this.checkCondition(name1);
    }

    public static CopyOnWriteArrayList getCopyOnWriteArrayList() {
        return copyOnWriteArrayList;
    }

    public static void executeAction(EntryPacketHelper $this, String[] stringArray) {
        $this.executeAction(stringArray);
    }

    static {
        INSTANCE = new EntryPacketHelper();
        copyOnWriteArrayList = new CopyOnWriteArrayList();
        itemList = new ArrayList();
        String[] var22 = new String[15];
        var22[0] = "\u0430\u0434\u043c\u0438\u043d";
        var22[1] = "admin";
        var22[2] = "ml.admin";
        var22[3] = "moder";
        var22[4] = "st.moder";
        var22[5] = "s.moder";
        var22[6] = "gl.moder";
        var22[7] = "j.moder";
        var22[8] = "\u043c\u043e\u0434\u0435\u0440\u0430\u0442\u043e\u0440";
        var22[9] = "\u043c\u043e\u0434\u0435\u0440";
        var22[10] = "st.helper";
        var22[11] = "\u0445\u0435\u043b\u043f\u0435\u0440";
        var22[12] = "helper";
        var22[13] = "helper";
        var22[14] = "yt";
        textValueArray = var22;
    }

}
