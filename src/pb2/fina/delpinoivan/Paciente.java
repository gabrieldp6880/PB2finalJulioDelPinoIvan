package pb2.fina.delpinoivan;

import java.util.HashSet;

public class Paciente implements Comparable <Paciente> {
	
	private String nomyape;
	private Integer dni;
	private HashSet <Vacuna> vacunasDelPaciente;
	private Boolean hepatitis = false;
	private Boolean rubeola = false;
	private Boolean covid1era = false;
	
	
	public Paciente(String nomyape, Integer dni, Vacuna vacunasDelPaciente) {
		this.nomyape = nomyape;
		this.dni = dni;
		this.vacunasDelPaciente = new HashSet <Vacuna>();
	}
	
	public void registrarHepatitis () {
		this.hepatitis = true;
	}
	
	public void registrarRubeola () {
		this.rubeola = true;
	}

	
	public boolean vacunadoContrCovid () {
		Integer cont = 0;
		for(Vacuna vc : vacunasDelPaciente) {
			if(vc.getNombre() == "Covid19 1era" || vc.getNombre() == "Covid19 2da") {
				cont++;
			}
		}
		if(cont == 2) {
			return true;
		}
		return false;
	}

	
	public Boolean getCovid1era() {
		return covid1era;
	}

	public void setCovid1era(Boolean covid1era) {
		this.covid1era = covid1era;
	}

	public String getNomyape() {
		return nomyape;
	}

	public void setNomyape(String nomyape) {
		this.nomyape = nomyape;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public HashSet<Vacuna> getVacunasDelPaciente() {
		return vacunasDelPaciente;
	}

	public void setVacunasDelPaciente(HashSet<Vacuna> vacunasDelPaciente) {
		this.vacunasDelPaciente = vacunasDelPaciente;
	}

	public Boolean getHepatitis() {
		return hepatitis;
	}

	public void setHepatitis(Boolean hepatitis) {
		this.hepatitis = hepatitis;
	}

	public Boolean getRubeola() {
		return rubeola;
	}

	public void setRubeola(Boolean rubeola) {
		this.rubeola = rubeola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		return this.dni.compareTo(o.getDni());
	}
	
	
}
