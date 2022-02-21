(* Micha³ Ka¼mierczak *)
(* Zadanie 1 *)
(* a) *)

let menu (opt) =
  let numItems = Array.length opt-1
  in
    begin
      print_string "\n\n=================================================== \n";
      print_string opt.(0);print_newline();
      for i=1 to numItems do  print_int i; print_string (". "^opt.(i)); print_newline() done;
      print_string "\nSelect an option: ";
      flush stdout;
      let choice = ref (read_int())
      in 
	while !choice < 1 || !choice > numItems do 
	  print_string ("Choose number between 1 and " ^ string_of_int numItems ^ ": ");
	  choice := read_int();
	done; 
	!choice
    end
;;

let q = ref (Queue_Fun_List.empty());;
let menuItems = Array.make 7 "";;
let quit = ref false;;
let choice = ref 8;;

menuItems.(0) <- "Queue Operations (implementation on single list)";
menuItems.(1) <- "empty";
menuItems.(2) <- "enqueue";
menuItems.(3) <- "dequeue";
menuItems.(4) <- "first";
menuItems.(5) <- "isEmpty";
menuItems.(6) <- "quit testing";
while not !quit do
  begin
    choice := menu(menuItems);
    match !choice with
	1 ->
	  begin
	    print_string "Created new queue";
	    q := Queue_Fun_List.empty();
	  end  
      | 2 ->
	  begin
            print_string "Element = ";
            q := Queue_Fun_List.enqueue(read_int(), !q);
	  end
      | 3 ->
	  begin
            q := Queue_Fun_List.dequeue !q;
            print_string "Dequeue\n";
	  end
      | 4 ->
	  begin
	    begin
               try print_int (Queue_Fun_List.first (!q)) with
		 Queue_Fun_List.Empty m -> print_string ("Exception: "^m);
	    end;
	    print_newline();
	  end  
      | 5 ->
	    print_string ("Queue is "^(if Queue_Fun_List.isEmpty !q then "" else "not ")^"empty.\n");
      | 6 ->
	    quit := true
      | _ ->
	    print_string "IMPOSSIBLE!!!\n"
  end
done
