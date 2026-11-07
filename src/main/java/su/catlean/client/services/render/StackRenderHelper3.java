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
            }
            EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable var42 = SharedKt.getWorld().method_18112();
        int var43 = 0;
        Object var44 = var42;
        Collection var45 = (Collection) new ArrayList();
        int var46 = 0;
        Iterator iterator = var44.iterator();
        while (iterator.hasNext()) {
            Object var48 = iterator.next();
            if (0L >= 0) {
                var45.add();
            }
            var42 = (Iterable) var45;
            var43 = 0;
            var44 = var42;
            var45 = (Collection) new ArrayList();
            if (0L >= 0) {
                var46 = 0;
            }
        }
        iterator = var44.iterator();
        if (iterator.hasNext()) {
            var48 = iterator.next();
            EndCrystalEntity entity = (EndCrystalEntity) var48;
            int var50 = 0;
            if (0L >= 0 && !(var39)) {
            }
            var45.add();
        }
        List positions = var45;
        if (0L >= 0) {
            if (positions.isEmpty()) {
                return;
            }
        }
        if (0L >= 0) {
            if (!(var39)) {
                if (mode != PlayerEspRenderMode.BOTH) {
                }
            }
            if (0L >= 0) {
                if (!(var39)) {
                    if (mode == PlayerEspRenderMode.FILL) {
                    }
                    int var35 = 4;
                    int var36 = 0;
                    int var37 = (positions.size() * 72);
                    VertexFormat var38 = class_290.field_1576;
                    var42 = new FormatRenderHelper();
                    var43 = (Iterable) positions;
                    var44 = 0;
                    var45 = var43.iterator();
                    while (var45.hasNext()) {
                        var46 = var45.next();
                        iterator = (EndCrystalEntity) var46;
                        var48 = 0;
                        INSTANCE.render(stack, iterator, fillColor, PlayerEspRenderMode.FILL, CrystalChamsModule.INSTANCE.computeValue((iterator.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
                        if (0L < 0 || !(var39)) {
                            continue;
                        }
                    }
                    FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, stack.method_23760().method_23761());
                }
            }
        }
        if (mode != PlayerEspRenderMode.BOTH) {
        }
        int var34 = 1;
        var35 = (positions.size() * 144);
        var36 = class_290.field_1576;
        var42 = new FormatRenderHelper();
        var43 = (Iterable) positions;
        var44 = 0;
        var45 = var43.iterator();
        while (var45.hasNext()) {
            var46 = var45.next();
            iterator = (EndCrystalEntity) var46;
            var48 = 0;
            INSTANCE.render(stack, iterator, lineColor, PlayerEspRenderMode.OUTLINE, CrystalChamsModule.INSTANCE.computeValue((iterator.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
            if (mode != PlayerEspRenderMode.OUTLINE || 0L <= 0 || !(var39)) {
                continue;
            }
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
    }

    public void render(MatrixStack stack, PlayerEspRenderMode mode, Color fillColor, Color lineColor, Color friendFillColor, Color friendLineColor, int vDistance, int hDistance) {
        if (SharedKt.getMc().method_1560() != null) {
            if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
            }
            EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable var38 = SharedKt.getWorld().method_18112();
        int var39 = 0;
        Object var40 = var38;
        Collection var41 = (Collection) new ArrayList();
        int var42 = 0;
        Iterator iterator = var40.iterator();
        while (iterator.hasNext()) {
            Object var44 = iterator.next();
            Entity entity = var44;
            int var46 = 0;
            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
            }
            var41.add();
        }
        List positions = var41;
        if (positions.isEmpty()) {
            return;
        }
        if (mode != PlayerEspRenderMode.BOTH) {
            if (mode == PlayerEspRenderMode.FILL) {
            }
            int var31 = 4;
            int var32 = 0;
            int var33 = (positions.size() * 144);
            VertexFormat var34 = class_290.field_1576;
            var38 = new FormatRenderHelper();
            var39 = (Iterable) positions;
            var40 = 0;
            var41 = var39.iterator();
            while (var41.hasNext()) {
                var42 = var41.next();
                iterator = var42;
                var44 = 0;
                if (EntityHelper4.isFriend((PlayerEntity) iterator)) {
                } else {
                }
                render(stack, iterator, friendFillColor, fillColor, PlayerEspRenderMode.FILL, 0.0F);
            }
            FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, stack.method_23760().method_23761());
        }
        if (mode != PlayerEspRenderMode.BOTH) {
        }
        int var30 = 1;
        var31 = (positions.size() * 288);
        var32 = class_290.field_1576;
        var38 = new FormatRenderHelper();
        var39 = (Iterable) positions;
        var40 = 0;
        var41 = var39.iterator();
        while (var41.hasNext()) {
            var42 = var41.next();
            iterator = var42;
            var44 = 0;
            if (EntityHelper4.isFriend((PlayerEntity) iterator)) {
            } else {
            }
            render(stack, iterator, friendLineColor, lineColor, PlayerEspRenderMode.OUTLINE, 0.0F);
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
    }

    public void render(MatrixStack stack, PlayerEspRenderMode mode, Color fillColor, Color lineColor, ArrayList list, int vDistance, int hDistance) {
        if (SharedKt.getMc().method_1560() != null) {
            if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
            }
            EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable var34 = (Iterable) list;
        int var35 = 0;
        Object var36 = var34;
        Collection var37 = (Collection) new ArrayList();
        int var38 = 0;
        Iterator iterator = var36.iterator();
        while (iterator.hasNext()) {
            Object var40 = iterator.next();
            PlayerEntity player = (PlayerEntity) var40;
            int var42 = 0;
            if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                if (SharedKt.getMc().options.method_31044() != class_5498.field_26664 && Math.hypot((vec.field_1352 - player.getX()), (vec.field_1350 - player.getZ())) < hDistance && Math.abs((vec.field_1351 - player.getY())) < vDistance) {
                }
            } else {
            }
            var37.add();
        }
        List positions = var37;
        if (positions.isEmpty()) {
            return;
        }
        if (mode != PlayerEspRenderMode.BOTH) {
            if (mode == PlayerEspRenderMode.FILL) {
            }
            int var27 = 4;
            int var28 = 0;
            int var29 = (list.size() * 144);
            VertexFormat var30 = class_290.field_1576;
            var34 = new FormatRenderHelper();
            var35 = (Iterable) positions;
            var36 = 0;
            var37 = var35.iterator();
            while (var37.hasNext()) {
                var38 = var37.next();
                iterator = (PlayerEntity) var38;
                var40 = 0;
                INSTANCE.render(stack, iterator, fillColor, PlayerEspRenderMode.FILL, 1.0F);
            }
            FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, stack.method_23760().method_23761());
        }
        if (mode != PlayerEspRenderMode.BOTH) {
        }
        int var26 = 1;
        var27 = (list.size() * 288);
        var28 = class_290.field_1576;
        var34 = new FormatRenderHelper();
        var35 = (Iterable) positions;
        var36 = 0;
        var37 = var35.iterator();
        while (var37.hasNext()) {
            var38 = var37.next();
            iterator = (PlayerEntity) var38;
            var40 = 0;
            INSTANCE.render(stack, iterator, lineColor, PlayerEspRenderMode.OUTLINE, 1.0F);
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
    }

    private void render(MatrixStack arg0, Entity arg1, Color arg2, PlayerEspRenderMode arg3, FormatRenderHelper arg4, float arg5, long arg6) {
        if (!(arg1 instanceof PlayerEntity)) {
            return;
        }
        PolygonRenderHelper var25 = new PolygonRenderHelper(arg4, arg3, arg2);
        class_591 var26 = (class_591) (class_1007) SharedKt.getMc().method_1561().method_3953(arg1).method_4038();
        class_10055 var27 = (class_10055) SharedKt.getMc().method_1561().method_3953(arg1).method_62425(arg1, TextShaderComponent2.INSTANCE.computeValue());
        arg0.method_22903();
        Vec3d vec = TextShaderComponent2.INSTANCE.resolveMinecraftObject((PlayerEntity) arg1, arg5);
        double var29 = vec.field_1352;
        double var31 = vec.field_1351;
        double var33 = vec.field_1350;
        class_4184 var35 = SharedKt.getMc().field_1773.method_19418();
        arg0.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var35.method_19330() + 180.0F)));
        arg0.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var35.method_19329()));
        arg0.method_46416();
        arg0.method_22905(var27.field_53453, var27.field_53453, var27.field_53453);
        LogoutSpotsModule.INSTANCE.render(arg0, var27.field_53446);
        arg0.method_22905(-1.0F, -1.0F, 1.0F);
        if (arg6 >= 0L) {
            if (var24) {
                arg0.method_22905(0.9375F, 0.9375F, 0.9375F);
            }
            if ((PlayerEntity) arg1.method_5715()) {
            }
        } else {
        }
        0.0F.method_46416(-1.37F, -1.501F, 0.0F);
        var26.method_62110();
        var26.field_3483.field_3665 = 0;
        var26.field_3484.field_3665 = 0;
        var26.field_3486.field_3665 = 0;
        var26.field_3482.field_3665 = 0;
        var26.field_3479.field_3665 = 0;
        var26.field_3394.field_3665 = 0;
        var26.method_60879(arg0, (class_4588) var25, 15728880, 0);
        arg0.method_22909();
    }

    private static void render(StackRenderHelper3 arg0, MatrixStack arg1, Entity arg2, Color arg3, PlayerEspRenderMode arg4, FormatRenderHelper arg5, float arg6, int arg7, Object arg8) {
        if ((arg7 & 32)) {
            arg6 = TextShaderComponent2.INSTANCE.computeValue();
        }
        arg0.render(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void render(MatrixStack stack, class_591 model, class_10055 state, Vec3d pos, Color color, PlayerEspRenderMode mode, FormatRenderHelper polygon) {
        PolygonRenderHelper var18 = new PolygonRenderHelper(polygon, mode, color);
        stack.method_22903();
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double var20 = (pos.field_1352 - vec.field_1352);
        double var22 = (pos.field_1351 - vec.field_1351);
        double var24 = (pos.field_1350 - vec.field_1350);
        class_4184 var26 = SharedKt.getMc().field_1773.method_19418();
        stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var26.method_19330() + 180.0F)));
        stack.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var26.method_19329()));
        stack.method_46416();
        stack.method_22905(state.field_53453, state.field_53453, state.field_53453);
        LogoutSpotsModule.INSTANCE.render(state, stack, state.field_53446);
        stack.method_22905(-1.0F, -1.0F, 1.0F);
        stack.method_22905(0.9375F, 0.9375F, 0.9375F);
        stack.method_46416(0.0F, -1.501F, 0.0F);
        model.method_62110(state);
        model.field_3483.field_3665 = 0;
        model.field_3484.field_3665 = 0;
        model.field_3486.field_3665 = 0;
        model.field_3482.field_3665 = 0;
        model.field_3479.field_3665 = 0;
        model.field_3394.field_3665 = 0;
        model.method_60879(stack, (class_4588) var18, 15728880, 0);
        stack.method_22909();
    }

    private void render(MatrixStack arg0, Entity arg1, Color arg2, PlayerEspRenderMode arg3, FormatRenderHelper arg4, float arg5) {
        if (!(arg1 instanceof EndCrystalEntity)) {
            return;
        }
        PolygonRenderHelper var16 = new PolygonRenderHelper(arg4, arg3, arg2);
        class_897 var17 = SharedKt.getMc().method_1561().method_3953(arg1);
        class_9946 var18 = (EndCrystalRendererAccessor) (class_892) var17.getModel();
        class_10014 var19 = (class_10014) (class_892) var17.method_62425(arg1, TextShaderComponent2.INSTANCE.computeValue());
        Vec3d vec = SharedKt.getMc().method_1561().field_4686.method_71156();
        double var21 = ((EndCrystalEntity) arg1.getX() - vec.field_1352);
        double var23 = ((EndCrystalEntity) arg1.getY() - vec.field_1351);
        double var25 = ((EndCrystalEntity) arg1.getZ() - vec.field_1350);
        arg0.method_22903();
        class_4184 var27 = SharedKt.getMc().field_1773.method_19418();
        arg0.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var27.method_19330() + 180.0F)));
        arg0.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var27.method_19329()));
        arg0.method_22904();
        arg0.method_22905(arg5, arg5, arg5);
        arg0.method_22905(2.0F, 2.0F, 2.0F);
        arg0.method_46416(0.0F, -0.5F, 0.0F);
        var18.method_62083();
        var18.method_60879(arg0, (class_4588) var16, 15728880, 0);
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
