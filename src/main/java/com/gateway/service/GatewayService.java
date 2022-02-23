package com.gateway.service;

import com.gateway.model.dto.CompanyDTO;
import com.gateway.model.dto.EmployeeByCompany;
import com.gateway.model.dto.EmployeeDTO;
import com.gateway.model.dto.GatewayDTO;

public interface GatewayService {
	
	CompanyDTO createCompany(CompanyDTO companyDTO);

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeByCompany getEmployeeByCompanyId(Integer id);

}
