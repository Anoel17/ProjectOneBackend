package main.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "image")
public class FileDB {
	
  @Id
  @Column(name = "id")
  @GeneratedValue
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Lob
  @Column(name = "pic_data")
  private byte[] picData;

  public FileDB() {
  }

public FileDB(String name, String type, byte[] picData) {
	super();
	this.name = name;
	this.type = type;
	this.picData = picData;
}

public FileDB(int id, String name, String type, byte[] picData) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.picData = picData;
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

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public byte[] getPicData() {
	return picData;
}

public void setPicData(byte[] picData) {
	this.picData = picData;
}

@Override
public String toString() {
	return "FileDB [id=" + id + ", name=" + name + ", type=" + type + ", picData=" + Arrays.toString(picData) + "]";
}

}