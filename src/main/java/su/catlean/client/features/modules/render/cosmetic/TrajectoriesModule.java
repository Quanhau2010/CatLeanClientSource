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
        return ((KeyRecord) previewBindSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setPreviewBind(KeyRecord value) {
        previewBindSetting.setValue(this, DELEGATED_PROPERTIES[0], value);
    }

    private boolean getHandOffset() {
        return ((Boolean) handOffsetSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setHandOffset(boolean value) {
        handOffsetSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private boolean checkCondition(Item arg0) {
        if (!(arg0 instanceof class_1776) && !(arg0 instanceof class_1835) && !(arg0 instanceof class_1779) && !(arg0 instanceof class_1823) && !(arg0 instanceof class_1771) && !(arg0 instanceof class_1828)) {
            if (arg0 instanceof class_1803) {
            } else {
            }
        }
        return false;
    }

    private float computeValue(Item arg0) {
        if (arg0 instanceof class_1753) {
        }
        return 0.4F;
    }

    private float computeValue2(Item arg0) {
        if (!(arg0 instanceof class_1828)) {
            if (arg0 instanceof class_1803) {
                return 0.39F;
            }
        }
        if (arg0 instanceof class_1779) {
            return 0.59F;
        }
        if (arg0 instanceof class_1835) {
            return 2.0F;
        }
        return 1.5F;
    }

    private int computeValue(Item arg0, long arg1) {
        if (!(arg0 instanceof class_1828) && !(arg0 instanceof class_1803)) {
            if (arg0 instanceof class_1779) {
            } else {
            }
        }
        return 0;
    }

    private float computeValue(Item arg0) {
        if (!(arg0 instanceof class_1828) && !(arg0 instanceof class_1803)) {
            if (arg0 instanceof class_1779) {
            }
        }
        return 0.5F;
    }

    private void onFreecamStateEvent(FreecamStateEvent arg0) {
        if (vec3d == null || this.getPreviewBind().getNumericValue() == -1 || !(ServiceComponent13.checkCondition(this.getPreviewBind().getNumericValue())) || SharedKt.getMc().method_1560() == null) {
            return;
        }
        arg0.cancel();
        float factor = easingServiceComponent.getNumericValue();
        Vec3d vec = vec3d.method_1031(0.0D, SharedKt.getPlayer().method_18381(SharedKt.getPlayer().method_18376()), 0.0D);
        Vec3d vec2 = SharedKt.getPlayer().getEyePos();
        Vec3d vec3 = TextShaderComponent2.INSTANCE.resolveMinecraftObject(vec2, vec, factor);
        arg0.setX(vec3.field_1352);
        arg0.setY(vec3.field_1351);
        arg0.setZ(vec3.field_1350);
        arg0.setYaw(SharedKt.getMc().method_1560().method_36454());
        arg0.setPitch(0.0F);
    }

    private void onTickEvent(TickEvent arg0) {
        vec3d2 = this.method_18798();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (ServiceComponent13.checkCondition(this.getPreviewBind().getNumericValue())) {
        }
        this.executeAction(0.0F);
        vec3d = null;
        boolean flag = ((Boolean) SharedKt.getMc().options.method_42448().method_41753());
        SharedKt.getMc().options.method_42448().method_41748(Boolean.valueOf(false));
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            ItemStack stack = player.method_6047();
            ItemStack stack2 = player.method_6079();
            if (!(stack.getItem() instanceof class_1753) && !(stack.getItem() instanceof class_1764)) {
                if (this.checkCondition(stack.getItem())) {
                }
            }
            if (!(stack2.getItem() instanceof class_1753) && !(stack2.getItem() instanceof class_1764)) {
            }
            Hand hand = Hand.field_5810;
            if (!(this.checkCondition(stack2.getItem())) || hand == Hand.field_5810) {
                continue;
            }
            Item item = stack.getItem();
            item = StackServiceComponent3.checkCondition(stack2, class_1893.field_9108);
            boolean flag2 = StackServiceComponent3.checkCondition(stack, class_1893.field_9108);
            float factor = PolygonShaderComponent.INSTANCE.computeValue(player.field_5982, player.method_36454());
            if (stack2.getItem() instanceof class_1764) {
                if (!(item)) {
                    if (flag2) {
                        this.executeAction(((PlayerEntity) player), item, (factor - 10));
                        this.executeAction(((PlayerEntity) player), item, factor);
                        this.executeAction(((PlayerEntity) player), item, (factor + 10));
                    }
                }
            }
            this.executeAction(((PlayerEntity) player), item, factor);
        }
        SharedKt.getMc().options.method_42448().method_41748(Boolean.valueOf(flag));
    }

    public void executeAction(PlayerEntity player, Item item, float yaw) {
        vec3d = null;
        double offset = this.computeValue(PolygonShaderComponent.INSTANCE, player.field_6014, player.getX());
        double offset2 = this.computeValue(PolygonShaderComponent.INSTANCE, player.field_6036, player.getY());
        double offset3 = this.computeValue(PolygonShaderComponent.INSTANCE, player.field_5969, player.getZ());
        offset2 = (offset2 + player.method_18381(player.method_18376()));
        if (__UNDEF_KEY__ != null) {
            if (this.getHandOffset()) {
                offset2 = (offset2 - 0.1D);
                if (__UNDEF_KEY__ != null) {
                    if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                        if (Intrinsics.areEqual(item, player.method_6079().getItem())) {
                            offset = (offset + (Math.cos(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                            offset3 = (offset3 + (Math.sin(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                            if (__UNDEF_KEY__ == null) {
                                offset = (offset - (Math.cos(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                                offset3 = (offset3 - (Math.sin(((yaw / 180.0F) * 3.1415927F)) * 0.16F));
                            }
                        }
                    }
                }
            }
        }
        float factor = PolygonShaderComponent.INSTANCE.computeValue(player.field_6004, player.method_36455());
        float factor2 = this.computeValue(item);
        double offset4 = ((Math.sin(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((factor / 180.0F) * 3.1415927F))) * factor2);
        double offset5 = (Math.sin((((factor - this.computeValue(item)) / 180.0F) * 3.141593F)) * factor2);
        double offset6 = ((Math.cos(((yaw / 180.0F) * 3.1415927F)) * Math.cos(((factor / 180.0F) * 3.1415927F))) * factor2);
        float factor3 = (PolygonShaderComponent.INSTANCE.computeValue(Math.max(0.0F, (player.method_6048() - 1.0F)), player.method_6048()) / 20.0F);
        factor3 = (((factor3 * factor3) + (factor3 * 2.0F)) / 3.0F);
        if (__UNDEF_KEY__ != null) {
            if (factor3 <= 1.0F) {
                if (__UNDEF_KEY__ != null) {
                    if (factor3 == 0.0F) {
                    } else {
                    }
                }
                if (0) {
                    factor3 = 1.0F;
                }
            }
        }
        float factor4 = class_3532.method_15355((((offset4 * offset4) + (offset5 * offset5)) + (offset6 * offset6)));
        offset4 = (offset4 / factor4);
        offset5 = (offset5 / factor4);
        offset6 = (offset6 / factor4);
        if (__UNDEF_KEY__ != null) {
            if (item instanceof class_1753) {
            }
        }
        if (item instanceof class_1764) {
        }
        float factor5 = (1.0F * this.computeValue2(item));
        offset4 = (offset4 * factor5);
        offset5 = (offset5 * factor5);
        offset6 = (offset6 * factor5);
        if (__UNDEF_KEY__ != null) {
            if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                offset4 = (offset4 + this.computeValue(PolygonShaderComponent.INSTANCE, vec3d2.field_1352, player.method_18798().field_1352));
                offset5 = (offset5 + this.computeValue(PolygonShaderComponent.INSTANCE, vec3d2.field_1351, player.method_18798().field_1351));
                offset6 = (offset6 + this.computeValue(PolygonShaderComponent.INSTANCE, vec3d2.field_1350, player.method_18798().field_1350));
            }
        }
        int index = 0;
        Vec3d vec = new Vec3d(offset, offset2, offset3);
        offset = (offset + offset4);
        offset2 = (offset2 + offset5);
        offset3 = (offset3 + offset6);
        if (__UNDEF_KEY__ != null) {
            if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.method_49637(offset, offset2, offset3)).getBlock(), Blocks.BEDROCK)) {
                offset4 = (offset4 * 0.8D);
                offset5 = (offset5 * 0.8D);
                offset6 = (offset6 * 0.8D);
                if (__UNDEF_KEY__ == null) {
                    offset4 = (offset4 * 0.99D);
                    offset5 = (offset5 * 0.99D);
                    offset6 = (offset6 * 0.99D);
                }
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (item instanceof class_1753) {
            }
        }
        if (player.method_6047().getItem() instanceof class_1764) {
        }
        offset5 = (0.05000000074505806D - 0.03D);
        Vec3d vec2 = new Vec3d(offset, offset2, offset3);
        class_3965 class3965 = SharedKt.getWorld().method_17742(new class_3959(vec, vec2, class_3960.field_17558, class_242.field_1348, player));
        if (class3965.method_17783() == class_240.field_1332) {
            if (BowMinecartModule.INSTANCE.checkCondition()) {
                Box box = new Box(class3965.method_17777().up()).method_35578((class3965.method_17777().up().method_10264() + 0.125D));
                double offset7 = SharedKt.getMc().player.method_55754();
                double offset8 = SharedKt.getPlayer().getEyePos().method_1022(class3965.method_17777().toCenterPos());
                if (__UNDEF_KEY__ != null) {
                    if (2.299999952316284D <= offset8) {
                        if (__UNDEF_KEY__ != null) {
                            if (offset8 <= offset7) {
                            }
                        }
                    } else {
                    }
                }
                if (0) {
                }
                Color color = Color.RED;
                TextShaderComponent2.checkCondition(box, color);
                TextShaderComponent2.checkCondition(box, PolygonShaderComponent.INSTANCE.resolveColor(color, (PolygonShaderComponent.INSTANCE.computeValue2(color) / 4.0F)));
                if (__UNDEF_KEY__ == null) {
                    Color color2 = NewThemeRenderHelper.INSTANCE.resolveColor((index * 10));
                    Direction direction = class3965.method_17780();
                    float factor6 = this.computeValue(item);
                    Vec3d vec3 = class3965.method_17784();
                    this.executeAction(vec3, factor6, direction, color2);
                }
            }
            TextShaderComponent2.checkCondition(vec, class3965.method_17784(), NewThemeRenderHelper.INSTANCE.resolveColor(index), null, false);
            if (__UNDEF_KEY__ != null) {
            }
            if (item instanceof class_1776 && Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                vec3d = class3965.method_17784();
            }
        }
        color = SharedKt.getWorld().method_18112();
        offset7 = 0;
        offset8 = color;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = offset8.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Entity entity = element;
            int index3 = 0;
            if (__UNDEF_KEY__ != null) {
            }
            if (__UNDEF_KEY__ != null) {
            }
            if (__UNDEF_KEY__ != null) {
                if (entity.method_5707(vec2) >= 25.0D) {
                    if (__UNDEF_KEY__ != null) {
                        if (!(entity instanceof class_1676) && !(Intrinsics.areEqual(entity, SharedKt.getMc().player)) && entity.method_5707(vec) < 25.0D) {
                        } else {
                        }
                    }
                }
            }
            collection.add(element);
        }
        box = collection;
        color = 0;
        offset7 = ((Iterable) box);
        offset8 = 0;
        collection = offset7.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = index2;
            element = 0;
            entity = iterator.method_5829();
            index3 = entity.method_992(vec, vec2);
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                    if (__UNDEF_KEY__ != null) {
                        if (index3.isPresent() && !(color)) {
                            TextShaderComponent2.checkCondition(vec, ((Vec3d) index3.get()), NewThemeRenderHelper.INSTANCE.resolveColor(index), null, false);
                            color = 1;
                            if (__UNDEF_KEY__ != null) {
                                if (__UNDEF_KEY__ != null) {
                                    if (item instanceof class_1776 && Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                                        vec3d = iterator.method_5829().method_1005();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (color) {
            }
        }
        if (__UNDEF_KEY__ != null) {
        }
        if (__UNDEF_KEY__ != null) {
            if (offset4 == 0.0D) {
            } else {
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (offset5 == 0.0D) {
            } else {
            }
        }
        if (0 && 0) {
            if (__UNDEF_KEY__ != null) {
                if (offset6 == 0.0D) {
                } else {
                }
            }
            if (!(0)) {
                TextShaderComponent2.checkCondition(vec, vec2, NewThemeRenderHelper.INSTANCE.resolveColor(index), null, false);
            }
        }
    }

    private void executeAction(Vec3d arg0, short arg1, float arg2, Direction arg3, Color arg4) {
        List list = new ArrayList();
        double offset = arg0.field_1352;
        double offset2 = arg0.field_1351;
        double offset3 = arg0.field_1350;
        int index = 10;
        int index2 = 0;
        int index3 = ProgressionUtilKt.getProgressionLastElement(0, 360, index);
        if (__UNDEF_KEY__ != null) {
            if (index2 <= index3) {
                int index4 = ((index2 * 3.141592653589793D) / 180.0D);
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                double offset4 = ((Number) noWhenBranchMatchedException.component1());
                double offset5 = ((Number) noWhenBranchMatchedException.component2());
                double offset6 = ((Number) noWhenBranchMatchedException.component3());
                list.add(new Vec3d((offset + offset4), (offset2 + offset5), (offset3 + offset6)));
                if (arg1 > 0) {
                    if (__UNDEF_KEY__ != null) {
                        if (index2 != index3) {
                            index2 = (index2 + index);
                        }
                        index2 = 0;
                        if (arg1 >= 0) {
                        }
                    }
                }
            }
        }
        index3 = (list.size() - 1);
        if (index2 < index3) {
            TextShaderComponent2.checkCondition(((Vec3d) list.get(index2)), ((Vec3d) list.get((index2 + 1))), arg4, null, false);
        }
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new TrajectoriesModule();
        previewBindSetting = VisibleRenderHelper.registerSetting(INSTANCE, "preview", new KeyRecord(0, false, false));
        handOffsetSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hand-offset", false);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        vec3d2 = Vec3d.ZERO;
    }

}
