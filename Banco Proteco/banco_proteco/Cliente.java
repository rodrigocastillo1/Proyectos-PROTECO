package banco_proteco;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Cliente implements Serializable{
	
	protected int account_id;
	protected String password;
	protected String titular_name;
	protected double balance;

	public Cliente(int account_id, String password, String titular_name, double balance){
		this.account_id = account_id;
		this.password = password;
		this.titular_name = titular_name;
		this.balance = balance;
	}

	public void showAccountDetails(){
		System.out.println("//////- INFORMACIÓN DE LA CUENTA -//////");
		System.out.println("Nombre: "+titular_name);
		System.out.println("Id de cuenta: "+account_id);
		System.out.println("Saldo de la cuenta: "+balance);
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double new_balance){
		this.balance = new_balance;
	}

	public int getAccountId(){
		return account_id;
	}

	public String getPassword(){
		return password;
	}

	public String getTitularName(){
		return titular_name;
	}


}
