package Model;

public class Criterio {
	private int codeCriterio;
	private String nameCriterio;
	private String abreviationCriterio;
	private double u;
	private double v;
	private double pi;

	public Criterio(int codeCriterio, String nameCriterio, String abreviationCriterio, double u, double v, double pi) {
		this.codeCriterio = codeCriterio;
		this.nameCriterio = nameCriterio;
		this.abreviationCriterio = abreviationCriterio;
		this.u = u;
		this.v = v;
		this.pi = pi;
	}

	public int getCodeCriterio() {
		return codeCriterio;
	}

	public void setCodeCriterio(int codeCriterio) {
		this.codeCriterio = codeCriterio;
	}

	public String getNameCriterio() {
		return nameCriterio;
	}

	public void setNameCriterio(String nameCriterio) {
		this.nameCriterio = nameCriterio;
	}

	public String getAbreviationCriterio() {
		return abreviationCriterio;
	}

	public void setAbreviationCriterio(String abreviationCriterio) {
		this.abreviationCriterio = abreviationCriterio;
	}

	public double getU() {
		return u;
	}

	public void setU(double valueCriterio) {
		this.u = valueCriterio;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}

	@Override
	public String toString() {
		return nameCriterio;
	}

	public String toString2() {
		return nameCriterio + "," + u + "," + v + "," + pi;
	}

}
