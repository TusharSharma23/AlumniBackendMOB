package in.ac.ymcaust.AlumniBackendUMS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A class which represents the registration table from database.
 * Contains loginId and password of user.
 * Also linked with REST Controller
 * @author Tushar
 *
 */
@Entity
@Table
public class Registration implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2620274161719156010L;

	// Login Id of user
	@Id
	@JsonProperty("email_id")
	private String email_id;
	
	// Encrypted password
	@Column(nullable = false)
	@JsonProperty("password")
	private String password;

	/**
	 * Constructor for Registration object
	 * @param email_id User registration email_id
	 * @param password User password encrypted
	 */
	public Registration(String email_id, String password) {		
		this.email_id = email_id;
		this.password = password;
	}

	/**
	 * Empty constructor for REST requests
	 */
	public Registration() {
		super();
	}


	/**
	 * Method to get user email_id
	 * @return email_id of user
	 */
	public String getEmail_id() {
		return email_id;
	}

	/**
	 * Method to get user encrypted password
	 * @return password of user
	 */
	public String getPassword() {
		return password;
	}

}
