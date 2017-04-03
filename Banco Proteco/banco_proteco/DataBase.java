package banco_proteco;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class DataBase implements Serializable{
	
	public ArrayList<Cliente>clientes;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private ObjectInputStream ois;
	private Scanner read;

	public DataBase(){
		clientes = new ArrayList<>();
		read = new Scanner(System.in);
	}

	public void readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		fis = new FileInputStream("dataBase.txt");
		ois = new ObjectInputStream(fis);
		if(fis.available() != 0){
			clientes = (ArrayList<Cliente>)ois.readObject();
		}
		ois.close();
		System.out.println("Se cargó la información correctamente");
	}

	public void writeFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		fos = new FileOutputStream("dataBase.txt");
		oos = new ObjectOutputStream(fos);
		System.out.println("Grabando infromación...");
		oos.writeObject(clientes);
		oos.close();
		System.out.println("Se guardó la información correctamente");
	}

	public void saveClientAccount(Cliente cliente){
		clientes.add(cliente);
	}

	public void deleteClientAccount(Cliente cliente){
		clientes.remove(cliente);
	}

	public void listClientAccounts(){
		for(Cliente c: clientes){
			c.showAccountDetails();
		}
	}

	public Cliente searchForAClient(int client_id, String passw){
		int i = 0;
		for(Cliente client: clientes){
			if(client.getAccountId() == client_id && client.getPassword().equals(passw))
				return clientes.get(i);
			i++;
			System.out.println("Id: "+client.getAccountId()+" Password "+client.getPassword());
		}
		return null;
	}
}