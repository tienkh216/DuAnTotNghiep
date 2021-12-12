package com.gymshop.domain;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DoanhThuThang {
	 @Id
	 private int thang;
	 private double doanhThu;
}
