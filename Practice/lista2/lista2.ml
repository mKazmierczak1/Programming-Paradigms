(* Micha³ Ka¼mierczak *)

(*  zadanie 2  *)
let rec fib n =
  match n with
    0 -> 0
   | 1 -> 1
   | _ -> if n > 0 then fib(n - 1) + fib(n - 2) else failwith "Ujemny argument!";;

fib(4) = 3;;
(* fib(-2);; Wyjatek: "Ujemny argument" *)
fib(42) = 267914296;;

let fibTail n =
  let rec fibIter (n, fib1, fib2) =
    match n with
      0 -> fib1
     |1 -> fib2
     |_ -> fibIter(n - 1, fib2, fib1 + fib2) in

  if n > 0 then fibIter(n, 0, 1) else failwith "Ujemny argument!";;


fibTail(4) = 3;;
(* fib(-2);; Wyjatek: "Ujemny argument" *)
fibTail(42) = 267914296;;

(*  zadanie 3  *)
let root3 a =
  let rec root3Iter x =
    if abs_float(x ** 3. -. a) <= 0.000000000000001 *. abs_float(a) then x
    else root3Iter(x +. (a /. x ** 2. -. x) /. 3.) in
  root3Iter(if a <= 1. then a else a /. 3.)
;;

root3(2197.) > 12.9 && root3(2197.) < 13.1;;

(*  zadanie 4  *)
let match_A a = 
    let [_; _; x; _; _] = a in x;;

match_A ([-2; -1; 0; 1; 2]) == 0;; 

let match_B b = 
    let [(_, _); (x, _)] = b in x;;

match_B ([(1,2); (0,1)]) == 0;;
      
(*  zadanie 5  *)
let rec initSegment (xs, ys) =
  match (xs, ys) with
    ([], _) -> true
    |(_, []) -> false
    | _ -> if List.hd xs = List.hd ys then initSegment(List.tl xs,List.tl ys) else false;;

initSegment([1; 2], [1; 2; 3; 5; 7]) = true;;
initSegment(["ab"; "bc"], ["cd"]) = false;;
initSegment([2.3; 5.6], [2.3]) = false;;
  
                               
