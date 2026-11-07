package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_315;
import net.minecraft.class_4184;
import net.minecraft.class_5498;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.render.esp.PlayerEspRenderMode;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class FillColorRenderHelper {

    public static final FillColorRenderHelper INSTANCE;

    private FillColorRenderHelper() {
    }

    public void executeAction(PlayerEspRenderMode mode, Color fillColor, Color lineColor, int vDistance, int hDistance) {
        if (SharedKt.getMc().method_1560() != null) {
            if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
            }
            EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
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
        var27 = (Iterable) var30;
        var28 = 0;
        var29 = var27;
        var30 = (Collection) new ArrayList();
        var31 = 0;
        iterator = var29.iterator();
        while (iterator.hasNext()) {
            var33 = iterator.next();
            EndCrystalEntity entity = (EndCrystalEntity) var33;
            int var35 = 0;
            var30.add();
        }
        var27 = (Iterable) var30;
        var28 = 0;
        var29 = var27.iterator();
        while (var29.hasNext()) {
            var30 = var29.next();
            var31 = (EndCrystalEntity) var30;
            iterator = 0;
            if (mode != PlayerEspRenderMode.BOTH) {
                if (mode == PlayerEspRenderMode.FILL) {
                }
                TextShaderComponent2.checkCondition(var31.method_5829(), fillColor);
            }
            if (mode != PlayerEspRenderMode.BOTH) {
                if (mode == PlayerEspRenderMode.OUTLINE) {
                }
                int var21 = 4;
                Object var23 = lineColor;
                Box var24 = var31.method_5829();
                TextShaderComponent2.checkCondition();
            }
        }
    }

    public void executeAction(PlayerEspRenderMode mode, Color fillColor, Color lineColor, Color friendFillColor, Color friendLineColor, int vDistance, int hDistance, Color sFillColor, Color sLineColor, Color sFriendFillColor, Color sFriendLineColor) {
        if (!(var38)) {
            if (SharedKt.getMc().method_1560() != null) {
                if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
                }
                EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
            }
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable var40 = SharedKt.getWorld().method_18112();
        int var41 = 0;
        Object var42 = var40;
        Collection var43 = (Collection) new ArrayList();
        int var44 = 0;
        Iterator iterator = var42.iterator();
        if (iterator.hasNext()) {
            Object var46 = iterator.next();
            Entity entity = var46;
            int var48 = 0;
            if (0L >= 0) {
                if (!(var38)) {
                    if (0L > 0) {
                        if (!(var38)) {
                        }
                    }
                    if (0L < 0) {
                        if (!(var38)) {
                            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
                            }
                        }
                    }
                    if (0L <= 0) {
                        if (!(var38)) {
                        }
                    }
                    if (!(var38)) {
                        if (entity instanceof PlayerEntity && SharedKt.getMc().options.method_31044() != class_5498.field_26664 && Math.hypot((vec.field_1352 - (PlayerEntity) entity.getX()), (vec.field_1350 - (PlayerEntity) entity.getZ())) < hDistance && Math.abs((vec.field_1351 - (PlayerEntity) entity.getY())) < vDistance) {
                        }
                    } else {
                    }
                    var43.add();
                }
                var40 = (Iterable) var43;
                if (0L > 0) {
                }
                var41 = 0;
            }
        }
        var42 = var40.iterator();
        if (var42.hasNext()) {
            var43 = var42.next();
            var44 = var43;
            iterator = 0;
            var46 = var44.method_5829();
            entity = SharedKt.getMc().method_1561().field_4686.method_71156();
            var48 = TextShaderComponent2.resolveMinecraftObject((PlayerEntity) var44, 0.0F).method_1031(entity.field_1352, entity.field_1351, entity.field_1350);
            Vec3d vec2 = var48.method_1031((var46.method_17939() / 2.0D), 0.0D, (var46.method_17941() / 2.0D));
            Vec3d vec3 = var48.method_1031((var46.method_17939() / 2.0D), var46.method_17940(), (var46.method_17941() / 2.0D));
            var46 = new Box(vec2, vec3);
            if (0L >= 0) {
                if (!(var38)) {
                    if (mode != PlayerEspRenderMode.BOTH) {
                    }
                }
                if (0L >= 0) {
                    if (!(var38)) {
                        if (mode == PlayerEspRenderMode.FILL) {
                        }
                        if (EntityHelper4.isFriend((PlayerEntity) var44)) {
                        } else {
                        }
                        if (EntityHelper4.isFriend((PlayerEntity) var44)) {
                        } else {
                        }
                        friendFillColor.checkCondition(fillColor, sFriendFillColor, sFillColor);
                    }
                }
            }
            if (0L >= 0 && !(var38)) {
                if (mode != PlayerEspRenderMode.BOTH) {
                }
                if (mode == PlayerEspRenderMode.OUTLINE) {
                }
                if (EntityHelper4.isFriend((PlayerEntity) var44)) {
                } else {
                }
                if (EntityHelper4.isFriend((PlayerEntity) var44)) {
                } else {
                }
                Object var35 = sLineColor;
                Object var36 = sFriendLineColor;
                Object var37 = lineColor;
                friendLineColor.checkCondition();
            }
        }
    }

    static {
        INSTANCE = new FillColorRenderHelper();
    }

}
