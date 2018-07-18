import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val target = sc.nextInt()
    var count = 0
    for(i in 1..5){
        if(sc.nextInt() == target) count++
    }
    println(count)
}
