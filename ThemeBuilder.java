package com.sdp.theme.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ThemeBuilder {

    private static final int DEFAULT_BASE_FONT_SIZE_PX = 16;
    private static final int DEFAULT_BORDER_RADIUS_PX = 4;
    private static final int DEFAULT_SPACING_UNIT_PX = 8;

    private static final int MIN_FONT_SIZE_PX = 8;
    private static final int MAX_FONT_SIZE_PX = 72;

    private static final Pattern HEX_COLOR_PATTERN =
            Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");

    String name;
    String primaryColor;
    String secondaryColor;
    String accentColor;
    String backgroundColor;
    String textColor;
    String fontFamily;
    int baseFontSizePx = DEFAULT_BASE_FONT_SIZE_PX;
    int borderRadiusPx = DEFAULT_BORDER_RADIUS_PX;
    int spacingUnitPx = DEFAULT_SPACING_UNIT_PX;
    boolean darkMode = false;

    public ThemeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ThemeBuilder primaryColor(String hexColor) {
        this.primaryColor = validatedHexColor("primaryColor", hexColor);
        return this;
    }

    public ThemeBuilder secondaryColor(String hexColor) {
        this.secondaryColor = validatedHexColor("secondaryColor", hexColor);
        return this;
    }

    public ThemeBuilder accentColor(String hexColor) {
        this.accentColor = validatedHexColor("accentColor", hexColor);
        return this;
    }

    public ThemeBuilder backgroundColor(String hexColor) {
        this.backgroundColor = validatedHexColor("backgroundColor", hexColor);
        return this;
    }

    public ThemeBuilder textColor(String hexColor) {
        this.textColor = validatedHexColor("textColor", hexColor);
        return this;
    }

    public ThemeBuilder fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public ThemeBuilder baseFontSizePx(int sizePx) {
        if (sizePx < MIN_FONT_SIZE_PX || sizePx > MAX_FONT_SIZE_PX) {
            throw new IllegalArgumentException(
                    "baseFontSizePx must be between " + MIN_FONT_SIZE_PX +
                            " and " + MAX_FONT_SIZE_PX + " px, got: " + sizePx);
        }
        this.baseFontSizePx = sizePx;
        return this;
    }

    public ThemeBuilder borderRadiusPx(int radiusPx) {
        if (radiusPx < 0) {
            throw new IllegalArgumentException("borderRadiusPx cannot be negative: " + radiusPx);
        }
        this.borderRadiusPx = radiusPx;
        return this;
    }

    public ThemeBuilder spacingUnitPx(int spacingPx) {
        if (spacingPx <= 0) {
            throw new IllegalArgumentException("spacingUnitPx must be positive: " + spacingPx);
        }
        this.spacingUnitPx = spacingPx;
        return this;
    }

    public ThemeBuilder darkMode(boolean darkMode) {
        this.darkMode = darkMode;
        return this;
    }

    private String validatedHexColor(String fieldName, String hexColor) {
        if (hexColor == null || !HEX_COLOR_PATTERN.matcher(hexColor).matches()) {
            throw new IllegalArgumentException(
                    fieldName + " must be a hex color like '#RRGGBB', got: " + hexColor);
        }
        return hexColor;
    }

    private void applyColorFallbacks() {
        if (secondaryColor == null) {
            secondaryColor = primaryColor;
        }
        if (accentColor == null) {
            accentColor = primaryColor;
        }
    }

    private void validateRequiredFields() {
        List<String> missing = new ArrayList<>();
        if (isBlank(name)) missing.add("name");
        if (primaryColor == null) missing.add("primaryColor");
        if (backgroundColor == null) missing.add("backgroundColor");
        if (textColor == null) missing.add("textColor");
        if (isBlank(fontFamily)) missing.add("fontFamily");

        if (!missing.isEmpty()) {
            throw new IllegalStateException(
                    "Cannot build Theme, missing required field(s): " + String.join(", ", missing));
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public Theme build() {
        validateRequiredFields();
        applyColorFallbacks();
        return new Theme(this);
    }
}
