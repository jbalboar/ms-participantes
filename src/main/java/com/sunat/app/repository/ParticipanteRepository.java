package com.sunat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunat.app.entities.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>  {

	List<Participante> findAllByIdParticipante(Long idParticipante);
	
	boolean existsByIdParticipanteAndIdEvento(Long idParticipante, Long idEvento);
}
