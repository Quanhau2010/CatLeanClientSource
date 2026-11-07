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
        return (Boolean) aucHelperSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getStructureCooldowns() {
        return (Boolean) structureCooldownsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (enabledFlag && arg0.getPacket() instanceof class_2716) {
            ClientboundRemoveEntitiesPacketAccessor var11 = (ClientboundRemoveEntitiesPacketAccessor) arg0.getPacket();
            IntArrayList positions = new IntArrayList();
            Iterable var13 = (Iterable) var11.getIds();
            int var14 = 0;
            Iterator iterator = var13.iterator();
            while (iterator.hasNext()) {
                Object var16 = iterator.next();
                Integer var17 = (Integer) var16;
                int var18 = 0;
                Iterable var19 = (Iterable) SharedKt.getWorld().getPlayers();
                int var20 = 0;
                if (var19 instanceof Collection && (Collection) var19.isEmpty()) {
                } else {
                    Iterator iterator2 = var19.iterator();
                    if (iterator2.hasNext()) {
                        Object var22 = iterator2.next();
                        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var22;
                        int var24 = 0;
                        if (var17 == null) {
                            player.method_5628();
                        } else {
                        }
                    } else {
                    }
                }
                if (1) {
                } else {
                }
                intArrayList.add();
            }
            (ClientboundRemoveEntitiesPacketAccessor) arg0.getPacket().setIds((IntList) positions);
        }
        if (!(Intrinsics.areEqual((class_2767) arg0.getPacket().method_11894().comp_349(), class_3417.field_15228))) {
            if (Intrinsics.areEqual((class_2767) arg0.getPacket().method_11894().comp_349(), class_3417.field_15134)) {
            }
            RunnableServiceComponent2.executeAction(0, 0, 0, this::onReceivePacket2);
        } else {
            var11 = BlockPos.method_49637((class_2767) arg0.getPacket().method_11890(), (class_2767) arg0.getPacket().method_11889(), (class_2767) arg0.getPacket().method_11893());
            RunnableServiceComponent2.executeAction(5, 0, 0, this::updateValue);
        }
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        itemList.removeIf(this::checkCondition);
        Iterable var20 = (Iterable) itemList;
        int var21 = 0;
        Iterator iterator = var20.iterator();
        while (iterator.hasNext()) {
            Object var23 = iterator.next();
            ItemServiceComponent5 var24 = (ItemServiceComponent5) var23;
            int var25 = 0;
            long var27 = ((var24.getNumericValue() - SharedKt.getNumericValue()) / 50.0F);
            String var28 = "%02d";
            Object[] var29 = new Object[1];
            var29[0] = Integer.valueOf(((var27 % 1200) / 20));
            String var30 = ((var27 / 1200) + String.format(Arrays.copyOf()));
            float var31 = (SFMServiceComponent.resolveFontRenderHelper().computeValue() + 22.0F);
            var28 = ((var26.x + ((var26.z - var26.x) / 2.0F)) - (var31 / 2));
            var29 = var26.y;
            StackShaderComponent2.executeAction(arg0.getContext().method_51448(), 16.0F, 3.0F, 1.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
            arg0.getContext().method_51448().pushMatrix();
            arg0.getContext().method_51448().translate((var28 + 2.0F), (var29 + 2.0F));
            arg0.getContext().method_51448().scale(0.7F);
            arg0.getContext().method_51427(var24.getMinecraftObject().method_7854(), 0, 0);
            arg0.getContext().method_51448().popMatrix();
            Color[] var32 = new Color[1];
            var32[0] = new Color(1157627903, 1);
            PolygonShaderComponent.INSTANCE.executeAction(arg0.getContext().method_51448(), (var28 + 14), (var29 + 4.0F), 0.5F, 9.0F);
            SFMServiceComponent.resolveFontRenderHelper().render(arg0.getContext(), (var28 + 18.0F), (var29 + 3.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().field_7512 instanceof class_1707 && this.getAucHelper()) {
            class_1707 var20 = (class_1707) SharedKt.getPlayer().field_7512;
            String var21 = SharedKt.getMc().currentScreen.method_25440().getString();
            if (!(StringsKt.contains$default((CharSequence) var21, (CharSequence) "\u0410\u0443\u043a\u0446\u0438\u043e\u043d"))) {
                if (StringsKt.contains$default((CharSequence) var21, (CharSequence) "\u041f\u043e\u0438\u0441\u043a")) {
                }
                itemList2.clear();
                Map var22 = (Map) new LinkedHashMap();
                int var23 = 0;
                Iterator iterator = var20.method_7602().iterator();
                while (iterator.hasNext()) {
                    ItemStack stack = (ItemStack) iterator.next();
                    int var26 = this.computeValue(stack);
                    if (stack.method_7947() > 1) {
                        var26 = (var26 / stack.method_7947());
                    }
                    var22.put(this.resolveString(stack), Integer.valueOf(Math.min((Number) var22.getOrDefault(this.resolveString(stack), Integer.valueOf(999999999)))));
                }
                var23 = 0;
                iterator = var20.method_7602().iterator();
                while (iterator.hasNext()) {
                    stack = (ItemStack) iterator.next();
                    if (var22.get(this.resolveString(stack)) != null) {
                        var26 = this.computeValue(stack);
                        if (stack.method_7947() > 1) {
                            var26 = (var26 / stack.method_7947());
                        }
                        if ((Integer) var22.get(this.resolveString(stack)) != null) {
                        } else {
                        }
                        int var15 = var23;
                        int var16 = 99999999;
                        int var17 = var26;
                        Item var18 = stack.getItem();
                        itemList2.add(new ItemServiceComponent3());
                    }
                }
            }
        }
        intArrayList.removeIf(this::checkCondition);
    }

    private String resolveString(ItemStack arg0) {
        String var2 = arg0.getItem().method_7876();
        return var2;
    }

    private void onSlotRenderEvent(SlotRenderEvent arg0) {
        class_1735 var12 = arg0.getSlot();
        DrawContext context = arg0.getContext();
        String var14 = SharedKt.getMc().currentScreen.method_25440().getString();
        int var15 = 4;
        if (!(StringsKt.contains$default((CharSequence) var14, (CharSequence) "\u0410\u0443\u043a\u0446\u0438\u043e\u043d"))) {
        }
        Iterator iterator = itemList2.iterator();
        ItemServiceComponent3 var17 = (ItemServiceComponent3) iterator.next();
        double var18 = (Math.pow(var17.getNumericValue2()) / Math.pow(var17.getNumericValue()));
        context.method_25294(var12.field_7873, var12.field_7872, (var12.field_7873 + 16), (var12.field_7872 + 16), PolygonShaderComponent.INSTANCE.resolveColor(Color.GREEN).getRGB());
    }

    private int computeValue(ItemStack arg0) {
        if (var6 == null) {
            if ((class_9290) arg0.method_57353().method_58694(class_9334.field_49632) == null) {
            }
            return 999999999;
        }
        if (var6 == null) {
            if (SharedKt.getNetwork().method_45734() != null) {
                if (var6 == null) {
                    if (SharedKt.getNetwork().method_45734().field_3761 == null) {
                    }
                }
            }
        }
        if (StringsKt.contains$default((CharSequence) "singleplayer", (CharSequence) "holyworld")) {
            Iterator iterator = var7.comp_2400().iterator();
            if (iterator.hasNext()) {
                class_2561 var9 = (class_2561) iterator.next();
                if (var6 == null) {
                }
                Iterator iterator2 = var9.method_10855().iterator();
                class_2561 var11 = (class_2561) iterator2.next();
                String var12 = var11.getString();
                CharSequence var13 = (CharSequence) var12;
                int var14 = 0;
                int var15 = 0;
                int var16 = 0;
                if (var16 < var13.length()) {
                    char var17 = var13.charAt();
                    int var18 = var17;
                    int var19 = 0;
                    if (var6 == null) {
                        if (var6 == null) {
                            if (Character.isDigit()) {
                            }
                        }
                    }
                }
                return Integer.parseInt(StringsKt.replace$default(StringsKt.replace$default(" ", ""), "\u00a4", ""));
            }
            iterator = var7.comp_2400().iterator();
            if (iterator.hasNext()) {
                var9 = (class_2561) iterator.next();
                return Integer.parseInt(StringsKt.replace$default(StringsKt.replace$default(var9.getString(), "$ \u0426\u0435\u043da $", ""), ",", ""));
            }
        }
        return 9999999;
    }

    private List resolveList(BlockPos arg0, long arg1, int arg2, int arg3) {
        List positions = new ArrayList();
        int var11 = (arg0.method_10263() - arg2);
        int var12 = (arg0.method_10263() + arg2);
        if (var11 <= var12) {
            int var13 = (arg0.method_10260() - arg2);
            int var14 = (arg0.method_10260() + arg2);
            if (arg1 > 0L) {
                if (var13 <= var14) {
                }
                int var15 = (arg0.method_10264() - arg3);
                int var16 = (arg0.method_10264() + arg3);
                positions.add(new BlockPos());
                if (var15 <= var16 && var15 != var16 && arg1 > 0L) {
                }
                if (arg1 > 0L) {
                    if (var13 != var14) {
                    }
                }
            }
            if (var11 != var12) {
            }
        }
        return positions;
    }

    private static void onReceivePacket2(ReceivePacket arg0) {
        itemList.add(new ItemServiceComponent5(new Vec3d((class_2767) arg0.getPacket().method_11890(), (class_2767) arg0.getPacket().method_11889(), (class_2767) arg0.getPacket().method_11893()), (SharedKt.getNumericValue() + timestampValue), Items.field_22021));
    }

    private static void updateValue(BlockPos arg0) {
        Iterable var12 = (Iterable) INSTANCE.resolveList(arg0, 4, 4);
        int var13 = 0;
        Object var14 = var12;
        Collection var15 = (Collection) new ArrayList();
        int var16 = 0;
        Iterator iterator = var14.iterator();
        while (iterator.hasNext()) {
            Object var19 = iterator.next();
            BlockPos blockPos = (BlockPos) var19;
            int var22 = 0;
            var15.add();
        }
        var12 = (Iterable) var15;
        var13 = 0;
        var14 = var12.iterator();
        if (!(var14.hasNext())) {
        } else {
            var15 = var14.next();
            if (!(var14.hasNext())) {
            } else {
                var16 = (BlockPos) var15;
                iterator = 0;
                var16 = var16.toCenterPos().method_1022(arg0.toCenterPos());
                iterator = var14.next();
                var19 = (BlockPos) iterator;
                blockPos = 0;
                var19 = var19.toCenterPos().method_1022(arg0.toCenterPos());
                if (Double.compare() > 0) {
                    var15 = iterator;
                    var16 = var19;
                }
            }
        }
        BlockPos blockPos2 = (BlockPos) var15;
        var13 = (Iterable) INSTANCE.resolveList(blockPos2, 1, 0);
        var14 = 0;
        if (var13 instanceof Collection) {
            if ((Collection) var13.isEmpty()) {
            }
        } else {
            var15 = 0;
            var16 = var13.iterator();
            while (var16.hasNext()) {
                iterator = var16.next();
                var19 = (BlockPos) iterator;
                blockPos = 0;
                CollectionsKt.throwCountOverflow();
            }
        }
        }
        var12 = var15;
        if (var12 == 8) {
        } else {
        }
        var13 = 20000;
        if (var12 == 8) {
        } else {
        }
        blockPos2.toCenterPos().<init>(0.0D.method_1031(-0.5D, 0.0D, 0.0D), ((SharedKt.getNumericValue() + var13) - 250), Items.field_8551);
    }

    private static boolean checkCondition(ItemServiceComponent5 arg0) {
        return (SharedKt.getNumericValue() - arg0.getNumericValue()) >= 0L;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(int arg0) {
        if (var6 instanceof PlayerEntity && (PlayerEntity) var6.isAlive()) {
            if (!(SharedKt.getWorld().method_8477((PlayerEntity) var6.method_24515()))) {
            }
            SharedKt.getWorld().method_2945(arg0, class_5529.field_26998);
            return true;
        }
        return false;
    }

    static {
        KProperty[] var31 = new KProperty[2];
        INSTANCE = new ServerHelperModule();
        aucHelperSetting = VisibleRenderHelper.registerSetting(INSTANCE, "auc-helper");
        structureCooldownsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "structure-cooldowns");
        itemList = new ArrayList();
        itemList2 = new ArrayList();
        intArrayList = new IntArrayList();
    }

}
