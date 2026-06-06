package com.example.demo.dto;

import com.example.demo.model.Staff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {

	private Integer id;
	private String name;
	private Float salary;
	private String department;
	private String role;
	private String email;

	public static StaffDto toDto(Staff staff) {
		StaffDto sd = new StaffDto();
		sd.setDepartment(staff.getDepartment());
		sd.setEmail(staff.getEmail());
		sd.setId(staff.getId());
		sd.setName(staff.getName());
		sd.setRole(staff.getRole());
		sd.setSalary(staff.getSalary());

		return sd;
	}
}