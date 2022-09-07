package com.worldcup.scoreboard.dao;

import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

}
