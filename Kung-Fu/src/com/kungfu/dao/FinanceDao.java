package com.kungfu.dao;

import java.util.List;

import com.kungfu.entity.Payments;

public interface FinanceDao {

    List<Payments> getAllPayments();

}
