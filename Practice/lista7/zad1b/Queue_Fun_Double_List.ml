(* Micha³ Ka¼mierczak *)
(* Zadanie 1 *)
(* b) *)

type 'a t =  'a list * 'a list
exception Empty of string          
let empty () = ([], [])
let enqueue (e, q) =
  match q with
  | ([], []) -> ([e], [])
  | (l1, l2) -> (l1, e :: l2)
let dequeue = function
  | ([], []) -> ([], [])          
  | (h1 :: t1, l2) -> if t1 = [] then (List.rev l2, []) else (t1, l2)
let first = function
  | ([], []) -> raise(Empty "module Queue_Fun_Double_List: first")
  | (h1 :: t1, _) -> h1
let isEmpty = function
  | ([], []) -> true
  | (_, _) -> false

