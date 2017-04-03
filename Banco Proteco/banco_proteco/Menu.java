package banco_proteco;

import java.util.Scanner;

public class Menu{
	private int selected_opt;
	private Scanner read;

	public Menu(){
		read = new Scanner(System.in);
	}

	public static int showMenu(String options, int num_of_opt){
		
		do{
			System.out.println(options);
			selected_opt = read.nextInt();
			if(selected_opt < 1 || selected_opt > num_of_opt)
				System.out.println("ERROR: Opción no valida...\n");
		}while(selected_opt < 1 || selected_opt > num_of_opt);

		return selected_opt;
	}
}