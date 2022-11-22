package cl.yose.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.yose.web.models.ValoracionComentario;
import cl.yose.web.services.ValoracionComentarioServiceImpl;


@RestController
public class ValoracionComentarioApiRestController {
	
	@Autowired
	private ValoracionComentarioServiceImpl valoracionServiceImpl;

	// http://localhost:8080/guardar/valoracion
	@RequestMapping("/guardar/valoracion")
	public ValoracionComentario guardarValoracion(@RequestBody ValoracionComentario valoracion) {
		return valoracionServiceImpl.guardarValoracion(valoracion);
	}
}
