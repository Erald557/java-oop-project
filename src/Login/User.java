package Login;

import java.io.Serializable;

public class User implements Serializable {

	private static int id=0;
	private String name,surname,email,password, gender, description, proffession;
	private boolean isRememberme;
	
	public User(String name, String surname, String email, String password, String gender, String description,
			String proffession, boolean isRememberme) {
		super();

		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.description = description;
		this.proffession = proffession;
		this.isRememberme = isRememberme;
		++this.id;
	}
	

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", description=" + description + ", proffession=" + proffession
				+ ", isRememberme=" + isRememberme + "]";
	}


	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		User.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProffession() {
		return proffession;
	}

	public void setProffession(String proffession) {
		this.proffession = proffession;
	}

	public boolean isRememberme() {
		return isRememberme;
	}

	public void setRememberme(boolean isRememberme) {
		this.isRememberme = isRememberme;
	}
	
}
