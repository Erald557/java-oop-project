package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Login.User;

public class UserController {

	private ArrayList<User>users;
	private File file;

	public UserController()
	{
		users = new ArrayList<>();
	    file = new File("file.bin");
	    if(file.exists()){
	    	readFile();
	    }
		
	}
	public void writeFile(){
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	public void readFile(){
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users=(ArrayList<User>) ois.readObject();
			ois.close();
			fis.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public boolean SignedUp(String name,String surname,String email,String password, String verifypassword, 
			String gender,String description,String proffession,boolean isRememberme){
		
		if(verifypassword.equals(password)){
			
			User u = new User(name,surname,email,password,verifypassword, gender, description, isRememberme);
			this.users.add(u);
			writeFile();
			return true;
		}
		return false;
		
	}
	public User login(String email, String password){
		System.out.println("User"+this.users);
		for(User user:this.users){
			if(user.getEmail().equals(email) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	public ArrayList<User> getUsers(){
		
		return this.users;
		
	}
	
	public void editUser(User updateUser, int position){
		this.users.set(position, updateUser);
		writeFile();
		
	}

	public int positionOfUser(User currentUser){

		for(int i=0; i<this.users.size();i++){
			if(currentUser.getEmail().equals(this.users.get(i).getEmail())){
				return i;
			}
		}
		return -1;
	}




























}
