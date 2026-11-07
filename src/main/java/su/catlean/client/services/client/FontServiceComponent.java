package su.catlean.client.services.client;

import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1060;
import net.minecraft.class_2960;
import net.minecraft.client.MinecraftClient;
import su.catlean.SharedKt;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class FontServiceComponent {

    private final char fieldValue;
    private final char fieldValue2;
    private final Font font;
    private final class_2960 minecraftRef;
    private final int countValue;
    private final Char2ObjectArrayMap char2ObjectArrayMap;
    private int countValue2;
    private int countValue3;
    private boolean enabledFlag;

    public FontServiceComponent(char fromIncl, char toExcl, Font font, class_2960 bindToTexture, int pixelPadding) {
        this.fieldValue = fromIncl;
        this.fieldValue2 = toExcl;
        this.font = font;
        this.minecraftRef = bindToTexture;
        this.countValue = pixelPadding;
        this.char2ObjectArrayMap = new Char2ObjectArrayMap();
    }

    public Font getFont() {
        return this.font;
    }

    public class_2960 getMinecraftObject() {
        return this.minecraftRef;
    }

    public int getNumericValue() {
        return this.countValue2;
    }

    public void updateValue(int value) {
        this.countValue2 = value;
    }

    public int getNumericValue2() {
        return this.countValue3;
    }

    public void updateValue2(int value) {
        this.countValue3 = value;
    }

    public OwnerServiceComponent resolveOwnerServiceComponent(char c) {
        if (!(this.enabledFlag)) {
            this.updateValue2();
        }
        return (OwnerServiceComponent) this.char2ObjectArrayMap.get(c);
    }

    public void updateValue() {
        SharedKt.getMc().method_1531().method_4615(this.minecraftRef);
        this.char2ObjectArrayMap.clear();
        this.countValue2 = -1;
        this.countValue3 = -1;
        this.enabledFlag = 0;
    }

    public boolean checkCondition(char c) {
        char var4 = this.fieldValue;
        if (c < this.fieldValue2) {
        } else {
        }
        return var4 <= c;
    }

    private Font resolveFont(char arg0) {
        if (this.font.canDisplay(arg0)) {
            return this.font;
        }
        return this.font;
    }

    private void updateValue2() {
        if (this.enabledFlag) {
            return;
        }
        char var10 = ((this.fieldValue2 - this.fieldValue) - 1);
        double var11 = (Math.ceil(Math.sqrt()) * 1.5D);
        this.char2ObjectArrayMap.clear();
        int var12 = 0;
        int var13 = 0;
        int var14 = 0;
        int var15 = 0;
        int var16 = 0;
        int var17 = 0;
        int var18 = 0;
        List positions = new ArrayList();
        AffineTransform var20 = new AffineTransform();
        FontRenderContext var21 = new FontRenderContext(1, 0);
        if (var12 <= var10) {
            char var22 = (this.fieldValue + var12);
            Font var23 = this.resolveFont();
            Rectangle2D var24 = var23.getStringBounds(String.valueOf());
            double var25 = Math.ceil(var24.getWidth());
            double var26 = Math.ceil(var24.getHeight());
            var14 = Math.max((var16 + var25));
            var15 = Math.max((var17 + var26));
            if (var13 >= var11) {
                var16 = 0;
                var17 = (var17 + (var18 + this.countValue));
                var13 = 0;
                var18 = 0;
            }
            var18 = Math.max();
            positions.add(new OwnerServiceComponent(this));
            var16 = (var16 + (var25 + this.countValue));
        }
        var22 = new BufferedImage(Math.max((var14 + this.countValue), 1.0D), Math.max((var15 + this.countValue), 1.0D), 2);
        this.countValue2 = var22.getWidth();
        this.countValue3 = var22.getHeight();
        var23 = var22.createGraphics();
        var23.setColor(new Color(255, 255, 255, 0));
        var23.fillRect(0, 0, this.countValue2, this.countValue3);
        var23.setColor(Color.WHITE);
        var23.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        var23.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        var23.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        var24 = positions.iterator();
        while (var24.hasNext()) {
            var25 = (OwnerServiceComponent) var24.next();
            var23.setFont(this.resolveFont(var25.process()));
            var23.drawString(String.valueOf(var25.process()), var25.getNumericValue(), (var25.getNumericValue2() + var23.getFontMetrics().getAscent()));
            this.char2ObjectArrayMap.put(var25.process());
        }
        PolygonShaderComponent.INSTANCE.executeAction(this.minecraftRef);
        this.enabledFlag = 1;
    }

}
