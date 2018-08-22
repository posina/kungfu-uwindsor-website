package com.kungfu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kungfu.dao.FinanceDao;
import com.kungfu.entity.Payments;

@Service
public class FinanceServiceImpl implements FinanceService {
	
	@Autowired
	private FinanceDao financeDao;

	@Override
	@Transactional
	public List<Payments> getFinancialDetails() {
        return financeDao.getAllPayments();
	}

}
