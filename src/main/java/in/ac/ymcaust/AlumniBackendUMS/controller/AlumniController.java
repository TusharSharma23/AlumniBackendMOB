package in.ac.ymcaust.AlumniBackendUMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.ymcaust.AlumniBackendUMS.JSONObjects.RegisterUser;
import in.ac.ymcaust.AlumniBackendUMS.Response.VerifyRegisterUserResponse;
import in.ac.ymcaust.AlumniBackendUMS.model.Registration;
import in.ac.ymcaust.AlumniBackendUMS.service.ResponseService;

@RestController
@RequestMapping("/Alumni")
public class AlumniController {

	@Autowired
	private ResponseService service;
	
	@PostMapping("/authenticateUser")
	private VerifyRegisterUserResponse authenticate(@RequestBody Registration registration) {
		return service.verifyUser(registration);
	}
	
	@PostMapping("/registerUser")
	private VerifyRegisterUserResponse register(@RequestBody RegisterUser userJson) {
		return service.registerUser(userJson);
	}
}
