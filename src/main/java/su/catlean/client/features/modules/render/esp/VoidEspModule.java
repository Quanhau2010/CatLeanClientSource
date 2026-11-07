package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent89;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class VoidEspModule extends Module {

    public static final VoidEspModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final RangeVisibleSettingPropertyImpl rangeSetting;
    private static int countValue;
    private static List itemList;

    private VoidEspModule() {
        super("void-esp", SubCategoriesKt.getEspCategory());
    }

    private VoidEspMode getMode() {
        return ((VoidEspMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private int getRange() {
        return ((Number) rangeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setRange(int value) {
        rangeSetting.setValue(this, DELEGATED_PROPERTIES[2], Integer.valueOf(value));
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            BlockPos blockPos = ((BlockPos) element);
            Box box = new Box(blockPos);
            if (__UNDEF_KEY__) {
                TextShaderComponent2.checkCondition(box.method_35578(blockPos.method_10264()), INSTANCE.getColor());
                int index = 4;
                Color color = PolygonShaderComponent.INSTANCE.resolveColor(INSTANCE.getColor(), 1.0F);
                Box box2 = box.method_35578(blockPos.method_10264());
            }
            TextShaderComponent2.checkCondition(box, INSTANCE.getColor());
            index = 8;
            int index2 = 1;
            box2 = INSTANCE.getColor();
            Vec3d vec = new Vec3d(box.field_1320, box.field_1322, box.field_1321);
            Vec3d vec2 = new Vec3d(box.field_1323, box.field_1322, box.field_1324);
            TextShaderComponent2.checkCondition(vec2, vec, box2, color, index2, index);
            index = 8;
            index2 = 1;
            box2 = INSTANCE.getColor();
            vec = new Vec3d(box.field_1323, box.field_1322, box.field_1321);
            vec2 = new Vec3d(box.field_1320, box.field_1322, box.field_1324);
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        itemList = this.resolveList();
    }

    private List resolveList() {
        List<BlockPos> list = new ArrayList();
        double offset = (SharedKt.getPlayer().getX() - this.getRange());
        double offset2 = (SharedKt.getPlayer().getX() + this.getRange());
        if (offset < offset2) {
            double offset3 = (SharedKt.getPlayer().getZ() - this.getRange());
            double offset4 = (SharedKt.getPlayer().getZ() + this.getRange());
            if (offset3 < offset4) {
                BlockPos blockPos = BlockPos.method_49637(offset, SharedKt.getWorld().method_31607(), offset3);
                if (__UNDEF_KEY__) {
                    if (!(Intrinsics.areEqual(SharedKt.getWorld().getBlockState(blockPos).getBlock(), Blocks.field_9987))) {
                        list.add(blockPos);
                    }
                }
            }
        }
        return list;
    }

    static {
        KProperty[] items = new KProperty[3];
        INSTANCE = new VoidEspModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", VoidEspMode.CROSS);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", Color.WHITE);
        rangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "range", 10, new IntRange(1, 64));
        itemList = new ArrayList();
    }

}
