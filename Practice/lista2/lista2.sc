import scala.annotation.tailrec
// Michał Kaźmierczak

//  zadanie 2
def fib (n: Int): Int =
  n match
    case 0 => 0
    case 1 => 1
    case _ => if n > 0 then fib(n - 1) + fib(n - 2) else throw new Exception("Ujemny argument!")

fib(4) == 3
//fib(-2) Wyjątek: "Ujemny argument!"
fib(42) == 267914296

def fibTail (n: Int): Int = {
  @tailrec
  def fibIter(n: Int, fib1: Int, fib2: Int): Int =
    n match
      case 0 => fib1
      case 1 => fib2
      case _ => fibIter(n - 1, fib2, fib1 + fib2)

  if n > 0 then fibIter(n, 0, 1) else throw new Exception("Ujemny argument!")
}

fibTail(4) == 3
//fib(-2) Wyjątek: "Ujemny argument!"
fibTail(42) == 267914296

//  zadanie 3
//metoda
def root3 (a: Double): Double =
  @tailrec
  def root3Iter (x: Double): Double =
    if math.abs((x * x * x) - a) <= 0.000000000000001 * Math.abs(a) then x
    else root3Iter(x + (a / (x * x) - x) / 3)

  root3Iter(if a <= 1 then a else a/3)

//funkcja
val root3F = (a: Double) =>
  @tailrec
  def root3FIter (x: Double): Double =
    if math.abs((x * x * x) - a) <= 0.000000000000001 * Math.abs(a) then x
    else root3FIter(x + (a / (x * x) - x) / 3)

  root3FIter(if a <= 1 then a else a/3)

root3(2197) > 12.9 &&  root3(2197) < 13.1
root3F(2197) > 12.9 &&  root3(2197) < 13.1

//  zadanie 4
val List(_, _, x_a, _, _) = List(-2, -1, 0, 1, 2)
val List((_, _), (x_b, _)) = List((1,2), (0,1))

x_a == 0
x_b == 0

//  zadanie 5
def initSegment[A](xs: List[A], ys: List[A]): Boolean =
  (xs, ys) match
    case (Nil, _) => true
    case (_, Nil) => false
    case _ => if xs.head == ys.head then initSegment(xs.tail, ys.tail) else false

initSegment(List(1, 2), List(1, 2, 3, 5, 7)) == true
initSegment(List("ab", "bc"), List("cd")) == false
initSegment(List(2.3, 5.6), List(2.3)) == false