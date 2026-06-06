package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StaffDto;
import com.example.demo.model.Staff;

@Service
public interface StaffService {

	void add(Staff staff);
	
	List<StaffDto> display();
	List<StaffDto> searchByName(String name);
	List<StaffDto> searchByDepartment(String department);
	List<StaffDto> searchByRole(String role);
	
	StaffDto searchByEmail(String email);
	StaffDto searchById(Integer id); 
	
	void delete(int id);
	void update(int id, Staff staff);
}