package com.kungfu.dao;

import java.util.List;

import com.kungfu.entity.Payments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FinanceDaoImpl implements FinanceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Payments> getAllPayments() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Payments> theQuery = currentSession.
                createQuery("from Payments", Payments.class);
        return theQuery.getResultList();
    }

}
