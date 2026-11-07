package su.catlean.client.services.client;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class ServiceComponent45 implements Contract9 {

    public static final ServiceComponent45 INSTANCE;
    private static final ConcurrentHashMap concurrentHashMap;

    private ServiceComponent45() {
    }

    public boolean checkCondition(BlockPos bp) {
        return concurrentHashMap.containsKey(bp);
    }

    public void executeAction(BlockPos pos) {
    }

    public void executeAction(BlockPos pos) {
        concurrentHashMap.remove(pos);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = concurrentHashMap.entrySet().iterator();
        long var9 = (Number) (Entry) iterator.next().getValue().longValue();
        if (var7 != null) {
            iterator.remove();
        }
    }

    static {
        INSTANCE = new ServiceComponent45();
        concurrentHashMap = new ConcurrentHashMap();
    }

}
