package su.catlean.api.setting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import net.minecraft.block.Block;
import net.minecraft.class_7923;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.ServiceComponent79;

public class DefaultValueVisibleSettingPropertyImpl3 extends VisibleSettingProperty {

    private static boolean enabledFlag;

    public DefaultValueVisibleSettingPropertyImpl3(String id, BlocksServiceComponent defaultValue, SettingGroup group, Function0 visible) {
        super(id, defaultValue, null, group, visible);
    }

    public DefaultValueVisibleSettingPropertyImpl3(String arg0, BlocksServiceComponent arg1, SettingGroup arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        if ((arg4 & 4)) {
        }
        if ((arg4 & 8)) {
            arg3 = this::isActive;
        }
        this(arg0, arg1, arg2, arg3);
    }

    public void setValue(String setting) {
        long var4 = (0L ^ 45093887485344L);
        Json var7 = VisibleSettingProperty.serviceComponent79.getJson();
        Object var8 = setting;
        int var9 = 0;
        var7.getSerializersModule();
        var7 = (Iterable) var7.decodeFromString((DeserializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE));
        Object var28 = this;
        var8 = 0;
        var9 = var7;
        Collection var10 = (Collection) new ArrayList();
        int var11 = 0;
        Object var12 = var9;
        int var13 = 0;
        Iterator iterator = var12.iterator();
        if (iterator.hasNext()) {
            Object var15 = iterator.next();
            Object var16 = var15;
            int var17 = 0;
            String var18 = (String) var16;
            int var19 = 0;
            Iterable var20 = (Iterable) class_7923.field_41175;
            int var21 = 0;
            if (var6 != null) {
                Iterator iterator2 = var20.iterator();
                if (iterator2.hasNext()) {
                    Object var23 = iterator2.next();
                    Block var24 = (Block) var23;
                    int var25 = 0;
                } else {
                }
                if ((Block) null != null) {
                    Block var26 = (Block) null;
                    int var27 = 0;
                    var10.add();
                } else {
                }
            }
            if (0L >= 0L) {
            }
        }
        List positions = CollectionsKt.toMutableList((Collection) var10);
        var28.updateValue(new BlocksServiceComponent(positions));
    }

    public String toString() {
        Json var4 = VisibleSettingProperty.serviceComponent79.getJson();
        Iterable var5 = (Iterable) (BlocksServiceComponent) this.getObject2().getList();
        int var6 = 0;
        Object var7 = var5;
        Collection var8 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var9 = 0;
        Iterator iterator = var7.iterator();
        if (iterator.hasNext()) {
            Object var11 = iterator.next();
            Block var12 = (Block) var11;
            if (var3 != null) {
                Object var14 = var8;
                int var13 = 0;
                var14.add(var12.method_63499());
            }
        }
        var5 = var8;
        var6 = 0;
        var4.getSerializersModule();
        return var4.encodeToString((SerializationStrategy) new ArrayListSerializer(StringSerializer.INSTANCE));
    }

    private static boolean isActive() {
        return true;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive2() {
        return enabledFlag;
    }

    public static boolean isActive3() {
        return true;
        return false;
    }

}
