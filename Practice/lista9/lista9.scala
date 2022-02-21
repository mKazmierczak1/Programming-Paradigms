// Michał Kaźmierczak

class lista9 {
// zadanie 1
  class Time_zad1 (private var h: Int):
    if h < 0 then h = 0

    def hour: Int = h
    def hour_= (newHour: Int): Unit =
      if h < 0 then h = 0 else h = newHour

// zadanie 2
// a)
  class Time_zad2a (private var h: Int, private var m: Int):
    require(0 <= h && h < 24, s"h = $h")
    require(0 <= m && m < 60, s"m = $m")

    def hour: Int = h
    def hour_= (newHour: Int): Unit =
      require(0 <= newHour && newHour < 24, s"newHour = $newHour")
      h = newHour

    def minute: Int = m
    def minute_= (newMinute: Int): Unit =
      require(0 <= newMinute && newMinute < 60, s"newMinute = $newMinute")
      m = newMinute

    def before(other: Time_zad2a): Boolean =
      (h * 60 + m) < (other.h * 60 + other.m)

// b)
  class Time_zad2b (private var h: Int, private var m: Int):
    require(0 <= h && h < 24, s"h = $h")
    require(0 <= m && m < 60, s"m = $m")

    private var minutesAfterMidnight: Int = h * 60 + m

    def hour: Int = minutesAfterMidnight / 60
    def hour_= (newHour: Int): Unit =
      require(0 <= newHour && newHour < 24, s"newHour = $newHour")
      minutesAfterMidnight = newHour * 60 + minute

    def minute: Int = minutesAfterMidnight % 60
    def minute_= (newMinute: Int): Unit =
      require(0 <= newMinute && newMinute < 60, s"newMinute = $newMinute")
      minutesAfterMidnight = hour + newMinute

    def before(other: Time_zad2b): Boolean =
      minutesAfterMidnight < other.minutesAfterMidnight

// zadanie 3
  class Pojazd(private val nazwaProducenta: String, private val model: String, private var rok: Int = -1, private val rejestracja: String = ""):
    override def toString: String = nazwaProducenta  + " " + model + " " + rok + " " + rejestracja

}
