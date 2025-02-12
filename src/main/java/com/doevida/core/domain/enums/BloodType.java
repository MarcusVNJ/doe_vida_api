package com.doevida.core.domain.enums;

public enum BloodType {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-");

    private final String code;

    BloodType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static BloodType fromString(String codigo) {
        for (BloodType tipo : BloodType.values()) {
            if (tipo.code.equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo sanguíneo inválido: " + codigo);
    }
}