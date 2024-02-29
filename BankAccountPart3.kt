fun main() {


    var accountType = ""
    var userChoice = 0
    var isSystemOpen = true
    var option = 0


    var accountBalance = (0..1000).random()
    println("The checking balance is $accountBalance dollars.")
    val money = (0..1000).random()
    println("The amount you transferred is $money dollars.")

    fun withdraw(amount: Int): Int {
        accountBalance -= amount
        println("You successfully withdrew $amount dollars. The checking balance is ${accountBalance} dollars.")
        return amount
    }

    fun debitWithdraw(amount: Int): Int {
        if (accountBalance == 0) {
            println("Can't withdraw, no money on this account!")
            return accountBalance
        } else if (amount > accountBalance) {
            println("Not enough money on this account! The checking balance is $accountBalance dollars.")
            return 0
        } else {
            return withdraw(amount)
        }
    }

    fun deposit(amount: Int): Int {
        accountBalance += amount
        println("You successfully deposited $amount dollars. The checking balance is $accountBalance dollars.")
        return amount
    }

    fun creditDeposit(amount: Int): Int {
        if (accountBalance == 0) {
            println("This account is completely paid off! Do not deposit money!")
            return accountBalance
        } else if (accountBalance + amount > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is ${accountBalance} dollars.")
            return 0
        } else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid off this account!")
            return amount
        } else {
            return deposit(amount)
        }
    }

    fun transfer(mode:String){
        val transferAmount:Int
        when (mode){
            "withdraw" -> {
                if(accountType == "debit"){
                    transferAmount = debitWithdraw(money)
                }
                else {
                    transferAmount = withdraw(money)
                }
                println("The money you have withdrew is $transferAmount")
            }
            "deposit" -> {
                if(accountType == "credit"){
                    transferAmount = creditDeposit(money)
                }
                else {
                    transferAmount = deposit(money)
                }
                println("The amount you deposited is $transferAmount dollars.")
            }
            else -> return

        }
    }

    while (isSystemOpen == true) {
        println("What do you want to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? 1 2 3 4")
        option = readln().toInt()

        when (option) {
            1 -> println("The current balance is $accountBalance dollars")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }

            else -> continue

        }
    }




}

