fun main(args: Array<String>) {
    val result = wasOnline(180)
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

fun calculationMinutes(time: Int) {
    val timeMinutes = (time / 60).toInt()
    when ((time / 60).toInt() % 10) {
        1 -> timeMinutes.toString() + "минуту"
        in 2..4 -> timeMinutes.toString() + "минуты"
        in 5..9 -> timeMinutes.toString() + "минут"
        0 -> timeMinutes.toString() + "минут"
    }
}

fun calculationHours(time: Int) {
    val timeHour = (time / 3600).toInt()
    when ((time / 3600).toInt() % 10) {
        1 -> timeHour.toString() + "час"
        in 2..4 -> timeHour.toString() + "часа"
        in 5..9 -> timeHour.toString() + "часов"
    }
}