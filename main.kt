open class BCSDLab(val emoji: String, val name: String)

class Beginner(emoji: String, name: String, val fail: Int) : BCSDLab(emoji, name){
    fun printStatus() {
        println(emoji + name + " Number of fail: " + fail)
    }
}

class Regular(emoji: String, name: String, val pay: Boolean) : BCSDLab(emoji, name){
    fun printStatus() {
        val payment = if(pay == true) "done" else "unpaid"
        println(emoji + name + " payment of membership fees: " + payment)
    }
}

class Mentor(emoji: String, name: String, val email: String?) : BCSDLab(emoji, name){
    fun printStatus() {
        val mail = if (email.isNullOrEmpty()) "None" else email
        println(emoji + name + " email: " + mail)
    }
}

fun main(){
    val beginner = Beginner("sprout", "Yeran", 2)
    val regular = Regular("greenapple", "yeran", true)
    val mentor = Mentor("star", "yeran", "@gmail")

    /*val mentor = Mentor("0x1F31F", "yeran", "@gmail")

    binding.textView.text = unicodeText*/

    beginner.printStatus()
    regular.printStatus()
    mentor.printStatus()
}