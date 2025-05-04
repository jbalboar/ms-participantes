package com.sunat.app.util;

public class EventoYaRegistradoException extends RuntimeException {
	public EventoYaRegistradoException() {
        super("Ya se encuentra registrado al evento");
    }
}
