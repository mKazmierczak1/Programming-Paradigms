(* Micha³ Ka¼mierczak *)
(* Zadanie 1 *)
(* a) *)

type 'a t =  'a list
exception Empty of string          
let empty () = []
let enqueue (e, q) = q @ [e] 
let dequeue = function
  | [] -> []
  | h :: t -> t
let first = function
  | [] -> raise(Empty "module Queue_Fun_List: first")
  | h :: t -> h
let isEmpty q = q = []    

