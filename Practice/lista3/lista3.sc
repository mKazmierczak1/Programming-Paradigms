// Michał Kaźmierczak

//  zadanie 3
def sumProd (xs: List[Int]): (Int,Int) =
  xs.foldLeft(0, 1) ((sp, x) => sp match {case (s, p) => (s + x, p * x)})

sumProd(List(1, 2, 3, 4)) ==  (10, 24)
sumProd(List(1)) == (1, 1)
sumProd(List(10, -5, -13, 9)) == (1, 5850)

//  zadanie 5
//a)
def insertionsort[A] (f: (A, A) => Boolean, xs: List[A]): List[A] =
  def insert (orderedList: List[A], element: A): List[A] =
    orderedList match
      case Nil => List(element)
      case h :: t => if f(element, h) then h :: insert(t, element)
                     else element :: orderedList

  xs.foldLeft(List[A]())(insert)


insertionsort((a:Int, b:Int) => (a > b), List(2, 5, 3, 6, 4, 7, 2, 1)) == List(1, 2, 2, 3, 4, 5, 6, 7)
insertionsort((a:Int, b:Int) => (a < b), List(2, 5, 3, 6, 4, 7, 2, 1)) == List(7, 6, 5, 4, 3, 2, 2, 1)
