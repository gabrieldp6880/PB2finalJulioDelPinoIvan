package pb2.fina.delpinoivan;

public class NoCovidVaccineException extends Exception {
	
	public NoCovidVaccineException () {
		super("No tiene primer vacuna de covid");
	}
}
