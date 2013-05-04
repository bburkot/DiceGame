package pl.edu.agh.to1.dice.logic;

import java.util.ArrayList;

public class Bot extends Player{
	private ArrayList<String> availableComands = new ArrayList<String>();
	Table privateTable;
	public Bot(String name, PlayerIOController playerIOController) {
		super(name, playerIOController);
		if(!(playerIOController instanceof BotIOControler)){
			throw new Error("bot IO controler must be instance of BotIOControler");
		}
		addComands(); 
	}

	public Bot() {
		super("bot",(PlayerIOController)(new BotIOControler()));
		addComands(); 		
	}
	
	public void play() {
	//	System.out.println("bot turn");
       int intTable[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
       privateTable =  StdTable.getTable();
       for(int i=0;  i<availableComands.size();  i++){
    	   privateTable.execute(availableComands.get(i), diceSet);
           intTable[i] = privateTable.getLastPoints();
       }
       int currentMax=0;
       for(int i=1;i<availableComands.size();i++){
    	  if(intTable[i]>currentMax)   		  
    		  currentMax = i;
       }
       table.execute(availableComands.get(currentMax), diceSet);
       availableComands.remove(currentMax); 
      // System.out.println(availableComands);
  //     System.out.println("\nend bot turn");
    }
	
	
	void addComands(){
		availableComands.add("1");
		availableComands.add("2");
		availableComands.add("3");
		availableComands.add("4");
		availableComands.add("5");
		availableComands.add("6");
		availableComands.add("3ka");
		availableComands.add("4ka");
		availableComands.add("ful");
		availableComands.add("ms");
		availableComands.add("ds");
		availableComands.add("g");
		availableComands.add("sz");
	}
}
