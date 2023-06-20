fun main(args: Array<String>) {
    val result = wasOnline(65006)
    println("Пользователь был в сети : $result")

}

fun wasOnline(time: Int) = when (time) {
    in 0..60 -> "только что"
    in 61..3600 -> calculationMinutes(time).toString() + " назад"
    in 3601..24 * 3600 -> calculationHours(time).toString() + " назад"
    in 24 * 360 + 1..48 * 3600 -> "вчера"
    in 48 * 3600 + 1..72 * 3600 -> "позавчера"
    else -> "давно"
}

fun calculationMinutes(time: Int): String {
    val timeMinutes = (time / 60).toInt()
    val minutes = when ((time / 60).toInt() % 10) {
        1 -> "$timeMinutes минуту"
        in 2..4 -> "$timeMinutes минуты"
        in 5..9 -> "$timeMinutes минут"
        else -> "$timeMinutes минут"
    }
    return minutes
}

fun calculationHours(time: Int): String {
    val timeHour = (time / 3600).toInt()
    val hour = when ((time / 3600).toInt() % 10) {
        in 2..4 -> "$timeHour часа"
        in 5..9 -> "$timeHour часов"
        else -> "$timeHour час"
    }
    return hour
}