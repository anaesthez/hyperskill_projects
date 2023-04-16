package fourth_stage

/*
task:
The program should work as follows:

Get the initial 3x3 grid from the input as in the previous stages.
Here the user should input 9 symbols representing the field, for example, _XXOO_OX_.
Output this 3x3 grid as in the previous stages.
Prompt the user to make a move.
The user should input 2 coordinate numbers that represent the cell where they want to place their X, for example, 1 1.
Analyze user input. If the input is incorrect, inform the user why their input is wrong:
Print This cell is occupied! Choose another one! if the cell is not empty.
Print You should enter numbers! if the user enters non-numeric symbols in the coordinates input.
Print Coordinates should be from 1 to 3! if the user enters coordinates outside the game grid.
Keep prompting the user to enter the coordinates until the user input is valid.
If the input is correct, update the grid to include the user's move and print the updated grid to the console.
To summarize, you need to output the field 2 times:
once before the user's move (based on the first line of input) and once after the user has entered valid coordinates
(then you need to update the grid to include that move). */

class Field(val lines: MutableList<MutableList<Char>>) {

    fun printField() {
        val field = lines
        println("---------")
        for (i in 0..2) println("| ${field[i].joinToString().replace(",", "")} |")
        println("---------")
    }
}

fun main() {
    val lines = readln().asSequence().chunked(3).map {it.toMutableList()}.toMutableList()
    val game = Field(lines)
    game.printField()

    while(true) {
        try{
            val (x,y) = readln().split(" ")
            if(game.lines[x.toInt() - 1][y.toInt() - 1] != 'X'&& game.lines[x.toInt() - 1][y.toInt() - 1] != 'O' ) {
                game.lines[x.toInt() - 1][y.toInt() - 1] = 'X'
                game.printField()
                break
            } else {
                println("This cell is occupied! Choose another one!")
            }
        } catch(e: IndexOutOfBoundsException) {
            println("Coordinates should be from 1 to 3!")
        }
    }
}