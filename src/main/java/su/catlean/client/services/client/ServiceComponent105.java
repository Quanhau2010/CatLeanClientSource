package su.catlean.client.services.client;

import java.util.List;
import java.util.Optional;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1844;
import net.minecraft.class_1935;
import net.minecraft.class_2561;
import net.minecraft.class_9334;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ServiceComponent105 {

    public static final ServiceComponent105 INSTANCE;

    private ServiceComponent105() {
    }

    public ItemStack resolveMinecraftObject(int id) {
        class_1293[] var8 = new class_1293[2];
        var8[0] = new class_1293(class_1294.field_5907, 3600, 0);
        var8[1] = new class_1293(class_1294.field_5910, 1800, 3);
        List positions = CollectionsKt.listOf();
        class_2561 var6 = (class_2561) class_2561.method_43470("\u00a74\u00a7l[\u2605]\u00a7r\u00a7c\u00a7l \u0417\u0435\u043b\u044c\u0435 \u041a\u0438\u043b\u043b\u0435\u0440\u0430\u00a7r");
        var8 = new class_1293[2];
        var8[0] = new class_1293(class_1294.field_5913, 3600, 0);
        var8[1] = new class_1293(class_1294.field_5904, 3600, 2);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a73\u00a7l[\u2605]\u00a7r\u00a7b\u00a7l \u041c\u043e\u0447\u0430 \u0424\u043b\u0435\u0448\u0430\u00a7r");
        var8 = new class_1293[2];
        var8[0] = new class_1293(class_1294.field_5914, 900, 2);
        var8[1] = new class_1293(class_1294.field_5924, 900, 2);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a75\u00a7l[\u2605]\u00a7r\u00a7d\u00a7l \u0417\u0435\u043b\u044c\u0435 \u041c\u0435\u0434\u0438\u043a\u0430\u00a7r");
        var8 = new class_1293[5];
        var8[0] = new class_1293(class_1294.field_5918, 18000, 0);
        var8[1] = new class_1293(class_1294.field_5917, 3600, 0);
        var8[2] = new class_1293(class_1294.field_5905, 18000, 0);
        var8[3] = new class_1293(class_1294.field_5904, 18000, 2);
        var8[4] = new class_1293(class_1294.field_5910, 6000, 2);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a76\u00a7l[\u2605]\u00a7r\u00a7e\u00a7l \u0417\u0435\u043b\u044c\u0435 \u0430\u0433\u0435\u043d\u0442\u0430\u00a7r");
        var8 = new class_1293[4];
        var8[0] = new class_1293(class_1294.field_5914, 3600, 1);
        var8[1] = new class_1293(class_1294.field_5905, 18000, 0);
        var8[2] = new class_1293(class_1294.field_5924, 1200, 1);
        var8[3] = new class_1293(class_1294.field_5907, 1200, 0);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a72\u00a7l[\u2605]\u00a7r\u00a7a\u00a7l \u0417\u0435\u043b\u044c\u0435 \u041f\u043e\u0431\u0435\u0434\u0438\u0442\u0435\u043b\u044f\u00a7r");
        var8 = new class_1293[5];
        var8[0] = new class_1293(class_1294.field_5919, 200, 0);
        var8[1] = new class_1293(class_1294.field_5912, 3600, 0);
        var8[2] = new class_1293(class_1294.field_5903, 1800, 9);
        var8[3] = new class_1293(class_1294.field_5909, 3600, 2);
        var8[4] = new class_1293(class_1294.field_5920, 600, 4);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a7c\u00a7l[\u2605]\u00a7r\u00a76\u00a7l \u0417\u0435\u043b\u044c\u0435 \u041e\u0442\u0440\u044b\u0436\u043a\u0438\u00a7r");
        var8 = new class_1293[4];
        var8[0] = new class_1293(class_1294.field_5899, 1000, 1);
        var8[1] = new class_1293(class_1294.field_5909, 1800, 3);
        var8[2] = new class_1293(class_1294.field_5911, 1800, 2);
        var8[3] = new class_1293(class_1294.field_5920, 600, 4);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a72\u00a7l[\u2605]\u00a7r\u00a7a\u00a7l \u0421\u0435\u0440\u043d\u0430\u044f \u043a\u0438\u0441\u043b\u043e\u0442\u0430\u00a7r");
        var8 = new class_1293[2];
        var8[0] = new class_1293(class_1294.field_5919, 400, 0);
        var8[1] = new class_1293(class_1294.field_5912, 4800, 0);
        positions = CollectionsKt.listOf();
        var6 = (class_2561) class_2561.method_43470("\u00a76\u00a7l[\u2605]\u00a7r\u00a7e\u00a7l \u0412\u0441\u043f\u044b\u0448\u043a\u0430\u00a7r");
        var8 = new ItemStack((class_1935) Items.field_8436);
        var8.method_57379(class_9334.field_49631, class_2561.method_43470("\u00a77\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u0437\u0435\u043b\u044c\u0435"));
        return var8;
        ItemStack stack = new ItemStack((class_1935) Items.field_8436);
        stack.method_57379(class_9334.field_49651, new class_1844(Optional.empty(), Optional.empty(), positions, Optional.empty()));
        stack.method_57379(class_9334.field_49631);
        return stack;
    }

    static {
        INSTANCE = new ServiceComponent105();
    }

}
