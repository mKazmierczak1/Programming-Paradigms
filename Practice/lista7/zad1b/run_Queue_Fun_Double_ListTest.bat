ocamlc -c Queue_Fun_Double_List.mli 
ocamlc -c Queue_Fun_Double_List.ml
ocamlc -c Queue_Fun_Double_ListTest.ml
ocamlc -o Queue_Fun_Double_ListTest Queue_Fun_Double_List.cmo Queue_Fun_Double_ListTest.cmo
ocamlrun Queue_Fun_Double_ListTest
