package su.catlean.client.features.modules.render.world;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1297.class_5529;
import net.minecraft.class_1707;
import net.minecraft.class_1735;
import net.minecraft.class_2371;
import net.minecraft.class_2561;
import net.minecraft.class_2716;
import net.minecraft.class_2767;
import net.minecraft.class_3417;
import net.minecraft.class_6880;
import net.minecraft.class_9290;
import net.minecraft.class_9323;
import net.minecraft.class_9334;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.SlotRenderEvent;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ItemServiceComponent3;
import su.catlean.client.services.client.ItemServiceComponent5;
import su.catlean.client.services.client.RunnableServiceComponent2;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.mixins.accessors.ClientboundRemoveEntitiesPacketAccessor;

public class ServerHelperModule extends Module {

    public static final ServerHelperModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl aucHelperSetting;
    private static final VisibleVisibleSettingPropertyImpl structureCooldownsSetting;
    private static final boolean enabledFlag;
    private static final List itemList;
    private static final List itemList2;
    private static final IntArrayList intArrayList;

    private ServerHelperModule() {
        super("server-helper", SubCategoriesKt.getWorldRenderCategory());
    }

    private boolean getAucHelper() {
        return ((Boolean) aucHelperSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getStructureCooldowns() {
        return ((Boolean) structureCooldownsSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (enabledFlag && arg0.getPacket() instanceof class_2716) {
            ClientboundRemoveEntitiesPacketAccessor clientboundRemoveEntitiesPacketAccessor = ((ClientboundRemoveEntitiesPacketAccessor) arg0.getPacket());
            IntArrayList list = new IntArrayList();
            Iterable iterable = ((Iterable) clientboundRemoveEntitiesPacketAccessor.getIds());
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                Integer integer = ((Integer) element);
                Iterable iterable2 = ((Iterable) SharedKt.getWorld().getPlayers());
                if (iterable2 instanceof Collection && ((Collection) iterable2).isEmpty()) {
                } else {
                    Iterator iterator2 = iterable2.iterator();
                    while (iterator2.hasNext()) {
                        Object element2 = iterator2.next();
                        AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element2);
                        if (integer == null) {
                            player.method_5628();
                        } else {
                        }
                    }
                }
                if (1) {
                } else {
                }
                intArrayList.add(integer);
            }
            ((ClientboundRemoveEntitiesPacketAccessor) arg0.getPacket()).setIds(((IntList) list));
        }
        if (!(Intrinsics.areEqual(((class_2767) arg0.getPacket()).method_11894().comp_349(), class_3417.field_15228))) {
            if (Intrinsics.areEqual(((class_2767) arg0.getPacket()).method_11894().comp_349(), class_3417.field_15134)) {
                RunnableServiceComponent2.executeAction(0, 0, false, this::onReceivePacket2);
            } else {
                clientboundRemoveEntitiesPacketAccessor = BlockPos.method_49637(((class_2767) arg0.getPacket()).method_11890(), ((class_2767) arg0.getPacket()).method_11889(), ((class_2767) arg0.getPacket()).method_11893());
                RunnableServiceComponent2.executeAction(5, 0, false, this::updateValue);
            }
        }
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        itemList.removeIf(this::checkCondition);
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ItemServiceComponent5 itemServiceComponent5 = ((ItemServiceComponent5) element);
            long time = ((itemServiceComponent5.getNumericValue() - SharedKt.getNumericValue()) / 50.0F);
            String text = "%02d";
            Object[] items = new Object[1];
            items[0] = Integer.valueOf(((time % 1200) / 20));
            String text2 = ((time / 1200) + String.format(text, Arrays.copyOf(items, items)));
            float factor = (SFMServiceComponent.resolveFontRenderHelper().computeValue(text2) + 22.0F);
            text = ((this.x + ((this.z - this.x) / 2.0F)) - (factor / 2));
            items = this.y;
            StackShaderComponent2.executeAction(arg0.getContext().method_51448(), text, items, factor, 16.0F, 3.0F, 1.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            arg0.getContext().method_51448().pushMatrix();
            arg0.getContext().method_51448().translate((text + 2.0F), (items + 2.0F));
            arg0.getContext().method_51448().scale(0.7F);
            arg0.getContext().method_51427(itemServiceComponent5.getMinecraftObject().method_7854(), 0, 0);
            arg0.getContext().method_51448().popMatrix();
            Color[] items2 = new Color[1];
            items2[0] = new Color(1157627903, true);
            PolygonShaderComponent.INSTANCE.executeAction(arg0.getContext().method_51448(), (text + 14), (items + 4.0F), 0.5F, 9.0F, items2);
            SFMServiceComponent.resolveFontRenderHelper().render(arg0.getContext(), text2, (text + 18.0F), (items + 3.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().field_7512 instanceof class_1707 && this.getAucHelper()) {
            class_1707 class1707 = ((class_1707) SharedKt.getPlayer().field_7512);
            String text = SharedKt.getMc().currentScreen.method_25440().getString();
            if (!(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u0410\u0443\u043a\u0446\u0438\u043e\u043d"), false))) {
                if (StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u041f\u043e\u0438\u0441\u043a"), false)) {
                    itemList2.clear();
                    Map map = ((Map) new LinkedHashMap());
                    int index = 0;
                    Iterator iterator = class1707.method_7602().iterator();
                    while (iterator.hasNext()) {
                        ItemStack stack = ((ItemStack) iterator.next());
                        int index2 = this.computeValue(stack);
                        if (stack.method_7947() > 1) {
                            index2 = (index2 / stack.method_7947());
                        }
                        map.put(this.resolveString(stack), Integer.valueOf(Math.min(((Number) map.getOrDefault(this.resolveString(stack), Integer.valueOf(999999999))), index2)));
                    }
                    index = 0;
                    iterator = class1707.method_7602().iterator();
                    while (iterator.hasNext()) {
                        stack = ((ItemStack) iterator.next());
                        if (map.get(this.resolveString(stack)) != null) {
                            index2 = this.computeValue(stack);
                            if (stack.method_7947() > 1) {
                                index2 = (index2 / stack.method_7947());
                            }
                            if (((Integer) map.get(this.resolveString(stack))) != null) {
                            } else {
                            }
                            int index3 = 99999999;
                            Item item = stack.getItem();
                            itemList2.add(new ItemServiceComponent3(item, index2, index3, index));
                        }
                    }
                }
            }
        }
        intArrayList.removeIf(this::checkCondition);
    }

    private String resolveString(ItemStack arg0) {
        String text = arg0.getItem().method_7876();
        return text;
    }

    private void onSlotRenderEvent(SlotRenderEvent arg0) {
        class_1735 class1735 = arg0.getSlot();
        DrawContext context = arg0.getContext();
        String text = SharedKt.getMc().currentScreen.method_25440().getString();
        int index = 4;
        if (!(StringsKt.contains$default(((CharSequence) text), ((CharSequence) "\u0410\u0443\u043a\u0446\u0438\u043e\u043d"), false))) {
        }
        Iterator iterator = itemList2.iterator();
        while (iterator.hasNext()) {
            ItemServiceComponent3 itemServiceComponent3 = ((ItemServiceComponent3) iterator.next());
            double offset = (Math.pow(itemServiceComponent3.getNumericValue2(), index) / Math.pow(itemServiceComponent3.getNumericValue(), index));
            context.method_25294(class1735.field_7873, class1735.field_7872, (class1735.field_7873 + 16), (class1735.field_7872 + 16), PolygonShaderComponent.INSTANCE.resolveColor(Color.GREEN, offset).getRGB());
            return;
        }
    }

    private int computeValue(ItemStack arg0) {
        if (((class_9290) arg0.method_57353().method_58694(class_9334.field_49632)) == null) {
            return 999999999;
        }
        if (SharedKt.getNetwork().method_45734() != null) {
            if (SharedKt.getNetwork().method_45734().field_3761 == null) {
            }
        }
        if (StringsKt.contains$default(((CharSequence) "singleplayer"), ((CharSequence) "holyworld"), false)) {
            Iterator iterator = this.comp_2400().iterator();
            while (iterator.hasNext()) {
                class_2561 class2561 = ((class_2561) iterator.next());
                Iterator iterator2 = class2561.method_10855().iterator();
                class_2561 class25612 = ((class_2561) iterator2.next());
                String text = class25612.getString();
                CharSequence charSequence = ((CharSequence) text);
                int index = 0;
                int index2 = 0;
                if (index2 < charSequence.length()) {
                    char ch = charSequence.charAt(index2);
                    if (Character.isDigit(ch)) {
                    }
                }
                return Integer.parseInt(StringsKt.replace$default(StringsKt.replace$default(text, " ", "", false), "\u00a4", "", false));
                iterator = this.comp_2400().iterator();
                while (iterator.hasNext()) {
                    class2561 = ((class_2561) iterator.next());
                    return Integer.parseInt(StringsKt.replace$default(StringsKt.replace$default(class2561.getString(), "$ \u0426\u0435\u043da $", "", false), ",", "", false));
                }
            }
        }
        return 9999999;
    }

    private List resolveList(BlockPos arg0, long arg1, int arg2, int arg3) {
        List list = new ArrayList();
        int index = (arg0.method_10263() - arg2);
        int index2 = (arg0.method_10263() + arg2);
        if (index <= index2) {
            int index3 = (arg0.method_10260() - arg2);
            int index4 = (arg0.method_10260() + arg2);
            if (arg1 > 0L) {
                if (index3 <= index4) {
                    int index5 = (arg0.method_10264() - arg3);
                    int index6 = (arg0.method_10264() + arg3);
                    list.add(new BlockPos(index, index5, index3));
                    if (index5 <= index6 && index5 != index6 && arg1 > 0L) {
                    }
                    if (arg1 > 0L) {
                        if (index3 != index4) {
                        }
                    }
                }
            }
            if (index != index2) {
            }
        }
        return list;
    }

    private static void onReceivePacket2(ReceivePacket arg0) {
        itemList.add(new ItemServiceComponent5((SharedKt.getNumericValue() + timestampValue), Items.field_22021));
    }

    private static void updateValue(BlockPos arg0) {
        Iterable iterable = ((Iterable) INSTANCE.resolveList(arg0, 4, 4));
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        index = 0;
        iterable2 = iterable.iterator();
        if (!(iterable2.hasNext())) {
        } else {
            collection = iterable2.next();
            if (!(iterable2.hasNext())) {
            } else {
                index2 = ((BlockPos) collection);
                iterator = 0;
                index2 = index2.toCenterPos().method_1022(arg0.toCenterPos());
                iterator = iterable2.next();
                element = ((BlockPos) iterator);
                blockPos = 0;
                element = element.toCenterPos().method_1022(arg0.toCenterPos());
                if (Double.compare(index2, element) > 0) {
                    collection = iterator;
                    index2 = element;
                }
            }
        }
        BlockPos blockPos2 = ((BlockPos) collection);
        index = ((Iterable) INSTANCE.resolveList(blockPos2, 1, 0));
        iterable2 = 0;
        if (index instanceof Collection) {
            if (((Collection) index).isEmpty()) {
            } else {
                collection = 0;
                index2 = index.iterator();
                while (index2.hasNext()) {
                    iterator = index2.next();
                    element = ((BlockPos) iterator);
                    blockPos = 0;
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
        }
        iterable = collection;
        if (iterable == 8) {
        } else {
        }
        index = 20000;
        if (iterable == 8) {
        } else {
        }
        itemList.add(new ItemServiceComponent5(this.method_1031(-0.5D, 0.0D, 0.0D), ((SharedKt.getNumericValue() + index) - 250), Items.field_8551));
    }

    private static boolean checkCondition(ItemServiceComponent5 arg0) {
        return (SharedKt.getNumericValue() - arg0.getNumericValue()) >= 0L;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(int arg0) {
        if (__UNDEF_KEY__ instanceof PlayerEntity && this.isAlive()) {
            if (!(SharedKt.getWorld().method_8477(this.method_24515()))) {
                SharedKt.getWorld().method_2945(arg0, class_5529.field_26998);
                return true;
            }
        }
        return false;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new ServerHelperModule();
        aucHelperSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auc-helper", true);
        structureCooldownsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "structure-cooldowns", true);
        itemList = new ArrayList();
        itemList2 = new ArrayList();
        intArrayList = new IntArrayList();
    }

}
