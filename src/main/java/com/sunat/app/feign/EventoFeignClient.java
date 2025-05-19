package com.sunat.app.feign;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "ms-eventos", url = "${eventos.service.url}")
@FeignClient(name = "ms-eventos")
public interface EventoFeignClient {

	@GetMapping("/eventos/{id}")
	Evento obtenerEventoPorId(@PathVariable Long id);
	
	@PutMapping("/eventos/{id}")
	Evento actualizarPorId(@PathVariable Long id, @RequestBody Evento evento);
	
	public class Evento {
		private Long id;
		private String nombre;
		private String descripcion;
		private Date fecha;
		private String ubicacion;
		private Integer capacidad;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public String getUbicacion() {
			return ubicacion;
		}

		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}

		public Integer getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(Integer capacidad) {
			this.capacidad = capacidad;
		}

	}
	
}
