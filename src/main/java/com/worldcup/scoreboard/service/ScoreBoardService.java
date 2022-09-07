package com.worldcup.scoreboard.service;

import java.util.List;

import com.worldcup.scoreboard.dao.Match;

public interface ScoreBoardService {
	
	boolean startGame(String homeTeam, String awayTeam);
	
	boolean finishGame(String homeTeam, String awayTeam);
	
	boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);
	
	List<Match> getSummaryByTotalScore();

}
