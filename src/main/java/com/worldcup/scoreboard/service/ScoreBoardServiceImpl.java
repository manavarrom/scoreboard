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
		Optional<Match> match = this.findMatchByTeams(homeTeam, awayTeam);
		
		return match.isPresent() ? this.scoreBoardDao.deleteMatch(match.get()) : false;
	}

	@Override
	public boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
		Optional<Match> match = this.findMatchByTeams(homeTeam, awayTeam);
		
		if(match.isPresent()) {
			Match updatedMatch = match.get();
			
			updatedMatch.setHomeScore(homeScore);
			updatedMatch.setAwayScore(awayScore);
			
			return this.scoreBoardDao.updateMatch(updatedMatch);
		}
		
		return false;
	}

	@Override
	public List<Match> getSummaryByTotalScore() {
		List<Match> liveMatcher = this.scoreBoardDao.getLiveMatches();
		
		//TODO sort liveMatcher by total score and last added.
		
		return liveMatcher;
	}
	
	private Optional<Match> findMatchByTeams(String homeTeam, String awayTeam){
		MatchCriteria criteria = new MatchCriteria.Builder().homeTeam(homeTeam)
															.awayTeam(awayTeam).build();

		return this.scoreBoardDao.findMatchByTeams(criteria);
	}

}
