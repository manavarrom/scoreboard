package com.worldcup.scoreboard;

import com.worldcup.scoreboard.controller.ScoreBoardController;
import com.worldcup.scoreboard.controller.ScoreBoardControllerImpl;

public class AppDemo 
{
    public static void main( String[] args ) throws Exception
    {
    	ScoreBoardController controller = new ScoreBoardControllerImpl();
    	
    	controller.startGame("Mexico", "Canada");
    	controller.updateScore("Mexico", "Canada", 0, 5);
        Thread.sleep(1);
    	
    	controller.startGame("Spain", "Brazil");
    	controller.updateScore("Spain", "Brazil", 10, 2);
        Thread.sleep(1);
    	
    	controller.startGame("Germany", "France");
    	controller.updateScore("Germany", "France", 2, 2);
        Thread.sleep(1);
    	
    	controller.startGame("Uruguay", "Italy");
    	controller.updateScore("Uruguay", "Italy", 6, 6);
        Thread.sleep(1);
    	
    	controller.startGame("Argentina", "Australia");
    	controller.updateScore("Argentina", "Australia", 3, 1);
        Thread.sleep(1);
    	
    	
    	System.out.println("Summary by Total Score:\n");
    	controller.getSummaryByTotalScore().forEach(System.out::println);
    	
    	controller.finishGame("Mexico", "Canada");
    	
    	System.out.println("\nSummary by Total Score:\n");
    	controller.getSummaryByTotalScore().forEach(System.out::println);
        
    }
}
