package in.ac.ymcaust.AlumniBackendUMS.service;

import in.ac.ymcaust.AlumniBackendUMS.JSONObjects.RegisterUser;
import in.ac.ymcaust.AlumniBackendUMS.Response.VerifyRegisterUserResponse;
import in.ac.ymcaust.AlumniBackendUMS.model.Registration;

public interface ResponseService {
	
	public VerifyRegisterUserResponse verifyUser(Registration registration);
	
	public VerifyRegisterUserResponse registerUser(RegisterUser registerUser);
}
