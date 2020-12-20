package com.excel.upload.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Double ammount;
	private String number;
	private String recievedDate;

	public Invoice() {

	}

	public Invoice(String name, Double ammount, String number, String recievedDate) {
		this.name = name;
		this.ammount = ammount;
		this.number = number;
		this.recievedDate = recievedDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRecievedDate() {
		return recievedDate;
	}

	public void setRecievedDate(String recievedDate) {
		this.recievedDate = recievedDate;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", name=" + name + ", ammount=" + ammount + ", number=" + number
				+ ", recievedDate=" + recievedDate + "]";
	}

}
