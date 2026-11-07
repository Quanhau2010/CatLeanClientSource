package su.catlean.client.features.modules.utility.misc;

import com.mojang.authlib.GameProfile;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.class_10691;
import net.minecraft.class_124;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1542;
import net.minecraft.class_1675;
import net.minecraft.class_1844;
import net.minecraft.class_1923;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2627;
import net.minecraft.class_2673;
import net.minecraft.class_2739;
import net.minecraft.class_2775;
import net.minecraft.class_2797;
import net.minecraft.class_2818;
import net.minecraft.class_2945.class_7834;
import net.minecraft.class_4081;
import net.minecraft.class_6880;
import net.minecraft.class_7439;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.PlayerEntityDeathEvent;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.world.EntityRemove;
import su.catlean.api.event.events.world.EntitySpawn;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ItemNameServiceComponent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent105;
import su.catlean.client.services.client.ServiceComponent65;
import su.catlean.client.services.client.ServiceComponent86;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.OptionMode16;

public class NotifierModule extends Module {

    public static final NotifierModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl totemPopsSetting;
    private static final VisibleVisibleSettingPropertyImpl lowArmorSetting;
    private static final VisibleVisibleSettingPropertyImpl rangeEnterSetting;
    private static final VisibleVisibleSettingPropertyImpl rangeLeaveSetting;
    private static final VisibleVisibleSettingPropertyImpl lagSetting;
    private static final VisibleVisibleSettingPropertyImpl rubberBandSetting;
    private static final VisibleVisibleSettingPropertyImpl stashSetting;
    private static final RangeVisibleSettingPropertyImpl minChestsSetting;
    private static final RangeVisibleSettingPropertyImpl minShulkersSetting;
    private static final VisibleVisibleSettingPropertyImpl mentionSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 pastEffectsSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 splashBuffSetting;
    private static final VisibleVisibleSettingPropertyImpl ftBypassSetting;
    private static final VisibleVisibleSettingPropertyImpl selfSetting;
    private static final VisibleVisibleSettingPropertyImpl oldSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 itemCollectSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyDonSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 useTrackerSetting;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static final MissingnoRenderHelper missingnoRenderHelper2;
    private static final MissingnoRenderHelper missingnoRenderHelper3;
    private static final MissingnoRenderHelper missingnoRenderHelper4;
    private static final MissingnoRenderHelper missingnoRenderHelper5;
    private static final MissingnoRenderHelper missingnoRenderHelper6;
    private static final MissingnoRenderHelper missingnoRenderHelper7;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;
    private static final ServiceComponent10 serviceComponent103;
    private static final ServiceComponent10 serviceComponent104;
    private static final ServiceComponent10 serviceComponent105;
    private static final ServiceComponent10 serviceComponent106;
    private static final ServiceComponent10 serviceComponent107;
    private static final ServiceComponent10 serviceComponent108;
    private static final ServiceComponent10 serviceComponent109;
    private static final List itemList;
    private static final List itemList2;
    private static final ConcurrentHashMap concurrentHashMap;
    private static boolean enabledFlag;
    private static int countValue;

    private NotifierModule() {
        super("notifier", SubCategoriesKt.getMiscUtilityCategory());
    }

