package com.worldcup.scoreboard.dao;

import java.util.List;
import java.util.Optional;

public interface ScoreBoardDao {
	
	List<Match> getLiveMatches();
	
	boolean insertMatch(Match match);

	boolean updateMatch(Match match);

	boolean deleteMatch(Match match);

	Optional<Match> findMatchByTeams(MatchCriteria criteria);

}
