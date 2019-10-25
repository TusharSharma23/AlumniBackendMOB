package in.ac.ymcaust.AlumniBackendUMS.dao;

import in.ac.ymcaust.AlumniBackendUMS.model.Registration;
import in.ac.ymcaust.AlumniBackendUMS.model.UserDetails;

public interface UserRegistrationDAO {
	
	public Registration verifyUser(String email);
	
	public boolean registerUser(Registration registration,UserDetails userDetails);
}
