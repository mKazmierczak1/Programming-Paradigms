(*Micha³ Ka¼mierczak*)

(* zadanie 3 *)
let rec sumProd xs = List.fold_left (fun sp x -> match sp with (s, p) -> (s + x, p * x)) (0, 1) xs;;             
sumProd [1; 2; 3; 4] = (10, 24);;
sumProd [10; -5; -13; 9] = (1, 5850);;
sumProd [1] = (1, 1);;
                     
(* zadanie 5 *)
(* a) *)
let insertionsort f xs =
  let rec insert orderedList element =
    match orderedList with
    |[] -> [element]
    |h :: t -> if f element h then h :: insert t element
               else element :: orderedList
  in List.fold_left(insert)([]) xs;;


insertionsort(fun a b -> (a > b)) [2; 5; 3; 6; 4; 7; 2; 1] = [1; 2; 2; 3; 4; 5; 6; 7];;
insertionsort(fun a b -> (a < b)) [2; 5; 3; 6; 4; 7; 2; 1] = [7; 6; 5; 4; 3; 2; 2; 1];;

