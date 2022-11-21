package cl.yose.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.yose.web.models.Posteo;
import cl.yose.web.repositories.PosteoRepository;

@Service
public class PosteoServiceImplement implements PosteoService {
	@Autowired
	public PosteoRepository posteoRepository;

	@Override
	public Posteo guardarPosteo(Posteo posteo) {
		// TODO Auto-generated method stub
		return posteoRepository.save(posteo);
	}
//--------------------------------------------------------------------------------

	@Override
	public String eliminarPosteo(Long id) {
		Boolean existe = posteoRepository.existsById(id);

		if (existe) {
			// elimino el posteo pasando el id (pk)
			posteoRepository.deleteById(id);
		} else {
			return "Posteo no existe en la tabla";
		}

		existe = posteoRepository.existsById(id);

		// si es distinto de nulo, no fue eliminado
		if (existe) {
			return "posteo no eliminado";
		}

		return "El Posteo fue eliminado";
	}

//------------------------------------------------------------------------------------------
	@Override
	public String actualizarPosteo(Posteo posteo) {

		Boolean existe = posteoRepository.existsById(posteo.getId());

		if (existe) {
			posteoRepository.save(posteo);
			return "Posteo actualizado";
		}
		return "Posteo no actualizado";
	}

//-------------------------------------------------------------------
	@Override
	public Posteo obtenerPosteo(Long id) {
		// Optional<Usuario> user = usuarioRepository.findById(id);
		Boolean existe = posteoRepository.existsById(id);

		if (existe) {
			Posteo posteo = posteoRepository.findById(id).get();
			return posteo;
		}
		return null;
	}

//-----------------------------------------------------------------------

	public List<Posteo> obtenerListaPosteos() {
		// TODO Auto-generated method stub
		return posteoRepository.findAll();
	}
//-------------------------------------------------------------

	@Override
	public Optional<Posteo> obtenerDatosPosteo(Long id) {
		Optional<Posteo> mensaje = posteoRepository.findById(id);
		return mensaje;
	}
}
