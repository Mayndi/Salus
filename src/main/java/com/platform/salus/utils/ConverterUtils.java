package com.platform.salus.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ConverterUtils {

	public String convertDateToString(LocalDate date) {
		DateTimeFormatter out = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return out.format(date);
	}

	public LocalDate convertStringToLocalDate(String date) {
		DateTimeFormatter out = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, out);
	}
}
