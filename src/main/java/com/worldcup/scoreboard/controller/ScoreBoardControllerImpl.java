package com.worldcup.scoreboard.controller;

import java.util.List;

import com.worldcup.scoreboard.dao.Match;
import com.worldcup.scoreboard.service.ScoreBoardService;
import com.worldcup.scoreboard.service.ScoreBoardServiceImpl;

public class ScoreBoardControllerImpl implements ScoreBoardController{
	
	private final ScoreBoardService scoreBoardService;
	
	public ScoreBoardControllerImpl() {
		this.scoreBoardService = new ScoreBoardServiceImpl();
	}
	
	public ScoreBoardControllerImpl(ScoreBoardService scoreBoardService) {
		this.scoreBoardService = scoreBoardService;
	}

	@Override
	public boolean startGame(String homeTeam, String awayTeam) {
		return this.scoreBoardService.startGame(homeTeam, awayTeam);
	}

	@Override
	public boolean finishGame(String homeTeam, String awayTeam) {
		return this.scoreBoardService.finishGame(homeTeam, awayTeam);
	}

	@Override
	public boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
		return this.scoreBoardService.updateScore(homeTeam, awayTeam, homeScore, awayScore);
	}

	@Override
	public List<Match> getSummaryByTotalScore() {
		return this.scoreBoardService.getSummaryByTotalScore();
	}

}
