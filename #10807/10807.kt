import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    var num = sc.nextInt()

    var numList = arrayOfNulls<Int>(num)

    for (i in 0..num - 1) {
        numList.set(i, sc.nextInt())
    }
    val target = sc.nextInt()

    print(numList.filter { it == target}.count())
}