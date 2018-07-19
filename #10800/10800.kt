import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val numOfBall = sc.nextInt()
    val color = arrayOfNulls<Int>(numOfBall)
    val ballSize = arrayOfNulls<Int>(numOfBall)
    var sum: Int = 0
    //init
    for (i in 0..numOfBall - 1) {
        color.set(i, sc.nextInt())
        ballSize.set(i, sc.nextInt())
    }


    for (i in 0..numOfBall - 1) {
        sum = 0
        for (j in 0..numOfBall - 1) {
            if ((color.get(i)!! != color.get(j)!!)) {
                if((ballSize.get(i)!! > ballSize.get(j)!!)){
                    sum += ballSize.get(j)!!
                }
            }
        }
        println(sum)
    }
}