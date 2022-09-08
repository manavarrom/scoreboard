package com.worldcup.scoreboard.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.worldcup.scoreboard.dao.Match;
import com.worldcup.scoreboard.dao.MatchCriteria;
import com.worldcup.scoreboard.dao.ScoreBoardDao;
import com.worldcup.scoreboard.dao.ScoreBoardDaoImpl;

public class ScoreBoardServiceImpl implements ScoreBoardService {
	
	private final ScoreBoardDao scoreBoardDao;
	
	private static final Comparator<Match> BY_TOTAL_SCORE_AND_LAST_ADDED = Comparator.comparing(Match::getTotalScore)
																					 .thenComparing(Match::getCreationTime)
																					 .reversed();
	
	public ScoreBoardServiceImpl() {
		this.scoreBoardDao = new ScoreBoardDaoImpl();
	}

	@Override
	public boolean startGame(String homeTeam, String awayTeam) {
		boolean isValidInput = this.checkInputForStartGame(homeTeam,awayTeam);
		
		return isValidInput ? this.scoreBoardDao.insertMatch(new Match(homeTeam, awayTeam)) : false;
	}

	@Override
	public boolean finishGame(String homeTeam, String awayTeam) {
		boolean isValidInput = this.checkInputForFinishGame(homeTeam,awayTeam);
		
		return isValidInput ? this.finishMatch(homeTeam, awayTeam) : false; 
	}
	
	private boolean finishMatch(String homeTeam, String awayTeam) {
		Optional<Match> match = this.findMatchByTeams(homeTeam, awayTeam);
		
		return match.isPresent() ? this.scoreBoardDao.deleteMatch(match.get()) : false;
	}

	@Override
	public boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
		boolean isValidInput = this.checkInputForUpdateScore(homeTeam,awayTeam, homeScore, awayScore);
		
		return isValidInput ? this.updateMatchScore(homeTeam, awayTeam, homeScore, awayScore) : false;
	}
	
	private boolean updateMatchScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
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
		
		liveMatcher.sort(BY_TOTAL_SCORE_AND_LAST_ADDED);
		
		return liveMatcher;
	}
	
	private Optional<Match> findMatchByTeams(String homeTeam, String awayTeam){
		MatchCriteria criteria = new MatchCriteria.Builder().homeTeam(homeTeam)
															.awayTeam(awayTeam).build();

		return this.scoreBoardDao.findMatchByTeams(criteria);
	}
	
	private boolean checkInputForStartGame(String homeTeam, String awayTeam) {
		boolean isNotNull = this.checkInputIsNotNull(Optional.ofNullable(homeTeam), 
													 Optional.ofNullable(awayTeam));
		
		boolean isInGame = isNotNull ? this.checkTeamsAreInGame(homeTeam, awayTeam) : false;
		
		return isNotNull && !isInGame;
	}
	
	private boolean checkInputForFinishGame(String homeTeam, String awayTeam) {
		return this.checkInputIsNotNull(Optional.ofNullable(homeTeam), 
										Optional.ofNullable(awayTeam));
	}
	
	private boolean checkInputForUpdateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
		boolean isNotNull = this.checkInputIsNotNull(Optional.ofNullable(homeTeam), 
													 Optional.ofNullable(awayTeam));
		
		boolean isValidScore = isNotNull ? this.isValidScore(homeScore, awayScore) : false;
		
		return isNotNull && isValidScore;
	}
	
	private boolean checkInputIsNotNull(Optional<String> homeTeam, Optional<String> awayTeam) {
		return homeTeam.isPresent() && awayTeam.isPresent();
	}
	
	private boolean checkTeamsAreInGame(String homeTeam, String awayTeam) {
		Optional<Match> matchForHomeTeam = this.scoreBoardDao.findMatchByTeam(homeTeam);
		Optional<Match> matchForAwayTeam = this.scoreBoardDao.findMatchByTeam(awayTeam);
		
		return matchForHomeTeam.isPresent() || matchForAwayTeam.isPresent();
	}
	
	private boolean isValidScore(int homeScore, int awayScore) {
		return homeScore >=0 && awayScore >=0;
	}

}
