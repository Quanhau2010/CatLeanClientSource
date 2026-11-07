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
            if (arg0.getSide() == class_2598.field_11942 && !(arg0.getLocal())) {
                if (((ChannelPipeline) arg0.getPipeline().get()) != null) {
                    ChannelHandler[] items = new ChannelHandler[1];
                    if (idRecord12.isActive()) {
                    } else {
                    }
                    0[((ProxyHandler) new Socks4ProxyHandler(((SocketAddress) new InetSocketAddress(idRecord12.getString2(), idRecord12.getNumericValue())), idRecord12.getString3()))] = ((ProxyHandler) new Socks5ProxyHandler(((SocketAddress) new InetSocketAddress(idRecord12.getString2(), idRecord12.getNumericValue())), idRecord12.getString3(), idRecord12.getString4()));
                    items.addFirst(items);
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
        Iterable iterable = ((Iterable) this.resolveList());
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            IdRecord12 idRecord12 = ((IdRecord12) element);
            INSTANCE.executeAction(idRecord12, index);
        }
    }

    private void executeAction(IdRecord12 arg0, int arg1) {
        long time = System.currentTimeMillis();
        arg0.updateValue2(-2);
        new Thread(this::executeAction).start();
    }

    private static void executeAction(int arg0, IdRecord12 arg1, long arg2) {
        Thread.sleep((timestampValue * arg0));
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture channelFuture = bootstrap.connect("crystalpvp.cc", 25565).sync();
        channelFuture.await();
        if (!(__UNDEF_KEY__)) {
            if (channelFuture.isSuccess()) {
                arg1.updateValue2((SharedKt.getNumericValue() - arg2));
                if (__UNDEF_KEY__) {
                    arg1.updateValue2(-1);
                }
            }
        }
        nioEventLoopGroup.shutdownGracefully();
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
