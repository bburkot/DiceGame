package pl.edu.agh.to1.dice.logic;

public class Game2 {
	Game2(){};
	
    protected Table getTable() {
        return StdTable.getTable();
    }
    public int getMinPlayers() {
        return 2;
    }
    public int getMaxPlayers() {
        return 4;
    }
    protected int getDiceSetSize() {
        return 5;
    }
    protected int getMaxRerolls() {
        return 2;
    }
}
