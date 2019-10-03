package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar(Object classe) throws IllegalArgumentException, IllegalAccessException {
		BigDecimal somar = new BigDecimal(0);
		for (Field field : classe.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Somar.class) && field.getType().equals(BigDecimal.class)) {
				somar = somar.add(new BigDecimal(field.get(classe).toString()));
			}
		}
		return somar;
	}

	@Override
	public BigDecimal subtrair(Object classe) throws IllegalArgumentException, IllegalAccessException {
		BigDecimal subtrair = new BigDecimal(0);
		for (Field field : classe.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Subtrair.class) && field.getType().equals(BigDecimal.class)) {
				subtrair = subtrair.add(new BigDecimal(field.get(classe).toString()));
			}
		}
		return subtrair;
	}

	@Override
	public BigDecimal totalizar(Object classe) throws IllegalArgumentException, IllegalAccessException {
		return somar(classe).subtract(subtrair(classe));
	}
}