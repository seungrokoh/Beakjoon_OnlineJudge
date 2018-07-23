import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val T = sc.nextInt()
    var a = 0
    var b = 0
    var sum = 1

    for (i in 1..T) {
        a = sc.nextInt()
        b = sc.nextInt()
        sum = 1
        for (j in 1..b) {
            sum *= a
            sum %= 10
        }
        if(sum == 0){
            println(10)
        } else {
            println(sum)
        }
    }

}