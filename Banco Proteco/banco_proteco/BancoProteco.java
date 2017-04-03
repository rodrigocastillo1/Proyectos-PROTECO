package banco_proteco;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BancoProteco{
	
	private static DataBase db;
	private static Menu menu;
	private static Scanner read;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		db = new DataBase();
		read = new Scanner(System.in);
		db.readFile();

		showGuestInterface(db);
		
		db.writeFile();

	}

	public static void makeADeposit(Cliente client, double amount){
		client.setBalance(client.getBalance()+amount);
	}

	public static void checkBalance(Cliente client){
		System.out.println("El saldo actual es de: "+client.getBalance()+" pesos"); 
	}

	public static void withdrawMoney(Cliente client, double amount){
		if(amount <= client.getBalance()){
			System.out.println("Procesando la transacción...");
			client.setBalance(client.getBalance()-amount);
		}
		else System.out.println("ERROR. La cantidad especificada es mayor que el saldo actual");
	}

	public static void showAccountDetails(Cliente client){
		client.showAccountDetails();
	}

	public static void showClientInterface(Cliente client){
		int opt;
		boolean flag = true;
		do{
			menu = new Menu();
			opt = menu.showMenu("Selecciona la opción deseada: "
									+ "\n1) Hacer un deposito"
									+ "\n2) Consultar saldo"
									+ "\n3) Retirar"
									+ "\n4) Mostrar datos de la cuenta"
									+ "\n5) Salir de la cuenta", 5);
			switch(opt){
				case 1:
					System.out.println("Ingrese la cantidad que desea depositar\n>> ");
					makeADeposit(client, read.nextDouble());
					System.out.println("Desposito realizado con éxito");
					break;
				case 2:
					checkBalance(client);
					break;
				case 3:
					System.out.println("Ingrese la cantidad que desea retirar\n>> ");
					withdrawMoney(client, read.nextDouble());
					break;
				case 4:
					showAccountDetails(client);
					break;
				case 5:
					flag = false;
					break;
			}

		}while(flag);
	}

	public static void showGuestInterface(DataBase db){
		int opt, user_id;
		boolean flag = true;
		String passw, name;
		double balance;
		Cliente client;
		do{
			System.out.println("--BANCO PROTECO--");
			menu = new Menu();
			opt = menu.showMenu("Selecciona la opción deseada: "
									+ "\n1) Ingresar a una cuenta (Usuarios registrados)"
									+ "\n2) Crear una cuenta"
									+ "\n3) Apagar el sistema", 3);
			switch(opt){
				case 1:
					System.out.println("Ingrese el ID de usuario\n>> ");
					user_id = read.nextInt();
					System.out.println("Ingrese la contraseña\n>> ");
					read.nextLine();
					passw = read.nextLine();
					client = db.searchForAClient(user_id, passw);
					client.getTitularName();
					if(client != null){
						System.out.println("Bienvenido "+client.getTitularName());
						showClientInterface(client);
					}
					else
						System.out.println("El usuario no está registrado en la base de datos, por favor cree una cuenta.");
					break;

				case 2:
					System.out.println("Ingrese el nombre de usuario\n>> ");
					name = read.nextLine();
					System.out.println("Ingrese el ID de usuario\n>> ");
					user_id = read.nextInt();
					System.out.println("Ingrese la contraseña del nuevo usuario\n>> ");
					read.nextLine();
					passw = read.nextLine();
					System.out.println("Ingrese el saldo inicial del nuevo usuario\n>> ");
					balance = read.nextDouble();
					client = new Cliente(user_id, passw, name, balance);
					db.saveClientAccount(client);
					System.out.println("Usuario registrado correctamente");
					break;
				
				case 3:
					flag = false;
					break;
			}	
		}while(flag);
	}
}
