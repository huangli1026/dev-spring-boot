package com.huangli.springboot.cruddemo.dao;

import com.huangli.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery= entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees=theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee=entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //if id==0, then insert/save. else update
        Employee dbEmployee=entityManager.merge(theEmployee);
        //return dbEmployee, it has updated id from the database,(in the case of insert)
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee=entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
