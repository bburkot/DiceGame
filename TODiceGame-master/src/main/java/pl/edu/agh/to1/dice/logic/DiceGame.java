package pl.edu.agh.to1.dice.logic;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;

public class DiceGame {
    public void play() {
        System.out.println("Playing Dice:");

        GameOutputController gameOutputController = new StdGameOutputController();
        PlayerIOController playerIOController = new StdPlayerIOController();

        Player terr = new Player("Player 1", playerIOController);
      //  Player ct1   = new Player("Player 2", playerIOController);
      //  Player ct2   = new Player("Player 3", playerIOController);
        Bot ct3   = new Bot();

        Game game = new Game(gameOutputController);

        game.registerPlayer(terr);
     //   game.registerPlayer(ct1);
     //   game.registerPlayer(ct2);
        game.registerPlayer(ct3);
        
        int status = game.play();
    }
}