import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val numOfBall = sc.nextInt()
    val color = arrayOfNulls<Int>(numOfBall)
    val ballSize = arrayOfNulls<Int>(numOfBall)
    var score = IntArray(numOfBall, {0})

    var sum: Int = 0
    //init
    for (i in 0..numOfBall - 1) {
        color.set(i, sc.nextInt())
        ballSize.set(i, sc.nextInt())
    }

    for (i in 0..numOfBall - 2) {
        for (j in (i + 1)..numOfBall - 1) {
            if ((color.get(i)!! != color.get(j)!!)) {
                //색상이 다를 때
                if (ballSize.get(i)!! > ballSize.get(j)!!) {
                    //나보다 작을 때
                    score.set(i, score.get(i)!! + ballSize.get(j)!!)
                }else {
                    //나보다 클 때
                    score.set(j, score.get(j)!! + ballSize.get(i)!!)
                }
            }
        }
    }
    for (i in 0..numOfBall - 1) {
        println(score.get(i))
    }
}
