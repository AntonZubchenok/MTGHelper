package com.zubchenok.mtghelper;

import com.zubchenok.mtghelper.ui.card.CardContract;
import com.zubchenok.mtghelper.ui.card.CardPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardPresenterTest {

    @Mock
    private CardContract.View view;

    private CardPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new CardPresenter(view);

    }

    @Test
    public void whenSearchCardsAttemptSucceeds() throws Exception {
        Mockito.verify(view).showCard("Test card name", "Test image URL");
    }

    @Test
    public void whenSearchCardsAttemptFails() throws Exception {
        Mockito.verify(view).showToast(Mockito.anyString());
    }

}