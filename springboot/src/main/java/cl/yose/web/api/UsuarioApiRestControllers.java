package cl.yose.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.yose.web.models.Usuario;
import cl.yose.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestControllers {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping("/guardar/usuario")
	public Usuario guardarUsuario (@RequestBody Usuario usuario) {
		return usuarioServiceImpl.guardarUsuario(usuario);
	}

}
