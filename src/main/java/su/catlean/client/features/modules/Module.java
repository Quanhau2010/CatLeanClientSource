package su.catlean.client.features.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract;
import su.catlean.api.contracts.Contract5;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategory;
import su.catlean.client.services.render.TitleRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.types.OptionMode16;
import su.catlean.gofra.Gofra;
import su.catlean.interfaces.IEntity;

public abstract class Module implements Contract5, Contract {

    private final String textValue;
    private final SubCategory subCategory;
    private final List itemList;
    private final List itemList2;
    private final List itemList3;
    private final String textValue2;
    private final VisibleVisibleSettingPropertyImpl enabledSetting;
    private final DefaultValueVisibleSettingPropertyImpl2 bindSetting;

    public Module(String id, SubCategory category, List aliases) {
        this.textValue = id;
        this.subCategory = category;
        this.itemList = aliases;
        this.itemList2 = new ArrayList();
        this.itemList3 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        String[] items = new String[1];
        items[0] = "-";
        items = ((Iterable) StringsKt.split$default(((CharSequence) this.textValue), items, false));
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            String text = ((String) element);
            if (((CharSequence) text).length() > 0) {
                char ch = text.charAt(0);
                StringBuilder stringBuilder2 = new StringBuilder();
                int index = 0;
                CharSequence charSequence = ((CharSequence) String.valueOf(ch).toUpperCase(Locale.ROOT));
                ch = text;
                index = 1;
            } else {
            }
            stringBuilder2.append(charSequence).append(ch.substring(index)).toString().append(text);
            stringBuilder.append(32);
            StringsKt.trim(((CharSequence) stringBuilder));
        }
        this.textValue2 = stringBuilder.toString();
        this.enabledSetting = VisibleRenderHelper.registerSetting(this, "enabled", false);
        this.bindSetting = VisibleRenderHelper.registerSetting(this, "bind", new KeyRecord(0, false, false));
    }

    public String getString() {
        return this.textValue;
    }

    public SubCategory getSubCategory() {
        return this.subCategory;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList() {
        return this.itemList2;
    }

    public List getList2() {
        return this.itemList3;
    }

    public String getString2() {
        return this.textValue2;
    }

    public boolean getEnabled() {
        return ((Boolean) this.enabledSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void setEnabled(boolean value) {
        this.enabledSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    public KeyRecord getBind() {
        return ((KeyRecord) this.bindSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public void setBind(KeyRecord value) {
        this.bindSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    public boolean checkCondition() {
        return SharedKt.getMc().world != null;
    }

    public void updateValue() {
        if (this.getEnabled()) {
            this.updateValue2();
        }
        this.executeAction();
    }

    public void executeAction() {
        this.setEnabled(true);
        Gofra.INSTANCE.unplug(this);
        Gofra.INSTANCE.plug(this);
        this.updateValue();
        TitleRenderHelper.executeAction(this.textValue2, MessageServiceComponent.resolveString(this, "enable", new Object[0], true), 1, OptionMode16.ENABLED);
    }

    public void executeAction(String message) {
        this.updateValue2();
        MessageServiceComponent.S(this, message, false);
    }

    public void updateValue2() {
        this.setEnabled(false);
        Gofra.INSTANCE.unplug(this);
        this.updateValue2();
        TitleRenderHelper.executeAction(this.textValue2, MessageServiceComponent.resolveString(this, "disable", new Object[0], true), 1, OptionMode16.DISABLED);
    }

    public void updateValue() {
    }

    public void updateValue2() {
    }

    public Vec3d resolveMinecraftObject(Entity receiver) {
        return ((IEntity) receiver).catLean$getPosition();
    }

    static {
        KProperty[] items = new KProperty[2];
    }

    public static void updateValue(Module[] arg0) {
        INSTANCEArray = arg0;
    }

    public static Module[] process() {
        return INSTANCEArray;
    }

}
