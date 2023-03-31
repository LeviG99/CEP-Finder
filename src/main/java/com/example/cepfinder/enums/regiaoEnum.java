package com.example.cepfinder.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum regiaoEnum {
    NORDESTE(15.98, Arrays.asList("MA","PI","CE","RN","PB","PE","AL","SE","BA")),
    SUDESTE(7.85, Arrays.asList("ES","MG","RJ","SP")),
    CENTRO_OESTE(12.50, Arrays.asList("GO","MT","MS","DF")),
    SUL(17.30,Arrays.asList("PR","SC","RS")),
    NORTE(20.83, Arrays.asList("AM","PA","AC","RR","RO","AP","TO"));

    private final double value;

    private final List<String> estados;


    regiaoEnum(double value, List<String> estados) {
        this.value = value;
        this.estados = estados;
    }

    public List<String> getEstados() {
        return estados;
    }

    public double getValue() {
        return value;
    }
}
