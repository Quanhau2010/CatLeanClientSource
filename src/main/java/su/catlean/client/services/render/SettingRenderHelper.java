package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_3532;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class SettingRenderHelper {

    private final VisibleSettingProperty visibleSettingProperty;
    private float factorValue;
    private float factorValue2;
    private final int countValue;
    private boolean enabledFlag;
    private String textValue;

    public SettingRenderHelper(VisibleSettingProperty setting, float x, float y, int index) {
        this.visibleSettingProperty = setting;
        this.factorValue = x;
        this.factorValue2 = y;
        this.countValue = index;
        this.textValue = "-";
    }

    public VisibleSettingProperty getVisibleSettingProperty() {
        return this.visibleSettingProperty;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void render(Matrix3x2fStack m, DrawContext context) {
        StackShaderComponent2.executeAction(context.method_51448(), (this.factorValue + 40.0F), ((this.factorValue2 + 10.0F) + (this.countValue * 10.0F)), 15.0F, 8.0F, 2.0F, 2.0F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor11(), NewThemeRenderHelper.INSTANCE.getColor9(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, String.valueOf("RGBA".charAt(this.countValue)), (this.factorValue + 34.0F), ((this.factorValue2 + 13.5F) + (this.countValue * 10.0F)), NewThemeRenderHelper.INSTANCE.getColor7());
        if (this.enabledFlag) {
        } else {
            Integer[] items = new Integer[4];
            items[0] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getRed());
            items[1] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getGreen());
            items[2] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getBlue());
            items[3] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getAlpha());
        }
        if (this.enabledFlag) {
        } else {
        }
        float factor = 1.0F;
        this.textValue.render(String.valueOf(((Number) CollectionsKt.listOf(items).get(this.countValue))), (this.factorValue + 47.0F), ((this.factorValue2 + 13.0F) + (this.countValue * 10.0F)), PolygonShaderComponent.INSTANCE, NewThemeRenderHelper.INSTANCE.getColor8().resolveColor((Math.sin((System.currentTimeMillis() / 50.0D)) + 0.5F), factor));
    }

    public void setValue(int mouseX, int mouseY) {
        float factor = (this.factorValue + 40.0F);
        float factor2 = (this.factorValue + 55.0F);
        int index = mouseX;
        if (factor <= index) {
        } else {
        }
        factor = ((this.factorValue2 + 10.0F) + (this.countValue * 10.0F));
        factor2 = ((this.factorValue2 + 18.0F) + (this.countValue * 10.0F));
        index = mouseY;
        if (factor <= index) {
        } else {
        }
        this.enabledFlag = !(this.enabledFlag);
        factor = new Integer[4];
        factor[0] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getRed());
        factor[1] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getGreen());
        factor[2] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getBlue());
        factor[3] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getAlpha());
        this.textValue = String.valueOf(((Number) CollectionsKt.listOf(factor).get(this.countValue)));
    }

    public void setValue(char charParam) {
        this.textValue = (this.textValue + charParam);
    }

    public void setValue(int key) {
        this.enabledFlag = false;
        int index = class_3532.method_15340(Integer.parseInt(this.textValue), 0, 255);
        Color color = ((Color) this.visibleSettingProperty.getObject2());
        if (!(this.countValue)) {
        }
        if (this.countValue == 1) {
        } else {
        }
        if (this.countValue == 2) {
        } else {
        }
        if (this.countValue == 3) {
        } else {
        }
        index.updateValue(new Color(index, color.getBlue(), index, color.getAlpha()));
        index = color.getRed();
        if (__UNDEF_KEY__ >= 0) {
        }
        if (((CharSequence) this.textValue).length() > 0) {
        } else {
        }
        this.textValue = this.textValue.substring(0, (this.textValue.length() - 1));
    }

    public boolean checkCondition(double mouseX, double mouseY, double verticalAmount) {
        float factor = (this.factorValue + 40.0F);
        float factor2 = (this.factorValue + 55.0F);
        double offset = mouseX;
        if (factor <= offset) {
        } else {
            if (offset <= factor2) {
                factor = ((this.factorValue2 + 10.0F) + (this.countValue * 10.0F));
                factor2 = ((this.factorValue2 + 18.0F) + (this.countValue * 10.0F));
                offset = mouseY;
                if (factor <= offset) {
                } else {
                    if (offset <= factor2) {
                        factor2 = new Integer[4];
                        factor2[0] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getRed());
                        factor2[1] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getGreen());
                        factor2[2] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getBlue());
                        factor2[3] = Integer.valueOf(((Color) this.visibleSettingProperty.getObject2()).getAlpha());
                        factor = CollectionsKt.listOf(factor2);
                        offset = ((Iterable) factor);
                        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(offset, 10)));
                        int index = 0;
                        Iterator iterator = offset.iterator();
                        while (iterator.hasNext()) {
                            Object element = iterator.next();
                            if (index < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            int index2 = ((Number) element);
                            if (index == this.countValue) {
                            } else {
                            }
                            collection.add(Integer.valueOf(index2));
                        }
                        factor2 = collection;
                        this.visibleSettingProperty.updateValue(new Color(((Number) factor2.get(0)), ((Number) factor2.get(1)), ((Number) factor2.get(2)), ((Number) factor2.get(3))));
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
