package com.example;


import java.util.Random;

public class JokesLibrary {

    private static int sCounter = 0;

    private static final String[] JOKE_LIST = {
            "A woman gets on a bus with her baby. The bus driver says: ''Ugh, that's the ugliest baby I've ever seen!'' The woman walks to the rear of the bus and sits down, fuming. She says to a man next to her: ''The driver just insulted me!'' The man says: ''You go up there and tell him off. Go on, I'll hold your monkey for you.''",
            "I went to the zoo the other day, there was only one dog in it, it was a shitzu.'",
            "Police arrested two kids yesterday, one was drinking battery acid, the other was eating fireworks. They charged one - and let the other one off.",
            "There's two fish in a tank, and one says ''How do you drive this thing?''",
            "A priest, a rabbi and a vicar walk into a bar. The barman says, ''Is this some kind of joke?''",
    };


    public static String getJoke() {

        if (sCounter == JOKE_LIST.length) sCounter = 0;
        String joke = JOKE_LIST[sCounter];
        sCounter++;

        return joke;
    }


}
