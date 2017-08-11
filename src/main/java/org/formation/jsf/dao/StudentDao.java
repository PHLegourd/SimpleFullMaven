package org.formation.jsf.dao;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.jsf.model.Student;

@Named
@ApplicationScoped
public class StudentDao implements IStudentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public List<Student> getStudents() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();

		List<Student> retList = new ArrayList<>();
		try {
			etxn.begin();
			TypedQuery<Student> query = em.createQuery("from Student", Student.class);
			retList = query.getResultList();

			etxn.commit();
		} catch (Exception e) {
			if (etxn != null) {
				etxn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return retList;
	}

	@Override
	public void addStudent(Student theStudent) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();

		try {
			etxn.begin();
			em.persist(theStudent);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null) {
				etxn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Student getStudent(int studentId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();

		Student stud = new Student();
		try {
			etxn.begin();
			stud = em.find(Student.class, studentId);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null) {
				etxn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return stud;
	}

	@Override
	public void updateStudent(Student theStudent) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		try {
			etxn.begin();
			em.merge(theStudent);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null) {
				etxn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public void deleteStudent(int studentId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		try {
			etxn.begin();
			Student stud = em.find(Student.class, studentId);
			em.remove(stud);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null) {
				etxn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
