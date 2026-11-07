package su.catlean.client.services.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_290;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_5498;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionfc;
import org.lwjgl.opengl.GL32C;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.render.world.FreeCamModule;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class StackRenderHelper2 {

    public static final StackRenderHelper2 INSTANCE;

    private StackRenderHelper2() {
    }

    public void render(MatrixStack stack, Color lineColor, Color friendLineColor, boolean extraPart) {
        Iterable var43 = SharedKt.getWorld().method_18112();
        int var44 = 0;
        Object var45 = var43;
        Collection var46 = (Collection) new ArrayList();
        int var47 = 0;
        Iterator iterator = var45.iterator();
        while (iterator.hasNext()) {
            Object var49 = iterator.next();
            var46.add();
        }
        List positions = var46;
        if (positions.isEmpty()) {
            return;
        }
        var43 = PolygonShaderComponent.INSTANCE.computeValue();
        int var38 = 1;
        int var39 = (9 * positions.size());
        VertexFormat var40 = class_290.field_1576;
        var44 = new FormatRenderHelper();
        var45 = SharedKt.getMc().field_1773.method_19418();
        var46 = (Iterable) positions;
        var47 = 0;
        iterator = var46.iterator();
        while (iterator.hasNext()) {
            var49 = iterator.next();
            PlayerEntity player = (PlayerEntity) var49;
            int var51 = 0;
            if (SharedKt.getMc().options.method_31044() == class_5498.field_26664 && !(FreeCamModule.INSTANCE.getEnabled())) {
                if (!(Intrinsics.areEqual(SharedKt.getMc().player, player))) {
                }
                stack.method_22903();
                stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var45.method_19330() + 180.0F)));
                stack.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var45.method_19329()));
                if (EntityHelper4.isFriend(player)) {
                } else {
                }
                Object var52 = lineColor;
                Vec3d vec = TextShaderComponent2.resolveMinecraftObject(player, 0.0F);
                class_591 var54 = (class_591) (class_1007) SharedKt.getMc().method_1561().method_3953(player).method_4038();
                class_10017 var55 = SharedKt.getMc().method_1561().method_3953(player).method_62425(player, TextShaderComponent2.INSTANCE.computeValue());
                class_10055 var56 = (class_10055) var55;
                if (Intrinsics.areEqual(player, SharedKt.getPlayer()) && SequenceServiceComponent.INSTANCE.getMoveFixServiceComponent2() != null && SequenceServiceComponent.INSTANCE.getMoveFixServiceComponent() != null) {
                } else {
                }
                var55 = class_3532.method_17821(player.field_6220, player.field_6283);
                if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
                } else {
                }
                float var57 = player.method_5695();
                var54.method_62110();
                boolean var58 = player.method_20232();
                boolean var60 = player.isFallFlying();
                stack.method_22904(vec.field_1352, vec.field_1351, vec.field_1350);
                if (var58) {
                    stack.method_46416(0.0F, 0.35F, 0.0F);
                }
                stack.method_22907((Quaternionfc) class_7833.field_40715.rotationDegrees((var55 + 180)));
                if (!(var58)) {
                    if (var60) {
                    }
                    stack.method_22907((Quaternionfc) class_7833.field_40713.rotationDegrees((80 + var57)));
                }
                if (var58) {
                    stack.method_46416(0.0F, -0.95F, 0.0F);
                }
                0.15F.resolveFormatRenderHelper(0.6F, 0.7F, 0.23F, 0.0F).resolveFormatRenderHelper();
                stack.method_22903();
                0.0F.method_46416(1.05F, 1.4F, 0.0F);
                INSTANCE.render(var54.field_3398, 0.3F, stack);
                stack.method_22903();
                0.0F.method_46416(0.5F, 0.7F, 0.0F);
                stack.method_22907((Quaternionfc) class_7833.field_40718.rotation(var54.field_3398.field_3674));
                stack.method_22907((Quaternionfc) class_7833.field_40715.rotation(var54.field_3398.field_3675));
                stack.method_22907((Quaternionfc) class_7833.field_40713.rotation(1.1F));
                var44.resolveFormatRenderHelper(stack.method_23760().method_23761(), 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper().resolveFormatRenderHelper(stack.method_23760().method_23761(), 0.0F, 0.3F, 0.0F).resolveFormatRenderHelper();
                stack.method_22909();
                stack.method_22903();
                0.6F.method_46416(0.7F, 0.23F, 0.0F);
                INSTANCE.render(var54.field_3392, -0.6F, stack);
                stack.method_22903();
                0.6F.method_46416(0.7F, 0.23F, 0.0F);
                INSTANCE.render(var54.field_3397, -0.6F, stack);
                stack.method_22903();
                0.37F.method_46416(1.05F, 1.35F, 0.0F);
                INSTANCE.render(var54.field_3401, -0.55F, stack);
                stack.method_22903();
                -0.37F.method_46416(1.05F, 1.35F, 0.0F);
                INSTANCE.render(var54.field_27433, -0.55F, stack);
                if (var58) {
                    stack.method_46416(0.0F, 0.95F, 0.0F);
                }
                if (!(var58)) {
                    if (var60) {
                    }
                    stack.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees((90 + var57)));
                }
                if (var58) {
                    stack.method_46416(0.0F, -0.35F, 0.0F);
                }
                stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var55 + 180)));
                stack.method_22904(vec.field_1352, vec.field_1351, vec.field_1350);
                stack.method_22909();
            }
        }
        GL32C.glEnable(2848);
        GL32C.glHint(3154, 4354);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, stack.method_23760().method_23761());
        GL32C.glDisable(2848);
    }

    private void render(class_630 arg0, float arg1, MatrixStack arg2, Color arg3, FormatRenderHelper arg4) {
        this.render(arg2, arg0);
        arg4.resolveFormatRenderHelper(arg2.method_23760().method_23761(), 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(arg3).resolveFormatRenderHelper(arg2.method_23760().method_23761(), 0.0F, arg1, 0.0F).resolveFormatRenderHelper(arg3);
        arg2.method_22909();
    }

    private void render(MatrixStack arg0, class_630 arg1) {
        if (arg1.field_3674 != 0.0F) {
            arg0.method_22907((Quaternionfc) class_7833.field_40718.rotation(arg1.field_3674));
        }
        if (arg1.field_3675 != 0.0F) {
            arg0.method_22907((Quaternionfc) class_7833.field_40715.rotation(arg1.field_3675));
        }
        arg0.method_22907((Quaternionfc) class_7833.field_40713.rotation(arg1.field_3654));
    }

    static {
        INSTANCE = new StackRenderHelper2();
    }

}
