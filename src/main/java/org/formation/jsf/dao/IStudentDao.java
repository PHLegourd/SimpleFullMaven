package org.formation.jsf.dao;

import java.util.List;

import org.formation.jsf.model.Student;

public interface IStudentDao {

	List<Student> getStudents() throws Exception;

	void addStudent(Student theStudent) throws Exception;

	Student getStudent(int studentId) throws Exception;

	void updateStudent(Student theStudent) throws Exception;

	void deleteStudent(int studentId) throws Exception;

}