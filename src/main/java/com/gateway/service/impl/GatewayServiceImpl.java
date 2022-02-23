package com.gateway.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gateway.model.dto.CompanyDTO;
import com.gateway.model.dto.EmployeeByCompany;
import com.gateway.model.dto.EmployeeDTO;
import com.gateway.model.dto.GatewayDTO;
import com.gateway.service.GatewayService;

@Service
public class GatewayServiceImpl implements GatewayService {

	private final String COMPANY_HOST = "http://localhost:8082/company/";
	private final String CREATE_ENDPOINT = "crear";
	private final String GET_COMPANY_BY_ID_ENDPOINT = "/get";

	private final String EMPLOYEE_HOST = "http://localhost:8083/employee/";
	private final String CREATE_ENDPOINTE = "crear";
	private final String GET_EMPLOYEE_BY_ID_ENDPOINT = "/get";

	@Autowired
	RestTemplate restTemplate;

	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {

		String url = COMPANY_HOST.concat(CREATE_ENDPOINT);
		CompanyDTO companyCreated = restTemplate.postForObject(url, companyDTO, CompanyDTO.class);

		return companyCreated;
	}

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

		String urlE = EMPLOYEE_HOST.concat(CREATE_ENDPOINTE);
		EmployeeDTO employeeCreado = restTemplate.postForObject(urlE, employeeDTO, EmployeeDTO.class);

		return employeeCreado;
	}

	@Override
	public EmployeeByCompany getEmployeeByCompanyId(Integer id) {
		
		//conectado con ms-company para traer datos de la company
		String url = COMPANY_HOST.concat(id.toString()).concat(GET_COMPANY_BY_ID_ENDPOINT);
		CompanyDTO companyFound = restTemplate.getForObject(url, CompanyDTO.class);
		
		//conectando con ms-employee para traer los empleados de una company
		String url2= EMPLOYEE_HOST.concat(id.toString()).concat(GET_EMPLOYEE_BY_ID_ENDPOINT);
		List<EmployeeDTO> employeeList = restTemplate.getForObject(url2, List.class);
		
		
		EmployeeByCompany employeeByCompany = new EmployeeByCompany();
		employeeByCompany.setCompanyDTO(companyFound);
		employeeByCompany.setEmployeeList(employeeList);
		
		
		
		return employeeByCompany;
	}

}
