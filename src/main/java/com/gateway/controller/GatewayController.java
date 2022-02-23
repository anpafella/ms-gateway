package com.gateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.model.dto.CompanyDTO;
import com.gateway.model.dto.EmployeeByCompany;
import com.gateway.model.dto.EmployeeDTO;
import com.gateway.service.GatewayService;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

	@Autowired
	private GatewayService gatewayService;

	@PostMapping("/crearCompany")
	public CompanyDTO createCompany(@RequestBody @Valid CompanyDTO company) {

		CompanyDTO companyCreada = gatewayService.createCompany(company);

		return companyCreada;

	}

	@PostMapping("/crearEmployee")
	public EmployeeDTO createEmployee(@RequestBody @Valid EmployeeDTO employee) {

		EmployeeDTO employeeCreado = gatewayService.createEmployee(employee);

		return employeeCreado;
	}

	@GetMapping("/{id}/getEmployeesByCompany")
	public EmployeeByCompany getEmployeesByCompany(@PathVariable( value = "id")Integer id){
		EmployeeByCompany employeeByCompany = gatewayService.getEmployeeByCompanyId(id);
		
		return employeeByCompany;
	}

}
