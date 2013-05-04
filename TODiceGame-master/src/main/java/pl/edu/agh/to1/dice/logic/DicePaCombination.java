package pl.edu.agh.to1.dice.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 14.04.13
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public class DicePaCombination extends DiceJokerCombination {
    private final int n;
    public DicePaCombination(int n) {
        super("pa");
        this.n = n;
    }

    @Override
    public int check(DiceSet diceSet) {
        int points = 0;
        for (int i = 0; i < diceSet.SIZE; ++i) {
            if(diceSet.getValue(i) % 2 == 1) {
            	points = 1;
            }

        }

        if (points == 0) {
                for (int i = 0; i < diceSet.SIZE; ++i) {
                    points += diceSet.getValue(i);
                }
        }
        return points;
    }

    @Override
    public CommandResponse joker(DiceSet diceSet, int jokerBonus) {
        points = 0;
        for (int i = 0; i < diceSet.SIZE; ++i) {
            points += diceSet.getValue(i);
        }
        points += jokerBonus;
        return CommandResponse.CMD_OK;
    }
}
