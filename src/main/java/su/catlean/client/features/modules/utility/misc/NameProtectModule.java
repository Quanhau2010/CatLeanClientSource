package su.catlean.client.features.modules.utility.misc;

import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_640;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.StringDecomposerEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class NameProtectModule extends Module {

    public static final NameProtectModule INSTANCE;
    private static final SettingIdVisibleSettingPropertyImpl nameSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 replaceSetting;

    private NameProtectModule() {
        super("name-protect", SubCategoriesKt.getMiscUtilityCategory());
    }

    public String getName() {
        return (String) nameSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public NameProtectReplaceMode getReplace() {
        return (NameProtectReplaceMode) replaceSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onStringDecomposerEvent(StringDecomposerEvent arg0) {
        arg0.setString(this.resolveString(arg0.getString()));
    }

    public String resolveString(String text) {
        if (this.checkCondition()) {
            if (!(this.getEnabled())) {
            }
            return text;
        }
        String var23 = StringsKt.replace$default(text, SharedKt.getPlayer().method_7334().name(), this.getName());
        if (this.getReplace() != NameProtectReplaceMode.ONLY_SELF) {
            Iterable var24 = (Iterable) SharedKt.getNetwork().method_2880();
            int var25 = 0;
            Iterator iterator = var24.iterator();
            if (iterator.hasNext()) {
                Object var27 = iterator.next();
                class_640 var28 = (class_640) var27;
                int var29 = 0;
                if (0L >= 0) {
                    if (INSTANCE.getReplace() != NameProtectReplaceMode.ALL) {
                        if (PlayerEntityHelper.INSTANCE.checkCondition(var28.method_2966().name())) {
                        }
                        var23 = StringsKt.replace$default(var28.method_2966().name(), INSTANCE.getName());
                    }
                }
            }
        }
        return var23;
    }

    static {
        KProperty[] var29 = new KProperty[2];
        INSTANCE = new NameProtectModule();
        nameSetting = VisibleRenderHelper.registerSetting(INSTANCE, "name", "catlean.su", null, null, -2411962008896274420L);
        replaceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "replace", NameProtectReplaceMode.FRIENDS, null, null, -8254258175985844212L);
    }

}
