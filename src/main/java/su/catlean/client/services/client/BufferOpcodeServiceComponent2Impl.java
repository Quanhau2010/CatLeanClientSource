package su.catlean.client.services.client;

import java.net.SocketAddress;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.EvtRecord;
import su.catlean.client.types.OptionMode2;

public class BufferOpcodeServiceComponent2Impl extends OpcodeServiceComponent2 {

    private final Selector selector;
    private final SocketChannel socketChannel;
    private OptionMode2 optionMode2;
    private Integer integer;
    private ByteBuffer byteBuffer;
    private final ByteBuffer byteBuffer2;

    public BufferOpcodeServiceComponent2Impl(String name) {
        super();
        this.selector = Selector.open();
        this.socketChannel = SocketChannel.open((SocketAddress) UnixDomainSocketAddress.of(name));
        this.byteBuffer2 = ByteBuffer.allocate(4);
        this.socketChannel.configureBlocking(0);
        this.socketChannel.register(this.selector, 1);
        ThreadsKt.thread$default(1, 0, null, "Discord IPC - Socket thread", 0, this::resolveUnit, -6123452903903461354L);
    }

    private void updateValue() {
        Object var4 = this;
        BufferOpcodeServiceComponent2Impl var5 = (BufferOpcodeServiceComponent2Impl) var4;
        int var6 = 0;
        if (var5.selector.select() > 0) {
            var5.selector.selectedKeys().removeIf(this::checkCondition);
            if (!(var3)) {
            }
            var5 = Result.constructor-impl(Unit.INSTANCE);
        }
        var5 = Result.constructor-impl(ResultKt.createFailure());
    }

    protected void executeAction(ByteBuffer buffer) {
        Object var4 = this;
        BufferOpcodeServiceComponent2Impl var5 = (BufferOpcodeServiceComponent2Impl) var4;
        int var6 = 0;
        var5 = Result.constructor-impl(Integer.valueOf(var5.socketChannel.write(buffer)));
        var5 = Result.constructor-impl(ResultKt.createFailure());
    }

    public void executeAction() {
        Object var1 = this;
        BufferOpcodeServiceComponent2Impl var2 = (BufferOpcodeServiceComponent2Impl) var1;
        int var3 = 0;
        var2.socketChannel.close();
        var2.selector.close();
        var2 = Result.constructor-impl(Unit.INSTANCE);
        var2 = Result.constructor-impl(ResultKt.createFailure());
    }

    private OpcodeServiceComponent resolveOpcodeServiceComponent(ReadableByteChannel arg0) {
        if (this.optionMode2 == null) {
            if (!(this.checkCondition(arg0))) {
                return null;
            }
            this.optionMode2 = (OptionMode2) CollectionsKt.getOrNull(OptionMode2.getEnumEntries(), ServiceComponent52.computeValue(this.byteBuffer2.getInt(0)));
            this.byteBuffer2.clear();
        }
        if (this.integer == null) {
            if (!(this.checkCondition(arg0))) {
                return null;
            }
            this.integer = Integer.valueOf(ServiceComponent52.computeValue(this.byteBuffer2.getInt(0)));
            this.byteBuffer = ByteBuffer.allocate(this.integer);
            this.byteBuffer2.clear();
        }
        arg0.read(this.byteBuffer);
        if (this.byteBuffer.hasRemaining()) {
            return null;
        }
        if (this.byteBuffer != null) {
            this.byteBuffer.flip();
        } else {
        }
        Json var14 = ServiceComponent80.getJson();
        String var15 = Charsets.UTF_8.decode(this.byteBuffer).toString();
        int var16 = 0;
        var14.getSerializersModule();
        EvtRecord var10 = (EvtRecord) var14.decodeFromString((DeserializationStrategy) EvtRecord.serviceComponent25.getKSerializer());
        OptionMode2 var11 = this.optionMode2;
        OpcodeServiceComponent var13 = new OpcodeServiceComponent();
        this.optionMode2 = null;
        this.integer = null;
        this.byteBuffer = null;
        return var13;
    }

    private boolean checkCondition(ReadableByteChannel arg0) {
        arg0.read(this.byteBuffer2);
        if (this.byteBuffer2.hasRemaining()) {
            return false;
        }
        this.byteBuffer2.flip();
        return true;
    }

    private static Unit resolveUnit(BufferOpcodeServiceComponent2Impl arg0) {
        arg0.updateValue();
        return Unit.INSTANCE;
    }

    private static boolean checkCondition(BufferOpcodeServiceComponent2Impl arg0, SelectionKey arg1) {
        if (arg1.isReadable()) {
            OpcodeServiceComponent var9 = arg0.resolveOpcodeServiceComponent((ReadableByteChannel) arg0.socketChannel);
            if (var9 != null) {
                Object var10 = var9;
                int var11 = 0;
                AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit();
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

}
