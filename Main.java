package com.sdp.theme.builder;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 1. Manual construction (custom, one-off theme) ===");
        Theme oceanLight = new ThemeBuilder()
                .name("Ocean Light")
                .primaryColor("#0077B6")
                .secondaryColor("#90E0EF")
                .backgroundColor("#FFFFFF")
                .textColor("#03045E")
                .fontFamily("Inter")
                .baseFontSizePx(16)
                .borderRadiusPx(8)
                .build();
        System.out.println(oceanLight.toSummary());

        System.out.println();
        System.out.println("=== 2. Director-driven construction (known presets) ===");
        ThemeDirector director = new ThemeDirector();
        Theme darkCorporate = director.darkCorporateTheme(new ThemeBuilder());
        Theme lightPlayful = director.lightPlayfulTheme(new ThemeBuilder());
        Theme highContrast = director.highContrastAccessibleTheme(new ThemeBuilder());

        for (Theme theme : new Theme[] { darkCorporate, lightPlayful, highContrast }) {
            System.out.println(theme.toSummary());
        }

        System.out.println();
        System.out.println("=== 3. Multiple representations of one Theme ===");
        System.out.println("--- Summary ---");
        System.out.println(darkCorporate.toSummary());
        System.out.println("--- CSS ---");
        System.out.println(darkCorporate.toCssVariablesBlock());
        System.out.println("--- JSON ---");
        System.out.println(darkCorporate.toJson());

        System.out.println("=== 4. Validation in action ===");
        try {
            new ThemeBuilder()
                    .name("Broken Theme")
                    .fontFamily("Arial")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error (missing fields): " + e.getMessage());
        }

        try {
            new ThemeBuilder().primaryColor("not-a-color");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error (bad color): " + e.getMessage());
        }
    }
}
