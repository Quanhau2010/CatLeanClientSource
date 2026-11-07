package su.catlean.client.services.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.slf4j.Logger;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.CrosshairRenderEvent;
import su.catlean.api.event.events.render.FrameBufferEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.ScreenMouseCoordsEvent;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.ImageServiceComponent;
import su.catlean.client.services.client.JsonJsonServiceComponent5Impl4;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent6;
import su.catlean.client.services.client.config.models.IdRecord10;
import su.catlean.client.services.client.config.models.IdRecord5;
import su.catlean.client.services.client.config.models.IdRecord8;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class POSITIONCOLORRenderHelper implements Contract9 {

    public static final POSITIONCOLORRenderHelper INSTANCE;
    private static List itemList;
    private static final StackShaderComponent stackShaderComponent;
    private static List itemList2;
    private static List itemList3;
    private static CheckRenderHelper checkRenderHelper;
    private static CheckRenderHelper checkRenderHelper2;
    private static float factorValue;
    private static float factorValue2;
    public static final float factorValue3 = 5.0F;
    private static int countValue;

    private POSITIONCOLORRenderHelper() {
    }

    public List getList() {
        return itemList;
    }

    public void executeAction(List value) {
        itemList = value;
    }

    public StackShaderComponent getStackShaderComponent() {
        return stackShaderComponent;
    }

    public List getList2() {
        return itemList2;
    }

    public void executeAction2(List value) {
        itemList2 = value;
    }

    public List getList3() {
        return itemList3;
    }

    public void executeAction3(List value) {
        itemList3 = value;
    }

    public CheckRenderHelper getCheckRenderHelper() {
        return checkRenderHelper;
    }

    public void updateValue(CheckRenderHelper value) {
        checkRenderHelper = value;
    }

    public CheckRenderHelper getCheckRenderHelper2() {
        return checkRenderHelper2;
    }

    public void updateValue2(CheckRenderHelper value) {
        checkRenderHelper2 = value;
    }

    public float getNumericValue() {
        return factorValue;
    }

    public void updateValue(float value) {
        factorValue = value;
    }

    public float getNumericValue2() {
        return factorValue2;
    }

    public void updateValue2(float value) {
        factorValue2 = value;
    }

    private void onScreenMouseCoordsEvent(ScreenMouseCoordsEvent arg0) {
        factorValue = arg0.getX();
        factorValue2 = arg0.getY();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable var10 = (Iterable) itemList;
        int var11 = 0;
        Iterator iterator = var10.iterator();
        while (iterator.hasNext()) {
            Object var13 = iterator.next();
            CheckRenderHelper var14 = (CheckRenderHelper) var13;
            int var15 = 0;
            if (var14.getEnabled()) {
                var14.updateValue();
            }
        }
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        checkRenderHelper2 = null;
        Iterable var33 = (Iterable) itemList;
        int var34 = 0;
        Iterator iterator = var33.iterator();
        while (iterator.hasNext()) {
            Object var36 = iterator.next();
            CheckRenderHelper var37 = (CheckRenderHelper) var36;
            int var38 = 0;
            if (var37.getEnabled()) {
                var37.render2(arg0.getContext());
            }
        }
        stackShaderComponent.executeAction(arg0.getContext().method_51448(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor5(), (PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()) * PolygonShaderComponent.INSTANCE.getNumericValue())), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor6(), (PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor6()) * PolygonShaderComponent.INSTANCE.getNumericValue())), 0);
        if (!((Collection) itemList2.isEmpty())) {
            int var28 = 4;
            int var29 = 0;
            int var30 = itemList2.size();
            VertexFormat var31 = class_290.field_1576;
            var33 = new FormatRenderHelper();
            var34 = new Color(1157627903, 1);
            itemList2.removeIf(this::checkCondition);
            FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f((Matrix3x2fc) arg0.getContext().method_51448()));
        }
        if (!((Collection) itemList3.isEmpty())) {
            itemList3.removeIf(this::checkCondition2);
        }
        var33 = (Iterable) itemList;
        var34 = 0;
        iterator = var33.iterator();
        while (iterator.hasNext()) {
            var36 = iterator.next();
            var37 = (CheckRenderHelper) var36;
            var38 = 0;
            if (var37.getEnabled()) {
                var37.render(arg0.getContext());
            }
        }
        SFMServiceComponent.resolveFontRenderHelper().executeAction();
    }

    private void onInputEvent(InputEvent arg0) {
        Iterable var13 = (Iterable) itemList;
        int var14 = 0;
        Iterator iterator = var13.iterator();
        while (iterator.hasNext()) {
            Object var16 = iterator.next();
            CheckRenderHelper var17 = (CheckRenderHelper) var16;
            int var18 = 0;
            if (var17.getEnabled()) {
                var17.executeAction(arg0.getKey(), arg0.getAction());
            }
        }
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer((class_276) InventoryWidgetCheckRenderHelperImpl.INSTANCE.getMinecraftObject());
        arg0.cancel();
    }

    private void onCrosshairRenderEvent(CrosshairRenderEvent arg0) {
        arg0.cancel();
    }

    private void updateValue() {
        CheckRenderHelper[] var3 = new CheckRenderHelper[23];
        var3[0] = CoordWidgetRenderHelper.INSTANCE;
        var3[1] = FpsWidgetCheckRenderHelperImpl.INSTANCE;
        var3[2] = KeybindsWidgetCheckRenderHelperImpl.INSTANCE;
        var3[3] = PingWidgetCheckRenderHelperImpl.INSTANCE;
        var3[4] = PotionsWidgetCheckRenderHelperImpl.INSTANCE;
        var3[5] = StaffWidgetCheckRenderHelperImpl.INSTANCE;
        var3[6] = TargetInfoCheckRenderHelperImpl.INSTANCE;
        var3[7] = TpsWidgetCheckRenderHelperImpl.INSTANCE;
        var3[8] = WatermarkWidgetCheckRenderHelperImpl.INSTANCE;
        var3[9] = NotificationsCheckRenderHelperImpl.INSTANCE;
        var3[10] = SpeedWidgetCheckRenderHelperImpl.INSTANCE;
        var3[11] = InventoryWidgetCheckRenderHelperImpl.INSTANCE;
        var3[12] = CrystalSpeedWidgetCheckRenderHelperImpl.INSTANCE;
        var3[13] = MediaPlayerWidgetCheckRenderHelperImpl.INSTANCE;
        var3[14] = ArmorWidgetCheckRenderHelperImpl.INSTANCE;
        var3[15] = ChestCounterWidgetRenderHelper.INSTANCE;
        var3[16] = PvpResourcesWidgetCheckRenderHelperImpl.INSTANCE;
        var3[17] = PlayerListWidgetCheckRenderHelperImpl.INSTANCE;
        var3[18] = CrosshairRenderHelper.INSTANCE;
        var3[19] = FlightWidgetCheckRenderHelperImpl.INSTANCE;
        var3[20] = PhaseWidgetCheckRenderHelperImpl.INSTANCE;
        var3[21] = CooldownsWidgetRenderHelper.INSTANCE;
        var3[22] = MacroWidgetCheckRenderHelperImpl.INSTANCE;
        itemList.addAll((Collection) CollectionsKt.listOf());
    }

    public void updateValue2() {
        Iterable var7 = (Iterable) itemList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            CheckRenderHelper var11 = (CheckRenderHelper) var10;
            int var12 = 0;
            Iterable var13 = (Iterable) var11.getList();
            int var14 = 0;
            Iterator iterator2 = var13.iterator();
            while (iterator2.hasNext()) {
                Object var16 = iterator2.next();
                VisibleSettingProperty var17 = (VisibleSettingProperty) var16;
                int var18 = 0;
                Iterable var19 = (Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveIdRecord8().getList();
                Iterator iterator3 = var19.iterator();
                if (iterator3.hasNext()) {
                    Object var21 = iterator3.next();
                    IdRecord5 var22 = (IdRecord5) var21;
                    int var23 = 0;
                } else {
                }
                if ((IdRecord5) null == null) {
                }
                Object var24 = var21;
                iterator3 = (Iterable) var24.getList();
                var21 = iterator3.iterator();
                if (var21.hasNext()) {
                    var22 = var21.next();
                    var23 = (IdRecord10) var22;
                    int var25 = 0;
                } else {
                }
                if ((IdRecord10) null == null) {
                }
                Object var26 = var22;
                var17.setValue(var26.getString2());
                var17.setValue();
                String var28 = var27.getMessage();
                String var29 = var11.getString2();
                String var30 = var17.getString2();
                SharedKt.getLogger().warn(("Could not parse setting: " + var30 + " in " + var29 + ": " + var28));
            }
        }
    }

    private static boolean checkCondition(FormatRenderHelper arg0, Color arg1, ServiceComponent6 arg2) {
        arg0.resolveFormatRenderHelper(arg2.getMatrix3x2f(), arg2.getNumericValue(), (arg2.getNumericValue2() + arg2.getNumericValue4()), 0.0F).resolveFormatRenderHelper(arg1).resolveFormatRenderHelper(arg2.getMatrix3x2f(), (arg2.getNumericValue() + arg2.getNumericValue3()), (arg2.getNumericValue2() + arg2.getNumericValue4()), 0.0F).resolveFormatRenderHelper(arg1).resolveFormatRenderHelper(arg2.getMatrix3x2f(), (arg2.getNumericValue() + arg2.getNumericValue3()), arg2.getNumericValue2(), 0.0F).resolveFormatRenderHelper(arg1).resolveFormatRenderHelper(arg2.getMatrix3x2f(), arg2.getNumericValue(), arg2.getNumericValue2(), 0.0F).resolveFormatRenderHelper(arg1);
        return true;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(ImageServiceComponent arg0) {
        MissingnoRenderHelper.executeAction(arg0.getMissingnoRenderHelper(), arg0.getMatrix3x2f(), arg0.getNumericValue(), arg0.getNumericValue2(), arg0.getNumericValue3(), arg0.getNumericValue4(), null, null, arg0.getNumericValue5());
        return true;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new POSITIONCOLORRenderHelper();
        itemList = new ArrayList();
        stackShaderComponent = new StackShaderComponent();
        itemList2 = new ArrayList();
        itemList3 = new ArrayList();
        INSTANCE.updateValue();
        INSTANCE.updateValue2();
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 46;
        return 0;
    }

}
