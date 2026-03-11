package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipment 
{
    @Id
    private int id;
    private String name;
    private String date;
    private String status;
    private String destination;

    public Shipment() {}

    public Shipment(int id,String name,String date,String status,String destination)
    {
        this.id=id;
        this.name=name;
        this.date=date;
        this.status=status;
        this.destination=destination;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

  
}