(* Micha³ Ka¼mierczak *)

type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k + 1)));;

let rec toLazyList = function
    | [] -> LNil
    | x :: xs -> LCons (x, lazy (toLazyList xs));;

let rec ltake = function
    | (0, _) -> []
    | (_, LNil) -> []
    | (n, LCons (x, lazy xs)) -> x :: ltake (n-1, xs);;


(* zadanie 1 *)
let lrepeat k lxs =
  let rec lrepeatIn k2 lxs2 =
    match (k2, lxs2) with
    |(_, LNil) -> LNil
    |(1, LCons (x, lazy t)) -> LCons (x, lazy (lrepeatIn k t))
    |(_, LCons (x, _)) -> LCons (x, lazy (lrepeatIn (k2 - 1) lxs2))
  in lrepeatIn(k)(lxs);;

ltake(12, (lrepeat 3 (toLazyList ['a'; 'b'; 'c'; 'd']))) = ['a'; 'a'; 'a'; 'b'; 'b'; 'b'; 'c'; 'c'; 'c'; 'd'; 'd'; 'd'];;
ltake(15, (lrepeat 3 (lfrom 1))) = [1; 1; 1; 2; 2; 2; 3; 3; 3; 4; 4; 4; 5; 5; 5];;
ltake(15, (lrepeat 3 LNil)) = [];;


(* zadanie 2 *)                                                    
let lfib =
  let rec lfibIn f1 f2 = LCons (f1, lazy (lfibIn f2 (f1 + f2))) in lfibIn 0 1;;
                                                        
ltake(0, lfib) = [];;
ltake(2, lfib) = [0; 1];;
ltake(9, lfib) = [0; 1; 1; 2; 3; 5; 8; 13; 21];;


(* zadanie 3 *)  
type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT) * (unit -> 'a lBT);;

(* a) *)
let lBreadth lbt =
  let rec lBreadthIn = function
    | [] -> LNil
    | LEmpty :: t -> lBreadthIn t
    | LNode(v, l, r) :: t  -> LCons (v, lazy (lBreadthIn (t @ [l(); r()])))
  in lBreadthIn [lbt];;                                                      

(* b) *)
let rec lTree n =
  LNode(n, (function () -> lTree (2 * n)), function () -> lTree (2 * n + 1));;

ltake (20, lBreadth (lTree 1)) = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20];;
ltake (20, lBreadth LEmpty) = [];;
