package com.worldcup.scoreboard.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ScoreBoardDaoImpl implements ScoreBoardDao {
	
	private final List<Match> liveMatches = new ArrayList<>();

	@Override
	public List<Match> getLiveMatches() {
		return this.liveMatches;
	}

	@Override
	public boolean insertMatch(Match match) {
		return this.liveMatches.add(match);
	}

	@Override
	public boolean updateMatch(Match match) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMatch(Match match) {
		return this.liveMatches.remove(match);
	}

	@Override
	public Optional<Match> findMatchByTeams(MatchCriteria criteria) {
		return this.findMatch(m -> m.getHomeTeam().equals(criteria.getHomeTeam()) && 
									m.getAwayTeam().equals(criteria.getAwayTeam()));
	}
	
	private Optional<Match> findMatch(Predicate<Match> predicate) {
		
		for(Match match : this.liveMatches){
			if(predicate.test(match)) {
				return Optional.of(match);
			}
		}
		
		return Optional.empty();
	}

}
