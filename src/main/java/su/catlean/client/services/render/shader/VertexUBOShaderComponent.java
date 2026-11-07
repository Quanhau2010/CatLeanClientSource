package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.shaders.ShaderType;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.io.CloseableKt;
import net.minecraft.class_10789;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3298;
import net.minecraft.class_3300;
import net.minecraft.client.MinecraftClient;
import org.apache.commons.io.IOUtils;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.ShaderApplyEvent;
import su.catlean.client.services.client.StringServiceComponent2;

public class VertexUBOShaderComponent {

    public static final VertexUBOShaderComponent INSTANCE;
    private static final List itemList;
    private static boolean enabledFlag;
    private static final Snippet snippet;
    private static final RenderPipeline renderPipeline;
    private static final RenderPipeline renderPipeline2;
    private static final RenderPipeline renderPipeline3;
    private static final RenderPipeline renderPipeline4;
    private static final RenderPipeline renderPipeline5;
    private static final RenderPipeline renderPipeline6;
    private static final RenderPipeline renderPipeline7;
    private static final RenderPipeline renderPipeline8;
    private static final RenderPipeline renderPipeline9;
    private static final RenderPipeline renderPipeline10;
    private static final RenderPipeline renderPipeline11;
    private static final RenderPipeline renderPipeline12;
    private static final RenderPipeline renderPipeline13;
    private static final RenderPipeline renderPipeline14;
    private static final RenderPipeline renderPipeline15;
    private static final RenderPipeline renderPipeline16;
    private static final RenderPipeline renderPipeline17;
    private static final RenderPipeline renderPipeline18;
    private static final RenderPipeline renderPipeline19;
    private static final RenderPipeline renderPipeline20;
    private static final RenderPipeline renderPipeline21;
    private static final RenderPipeline renderPipeline22;
    private static final RenderPipeline renderPipeline23;
    private static final RenderPipeline renderPipeline24;
    private static final RenderPipeline renderPipeline25;
    private static final RenderPipeline renderPipeline26;
    private static String[] textValueArray;

