package cl.yose.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.yose.web.models.Recover;
import cl.yose.web.repositories.RecoverRepository;

@Service
public class RecoverServiceimplement implements RecoverService {
	@Autowired
	public RecoverRepository recoRepo;

//--------------------------------------------------------------	
	@Override
	public Recover guardarRecover(Recover recover) {
		// TODO Auto-generated method stub
		return recoRepo.save(recover);
	}
//--------------------------------------------------------------
	@Override
	public String eliminarRecover(Long id) {
		Boolean existe = recoRepo.existsById(id);

		if (existe) {
			// elimino el usuario pasando el id (pk)
			recoRepo.deleteById(id);
		} else {
			return "Recover no existe en la tabla";
		}

		existe = recoRepo.existsById(id);

		// si es distinto de nulo, no fue eliminado
		if (existe) {
			return "Recover no eliminado";
		}

		return "El Recover fue eliminado";
	}
//-------------------------------------------------------------------
	@Override
	public String actualizarRecover(Recover recover) {

		Boolean existe = recoRepo.existsById(recover.getId());

		if (existe) {
			recoRepo.save(recover);
			return "Recover actualizado";
		}
		return "Recover no actualizado";
	}

//-------------------------------------------------------------------
	@Override
	public Recover obtenerRecover(Long id) {
		// Optional<Usuario> user = usuarioRepository.findById(id);
		Boolean existe = recoRepo.existsById(id);

		if (existe) {
			Recover recover = recoRepo.findById(id).get();
			return recover;
		}
		return null;
	}

//-------------------------------------------------------------------

	@Override
	public List<Recover> obtenerListaRecover() {
		// obtener todos los usuarios
		return recoRepo.findAll();
	}

// -------------------------------------------------------------------
	@Override
	public Optional<Recover> obtenerDatosRecover(Long id) {
		Optional<Recover> mensaje = recoRepo.findById(id);
		return mensaje;
	}

}
