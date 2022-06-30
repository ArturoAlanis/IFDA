package Model;

public class Charge {
	private int codeCharge;
	private String charge;
	private double u;
	private double v;
	private double pi;
	
	public Charge(int codeCharge, String charge, double u, double v, double pi) {
		this.codeCharge = codeCharge;
		this.charge = charge;
		this.u = u;
		this.v = v;
		this.pi = pi;
	}

	public int getCodeCharge() {
		return codeCharge;
	}

	public void setCodeCharge(int codeCharge) {
		this.codeCharge = codeCharge;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
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
	
	public double getPesoProvisional() {
		return (u+(pi*((u)/(u+v))));
	}

	@Override
	public String toString() {
		return charge;
	}

}
