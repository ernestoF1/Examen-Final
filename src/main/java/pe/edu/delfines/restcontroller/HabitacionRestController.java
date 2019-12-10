package pe.edu.delfines.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.services.HabitacionService;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionRestController {
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping(path="/cantidad",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String>CantidadHabitacion(){
		try {
			Integer cantidad=habitacionService.fetchCantidadHabitacion();
		
			return new ResponseEntity<String>(cantidad.toString(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
