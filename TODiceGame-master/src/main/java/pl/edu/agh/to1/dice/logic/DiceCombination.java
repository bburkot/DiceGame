package pl.edu.agh.to1.dice.logic;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 14.04.13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public abstract class DiceCombination implements DicedCommandHandler {
    protected int points = -1;
    protected final String cmd_string;

    protected DiceCombination(String cmd_string) {
        this.cmd_string = cmd_string;
    }

    public boolean isSet() {
        return (points >= 0);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    
    public CommandResponse execute(String cmd_string) {
        return (cmd_string.equals(this.cmd_string)) ? CommandResponse.CMD_FAILED : CommandResponse.CMD_UNKNOWN;
    }

    public abstract int check(DiceSet diceSet);

    
    public CommandResponse execute(String cmd_string, DiceSet diceSet) {
        CommandResponse response = CommandResponse.CMD_UNKNOWN;
        if (cmd_string.equals(this.cmd_string)) {
            if (!isSet()) {
                response = CommandResponse.CMD_OK;
                points = check(diceSet);
            }
            else {
                response = CommandResponse.CMD_FAILED;
            }
        }
        return response;
    }

    @Override
    public String toString() {
        return String.format("%-3s %3s", cmd_string, ((points < 0) ? "-" : Integer.toString(points)));
    }
}
