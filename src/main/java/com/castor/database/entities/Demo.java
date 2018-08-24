package com.castor.database.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "demo")
public class Demo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;

}
