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
                EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
            }
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable iterable = SharedKt.getWorld().method_18112();
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable;
        collection = ((Collection) new ArrayList());
        index = 0;
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            EndCrystalEntity entity = ((EndCrystalEntity) element);
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = ((EndCrystalEntity) collection);
            iterator = 0;
            if (mode != PlayerEspRenderMode.BOTH) {
                if (mode == PlayerEspRenderMode.FILL) {
                    TextShaderComponent2.checkCondition(index.method_5829(), fillColor);
                }
            }
            if (mode != PlayerEspRenderMode.BOTH) {
                if (mode == PlayerEspRenderMode.OUTLINE) {
                    int index2 = 4;
                    Box box = index.method_5829();
                    TextShaderComponent2.checkCondition(box, lineColor, index2);
                }
            }
        }
    }

    public void executeAction(PlayerEspRenderMode mode, Color fillColor, Color lineColor, Color friendFillColor, Color friendLineColor, int vDistance, int hDistance, Color sFillColor, Color sLineColor, Color sFriendFillColor, Color sFriendLineColor) {
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getMc().method_1560() != null) {
                if (EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560()) == null) {
                    EntityHelper.resolveMinecraftObject(SharedKt.getMc().method_1560());
                }
            }
        }
        Vec3d vec = EntityHelper.resolveMinecraftObject(SharedKt.getPlayer());
        Iterable iterable = SharedKt.getWorld().method_18112();
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Entity entity = element;
            int index2 = 0;
            if (__UNDEF_KEY__ >= 0) {
                if (!(__UNDEF_KEY__)) {
                    if (__UNDEF_KEY__ > 0) {
                        if (!(__UNDEF_KEY__)) {
                        }
                    }
                    if (__UNDEF_KEY__ < 0) {
                        if (!(__UNDEF_KEY__)) {
                            if (Intrinsics.areEqual(entity, SharedKt.getPlayer())) {
                            }
                        }
                    }
                    if (__UNDEF_KEY__ <= 0) {
                        if (!(__UNDEF_KEY__)) {
                        }
                    }
                    if (!(__UNDEF_KEY__)) {
                        if (entity instanceof PlayerEntity && SharedKt.getMc().options.method_31044() != class_5498.field_26664 && Math.hypot((vec.field_1352 - ((PlayerEntity) entity).getX()), (vec.field_1350 - ((PlayerEntity) entity).getZ())) < hDistance && Math.abs((vec.field_1351 - ((PlayerEntity) entity).getY())) < vDistance) {
                        } else {
                        }
                    }
                    collection.add(element);
                    iterable = ((Iterable) collection);
                    if (__UNDEF_KEY__ > 0) {
                    }
                }
            }
        }
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = collection;
            iterator = 0;
            element = index.method_5829();
            entity = SharedKt.getMc().method_1561().field_4686.method_71156();
            index2 = TextShaderComponent2.resolveMinecraftObject(((PlayerEntity) index), 0.0F).method_1031(entity.field_1352, entity.field_1351, entity.field_1350);
            Vec3d vec2 = index2.method_1031((element.method_17939() / 2.0D), 0.0D, (element.method_17941() / 2.0D));
            Vec3d vec3 = index2.method_1031((element.method_17939() / 2.0D), element.method_17940(), (element.method_17941() / 2.0D));
            element = new Box(vec2, vec3);
            if (__UNDEF_KEY__ >= 0) {
                if (!(__UNDEF_KEY__)) {
                    if (mode != PlayerEspRenderMode.BOTH) {
                        if (__UNDEF_KEY__ >= 0) {
                            if (!(__UNDEF_KEY__)) {
                                if (mode == PlayerEspRenderMode.FILL) {
                                    if (EntityHelper4.isFriend(((PlayerEntity) index))) {
                                    } else {
                                    }
                                    if (EntityHelper4.isFriend(((PlayerEntity) index))) {
                                    } else {
                                    }
                                    friendFillColor.checkCondition(fillColor, sFriendFillColor, sFillColor);
                                }
                            }
                        }
                    }
                }
            }
            if (__UNDEF_KEY__ >= 0 && !(__UNDEF_KEY__)) {
                if (mode != PlayerEspRenderMode.BOTH) {
                    if (mode == PlayerEspRenderMode.OUTLINE) {
                        if (EntityHelper4.isFriend(((PlayerEntity) index))) {
                        } else {
                        }
                        if (EntityHelper4.isFriend(((PlayerEntity) index))) {
                        } else {
                        }
                        friendLineColor.checkCondition(lineColor, sFriendLineColor, sLineColor);
                    }
                }
            }
        }
    }

    static {
        INSTANCE = new FillColorRenderHelper();
    }

}
