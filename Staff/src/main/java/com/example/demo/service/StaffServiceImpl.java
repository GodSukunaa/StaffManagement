package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.StaffApplication;
import com.example.demo.dto.StaffDto;
import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffApplication staffApplication;

	@Autowired
	private StaffRepository sr;

    StaffServiceImpl(StaffApplication staffApplication) {
        this.staffApplication = staffApplication;
    }
	
	@Override
	public void add(Staff staff) {
		// TODO Auto-generated method stub

		sr.save(staff);
	}
 
	@Override
	public List<StaffDto> display() {
		// TODO Auto-generated method stub
		List<Staff> temp = sr.findAll();
		List<StaffDto> result = new ArrayList<>();
		
		for(Staff x : temp) {
			result.add(StaffDto.toDto(x));
		}
		return result;
	}

	@Override
	public List<StaffDto> searchByName(String name) {
		List<Staff> temp = sr.findByName(name);
		List<StaffDto> result = new ArrayList<>();
		
		for(Staff x : temp) {
			result.add(StaffDto.toDto(x));
		}
		return result;
	}

	@Override
	public List<StaffDto> searchByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffDto> searchByRole(String role) {
		List<Staff> temp = sr.findByRole(role);
		List<StaffDto> result = new ArrayList<>();
		for (Staff s : temp) {
			result.add(StaffDto.toDto(s));
		}
		return result;
	}

	@Override
	public StaffDto searchByEmail(String email) {
		
		Staff data = sr.findByEmail(email);
		return StaffDto.toDto(data);
	}

	@Override
	public StaffDto searchById(Integer id) {
		return sr.findById(id).map(StaffDto::toDto).orElseThrow(()-> new RuntimeException("Staff not found"));
	}

	@Override
	public void delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}
	@Override
	public void update(int id,Staff staff) {
		Staff existStaff = sr.findById(id).orElseThrow(() -> new RuntimeException("User Not Found !"));
		
		existStaff.setName(staff.getName());
		existStaff.setDepartment(staff.getDepartment());
		existStaff.setSalary(staff.getSalary());
		
		sr.save(existStaff);
	}

	
	
}