package com.kungfu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.kungfu.entity.Payments;

@Service
public interface FinanceService {

    List<Payments> getFinancialDetails();

}
