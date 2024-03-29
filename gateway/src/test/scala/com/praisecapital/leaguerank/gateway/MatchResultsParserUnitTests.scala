package com.leaguerank.gateway

import org.scalatest.funsuite.AnyFunSuite
import com.leaguerank.model.{MatchResultDefaultObject, TeamScoreDefaultObject}

class MatchResultsParserUnitTests extends AnyFunSuite {

  test(
    "successfully parse a single match result in string format to a List[MatchResult] object"
  ) {
    val matchScores = "Lions 3, Snakes 3"
    val lions = "Lions"
    val snakes = "Snakes"
    val expectedMatchResults = List(
      MatchResultDefaultObject.copy(
        teamA = TeamScoreDefaultObject.copy(lions, 3),
        teamB = TeamScoreDefaultObject.copy(snakes, 3)
      )
    )

    assert(expectedMatchResults === MatchResultsParser.parse(List(matchScores)))
  }

  test(
    "successfully parse multiple match result in string format to a List[MatchResult] object"
  ) {
    val matchScores_1 = "Lions 3, Snakes 3"
    val matchScores_2 = "Tarantulas 1, FC Awesome 0"
    val lions = "Lions"
    val snakes = "Snakes"
    val tarantulas = "Tarantulas"
    val fcAwesome = "FC Awesome"

    val expectedMatchResults = List(
      MatchResultDefaultObject.copy(
        teamA = TeamScoreDefaultObject.copy(lions, 3),
        teamB = TeamScoreDefaultObject.copy(snakes, 3)
      ),
      MatchResultDefaultObject.copy(
        teamA = TeamScoreDefaultObject.copy(tarantulas, 1),
        teamB = TeamScoreDefaultObject.copy(fcAwesome, 0)
      )
    )

    assert(
      expectedMatchResults === MatchResultsParser.parse(
        List(matchScores_1, matchScores_2)
      )
    )
  }
}
