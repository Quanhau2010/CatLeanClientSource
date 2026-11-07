package su.catlean.client.services.client;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1041;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.types.OptionMode16;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.types.mappings.ysWhenMappings;

public class TitleServiceComponent {

    private final String textValue;
    private final String textValue2;
    private final OptionMode16 optionMode16;
    private final int countValue;
    private final ItemStack itemStack;
    private float factorValue;
    private final EasingServiceComponent easingServiceComponent;
    private final float factorValue2;
    private final ServiceComponent10 serviceComponent10;
    private final MissingnoRenderHelper missingnoRenderHelper;

    public TitleServiceComponent(String title, String message, OptionMode16 type, int time, ItemStack item) {
        this.textValue = title;
        this.textValue2 = message;
        this.optionMode16 = type;
        this.countValue = time;
        this.itemStack = item;
        this.factorValue = ((SharedKt.getMc().method_22683().method_4502() / 2.0F) + 41.0F);
        this.easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK, timestampValue);
        if (__UNDEF_KEY__ != null) {
            if (this.itemStack == null) {
            }
        }
        SFMServiceComponent.resolveFontRenderHelper().factorValue2 = ((this.textValue + this.textValue2).computeValue(this.textValue2) + 20.0F);
        this.serviceComponent10 = new ServiceComponent10();
        TitleRenderHelper.INSTANCE.getMissingnoRenderHelper5().missingnoRenderHelper = new NoWhenBranchMatchedException();
        if (__UNDEF_KEY__ <= 0) {
        }
    }

    public String getString() {
        return this.textValue;
    }

    public String getString2() {
        return this.textValue2;
    }

    public OptionMode16 getOptionMode16() {
        return this.optionMode16;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public ItemStack getMinecraftObject() {
        return this.itemStack;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public ServiceComponent10 getServiceComponent10() {
        return this.serviceComponent10;
    }

    public MissingnoRenderHelper getMissingnoRenderHelper() {
        return this.missingnoRenderHelper;
    }

    public boolean checkCondition() {
        return this.serviceComponent10.checkCondition(this.countValue);
    }

    public String getString3() {
        return this.textValue;
    }

    public String getString4() {
        return this.textValue2;
    }

    public OptionMode16 getOptionMode162() {
        return this.optionMode16;
    }

    public int getNumericValue2() {
        return this.countValue;
    }

    public ItemStack getMinecraftObject2() {
        return this.itemStack;
    }

    public TitleServiceComponent resolveTitleServiceComponent(String title, String message, OptionMode16 type, int time, ItemStack item) {
        return new TitleServiceComponent(title, message, type, time, item);
    }

    public static TitleServiceComponent resolveTitleServiceComponent(TitleServiceComponent arg0, String arg1, String arg2, OptionMode16 arg3, int arg4, ItemStack arg5, int arg6, Object arg7) {
        arg1 = arg0.textValue;
        arg2 = arg0.textValue2;
        arg3 = arg0.optionMode16;
        arg4 = arg0.countValue;
        if ((arg6 & 16) != 0) {
            arg5 = arg0.itemStack;
        }
        return arg0.resolveTitleServiceComponent(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        ItemStack stack = this.itemStack;
        int index = this.countValue;
        OptionMode16 optionMode16 = this.optionMode16;
        String text = this.textValue2;
        String text2 = this.textValue;
        return ("Notification(title=" + text2 + ", message=" + text + ", type=" + optionMode16 + ", time=" + index + ", item=" + stack + ")");
    }

    public int hashCode() {
        int index = this.textValue.hashCode();
        index = ((index * 31) + this.textValue2.hashCode());
        index = ((index * 31) + this.optionMode16.hashCode());
        index = ((index * 31) + Integer.hashCode(this.countValue));
        if (__UNDEF_KEY__ != null) {
            if (this.itemStack == null) {
            }
        }
        index = (0 + this.itemStack.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleServiceComponent)) {
            return false;
        }
        TitleServiceComponent titleServiceComponent = ((TitleServiceComponent) other);
        if (!(Intrinsics.areEqual(this.textValue, titleServiceComponent.textValue))) {
            return false;
        }
        if (!(this)) {
            return false;
        }
        if (this.optionMode16 != titleServiceComponent.optionMode16) {
            return false;
        }
        if (this.countValue != titleServiceComponent.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.itemStack, titleServiceComponent.itemStack))) {
            return false;
        }
        return true;
    }

}
