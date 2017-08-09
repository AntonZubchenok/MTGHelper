package com.zubchenok.mtghelper.injection;

import com.zubchenok.mtghelper.services.impl.CardService;
import com.zubchenok.mtghelper.services.interfaces.ICardService;

public class CardServiceInjection {

    public static ICardService provideCardService() {
        return new CardService();
    }
}
