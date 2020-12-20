package com.excel.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.upload.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
