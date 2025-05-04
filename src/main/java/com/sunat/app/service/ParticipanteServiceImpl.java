package com.sunat.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunat.app.entities.Participante;
import com.sunat.app.feign.EventoFeignClient;
import com.sunat.app.repository.ParticipanteRepository;
import com.sunat.app.util.EventoSinCapacidadException;
import com.sunat.app.util.EventoYaRegistradoException;

@Service
public class ParticipanteServiceImpl implements IParticipanteService {

	private final EventoFeignClient eventoClient;
	private final ParticipanteRepository participanteRepository;

	public ParticipanteServiceImpl(EventoFeignClient eventoClient, ParticipanteRepository participanteRepository) {
		this.eventoClient = eventoClient;
		this.participanteRepository = participanteRepository;
	}

	@Override
	public List<Participante> listarParticipantes() {
		return participanteRepository.findAll();
	}

	@Override
	public Participante agregarEvento(Participante participante) {

		EventoFeignClient.Evento evento = null;
		try {
			evento = eventoClient.obtenerEventoPorId(participante.getIdEvento());
		} catch (Exception e) {
			throw new IllegalArgumentException("El evento no existe.");
		}

		if (evento.getCapacidad() == 0)
			throw new EventoSinCapacidadException();

		if (participanteRepository.existsByIdParticipanteAndIdEvento(participante.getIdParticipante(),
				participante.getIdEvento()))
			throw new EventoYaRegistradoException();

		// Se realiza la actualización del evento
		evento.setCapacidad(evento.getCapacidad() - 1);
		eventoClient.actualizarPorId(evento.getId(), evento);

		return participanteRepository.save(participante);
	}

	@Override
	public void eliminarParticipante(Participante participante) {
		participanteRepository.delete(participante);
	}

	@Override
	public List<Participante> getParticipanteById(Long idParticipante) {
		return participanteRepository.findAllByIdParticipante(idParticipante);
	}

}
