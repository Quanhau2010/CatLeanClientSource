package su.catlean.gofra;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.function.Consumer;

public class Branch {

    private final Class eventTarget;
    private final byte priority;
    private Consumer consumer;
    private Method privateLookupInMethod;

    public Branch(Class klass, Object obj, Method method) {
        this.eventTarget = method.getParameters()[0].getType();
        this.priority = (Flow) method.getAnnotation(Flow.class).priority();
        Class[] var4 = new Class[2];
        var4[0] = Class.class;
        var4[1] = Lookup.class;
        this.privateLookupInMethod = MethodHandles.class.getDeclaredMethod("privateLookupIn");
        Object[] var6 = new Object[2];
        var6[0] = klass;
        var6[1] = MethodHandles.lookup();
        var4 = (Lookup) this.privateLookupInMethod.invoke(null);
        MethodType var5 = MethodType.methodType(Void.TYPE, method.getParameters()[0].getType());
        var6 = var4.findVirtual(klass, method.getName());
        MethodType var7 = MethodType.methodType(Consumer.class, klass);
        this.consumer = LambdaMetafactory.metafactory("accept", MethodType.methodType(Void.TYPE, Object.class)).getTarget().invoke(obj);
    }

    public Class getEventTarget() {
        return this.eventTarget;
    }

    public byte getPriority() {
        return this.priority;
    }

    public void call(Object event) {
        this.consumer.accept(event);
    }

}
