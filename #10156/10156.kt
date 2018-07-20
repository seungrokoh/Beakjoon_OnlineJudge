import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val price: Int = sc.nextInt()
    val numOfSnack: Int = sc.nextInt()
    val money: Int = sc.nextInt()

    if ((numOfSnack * price) > money) {
        print((numOfSnack * price) - money)
    } else {
        print(0)
    }
}