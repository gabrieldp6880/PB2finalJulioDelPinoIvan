package pb2.fina.delpinoivan;

import java.util.TreeSet;

public class Centro {
	
	private String nombreCentro;
	private TreeSet <Paciente> pacientesVacunados;
	
	public Centro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
		this.pacientesVacunados = new TreeSet <> ();
	}
	
	public Integer obtenerCantidadDeVacunasDelPaciente (Paciente p) {
		return p.getVacunasDelPaciente().size();
	}
	
	public boolean vacunarPaciente (Paciente p, Vacuna v) throws NoMoreVaccineException, NoCovidVaccineException {
		
		Integer cantidad = obtenerCantidadDeVacunasDelPaciente(p);
		
		if(cantidad <= 2) {
			if(p.vacunadoContrCovid()==false && cantidad == 2) {
				throw new NoMoreVaccineException();
			}
			
			if(v.getNombre()=="Covid19 1era") {
				p.getVacunasDelPaciente().add(v);
				p.setCovid1era(true);
				return true;
			}
			
			if(v.getNombre()=="Covid19 2da") {
				if(p.getCovid1era()==true) {
					p.getVacunasDelPaciente().add(v);
					return true;
				}
				throw new NoCovidVaccineException();
			}
			
			if(v.getNombre()=="Hepatitis A"||v.getNombre()=="Hepatitis B"||v.getNombre()=="Hepatitis c") {
				if(p.getHepatitis()==false) {
					p.getVacunasDelPaciente().add(v);
					return true;
				}else {
					return false;
				}
			}
			
			if(v.getNombre()=="Rubeola") {
				if(p.getRubeola()==false) {
					p.getVacunasDelPaciente().add(v);
					return true;
				}else {
					return false;
				}
			}
			
		}
		return false;
		
		
	}
	
	public void agregarListaPacientesVacunados (Paciente p) {
		Integer cantidad = obtenerCantidadDeVacunasDelPaciente(p);
		if(cantidad > 0) {
			this.pacientesVacunados.add(p);
		}
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public TreeSet<Paciente> getPacientesVacunados() {
		return pacientesVacunados;
	}

	public void setPacientesVacunados(TreeSet<Paciente> pacientesVacunados) {
		this.pacientesVacunados = pacientesVacunados;
	}
	
	
	
}
