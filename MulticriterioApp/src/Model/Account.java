package Model;

import java.util.ArrayList;

public class Account {
	private String name;
	private String lastName;
	private String birthday;
	private String telephone;
	private String email;
	private String password;
	private ArrayList<Decisor> listDecisors;
	private ArrayList<Criterio> listCriterios;
	private ArrayList<Charge> listCharges;
	private ArrayList<VariableLinguistica> listVarLing;
	
	public Account(String name, String lastName, String bithday, String telephone, String email, String password, ArrayList<Decisor> listDecisors,
			ArrayList<Criterio> listCriterios, ArrayList<Charge> listCharges, ArrayList<VariableLinguistica> listVarLing) {
		this.name = name;
		this.lastName = lastName;
		this.birthday = bithday;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.listDecisors = listDecisors;
		this.listCriterios = listCriterios;
		this.listCharges = listCharges;
		this.listVarLing = listVarLing;
	}
	
	public void addDecisor(Decisor decisor) {
		listDecisors.add(decisor);
	}
	
	public boolean verifyExitEmailOfDecisor(String emailOfDecisor) {
		for (int i = 0; i < listDecisors.size(); i++) {
			if (listDecisors.get(i).getEmailDecisor().equals(emailOfDecisor)) {
				return true;
			}
		}
		return false;
	}
	
	public void addCriterio(Criterio criterio) {
		listCriterios.add(criterio);
	}
	
	public void addCharge(Charge charge) {
		listCharges.add(charge);
	}
	
	public void addVarLing(VariableLinguistica varLing) {
		listVarLing.add(varLing);
	}

	public ArrayList<Decisor> getListDecisors() {
		return listDecisors;
	}

	public ArrayList<Criterio> getListCriterios() {
		return listCriterios;
	}

	public ArrayList<Charge> getListCharges() {
		return listCharges;
	}

	public ArrayList<VariableLinguistica> getListVarLing() {
		return listVarLing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
