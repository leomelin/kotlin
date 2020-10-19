fun test(): Boolean {
    var flag = false
    for(i in 0..5) {
        when (i) {
            1 -> Unit
            2 -> Unit
            4 -> Unit
            6 -> Unit
            3 -> {
                flag = true
                break
            }
            else -> flag = false
        }
    }

    return flag
}

fun box(): String {
    val flag = test()
    return if (flag) "OK" else "fail1"
}