    private VertexUBOShaderComponent() {
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public RenderPipeline getRenderPipeline() {
        return renderPipeline;
    }

    public RenderPipeline getRenderPipeline2() {
        return renderPipeline2;
    }

    public RenderPipeline getRenderPipeline3() {
        return renderPipeline3;
    }

    public RenderPipeline getRenderPipeline4() {
        return renderPipeline4;
    }

    public RenderPipeline getRenderPipeline5() {
        return renderPipeline5;
    }

    public RenderPipeline getRenderPipeline6() {
        return renderPipeline6;
    }

    public RenderPipeline getRenderPipeline7() {
        return renderPipeline7;
    }

    public RenderPipeline getRenderPipeline8() {
        return renderPipeline8;
    }

    public RenderPipeline getRenderPipeline9() {
        return renderPipeline9;
    }

    public RenderPipeline getRenderPipeline10() {
        return renderPipeline10;
    }

    public RenderPipeline getRenderPipeline11() {
        return renderPipeline11;
    }

    public RenderPipeline getRenderPipeline12() {
        return renderPipeline12;
    }

    public RenderPipeline getRenderPipeline13() {
        return renderPipeline13;
    }

    public RenderPipeline getRenderPipeline14() {
        return renderPipeline14;
    }

    public RenderPipeline getRenderPipeline15() {
        return renderPipeline15;
    }

    public RenderPipeline getRenderPipeline16() {
        return renderPipeline16;
    }

    public RenderPipeline getRenderPipeline17() {
        return renderPipeline17;
    }

    public RenderPipeline getRenderPipeline18() {
        return renderPipeline18;
    }

    public RenderPipeline getRenderPipeline19() {
        return renderPipeline19;
    }

    public RenderPipeline getRenderPipeline20() {
        return renderPipeline20;
    }

    public RenderPipeline getRenderPipeline21() {
        return renderPipeline21;
    }

    public RenderPipeline getRenderPipeline22() {
        return renderPipeline22;
    }

    public RenderPipeline getRenderPipeline23() {
        return renderPipeline23;
    }

    public RenderPipeline getRenderPipeline24() {
        return renderPipeline24;
    }

    public RenderPipeline getRenderPipeline25() {
        return renderPipeline25;
    }

    public RenderPipeline getRenderPipeline26() {
        return renderPipeline26;
    }

    private void onShaderApplyEvent(ShaderApplyEvent arg0) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            RenderPipeline renderPipeline = ((RenderPipeline) element);
            RenderSystem.getDevice().precompilePipeline(renderPipeline, this::resolveString);
        }
        enabledFlag = 1;
    }

    private RenderPipeline resolveRenderPipeline(RenderPipeline arg0) {
        itemList.add(arg0);
        return arg0;
    }

    private static String resolveString(class_2960 arg0, ShaderType arg1) {
        Closeable closeable = ((Closeable) ((class_3298) SharedKt.getMc().method_1478().method_14486(arg0).get()).method_14482());
        InputStream inputStream = ((InputStream) closeable);
        int index = 0;
        String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        CloseableKt.closeFinally(closeable);
        return text;
        int index2 = index;
        CloseableKt.closeFinally(closeable, index2);
    }

    static {
        INSTANCE = new VertexUBOShaderComponent();
        itemList = new ArrayList();
        snippet = RenderPipeline.builder(new Snippet[0]).withUniform("VertexUBO", class_10789.field_60031).buildSnippet();
        Snippet[] items = new Snippet[1];
        items[0] = snippet;
        renderPipeline = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/default")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/default/default.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline2 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/camouflage")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/camouflage/camouflage.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline3 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/doubleglow")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/doubleglow/doubleglow.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline4 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/mirror")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/mirror/mirror.fsh")).withSampler("Sampler0").withSampler("Sampler1").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline5 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/bloom")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/bloom/bloom.fsh")).withSampler("Sampler0").withSampler("Sampler1").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline6 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/multidefault")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/multidefault/multidefault.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/multidefault/multidefault.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline7 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/lines")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/lines/lines.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/lines/lines.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline8 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/kawase/downscale")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/kawase/downscale.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline9 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/post/kawase/upscale")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/post.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/post/kawase/upscale.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline10 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/rect/textured")).withVertexFormat(class_290.field_1592, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/textured_rect.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/textured_rect.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline11 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/rect/blurred")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/blurred_rect.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/blurred_rect.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline12 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/rect/blurred")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/blurred_rect.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/blurred_rect.fsh")).withSampler("Sampler0").withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(true).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline13 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/rect/rect")).withVertexFormat(class_290.field_1576, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/rect.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/rect/rect.fsh")).withUniform("UBO", class_10789.field_60031).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline14 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline15 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline16 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture_cull")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(true).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline17 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture_cull_depth")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.LESS_DEPTH_TEST).withDepthWrite(true).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline18 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture_alt_blend")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline19 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture_alt_blend_depthtest")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline20 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/colored_texture_alt_blend_2")).withVertexFormat(class_290.field_1575, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/colored_texture.fsh")).withSampler("Sampler0").withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(new BlendFunction(SourceFactor.ZERO, DestFactor.ONE_MINUS_SRC_COLOR, SourceFactor.ONE, DestFactor.ZERO)).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline21 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/pos_color_alt_blend_depth")).withVertexFormat(class_290.field_1576, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.fsh")).withDepthTestFunction(DepthTestFunction.LESS_DEPTH_TEST).withDepthWrite(true).withBlend(BlendFunction.LIGHTNING).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline22 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/pos_color")).withVertexFormat(class_290.field_1576, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.fsh")).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline23 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/pos_color_depth")).withVertexFormat(class_290.field_1576, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.fsh")).withDepthTestFunction(DepthTestFunction.LESS_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline24 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/pos_color_no_blend")).withVertexFormat(class_290.field_1576, class_5596.field_27379).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.fsh")).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withoutBlend().withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline25 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/pos_color_lines")).withVertexFormat(class_290.field_1576, class_5596.field_29344).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.fsh")).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).withCull(false).build());
        items = new Snippet[1];
        items[0] = snippet;
        renderPipeline26 = INSTANCE.resolveRenderPipeline(RenderPipeline.builder(items).withLocation(StringServiceComponent2.resolveMinecraftObject("catlean", "program/default/pos_color_lines_alt")).withVertexFormat(class_290.field_1576, class_5596.field_29344).withVertexShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.vsh")).withFragmentShader(StringServiceComponent2.resolveMinecraftObject("catlean", "shaders/core/default/pos_color.fsh")).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).withCull(false).build());
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
