package com.example.demo.repository;

//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.dto.StaffDto;
//import com.example.demo.model.Staff;
//
//@Repository
//public interface StaffRepository extends JpaRepository<Staff, Integer> {
//	List<Staff> findByName1(String name);
//	List<Staff> findByDepartment(String department);
//	List<Staff> findByName(String role);
//	StaffDto findByEmail(String email);
//}

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StaffDto;
import com.example.demo.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    List<Staff> findByName(String name);

    List<Staff> findByDepartment(String department);

    List<Staff> findByRole(String role);

    Staff findByEmail(String email);
}