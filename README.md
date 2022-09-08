# scoreboard

Library for the Football World Cup scoreboards.

**Current version:** 1.1.0

**Branches of the project:**
> - master
> - develop

**Tags:**
> - scoreboard-1.0.0 - Initial implementation
> - scoreboard-1.1.0 - Adding validations to input data


## Functional description

The project consists of the implementation of a library that displays the live scores of the matches and scores of the Football World Cup.

The scoreboard supports the following operations:

- **Start a game**. The data of the matches will be received when start and that information will be captured. The information of the home team and the away team will be saved. The initial score is 0 - 0.
- **End a game**. The match information will be removed from the scoreboard.
- **Update score**. On receiving the score pair, home team score and away team score, the game score will be updated.
- **Get a summary of the games by total score**. Games with the same total score will be returned sorted by the most recently added to the system.



## Technical description

The library has been implemented as a Java Maven Project. The structure of the project is as follows:

```
scoreboard
	src/main/java
		com.worldcup.scoreboard
				controller
				dao
				service
	src/test/java
		com.worldcup.scoreboard
				service
```

The project has been implemented in three layers which are described below:

- **Controller:** This is the entry point to the library. It contains the methods corresponding to the functionalities of the application. This layer makes calls to the Service layer. It implements the following interface:

```
public interface ScoreBoardController {
	boolean startGame(String homeTeam, String awayTeam);
	boolean finishGame(String homeTeam, String awayTeam);
	boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);
	List<Match> getSummaryByTotalScore();
}
```

- **Service:** This layer implements the application logic. It receives the requests from the Controller layer, makes calls to the Dao layer and returns the results obtained to the Controller layer. It implements the following interface:

```
public interface ScoreBoardService {
	boolean startGame(String homeTeam, String awayTeam);
	boolean finishGame(String homeTeam, String awayTeam);
	boolean updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);
	List<Match> getSummaryByTotalScore();
}
```

- **Dao:** This layer implements the persistence of the application. It uses in-memory storage. For this, it uses ArrayList data structure, which contains the collection of the matches in play. It implements the following interface:

```
public interface ScoreBoardDao {
	List<Match> getLiveMatches();
	boolean insertMatch(Match match);
	boolean updateMatch(Match match);
	boolean deleteMatch(Match match);
	Optional<Match> findMatchByTeams(MatchCriteria criteria);
	Optional<Match> findMatchByTeam(String team);
}
```

In this layer the Match object is defined, which contains the information related to the matches: home team, away team, home team score and away team score.



## Technologies used

The project has been implemented with Java JDK 11.0.14.

Maven version 3.8.6 has been used to build the project.



## Build and Tests

As prerequisites for building the library, we must have installed at least the versions of JDK and Maven mentioned above.

Once the requirements are fulfilled, in the command line, from the root of the project we will execute the following maven command:

> mvn clean install

During the building of the library, the unit tests will be executed. The result will be shown in the console output:


```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.worldcup.scoreboard.service.ScoreBoardServiceImplTest
Tests run: 25, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.062 s - in com.worldcup.scoreboard.service.ScoreBoardServiceImplTest

Results:

Tests run: 25, Failures: 0, Errors: 0, Skipped: 0
```

At the end of the library build, the artifact with the project name and version will have been generated:

> .m2\repository\com\worldcup\scoreboard\1.1.0\\**scoreboard-1.1.0.jar**


## Usage

To use the library in an application, once the artefact has been generated, we can import the library into our application by adding the dependency to the maven pom.xml file:

```
<dependencies>
	<dependency>
		<groupId>com.worldcup</groupId>
		<artifactId>scoreboard</artifactId>
		<version>1.1.0</version>
	</dependency>
</dependencies>
```



## Usage example

The following is an example of the use of the application:

```
...
public static void main( String[] args ) throws Exception
{
	ScoreBoardController controller = new ScoreBoardControllerImpl();
		
	//Starting games and updating their scores
	controller.startGame("Mexico", "Canada");
	controller.updateScore("Mexico", "Canada", 0, 5);
		
	controller.startGame("Spain", "Brazil");
	controller.updateScore("Spain", "Brazil", 10, 2);
		
	controller.startGame("Germany", "France");
	controller.updateScore("Germany", "France", 2, 2);
		
	controller.startGame("Uruguay", "Italy");
	controller.updateScore("Uruguay", "Italy", 6, 6);
		
	controller.startGame("Argentina", "Australia");
	controller.updateScore("Argentina", "Australia", 3, 1);
		
	//Finishing a game
	controller.finishGame("Mexico", "Canada");
		
	//Getting summary for live games
	System.out.println("Summary by Total Score:\n");
	controller.getSummaryByTotalScore().forEach(System.out::println);
		
}
...
```

Executing the method produces the following output:

```
Summary by Total Score:

Uruguay 6 - Italy 6
Spain 10 - Brazil 2
Argentina 3 - Australia 1
Germany 2 - France 2
```
