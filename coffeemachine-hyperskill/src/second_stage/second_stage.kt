package second_stage
/*
task:
First, read the numbers of coffee drinks from the input.
Figure out how much of each ingredient the machine will need.
Note that one cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk,
and 15 g of coffee beans.
Output the required ingredient amounts back to the user.
 */
class CoffeeMachine(val cups: Int) {

    fun countMilk (): Int = 50 * cups
    fun countWater (): Int = 200 * cups
    fun countBeans () : Int = 15 * cups

}

fun main() {
    println("Write how many cups of coffee you will need:")
    val cups = try {

        readln().trim().toInt()

    } catch (e: Exception) {

        null

    }

    if(cups != null) {
        val coffee = CoffeeMachine(cups)
        println(buildString {
            append("For ${coffee.cups} cups of coffee you will need: \n")
            append(coffee.countWater())
            append(" ml of water \n")
            append(coffee.countMilk())
            append(" ml of milk \n")
            append(coffee.countBeans())
            append(" g of coffee beans")
        } )
    } else {
        throw RuntimeException("You need to specify the number of cups")
    }
}