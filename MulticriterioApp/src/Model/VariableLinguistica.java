package Model;

public class VariableLinguistica {
	private int codeVarLing;
	private String nameVarLing;
	private String abreviationVarLing;
	private double u;
	private double v;
	private double pi;
	
	public VariableLinguistica(int codeVarLing, String nameVarLing, String abreviationVarLing, double u, double v, double pi) {
		this.codeVarLing = codeVarLing;
		this.nameVarLing = nameVarLing;
		this.abreviationVarLing = abreviationVarLing;
		this.u = u;
		this.v = v;
		this.pi = pi;
	}

	public int getCodeCriterio() {
		return codeVarLing;
	}

	public void setCodeCriterio(int codeCriterio) {
		this.codeVarLing = codeCriterio;
	}


	public String getNameCriterio() {
		return nameVarLing;
	}

	public void setNameCriterio(String nameCriterio) {
		this.nameVarLing = nameCriterio;
	}

	public String getAbreviationCriterio() {
		return abreviationVarLing;
	}

	public void setAbreviationCriterio(String abreviationCriterio) {
		this.abreviationVarLing = abreviationCriterio;
	}

	public double getU() {
		return u;
	}

	public void setU(double u) {
		this.u = u;
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
		return nameVarLing;
	}
	
	public String toString2() {
		return nameVarLing + "," + u + "," + v + "," + pi;
	}

}


