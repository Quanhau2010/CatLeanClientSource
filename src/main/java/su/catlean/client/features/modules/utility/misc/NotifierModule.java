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
        return (Boolean) totemPopsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getLowArmor() {
        return (Boolean) lowArmorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getRangeEnter() {
        return (Boolean) rangeEnterSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getRangeLeave() {
        return (Boolean) rangeLeaveSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getLag() {
        return (Boolean) lagSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getRubberBand() {
        return (Boolean) rubberBandSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getStash() {
        return (Boolean) stashSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private int getMinChests() {
        return (Number) minChestsSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private int getMinShulkers() {
        return (Number) minShulkersSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getMention() {
        return (Boolean) mentionSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private NotifierPastEffectsMode getPastEffects() {
        return (NotifierPastEffectsMode) pastEffectsSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private NotifierPastEffectsMode getSplashBuff() {
        return (NotifierPastEffectsMode) splashBuffSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private boolean getFtBypass() {
        return (Boolean) ftBypassSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getSelf() {
        return (Boolean) selfSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getOld() {
        return (Boolean) oldSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private NotifierPastEffectsMode getItemCollect() {
        return (NotifierPastEffectsMode) itemCollectSetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private boolean getOnlyDon() {
        return (Boolean) onlyDonSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private NotifierPastEffectsMode getUseTracker() {
        return (NotifierPastEffectsMode) useTrackerSetting.getValue(this, DELEGATED_PROPERTIES[17]);
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
            this.render(arg0.getContext(), missingnoRenderHelper6, missingnoRenderHelper7, MessageServiceComponent.Z(this, "air-alarm-header", new Object[0]), MessageServiceComponent.Z(this, "air-alarm", new Object[0]));
        }
        if (this.getLowArmor()) {
            Iterator iterator = EntityHelper2.resolveList(SharedKt.getPlayer()).iterator();
            if (iterator.hasNext()) {
                ItemStack stack = (ItemStack) iterator.next();
                this.render(arg0.getContext(), missingnoRenderHelper, missingnoRenderHelper2, MessageServiceComponent.Z(this, "low-armor-title", new Object[0]), MessageServiceComponent.Z(this, "low-armor-text", new Object[0]));
                StartupServiceComponent.INSTANCE.getVecServiceComponent10().updateValue();
                return;
            }
        }
        if (!(serviceComponent103.checkCondition2(60000)) || !(AssistantModule.INSTANCE.getEnabled()) || this.getLag()) {
            return;
        }
        iterator = new Object[1];
        iterator[0] = this.resolveString(EventPacketHelper2.INSTANCE.getNumericValue4());
        this.render(arg0.getContext(), missingnoRenderHelper5, missingnoRenderHelper5, MessageServiceComponent.Z(this, "flag-title", new Object[0]), MessageServiceComponent.Z(this, "flag-text", iterator));
        StartupServiceComponent.INSTANCE.getVecServiceComponent8().updateValue();
    }

    private void onSendPacket(SendPacket arg0) {
        serviceComponent107.executeAction();
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (var40 != null) {
            if (arg0.getPacket() instanceof class_2739) {
                if (SharedKt.getWorld().method_8469((class_2739) arg0.getPacket().comp_1127()) == null) {
                    SharedKt.getWorld().method_8469((class_2739) arg0.getPacket().comp_1127());
                    return;
                }
                if (var40 != null) {
                }
                if (!(var41 instanceof PlayerEntity) || Intrinsics.areEqual(SharedKt.getPlayer())) {
                    return;
                }
                Iterable var42 = (Iterable) (class_2739) arg0.getPacket().comp_1128();
                int var43 = 0;
                Iterator iterator = var42.iterator();
                if (iterator.hasNext()) {
                    Object var45 = iterator.next();
                    class_7834 var46 = (class_7834) var45;
                    int var47 = 0;
                    if (var40 != null) {
                        if (var40 != null) {
                            if (Intrinsics.areEqual(String.valueOf(var46.comp_1115()), "8")) {
                                if (var40 != null) {
                                    if (!(Intrinsics.areEqual(var46.comp_1117().toString(), "1"))) {
                                        if (var40 != null) {
                                            if (Intrinsics.areEqual(var46.comp_1117().toString(), "3")) {
                                            }
                                        }
                                        boolean var48 = Intrinsics.areEqual(var46.comp_1117().toString(), "3");
                                        if (var48) {
                                        }
                                        ItemStack stack = Hand.field_5810.method_5998(Hand.field_5808);
                                        if (var40 != null) {
                                            if (var40 != null) {
                                                if (!(stack.method_57353().method_57832(class_9334.field_50075))) {
                                                }
                                                if (stack != null && stack.method_57353().method_57832(class_9334.field_49651)) {
                                                }
                                                Map var50 = (Map) concurrentHashMap;
                                                String var51 = ServiceComponent86.resolveString((PlayerEntity) var41.method_5477());
                                                ItemNameServiceComponent var52 = new ItemNameServiceComponent(ServiceComponent86.resolveString(stack.method_7972().method_7964()), stack.method_7972(), SharedKt.getNumericValue());
                                                var50.put();
                                                if (var40 == null) {
                                                }
                                            }
                                            if ((ItemNameServiceComponent) concurrentHashMap.remove(ServiceComponent86.resolveString((PlayerEntity) var41.method_5477())) == null) {
                                                return;
                                            }
                                            var48 = (PlayerEntity) var41;
                                            if ((SharedKt.getNumericValue() - var48.getNumericValue()) >= 1000L) {
                                                var50 = new Object[2];
                                                var50[0] = ServiceComponent86.resolveString((PlayerEntity) var41.method_5477());
                                                var50[1] = var48.getString();
                                                stack = MessageServiceComponent.Z(INSTANCE, "used");
                                                if (var40 != null) {
                                                    if (INSTANCE.getUseTracker() != NotifierPastEffectsMode.NOTIFICATION) {
                                                    }
                                                    if (var40 != null) {
                                                        if (INSTANCE.getUseTracker() == NotifierPastEffectsMode.BOTH) {
                                                        }
                                                        TitleRenderHelper.INSTANCE.executeAction("", stack, 5, OptionMode16.INFO, var48.getMinecraftObject());
                                                    }
                                                }
                                                if (INSTANCE.getUseTracker() != NotifierPastEffectsMode.CHAT) {
                                                    if (var40 != null && var40 != null) {
                                                        if (INSTANCE.getUseTracker() == NotifierPastEffectsMode.BOTH) {
                                                        }
                                                    }
                                                    MessageServiceComponent.S(INSTANCE, stack);
                                                }
                                            }
                                            var50 = (Iterable) SharedKt.getWorld().getPlayers();
                                            var51 = 0;
                                            var52 = var50;
                                            Collection var53 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
                                            int var54 = 0;
                                            Iterator iterator2 = var52.iterator();
                                            if (iterator2.hasNext()) {
                                                Object var56 = iterator2.next();
                                                AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var56;
                                                Object var58 = var53;
                                                int var59 = 0;
                                                var58.add(ServiceComponent86.resolveString(player.method_5477()));
                                                if (var40 != null) {
                                                }
                                                stack = var53;
                                                concurrentHashMap.entrySet().removeIf(this::checkCondition);
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
        if (arg0.getPacket() instanceof class_2673) {
            if (var40 != null) {
                if ((class_2673) arg0.getPacket().method_11532() != 2007) {
                    if (var40 != null && var40 != null) {
                        if ((class_2673) arg0.getPacket().method_11532() == 2002) {
                        }
                    }
                    int var41 = (class_2673) arg0.getPacket().method_11534();
                    var42 = (((var41 >> 16) & 255) / 255.0F);
                    var43 = (((var41 >> 8) & 255) / 255.0F);
                    iterator = (((var41 >> 0) & 255) / 255.0F);
                    var45 = new Color(iterator);
                    if (var40 != null) {
                        if (var45.getRGB() == -13083194) {
                            return;
                        }
                    }
                    countValue = var45.getRGB();
                }
            }
            if (var40 != null) {
            }
            if (var40 != null) {
            }
            if (this.getMention() && arg0.getPacket() instanceof class_7439 && serviceComponent107.checkCondition(500)) {
                var41 = arg0.getPacket();
                if (var40 != null) {
                    TitleRenderHelper.executeAction(this.getString2(), MessageServiceComponent.Z(this, "mention", new Object[0]), 3, OptionMode16.WARNING);
                }
                if (var40 != null) {
                }
                if (StringsKt.contains$default((CharSequence) (class_7439) var41.comp_763.getString(), (CharSequence) SharedKt.getPlayer().method_7334().name()) && serviceComponent104.checkCondition2(2500) && AssistantModule.INSTANCE.getEnabled()) {
                    StartupServiceComponent.INSTANCE.getVecServiceComponent11().updateValue();
                }
            }
        }
        var41 = SharedKt.getWorld().method_8469((class_2775) arg0.getPacket().method_11915());
        var42 = SharedKt.getWorld().method_8469((class_2775) arg0.getPacket().method_11912());
        if (var40 != null) {
        }
        if (var40 != null) {
        }
        var43 = (class_1542) var41.method_6983().method_7972();
        if (var40 != null) {
        }
        if (this.getOnlyDon()) {
            if (!(StringsKt.contains$default((CharSequence) var43.method_7964().getString().toLowerCase(Locale.ROOT), (CharSequence) "\u043a\u0440\u0443\u0448"))) {
                if (var40 != null && var40 != null && var40 != null) {
                    if (!(StringsKt.contains$default((CharSequence) var43.method_7964().getString(), (CharSequence) "\u2605"))) {
                        return;
                    }
                }
            }
        }
        if (var42.method_5628() == SharedKt.getPlayer().method_5628()) {
            var45 = new Object[2];
            var45[0] = ServiceComponent86.resolveString(var43.method_7964());
            var45[1] = Integer.valueOf(var43.method_7947());
        } else {
            var45 = new Object[3];
            var45[0] = ServiceComponent86.resolveString(var42.method_5477());
            var45[1] = ServiceComponent86.resolveString(var43.method_7964());
            var45[2] = Integer.valueOf(var43.method_7947());
        }
        iterator = MessageServiceComponent.Z(this, "collector");
        if (var40 != null) {
            if (this.getItemCollect() != NotifierPastEffectsMode.NOTIFICATION) {
            }
            if (var40 != null) {
                if (this.getItemCollect() == NotifierPastEffectsMode.BOTH) {
                }
                TitleRenderHelper.INSTANCE.executeAction("", iterator, 5, OptionMode16.INFO);
            }
        }
        if (this.getItemCollect() != NotifierPastEffectsMode.CHAT) {
            if (var40 != null && var40 != null) {
            }
        }
        MessageServiceComponent.S(this, iterator);
        var41 = MessageServiceComponent.Z(this, "collect");
        var41.printStackTrace();
    }

    private void onEntitySpawn(EntitySpawn arg0) {
        Object[] var21 = new Object[1];
        var21[0] = arg0.getEntity().method_5477().getString();
        MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "range-enter"));
        StartupServiceComponent.INSTANCE.getVecServiceComponent13().updateValue();
    }

    private void onEntityRemove(EntityRemove arg0) {
        if (this.getSplashBuff() != NotifierPastEffectsMode.OFF && arg0.getEntity() != null && arg0.getEntity() instanceof class_10691) {
            class_10691 var41 = (class_10691) arg0.getEntity();
            Iterable var42 = (Iterable) SharedKt.getWorld().getPlayers();
            int var43 = 0;
            Object var44 = var42;
            Collection var45 = (Collection) new ArrayList();
            int var46 = 0;
            Iterator iterator = var44.iterator();
            while (iterator.hasNext()) {
                Object var48 = iterator.next();
                AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var48;
                int var50 = 0;
                if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                    if (INSTANCE.getSelf()) {
                    }
                } else {
                }
                var45.add();
            }
            var42 = (Iterable) var45;
            var43 = 0;
            var44 = var42.iterator();
            while (var44.hasNext()) {
                var45 = var44.next();
                var46 = (AbstractClientPlayerEntity) var45;
                iterator = 0;
                if (INSTANCE.getOld()) {
                } else {
                }
                var48 = var41.method_5829().method_71490(var46.method_5829().method_1014(class_1675.method_71624()));
                if (var48 < 16.0D) {
                    if (INSTANCE.getFtBypass() && StringsKt.contains$default((CharSequence) ServiceComponent86.resolveString(var41.method_7495().method_7964()).toLowerCase(Locale.ROOT), (CharSequence) "\u043d\u0435\u0441\u043e\u0437\u0434\u0430\u0432\u0430\u0435\u043c\u043e\u0435")) {
                    } else {
                    }
                    var50 = var41.method_7495();
                    double var51 = (1.0D - (Math.sqrt() / 4.0D));
                    int var53 = (100 * var51);
                    if (var53 > 80) {
                    } else {
                        if (var53 > 50) {
                        } else {
                        }
                    }
                    String var54 = class_124.field_1061.toString();
                    Object[] var55 = new Object[4];
                    var55[0] = ServiceComponent86.resolveString(var46.method_5477());
                    var55[1] = ServiceComponent86.resolveString(var50.method_7964());
                    var55[2] = var54;
                    var55[3] = Integer.valueOf();
                    String var56 = (MessageServiceComponent.Z(INSTANCE, "splash-buff"));
                    if (INSTANCE.getSplashBuff() != NotifierPastEffectsMode.NOTIFICATION) {
                        if (INSTANCE.getSplashBuff() == NotifierPastEffectsMode.BOTH) {
                        }
                        TitleRenderHelper.INSTANCE.executeAction("", 5, OptionMode16.WARNING);
                    }
                    if (INSTANCE.getSplashBuff() != NotifierPastEffectsMode.CHAT) {
                        if (INSTANCE.getSplashBuff() == NotifierPastEffectsMode.BOTH) {
                        }
                        MessageServiceComponent.S(INSTANCE);
                        if ((class_1844) var50.method_58694(class_9334.field_49651) == null) {
                            return;
                        }
                        var55 = class_124.field_1054;
                        Iterable var57 = var55.method_57397();
                        Iterator iterator2 = var57.iterator();
                        while (iterator2.hasNext()) {
                            class_1293 var59 = (class_1293) iterator2.next();
                            String var60 = String.valueOf((var59.method_5578() + 1));
                            int var61 = (var59.method_5584() * var51);
                            if (var59.method_48559()) {
                            } else {
                                String var62 = "%02d";
                                Object[] var63 = new Object[1];
                                var63[0] = Integer.valueOf(((var61 % 1200) / 20));
                            }
                            String var64 = ((var61 / 1200) + String.format(Arrays.copyOf()));
                            if ((class_1291) var59.method_5579().comp_349().method_18792() == class_4081.field_18272) {
                            } else {
                            }
                            Object[] var38 = new Object[0];
                            String var39 = (class_1291) var59.method_5579().comp_349().method_5567();
                            class_124.field_1061.method_7353(class_2561.method_30163(("" + KeyServiceComponent.INSTANCE.resolveString() + var60 + class_124.field_1070 + var64)), 0);
                        }
                    }
                }
            }
        }
        var41 = new Object[1];
        var41[0] = arg0.getEntity().method_5477().getString();
        MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "range-leave"));
        StartupServiceComponent.INSTANCE.getVecServiceComponent14().updateValue();
    }

    private void onPlayerEntityDeathEvent(PlayerEntityDeathEvent arg0) {
        if (var11 != null) {
        }
        Object[] var12 = new Object[1];
        var12[0] = Integer.valueOf(arg0.getTotemsPopped());
        MessageServiceComponent.S(this, (arg0.getPlayer().method_5477().getString() + MessageServiceComponent.Z(this, "death")));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var41 != null) {
            if (this.getStash()) {
                Iterator iterator = TheNetherPacketHelper.INSTANCE.resolveList().iterator();
                while (iterator.hasNext()) {
                    class_2818 var43 = (class_2818) iterator.next();
                    if (var41 != null) {
                        if (var41 != null) {
                        }
                        List positions = var43.method_12214().values().stream().toList();
                        int var45 = 0;
                        int var46 = 0;
                        Iterator iterator2 = positions.iterator();
                        if (iterator2.hasNext()) {
                            class_2586 var48 = (class_2586) iterator2.next();
                            if (var41 != null) {
                                if (var41 != null) {
                                    if (var48 instanceof class_2595) {
                                    }
                                }
                            }
                        }
                        if (var41 != null) {
                        }
                        if (var41 != null) {
                            itemList.add();
                        }
                        int var53 = var46;
                        int var54 = var45;
                        int var55 = var43.method_12004().method_33942();
                        int var56 = var43.method_12004().method_33940();
                        iterator2 = ("Stash: X: " + var56 + " Z: " + var55 + " Chests: " + var54 + " Shulkers: " + var53);
                        TitleRenderHelper.executeAction("Stash Logger", iterator2, 5, OptionMode16.SUCCESS);
                        MessageServiceComponent.S(this, iterator2);
                        if (serviceComponent109.checkCondition2(5000)) {
                            StartupServiceComponent.INSTANCE.getVecServiceComponent17().updateValue();
                        }
                        var48 = "unknown_server";
                        if (var41 != null) {
                            if (var41 != null) {
                                if (SharedKt.getMc().method_1562().method_45734() != null && SharedKt.getMc().method_1562().method_45734().field_3761 != null) {
                                }
                                var48 = StringsKt.replace$default(SharedKt.getMc().method_1562().method_45734().field_3761);
                            }
                        }
                        BufferedWriter var49 = new BufferedWriter((Writer) new FileWriter(new File(ServiceComponent65.getFile3(), (var48 + ".txt")), 1));
                        var49.append((CharSequence) (iterator2));
                        var49.close();
                    }
                }
            }
        }
        iterator = (Iterable) itemList2;
        var43 = 0;
        positions = iterator;
        var45 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterator, 10));
        var46 = 0;
        iterator2 = positions.iterator();
        if (iterator2.hasNext()) {
            var48 = iterator2.next();
            var49 = (class_1293) var48;
            Object var51 = var45;
            int var50 = 0;
            var51.add(var49.method_5586());
            if (var41 != null) {
            }
            iterator = (Iterable) SharedKt.getPlayer().method_6026();
            var51 = (Iterable) var45;
            var43 = 0;
            positions = iterator;
            var45 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterator, 10));
            var46 = 0;
        }
        iterator2 = positions.iterator();
        if (iterator2.hasNext()) {
            var48 = iterator2.next();
            var49 = (class_1293) var48;
            Object var52 = var45;
            var50 = 0;
            var52.add(var49.method_5586());
            if (var41 != null) {
            }
            iterator = (Iterable) CollectionsKt.minus((Iterable) CollectionsKt.toSet((Iterable) var45));
            var43 = 0;
        }
        positions = iterator.iterator();
        if (positions.hasNext()) {
            var45 = positions.next();
            var46 = (String) var45;
            iterator2 = 0;
            if (var41 != null) {
                if (var41 != null) {
                    if (INSTANCE.getPastEffects() != NotifierPastEffectsMode.NOTIFICATION) {
                        if (var41 != null) {
                            if (INSTANCE.getPastEffects() == NotifierPastEffectsMode.BOTH) {
                            }
                        }
                        var48 = new Object[1];
                        var48[0] = KeyServiceComponent.INSTANCE.resolveString(new Object[0]);
                        ItemStack stack = Items.field_8574.method_7854();
                        int var37 = 2;
                        OptionMode16 var38 = OptionMode16.WARNING;
                        String var39 = MessageServiceComponent.Z(INSTANCE, "past-effect");
                        Module var40 = INSTANCE;
                        MessageServiceComponent.executeAction(stack);
                    }
                }
                if (INSTANCE.getPastEffects() != NotifierPastEffectsMode.CHAT) {
                    if (var41 != null && var41 != null) {
                        if (INSTANCE.getPastEffects() == NotifierPastEffectsMode.BOTH) {
                        }
                    }
                    var48 = new Object[1];
                    var48[0] = KeyServiceComponent.INSTANCE.resolveString(new Object[0]);
                    MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "past-effect"));
                }
            }
            itemList2.clear();
        }
        itemList2.addAll(SharedKt.getPlayer().method_6026());
    }

    private String resolveString(long arg0) {
        String var5 = "%.1f";
        Object[] var6 = new Object[1];
        var6[0] = Float.valueOf((arg0 / 1000.0F));
        return String.format(Arrays.copyOf());
    }

    private void render(DrawContext arg0, MissingnoRenderHelper arg1, MissingnoRenderHelper arg2, String arg3, String arg4) {
        float var23 = Math.max(SFMServiceComponent.resolveFontRenderHelper2().computeValue(arg4), SFMServiceComponent.resolveFontRenderHelper9().computeValue(arg3));
        int var24 = (((SharedKt.getMc().method_22683().method_4486() / 2.0F) - (var23 / 2.0F)) - 17.0F);
        int var25 = 360;
        if (var25 >= 180) {
        } else {
        }
        Color var26 = PolygonShaderComponent.INSTANCE.resolveColor(Color.RED, Color.YELLOW, (var25 / 360.0F));
        SFMServiceComponent.resolveFontRenderHelper9().render(arg0, arg3, 8.0F);
        SFMServiceComponent.resolveFontRenderHelper2().render(arg0, arg4, 20.0F);
        if (var25 > 90) {
        } else {
        }
        MissingnoRenderHelper.executeAction(arg2, (Matrix3x2f) arg0.method_51448(), ((var24 + 5) + var23), 5.0D, 0.0F, 0.0F, null, 0.0F);
    }

    public void executeAction(String name, int count) {
        Object[] var19 = new Object[1];
        var19[0] = Integer.valueOf(count);
        MessageServiceComponent.S(this, (name + MessageServiceComponent.Z(this, "totem")));
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
        String var5 = (String) arg1.getKey();
        return !(arg0.contains());
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var43 = new KProperty[18];
        INSTANCE = new NotifierModule();
        totemPopsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-pops");
        lowArmorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "low-armor");
        rangeEnterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range-enter");
        rangeLeaveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range-leave");
        lagSetting = VisibleRenderHelper.registerSetting(INSTANCE, "lag");
        rubberBandSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rubber-band");
        stashSetting = VisibleRenderHelper.registerSetting(INSTANCE, "stash");
        minChestsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-chests", 5, new IntRange(0, 100), null, this::isActive2);
        minShulkersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "min-shulkers", 0, new IntRange(0, 100), null, this::isActive3);
        mentionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mention");
        pastEffectsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "past-effects", NotifierPastEffectsMode.BOTH);
        splashBuffSetting = VisibleRenderHelper.registerSetting(INSTANCE, "splash-buff", NotifierPastEffectsMode.BOTH);
        ftBypassSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ft-bypass", 1, null, this::isActive4);
        selfSetting = VisibleRenderHelper.registerSetting(INSTANCE, "self", 0, null, this::isActive5);
        oldSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pre-1.21", 1, null, this::isActive6);
        itemCollectSetting = VisibleRenderHelper.registerSetting(INSTANCE, "item-collect", NotifierPastEffectsMode.BOTH);
        onlyDonSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-don", 0, null, this::isActive7);
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
