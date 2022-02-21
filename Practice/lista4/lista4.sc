// Michał Kaźmierczak

//  zadanie 3
sealed trait BT[+A]
  case object Empty extends BT[Nothing]
  case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val tt = Node(1,
  Node(2,
    Node(4,
      Empty,
      Empty
    ),
    Empty
  ),
  Node(3,
    Node(5,
      Empty,
      Node(6,
        Empty,
        Empty
      )
    ),
    Empty
  )
)

def breadthBT[A] (bt: BT[A]) =
  def breadthBTin (xs: List[BT[A]]): List[A] =
    xs match
      case Nil => Nil
      case Empty :: t => breadthBTin(t)
      case Node(v, l, r) :: t => v :: breadthBTin(t ::: List(l, r))
  breadthBTin(List(bt))

breadthBT(tt) == List(1, 2, 3, 4, 5, 6)

//  zadanie 5
sealed trait Graphs[A]
 case class Graph[A](succ: A=>List[A]) extends Graphs[A]

val g = Graph((i: Int) =>
  i match
   case 0 => List(3)
   case 1 => List(0, 2, 4)
   case 2 => List(1)
   case 3 => Nil
   case 4 => List(0, 2)
   case n => throw new Exception(s"Graph g: node $n doesn't exist")
  )

def depthSearch[A] (g: Graph[A]) (startNode: A): List[A] =
  def search(visited: List[A])(queue: List[A]): List[A] =
    queue match
      case Nil => Nil
      case h :: t => if visited contains h then search(visited)(t)
                     else h :: search(h :: visited)((g succ h) ::: t)
  search (Nil) (List(startNode))

depthSearch(g) (4) == List(4, 0, 3, 2, 1)