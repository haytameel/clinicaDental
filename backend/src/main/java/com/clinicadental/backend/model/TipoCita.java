package com.clinicadental.backend.model;

public enum TipoCita {
    ORTODONCIA(60),
    EMPASTE(45),
    IMPLANTES_DENTALES(90),
    BLANQUEAMIENTO_DENTAL(45),
    LIMPIEZA_PROFESIONAL(30),
    ESTETICA_DENTAL(60),
    ENDODONCIA(75),
    ODONTOPEDIATRIA(40),
    CIRUGIA_ORAL(120),
    PROTESIS_DENTALES(60),
    DIAGNOSTICO_DIGITAL(20);

    private final int duracionMinutos;

    TipoCita(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }
}
