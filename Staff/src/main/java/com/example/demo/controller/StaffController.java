package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StaffDto;
import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.StaffService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StaffController {

    private final StaffRepository staffRepository;

	@Autowired
	private StaffService ss;

    StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
	
	@PostMapping("/add")
	public void add(@Valid @RequestBody Staff staff) {
		ss.add(staff);
	}
	
	@GetMapping("displays")
	public List<StaffDto> display() {
		return ss.display();
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		ss.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody Staff staff) {
		ss.update(id,staff);
	}
	
	@GetMapping("/getById/{id}")
	public StaffDto getById(@PathVariable int id) {
		return ss.searchById(id);
	}
	
	@GetMapping("/getByName")
	public List getMethodName(@RequestParam String name) {
		return ss.searchByName(name);
	}
	
	@GetMapping("/getByRole/{role}")
	public List getByRole(@PathVariable String role) {
		return ss.searchByRole(role);
	}
	
	@GetMapping("getByEmail")
	public StaffDto getByEmail(@RequestParam String emails) {
		return ss.searchByEmail(emails);
	}
}