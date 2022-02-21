(* Micha³ Ka¼mierczak *)


(* zadanie 1 *)
let rec flatten1 xss =
  if xss == [] then [] else List.hd xss @ flatten1(List.tl xss);;

flatten1([[5; 6]; [1; 2; 3]]) = [5; 6; 1; 2; 3];;
flatten1([["Ala"; "ma"; "kota"]]) = ["Ala"; "ma"; "kota"];;
flatten1([]) = [];;

(* zadanie 2 *)
let rec count (x, xs)  =
  if xs == [] then 0 else (if List.hd xs = x then 1 else 0) + count(x, List.tl xs);;

count('a', ['a'; 'l'; 'a']) = 2;;
count(1, [1; 1; 2; 3; 1]) = 3;;
count("a", ["a"; "b"; "c"; "d"; "e"]) = 1;;

(* zadanie 3 *)
let rec replicate (x, n)  =
  if n < 0 then failwith "Ujemna liczba powtorzen."
  else if n = 0 then [] else x :: replicate(x, n - 1);;                

replicate("la", 3) = ["la"; "la"; "la"];;
(* replicate("la", -1);; Wyjatek: "Ujemna liczba powtorzen" *)
                     
(* zadanie 4 *)
let rec sqrList xs =
  if xs == [] then [] else List.hd xs * List.hd xs :: sqrList(List.tl  xs);;

sqrList([1; 2; 3; -4]) = [1; 4; 9; 16];;
sqrList([]) = [];;

(* zadanie 5 *)
let palindrome xs =
  xs = List.rev  xs;;

palindrome(["a"; "l"; "a"]) = true;;
palindrome(["k"; "a"; "j"; "a"; "k"]) = true;;
palindrome([1; 2; 3]) = false;;

(* zadanie 6 *)
let rec listLength xs =
  if xs = [] then 0 else 1 + listLength(List.tl xs);;

listLength([1; 1; 1; 1; 1]) = 5;;
