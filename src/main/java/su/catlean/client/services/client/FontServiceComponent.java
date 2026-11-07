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
        return ((OwnerServiceComponent) this.char2ObjectArrayMap.get(c));
    }

    public void updateValue() {
        SharedKt.getMc().method_1531().method_4615(this.minecraftRef);
        this.char2ObjectArrayMap.clear();
        this.countValue2 = -1;
        this.countValue3 = -1;
        this.enabledFlag = false;
    }

    public boolean checkCondition(char c) {
        char ch = this.fieldValue;
        if (c < this.fieldValue2) {
        } else {
            return ch <= c;
        }
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
        char ch = ((this.fieldValue2 - this.fieldValue) - 1);
        double offset = (Math.ceil(Math.sqrt(ch)) * 1.5D);
        this.char2ObjectArrayMap.clear();
        int index = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int index5 = 0;
        int index6 = 0;
        int index7 = 0;
        List list = new ArrayList();
        AffineTransform affineTransform = new AffineTransform();
        FontRenderContext fontRenderContext = new FontRenderContext(affineTransform, true, false);
        if (index <= ch) {
            char ch2 = (this.fieldValue + index);
            Font font = this.resolveFont(ch2);
            Rectangle2D rectangle2D = font.getStringBounds(String.valueOf(ch2), fontRenderContext);
            double offset2 = Math.ceil(rectangle2D.getWidth());
            double offset3 = Math.ceil(rectangle2D.getHeight());
            index3 = Math.max(index3, (index5 + offset2));
            index4 = Math.max(index4, (index6 + offset3));
            if (index2 >= offset) {
                index5 = 0;
                index6 = (index6 + (index7 + this.countValue));
                index2 = 0;
                index7 = 0;
            }
            index7 = Math.max(index7, offset3);
            list.add(new OwnerServiceComponent(index5, index6, offset2, offset3, ch2, this));
            index5 = (index5 + (offset2 + this.countValue));
        }
        ch2 = new BufferedImage(Math.max((index3 + this.countValue), 1.0D), Math.max((index4 + this.countValue), 1.0D), 2);
        this.countValue2 = ch2.getWidth();
        this.countValue3 = ch2.getHeight();
        font = ch2.createGraphics();
        font.setColor(new Color(255, 255, 255, 0));
        font.fillRect(0, 0, this.countValue2, this.countValue3);
        font.setColor(Color.WHITE);
        font.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        font.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        font.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        rectangle2D = list.iterator();
        while (rectangle2D.hasNext()) {
            offset2 = ((OwnerServiceComponent) rectangle2D.next());
            font.setFont(this.resolveFont(offset2.process()));
            font.drawString(String.valueOf(offset2.process()), offset2.getNumericValue(), (offset2.getNumericValue2() + font.getFontMetrics().getAscent()));
            this.char2ObjectArrayMap.put(offset2.process(), offset2);
        }
        PolygonShaderComponent.INSTANCE.executeAction(this.minecraftRef, ch2);
        this.enabledFlag = true;
    }

}
