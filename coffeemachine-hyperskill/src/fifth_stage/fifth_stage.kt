package fifth_stage

/*
task:
Write a program that will work endlessly to make coffee for all interested persons until the shutdown signal is given.
Introduce two new options: "remaining" and "exit".
Do not forget that you can be out of resources for making coffee.
If the coffee machine doesn't have enough resources to make coffee,
the program should output a message that says it can't make a cup of coffee and state what is missing.

And the last improvement to the program at this step —
if the user types "buy" to buy a cup of coffee and then changes his mind,
they should be able to type "back" to return into the main cycle.
 */

class CoffeeMachine(private var water: Int = 400,
                    private var milk: Int = 540,
                    private var beans: Int = 120,
                    private var dollars: Int = 550,
                    private var cups: Int = 9) {

    fun fullInfo(): String {
        return "The coffee machine has:\n" +
                "${this.water} ml of water\n" +
                "${this.milk} ml of milk\n" +
                "${this.beans} g of coffee beans\n" +
                "${this.cups} disposable cups\n" +
                "${this.dollars} of money"
    }

    private fun makeCoffee(water: Int, milk: Int, beans: Int, dollars: Int, cups: Int) {
        if (this.water - water < 0) {
            println("Sorry, not enough water!")
        } else if (this.beans - beans < 0) {
            println("Sorry, not enough beans!")
        } else if (this.milk - milk < 0) {
            println("Sorry, not enough milk!")
        } else {
            this.cups -= cups
            this.water -= water
            this.milk -= milk
            this.beans -= beans
            this.dollars += dollars
            println("I have enough resources, making you a coffee!")
        }
    }
    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when(readln()) {
            "1" -> this.makeCoffee(250, 0,16,4,1)
            "2" -> this.makeCoffee(350,75,20,7,1)
            "3" -> this.makeCoffee(200, 100,12,6,1)
        }
    }

    fun fill() {
        println("Write how many ml of water do you want to add:")
        this.water += readln().toInt()
        println("Write how many ml of milk do you want to add:")
        this.milk += readln().toInt()
        println("Write how many grams of coffee beans do you want to add:")
        this.beans += readln().toInt()
        println("Write how many disposable cups of coffee do you want to add:")
        this.cups += readln().toInt()
    }

    fun take() {
        println("I gave you ${this.dollars}")
        this.dollars = 0
    }
}

fun main() {
    val machine = CoffeeMachine()
    while(true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when(readln()) {
            "fill" -> machine.fill()
            "take" -> machine.take()
            "buy" -> machine.buy()
            "remaining" -> println(machine.fullInfo())
            "exit" -> break
        }
    }
}