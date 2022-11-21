package cl.yose.web.services;

import java.util.List;
import java.util.Optional;

import cl.yose.web.models.Recover;

public interface RecoverService {
	
	public Recover guardarRecover(Recover recover);

	List<Recover> obtenerListaRecover();

	String eliminarRecover(Long id);

	String actualizarRecover(Recover recover);

	Recover obtenerRecover(Long id);

	Optional<Recover> obtenerDatosRecover(Long id);

}
