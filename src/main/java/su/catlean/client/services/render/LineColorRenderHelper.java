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
        Iterable iterable = SharedKt.getWorld().method_18112();
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            collection.add(element);
        }
        int index3 = 4;
        int index4 = 0;
        int index5 = (collection.size() * 8);
        VertexFormat vertexFormat = class_290.field_1576;
        iterable = new FormatRenderHelper(vertexFormat, index5, index4, index3);
        index = ((Iterable) collection);
        iterable2 = 0;
        collection = index.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = ((EndCrystalEntity) index2);
            element = 0;
            Vec3d[] items = PolygonShaderComponent.INSTANCE.process(iterator);
            int index6 = 0;
            if (__UNDEF_KEY__ <= 0L || __UNDEF_KEY__ >= 0L) {
                continue;
            }
            if (index6 < __UNDEF_KEY__) {
                Object element2 = items[index6];
                Vec3d vec = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(new Vec3d(element2.field_1352, element2.field_1351, element2.field_1350));
                if (__UNDEF_KEY__ < 0) {
                }
                if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
                    if (__UNDEF_KEY__ == null) {
                        Vector4d vector4d = new Vector4d(vec.field_1352, vec.field_1351, vec.field_1350, 0.0D);
                    }
                    vector4d.x = Math.min(vec.field_1352, vector4d.x);
                    vector4d.y = Math.min(vec.field_1351, vector4d.y);
                    vector4d.z = Math.max(vec.field_1352, vector4d.z);
                    vector4d.w = Math.max(vec.field_1351, vector4d.w);
                }
            }
            if (__UNDEF_KEY__ <= 0L || __UNDEF_KEY__ || vector4d != null) {
                continue;
            }
        }
        FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f(((Matrix3x2fc) context.method_51448())));
    }

    public void render(DrawContext context, Color lineColor, Color friendLineColor) {
        Iterable iterable = SharedKt.getWorld().method_18112();
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Entity entity = element;
            int index3 = 0;
            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
                if (entity instanceof PlayerEntity && SharedKt.getMc().options.method_31044() != class_5498.field_26664) {
                } else {
                }
            }
            collection.add(element);
        }
        int index4 = 4;
        int index5 = 0;
        int index6 = (collection.size() * 8);
        VertexFormat vertexFormat = class_290.field_1576;
        iterable = new FormatRenderHelper(vertexFormat, index6, index5, index4);
        index = ((Iterable) collection);
        iterable2 = 0;
        collection = index.iterator();
        while (collection.hasNext()) {
            index2 = collection.next();
            iterator = index2;
            element = 0;
            entity = PolygonShaderComponent.INSTANCE.process(iterator);
            int index7 = 0;
            Entity entity2 = entity;
            if (index7 < entity2) {
                Object element2 = entity[index7];
                Vec3d vec = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(new Vec3d(element2.field_1352, element2.field_1351, element2.field_1350));
                if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
                    if (index3 == null) {
                        index3 = new Vector4d(vec.field_1352, vec.field_1351, vec.field_1350, 0.0D);
                    }
                    index3.x = Math.min(vec.field_1352, index3.x);
                    index3.y = Math.min(vec.field_1351, index3.y);
                    index3.z = Math.max(vec.field_1352, index3.z);
                    index3.w = Math.max(vec.field_1351, index3.w);
                }
            }
            if (index3 != null) {
                index7 = index3.x;
                entity2 = index3.y;
                element2 = index3.z;
                vec = index3.w;
                if (EntityHelper4.isFriend(((PlayerEntity) iterator))) {
                } else {
                }
                Color color = lineColor;
                index4 = friendLineColor;
                index5 = vec;
                index6 = element2;
                iterable.executeAction(index7, entity2, index6, index5, index4, color);
            }
        }
        FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f(((Matrix3x2fc) context.method_51448())));
    }

    static {
        INSTANCE = new LineColorRenderHelper();
    }

}
