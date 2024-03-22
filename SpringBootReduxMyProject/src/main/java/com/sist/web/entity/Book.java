package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

	@Id
	private int no;
	private int cart;
	@Column(insertable = true,updatable = false)
	private String name;
	@Column(insertable = true,updatable = false)
	private String poster;
	@Column(insertable = true,updatable = false)
	private String author;
	@Column(insertable = true,updatable = false)
	private String publ;
	@Column(insertable = true,updatable = false)
	private String regdate;
	@Column(insertable = true,updatable = false)
	private String score;
	@Column(insertable = true,updatable = false)
	private String price;
	@Column(insertable = true,updatable = false)
	private String saleprice;
	@Column(insertable = true,updatable = false)
	private String detailposter;
	@Column(insertable = true,updatable = false)
	private String intro;
	@Column(insertable = true,updatable = false)
	private String type;
}
