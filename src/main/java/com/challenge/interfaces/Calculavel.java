package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    public BigDecimal somar(Object classe) throws IllegalAccessException;


    public BigDecimal subtrair(Object classe) throws IllegalArgumentException, IllegalAccessException;


    public BigDecimal totalizar(Object classe) throws IllegalArgumentException, IllegalAccessException;

}
