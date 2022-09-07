package com.worldcup.scoreboard.controller;

import java.util.List;

import com.worldcup.scoreboard.dao.Match;

public interface ScoreBoardController {
	
	boolean startGame(String homeTeam, String awayTeam);
	
	boolean finishGame(String homeTeam, String awayTeam);
	
	boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);
	
	List<Match> getSummaryByTotalScore();

}
