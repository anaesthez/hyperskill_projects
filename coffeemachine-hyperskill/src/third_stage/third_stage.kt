package third_stage
/*
task:
It requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups a user needs.
If the coffee machine has enough supplies to make the specified amount of coffee, the program should print "Yes, I can make that amount of coffee".
If the coffee machine can make more than that, the program should output "Yes, I can make that amount of coffee (and even N more than that)", where N is the number of additional cups of coffee that the coffee machine can make.
If the amount of given resources is not enough to make the specified amount of coffee, the program should output "No, I can make only N cups of coffee".
 */
data class CoffeeMachine(val water: Int = 0, val milk: Int = 0, val beans: Int = 0) {
    val cups = minOf(water / 200 , milk / 50 , beans / 15)
}

fun validateInput(input: String): Int =
        try {
            input.trim().toInt()
        } catch (e: Exception) {
            throw RuntimeException("Wrong input")
        }

fun main() {
    println("Write how many ml of water the coffee machine has:")
    val availableWater = validateInput(readln())

    println("Write how many ml of milk the coffee machine has:")
    val availableMilk = validateInput(readln())

    println("Write how many grams of coffee beans the coffee machine has:")
    val availableBeans = validateInput(readln())

    println("Write how many cups of coffee you will need:")
    val requiredCups = validateInput(readln())

    val coffee = CoffeeMachine(availableWater, availableMilk, availableBeans)
    when {
        requiredCups == coffee.cups -> println("Yes, I can make that amount of coffee")
        requiredCups > coffee.cups -> println("No, I can make only ${coffee.cups} cups of coffee")
        requiredCups < coffee.cups -> println("Yes, I can make that amount of coffee (and even ${coffee.cups - requiredCups} more than that)")
    }
}