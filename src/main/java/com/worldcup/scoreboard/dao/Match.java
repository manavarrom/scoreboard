package com.worldcup.scoreboard.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Match {
	
	private final String homeTeam;
	private final String awayTeam;
	private int homeScore;
	private int awayScore;
	private final Timestamp creationTime;

	public Match(String homeTeam, String awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.creationTime = Timestamp.valueOf(LocalDateTime.now());
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}
	
	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	
	public Timestamp getCreationTime() {
		return creationTime;
	}
	
	public int getTotalScore() {
		return this.homeScore + this.awayScore;
	}

	@Override
	public String toString() {
		return String.format("%s %d - %s %d", this.homeTeam, this.homeScore, this.awayTeam, this.awayScore);
	}

}
