package second_stage
/*
task:
In this stage, you will write a program that:

Reads a string of 9 symbols from the input and displays them to the user in a 3x3 grid.
The grid can contain only X, O and _ symbols.
Outputs a line of dashes --------- above and below the grid,
adds a pipe | symbol to the beginning and end of each line of the grid,
and adds a space between all characters in the grid. */

fun main() {
    val input = readln()
    println("---------")
    input.chunked(3).forEach {
        println("| ${ it.chunked(1).joinToString(" ")} |")
    }
    print("---------")
}