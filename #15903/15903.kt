import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val n = sc.nextInt()
    val m = sc.nextLong()
    var arr: Array<Long?> = arrayOfNulls<Long>(n)
    var result = 0L
    for (i in 0..n - 1) {
        arr[i] = sc.nextLong()
    }

    for (i in 1..m) {
        arr.sort()
        arr.set(0, arr.get(0)!! + arr.get(1)!!)
        arr.set(1,arr.get(0)!!)
    }

    for (i in 0..n - 1) {
        result += arr.get(i)!!
    }

    print(result)
}