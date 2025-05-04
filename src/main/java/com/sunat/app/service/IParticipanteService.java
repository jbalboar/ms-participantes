package com.sunat.app.service;

import java.util.List;
import com.sunat.app.entities.Participante;

public interface IParticipanteService {
	public List<Participante> listarParticipantes();

	public Participante agregarEvento(Participante participante);

	public void eliminarParticipante(Participante participante);

	public List<Participante> getParticipanteById(Long idParticipante);
}
