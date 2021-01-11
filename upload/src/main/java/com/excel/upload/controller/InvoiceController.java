package com.excel.upload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.excel.upload.entity.Invoice;
import com.excel.upload.repository.InvoiceRepository;
import com.excel.upload.service.FileUploadService;
import com.excel.upload.service.IExcelDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class InvoiceController {


Logger log=LoggerFactory.getLogger("Invoice controller")
	FileUploadService fileService;

	IExcelDataService excelservice;

	InvoiceRepository repo;
	
	
	@Autowired
	public InvoiceController(FileUploadService fileService, IExcelDataService excelservice, InvoiceRepository repo) {
		this.fileService = fileService;
		this.excelservice = excelservice;
		this.repo = repo;
	}

	@GetMapping("/")
	public String index() {
		log.info("index controller called");
		return "uploadPage";
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		fileService.uploadFile(file);

		redirectAttributes.addFlashAttribute("message",
				"You have successfully uploaded '" + file.getOriginalFilename() + "' !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping("/saveData")
	public String saveExcelData(Model model) {

		List<Invoice> excelDataAsList = excelservice.getExcelDataList();
		int noOfRecords = excelservice.saveExcelData(excelDataAsList);
		model.addAttribute("noOfRecords", noOfRecords);
		return "success";
	}
}
