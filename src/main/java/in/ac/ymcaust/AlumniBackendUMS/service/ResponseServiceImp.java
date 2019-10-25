package in.ac.ymcaust.AlumniBackendUMS.service;

import java.sql.Date;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.ymcaust.AlumniBackendUMS.JSONObjects.RegisterUser;
import in.ac.ymcaust.AlumniBackendUMS.Response.VerifyRegisterUserResponse;
import in.ac.ymcaust.AlumniBackendUMS.dao.UserRegistrationDAO;
import in.ac.ymcaust.AlumniBackendUMS.model.Registration;
import in.ac.ymcaust.AlumniBackendUMS.model.UserDetails;

@Service
@Transactional(readOnly = true)
public class ResponseServiceImp implements ResponseService{

	@Autowired
	private UserRegistrationDAO databaseDAO;

	@Transactional
	public VerifyRegisterUserResponse verifyUser(Registration registration) {
		VerifyRegisterUserResponse response = new VerifyRegisterUserResponse();
		if(registration != null && registration.getEmail_id() != null) {
			if(registration.getPassword() != null) {
				Registration dbRes = databaseDAO.verifyUser(
						registration.getEmail_id());
				//System.out.println(dbRes.getEmail_id() + " " + dbRes.getPassword());
				if(dbRes != null) {
					if(dbRes.getPassword().equals(registration.getPassword())) {
						response.setStatus("Success");
						response.setResponseMessage("Valid User");
					} else {
						response.setStatus("Failure");
						response.setErrorMessage("Device not registered.");
					}
				} else {
					response.setStatus("Error");
					response.setErrorMessage("User not registered.");
				}
			} else {
				response.setStatus("Error");
				response.setErrorMessage("No password provided");
			}
		} else {
			response.setStatus("Error");
			response.setErrorMessage("No email provided");
		}
		return response;
	}

	@Transactional(value = "transactionManager",rollbackFor=Exception.class,propagation= Propagation.REQUIRES_NEW)
	public VerifyRegisterUserResponse registerUser(RegisterUser registerUser) {
		VerifyRegisterUserResponse response = new VerifyRegisterUserResponse();

		if(registerUser != null && registerUser.getEmailID() != null) {
			if(registerUser.getPassword() != null) {
				if(registerUser.getDetails() != null) {
					//Nothing, It is here for error checking
				} else {
					response.setStatus("Error");
					response.setErrorMessage("User details not provided");
					return response;
				}
			} else {
				response.setStatus("Error");
				response.setErrorMessage("No password provided");
				return response;
			}
		} else {
			response.setStatus("Error");
			response.setErrorMessage("No email provided");
			return response;
		}

		@SuppressWarnings("rawtypes")
		Map details = registerUser.getDetails();
		Registration reg = new Registration(registerUser.getEmailID(),
				registerUser.getPassword());
		UserDetails userDetails = null;
		try {
			userDetails = new UserDetails(
					details.get("name").toString(),
					Integer.parseInt(details.get("passout_batch").toString()),
					details.get("type_of_degree").toString(),
					details.get("stream").toString(),
					details.get("current_location").toString(),
					details.get("home_town_location").toString(),
					details.get("gender").toString(),
					details.get("interests").toString()
					);
		} catch(NullPointerException e) {
			response.setStatus("Error");
			response.setErrorMessage("Mandatory details not provided");
			return response;
		}
		
		if(details.containsKey("anniversary_date")) {
			userDetails.setAnniversary_date(new Date(Long.parseLong(details.get("anniversary_date").toString())));
		}
		
		if(details.containsKey("business_domain")) {
			userDetails.setBusiness_domain(details.get("business_domain").toString());
		}
		
		if(details.containsKey("company_name")) {
			userDetails.setCompany_name(details.get("company_name").toString());
		}
		
		if(details.containsKey("current_designation")) {
			userDetails.setCurrent_designation(details.get("current_designation").toString());
		}
		
		if(details.containsKey("date_of_birth")) {
			userDetails.setDate_of_birth(new Date(Long.parseLong(details.get("date_of_birth").toString())));
		}
		
		if(details.containsKey("location_of_work")) {
			userDetails.setLocation_of_work(details.get("location_of_work").toString());
		}
		
		if(details.containsKey("image")) {
			String image = details.get("image").toString();
			userDetails.setImage(BlobProxy.generateProxy(image.getBytes()));
		}
		
		if(databaseDAO.registerUser(reg, userDetails)) {
			response.setStatus("Success");
			response.setResponseMessage("Valid User");
		} else {
			System.out.println("Service: Save error occured");
			response.setStatus("Failure");
			response.setErrorMessage("User already registered.");
		}

		return response;
	}

}
