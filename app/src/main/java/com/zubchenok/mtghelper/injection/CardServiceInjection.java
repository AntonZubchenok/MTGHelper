package com.zubchenok.mtghelper.injection;

import com.zubchenok.mtghelper.usecases.impl.CardService;
import com.zubchenok.mtghelper.usecases.interfaces.ICardService;

public class CardServiceInjection {

    public static ICardService provideCardService() {
        return new CardService();
    }
}
