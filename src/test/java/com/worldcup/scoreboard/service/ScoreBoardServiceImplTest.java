package com.worldcup.scoreboard.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.worldcup.scoreboard.dao.Match;

public class ScoreBoardServiceImplTest {
	
	private static final String HOME_TEAM_1 = "Spain";
	private static final String HOME_TEAM_2 = "Uruguay";
	private static final String AWAY_TEAM_1 = "Brazil";
	private static final String AWAY_TEAM_2 = "Italy";
	private static final int FIRST_INDEX = 0;
	private static final int SECOND_INDEX = 1;
	
    
    @Test
    public void when_start_game_then_create_new_match_with_initial_score_zero() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home team not equals to expected Home team", HOME_TEAM_1, liveMatches.get(FIRST_INDEX).getHomeTeam());
    	assertEquals("Away team not equals to expected Away team", AWAY_TEAM_1, liveMatches.get(FIRST_INDEX).getAwayTeam());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_start_game_with_null_teams_input_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(null, null);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Match added", isAdded);
    	assertEquals("Match added to liveMatches", 0, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_null_home_team_input_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(null, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Match added", isAdded);
    	assertEquals("Match added to liveMatches", 0, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_null_away_team_input_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, null);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Match added", isAdded);
    	assertEquals("Match added to liveMatches", 0, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_same_teams_previously_added_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isAddedSecondMatch = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Second match added", isAddedSecondMatch);
    	assertEquals("Second match added to liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_same_teams_previously_added_in_reversed_order_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isAddedSecondMatch = scoreBoardService.startGame(AWAY_TEAM_1, HOME_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Second match added", isAddedSecondMatch);
    	assertEquals("Second match added to liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_home_team_previously_added_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isAddedSecondMatch = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Second match added", isAddedSecondMatch);
    	assertEquals("Second match added to liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_away_team_previously_added_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isAddedSecondMatch = scoreBoardService.startGame(HOME_TEAM_2, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Second match added", isAddedSecondMatch);
    	assertEquals("Second match added to liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_away_team_previously_added_as_home_team_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isAddedSecondMatch = scoreBoardService.startGame(HOME_TEAM_2, HOME_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Second match added", isAddedSecondMatch);
    	assertEquals("Second match added to liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_start_game_with_home_team_previously_added_as_away_team_then_match_is_not_added() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	boolean isAdded = scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Start game returns false. Match not added", isAdded);
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isAddedSecondMatch = scoreBoardService.startGame(AWAY_TEAM_1, AWAY_TEAM_2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Start game returns true. Second match added", isAddedSecondMatch);
    	assertEquals("Second match added to liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_finish_game_then_remove_from_scoreboard() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isRemoved = scoreBoardService.finishGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Finish game returns false. Match not removed", isRemoved);
    	assertEquals("Finished Match not removed from liveMatches", 0, liveMatches.size());
    }
    
    @Test
    public void when_finish_game_receive_teams_in_reversed_order_then_match_is_not_removed() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isRemoved = scoreBoardService.finishGame(AWAY_TEAM_1, HOME_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Finish game returns true. Match removed", isRemoved);
    	assertEquals("Finished Match removed from liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_finish_game_receive_null_teams_input_then_match_is_not_removed() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isRemoved = scoreBoardService.finishGame(null, null);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Finish game returns true. Match removed", isRemoved);
    	assertEquals("Finished Match removed from liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_finish_game_receive_null_home_team_input_then_match_is_not_removed() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isRemoved = scoreBoardService.finishGame(null, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Finish game returns true. Match removed", isRemoved);
    	assertEquals("Finished Match removed from liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_finish_game_receive_null_away_team_input_then_match_is_not_removed() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	
    	boolean isRemoved = scoreBoardService.finishGame(HOME_TEAM_1, null);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Finish game returns true. Match removed", isRemoved);
    	assertEquals("Finished Match removed from liveMatches", 1, liveMatches.size());
    }
    
    @Test
    public void when_receive_pair_score_then_updates_match_score() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(HOME_TEAM_1, AWAY_TEAM_1, 10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Update score returns false. Score not updated", isUpdated);
    	assertEquals("Home score not updated", 10, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not updated", 2, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 12, liveMatches.get(FIRST_INDEX).getTotalScore());
    }
    
    @Test
    public void when_update_score_receive_null_teams_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(null, null, 10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_update_score_receive_null_home_team_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(null, AWAY_TEAM_1, 10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_update_score_receive_null_away_team_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(HOME_TEAM_1, null, 10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_update_score_receive_teams_in_reversed_order_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(AWAY_TEAM_1, HOME_TEAM_1, 10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_update_score_receive_negative_home_score_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(HOME_TEAM_1, AWAY_TEAM_1, -10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_update_score_receive_negative_away_score_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(HOME_TEAM_1, AWAY_TEAM_1, 10, -2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_update_score_receive_negative_home_and_away_score_then_match_score_not_updated() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	    	
    	assertEquals("Match not added to liveMatches", 1, liveMatches.size());
    	assertEquals("Home score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score not equals to zero", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    	assertEquals("Total score not equals to expected total score", 0, liveMatches.get(FIRST_INDEX).getTotalScore());
    	
    	boolean isUpdated = scoreBoardService.updateScore(HOME_TEAM_1, AWAY_TEAM_1, -10, -2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertFalse("Update score returns true. Score updated", isUpdated);
    	assertEquals("Home score updated", 0, liveMatches.get(FIRST_INDEX).getHomeScore());
    	assertEquals("Away score updated", 0, liveMatches.get(FIRST_INDEX).getAwayScore());
    }
    
    @Test
    public void when_get_summary_with_no_games_started_then_returned_empty_list() {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    }
    
    @Test
    public void when_get_summary_and_matches_have_same_score_then_returned_ordered_by_most_recently_added() throws InterruptedException {
    	ScoreBoardService scoreBoardService = new ScoreBoardServiceImpl();
    	
    	List<Match> liveMatches = scoreBoardService.getSummaryByTotalScore();
    	
    	assertTrue("Initial liveMatches is not empty", liveMatches.isEmpty());
    	
    	scoreBoardService.startGame(HOME_TEAM_1, AWAY_TEAM_1);
    	scoreBoardService.updateScore(HOME_TEAM_1, AWAY_TEAM_1, 10, 2);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();
    	Thread.sleep(1);
    	
    	assertEquals("First match not added to liveMatches", 1, liveMatches.size());
    	
    	scoreBoardService.startGame(HOME_TEAM_2, AWAY_TEAM_2);
    	scoreBoardService.updateScore(HOME_TEAM_2, AWAY_TEAM_2, 6, 6);
    	liveMatches = scoreBoardService.getSummaryByTotalScore();

    	assertEquals("Second match not added to liveMatches", 2, liveMatches.size());
    	
    	assertEquals("First total score not equals to second total score", 
    			liveMatches.get(FIRST_INDEX).getTotalScore(), liveMatches.get(SECOND_INDEX).getTotalScore());    	
    	assertTrue("First returned match added before second returned match", 
    			liveMatches.get(FIRST_INDEX).getCreationTime().after(liveMatches.get(SECOND_INDEX).getCreationTime()));
    }
    
}
