// Michał Kaźmierczak

//  zadanie 1
def flatten1[A](xss: List[List[A]]): List[A] =
  if xss == Nil then Nil else xss.head ++ flatten1(xss.tail)

flatten1(List(List(5,6), List(1,2,3))) == List(5, 6, 1, 2, 3)
flatten1(List(List("Ala", "ma", "kota"))) == List("Ala", "ma", "kota")
flatten1(Nil) == List()

// zadanie 2
def count[A] (x: A, xs: List[A]): Int =
  if xs == Nil then 0
  else (if xs.head == x then 1 else 0) + count(x, xs.tail)

count('a', List('a', 'l', 'a')) == 2
count(1, List(1, 1, 2, 3, 1)) == 3
count("a", List("a", "b", "c", "d", "e")) == 1

// zadanie 3
def replicate[A] (x: A, n: Int): List[A] =
  if (n < 0) then throw new Exception("Ujemna liczba powtorzen.")
  if n == 0 then Nil else x :: replicate(x, n - 1)

replicate("la" , 3)  == List("la", "la", "la")
replicate(5 , 4) == List(5, 5, 5, 5)
//replicate("la" , -1) Wyjątek: "Ujemna liczba powtorzen."

// zadanie 4
def sqrList(xs: List[Int]): List[Int] =
  if xs == Nil then Nil else xs.head * xs.head :: sqrList(xs.tail)

val sqrListF = (xs: List[Int]) =>
  if xs == Nil then Nil else xs.head * xs.head :: sqrList(xs.tail)

sqrList(List(1 , 2, 3, -4)) == List(1, 4, 9, 16)
sqrList(Nil) == List()

sqrListF(List(1 , 2, 3, -4)) == List(1, 4, 9, 16)
sqrListF(Nil) == List()

// zadanie 5
def palindrome[A] (xs: List[A]): Boolean =
  xs == xs.reverse

palindrome(List("a", "l", "a")) == true
palindrome(List("k", "a", "j", "a", "k")) == true
palindrome(List(1, 2, 3)) == false

// zadanie 6
def listLength[A](xs: List[A]): Int =
  if xs == Nil then 0 else 1 + listLength(xs.tail)

listLength(List(1, 1, 1, 1, 1)) == 5