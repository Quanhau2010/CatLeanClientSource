package su.catlean.client.services.client;

import com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.stream.Stream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_124;
import net.minecraft.class_1934;
import net.minecraft.class_5250;
import net.minecraft.class_640;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import su.catlean.SharedKt;
import su.catlean.client.services.network.EntryPacketHelper;

public class ProfileServiceComponent {

    private final GameProfile gameProfile;
    private boolean enabledFlag;
    private final class_640 minecraftRef;
    private String textValue;

    public ProfileServiceComponent(GameProfile profile, boolean announced) {
        this.gameProfile = profile;
        this.enabledFlag = announced;
        this.minecraftRef = new class_640(this.gameProfile, false);
    }

    public GameProfile getGameProfile() {
        return this.gameProfile;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public class_640 getMinecraftObject() {
        return this.minecraftRef;
    }

    public String resolveString() {
        if (this.textValue == null) {
            this.textValue = EntryPacketHelper.INSTANCE.resolveMinecraftObject(this.minecraftRef).getString();
        }
        return this.textValue;
    }

    private String resolveString2() {
        String text = this.gameProfile.name();
        this.enabledFlag = false;
        return (class_124.field_1054 + " (near)" + class_124.field_1070);
        class_640 class640 = SharedKt.getNetwork().method_2874(text);
        if (SharedKt.getNetwork().method_2880().stream().map(this::resolveString).noneMatch(this::checkCondition)) {
            this.enabledFlag = true;
            return (class_124.field_1061 + " Spec!" + class_124.field_1070);
        }
        if (class640 != null && class640.method_2958() == class_1934.field_9219) {
            this.enabledFlag = false;
            return (class_124.field_1054 + " (gm3)" + class_124.field_1070);
        }
        this.enabledFlag = false;
        return "";
    }

    public String resolveString3() {
        return (this.resolveString2() + this.resolveString());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(this.getClass(), other.getClass())) {
            ProfileServiceComponent profileServiceComponent = ((ProfileServiceComponent) other);
            return Intrinsics.areEqual(this.gameProfile.name(), profileServiceComponent.gameProfile.name());
        }
        return false;
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    private static String resolveString(class_640 arg0) {
        return arg0.method_2966().name();
    }

    private static String resolveString(Function1 arg0, Object arg1) {
        return ((String) arg0.invoke(arg1));
    }

    private static boolean checkCondition(String arg0, String arg1) {
        return arg1.equals(arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

}
