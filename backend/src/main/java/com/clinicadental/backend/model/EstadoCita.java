package com.clinicadental.backend.model;

public enum EstadoCita {
    PENDIENTE,        // Solicitud enviada por el paciente, aún no confirmada
    CONFIRMADA,       // El admin ha confirmado la cita y asignado personal
    CANCELADA,        // La cita ha sido cancelada por el paciente o admin
    FINALIZADA        // La cita ya se ha realizado
    ;

}
