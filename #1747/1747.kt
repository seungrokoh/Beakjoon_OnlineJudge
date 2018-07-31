import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val num = sc.nextInt()
    val max_num = 1000000

    var count = 0

    if (num == 1) {
        print(1)
        return
    }
    for (i in num..max_num) {
        var str = i.toString()
        if (str.length < 3) {
            continue
        }
        for (j in 2..i) {
            //소수체크
            if (i % j == 0) {
                count++
            }
        }
        if (count == 1) {
            //소수일경우
            if (str.equals(str.reversed())) {
                print(str)
                return
            }
        }
        count = 0
    }
}