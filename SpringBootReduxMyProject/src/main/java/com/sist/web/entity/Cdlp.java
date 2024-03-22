package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cdlp {

	@Id
	private int no;
	private int score,price,saleprice,discount;
	private String poster,subject,content,image,artist,publisher,regdate,genre,sub_genre;
}
