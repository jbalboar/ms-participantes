package com.sunat.app.util;

public class EventoSinCapacidadException extends RuntimeException {
	public EventoSinCapacidadException() {
        super("El evento no cuenta con capacidad disponible.");
    }
}
