package fourth_stage
/*
task:
Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out.
Note that the program is supposed to do one of the mentioned actions at a time.
It should also calculate the amounts of remaining ingredients and how much money is left.
Display the quantity of supplies before and after purchase.

First, your program reads one option from the standard input, which can be "buy", "fill", "take".
If a user wants to buy some coffee, the input is "buy".
If a special worker thinks that it is time to fill out all the supplies for the coffee machine,
the input line will be "fill".
If another special worker decides that it is time to take out the money from the coffee machine,
 you'll get the input "take".
If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make: espresso,
latte, or cappuccino.
For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
If the user writes "fill", the program should ask them how much water, milk,
coffee and how many disposable cups they want to add into the coffee machine.
If the user writes "take" the program should give all the money that it earned from selling coffee.
At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans,
and 9 disposable cups.
 */
open class CoffeeMachine(var water: Int = 400, var milk: Int = 540, var beans: Int = 120, var dollars: Int = 550, var cups: Int = 9) {

    fun fullInfo(): String {
        return "The coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$beans g of coffee beans\n" +
                "$cups disposable cups\n" +
                "$dollars of money"
    }

    open fun makeCoffee() {
        --cups
        println(fullInfo())
    }

    fun buy() {
        val espresso = Espresso(water, milk, beans, dollars, cups)
        val latte = Latte(water, milk, beans, dollars, cups)
        val cappuccino = Cappuccino(water, milk, beans, dollars, cups)
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        when(readln().toInt()) {
            1 -> espresso.makeCoffee()
            2 -> latte.makeCoffee()
            3 -> cappuccino.makeCoffee()
        }
    }

    fun fill() {
        println("Write how many ml of water do you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk do you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans do you want to add:")
        beans += readln().toInt()
        println("Write how many disposable cups of coffee do you want to add:")
        cups += readln().toInt()
        println(fullInfo())
    }
    fun take() {
        println("I gave you $dollars")
        dollars = 0
        println(fullInfo())
    }
}

class Espresso(water: Int, milk: Int, beans: Int, cups: Int, dollars: Int) : CoffeeMachine(water, milk, beans, cups, dollars){
    override fun makeCoffee() {
        --cups
        water -= 250
        beans -= 16
        dollars += 4
        println(fullInfo())
    }
}

class Latte(water: Int, milk: Int, beans: Int, cups: Int, dollars: Int) : CoffeeMachine(water, milk, beans, cups, dollars) {
    override fun makeCoffee() {
        --cups
        water -= 350
        milk -= 75
        beans -= 20
        dollars += 7
        println(fullInfo())
    }
}

class Cappuccino(water: Int, milk: Int, beans: Int, cups: Int, dollars: Int) : CoffeeMachine(water, milk, beans, cups, dollars) {
    override fun makeCoffee() {
        --cups
        water -= 200
        milk -= 100
        beans -= 12
        dollars += 6
        println(fullInfo())
    }
}

fun main() {
    val machine = CoffeeMachine()
    println(machine.fullInfo())
    println("Write action (buy, fill, take):")
    when(readln()) {
        "fill" -> machine.fill()
        "take" -> machine.take()
        "buy" -> machine.buy()
    }
}