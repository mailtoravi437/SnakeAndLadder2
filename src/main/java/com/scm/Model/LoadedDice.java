package com.scm.Model;

import java.util.Random;

public class LoadedDice implements DiceStrategy{
    Random random;
    @Override
    public int rollDice() {
        return random.nextInt(3)+4;
    }
}
