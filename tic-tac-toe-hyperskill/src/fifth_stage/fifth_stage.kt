package fifth_stage

/*
task:
The program should work as follows:

In this stage, you should write a program that:

Prints an empty grid at the beginning of the game.
Creates a game loop where the program asks the user to enter the cell coordinates, analyzes the move for correctness and shows a grid with the changes if everything is okay.
Ends the game when someone wins or there is a draw.
You need to output the final result at the end of the game. Good luck! */

class Game(private var lines: MutableList<MutableList<Char>> =  MutableList (3) { MutableList (3) { ' ' } } ) {

    init {
        printField()
        makeMove()
    }

    private fun printField() {
        println("---------")
        for (i in 0..2) println("| ${lines[i].joinToString().replace(",", "")} |")
        println("---------")
    }

    private fun makeMove() {
        while (true) {
            try {
                val (x, y) = readln().split(" ")
                if (lines[x.toInt() - 1][y.toInt() - 1] != 'X' && lines[x.toInt() - 1][y.toInt() - 1] != 'O') {
                    if(counter()) {
                        lines[x.toInt() - 1][y.toInt() - 1] = 'X'
                    } else {
                        lines[x.toInt() - 1][y.toInt() - 1] = 'O'
                    }
                    printField()
                    if (checkState()) {
                        break
                    } else {
                        continue
                    }
                } else {
                    println("This cell is occupied! Choose another one!")
                }
            } catch (e: IndexOutOfBoundsException) {
                println("Coordinates should be from 1 to 3!")
            }
        }
    }
    private fun counter(): Boolean {
        var x = 0
        var o = 0
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (lines[i][j] == 'X') x++
                if (lines[i][j] == 'O') o++
            }
        }
        return x <= o
    }

    private fun checkState(): Boolean {
        var output = ""
        if ((lines[0][0] == 'X' || lines[0][0] == 'O') && (lines[0][0] == lines[0][1] && lines[0][1] == lines[0][2])) {
            output += "${lines[0][0]} wins"
        } else if ((lines[1][0] == 'X' || lines[1][0] == 'O') && (lines[1][0] == lines[1][1] && lines[1][1] == lines[1][2])) {
            output += "${lines[1][0]} wins"
        } else if ((lines[2][0] == 'X' || lines[2][0] == 'O') && (lines[2][0] == lines[2][1] && lines[2][1] == lines[2][2])) {
            output += "${lines[2][0]} wins"
        } else if ((lines[0][0] == 'X' || lines[0][0] == 'O') && (lines[0][0] == lines[1][0] && lines[1][0] == lines[2][0])) {
            output += "${lines[0][0]} wins"
        } else if ((lines[0][1] == 'X' || lines[0][1] == 'O') && (lines[0][1] == lines[1][1] && lines[1][1] == lines[2][1])) {
            output += "${lines[0][1]} wins"
        } else if ((lines[0][2] == 'X' || lines[0][2] == 'O') && (lines[0][2] == lines[1][2] && lines[1][2] == lines[2][2])) {
            output += "${lines[0][2]} wins"
        } else if ((lines[0][0] == 'X' || lines[0][0] == 'O') && (lines[0][0] == lines[1][1] && lines[1][1] == lines[2][2])) {
            output += "${lines[0][0]} wins"
        } else if ((lines[0][2] == 'X' || lines[0][2] == 'O') && (lines[0][2] == lines[1][1] && lines[1][1] == lines[2][0])) {
            output += "${lines[0][2]} wins"
        }
        if (output.length == 6) {
            println(output)
            return true
        }
        var x = 0
        var o = 0
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (lines[i][j] == 'X') x++
                if (lines[i][j] == 'O') o++
            }
        }
        return if (x == 5 || o == 5) {
            println("Draw")
            true
        } else {
            false
        }
    }
}


fun main() {
    Game()
}