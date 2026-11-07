package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import su.catlean.client.services.client.module.category.SubCategory;

public class SubCategoryServiceComponent {

    private final float factorValue;
    private final float factorValue2;
    private final SubCategory subCategory;
    private final EasingServiceComponent easingServiceComponent;

    public SubCategoryServiceComponent(float x, float w, SubCategory subCategory, EasingServiceComponent animation) {
        this.factorValue = x;
        this.factorValue2 = w;
        this.subCategory = subCategory;
        this.easingServiceComponent = animation;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public SubCategory getSubCategory() {
        return this.subCategory;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return this.easingServiceComponent;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public SubCategory getSubCategory2() {
        return this.subCategory;
    }

    public EasingServiceComponent getEasingServiceComponent2() {
        return this.easingServiceComponent;
    }

    public SubCategoryServiceComponent resolveSubCategoryServiceComponent(float x, float w, SubCategory subCategory, EasingServiceComponent animation) {
        return new SubCategoryServiceComponent(x, w, subCategory, animation);
    }

    public String toString() {
        EasingServiceComponent var3 = this.easingServiceComponent;
        SubCategory var4 = this.subCategory;
        float var5 = this.factorValue2;
        float var6 = this.factorValue;
        return ("Selector(x=" + var6 + ", w=" + var5 + ", subCategory=" + var4 + ", animation=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = Float.hashCode(this.factorValue);
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        var3 = ((var3 * 31) + this.subCategory.hashCode());
        var3 = ((var3 * 31) + this.easingServiceComponent.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubCategoryServiceComponent)) {
            return false;
        }
        SubCategoryServiceComponent var5 = (SubCategoryServiceComponent) other;
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.subCategory, var5.subCategory))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, var5.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
