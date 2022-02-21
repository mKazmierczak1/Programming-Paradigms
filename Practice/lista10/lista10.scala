// Michał Kaźmierczak
import scala.collection.mutable.Seq

class lista10 {

// zadanie 3
  class UnderflowException(msg: String) extends Exception(msg)

  class Queue_Fun_Double_List[+T] private (private val queue: (List[T], List[T])):

    def enqueue[S >: T](e: S): Queue_Fun_Double_List[S] =
      queue match
        case (Nil, Nil) => new Queue_Fun_Double_List[S](List(e), Nil)
        case (l1, l2) => new Queue_Fun_Double_List[S](l1, e :: l2)

    def dequeue: Queue_Fun_Double_List[T] =
      queue match
        case (Nil, Nil) => this
        case (h1 :: t1, l2) => if t1 == Nil then new Queue_Fun_Double_List[T](l2.reverse, Nil) else new Queue_Fun_Double_List[T](t1, l2)

    def first: T =
      queue match
        case (Nil, Nil) => throw new UnderflowException("Queue_Fun_Double_List: first")
        case (h1 :: t1, _) => h1

    def isEmpty: Boolean =
      queue match
        case (Nil, Nil) => true
        case (_, _) => false

  object Queue_Fun_Double_List:
    def apply[T](xs: T*) = new Queue_Fun_Double_List[T](xs.toList, Nil)
    def empty[T] = new Queue_Fun_Double_List[T](Nil, Nil)

// zadanie 4
  def copy[T](dest: Seq[T], src: Seq[T]): Unit =
    require(dest.length >= src.length)
    var i = 0
    src.foreach(e => { dest.update(i, e); i += 1 })

}
