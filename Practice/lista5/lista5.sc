// Michał Kaźmierczak

//  zadanie 1
def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] =
  def lrepeatIn(k2: Int)(lxs2: LazyList[A]): LazyList[A] =
    (k2, lxs2) match
    case (_, LazyList()) => LazyList[A]()
    case (1, x #:: t) => x #:: (lrepeatIn(k)(t))
    case (_, x #:: _) => x #:: (lrepeatIn(k2 - 1)(lxs2))
  lrepeatIn(k)(lxs)

lrepeat(3)(LazyList('a','b','c','d')).toList == List('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd')
lrepeat(3)(LazyList.from(1)).take(15).toList == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
lrepeat(3)(LazyList()).take(15).toList == List()


//  zadanie 2
val lfib: LazyList[Int] =
  def lfibIn(f1: Int, f2: Int): LazyList[Int] =
    f1 #:: lfibIn(f2, f1 + f2)
  lfibIn(0, 1)

lfib.take(0).toList == List()
lfib.take(2).toList == List(0, 1)
lfib.take(9).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21)


// Zadanie 3
sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

//a)
def lBreadth[A] (ltree: lBT[A]) =
  def lBreadthIn (xs: List[lBT[A]]): LazyList[A] =
    xs match
      case Nil => LazyList()
      case LEmpty :: t => lBreadthIn(t)
      case LNode(v, l, r) :: t => v #:: (lBreadthIn(t ::: List(l(), r())))
  lBreadthIn(List(ltree))


//b)
def lTree(n: Int): lBT[Int] =
  LNode(n, () => lTree(n * 2), () => lTree(n * 2 + 1))

lBreadth(lTree(1)).take(20).toList == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
lBreadth(LEmpty).take(20).toList == List()