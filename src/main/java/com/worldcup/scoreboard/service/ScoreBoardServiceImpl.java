package com.worldcup.scoreboard.service;

import java.util.List;
import java.util.Optional;

import com.worldcup.scoreboard.dao.Match;
import com.worldcup.scoreboard.dao.MatchCriteria;
import com.worldcup.scoreboard.dao.ScoreBoardDao;
import com.worldcup.scoreboard.dao.ScoreBoardDaoImpl;

public class ScoreBoardServiceImpl implements ScoreBoardService {
	
	private final ScoreBoardDao scoreBoardDao;
	
	public ScoreBoardServiceImpl() {
		this.scoreBoardDao = new ScoreBoardDaoImpl();
	}

	@Override
	public boolean startGame(String homeTeam, String awayTeam) {
		return this.scoreBoardDao.insertMatch(new Match(homeTeam, awayTeam));
	}

	@Override
	public boolean finishGame(String homeTeam, String awayTeam) {
		MatchCriteria criteria = new MatchCriteria.Builder().homeTeam(homeTeam)
				.awayTeam(awayTeam).build();

		Optional<Match> match = this.scoreBoardDao.findMatchByTeams(criteria);
		
		return match.isPresent() ? this.scoreBoardDao.deleteMatch(match.get()) : false;
	}

	@Override
	public boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Match> getSummaryByTotalScore() {
		List<Match> liveMatcher = this.scoreBoardDao.getLiveMatches();
		
		//TODO sort liveMatcher by total score and last added.
		
		return liveMatcher;
	}

}
