import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    val input: String? = sc.nextLine()
    var stack = 0
    var total = 0
    var preStatus = false

    for(i in 0..input?.length!!-1){
        if(input.get(i)!! == '('){
            preStatus = true
            stack++ //push
        }else {
            if(preStatus){
                //레이저
                stack-- //pop
                total += stack
            } else {
                //레이저가 아닐 때
                stack--
                total++
            }
            preStatus = false
        }
    }
    println(total)
}