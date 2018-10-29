package com.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.services.model.AddResponse;
import com.services.model.EmployeeDtls;
import com.services.service.EmployeeDetailsService;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RestController
public class EmployeeDetailsController {

	@Autowired
	@Qualifier("EmployeeDetailsService")
	private EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(value = "/getEmployeeDtls", method = { RequestMethod.GET })
	public EmployeeDtls getEmployeeDtls(
			@RequestParam(value = "employeeId") String employeeId) throws Exception {
		System.out.println("Request : employeeId : " + employeeId);
		EmployeeDtls employeeDtls = employeeDetailsService.getEmployeeDtls(employeeId);
		return employeeDtls;
	}
	
	@RequestMapping(value = "/updateEmployeeDtls", method = { RequestMethod.PUT })
	public EmployeeDtls updateEmployeeDtls(
			@RequestParam(value = "employeeId") String employeeId) throws Exception {
		System.out.println("Request : employeeId : " + employeeId);
		EmployeeDtls employeeDtls = employeeDetailsService.updateEmployeeDtls(employeeId);
		return employeeDtls;
	}
	
	@RequestMapping(value = "/addNumbers", method = { RequestMethod.PUT })
	public AddResponse addNumbers(
			@RequestParam(value = "intA") int intA,
			@RequestParam(value = "intB") int intB) throws Exception {
		System.out.println("Request : intA : " + intA);
		System.out.println("Request : intB : " + intB);
		AddResponse addResponse = employeeDetailsService.addNumbers(intA,intB);
		return addResponse;
	}
}
