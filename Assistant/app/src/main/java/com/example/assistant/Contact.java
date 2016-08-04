package com.example.assistant;

public class Contact {

	private long id;
	private String number;
	private String type;
	private String month;
	private String duration;
	private String day;

	public Contact(){}
	
	public Contact(String number, String type, String month,String day, String duration) {
		super();
		this.number = number;
		this.type = type;
		this.month=month;
		this.day=day;
		this.duration=duration;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	public String getDay() {
		return day;
	}
	public String getMonth(){return month;}
	public String getDuration() {
		return duration;
	}
	public void setNUmber(String number) {
		this.number = number;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setday(String day) {
		this.day = day;
	}
	public void setMonth(String month) {
		this.month= month;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", type=" + type + ", day=" + day+", month=" + month+", duration="+duration
				+ "]";
	}
	
	
	
}
