package cl.yose.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cl.yose.web.models.Recover;
import cl.yose.web.services.RecoverServiceimplement;

@RestController
public class RecoverApiRestcontroller {
	
	@Autowired
	private RecoverServiceimplement recoServImpl;
	
	@RequestMapping("/guardar/recover")
	public Recover guardarRecover(@RequestBody Recover recover) {
		
		// http://localhost:8080/guardar/posteo
		
		return recoServImpl.guardarRecover(recover);
	}	
//----------------------------------------------------------------------------
	
	@RequestMapping("/eliminar/recover")
	public String eliminarRecover(@RequestParam(value="id",required = false) Long id) {
		//llamando el metodo eliminar en el service
		/*String respuesta = usuarioServiceImpl.eliminarUsuario(id);
		return respuesta;*/
		return recoServImpl.eliminarRecover(id);
	}
//----------------------------------------------------------------------------
	
	@RequestMapping("/actualizar/recover")
	public String actualizarRecover(@RequestBody Recover recover) {
		//validacion logica
		if(recover.getId()!=null) {
			String mensaje =  recoServImpl.actualizarRecover(recover);
			return mensaje;
		}
		return "No se actualizara ningun Recover";
	}
//----------------------------------------------------------------------------	
	
	@RequestMapping("/obtener/recover")
	public Recover obtenerRecover(@RequestParam(value="id",required = true) Long id) {
		
		return recoServImpl.obtenerRecover(id);
	}
//----------------------------------------------------------------------------		
	
	
// ahora obtenemos el usuario a partir del id
		// http://localhost:8080/obtenerdato/usuario
		@RequestMapping("/obtenerdato/recover")
		public Optional<Recover> obtenerDatosRecover(@RequestParam(value = "id", required = true) Long id) {
				
			return recoServImpl.obtenerDatosRecover(id);
		}
//----------------------------------------------------------------------------	
		
	//listar todos los usuarios
	@GetMapping("/listar/recover")
	public List<Recover> obtenerListaUsuarios(){
		return recoServImpl.obtenerListaRecover();
	}	
}
