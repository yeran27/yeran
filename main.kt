open class BcsdLabUser(val emoji: String, val name: String)

class Beginner(emoji: String, name: String, val fail: Int) : BcsdLabUser(emoji, name) {
    fun printStatus() {
        println(emoji +" "+ name + " Number of fail: " + fail)
    }
}

class Regular(emoji: String, name: String, val pay: Boolean) : BcsdLabUser(emoji, name) {
    fun printStatus() {
        val payment = if (pay) "paid" else "unpaid"
        println(emoji + " "+ name + " payment of membership fees: " + payment)
    }
}

class Mentor(emoji: String, name: String, val email: String?) : BcsdLabUser(emoji, name) {
    fun printStatus() {
        val mail = if (email.isNullOrEmpty()) "None" else email
        println(emoji + " "+ name + " email: " + mail)
    }
}

fun main() {
    val users: List<BcsdLabUser> = listOf(
        Beginner("🌱", "KimYeran", 0),
        Beginner("🌱", "LeeYejin", 1),
        Beginner("🌱", "ParkYerin", 2),
        Beginner("🌱", "YangYechan", 3),
        Regular("🍏", "ChoiYein", false),
        Regular("🍏", "JungYehan", false),
        Regular("🍏", "HanYesung", true),
        Mentor("⭐", "YangYewon", "yang@gmail.com"),
        Mentor("⭐", "NaYeyoung", null)
    )

    println("All Beginners: ")
    for (user in users) {
        if (user is Beginner) {
            user.printStatus()
        }
    }

    println("\nBeginners who failed 3 or more tasks: ")
    for (user in users) {
        if (user is Beginner)
            if (user.fail >= 3){
                user.printStatus()
        }
    }

    println("\nRegular members who haven't paid: ")
    for (user in users){
        if (user is Regular) {
            if (!user.pay) {
                user.printStatus()
            }
        }
    }

    println("\nUsers with last name 'Yang':")
    for (user in users) {
        if (user.name.startsWith("Yang")) {
            if (user is Beginner) {
                user.printStatus()
            }
            else if (user is Regular) {
                user.printStatus()
            }
            else if (user is Mentor) {
                user.printStatus()
            }
        }
    }
}
