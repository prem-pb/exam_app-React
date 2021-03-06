package com.example.examapp.demo.dao;

import com.example.examapp.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements Dao<Student>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Student getEntityById(long id) {
        Session session = sessionFactory.getCurrentSession();

        try {
            return session.get(Student.class, id);
        } catch (NoResultException exp) {
            return null;
        }
    }

    @Override
    public List<Student> getAllEntities() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student").getResultList();
        return students;
    }

    @Override
    public Student save(Student obj) {
        Session session = sessionFactory.getCurrentSession();
        return (Student)session.merge(obj);
    }

    @Override
    public void delete(Student obj) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(obj);
    }

    public Student getByUsername(String username){
        Session session = sessionFactory.getCurrentSession();

        try {
            return session.createQuery(
                     "from Student " +
                        "where username = :username", Student.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException exp) {
            return null;
        }
    }
}
