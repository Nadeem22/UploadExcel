package com.excel.upload.service;

import java.util.List;

import com.excel.upload.entity.Invoice;

public interface IExcelDataService {
	
	List<Invoice> getExcelDataList();
	int saveExcelData(List<Invoice> invoices);
}
