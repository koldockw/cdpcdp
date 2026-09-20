package com.sdp.theme.builder;

public final class Theme {

    private final String name;
    private final String primaryColor;
    private final String secondaryColor;
    private final String accentColor;
    private final String backgroundColor;
    private final String textColor;
    private final String fontFamily;
    private final int baseFontSizePx;
    private final int borderRadiusPx;
    private final int spacingUnitPx;
    private final boolean darkMode;

    Theme(ThemeBuilder builder) {
        this.name = builder.name;
        this.primaryColor = builder.primaryColor;
        this.secondaryColor = builder.secondaryColor;
        this.accentColor = builder.accentColor;
        this.backgroundColor = builder.backgroundColor;
        this.textColor = builder.textColor;
        this.fontFamily = builder.fontFamily;
        this.baseFontSizePx = builder.baseFontSizePx;
        this.borderRadiusPx = builder.borderRadiusPx;
        this.spacingUnitPx = builder.spacingUnitPx;
        this.darkMode = builder.darkMode;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getBaseFontSizePx() {
        return baseFontSizePx;
    }

    public int getBorderRadiusPx() {
        return borderRadiusPx;
    }

    public int getSpacingUnitPx() {
        return spacingUnitPx;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public String toCssVariablesBlock() {
        StringBuilder css = new StringBuilder();
        css.append(":root {\n");
        css.append("  --color-primary: ").append(primaryColor).append(";\n");
        css.append("  --color-secondary: ").append(secondaryColor).append(";\n");
        css.append("  --color-accent: ").append(accentColor).append(";\n");
        css.append("  --color-background: ").append(backgroundColor).append(";\n");
        css.append("  --color-text: ").append(textColor).append(";\n");
        css.append("  --font-family: '").append(fontFamily).append("';\n");
        css.append("  --font-size-base: ").append(baseFontSizePx).append("px;\n");
        css.append("  --border-radius: ").append(borderRadiusPx).append("px;\n");
        css.append("  --spacing-unit: ").append(spacingUnitPx).append("px;\n");
        css.append("  --color-scheme: ").append(darkMode ? "dark" : "light").append(";\n");
        css.append("}\n");
        return css.toString();
    }

    public String toJson() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"darkMode\": " + darkMode + ",\n" +
                "  \"colors\": {\n" +
                "    \"primary\": \"" + primaryColor + "\",\n" +
                "    \"secondary\": \"" + secondaryColor + "\",\n" +
                "    \"accent\": \"" + accentColor + "\",\n" +
                "    \"background\": \"" + backgroundColor + "\",\n" +
                "    \"text\": \"" + textColor + "\"\n" +
                "  },\n" +
                "  \"typography\": {\n" +
                "    \"fontFamily\": \"" + fontFamily + "\",\n" +
                "    \"baseFontSizePx\": " + baseFontSizePx + "\n" +
                "  },\n" +
                "  \"spacing\": {\n" +
                "    \"borderRadiusPx\": " + borderRadiusPx + ",\n" +
                "    \"spacingUnitPx\": " + spacingUnitPx + "\n" +
                "  }\n" +
                "}";
    }

    public String toSummary() {
        return String.format(
                "Theme[%s] mode=%s font=%s@%dpx radius=%dpx spacing=%dpx",
                name, darkMode ? "dark" : "light", fontFamily,
                baseFontSizePx, borderRadiusPx, spacingUnitPx);
    }

    @Override
    public String toString() {
        return toSummary();
    }
}
