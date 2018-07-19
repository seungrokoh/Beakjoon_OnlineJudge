import java.util.*

fun main(args: Array<String>) {
    val arr = arrayOfNulls<String>(5)
    var maxLen = 0

    val sc = Scanner(System.`in`)
    for (i in 0..4) {
        arr.set(i, sc.nextLine())
        if(arr[i]?.length!! > maxLen)
            maxLen = arr[i]!!.length
    }

    for (row in 0..(maxLen - 1)) {
        for (col in 0..arr.size - 1) {
            if (arr[col]?.length!! > row) {
                print(arr.get(col)?.get(row))
            }
        }
    }
}