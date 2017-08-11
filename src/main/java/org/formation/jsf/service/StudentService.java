package org.formation.jsf.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.jsf.dao.IStudentDao;
import org.formation.jsf.model.Student;

@Named
public class StudentService implements IStudentService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IStudentDao studentdao;

	@PostConstruct
	public void initService() {
		System.out.println(this.getClass().getName() + " je suis construit");
	}

	@Override
	public List<Student> getStudents() throws Exception {
		return studentdao.getStudents();
	}

	@Override
	public void addStudent(Student student) throws Exception {
		studentdao.addStudent(student);
	}

	@Override
	public Student getStudent(int id) throws Exception {
		return studentdao.getStudent(id);
	}

	@Override
	public void updateStudent(Student student) throws Exception {
		studentdao.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) throws Exception {
		studentdao.deleteStudent(id);

	}

}
