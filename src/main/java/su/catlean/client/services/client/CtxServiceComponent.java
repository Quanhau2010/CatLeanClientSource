package su.catlean.client.services.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class CtxServiceComponent extends ChannelInboundHandlerAdapter {

    public CtxServiceComponent() {
        super();
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        this.channelRead(ctx, msg);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

}
