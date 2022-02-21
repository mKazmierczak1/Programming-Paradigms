ocamlc -c Queue_Fun_List.mli 
ocamlc -c Queue_Fun_List.ml
ocamlc -c Queue_Fun_ListTest.ml
ocamlc -o Queue_Fun_ListTest Queue_Fun_List.cmo Queue_Fun_ListTest.cmo
ocamlrun Queue_Fun_ListTest
