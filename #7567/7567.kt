import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val input = sc.nextLine()
    var sum = 10

    for (i in 1..input.length - 1) {
        if (input.get(i).equals(input.get(i - 1))) {
            sum += 5
        } else {
            sum += 10
        }
    }

    print(sum)
}