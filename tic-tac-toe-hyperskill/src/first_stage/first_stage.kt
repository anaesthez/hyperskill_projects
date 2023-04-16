package first_stage
/*
task:
Your first task in this project is to print the game grid in the console output.
 */

fun main() {
    mutableListOf(
            mutableListOf('X', 'O', 'X'),
            mutableListOf('O', 'X', 'O'),
            mutableListOf('X', 'X', 'O')
    ).forEach { line -> line.joinToString(" ").let(::println) }
}