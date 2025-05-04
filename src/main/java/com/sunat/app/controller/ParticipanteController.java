package com.sunat.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunat.app.entities.Participante;
import com.sunat.app.service.IParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
	private final IParticipanteService participanteService;
	
	public ParticipanteController(IParticipanteService participanteService) {
		this.participanteService = participanteService;
	}
	
	@GetMapping
	public ResponseEntity<List<Participante>> listarParticipantes() {
		return ResponseEntity.ok(participanteService.listarParticipantes());
	}
	
	@GetMapping("/{idParticipante}")
	public ResponseEntity<List<Participante>> getParticipanteById(@PathVariable Long idParticipante) {
		return ResponseEntity.ok(participanteService.getParticipanteById(idParticipante));
	}

	@PostMapping
	public ResponseEntity<Participante> agregarDeseo(@RequestBody Participante participante) {
		return ResponseEntity.ok(participanteService.agregarEvento(participante));
	}

	@DeleteMapping
	public ResponseEntity<Void> eliminarDeseo(@RequestBody Participante participante) {
		participanteService.eliminarParticipante(participante);
		return ResponseEntity.noContent().build();
	}

}
