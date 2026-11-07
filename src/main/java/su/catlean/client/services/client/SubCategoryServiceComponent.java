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
        EasingServiceComponent easingServiceComponent = this.easingServiceComponent;
        SubCategory subCategory = this.subCategory;
        float factor = this.factorValue2;
        float factor2 = this.factorValue;
        return ("Selector(x=" + factor2 + ", w=" + factor + ", subCategory=" + subCategory + ", animation=" + easingServiceComponent + ")");
    }

    public int hashCode() {
        int index = Float.hashCode(this.factorValue);
        index = ((index * 31) + Float.hashCode(this.factorValue2));
        index = ((index * 31) + this.subCategory.hashCode());
        index = ((index * 31) + this.easingServiceComponent.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubCategoryServiceComponent)) {
            return false;
        }
        SubCategoryServiceComponent subCategoryServiceComponent = ((SubCategoryServiceComponent) other);
        if (Float.compare(this.factorValue, subCategoryServiceComponent.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, subCategoryServiceComponent.factorValue2)) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.subCategory, subCategoryServiceComponent.subCategory))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.easingServiceComponent, subCategoryServiceComponent.easingServiceComponent))) {
            return false;
        }
        return true;
    }

}
