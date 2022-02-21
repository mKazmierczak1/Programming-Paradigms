(*Micha³ Ka¼mierczak*)

(* zadanie 2 *)
let rec f x = f x;;

(* zadanie 3 *)
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let tt = Node(1,
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
 );; 

let breadthBT bt =
  let rec breadthBTin = function
    | [] -> []
    | Empty :: t -> breadthBTin t
    | Node(v, l, r) :: t  ->  v :: breadthBTin (t @ [l; r])
  in breadthBTin [bt];;

breadthBT tt = [1; 2; 3; 4; 5; 6];;

(* zadanie 5 *)
type 'a graph = Graph of ('a -> 'a list);;

let g = Graph
 (function
   0 -> [3]
  | 1 -> [0;2;4]
  | 2 -> [1]
  | 3 -> []
  | 4 -> [0;2]
  | n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist"));;


let breadthSearch (Graph succ) startNode =
  let rec search visited queue =
    match queue with
    | [] -> []
    | h :: t -> if List.mem h visited then search visited t
                else h :: search (h :: visited) (succ h @ t)
  in search [] [startNode];;

breadthSearch g 4 = [4; 0; 3; 2; 1];;
