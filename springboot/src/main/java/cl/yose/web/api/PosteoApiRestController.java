package cl.yose.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cl.yose.web.models.Posteo;
import cl.yose.web.services.PosteoServiceImplement;


@RestController
public class PosteoApiRestController {
	
	@Autowired
	private PosteoServiceImplement postServiceImpl;
	
	// http://localhost:9084/guardar/posteo
	@RequestMapping("/guardar/posteo")
	public Posteo guardarPost(@RequestBody Posteo posteo) {
		
		// http://localhost:8080/guardar/posteo
		
		return postServiceImpl.guardarPosteo(posteo);
	}
	@RequestMapping("/eliminar/posteo")
	public String eliminarPosteo(@RequestParam(value="id",required = false) Long id) {
		//llamando el metodo eliminar en el service
		/*String respuesta = usuarioServiceImpl.eliminarUsuario(id);
		return respuesta;*/
		return postServiceImpl.eliminarPosteo(id);
	}

	@RequestMapping("/actualizar/posteo")
	public String actualizarPosteo(@RequestBody Posteo posteo) {
		//validacion logica
		if(posteo.getId()!=null) {
			String mensaje =  postServiceImpl.actualizarPosteo(posteo);
			return mensaje;
		}
		return "No se actualizara ningun posteo";
	}
	
	@RequestMapping("/obtener/posteo")
	public Posteo obtenerPosteo(@RequestParam(value="id",required = true) Long id) {
		
		return postServiceImpl.obtenerPosteo(id);
	}
	// ahora obtenemos el usuario a partir del id
		// http://localhost:8080/obtenerdato/usuario
		@RequestMapping("/obtenerdato/posteo")
		public Optional<Posteo> obtenerDatosPosteo(@RequestParam(value = "id", required = true) Long id) {
				
			return postServiceImpl.obtenerDatosPosteo(id);
		}
		
	//listar todos los usuarios
	@GetMapping("/listar/posteo")
	public List<Posteo> obtenerListaPosteos(){
		return postServiceImpl.obtenerListaPosteos();
	}	

	
}
