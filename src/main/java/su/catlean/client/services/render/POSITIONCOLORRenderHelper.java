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
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) element);
            if (checkRenderHelper.getEnabled()) {
                checkRenderHelper.updateValue();
            }
        }
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        checkRenderHelper2 = null;
        Iterable iterable = ((Iterable) itemList);
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) element);
            if (checkRenderHelper.getEnabled()) {
                checkRenderHelper.render2(arg0.getContext());
            }
        }
        stackShaderComponent.executeAction(arg0.getContext().method_51448(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor5(), (PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()) * PolygonShaderComponent.INSTANCE.getNumericValue())), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor6(), (PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor6()) * PolygonShaderComponent.INSTANCE.getNumericValue())), false);
        if (!(((Collection) itemList2).isEmpty())) {
            int index2 = 4;
            int index3 = 0;
            int index4 = itemList2.size();
            VertexFormat vertexFormat = class_290.field_1576;
            iterable = new FormatRenderHelper(vertexFormat, index4, index3, index2);
            index = new Color(1157627903, true);
            itemList2.removeIf(this::checkCondition);
            FormatRenderHelper.executeAction(iterable, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f(((Matrix3x2fc) arg0.getContext().method_51448())));
        }
        if (!(((Collection) itemList3).isEmpty())) {
            itemList3.removeIf(this::checkCondition2);
        }
        iterable = ((Iterable) itemList);
        index = 0;
        iterator = iterable.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            checkRenderHelper = ((CheckRenderHelper) element);
            if (checkRenderHelper.getEnabled()) {
                checkRenderHelper.render(arg0.getContext());
            }
        }
        SFMServiceComponent.resolveFontRenderHelper().executeAction();
    }

    private void onInputEvent(InputEvent arg0) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) element);
            if (checkRenderHelper.getEnabled()) {
                checkRenderHelper.executeAction(arg0.getKey(), arg0.getAction());
            }
        }
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer(((class_276) InventoryWidgetCheckRenderHelperImpl.INSTANCE.getMinecraftObject()));
        arg0.cancel();
    }

    private void onCrosshairRenderEvent(CrosshairRenderEvent arg0) {
        arg0.cancel();
    }

    private void updateValue() {
        CheckRenderHelper[] items = new CheckRenderHelper[23];
        items[0] = CoordWidgetRenderHelper.INSTANCE;
        items[1] = FpsWidgetCheckRenderHelperImpl.INSTANCE;
        items[2] = KeybindsWidgetCheckRenderHelperImpl.INSTANCE;
        items[3] = PingWidgetCheckRenderHelperImpl.INSTANCE;
        items[4] = PotionsWidgetCheckRenderHelperImpl.INSTANCE;
        items[5] = StaffWidgetCheckRenderHelperImpl.INSTANCE;
        items[6] = TargetInfoCheckRenderHelperImpl.INSTANCE;
        items[7] = TpsWidgetCheckRenderHelperImpl.INSTANCE;
        items[8] = WatermarkWidgetCheckRenderHelperImpl.INSTANCE;
        items[9] = NotificationsCheckRenderHelperImpl.INSTANCE;
        items[10] = SpeedWidgetCheckRenderHelperImpl.INSTANCE;
        items[11] = InventoryWidgetCheckRenderHelperImpl.INSTANCE;
        items[12] = CrystalSpeedWidgetCheckRenderHelperImpl.INSTANCE;
        items[13] = MediaPlayerWidgetCheckRenderHelperImpl.INSTANCE;
        items[14] = ArmorWidgetCheckRenderHelperImpl.INSTANCE;
        items[15] = ChestCounterWidgetRenderHelper.INSTANCE;
        items[16] = PvpResourcesWidgetCheckRenderHelperImpl.INSTANCE;
        items[17] = PlayerListWidgetCheckRenderHelperImpl.INSTANCE;
        items[18] = CrosshairRenderHelper.INSTANCE;
        items[19] = FlightWidgetCheckRenderHelperImpl.INSTANCE;
        items[20] = PhaseWidgetCheckRenderHelperImpl.INSTANCE;
        items[21] = CooldownsWidgetRenderHelper.INSTANCE;
        items[22] = MacroWidgetCheckRenderHelperImpl.INSTANCE;
        itemList.addAll(((Collection) CollectionsKt.listOf(items)));
    }

    public void updateValue2() {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            CheckRenderHelper checkRenderHelper = ((CheckRenderHelper) element);
            Iterable iterable2 = ((Iterable) checkRenderHelper.getList());
            Iterator iterator2 = iterable2.iterator();
            while (iterator2.hasNext()) {
                Object element2 = iterator2.next();
                VisibleSettingProperty visibleSettingProperty = ((VisibleSettingProperty) element2);
                Iterable iterable3 = ((Iterable) ProxyGuiElement.INSTANCE.getJsonJsonServiceComponent5Impl4().resolveIdRecord8().getList());
                Iterator iterator3 = iterable3.iterator();
                while (iterator3.hasNext()) {
                    Object element3 = iterator3.next();
                    IdRecord5 idRecord5 = ((IdRecord5) element3);
                    int index = 0;
                }
                if (((IdRecord5) null) == null) {
                }
                iterator3 = ((Iterable) element3.getList());
                element3 = iterator3.iterator();
                while (element3.hasNext()) {
                    idRecord5 = element3.next();
                    index = ((IdRecord10) idRecord5);
                }
                if (((IdRecord10) null) == null) {
                }
                visibleSettingProperty.setValue(idRecord5.getString2());
                visibleSettingProperty.setValue();
                String text = this.getMessage();
                String text2 = checkRenderHelper.getString2();
                String text3 = visibleSettingProperty.getString2();
                SharedKt.getLogger().warn(("Could not parse setting: " + text3 + " in " + text2 + ": " + text));
            }
        }
    }

    private static boolean checkCondition(FormatRenderHelper arg0, Color arg1, ServiceComponent6 arg2) {
        arg0.resolveFormatRenderHelper(arg2.getMatrix3x2f(), arg2.getNumericValue(), (arg2.getNumericValue2() + arg2.getNumericValue4()), 0.0F).resolveFormatRenderHelper(arg1).resolveFormatRenderHelper(arg2.getMatrix3x2f(), (arg2.getNumericValue() + arg2.getNumericValue3()), (arg2.getNumericValue2() + arg2.getNumericValue4()), 0.0F).resolveFormatRenderHelper(arg1).resolveFormatRenderHelper(arg2.getMatrix3x2f(), (arg2.getNumericValue() + arg2.getNumericValue3()), arg2.getNumericValue2(), 0.0F).resolveFormatRenderHelper(arg1).resolveFormatRenderHelper(arg2.getMatrix3x2f(), arg2.getNumericValue(), arg2.getNumericValue2(), 0.0F).resolveFormatRenderHelper(arg1);
        return true;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(ImageServiceComponent arg0) {
        MissingnoRenderHelper.executeAction(arg0.getMissingnoRenderHelper(), arg0.getMatrix3x2f(), arg0.getNumericValue(), arg0.getNumericValue2(), arg0.getNumericValue3(), arg0.getNumericValue4(), null, null, arg0.getNumericValue5());
        return true;
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
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
