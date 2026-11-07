package su.catlean.client.services.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;

public class EntityHelper4 {

    private static String[] textValueArray;

    public static boolean isFriend(PlayerEntity receiver) {
        return PlayerEntityHelper.INSTANCE.checkCondition(receiver.method_7334().name());
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
