package pe.edu.delfines;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Test
	void contextLoads() {
		
		try {

			
			Vendedor vendedor1=new Vendedor();
			vendedor1.setId("VEN01");
			vendedor1.setNombre("Ramon");
			vendedor1.setDireccion("Av.la marina");
			vendedor1.setTelefono("8956235");
			vendedor1.setObservacion("Buen vendedor");
			vendedor1.setSueldo((float) 152.5);
			
			Vendedor vendedor2=new Vendedor();
			vendedor2.setId("VEN02");
			vendedor2.setNombre("Luis");
			vendedor2.setDireccion("San Miguel");
			vendedor2.setTelefono("899562356");
			vendedor2.setObservacion("Mal vendedor");
			vendedor2.setSueldo((float) 54.6);
			
			
			vendedor1=vendedorRepository.save(vendedor1);
			vendedor2=vendedorRepository.save(vendedor2);
			
			
			Alquiler alquiler1=new Alquiler();
			alquiler1.setPrecio(100);
			alquiler1.setFecha_entrada(new Date(2019,05,10));
			alquiler1.setFecha_salida(new Date(2019,05,12));
			alquiler1.setEstado("Activo");
			alquiler1.setObservacion("Buen precio alquiler");
			alquiler1.setVendedor(vendedor1);
			
			Alquiler alquiler2=new Alquiler();
			alquiler2.setPrecio(100);
			alquiler2.setFecha_entrada(new Date(2019,06,15));
			alquiler2.setFecha_salida(new Date(2019,06,17));
			alquiler2.setEstado("Activo");
			alquiler2.setObservacion("Regular precio alquiler");
			alquiler2.setVendedor(vendedor1);
			
			/*
			List<Alquiler>alquileres=Arrays.asList(alquiler1,alquiler2);
			this.alquilerRepository.saveAll(alquileres);
			*/
			
			alquiler1=alquilerRepository.save(alquiler1);
			alquiler2=alquilerRepository.save(alquiler2);
			
			
			Cliente cliente1=new Cliente();
			cliente1.setDocumento("85652365");
			cliente1.setNombre("Pedro");
			cliente1.setFechaNacimiento(new Date(1998,05,05));
			cliente1.setLugarNacimiento("La molina");
			cliente1.setSexo('M');
			cliente1.setObservacion("Buen cliente");
			
			Cliente cliente2=new Cliente();
			cliente2.setDocumento("8956325");
			cliente2.setNombre("Jean");
			cliente2.setFechaNacimiento(new Date(1995,10,11));
			cliente2.setLugarNacimiento("La molina");
			cliente2.setSexo('M');
			cliente2.setObservacion("Mal cliente");
			
			cliente1=clienteRepository.save(cliente1);
			cliente2=clienteRepository.save(cliente2);
			
			
			
			
			Tipo tipo1=new Tipo();
			tipo1.setId("TI01");
			tipo1.setNombre("Cara");
			
			Tipo tipo2=new Tipo();
			tipo2.setId("TI02");
			tipo2.setNombre("Barata");
			
			tipo1=tipoRepository.save(tipo1);
			tipo2=tipoRepository.save(tipo2);
			
			/*
			List<Tipo>tipos=Arrays.asList(tipo1,tipo2);
			this.tipoRepository.saveAll(tipos);
			
			*/
			
			
			Habitacion habitacion1=new Habitacion();
			habitacion1.setNumeroCamas(4);
			habitacion1.setDescripcion("Nueva cama");
			habitacion1.setPrecio((float) 56.4);
			habitacion1.setTipo(tipo1);
			habitacion1.setObservacion("habitacion grande");
			
			Habitacion habitacion2=new Habitacion();
			habitacion2.setNumeroCamas(2);
			habitacion2.setDescripcion("Cama usada");
			habitacion2.setPrecio((float) 20.5);
			habitacion2.setTipo(tipo1);
			habitacion2.setObservacion("habitacion pequeña");
			
			habitacion1=habitacionRepository.save(habitacion1);
			habitacion2=habitacionRepository.save(habitacion2);
			
			
			
			
			
			
			
			
			/*
			List<Habitacion>habitaciones=Arrays.asList(habitacion1,habitacion2);
			this.habitacionRepository.saveAll(habitaciones);
			*/
			
			
			
			
			
		
			
			
			
			/*
			List<Vendedor>vendedores=Arrays.asList(vendedor1,vendedor2);
			this.vendedorRepository.saveAll(vendedores);
			*/
			
		
			
			
			
			
			/*
			List<Cliente>clientes=Arrays.asList(cliente1,cliente2);
			this.clienteRepository.saveAll(clientes);
			*/
			
			
			
			
			
			
			/*  Vendedor - alquiler*/
			vendedor1.addAlquiler(alquiler2);
			
			
			/* alquiler -vendedor*/
			alquiler2.setVendedor(vendedor1);
			
			
			/*alquiler - habitacion  */
			alquiler1.setHabitacion(habitacion1);
			
			/* habitacion- alquiler */
			habitacion1.addAlquiler(alquiler1);
			
			
			/*alquiler -cliente  */
			alquiler1.setCliente(cliente2);
			
			/* cliente - alquiler */
			cliente2.addAlquiler(alquiler1);
			
			tipo2.addHabitacion(habitacion1);
			habitacion2.setTipo(tipo1);
			
			
			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor2);
			
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
			
			habitacionRepository.save(habitacion1);
			habitacionRepository.save(habitacion2);
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			
			
			
			
/*
			habitacion1.setTipo(tipo1);
			habitacion1.setTipo(tipo2);
			
			tipo2.addHabitacion(habitacion2);
			tipo1.addHabitacion(habitacion1);
			
			
			
			alquiler1.setVendedor(vendedor1);
			alquiler1.setCliente(cliente1);
			alquiler1.setHabitacion(habitacion1);
			
			
			vendedor1.addAlquiler(alquiler1);
			
			cliente1.addAlquiler(alquiler1);
			
			habitacion1.addAlquiler(alquiler1);
			
			*/
			
			
			
		
			
		
			
		
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	@Service
	public class InitDB implements CommandLineRunner{

	@Autowired
	private TipoRepository tipoRepository;
		
	@Override
	public void run(String... args) throws Exception {
		
		Tipo tipo1=new Tipo();
		tipo1.setId("TI01");
		tipo1.setNombre("Cara");
		
		Tipo tipo2=new Tipo();
		tipo2.setId("TI02");
		tipo2.setNombre("Barata");
		
		List<Tipo>tipos=Arrays.asList(tipo1,tipo2);
		this.tipoRepository.saveAll(tipos);
		
		
	}
	
	}
	*/
}
