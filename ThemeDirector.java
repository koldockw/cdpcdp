package com.sdp.theme.builder;

public class ThemeDirector {

    public Theme darkCorporateTheme(ThemeBuilder builder) {
        return builder
                .name("Dark Corporate")
                .primaryColor("#1F6FEB")
                .secondaryColor("#30363D")
                .accentColor("#58A6FF")
                .backgroundColor("#0D1117")
                .textColor("#C9D1D9")
                .fontFamily("Segoe UI")
                .baseFontSizePx(15)
                .borderRadiusPx(6)
                .spacingUnitPx(8)
                .darkMode(true)
                .build();
    }

    public Theme lightPlayfulTheme(ThemeBuilder builder) {
        return builder
                .name("Light Playful")
                .primaryColor("#FF6B6B")
                .secondaryColor("#FFD93D")
                .accentColor("#6BCB77")
                .backgroundColor("#FFFDF7")
                .textColor("#2B2B2B")
                .fontFamily("Poppins")
                .baseFontSizePx(17)
                .borderRadiusPx(16)
                .spacingUnitPx(10)
                .darkMode(false)
                .build();
    }

    public Theme highContrastAccessibleTheme(ThemeBuilder builder) {
        return builder
                .name("High Contrast Accessible")
                .primaryColor("#FFFF00")
                .secondaryColor("#000000")
                .accentColor("#00FFFF")
                .backgroundColor("#000000")
                .textColor("#FFFFFF")
                .fontFamily("Arial")
                .baseFontSizePx(20)
                .borderRadiusPx(0)
                .spacingUnitPx(12)
                .darkMode(true)
                .build();
    }
}
