package in.ac.ymcaust.AlumniBackendUMS.JSONObjects;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUser {

	@JsonProperty("email_id")
	private String emailID;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("user_details")
	private Map<String, Object> details;
	
	public String getEmailID() {
		return emailID;
	}

	public String getPassword() {
		return password;
	}

	public Map<String, Object> getDetails() {
		return details;
	}

}
