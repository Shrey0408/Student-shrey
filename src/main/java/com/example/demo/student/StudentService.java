package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public void registerNewStudent(Student student) {
		if (!studentRepository.findStudentByEmail(student.getEmail()).isPresent())
			studentRepository.save(student);
		else
			throw new IllegalArgumentException("Email already exists");
	}

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public void deleteById(Long id) {
		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
		} else {
			throw new IllegalStateException("Student ID " + id + " not found");
		}

	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		if (studentRepository.existsById(studentId)) {
			Student student = getStudentById(studentId);
			if (name != null && name.length() > 0 && name != student.getName()) {
				student.setName(name);
			}
			if (email != null && email.length() > 0 && email != student.getEmail()) {
				Optional<Student> studentWithEmail = studentRepository.findStudentByEmail(email);
				if (studentWithEmail.equals(email)) {
					throw new IllegalStateException("Email Record already present");
				}else {
				student.setEmail(email);
				}
			}
		} else {
			throw new IllegalStateException("Student with student ID " + studentId + " does not exists");
		}
	}

	public Student getStudentById(Long studentId) {
		return studentRepository.getById(studentId);
	}

}
