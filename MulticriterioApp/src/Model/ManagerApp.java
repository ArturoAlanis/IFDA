package Model;

import java.util.ArrayList;

public class ManagerApp {
	private ArrayList<Account> listAccounts;
	
	public ManagerApp() {
		listAccounts = new ArrayList<Account>();
	}
	
	public void addAccount(Account account) {
		listAccounts.add(account);
	}
	
	public Account getAccount(String email) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return listAccounts.get(i);
			}
		}
		return null;
	}
	
	public String getNameAccount(String email) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return listAccounts.get(i).getName() + " " + listAccounts.get(i).getLastName();
			}
		}
		return null;
	}
	
	public boolean existAccount(String email) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateCredentials(String email, String password) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email) && listAccounts.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public void addDecisor(String emailAccount, Decisor decisor) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(emailAccount)) {
				listAccounts.get(i).getListDecisors().add(decisor);
				break;
			}
		}
	}
	
	public void addCriterio(String email, Criterio criterio) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				listAccounts.get(i).getListCriterios().add(criterio);
				break;
			}
		}
	}
	
	public void addCharge(String email, Charge charge) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				listAccounts.get(i).getListCharges().add(charge);
				break;
			}
		}
	}
	
	public void addVarLing(String email, VariableLinguistica varLing) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				listAccounts.get(i).getListVarLing().add(varLing);
				break;
			}
		}
	}
	
	public ArrayList<Decisor> getListDecisors(String email){
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return listAccounts.get(i).getListDecisors();
			}
		}
		return null;
	}
	
	public ArrayList<Criterio> getListCriterios(String email){
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return listAccounts.get(i).getListCriterios();
			}
		}
		return null;
	}

	public ArrayList<Charge> getListCharges(String email){
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return listAccounts.get(i).getListCharges();
			}
		}
		return null;
	}
	
	public ArrayList<VariableLinguistica> getListVarLing(String email){
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				return listAccounts.get(i).getListVarLing();
			}
		}
		return null;
	}
	
//	public void setDecisor(String email, int codeCriterio, String name, String abreviation, double value ) {
//		for (int i = 0; i < listAccounts.size(); i++) {
//			if (listAccounts.get(i).getEmail().equals(email)) {
//				for (int j = 0; j < listAccounts.get(i).getListCriterios().size(); j++) {
//					if (listAccounts.get(i).getListCriterios().get(j).getCodeCriterio() == codeCriterio) {
//						listAccounts.get(i).getListCriterios().get(j).setAbreviationCriterio(abreviation);
//						listAccounts.get(i).getListCriterios().get(j).setNameCriterio(name);
//						listAccounts.get(i).getListCriterios().get(j).setValueCriterio(value);
//					}
//				}
//			}
//		}
//	}
	
	public void setCriterio(String email, int codeCriterio, String name, String abreviation, double value ) {
		for (int i = 0; i < listAccounts.size(); i++) {
			if (listAccounts.get(i).getEmail().equals(email)) {
				for (int j = 0; j < listAccounts.get(i).getListCriterios().size(); j++) {
					if (listAccounts.get(i).getListCriterios().get(j).getCodeCriterio() == codeCriterio) {
						listAccounts.get(i).getListCriterios().get(j).setAbreviationCriterio(abreviation);
						listAccounts.get(i).getListCriterios().get(j).setNameCriterio(name);
//						listAccounts.get(i).getListCriterios().get(j).setValueCriterio(value);
					}
				}
			}
		}
	}
	
	
}
