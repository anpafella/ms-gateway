package com.gateway.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull
	@Size(max = 50, message = "No pasar los 50 caracteress")
	private String name;

	@NotNull
	@Size(max = 50, message = "No pasar los 50 caracteress")
	private String lastName;

	@NotNull
	private Integer edad;

	private Integer companyId;
}
