package pb2.fina.delpinoivan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;


public class testCentro {
	
	
	@Test
	public void queUnPacienteEsteVacunadoContraCovid () throws NoMoreVaccineException, NoCovidVaccineException {
		Paciente p1 = new Paciente ("Ivan Del Pino", 1234);
		Vacuna v1 = new Vacuna ("Covid19 1era");
		Vacuna v2 = new Vacuna ("Covid19 2da");
		Centro c1 = new Centro ("Club Flecha");
		
		c1.vacunarPaciente(p1, v1);
		c1.vacunarPaciente(p1, v2);
		
		assertTrue(p1.vacunadoContrCovid());
		
	}
	
	@Test(expected = NoMoreVaccineException.class)
	public void queArrojeExecpcionDeMasDeDosVacunas () throws NoMoreVaccineException, NoCovidVaccineException {
		Paciente p1 = new Paciente ("Ivan Del Pino", 1234);
		Vacuna v1 = new Vacuna ("Rubeola");
		Vacuna v2 = new Vacuna ("Hepatitis A");
		Vacuna v3 = new Vacuna ("Hepatitis B");
		Centro c1 = new Centro ("Club Flecha");
		
		c1.vacunarPaciente(p1, v1);
		c1.vacunarPaciente(p1, v2);
		c1.vacunarPaciente(p1, v3);
		
	}
	
	@Test(expected = NoCovidVaccineException.class)
	public void queNoPuedaRecibirSegundaVacunaCovid () throws NoMoreVaccineException, NoCovidVaccineException {
		Paciente p1 = new Paciente ("Ivan Del Pino", 1234);
		Vacuna v1 = new Vacuna ("Rubeola");
		Vacuna v2 = new Vacuna ("Covid19 2da");
		Centro c1 = new Centro ("Club Flecha");
		
		c1.vacunarPaciente(p1, v1);
		c1.vacunarPaciente(p1, v2);
		
	}
	
	@Test
	public void queNoPuedaVacunarseSiTuvoLaEnfermedad () {
		Paciente p1 = new Paciente ("Ivan Del Pino", 1234);
		Vacuna v1 = new Vacuna ("Rubeola");
		Centro c1 = new Centro ("Club Flecha");
		
		p1.setRubeola(true);
		Boolean esperado = false;
		
		try {
			Boolean real = c1.vacunarPaciente(p1, v1);
			assertEquals(esperado,real);
		} catch (NoMoreVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoCovidVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void queTengaPacientesOrdenados () {
		Paciente p1 = new Paciente ("Ivan Del Pino", 4524);
		Paciente p2 = new Paciente ("Gabriel Del Pino", 1123);
		Paciente p3 = new Paciente ("Beatriz Del Pino", 4524);
		Vacuna v1 = new Vacuna ("Rubeola");
		Vacuna v2 = new Vacuna ("Hepatitis A");
		Centro c1 = new Centro ("Club Flecha");
		
		try {
			c1.vacunarPaciente(p1, v1);
		} catch (NoMoreVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoCovidVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c1.agregarListaPacientesVacunados(p1);
		
		try {
			c1.vacunarPaciente(p2, v2);
		} catch (NoMoreVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoCovidVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c1.agregarListaPacientesVacunados(p2);
		
		
		try {
			c1.vacunarPaciente(p3, v1);
		} catch (NoMoreVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoCovidVaccineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c1.agregarListaPacientesVacunados(p3);
		
		Integer i = 0;

		Iterator<Paciente> it = c1.getPacientesVacunados().iterator();

		while (it.hasNext()) {
			Paciente l = it.next();
			switch (i) {
			case 0:
				String esperado1 = "Gabriel Del Pino";
				String real1 = l.getNomyape();
				assertEquals(esperado1, real1);
				i++;
				break;
			case 1:
				String esperado2 = "Beatriz Del Pino";
				String real2 = l.getNomyape();
				assertEquals(esperado2, real2);
				i++;
				break;
			}
		}
		
	}
	
}
