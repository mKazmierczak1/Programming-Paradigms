ocamlc -c Queue_Mut.mli 
ocamlc -c Queue_Mut.ml
ocamlc -c Queue_MutTest.ml
ocamlc -o Queue_MutTest Queue_Mut.cmo Queue_MutTest.cmo
ocamlrun Queue_MutTest
