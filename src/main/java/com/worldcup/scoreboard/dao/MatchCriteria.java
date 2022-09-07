package com.worldcup.scoreboard.dao;

public class MatchCriteria {
	
	private final String homeTeam;
	private final String awayTeam;
	
	private MatchCriteria(Builder builder) {
		this.homeTeam = builder.homeTeam;
		this.awayTeam = builder.awayTeam;
	}
	
	public static class Builder {
		private String homeTeam;
		private String awayTeam;
		
		public Builder homeTeam(String homeTeam) {
			this.homeTeam = homeTeam;
			return this;
		}
		
		public Builder awayTeam(String awayTeam) {
			this.awayTeam = awayTeam;
			return this;
		}
		
		public MatchCriteria build() {
			return new MatchCriteria(this);
		}
		
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

}
