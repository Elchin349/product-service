package com.company.productsapi.enums;

public enum CategoryEnum {
    MOBILE_PHONE_AND_TABLET(1,"MOBILE PHONE AND TABLET"),
    TV_AND_AUDIO(2,"TV AND AUDIO"),
    COMPUTER_AND_ACCESSORIES(3,"COMPUTER AND ACCOSSORIES"),
    GAME_CONSOLE_AND_ACCESSORIES(4,"GAME CONSOLE AND ACCESSORIES"),
    PHOTO_AND_VIDEO(5,"PHOTO AND VIDEO"),
    HOUSEHOLD_APPLİANCES(6,"HOUSEHOLD APPLİANCES")
    ;

    private int id;
    private String name;

    CategoryEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
