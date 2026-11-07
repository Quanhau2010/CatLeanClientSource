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
        this.socketChannel = SocketChannel.open(((SocketAddress) UnixDomainSocketAddress.of(name)));
        this.byteBuffer2 = ByteBuffer.allocate(4);
        this.socketChannel.configureBlocking(false);
        this.socketChannel.register(this.selector, 1);
        ThreadsKt.thread$default(true, false, null, "Discord IPC - Socket thread", 0, this::resolveUnit);
    }

    private void updateValue() {
        BufferOpcodeServiceComponent2Impl bufferOpcodeServiceComponent2Impl = ((BufferOpcodeServiceComponent2Impl) this);
        int index = 0;
        if (bufferOpcodeServiceComponent2Impl.selector.select() > 0) {
            bufferOpcodeServiceComponent2Impl.selector.selectedKeys().removeIf(this::checkCondition);
            if (!(__UNDEF_KEY__)) {
                bufferOpcodeServiceComponent2Impl = Result.constructor_impl(Unit.INSTANCE);
            }
        }
        bufferOpcodeServiceComponent2Impl = Result.constructor_impl(ResultKt.createFailure(index));
    }

    protected void executeAction(ByteBuffer buffer) {
        BufferOpcodeServiceComponent2Impl bufferOpcodeServiceComponent2Impl = ((BufferOpcodeServiceComponent2Impl) this);
        int index = 0;
        bufferOpcodeServiceComponent2Impl = Result.constructor_impl(Integer.valueOf(bufferOpcodeServiceComponent2Impl.socketChannel.write(buffer)));
        bufferOpcodeServiceComponent2Impl = Result.constructor_impl(ResultKt.createFailure(index));
    }

    public void executeAction() {
        BufferOpcodeServiceComponent2Impl bufferOpcodeServiceComponent2Impl = ((BufferOpcodeServiceComponent2Impl) this);
        int index = 0;
        bufferOpcodeServiceComponent2Impl.socketChannel.close();
        bufferOpcodeServiceComponent2Impl.selector.close();
        bufferOpcodeServiceComponent2Impl = Result.constructor_impl(Unit.INSTANCE);
        bufferOpcodeServiceComponent2Impl = Result.constructor_impl(ResultKt.createFailure(index));
    }

    private OpcodeServiceComponent resolveOpcodeServiceComponent(ReadableByteChannel arg0) {
        if (this.optionMode2 == null) {
            if (!(this.checkCondition(arg0))) {
                return null;
            }
            this.optionMode2 = ((OptionMode2) CollectionsKt.getOrNull(OptionMode2.getEnumEntries(), ServiceComponent52.computeValue(this.byteBuffer2.getInt(0))));
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
        Json json = ServiceComponent80.getJson();
        String text = Charsets.UTF_8.decode(this.byteBuffer).toString();
        json.getSerializersModule();
        EvtRecord evtRecord = ((EvtRecord) json.decodeFromString(((DeserializationStrategy) EvtRecord.serviceComponent25.getKSerializer()), text));
        OptionMode2 optionMode2 = this.optionMode2;
        OpcodeServiceComponent opcodeServiceComponent = new OpcodeServiceComponent(optionMode2, evtRecord);
        this.optionMode2 = null;
        this.integer = null;
        this.byteBuffer = null;
        return opcodeServiceComponent;
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
            OpcodeServiceComponent opcodeServiceComponent = arg0.resolveOpcodeServiceComponent(((ReadableByteChannel) arg0.socketChannel));
            if (opcodeServiceComponent != null) {
                AppIdXDGRUNTIMEDIRServiceComponentImpl.INSTANCE.resolveUnit(opcodeServiceComponent);
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

}
