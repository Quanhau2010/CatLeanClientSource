package su.catlean.client.services.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.proxy.ProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_2598;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.AddHandlersEvent;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.services.client.config.models.IdRecord12;
import su.catlean.client.services.client.config.models.ProxiesRecord;
import su.catlean.client.ui.clickgui.CatleanPanelScreenGuiElement;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class ProxyServiceComponent {

    public static final ProxyServiceComponent INSTANCE;
    private static IdRecord12 idRecord12;
    private static ServiceComponent38 serviceComponent38;
    private static int[] countValueArray;

    private ProxyServiceComponent() {
    }

    public List resolveList() {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent3().resolveProxiesRecord().getList();
    }

    public IdRecord12 getIdRecord12() {
        return idRecord12;
    }

    public void updateValue(IdRecord12 value) {
        idRecord12 = value;
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.updateValue();
        serviceComponent38.updateValue();
    }

    private void onAddHandlersEvent(AddHandlersEvent arg0) {
        if (idRecord12 != null) {
            IdRecord12 var5 = idRecord12;
            int var6 = 0;
            IdRecord12 var7 = idRecord12;
            int var8 = 0;
            if (arg0.getSide() == class_2598.field_11942 && !(arg0.getLocal())) {
                if ((ChannelPipeline) arg0.getPipeline().get() != null) {
                    ChannelHandler[] var9 = new ChannelHandler[1];
                    if (var7.isActive()) {
                    } else {
                    }
                    0[(ProxyHandler) new Socks4ProxyHandler((SocketAddress) new InetSocketAddress(var7.getString2(), var7.getNumericValue()), var7.getString3())] = (ProxyHandler) new Socks5ProxyHandler((SocketAddress) new InetSocketAddress(var7.getString2(), var7.getNumericValue()), var7.getString3(), var7.getString4());
                    var9.addFirst();
                } else {
                }
            }
        } else {
        }
    }

    public boolean checkCondition(IdRecord12 proxy) {
        return this.resolveList().remove(proxy);
    }

    public boolean checkCondition2(IdRecord12 proxy) {
        return this.resolveList().add(proxy);
    }

    public void updateValue() {
        Iterable var7 = (Iterable) this.resolveList();
        int var8 = 0;
        int var9 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var11 = iterator.next();
            int var12 = var9;
            if (var12 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            IdRecord12 var13 = (IdRecord12) var11;
            int var14 = var12;
            int var15 = 0;
            INSTANCE.executeAction();
        }
    }

    private void executeAction(IdRecord12 arg0, int arg1) {
        long var5 = System.currentTimeMillis();
        arg0.updateValue2(-2);
        new Thread(this::executeAction).start();
    }

    private static void executeAction(int arg0, IdRecord12 arg1, long arg2) {
        Thread.sleep((timestampValue * arg0));
        NioEventLoopGroup var7 = new NioEventLoopGroup();
        Bootstrap var8 = new Bootstrap();
        ChannelFuture var9 = var8.connect("crystalpvp.cc", 25565).sync();
        var9.await();
        if (!(var6)) {
            if (var9.isSuccess()) {
                arg1.updateValue2((SharedKt.getNumericValue() - arg2));
            }
            if (var6) {
            }
            arg1.updateValue2(-1);
        }
        var7.shutdownGracefully();
        arg1.updateValue2(-1);
    }

    static {
        INSTANCE = new ProxyServiceComponent();
        serviceComponent38 = new ServiceComponent38();
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
