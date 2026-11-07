package su.catlean.client.services.player;

import java.util.List;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_1661;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import su.catlean.client.features.modules.Module;

public class EntityHelper2 {

    private static int countValue;

    public static List resolveList(ClientPlayerEntity receiver) {
        ItemStack[] var4 = new ItemStack[4];
        var4[0] = receiver.method_31548().method_5438(39);
        var4[1] = receiver.method_31548().method_5438(38);
        var4[2] = receiver.method_31548().method_5438(37);
        var4[3] = receiver.method_31548().method_5438(36);
        if (CollectionsKt.listOf() != null) {
        }
        return null;
    }

    public static List resolveList(PlayerEntity receiver) {
        ItemStack[] var4 = new ItemStack[4];
        var4[0] = receiver.method_31548().method_5438(39);
        var4[1] = receiver.method_31548().method_5438(38);
        var4[2] = receiver.method_31548().method_5438(37);
        var4[3] = receiver.method_31548().method_5438(36);
        if (var3) {
        }
        return CollectionsKt.mutableListOf();
    }

    public static List resolveList(LivingEntity receiver) {
        ItemStack[] var6 = new ItemStack[4];
        var6[0] = Items.field_8162.method_7854();
        var6[1] = Items.field_8162.method_7854();
        var6[2] = Items.field_8162.method_7854();
        var6[3] = Items.field_8162.method_7854();
        return CollectionsKt.mutableListOf();
    }

    public static void updateValue(int arg0) {
        countValue = arg0;
    }

    public static int getNumericValue() {
        return countValue;
    }

    public static int getNumericValue2() {
        return 100;
        return 0;
    }

}
