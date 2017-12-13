package objects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Entity
@Table(name = "client")
public class Client {

	@Column(name = "Id" )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Password")
	private String password;

	@Column(name = "Email")
	private String email;

	@Column(name = "Token")
	private String token;
	
	@Column(name = "PasswordRecoveryToken")
	private String passwordRecoveryToken;

	@Column(name = "Enabled")
	private String enabled;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPasswordRecoveryToken() {
		return passwordRecoveryToken;
	}

	public void setPasswordRecoveryToken(String passwordRecoveryToken) {
		this.passwordRecoveryToken = passwordRecoveryToken;
	}

}
