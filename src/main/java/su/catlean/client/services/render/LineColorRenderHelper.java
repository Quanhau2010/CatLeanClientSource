package su.catlean.client.services.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_290;
import net.minecraft.class_315;
import net.minecraft.class_5498;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.joml.Vector4d;
import su.catlean.SharedKt;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class LineColorRenderHelper {

    public static final LineColorRenderHelper INSTANCE;

    private LineColorRenderHelper() {
    }

    public void render(DrawContext context, Color lineColor) {
        Iterable var27 = SharedKt.getWorld().method_18112();
        int var28 = 0;
        Object var29 = var27;
        Collection var30 = (Collection) new ArrayList();
        int var31 = 0;
        Iterator iterator = var29.iterator();
        while (iterator.hasNext()) {
            Object var33 = iterator.next();
            var30.add();
        }
        List positions = var30;
        int var21 = 4;
        int var22 = 0;
        int var23 = (positions.size() * 8);
        VertexFormat var24 = class_290.field_1576;
        var27 = new FormatRenderHelper();
        var28 = (Iterable) positions;
        var29 = 0;
        var30 = var28.iterator();
        while (var30.hasNext()) {
            var31 = var30.next();
            iterator = (EndCrystalEntity) var31;
            var33 = 0;
            Vec3d[] var34 = PolygonShaderComponent.INSTANCE.process(iterator);
            int var36 = 0;
            if (0L <= 0L || 0L >= 0L) {
                continue;
            }
            int var37 = var25;
            if (var36 < var37) {
                Object var38 = var34[var36];
                Vec3d vec = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(new Vec3d(var38.field_1352, var38.field_1351, var38.field_1350));
                if (0L < 0) {
                }
                if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
                    if (var35 == null) {
                        Vector4d var35 = new Vector4d(vec.field_1352, vec.field_1351, vec.field_1350, 0.0D);
                    }
                    var35.x = Math.min(vec.field_1352, var35.x);
                    var35.y = Math.min(vec.field_1351, var35.y);
                    var35.z = Math.max(vec.field_1352, var35.z);
                    var35.w = Math.max(vec.field_1351, var35.w);
                }
            }
            if (0L <= 0L || var25 || var35 != null) {
                continue;
            }
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f((Matrix3x2fc) context.method_51448()));
    }

    public void render(DrawContext context, Color lineColor, Color friendLineColor) {
        Iterable var31 = SharedKt.getWorld().method_18112();
        int var32 = 0;
        Object var33 = var31;
        Collection var34 = (Collection) new ArrayList();
        int var35 = 0;
        Iterator iterator = var33.iterator();
        while (iterator.hasNext()) {
            Object var37 = iterator.next();
            Entity entity = var37;
            int var39 = 0;
            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
                if (entity instanceof PlayerEntity && SharedKt.getMc().options.method_31044() != class_5498.field_26664) {
                }
            } else {
            }
            var34.add();
        }
        List positions = var34;
        int var25 = 4;
        int var26 = 0;
        int var27 = (positions.size() * 8);
        VertexFormat var28 = class_290.field_1576;
        var31 = new FormatRenderHelper();
        var32 = (Iterable) positions;
        var33 = 0;
        var34 = var32.iterator();
        while (var34.hasNext()) {
            var35 = var34.next();
            iterator = var35;
            var37 = 0;
            entity = PolygonShaderComponent.INSTANCE.process(iterator);
            int var40 = 0;
            Object var41 = entity;
            if (var40 < var41) {
                Object var42 = entity[var40];
                Vec3d vec = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(new Vec3d(var42.field_1352, var42.field_1351, var42.field_1350));
                if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
                    if (var39 == null) {
                        var39 = new Vector4d(vec.field_1352, vec.field_1351, vec.field_1350, 0.0D);
                    }
                    var39.x = Math.min(vec.field_1352, var39.x);
                    var39.y = Math.min(vec.field_1351, var39.y);
                    var39.z = Math.max(vec.field_1352, var39.z);
                    var39.w = Math.max(vec.field_1351, var39.w);
                }
            }
            if (var39 != null) {
                var40 = var39.x;
                var41 = var39.y;
                var42 = var39.z;
                vec = var39.w;
                if (EntityHelper4.isFriend((PlayerEntity) iterator)) {
                } else {
                }
                Object var24 = lineColor;
                var25 = friendLineColor;
                var26 = vec;
                var27 = var42;
                var31.executeAction();
            }
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f((Matrix3x2fc) context.method_51448()));
    }

    static {
        INSTANCE = new LineColorRenderHelper();
    }

}
