package su.catlean.client.features.modules.render.cosmetic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1676;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1771;
import net.minecraft.class_1776;
import net.minecraft.class_1779;
import net.minecraft.class_1803;
import net.minecraft.class_1823;
import net.minecraft.class_1828;
import net.minecraft.class_1835;
import net.minecraft.class_1893;
import net.minecraft.class_239.class_240;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_7172;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.TickEvent;
import su.catlean.api.event.events.player.FreecamStateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.legit.BowMinecartModule;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ServiceComponent103;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.TpYawSmootherMode;

public class TrajectoriesModule extends Module {

    public static final TrajectoriesModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl2 previewBindSetting;
    private static final VisibleVisibleSettingPropertyImpl handOffsetSetting;
    private static Vec3d vec3d;
    private static final EasingServiceComponent easingServiceComponent;
    private static Vec3d vec3d2;

    private TrajectoriesModule() {
        super("trajectories", SubCategoriesKt.getCosmeticCategory());
    }

    private KeyRecord getPreviewBind() {
        return (KeyRecord) previewBindSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private void setPreviewBind(KeyRecord value) {
        previewBindSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getHandOffset() {
        return (Boolean) handOffsetSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setHandOffset(boolean value) {
        handOffsetSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean checkCondition(Item arg0) {
        if (!(arg0 instanceof class_1776)) {
            if (!(arg0 instanceof class_1835)) {
                if (!(arg0 instanceof class_1779)) {
                    if (!(arg0 instanceof class_1823)) {
                        if (!(arg0 instanceof class_1771)) {
                            if (!(arg0 instanceof class_1828)) {
                                if (var4 != null && var4 != null && var4 != null && var4 != null && var4 != null && var4 != null && var4 != null) {
                                    if (arg0 instanceof class_1803) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
        }
        return false;
    }

    private float computeValue(Item arg0) {
        if (arg0 instanceof class_1753) {
        }
        return 0.4F;
    }

    private float computeValue2(Item arg0) {
        if (var4 != null) {
            if (!(arg0 instanceof class_1828)) {
            }
            if (var4 != null) {
                if (arg0 instanceof class_1803) {
                }
                return 0.39F;
            }
        }
        if (var4 != null) {
            if (arg0 instanceof class_1779) {
                return 0.59F;
            }
        }
        if (arg0 instanceof class_1835) {
            return 2.0F;
        }
        return 1.5F;
    }

    private int computeValue(Item arg0, long arg1) {
        if (!(arg0 instanceof class_1828)) {
            if (!(arg0 instanceof class_1803)) {
                if (var4 != null && var4 != null && var4 != null) {
                    if (arg0 instanceof class_1779) {
                    }
                }
            }
        } else {
        }
        return 0;
    }

    private float computeValue(Item arg0) {
        if (var4 != null) {
        }
        if (var4 != null) {
            if (!(arg0 instanceof class_1828) && !(arg0 instanceof class_1803)) {
            }
            if (arg0 instanceof class_1779) {
            }
        }
        return 0.5F;
    }

    private void onFreecamStateEvent(FreecamStateEvent arg0) {
        if (var18 != null) {
        }
        if (vec3d == null || this.getPreviewBind().getNumericValue() == -1 || !(ServiceComponent13.checkCondition(this.getPreviewBind().getNumericValue())) || SharedKt.getMc().method_1560() == null) {
            return;
        }
        arg0.cancel();
        float var15 = easingServiceComponent.getNumericValue();
        Vec3d vec = vec3d.method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        Vec3d vec2 = SharedKt.getPlayer().getEyePos();
        Vec3d vec3 = TextShaderComponent2.INSTANCE.resolveMinecraftObject(vec2, vec);
        arg0.setX(vec3.field_1352);
        arg0.setY(vec3.field_1351);
        arg0.setZ(vec3.field_1350);
        arg0.setYaw(SharedKt.getMc().method_1560().method_36454());
        arg0.setPitch(0.0F);
    }

    private void onTickEvent(TickEvent arg0) {
        if (var6 != null) {
            if (SharedKt.getMc().player != null) {
                ClientPlayerEntity player = SharedKt.getMc().player;
                int var8 = 0;
                vec3d2 = player.method_18798();
            } else {
            }
        }
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (ServiceComponent13.checkCondition(this.getPreviewBind().getNumericValue())) {
        }
        1.0F.executeAction(0.0F);
        vec3d = null;
        boolean var24 = (Boolean) SharedKt.getMc().options.method_42448().method_41753();
        SharedKt.getMc().options.method_42448().method_41748(Boolean.valueOf(0));
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
            ItemStack stack = player.method_6047();
            ItemStack stack2 = player.method_6079();
            if (var23 != null) {
            }
            if (var23 != null) {
                if (!(stack.getItem() instanceof class_1753) && !(stack.getItem() instanceof class_1764)) {
                }
                if (var23 != null) {
                    if (this.checkCondition(stack.getItem())) {
                    }
                }
            }
            if (var23 != null) {
            }
            if (var23 != null) {
                if (!(stack2.getItem() instanceof class_1753) && !(stack2.getItem() instanceof class_1764)) {
                }
            }
            Hand var29 = Hand.field_5810;
            if (var23 == null || !(this.checkCondition(stack2.getItem())) || var29 == Hand.field_5810) {
                continue;
            }
            Item var31 = stack.getItem();
            Object var30 = var31;
            var31 = StackServiceComponent3.checkCondition(stack2, class_1893.field_9108);
            boolean var32 = StackServiceComponent3.checkCondition(stack, class_1893.field_9108);
            float var33 = PolygonShaderComponent.INSTANCE.computeValue(player.field_5982, player.method_36454());
            if (stack2.getItem() instanceof class_1764) {
                if (var23 != null && var23 != null) {
                    if (!(var31)) {
                    }
                }
                if (var23 != null) {
                }
                if (stack.getItem() instanceof class_1764 && var32) {
                }
                this.executeAction((PlayerEntity) player, (var33 - 10));
                this.executeAction((PlayerEntity) player);
                this.executeAction((PlayerEntity) player, (var33 + 10));
            }
            this.executeAction((PlayerEntity) player);
        }
        SharedKt.getMc().options.method_42448().method_41748(Boolean.valueOf());
    }

    public void executeAction(PlayerEntity player, Item item, float yaw) {
        vec3d = null;
        double var51 = var44.computeValue(PolygonShaderComponent.INSTANCE, player.field_6014, player.getX());
        double var53 = var44.computeValue(PolygonShaderComponent.INSTANCE, player.field_6036, player.getY());
        double var55 = var44.computeValue(PolygonShaderComponent.INSTANCE, player.field_5969, player.getZ());
        var53 = (var53 + player.method_18381(player.method_18376()));
        if (var50 != null) {
            if (this.getHandOffset()) {
                var53 = (var53 - 0.1D);
            }
            if (var50 != null) {
                if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                }
                if (Intrinsics.areEqual(item, player.method_6079().getItem())) {
                    var51 = (var51 + (Math.cos(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                    var55 = (var55 + (Math.sin(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                    if (var50 == null) {
                    }
                    var51 = (var51 - (Math.cos(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                    var55 = (var55 - (Math.sin(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                }
            }
        }
        float var57 = PolygonShaderComponent.INSTANCE.computeValue(player.field_6004, player.method_36455());
        float var58 = this.computeValue(item);
        double var59 = ((Math.sin(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((var57 / 180.0F) * 3.1415927F))) * var58);
        double var61 = (Math.sin((((var57 - this.computeValue(item)) / 180.0F) * 3.141593F)) * var58);
        double var63 = ((Math.cos(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((var57 / 180.0F) * 3.1415927F))) * var58);
        float var65 = (PolygonShaderComponent.INSTANCE.computeValue(Math.max(0.0F, (player.method_6048() - 1.0F)), player.method_6048()) / 20.0F);
        var65 = (((var65 * var65) + (var65 * 2.0F)) / 3.0F);
        if (var50 != null) {
            if (var65 <= 1.0F) {
                if (var50 != null) {
                    if (var65 == 0.0F) {
                    }
                } else {
                }
                if (0) {
                }
            }
            var65 = 1.0F;
        }
        float var66 = class_3532.method_15355((((var59 * var59) + (var61 * var61)) + (var63 * var63)));
        var59 = (var59 / var66);
        var61 = (var61 / var66);
        var63 = (var63 / var66);
        if (var50 != null) {
            if (item instanceof class_1753) {
            }
        }
        if (item instanceof class_1764) {
        }
        float var67 = (1.0F * this.computeValue2(item));
        var59 = (var59 * var67);
        var61 = (var61 * var67);
        var63 = (var63 * var67);
        if (var50 != null) {
            if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                var59 = (var59 + var44.computeValue(PolygonShaderComponent.INSTANCE, vec3d2.field_1352, player.method_18798().field_1352));
                var61 = (var61 + var44.computeValue(PolygonShaderComponent.INSTANCE, vec3d2.field_1351, player.method_18798().field_1351));
            }
            var63 = (var63 + var44.computeValue(PolygonShaderComponent.INSTANCE, vec3d2.field_1350, player.method_18798().field_1350));
        }
        int var69 = 0;
        Vec3d vec = new Vec3d();
        var51 = (var51 + var59);
        var53 = (var53 + var61);
        var55 = (var55 + var63);
        if (var50 != null) {
            if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.method_49637()).getBlock(), Blocks.BEDROCK)) {
                var59 = (var59 * 0.8D);
                var61 = (var61 * 0.8D);
                var63 = (var63 * 0.8D);
                if (var50 == null) {
                }
                var59 = (var59 * 0.99D);
                var61 = (var61 * 0.99D);
            }
            var63 = (var63 * 0.99D);
        }
        if (var50 != null) {
            if (item instanceof class_1753) {
            }
        }
        if (player.method_6047().getItem() instanceof class_1764) {
        }
        var61 = (0.05000000074505806D - 0.03D);
        Vec3d vec2 = new Vec3d();
        class_3965 var71 = SharedKt.getWorld().method_17742(new class_3959(vec, vec2, class_3960.field_17558, class_242.field_1348, player));
        if (var71.method_17783() == class_240.field_1332) {
            if (BowMinecartModule.INSTANCE.checkCondition()) {
                Box var72 = new Box(var71.method_17777().up()).method_35578((var71.method_17777().up().method_10264() + 0.125D));
                double var74 = SharedKt.getMc().player.method_55754();
                double var75 = SharedKt.getPlayer().getEyePos().method_1022(var71.method_17777().toCenterPos());
                if (var50 != null) {
                    if (2.299999952316284D <= var75) {
                    }
                    if (var50 != null) {
                        if (var75 <= var74) {
                        }
                    }
                } else {
                }
                if (0) {
                }
                Color var73 = Color.RED;
                TextShaderComponent2.checkCondition();
                TextShaderComponent2.checkCondition(PolygonShaderComponent.INSTANCE.resolveColor((PolygonShaderComponent.INSTANCE.computeValue2() / 4.0F)));
                if (var50 == null) {
                }
                Color var46 = NewThemeRenderHelper.INSTANCE.resolveColor((var69 * 10));
                Direction var47 = var71.method_17780();
                float var48 = this.computeValue(item);
                Vec3d vec3 = var71.method_17784();
                this.executeAction(vec3);
            }
            TextShaderComponent2.checkCondition(vec, var71.method_17784(), NewThemeRenderHelper.INSTANCE.resolveColor());
            if (var50 != null) {
            }
            if (item instanceof class_1776 && Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                vec3d = var71.method_17784();
            }
        }
        var73 = SharedKt.getWorld().method_18112();
        var74 = 0;
        var75 = var73;
        Collection var76 = (Collection) new ArrayList();
        int var77 = 0;
        Iterator iterator = var75.iterator();
        if (iterator.hasNext()) {
            Object var79 = iterator.next();
            Entity entity = var79;
            int var81 = 0;
            if (var50 != null) {
            }
            if (var50 != null) {
            }
            if (var50 != null) {
                if (entity.method_5707(vec2) >= 25.0D) {
                    if (var50 != null) {
                        if (!(entity instanceof class_1676) && !(Intrinsics.areEqual(entity, SharedKt.getMc().player)) && entity.method_5707(vec) < 25.0D) {
                        }
                    }
                }
            } else {
            }
            var76.add();
        }
        var72 = var76;
        var73 = 0;
        var74 = (Iterable) var72;
        var75 = 0;
        var76 = var74.iterator();
        if (var76.hasNext()) {
            var77 = var76.next();
            iterator = var77;
            var79 = 0;
            entity = iterator.method_5829();
            var81 = entity.method_992(vec, vec2);
            int var82 = 0;
            if (var50 != null) {
                if (var50 != null) {
                    if (var50 != null) {
                        if (var81.isPresent() && !(var73)) {
                            TextShaderComponent2.checkCondition(vec, (Vec3d) var81.get(), NewThemeRenderHelper.INSTANCE.resolveColor());
                            var73 = 1;
                            if (var50 != null) {
                            }
                            if (var50 != null) {
                                if (item instanceof class_1776 && Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                                }
                                vec3d = iterator.method_5829().method_1005();
                            }
                        }
                    }
                }
            }
        }
        if (var50 != null) {
            if (var73) {
            }
        }
        if (var50 != null) {
        }
        if (var50 != null) {
            if (var59 == 0.0D) {
            }
        } else {
        }
        if (var50 != null) {
            if (var61 == 0.0D) {
            }
        } else {
        }
        if (0 && 0) {
            if (var50 != null) {
                if (var63 == 0.0D) {
                }
            } else {
            }
            if (!(0)) {
            }
            TextShaderComponent2.checkCondition(vec, vec2, NewThemeRenderHelper.INSTANCE.resolveColor());
        }
    }

    private void executeAction(Vec3d arg0, short arg1, float arg2, Direction arg3, Color arg4) {
        List positions = new ArrayList();
        double var15 = arg0.field_1352;
        double var17 = arg0.field_1351;
        double var19 = arg0.field_1350;
        int var21 = 10;
        int var22 = 0;
        int var23 = ProgressionUtilKt.getProgressionLastElement(0, 360);
        if (var13 != null) {
            if (var22 <= var23) {
                int var24 = ((var22 * 3.141592653589793D) / 180.0D);
                NoWhenBranchMatchedException var26 = new NoWhenBranchMatchedException();
                double var27 = (Number) var26.component1();
                double var29 = (Number) var26.component2();
                double var31 = (Number) var26.component3();
                positions.add(new Vec3d((var15 + var27), (var17 + var29), (var19 + var31)));
                if (arg1 > 0) {
                    if (var13 != null) {
                        if (var22 != var23) {
                            var22 = (var22 + var21);
                        }
                    }
                    var22 = 0;
                    if (arg1 >= 0) {
                    }
                }
            }
        }
        var23 = (positions.size() - 1);
        if (var22 < var23) {
            TextShaderComponent2.checkCondition((Vec3d) positions.get(), (Vec3d) positions.get((var22 + 1)), arg4);
        }
    }

    static {
        KProperty[] var40 = new KProperty[2];
        INSTANCE = new TrajectoriesModule();
        previewBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "preview", new KeyRecord());
        handOffsetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hand-offset");
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        vec3d2 = Vec3d.ZERO;
    }

}
