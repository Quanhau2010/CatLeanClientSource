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
        StringBuilder var13 = new StringBuilder();
        Object var14 = var13;
        Object var28 = this;
        int var15 = 0;
        String[] var16 = new String[1];
        var16[0] = "-";
        var16 = (Iterable) StringsKt.split$default((CharSequence) this.textValue);
        int var17 = 0;
        Iterator iterator = var16.iterator();
        while (iterator.hasNext()) {
            Object var19 = iterator.next();
            String var20 = (String) var19;
            int var21 = 0;
            Object var22 = var20;
            if ((CharSequence) var22.length() > 0) {
                char var23 = var22.charAt(0);
                StringBuilder var24 = new StringBuilder();
                Object var25 = var14;
                int var26 = 0;
                CharSequence var27 = (CharSequence) String.valueOf().toUpperCase(Locale.ROOT);
                var23 = var22;
                var26 = 1;
            } else {
            }
            var24.append().append(var23.substring()).toString().append();
            var14.append(32);
            StringsKt.trim((CharSequence) var14);
        }
        var28.textValue2 = var13.toString();
        this.enabledSetting = VisibleRenderHelper.registerSetting(this, "enabled");
        this.bindSetting = VisibleRenderHelper.registerSetting(this, "bind", new KeyRecord());
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
        return (Boolean) this.enabledSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void setEnabled(boolean value) {
        this.enabledSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    public KeyRecord getBind() {
        return (KeyRecord) this.bindSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public void setBind(KeyRecord value) {
        this.bindSetting.setValue(this, DELEGATED_PROPERTIES[1], value);
    }

    public boolean checkCondition() {
        return SharedKt.getMc().world != null;
    }

    public void updateValue(long arg0) {
        long var3 = ((arg0 ^ 67469537118988L) >>> 56);
        long var4 = (((arg0 ^ 67469537118988L) << 8) >>> 8);
        long var6 = (arg0 ^ 65469789313429L);
        long var8 = (arg0 ^ 130783482560314L);
        if (this.getEnabled()) {
            this.updateValue2();
        }
        this.executeAction();
    }

    public void executeAction(byte arg0, long arg1) {
        int var4 = ((arg0 << 56) | ((arg1 << 8) >>> 8));
        long var6 = (var4 ^ 106488220257691L);
        long var8 = ((var4 ^ 39325524053189L) >>> 32);
        long var9 = (((var4 ^ 39325524053189L) << 32) >>> 40);
        long var10 = (((var4 ^ 39325524053189L) << 56) >>> 56);
        long var11 = (var4 ^ 23933300365065L);
        long var13 = (var4 ^ 81931170417796L);
        this.setEnabled(1);
        Gofra.INSTANCE.unplug(this);
        Gofra.INSTANCE.plug(this);
        this.updateValue();
        TitleRenderHelper.executeAction(this.textValue2, MessageServiceComponent.resolveString(this, "enable", new Object[0], 1), 1, OptionMode16.ENABLED);
    }

    public void executeAction(String message) {
        this.updateValue2();
        MessageServiceComponent.S(this, message);
    }

    public void updateValue2(long arg0) {
        long var3 = (arg0 ^ 112210832039682L);
        long var5 = ((arg0 ^ 40765843988060L) >>> 32);
        long var6 = (((arg0 ^ 40765843988060L) << 32) >>> 40);
        long var7 = (((arg0 ^ 40765843988060L) << 56) >>> 56);
        long var8 = (arg0 ^ 57994491392730L);
        long var10 = (arg0 ^ 83922319646237L);
        this.setEnabled(0);
        Gofra.INSTANCE.unplug(this);
        this.updateValue2();
        TitleRenderHelper.executeAction(this.textValue2, MessageServiceComponent.resolveString(this, "disable", new Object[0], 1), 1, OptionMode16.DISABLED);
    }

    public void updateValue() {
    }

    public void updateValue2() {
    }

    public Vec3d resolveMinecraftObject(Entity receiver) {
        return (IEntity) receiver.catLean$getPosition();
    }

    static {
        KProperty[] var22 = new KProperty[2];
    }

    public static void updateValue(Module[] arg0) {
        INSTANCEArray = arg0;
    }

    public static Module[] process() {
        return INSTANCEArray;
    }

}
