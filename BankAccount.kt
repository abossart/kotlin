

fun main(){
    println("Welcome to your banking system.")
    var accountType:String = ""
    var userChoice:Int = 0

    println("what type of account would you like to create? \n" +
            "1. Debit Account\n" +
            "2. Credit Account\n" +
            "3. Checking account")
    userChoice = readln().toInt()



    when (userChoice) {
        1 -> accountType = "Debit"
        2 -> accountType = "Credit"
        3 -> accountType = "Checking"
        else -> accountType = "not a valid input"
    }


    println("The selected option is $userChoice and account type selected is $accountType")

    var accountBalance = 99 //(0..1000).random()
    val money = (0..1000).random()
    println("The value of the balance is $accountBalance and the money value $money")

    fun withdraw(amount:Int):Int{
        accountBalance -= amount
        println("Withdrawn $amount. New balance is $accountBalance")
        return amount

    }

    fun debitWithdraw(amount:Int):Int{
        if (amount > accountBalance){
            println("Balance is not high enough. Can't withdraw money")
            return 0
        }
        if (accountBalance == 0){
            println("No money on this account. Can't withdraw money")
            return 0
        }
        else {
            return withdraw(amount)
        }

    }

    fun deposit(amount:Int):Int{
        accountBalance += amount
        println("Deposit of $amount. New balance is $accountBalance")
        return amount
    }

    fun creditDeposit(amount:Int):Int{
        if (accountBalance == 0){
            println("You don t need to deposit anything in oder to pay off the account since it is already paid off")
            return accountBalance
        }
        else {
            if (accountBalance+amount >0){
                println("Deposit failed, you tried to pay off an amount greater thanthe credit balance.\n" +
                        "the checking balance is $accountBalance")
                return 0
            }
            if(amount == -accountBalance){
                accountBalance = 0
                println("You have paid off this account!")
                return amount
            }
            else{
                return deposit(amount)
            }
        }
    }

    var output = 0

    output = withdraw(200)

    //output = debitWithdraw(50)

    output = deposit(60)

    output = creditDeposit(39)





}