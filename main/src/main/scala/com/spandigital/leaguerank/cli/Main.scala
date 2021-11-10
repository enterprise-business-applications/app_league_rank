package com.spandigital.leaguerank.cli

import com.spandigital.leaguerank.gateway.MatchesFileParser
import com.spandigital.leaguerank.core._
object Main extends App {
  try {
    if (args.length == 0)
      println("Please provide a filename.")
    else if (args.length > 1)
      println("Please provide one filename.")
    else {
      val matchResultsFileName = args(0)
      val matches = MatchesFileParser.loadFile(matchResultsFileName)
      val league = League()
      val rankings = league.allocateRankings(matches)
      println(league)
    }
  } catch {
    case e: Exception =>
      println("failed during the execution of ranking teams. Please refer to stack trace below")
      e.printStackTrace()
  }
}
