package su.catlean.client.services.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.flow.FlowControlHandler;
import io.netty.handler.proxy.ProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import net.minecraft.class_9130.class_9131;
import net.minecraft.class_9130.class_9133;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.IdRecord12;

public class TimeoutProxyCheckerServiceComponent extends ChannelInitializer {

    private final IdRecord12 idRecord12;

    private TimeoutProxyCheckerServiceComponent(IdRecord12 arg0) {
        this.idRecord12 = arg0;
        super();
    }

    protected void executeAction(SocketChannel ch) {
        ChannelHandler[] var5 = new ChannelHandler[1];
        var5[0] = new FlowControlHandler();
        var5 = new ChannelHandler[1];
        if (this.idRecord12.isActive()) {
        } else {
        }
        0[(ProxyHandler) new Socks4ProxyHandler((SocketAddress) new InetSocketAddress(this.idRecord12.getString2(), this.idRecord12.getNumericValue()), this.idRecord12.getString3())] = (ProxyHandler) new Socks5ProxyHandler((SocketAddress) new InetSocketAddress(this.idRecord12.getString2(), this.idRecord12.getNumericValue()), this.idRecord12.getString3(), this.idRecord12.getString4());
        var5 = new ChannelHandler[1];
        var5[0] = new CtxServiceComponent();
        var5.addLast().addLast();
    }

    public void initChannel(Channel p0) {
        this.executeAction((SocketChannel) p0);
    }

}
