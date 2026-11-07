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
        Iterable iterable = ((Iterable) copyOnWriteArrayList);
        itemList = CollectionsKt.toMutableList(((Collection) CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator16()))));
    }

    private void onAfterReceivePacket(AfterReceivePacket arg0) {
        if (!(StaffWidgetCheckRenderHelperImpl.INSTANCE.getEnabled())) {
            return;
        }
        class_5900 class5900 = ((class_5900) arg0.getPacket());
        Iterator iterator = class5900.method_34178().iterator();
        while (iterator.hasNext()) {
            String text = ((String) iterator.next());
            ProfileServiceComponent profileServiceComponent = new ProfileServiceComponent(true);
            if (Intrinsics.areEqual(profileServiceComponent.getGameProfile().name(), SharedKt.getPlayer().method_7334().name())) {
                return;
            }
            String text2 = this.resolveMinecraftObject(profileServiceComponent.getMinecraftObject()).getString();
            CharSequence charSequence = ((CharSequence) class_3544.method_15440(text2.toLowerCase(Locale.getDefault())));
            text2 = new Regex(" ");
            int index = 0;
            charSequence = text2.split(charSequence, index);
            text2 = 0;
            if (!(charSequence.isEmpty())) {
                index = charSequence.listIterator(charSequence.size());
                if (index.hasPrevious()) {
                    String text3 = ((String) index.previous());
                } else {
                }
            } else {
            }
            charSequence = ((Collection) CollectionsKt.emptyList());
            text2 = 0;
            index = charSequence;
            String[] items = ((String[]) index.toArray(new String[0]));
            charSequence = RunnableServiceComponent.INSTANCE;
            text2 = 250;
            index = 0;
            charSequence.getExecutorService().execute(((Runnable) new ServiceComponent19(text2, profileServiceComponent, items)));
        }
    }

    public class_5250 resolveMinecraftObject(class_640 entry) {
        if (entry.method_2971() != null) {
        } else {
        }
        return this.resolveMinecraftObject(entry, class_268.method_1142(((class_270) entry.method_2955()), ((class_2561) class_2561.method_43470(entry.method_2966().name()))));
    }

    private class_5250 resolveMinecraftObject(class_640 arg0, class_5250 arg1) {
        if (arg0.method_2958() == class_1934.field_9219) {
        } else {
        }
        return arg1;
    }

    private void executeAction(String[] arg0) {
    }

    private boolean checkCondition(String arg0) {
        String text = arg0;
        text = class_3544.method_15440(text.toLowerCase(Locale.ROOT));
        if (__UNDEF_KEY__ != null) {
            if (StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u00a7"), false)) {
                return false;
            }
        }
        String[] items = new String[1];
        items[0] = " ";
        Iterator iterator = StringsKt.split$default(((CharSequence) text), items, false).iterator();
        while (iterator.hasNext()) {
            items = ((String) iterator.next());
            return true;
        }
        iterator = SharedKt.getPlayer().field_3944.method_2880().iterator();
        while (iterator.hasNext()) {
            items = ((class_640) iterator.next());
            return true;
        }
        return false;
    }

    public PlayerEntity resolveMinecraftObject(String name) {
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            return ((PlayerEntity) player);
        }
        return null;
    }

    private int computeValue(ProfileServiceComponent arg0, long arg1) {
        Object element = new char[1];
        element[0] = 32;
        List list = StringsKt.split$default(((CharSequence) class_3544.method_15440(arg0.resolveString().toLowerCase(Locale.ROOT))), element, false);
        element = 11;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String text = ((String) iterator.next());
            if (!(text.equals("st.helper"))) {
                if (!(text.equals("ml.admin"))) {
                    if (!(text.equals("\u0430\u0434\u043c\u0438\u043d")) && !(text.equals("admin"))) {
                        if (!(text.equals("gl.moder"))) {
                            if (!(text.equals("j.moder"))) {
                                if (!(text.equals("s.moder")) && !(text.equals("st.moder"))) {
                                    if (!(text.equals("yt+"))) {
                                        if (!(text.equals("helper"))) {
                                            if (!(text.equals("helper+"))) {
                                                if (!(text.equals("yt"))) {
                                                    if (!(text.equals("\u043c\u043e\u0434\u0435\u0440\u0430\u0442\u043e\u0440")) && !(text.equals("moder"))) {
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                                int index = 11;
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                            element = index;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        return element;
    }

    private static boolean checkCondition(ProfileServiceComponent arg0) {
        return arg0.isActive();
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(String arg0, String arg1) {
        return StringsKt.startsWith$default(arg0, arg1, false);
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
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
        String[] items = new String[15];
        items[0] = "\u0430\u0434\u043c\u0438\u043d";
        items[1] = "admin";
        items[2] = "ml.admin";
        items[3] = "moder";
        items[4] = "st.moder";
        items[5] = "s.moder";
        items[6] = "gl.moder";
        items[7] = "j.moder";
        items[8] = "\u043c\u043e\u0434\u0435\u0440\u0430\u0442\u043e\u0440";
        items[9] = "\u043c\u043e\u0434\u0435\u0440";
        items[10] = "st.helper";
        items[11] = "\u0445\u0435\u043b\u043f\u0435\u0440";
        items[12] = "helper";
        items[13] = "helper";
        items[14] = "yt";
        textValueArray = items;
    }

}
