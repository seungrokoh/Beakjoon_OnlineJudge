import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    var cardList: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    var start = 0
    var end = 0

    for(i in 0..9){
        start = sc.nextInt() - 1
        end = sc.nextInt() - 1
        for (j in 1..(end - start + 1) / 2) {
            val temp = cardList[start]
            cardList[start] = cardList[end]
            cardList[end] = temp
            start++
            end--
        }
    }

    for(i in 0..19){
        print(cardList[i])
        print(" ")
    }

}