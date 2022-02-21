(* Micha³ Ka¼mierczak *)
(* Zadanie 2 *)

type 'a t =  { mutable a: 'a option array; mutable f: int; mutable r: int }
exception Empty of string
exception Full of string
                
let empty n = { a = Array.make (n + 1) None; f = 0; r = 0 }

let isEmpty q = q.f = q.r
              
let isFull q  = Array.length q.a - 1 = q.r - q.f || q.f - q.r = 1
            
let enqueue (e, q) =
  if (isFull q) then raise (Full "module Queue_Mut: enqueue")
  else
    q.a.(q.r) <- Some e;
    q.r <- (q.r + 1) mod (Array.length q.a)
  
let dequeue q = 
  if isEmpty q then ()
  else
    q.f <- (q.f + 1) mod (Array.length q.a)
  
let first q =
   if isEmpty q then raise (Empty "module Queue_Mut: first")
   else
     match q.a.(q.f) with
     | Some e -> e
     | None -> failwith "module Queue_Mut: first"
