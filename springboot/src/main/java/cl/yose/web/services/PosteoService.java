package cl.yose.web.services;

import java.util.Optional;

import cl.yose.web.models.Posteo;


public interface PosteoService {

	public Posteo guardarPosteo(Posteo posteo);

	String eliminarPosteo(Long id);
	public String actualizarPosteo(Posteo posteo);

	Posteo obtenerPosteo(Long id);

	Optional<Posteo> obtenerDatosPosteo(Long id);

}
