package Model;

public class Decisor {
	private int idDecisor;
	private String nameDecisor;
	private String lastNameDecisor;
	private String emailDecisor;
	private Charge charge;
	
	public Decisor(int idDecisor, String nameDecisor, String lastNameDecisor, String emailDecisor, Charge charge) {
		this.idDecisor = idDecisor;
		this.nameDecisor = nameDecisor;
		this.lastNameDecisor = lastNameDecisor;
		this.emailDecisor = emailDecisor;
		this.charge = charge;
	}
	
	public int getIdDecisor() {
		return idDecisor;
	}

	public void setIdDecisor(int idDecisor) {
		this.idDecisor = idDecisor;
	}

	public String getNameDecisor() {
		return nameDecisor;
	}

	public void setNameDecisor(String nameDecisor) {
		this.nameDecisor = nameDecisor;
	}

	public String getLastNameDecisor() {
		return lastNameDecisor;
	}

	public void setLastNameDecisor(String lastNameDecisor) {
		this.lastNameDecisor = lastNameDecisor;
	}

	public String getEmailDecisor() {
		return emailDecisor;
	}

	public void setEmailDecisor(String emailDecisor) {
		this.emailDecisor = emailDecisor;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	
	@Override
	public String toString() {
		return idDecisor + " " + nameDecisor + " " + lastNameDecisor;
	}
	

}