    private boolean getTotemPops() {
        return ((Boolean) totemPopsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getLowArmor() {
        return ((Boolean) lowArmorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getRangeEnter() {
        return ((Boolean) rangeEnterSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getRangeLeave() {
        return ((Boolean) rangeLeaveSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getLag() {
        return ((Boolean) lagSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getRubberBand() {
        return ((Boolean) rubberBandSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getStash() {
        return ((Boolean) stashSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private int getMinChests() {
        return ((Number) minChestsSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private int getMinShulkers() {
        return ((Number) minShulkersSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getMention() {
        return ((Boolean) mentionSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private NotifierPastEffectsMode getPastEffects() {
        return ((NotifierPastEffectsMode) pastEffectsSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private NotifierPastEffectsMode getSplashBuff() {
        return ((NotifierPastEffectsMode) splashBuffSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private boolean getFtBypass() {
        return ((Boolean) ftBypassSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private boolean getSelf() {
        return ((Boolean) selfSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private boolean getOld() {
        return ((Boolean) oldSetting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private NotifierPastEffectsMode getItemCollect() {
        return ((NotifierPastEffectsMode) itemCollectSetting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private boolean getOnlyDon() {
        return ((Boolean) onlyDonSetting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private NotifierPastEffectsMode getUseTracker() {
        return ((NotifierPastEffectsMode) useTrackerSetting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    public ServiceComponent10 getServiceComponent10() {
        return serviceComponent106;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        if (!(serviceComponent106.checkCondition(3000)) && enabledFlag) {
            this.render(arg0.getContext(), missingnoRenderHelper6, missingnoRenderHelper7, MessageServiceComponent.Z(this, "air-alarm-header", new Object[0], false), MessageServiceComponent.Z(this, "air-alarm", new Object[0], false));
        }
        if (this.getLowArmor()) {
            Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
            while (iterator.hasNext()) {
                ItemStack stack = ((ItemStack) iterator.next());
                this.render(arg0.getContext(), missingnoRenderHelper, missingnoRenderHelper2, MessageServiceComponent.Z(this, "low-armor-title", new Object[0], false), MessageServiceComponent.Z(this, "low-armor-text", new Object[0], false));
                StartupServiceComponent.INSTANCE.getVecServiceComponent10().updateValue();
                return;
            }
        }
        if (!(serviceComponent103.checkCondition2(60000)) || !(AssistantModule.INSTANCE.getEnabled()) || this.getLag()) {
            return;
        }
        iterator = new Object[1];
        iterator[0] = this.resolveString(EventPacketHelper2.INSTANCE.getNumericValue4());
        this.render(arg0.getContext(), missingnoRenderHelper5, missingnoRenderHelper5, MessageServiceComponent.Z(this, "flag-title", new Object[0], false), MessageServiceComponent.Z(this, "flag-text", iterator, false));
        StartupServiceComponent.INSTANCE.getVecServiceComponent8().updateValue();
    }

    private void onSendPacket(SendPacket arg0) {
        serviceComponent107.executeAction();
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2739) {
            if (SharedKt.getWorld().method_8469(((class_2739) arg0.getPacket()).comp_1127()) == null) {
                SharedKt.getWorld().method_8469(((class_2739) arg0.getPacket()).comp_1127());
                return;
            }
            if (!(__UNDEF_KEY__ instanceof PlayerEntity) || Intrinsics.areEqual(SharedKt.getPlayer())) {
                return;
            }
            Iterable iterable = ((Iterable) ((class_2739) arg0.getPacket()).comp_1128());
            int index = 0;
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                class_7834 class7834 = ((class_7834) element);
                if (Intrinsics.areEqual(String.valueOf(class7834.comp_1115()), "8")) {
                    if (!(Intrinsics.areEqual(class7834.comp_1117().toString(), "1"))) {
                        if (Intrinsics.areEqual(class7834.comp_1117().toString(), "3")) {
                            boolean flag = Intrinsics.areEqual(class7834.comp_1117().toString(), "3");
                            if (flag) {
                            }
                            ItemStack stack = Hand.field_5810.method_5998(Hand.field_5808);
                            if (!(stack.method_57353().method_57832(class_9334.field_50075))) {
                                if (stack != null && stack.method_57353().method_57832(class_9334.field_49651)) {
                                    Map map = ((Map) concurrentHashMap);
                                    String text = ServiceComponent86.resolveString(this.method_5477());
                                    ItemNameServiceComponent itemNameServiceComponent = new ItemNameServiceComponent(ServiceComponent86.resolveString(stack.method_7972().method_7964()), stack.method_7972(), SharedKt.getNumericValue());
                                    map.put(text, itemNameServiceComponent);
                                    if (((ItemNameServiceComponent) concurrentHashMap.remove(ServiceComponent86.resolveString(this.method_5477()))) == null) {
                                        return;
                                    }
                                    if ((SharedKt.getNumericValue() - flag.getNumericValue()) >= 1000L) {
                                        map = new Object[2];
                                        map[0] = ServiceComponent86.resolveString(this.method_5477());
                                        map[1] = flag.getString();
                                        stack = MessageServiceComponent.Z(INSTANCE, "used", map, false);
                                        if (INSTANCE.getUseTracker() != NotifierPastEffectsMode.NOTIFICATION) {
                                            if (INSTANCE.getUseTracker() == NotifierPastEffectsMode.BOTH) {
                                                TitleRenderHelper.INSTANCE.executeAction("", stack, 5, OptionMode16.INFO, flag.getMinecraftObject());
                                            }
                                        }
                                        if (0 != INSTANCE) {
                                            if (INSTANCE.getUseTracker() == NotifierPastEffectsMode.BOTH) {
                                                MessageServiceComponent.S(INSTANCE, stack, false);
                                            }
                                        }
                                    }
                                    map = ((Iterable) SharedKt.getWorld().getPlayers());
                                    text = 0;
                                    itemNameServiceComponent = map;
                                    Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(map, 10)));
                                    Iterator iterator2 = itemNameServiceComponent.iterator();
                                    while (iterator2.hasNext()) {
                                        Object element2 = iterator2.next();
                                        AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element2);
                                        collection.add(ServiceComponent86.resolveString(player.method_5477()));
                                    }
                                    stack = collection;
                                    concurrentHashMap.entrySet().removeIf(this::checkCondition);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (((class_2673) arg0.getPacket()).method_11532() != 2007) {
            if (arg0.getPacket() instanceof class_2673 && ((class_2673) arg0.getPacket()).method_11532() == 2002) {
                int index2 = ((class_2673) arg0.getPacket()).method_11534();
                iterable = (((index2 >> 16) & 255) / 255.0F);
                index = (((index2 >> 8) & 255) / 255.0F);
                iterator = (((index2 >> 0) & 255) / 255.0F);
                element = new Color(iterable, index, iterator);
                if (element.getRGB() == -13083194) {
                    return;
                }
                countValue = element.getRGB();
            }
        }
        if (this && arg0.getPacket() instanceof class_7439 && serviceComponent107.checkCondition(500)) {
            index2 = arg0.getPacket();
            TitleRenderHelper.executeAction(this.getString2(), MessageServiceComponent.Z(this, "mention", new Object[0], false), 3, OptionMode16.WARNING);
            if (StringsKt.contains$default(((CharSequence) ((class_7439) index2).comp_763.getString()), ((CharSequence) SharedKt.getPlayer().method_7334().name()), false) && serviceComponent104.checkCondition2(2500) && AssistantModule.INSTANCE.getEnabled()) {
                StartupServiceComponent.INSTANCE.getVecServiceComponent11().updateValue();
            }
        }
        index2 = SharedKt.getWorld().method_8469(((class_2775) arg0.getPacket()).method_11915());
        iterable = SharedKt.getWorld().method_8469(((class_2775) arg0.getPacket()).method_11912());
        index = ((class_1542) index2).method_6983().method_7972();
        if (this.getOnlyDon() && !(StringsKt.contains$default(((CharSequence) index.method_7964().getString().toLowerCase(Locale.ROOT)), ((CharSequence) "\u043a\u0440\u0443\u0448"), false)) && !(StringsKt.contains$default(((CharSequence) index.method_7964().getString()), ((CharSequence) "\u2605"), false))) {
            return;
        }
        if (iterable.method_5628() == SharedKt.getPlayer().method_5628()) {
            element = new Object[2];
            element[0] = ServiceComponent86.resolveString(index.method_7964());
            element[1] = Integer.valueOf(index.method_7947());
        } else {
            element = new Object[3];
            element[0] = ServiceComponent86.resolveString(iterable.method_5477());
            element[1] = ServiceComponent86.resolveString(index.method_7964());
            element[2] = Integer.valueOf(index.method_7947());
        }
        iterator = MessageServiceComponent.Z(this, "collector", element, false);
        if (this.getItemCollect() != NotifierPastEffectsMode.NOTIFICATION) {
            if (this.getItemCollect() == NotifierPastEffectsMode.BOTH) {
                TitleRenderHelper.INSTANCE.executeAction("", iterator, 5, OptionMode16.INFO, index);
            }
        }
        if (MessageServiceComponent.Z(this, "collect", element, false) != this) {
        }
        MessageServiceComponent.S(this, iterator, false);
        index2 = iterable;
        index2.printStackTrace();
    }

    private void onEntitySpawn(EntitySpawn arg0) {
        Object[] items = new Object[1];
        items[0] = arg0.getEntity().method_5477().getString();
        MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "range-enter", items, false), false);
        StartupServiceComponent.INSTANCE.getVecServiceComponent13().updateValue();
    }

    private void onEntityRemove(EntityRemove arg0) {
        if (this.getSplashBuff() != NotifierPastEffectsMode.OFF && arg0.getEntity() != null && arg0.getEntity() instanceof class_10691) {
            class_10691 class10691 = ((class_10691) arg0.getEntity());
            Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
            Iterable iterable2 = iterable;
            Collection collection = ((Collection) new ArrayList());
            int index = 0;
            Iterator iterator = iterable2.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
                int index2 = 0;
                if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                    if (INSTANCE.getSelf()) {
                    } else {
                    }
                }
                collection.add(element);
            }
            iterable = ((Iterable) collection);
            iterable2 = iterable.iterator();
            while (iterable2.hasNext()) {
                collection = iterable2.next();
                index = ((AbstractClientPlayerEntity) collection);
                iterator = 0;
                if (INSTANCE.getOld()) {
                } else {
                }
                element = class10691.method_5829().method_71490(index.method_5829().method_1014(class_1675.method_71624(class10691)));
                if (element < 16.0D) {
                    if (INSTANCE.getFtBypass() && StringsKt.contains$default(((CharSequence) ServiceComponent86.resolveString(class10691.method_7495().method_7964()).toLowerCase(Locale.ROOT)), ((CharSequence) "\u043d\u0435\u0441\u043e\u0437\u0434\u0430\u0432\u0430\u0435\u043c\u043e\u0435"), false)) {
                    } else {
                    }
                    index2 = class10691.method_7495();
                    double offset = (1.0D - (Math.sqrt(element) / 4.0D));
                    int index3 = (100 * offset);
                    if (index3 > 80) {
                    } else {
                        if (index3 > 50) {
                        } else {
                        }
                    }
                    String text = class_124.field_1061.toString();
                    Object[] items = new Object[4];
                    items[0] = ServiceComponent86.resolveString(index.method_5477());
                    items[1] = ServiceComponent86.resolveString(index2.method_7964());
                    items[2] = text;
                    items[3] = Integer.valueOf(index3);
                    String text2 = (MessageServiceComponent.Z(INSTANCE, "splash-buff", items, false));
                    if (INSTANCE.getSplashBuff() != NotifierPastEffectsMode.NOTIFICATION) {
                        if (INSTANCE.getSplashBuff() == NotifierPastEffectsMode.BOTH) {
                            TitleRenderHelper.INSTANCE.executeAction("", text2, 5, OptionMode16.WARNING, index2);
                        }
                    }
                    if (INSTANCE.getSplashBuff() != NotifierPastEffectsMode.CHAT) {
                        if (INSTANCE.getSplashBuff() == NotifierPastEffectsMode.BOTH) {
                            MessageServiceComponent.S(INSTANCE, text2, false);
                            if (((class_1844) index2.method_58694(class_9334.field_49651)) == null) {
                                return;
                            }
                            items = class_124.field_1054;
                            Iterable iterable3 = items.method_57397();
                            Iterator iterator2 = iterable3.iterator();
                            while (iterator2.hasNext()) {
                                class_1293 class1293 = ((class_1293) iterator2.next());
                                String text3 = String.valueOf((class1293.method_5578() + 1));
                                int index4 = (class1293.method_5584() * offset);
                                if (class1293.method_48559()) {
                                } else {
                                    String text4 = "%02d";
                                    Object[] items2 = new Object[1];
                                    items2[0] = Integer.valueOf(((index4 % 1200) / 20));
                                }
                                String text5 = ((index4 / 1200) + String.format(text4, Arrays.copyOf(items2, items2)));
                                if (((class_1291) class1293.method_5579().comp_349()).method_18792() == class_4081.field_18272) {
                                } else {
                                }
                                Object[] items3 = new Object[0];
                                String text6 = ((class_1291) class1293.method_5579().comp_349()).method_5567();
                                class_124.field_1061.method_7353(class_2561.method_30163(("" + KeyServiceComponent.INSTANCE.resolveString(text6, items3) + text3 + class_124.field_1070 + text5)), false);
                            }
                        }
                    }
                }
            }
        }
        class10691 = new Object[1];
        class10691[0] = arg0.getEntity().method_5477().getString();
        MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "range-leave", class10691, false), false);
        StartupServiceComponent.INSTANCE.getVecServiceComponent14().updateValue();
    }

    private void onPlayerEntityDeathEvent(PlayerEntityDeathEvent arg0) {
        Object[] items = new Object[1];
        items[0] = Integer.valueOf(arg0.getTotemsPopped());
        MessageServiceComponent.S(this, (arg0.getPlayer().method_5477().getString() + MessageServiceComponent.Z(this, "death", items, false)), false);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.resolveList().iterator();
        while (iterator.hasNext()) {
            class_2818 class2818 = ((class_2818) iterator.next());
            List list = class2818.method_12214().values().stream().toList();
            int index = 0;
            int index2 = 0;
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                class_2586 class2586 = ((class_2586) iterator2.next());
                if (class2586 instanceof class_2595) {
                }
            }
            itemList.add(class2818);
            int index3 = class2818.method_12004().method_33942();
            int index4 = class2818.method_12004().method_33940();
            iterator2 = ("Stash: X: " + index4 + " Z: " + index3 + " Chests: " + index + " Shulkers: " + index2);
            TitleRenderHelper.executeAction("Stash Logger", iterator2, 5, OptionMode16.SUCCESS);
            MessageServiceComponent.S(this, iterator2, false);
            if (serviceComponent109.checkCondition2(5000)) {
                StartupServiceComponent.INSTANCE.getVecServiceComponent17().updateValue();
            }
            class2586 = "unknown_server";
            if (SharedKt.getMc().method_1562().method_45734() != null && SharedKt.getMc().method_1562().method_45734().field_3761 != null) {
                class2586 = StringsKt.replace$default(SharedKt.getMc().method_1562().method_45734().field_3761, 58, 95, false);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(((Writer) new FileWriter(true)));
            bufferedWriter.append(((CharSequence) (iterator2)));
            bufferedWriter.close();
            bufferedWriter = this.getMinShulkers();
        }
        iterator = ((Iterable) itemList2);
        class2818 = 0;
        list = iterator;
        index = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterator, 10)));
        index2 = 0;
        iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            class2586 = iterator2.next();
            bufferedWriter = ((class_1293) class2586);
            int index5 = index;
            index5.add(bufferedWriter.method_5586());
        }
        iterator = ((Iterable) SharedKt.getPlayer().method_6026());
        index5 = ((Iterable) index);
        class2818 = 0;
        list = iterator;
        index = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterator, 10)));
        index2 = 0;
        iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            class2586 = iterator2.next();
            bufferedWriter = ((class_1293) class2586);
            index.add(bufferedWriter.method_5586());
        }
        iterator = ((Iterable) CollectionsKt.minus(index5, ((Iterable) CollectionsKt.toSet(((Iterable) index)))));
        class2818 = 0;
        list = iterator.iterator();
        while (list.hasNext()) {
            index = list.next();
            index2 = ((String) index);
            iterator2 = 0;
            if (INSTANCE.getPastEffects() != NotifierPastEffectsMode.NOTIFICATION) {
                if (INSTANCE.getPastEffects() == NotifierPastEffectsMode.BOTH) {
                    class2586 = new Object[1];
                    class2586[0] = KeyServiceComponent.INSTANCE.resolveString(index2, new Object[0]);
                    ItemStack stack = Items.field_8574.method_7854();
                    int index6 = 2;
                    OptionMode16 optionMode16 = OptionMode16.WARNING;
                    String text = MessageServiceComponent.Z(INSTANCE, "past-effect", class2586, false);
                    MessageServiceComponent.executeAction(INSTANCE, text, optionMode16, index6, stack);
                }
            }
            if (index2 != INSTANCE) {
                if (INSTANCE.getPastEffects() == NotifierPastEffectsMode.BOTH) {
                    class2586 = new Object[1];
                    class2586[0] = KeyServiceComponent.INSTANCE.resolveString(index2, new Object[0]);
                    MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "past-effect", class2586, false), false);
                }
            }
        }
        itemList2.clear();
        itemList2.addAll(SharedKt.getPlayer().method_6026());
    }

    private String resolveString(long arg0) {
        String text = "%.1f";
        Object[] items = new Object[1];
        items[0] = Float.valueOf((arg0 / 1000.0F));
        return String.format(text, Arrays.copyOf(items, items));
    }

    private void render(DrawContext arg0, MissingnoRenderHelper arg1, MissingnoRenderHelper arg2, String arg3, String arg4) {
        float factor = Math.max(SFMServiceComponent.resolveFontRenderHelper2().computeValue(arg4), SFMServiceComponent.resolveFontRenderHelper9().computeValue(arg3));
        int index = (((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (factor / 2.0F)) - 17.0F);
        int index2 = 360;
        if (index2 >= 180) {
        } else {
        }
        Color color = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, Color.YELLOW, (index2 / 360.0F));
        SFMServiceComponent.resolveFontRenderHelper9().render(arg0, arg3, index, 8.0F, color);
        SFMServiceComponent.resolveFontRenderHelper2().render(arg0, arg4, index, 20.0F, color);
        if (index2 > 90) {
        } else {
        }
        MissingnoRenderHelper.executeAction(arg2, ((Matrix3x2f) arg0.method_51448()), ((index + 5) + factor), 5.0D, 0.0F, 0.0F, color, null, 0.0F);
    }

    public void executeAction(String name, int count) {
        Object[] items = new Object[1];
        items[0] = Integer.valueOf(count);
        MessageServiceComponent.S(this, (name + MessageServiceComponent.Z(this, "totem", items, false)), false);
        StartupServiceComponent.INSTANCE.getVecServiceComponent12().updateValue();
    }

    private int computeValue(ItemStack arg0) {
        return (((arg0.method_7936() - arg0.method_7919()) / Math.max(0.1D, arg0.method_7936())) * 100.0F);
    }

    private static boolean isActive2() {
        return INSTANCE.getStash();
    }

    private static boolean isActive3() {
        return INSTANCE.getStash();
    }

    private static boolean isActive4() {
        return INSTANCE.getSplashBuff() != NotifierPastEffectsMode.OFF;
    }

    private static boolean isActive5() {
        return INSTANCE.getSplashBuff() != NotifierPastEffectsMode.OFF;
    }

    private static boolean isActive6() {
        return INSTANCE.getSplashBuff() != NotifierPastEffectsMode.OFF;
    }

    private static boolean isActive7() {
        return INSTANCE.getItemCollect() != NotifierPastEffectsMode.OFF;
    }

    private static boolean checkCondition(List arg0, Entry arg1) {
        String text = ((String) arg1.getKey());
        return !(arg0.contains(text));
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[18];
        INSTANCE = new NotifierModule();
        totemPopsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-pops", false);
        lowArmorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "low-armor", false);
        rangeEnterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range-enter", false);
        rangeLeaveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range-leave", false);
        lagSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lag", false);
        rubberBandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rubber-band", false);
        stashSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stash", false);
        minChestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-chests", 5, new IntRange(0, 100), null, this::isActive2);
        minShulkersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-shulkers", 0, new IntRange(0, 100), null, this::isActive3);
        mentionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mention", false);
        pastEffectsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "past-effects", NotifierPastEffectsMode.BOTH);
        splashBuffSetting = VisibleRenderHelper.registerSetting(INSTANCE, "splash-buff", NotifierPastEffectsMode.BOTH);
        ftBypassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ft-bypass", true, null, this::isActive4);
        selfSetting = VisibleRenderHelper.registerSetting(INSTANCE, "self", false, null, this::isActive5);
        oldSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pre-1.21", true, null, this::isActive6);
        itemCollectSetting = VisibleRenderHelper.registerSetting(INSTANCE, "item-collect", NotifierPastEffectsMode.BOTH);
        onlyDonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-don", false, null, this::isActive7);
        useTrackerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "use-tracker", NotifierPastEffectsMode.BOTH);
        missingnoRenderHelper = new MissingnoRenderHelper("armor", 30, 30);
        missingnoRenderHelper2 = new MissingnoRenderHelper("empty-armor", 30, 30);
        missingnoRenderHelper3 = new MissingnoRenderHelper("wifi", 30, 30);
        missingnoRenderHelper4 = new MissingnoRenderHelper("wifi-off", 30, 30);
        missingnoRenderHelper5 = new MissingnoRenderHelper("rewind", 30, 30);
        missingnoRenderHelper6 = new MissingnoRenderHelper("loudspeaker", 30, 30);
        missingnoRenderHelper7 = new MissingnoRenderHelper("loudspeaker-empty", 30, 30);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
        serviceComponent103 = new ServiceComponent10();
        serviceComponent104 = new ServiceComponent10();
        serviceComponent105 = new ServiceComponent10();
        serviceComponent106 = new ServiceComponent10();
        serviceComponent107 = new ServiceComponent10();
        serviceComponent108 = new ServiceComponent10();
        serviceComponent109 = new ServiceComponent10();
        itemList = new ArrayList();
        itemList2 = new ArrayList();
        concurrentHashMap = new ConcurrentHashMap();
        countValue = -999;
    }

}
