package third_stage

/*
task:
In this stage, your program should:

Take a string entered by the user and print the game grid as in the previous stage.
Analyze the game state and print the result. Possible states:
Game not finished when neither side has three in a row but the grid still has empty cells.
Draw when no side has a three in a row and the grid has no empty cells.
X wins when the grid has three X’s in a row (including diagonals).
O wins when the grid has three O’s in a row (including diagonals).
Impossible when the grid has three X’s in a row as well as three O’s in a row,
or there are a lot more X's than O's or vice versa
(the difference should be 1 or 0; if the difference is 2 or more, then the game state is impossible).
In this stage, we will assume that either X or O can start the game.

You can choose whether to use a space or underscore _ to print empty cells. */

import kotlin.math.abs

class Field(private val lines: MutableList<Char>) {

    fun printField() {
        val field = lines.chunked(3).map {it.toMutableList()}
        println("---------")
        for (i in 0..2) println("| ${field[i].joinToString().replace(",", "")} |")
        println("---------")
    }

    fun checkState(): String {
        var output = ""
        if (lines[0] == lines[1] && lines[1] == lines[2]) output += "${lines[0]} wins"
        if (lines[3] == lines[4] && lines[0] == lines[4]) output += "${lines[3]} wins"
        if (lines[6] == lines[7] && lines[7] == lines[8]) output += "${lines[6]} wins"
        if (lines[0] == lines[3] && lines[3] == lines[6]) output += "${lines[0]} wins"
        if (lines[1] == lines[4] && lines[4] == lines[7]) output += "${lines[1]} wins"
        if (lines[2] == lines[5] && lines[5] == lines[8]) output += "${lines[2]} wins"
        if (lines[2] == lines[4] && lines[4] == lines[6]) output += "${lines[2]} wins"
        if (lines[0] == lines[4] && lines[4] == lines[8]) output += "${lines[0]} wins"
        if(output.length > 7) return "Impossible"
        if(output.length == 6) return output
        var x = 0
        var o = 0
        for(i in 0 until lines.size) {
            if(lines[i] == 'X') x++
            if(lines[i] == 'O') o++
        }
        if(abs(x - o) >= 2) return "Impossible"
        return if(lines.contains('_')) "Game not finished" else "Draw"
    }
}
fun main() {
    val lines = readln().asSequence().toMutableList()
    val game = Field(lines)
    game.printField()
    println(game.checkState())
}