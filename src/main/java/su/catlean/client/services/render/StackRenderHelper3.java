package su.catlean.client.services.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10014;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_290;
import net.minecraft.class_315;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4588;
import net.minecraft.class_5498;
import net.minecraft.class_591;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_892;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.class_9946;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.cosmetic.CrystalChamsModule;
import su.catlean.client.features.modules.render.esp.LogoutSpotsModule;
import su.catlean.client.features.modules.render.esp.PlayerEspRenderMode;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.mixins.accessors.EndCrystalRendererAccessor;

public class StackRenderHelper3 {

    public static final StackRenderHelper3 INSTANCE;
    private static boolean enabledFlag;

    private StackRenderHelper3() {
    }

    public void render(MatrixStack stack, PlayerEspRenderMode mode, Color fillColor, Color lineColor, int vDistance, int hDistance) {
        if (SharedKt.getMc().method_1560() != null) {
            if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
                EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
            }
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable iterable = SharedKt.getWorld().method_18112();
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__ >= 0) {
                collection.add(element);
                iterable = ((Iterable) collection);
                index = 0;
                iterable2 = iterable;
                collection = ((Collection) new ArrayList());
                if (__UNDEF_KEY__ >= 0) {
                    index2 = 0;
                }
            }
        }
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            EndCrystalEntity entity = ((EndCrystalEntity) element);
            if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
            }
            collection.add(element);
        }
        if (__UNDEF_KEY__ >= 0) {
            if (collection.isEmpty()) {
                return;
            }
        }
        if (__UNDEF_KEY__ >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (mode != PlayerEspRenderMode.BOTH) {
                    if (__UNDEF_KEY__ >= 0) {
                        if (!(__UNDEF_KEY__)) {
                            if (mode == PlayerEspRenderMode.FILL) {
                                int index3 = 4;
                                int index4 = 0;
                                int index5 = (collection.size() * 72);
                                VertexFormat vertexFormat = class_290.field_1576;
                                iterable = new FormatRenderHelper(vertexFormat, index5, index4, index3);
                                index = ((Iterable) collection);
                                iterable2 = 0;
                                collection = index.iterator();
                                while (collection.hasNext()) {
                                    index2 = collection.next();
                                    iterator = ((EndCrystalEntity) index2);
                                    element = 0;
                                    INSTANCE.render(stack, iterator, fillColor, PlayerEspRenderMode.FILL, iterable, CrystalChamsModule.INSTANCE.computeValue((iterator.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
                                    if (__UNDEF_KEY__ < 0 || !(__UNDEF_KEY__)) {
                                        continue;
                                    }
                                }
                                FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, stack.method_23760().method_23761());
                            }
                        }
                    }
                }
            }
        }
        if (mode != PlayerEspRenderMode.BOTH) {
        }
        int index6 = 1;
        index3 = (collection.size() * 144);
        index4 = class_290.field_1576;
        iterable = new FormatRenderHelper(index4, index3, index6);
        index = ((Iterable) collection);
        iterable2 = 0;
        collection = index.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = ((EndCrystalEntity) index2);
            element = 0;
            INSTANCE.render(stack, iterator, lineColor, PlayerEspRenderMode.OUTLINE, iterable, CrystalChamsModule.INSTANCE.computeValue((iterator.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
            if (mode != PlayerEspRenderMode.OUTLINE || __UNDEF_KEY__ <= 0 || !(__UNDEF_KEY__)) {
                continue;
            }
        }
        FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
    }

    public void render(MatrixStack stack, PlayerEspRenderMode mode, Color fillColor, Color lineColor, Color friendFillColor, Color friendLineColor, int vDistance, int hDistance) {
        if (SharedKt.getMc().method_1560() != null) {
            if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
                EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
            }
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable iterable = SharedKt.getWorld().method_18112();
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (Intrinsics.areEqual(element, SharedKt.getPlayer())) {
            }
            collection.add(element);
        }
        if (collection.isEmpty()) {
            return;
        }
        if (mode != PlayerEspRenderMode.BOTH) {
            if (mode == PlayerEspRenderMode.FILL) {
                int index3 = 4;
                int index4 = 0;
                int index5 = (collection.size() * 144);
                VertexFormat vertexFormat = class_290.field_1576;
                iterable = new FormatRenderHelper(vertexFormat, index5, index4, index3);
                index = ((Iterable) collection);
                iterable2 = 0;
                collection = index.iterator();
                while (collection.hasNext()) {
                    index2 = collection.next();
                    iterator = index2;
                    element = 0;
                    if (EntityHelper4.isFriend(((PlayerEntity) iterator))) {
                    } else {
                    }
                    render(stack, iterator, friendFillColor, fillColor, PlayerEspRenderMode.FILL, iterable, 0.0F);
                }
                FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, stack.method_23760().method_23761());
            }
        }
        if (mode != PlayerEspRenderMode.BOTH) {
        }
        int index6 = 1;
        index3 = (collection.size() * 288);
        index4 = class_290.field_1576;
        iterable = new FormatRenderHelper(index4, index3, index6);
        index = ((Iterable) collection);
        iterable2 = 0;
        collection = index.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = index2;
            element = 0;
            if (EntityHelper4.isFriend(((PlayerEntity) iterator))) {
            } else {
            }
            render(stack, iterator, friendLineColor, lineColor, PlayerEspRenderMode.OUTLINE, iterable, 0.0F);
        }
        FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
    }

    public void render(MatrixStack stack, PlayerEspRenderMode mode, Color fillColor, Color lineColor, ArrayList list, int vDistance, int hDistance) {
        if (SharedKt.getMc().method_1560() != null) {
            if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
                EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
            }
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable iterable = ((Iterable) list);
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            PlayerEntity player = ((PlayerEntity) element);
            if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                if (SharedKt.getMc().options.method_31044() != class_5498.field_26664 && Math.hypot((vec.field_1352 - player.getX()), (vec.field_1350 - player.getZ())) < hDistance && Math.abs((vec.field_1351 - player.getY())) < vDistance) {
                } else {
                }
            }
            collection.add(element);
        }
        if (collection.isEmpty()) {
            return;
        }
        if (mode != PlayerEspRenderMode.BOTH) {
            if (mode == PlayerEspRenderMode.FILL) {
                int index3 = 4;
                int index4 = 0;
                int index5 = (list.size() * 144);
                VertexFormat vertexFormat = class_290.field_1576;
                iterable = new FormatRenderHelper(vertexFormat, index5, index4, index3);
                index = ((Iterable) collection);
                iterable2 = 0;
                collection = index.iterator();
                while (collection.hasNext()) {
                    index2 = collection.next();
                    iterator = ((PlayerEntity) index2);
                    element = 0;
                    INSTANCE.render(stack, iterator, fillColor, PlayerEspRenderMode.FILL, iterable, 1.0F);
                }
                FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, stack.method_23760().method_23761());
            }
        }
        if (mode != PlayerEspRenderMode.BOTH) {
        }
        int index6 = 1;
        index3 = (list.size() * 288);
        index4 = class_290.field_1576;
        iterable = new FormatRenderHelper(index4, index3, index6);
        index = ((Iterable) collection);
        iterable2 = 0;
        collection = index.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = ((PlayerEntity) index2);
            element = 0;
            INSTANCE.render(stack, iterator, lineColor, PlayerEspRenderMode.OUTLINE, iterable, 1.0F);
        }
        FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
    }

    private void render(MatrixStack arg0, Entity arg1, Color arg2, PlayerEspRenderMode arg3, FormatRenderHelper arg4, float arg5, long arg6) {
        if (!(arg1 instanceof PlayerEntity)) {
            return;
        }
        PolygonRenderHelper polygonRenderHelper = new PolygonRenderHelper(arg4, arg3, arg2);
        class_591 class591 = ((class_591) ((class_1007) SharedKt.getMc().method_1561().method_3953(arg1)).method_4038());
        class_10055 class10055 = ((class_10055) SharedKt.getMc().method_1561().method_3953(arg1).method_62425(arg1, TextShaderComponent2.INSTANCE.computeValue()));
        arg0.method_22903();
        Vec3d vec = TextShaderComponent2.INSTANCE.resolveMinecraftObject(((PlayerEntity) arg1), arg5);
        double offset = vec.field_1352;
        double offset2 = vec.field_1351;
        double offset3 = vec.field_1350;
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        arg0.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
        arg0.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
        arg0.method_46416(offset, offset2, offset3);
        arg0.method_22905(class10055.field_53453, class10055.field_53453, class10055.field_53453);
        LogoutSpotsModule.INSTANCE.render(class10055, arg0, class10055.field_53446);
        arg0.method_22905(-1.0F, -1.0F, 1.0F);
        if (arg6 >= 0L) {
            arg0.method_22905(0.9375F, 0.9375F, 0.9375F);
        }
        if (((PlayerEntity) arg1).method_5715()) {
        } else {
        }
        this.method_46416(-1.37F, -1.501F, 0.0F);
        class591.method_62110(class10055);
        class591.field_3483.field_3665 = false;
        class591.field_3484.field_3665 = false;
        class591.field_3486.field_3665 = false;
        class591.field_3482.field_3665 = false;
        class591.field_3479.field_3665 = false;
        class591.field_3394.field_3665 = false;
        class591.method_60879(arg0, ((class_4588) polygonRenderHelper), 15728880, 0);
        arg0.method_22909();
    }

    private static void render(StackRenderHelper3 arg0, MatrixStack arg1, Entity arg2, Color arg3, PlayerEspRenderMode arg4, FormatRenderHelper arg5, float arg6, int arg7, Object arg8) {
        if ((arg7 & 32) != 0) {
            arg6 = TextShaderComponent2.INSTANCE.computeValue();
        }
        arg0.render(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void render(MatrixStack stack, class_591 model, class_10055 state, Vec3d pos, Color color, PlayerEspRenderMode mode, FormatRenderHelper polygon) {
        PolygonRenderHelper polygonRenderHelper = new PolygonRenderHelper(polygon, mode, color);
        stack.method_22903();
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (pos.field_1352 - vec.field_1352);
        double offset2 = (pos.field_1351 - vec.field_1351);
        double offset3 = (pos.field_1350 - vec.field_1350);
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        stack.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
        stack.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
        stack.method_46416(offset, offset2, offset3);
        stack.method_22905(state.field_53453, state.field_53453, state.field_53453);
        LogoutSpotsModule.INSTANCE.render(state, stack, state.field_53446);
        stack.method_22905(-1.0F, -1.0F, 1.0F);
        stack.method_22905(0.9375F, 0.9375F, 0.9375F);
        stack.method_46416(0.0F, -1.501F, 0.0F);
        model.method_62110(state);
        model.field_3483.field_3665 = false;
        model.field_3484.field_3665 = false;
        model.field_3486.field_3665 = false;
        model.field_3482.field_3665 = false;
        model.field_3479.field_3665 = false;
        model.field_3394.field_3665 = false;
        model.method_60879(stack, ((class_4588) polygonRenderHelper), 15728880, 0);
        stack.method_22909();
    }

    private void render(MatrixStack arg0, Entity arg1, Color arg2, PlayerEspRenderMode arg3, FormatRenderHelper arg4, float arg5) {
        if (!(arg1 instanceof EndCrystalEntity)) {
            return;
        }
        PolygonRenderHelper polygonRenderHelper = new PolygonRenderHelper(arg4, arg3, arg2);
        class_897 class897 = SharedKt.getMc().method_1561().method_3953(arg1);
        class_9946 class9946 = ((EndCrystalRendererAccessor) ((class_892) class897)).getModel();
        class_10014 class10014 = ((class_10014) ((class_892) class897).method_62425(arg1, TextShaderComponent2.INSTANCE.computeValue()));
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (((EndCrystalEntity) arg1).getX() - vec.field_1352);
        double offset2 = (((EndCrystalEntity) arg1).getY() - vec.field_1351);
        double offset3 = (((EndCrystalEntity) arg1).getZ() - vec.field_1350);
        arg0.method_22903();
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        arg0.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
        arg0.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
        arg0.method_22904(offset, offset2, offset3);
        arg0.method_22905(arg5, arg5, arg5);
        arg0.method_22905(2.0F, 2.0F, 2.0F);
        arg0.method_46416(0.0F, -0.5F, 0.0F);
        class9946.method_62083(class10014);
        class9946.method_60879(arg0, ((class_4588) polygonRenderHelper), 15728880, 0);
        arg0.method_22909();
    }

    static {
        INSTANCE = new StackRenderHelper3();
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive() {
        return enabledFlag;
    }

    public static boolean isActive2() {
        return true;
        return false;
    }

}
