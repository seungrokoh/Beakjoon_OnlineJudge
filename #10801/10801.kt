import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val player1: List<String> = sc.nextLine().split(" ")
    val player2: List<String> = sc.nextLine().split(" ")

    var counta: Int = 0
    var countb: Int = 0

    loop@ for (round in 0..9) {
        if (player1.get(round).toInt() == player2.get(round).toInt())
            continue
        if(player1.get(round).toInt() > player2.get(round).toInt()){
            counta++
        } else {
            countb++
        }
    }

    if(counta == countb) print("D")
    else if(counta > countb) print("A")
    else print("B")
}