package cl.yose.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.yose.web.models.ValoracionComentario;
import cl.yose.web.repositories.ValoracionComentarioRepository;


@Service
public class ValoracionComentarioServiceImpl implements ValoracionComentarioServices {
	
	@Autowired
	public ValoracionComentarioRepository valoracionRepository;
	
	@Override
	public ValoracionComentario guardarValoracion(ValoracionComentario valoracion) {
		// TODO Auto-generated method stub
		return valoracionRepository.save(valoracion);
	}

}
