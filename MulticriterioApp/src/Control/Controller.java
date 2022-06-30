package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Account;
import Model.Charge;
import Model.Criterio;
import Model.Decisor;
import Model.ManagerApp;
import Model.VariableLinguistica;
import View.IoManager;

public class Controller implements ActionListener {
	private IoManager io;
	private ManagerApp manager;
	private Account account;
	private ArrayList<Decisor> listDecisors;
	private ArrayList<Criterio> listCriterios;
	private ArrayList<Charge> listCharges;
	private ArrayList<VariableLinguistica> listVarLing;
	// ---------------------------------------------Calculos estos
	private ArrayList<String> listBenfitCostTextForSend;
	private ArrayList<Decisor> listDecisorsSelected;
	private ArrayList<String> listNameCriterios;
	private ArrayList<String> listNameCriteriosAndBenfitCost;
	private ArrayList<Double> listPesoDecisor; // mi paso 1
	private String[][] matrizpesoCriterios; // mi paso 2
	private Double[][] matrizPesoCriteriosUV; // mi paso 3
	private Double[][] matrizPesoCriteriosUVConvertida; // mi paso 4
	private ArrayList<Double> listA; // mi paso 5
	private ArrayList<Double> listB; // mi paso 5
	private ArrayList<Double> listZ; // mi paso 5
	private ArrayList<Double> listAlfa; // mi paso 5
	private ArrayList<Double> listBenfitCostNumeric; // mi paso 5
	private ArrayList<String> listBenfitCostText; // mi paso 5
	private ArrayList<Double[][]> listMatricesN; // mi paso 6 A
	private ArrayList<Double[][]> listMatricesPorAlternativaN; // mi paso 6 B
	private ArrayList<Double[][]> listMatricesPorAlternativaNConvert; // mi paso 6 C
	private ArrayList<ArrayList<Double>> listAofAlternatives; // mi paso 6D
	private ArrayList<ArrayList<Double>> listBofAlternatives; // mi paso 6D
	private ArrayList<ArrayList<Double>> listZofAlternatives; // mi paso 6D
	private Double[][] matrizUnica; // mi paso 7
	private ArrayList<Double> listS; // mi paso 8
	private Double[][] matrizXjSj; // mi paso 9
	private Double[][] matrizXjSjConW; // mi paso 10
	private Double[][] matrizUVFinal; // mi paso 11
	private double[][] matrizResultados; // mi paso 12
	// ----------------------------------------------

	public Controller() {
		io = new IoManager("Multicriterio", this);
		manager = new ManagerApp();
		this.createAccounts();
		io.setLocationRelativeTo(null);
	}

	private void createAccounts() {
		Account account = new Account("Jose", "Vargas", "7/dic/99", "3109632596", "jose1@email.com", "hr",
				createDecisors(), createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);
		account = new Account("Andres", "Viviescas", "7/dic/99", "3109632596", "andres@email.com", "hr",
				createDecisors(), createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);
		account = new Account("Juan", "Gomez", "7/dic/99", "3109632596", "juan1@email.com", "hr", createDecisors(),
				createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);
		account = new Account("Felipe", "Bernal", "7/dic/99", "3109632596", "felipe1@email.com", "hr", createDecisors(),
				createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);
		account = new Account("Diego", "Burgos", "7/dic/99", "3109632596", "diego1@email.com", "hr", createDecisors(),
				createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);
		account = new Account("Andres", "Jara", "7/dic/99", "3109632596", "andres1@email.com", "hr", createDecisors(),
				createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);
		account = new Account("Laura", "Saenz", "7/dic/99", "3109632596", "laura1@email.com", "hr", createDecisors(),
				createCriterios(), createCharges(), createVarLing());
		manager.addAccount(account);

	}

	private ArrayList<Charge> createCharges() {
		ArrayList<Charge> listcharges = new ArrayList<Charge>();
		Charge charge = new Charge(1, "Beginner (B)", 0.1, 0.9, 0);
		listcharges.add(charge);
		charge = new Charge(2, "Practitioner (Pr)", 0.35, 0.6, 0.05);
		listcharges.add(charge);
		charge = new Charge(3, "Proficient (Pt)", 0.5, 0.45, 0.05);
		listcharges.add(charge);
		charge = new Charge(4, "Expert (E)", 0.75, 0.2, 0.05);
		listcharges.add(charge);
		charge = new Charge(5, "Master (M)", 0.9, 0.1, 0);
		listcharges.add(charge);
		return listcharges;
	}

	private ArrayList<Decisor> createDecisors() {
		ArrayList<Decisor> listDecisors = new ArrayList<Decisor>();
		Decisor decisor = new Decisor(1, "Andres", "Viviescas", "andres@email.com", this.createCharges().get(4));
		listDecisors.add(decisor);
		decisor = new Decisor(2, "Jorge", "Gonzales", "Jorge@email.com", this.createCharges().get(3));
		listDecisors.add(decisor);
		decisor = new Decisor(3, "Felipe", "Bernal", "felipe@email.com", this.createCharges().get(2));
		listDecisors.add(decisor);
		decisor = new Decisor(4, "Sebastian", "Gonzales", "sebastian@email.com", this.createCharges().get(1));
		listDecisors.add(decisor);
		decisor = new Decisor(5, "Ana", "Fuentes", "ana@email.com", this.createCharges().get(0));
		listDecisors.add(decisor);
//		decisor = new Decisor(6, "Liliana", "Bayona", "liliana@email.com", this.createCharges().get(1));
//		listDecisors.add(decisor);
		return listDecisors;
	}

	private ArrayList<Criterio> createCriterios() {
		ArrayList<Criterio> listCriterios = new ArrayList<Criterio>();
		Criterio criterio = new Criterio(1, "Very Unimportat (VU)", "(VU)", 0.1, 0.9, 0);
		listCriterios.add(criterio);
		criterio = new Criterio(2, "Unimportat (U)", "(U)", 0.35, 0.6, 0.05);
		listCriterios.add(criterio);
		criterio = new Criterio(3, "Medium (M)", "(M)", 0.5, 0.45, 0.05);
		listCriterios.add(criterio);
		criterio = new Criterio(4, "Important (I)", "(I)", 0.75, 0.2, 0.05);
		listCriterios.add(criterio);
		criterio = new Criterio(5, "Very Important (VI)", "(VI)", 0.9, 0.1, 0);
		listCriterios.add(criterio);
		criterio = new Criterio(6, "Veryfff Important (VI)", "(VI)", 0.9, 0.1, 0);
		listCriterios.add(criterio);
		return listCriterios;
	}

	private ArrayList<VariableLinguistica> createVarLing() {
		ArrayList<VariableLinguistica> listVatLing = new ArrayList<VariableLinguistica>();
		VariableLinguistica varLing = new VariableLinguistica(1, "Extremely Bad (EB) / Extremely Low (EL)", "(EB/EL)",
				0.1, 0.90, 0);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(2, "Very Bad (VB) / Very Low (VL)", "(VB/VL)", 0.1, 0.75, 0.15);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(3, "Bad (B) / Low (L)", "(B/L)", 0.25, 0.60, 0.15);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(4, "Medium Bad (MB) / Medium Low (ML)", "(MB/ML)", 0.40, 0.50, 0.1);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(5, "Fair (F) / Medium (M)", "(F/M)", 0.50, 0.40, 0.1);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(6, "Medium Good (MG) / Medium High (MH)", "(MG/MH)", 0.60, 0.30, 0.10);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(7, "Good (G) / High (H)", "(G/H)", 0.70, 0.20, 0.10);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(8, "Very Good (VG) / Very High (VH)", "(VG/VH)", 0.8, 0.10, 0.10);
		listVatLing.add(varLing);
		varLing = new VariableLinguistica(9, "Excellent (E) / Extremely High (EH)", "(E/EH)", 1.0, 0, 0);
		listVatLing.add(varLing);
		return listVatLing;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fuente = e.getActionCommand();
		switch (fuente) {
		case IoManager.CLOSE_INFORMATION:
			this.closeInformation();
			break;
		case IoManager.MODIFY_DATA:
			this.openModifyData();
			break;
		case IoManager.ACCEPT_OPTION_EDIT:
			this.openOptionSelectd();
			break;
		case IoManager.OPEN_ADD_CRITERIO:
			this.openAddCriterio();
			break;
		case IoManager.OPEN_MODIFY_CRITERIO:
			this.openModifyCriterio();
			break;
		case IoManager.OPEN_DELETE_CRITERIO:
			this.OpenDeleteCriterio();
			break;
		case IoManager.OPEN_ADD_VARLING:
			this.openAddVarLing();
			break;
		case IoManager.OPEN_MODIFY_VARLING:
			this.openModifyVarLing();
			break;
		case IoManager.OPEN_DELETE_VARLING:
			this.OpenDeleteVarLing();
			break;
		case IoManager.ACCEPT_DELETE_VARLING:
			this.processDeleteVarling();
			break;
		case IoManager.ACCEPT_DELETE_CRITERIO:
			this.processDeleteCriterio();
			break;
		case IoManager.ACCEPT_MODIFY_VARLING:
			this.processModifyVarling();
			break;
		case IoManager.ACCEPT_MODIFY_CRITERIO:
			this.processModifyCriterio();
			break;
		case IoManager.ACCEPT_ADD_VARLING:
			this.processAddVarling();
			break;
		case IoManager.ACCEPT_ADD_CRITERIO:
			this.processAddCriterio();
			break;
		case IoManager.CREATE_DECISOR:
			this.openCreateDecisor();
			break;
		case IoManager.IFDA:
			this.openIFDA();
			break;
		case IoManager.ACCEPT_IFDA:
			this.processIFDA();
			break;
		case IoManager.ACCEPT_SELECTED_DECISORS:
			this.verifyOptionsSelectedIFDADecisors();
			break;
		case IoManager.ACCEPT_SELECTED_CRITERIO:
			this.verifyOptionsSelectedNameAndType();
//			this.verifyOptionsSelectedIFDACriterios();
			break;
		case IoManager.START_SESION:
			this.startSesion();
			break;
		case IoManager.REGISTER_USER:
			this.openRegisterUser();
			break;
		case IoManager.LOG_OUT:
			this.logOut();
			break;
		case IoManager.SELECT_OPTION_APP:
			this.selectOptionApp();
			break;
		case IoManager.EDIT_ACCOUNT:
			this.openEditAccount();
			break;
		case IoManager.CONFIRM_PSW_ACTUAL:
			this.confirmPswActual();
			break;
		case IoManager.ACCEPT_CHANGE_PASSWORD:
			this.acceptChangePassword();
			break;
		case IoManager.SAVE_CHANGES_EDIT:
			this.saveChangesEdit();
			break;
		case IoManager.ACCEPT_PESO_CRITERIO:
			this.processAcceptPesoCriterio();
			break;
		case IoManager.CANCEL_FIRST_PROCESS:
			this.processCancelIFDA();
			break;
		case IoManager.CANCEL_SELECT_DECISORS:
			this.processCancelSelectDecisors();
			break;
		case IoManager.CANCEL_SELECT_CRITERIOS:
			this.processCancelSelectCriterios();
			break;
		case IoManager.CANCEL_PESO_CRITERIOS:
			this.processCancelPesoCriterios();
			break;
		case IoManager.CANCEL_SHOW_RESULTADOS:
			this.processCancelShowResultados();
			break;
		case IoManager.SAVE_RESULTADOS_TOPSIS:
			this.processSaveResultadosTopsis();
			break;
		case IoManager.CANCEL_EDIT_VARLING:
			this.processCancelEditOption();
			break;
		case IoManager.CANCEL_EDIT_CRITERIO:
			this.processCancelEditOption();
			break;
		case IoManager.CANCEL_AND_SHOW_CRITERIOS:
			this.processCancelAndShowCriterios();
			break;
		case IoManager.CANCEL_AND_SHOW_VARLING:
			this.processCancelAndShowVarLing();
			break;
		case IoManager.SAVE_AND_CREATE_DECISOR:
			this.processSaveAndCreateDecisor();
			break;
		case IoManager.CANCEL_REGISTER_USER:
			this.processCancelRegisterUser();
			break;
		case IoManager.REGISTER_USER_SAVE:
			this.processRegisterUserAndSave();
			break;
		case IoManager.VIEW_GRAPHIC:
			this.viewGraphic();
			break;
		case IoManager.CANCEL_VIEW_GRAPHIC:
			this.cancelViewGraphic();
			break;
		case IoManager.SAVE_GRAPHIC:
			this.saveGraphic();
			break;
		default:
			this.verifyMatrizN(fuente);
			break;
		}
	}

//	public void actionPerformed(ActionEvent e) {
//	    JFileChooser fileChooser = new JFileChooser();
//	    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//	    
//	    FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"); 
//	    fileChooser.setFileFilter(imgFilter);
//	    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Imagen PNG","png");
//		fileChooser.setFileFilter(filtro);
//
//	    int result = fileChooser.showSaveDialog(io.getComponent());
//
//	    if (result == JFileChooser.APPROVE_OPTION) {
//
//	        File fileName = fileChooser.getSelectedFile();
//	        
//	        if ((fileName == null) || (fileName.getName().equals(""))) {
//	          IoManager.send
//	        } else {
//	        	String ruta = fileChooser.getSelectedFile().getAbsolutePath();    
//				System.out.println(ruta);
//				io.saveGraphic(ruta);
//	           System.out.println(fileName.getAbsolutePath());
//	        }
//	        
//	        String extension = fileChooser.getFileFilter().getDescription();
//	    }
//	}

	private void saveGraphic() {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Archivo de Imagen JPG", "jpg");
			fileChooser.setFileFilter(imgFilter);
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Imagen PNG", "png");
			fileChooser.setFileFilter(filtro);

			int result = fileChooser.showSaveDialog(io.getComponent());

			if (result == JFileChooser.APPROVE_OPTION) {

				File fileName = fileChooser.getSelectedFile();

				if ((fileName == null) || (fileName.getName().equals(""))) {

				} else {
					String ruta = fileChooser.getSelectedFile().getAbsolutePath();
					String extensionDescription = fileChooser.getFileFilter().getDescription();
					String extension = "";
					String url = "";
					if (extensionDescription.equals("Archivo de Imagen PNG")) {
						extension = ".png";
						url = ruta + extension;
						io.saveGraphic(url);
						io.sendMessageAlert("Exito",
								"<html>Se ha descargado la imagen en la ruta seleccionada <br> " + ruta
										+ " <br> con nombre de archivo " + fileName.getName() + " y extension "
										+ extensionDescription + ".",
								false);
					} else if (extensionDescription.equals("Archivo de Imagen JPG")) {
						extension = ".jpg";
						url = ruta + extension;
						io.saveGraphic(url);
						io.sendMessageAlert("Exito",
								"<html>Se ha descargado la imagen en la ruta seleccionada <br> " + ruta
										+ " <br> con nombre de archivo " + fileName.getName() + " y extension "
										+ extensionDescription + ".",
								false);
					}else{
						io.sendMessageAlert("Error", "El archivo se debe guardar como \"Archivo de Imagen...\"", true);
					}
				}

			}
		} catch (IOException e) {
			io.sendMessageAlert("Error", "Verifique que la ruta sea la correcta.", false);
		}
	}

	private void cancelViewGraphic() {
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		io.openResultadosFinales(numberAlternatives, 2, matrizResultados);
	}

	private void viewGraphic() {
		ArrayList<String> listDatos = new ArrayList<String>();
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < 2; j++) {
				if (j % 2 == 0) {
					String value = String.valueOf(matrizResultados[i][j]);
					String nameProyect = "CREANDO_MATRIZ";
					String nameAlternative = "Alternativa " + (i + 1);
					listDatos.add(value + "," + nameProyect + "," + nameAlternative);
				}
			}
		}
//		listDatos.add("0.5896,CREANDO_MATRIZ1,Alternativa 1");
//		listDatos.add("0.5896,CREANDO_MATRIZ1,Alternativa 2");
//		listDatos.add("0.5896,CREANDO_MATRIZ1,Alternativa 3");
//		listDatos.add("0.5896,CREANDO_MATRIZ1,Alternativa 4");
//		listDatos.add("0.5896,CREANDO_MATRIZ1,Alternativa 5");
//		listDatos.add("0.5896,CREANDO_MATRIZ1,Alternativa 6");
		io.openGrafica(listDatos);
	}

	private void verifyOptionsSelectedNameAndType() {
		String[][] dataSelected = io.getDataOfCriteriosNameAndType();
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		listBenfitCostText = new ArrayList<String>();
		boolean isError = false;
		listNameCriterios = new ArrayList<String>();
		listNameCriteriosAndBenfitCost = new ArrayList<String>();
		for (int i = 0; i < numberCriterios; i++) {
			for (int j = 1; j < 3; j++) {
				if (j % 2 == 0) {
					listBenfitCostText.add(dataSelected[i][j]);
				} else {
					listNameCriterios.add(dataSelected[i][j]);
				}

			}
		}
		for (int i = 0; i < listNameCriterios.size(); i++) {
			System.out.println(listNameCriterios.get(i).length());

			if (listNameCriterios.get(i).length() > 20) {
				io.sendMessageAlert("Advertencia", "El nombre del criterio " + (i + 1)
						+ " debe ser menor de 20 caracteres, hay " + listNameCriterios.get(i).length() + " Caracteres.",
						true);
				isError = true;
				break;
			} else if (listNameCriterios.get(i).length() <= 1) {
				io.sendMessageAlert("Advertencia", "<html>El nombre del criterio " + (i + 1)
						+ " No se ha asignado, o es muy corto <br> Asegurese de dar Enter, verifique e intente denuevo.</html>",
						true);
				isError = true;
				break;
			}
		}
		if (!isError) {
			for (int i = 0; i < listNameCriterios.size(); i++) {
				listNameCriteriosAndBenfitCost.add(listNameCriterios.get(i) + "  //  " + listBenfitCostText.get(i));
			}
			io.openPesoCriterios(numberDecisors, numberCriterios, this.createCriterios().toArray(),
					listNameCriteriosAndBenfitCost.toArray());
			this.assignDecisorsSelected();
		}

	}

	private void processRegisterUserAndSave() {
		System.out.println("Registrar Usuario");
	}

	private void processCancelRegisterUser() {
		io.cleanAllCampsRegisterAccount();
		io.processForInitAccount();
	}

	private void processSaveAndCreateDecisor() {
		String name = io.getNameDecisor();
		String lastName = io.getLastNameDecisor();
		String emailOfDecisor = io.getEmail();
		String chargeOfDecisor = io.getCharge();
		Charge chargueforAdd = null;
		if (account.verifyExitEmailOfDecisor(emailOfDecisor)) {
			io.sendMessageAlert("Error", "El correo ingresado ya se encuentra regitrado, verifique e intente denuevo",
					true);
		} else {
			for (int i = 0; i < account.getListCharges().size(); i++) {
				if (account.getListCharges().get(i).getCharge().equals(chargeOfDecisor)) {
					chargueforAdd = account.getListCharges().get(i);
				}
			}
			account.addDecisor(
					new Decisor(account.getListDecisors().size() + 1, name, lastName, chargeOfDecisor, chargueforAdd));
			io.sendMessageAlert("Exito!", "Se ha agregado un nuevo decisor", true);
		}
	}

	private void processCancelAndShowCriterios() {
		this.openOptionEditCriterios();
		io.cleanAllCampsAddCriterio();
	}

	private void processCancelAndShowVarLing() {
		this.openOptionEditVariableLinguis();
		io.cleanAllCampsAddVarLing();
	}

	private void processCancelEditOption() {
		io.openModifyData();
		io.setOptionsModify(this.listOptionsEdit());
	}

	private void processSaveResultadosTopsis() {

		io.sendMessageAlert("Temporalmente en mantenimiento", "Por el momento se esta trabajando para mejorar", true);
	}

	private void processCancelShowResultados() {
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		io.openShowMatriz(numberDecisors - 1);
	}

	private void processCancelPesoCriterios() {
//		io.openIFDASelectOptionsCriterios();
//		io.setListOptionsCriterios(this.listCriterios.toArray());
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		io.openNameAndTypeOfCriterios(numberCriterios, listBenfitCostTextForSend.toArray());
	}

	private void processCancelSelectCriterios() {
		io.openIFDASelectOptionsDecisors();
		io.setListOptionsDecisors(this.listDecisors.toArray());
	}

	private void processCancelSelectDecisors() {
		this.openIFDA();
	}

	private void processCancelIFDA() {
		io.cleanAllCampsFirstProcess();
		io.startSesion();
	}

	// Panel Editar cuenta

	public void openEditAccount() {
		io.cleanAllCampsEditAccount();
		io.setDataForEditAccount(account.getName(), account.getLastName(), account.getBirthday(),
				account.getTelephone(), account.getEmail(), account.getPassword());
		io.openEditAccount();
	}

	public void saveChangesEdit() {
		System.out.println("---------------------------------------------------------------------");
	}

	public void acceptChangePassword() {
		System.out.println(".....................................................................");
	}

	public void confirmPswActual() {
		System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	}

	// fin Panel Editar cuenta

	// Proceso registrar usuario

	public void openRegisterUser() {
		io.openRegisterAccount();
	}

	// fin proceso registrar usuario

	// Proceso start Sesion

	public void selectOptionApp() {
		try {
			String option = io.getOptionSelectedApps();
			switch (option) {
			case "TOPSIS":
				this.processStartSesionTopsis();
				break;
			case "Otro":
				this.processForAppOtro();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			io.sendMessageAlert("¡Error!", "No ha seleccionado una opción ", true);
		}
	}

	public void processForAppOtro() {
		io.sendMessageAlert("¡404!", "Por el momento estamos trabajando en una nueva implementación. ", true);
		io.logOut();
	}

	public void processStartSesionTopsis() {
		listDecisors = account.getListDecisors();
		listCriterios = account.getListCriterios();
		listCharges = account.getListCharges();
		listVarLing = account.getListVarLing();
		io.setNameAccount(manager.getNameAccount(io.getUser()) + " ");
		io.startSesion();
		io.sendMessageAlert("¡Exito!", "Bienvenido a TOPSIS...", false);
	}

	public void logOut() {
		io.logOut();
		io.cleanAllCampsForAll();
	}

	public void startSesion() {
		String email = io.getUser();
		String password = io.getPassword();
		if (manager.existAccount(email)) {
			if (manager.validateCredentials(email, password)) {
				account = manager.getAccount(email);
//				listDecisors = account.getListDecisors();
//				listCriterios = account.getListCriterios();
//				listCharges = account.getListCharges();
//				listVarLing = account.getListVarLing();
//				io.setNameAccount(manager.getNameAccount(email) + " ");
//				io.startSesion();
				io.startSelectorApps();
				io.sendMessageAlert("¡Exito!", "Sesión iniciada, Bienvenido. ", false);
			} else {
				io.sendMessageAlert("¡Error!", "La contraseña no es la correcta, verifique e intente denuevo", true);
			}
		} else {
			io.sendMessageAlert("¡Error!", "El email no esta registrado, registrese e intente denuevo. ", true);
		}
	}

	// fin panel Account

	// PROCESO IFDA

	private void verifyMatrizN(String fuente) {
		if (fuente.contains("PROCESS_MATRIZ_")) {
			String numberN = fuente.substring(15, fuente.length());
			int numberDecisors = Integer.parseInt(io.getNumberDecisors());
			int numberNMore1 = Integer.parseInt(numberN) + 1;
			if (numberNMore1 < numberDecisors) {
				io.openShowMatriz(numberNMore1);
			} else {
				System.out.println("proceso next");
				this.assessAllMatriz();
			}
		} else if (fuente.contains("CANCEL_VIEW_MATRIZ_")) { // index begin posicion 19 hasta fuente.length()-1
			String numberN = fuente.substring(19, fuente.length());
			if (Integer.parseInt(numberN) == 0) {
				int numberCriterios = Integer.parseInt(io.getNumberCriterios());
				int numberDecisors = Integer.parseInt(io.getNumberDecisors());
				io.openPesoCriterios(numberDecisors, numberCriterios, this.createCriterios().toArray(),
						listNameCriteriosAndBenfitCost.toArray());
			} else {
				io.openShowMatriz(Integer.parseInt(numberN) - 1);
			}
		}

	}

	// EVALUANDO TODAS LAS
	// MATRICES.......................................................................................___________________________

	private void assessAllMatriz() {
		int numberMatricesN = io.getSizeListPanelsShowMatriz();
		System.out.println("procesando..");
		listMatricesN = new ArrayList<Double[][]>();
		for (int i = 0; i < numberMatricesN; i++) {
			listMatricesN.add(this.convertMatrizEnMatrizConvertidaUV(io.obtainMatrizN(i), this.createVarLing()));
		}
		ArrayList<Integer> listColumnRow = io.getColumnCountAndRowCountMatrizNumberN();
		listMatricesPorAlternativaN = new ArrayList<Double[][]>();
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		for (int i = 0; i < numberAlternatives; i++) {
			listMatricesPorAlternativaN.add(new Double[numberDecisors][numberCriterios * 2 + 2]);
		}

		int indexForAlternativeN = 0;
		int indexForDecisors = 0;
		for (int i = 0; i < listMatricesN.size(); i++) {
			indexForAlternativeN = 0;
			if (indexForDecisors < numberDecisors) {

				for (int h = 0; h < listColumnRow.get(1); h++) {
					for (int j = 0; j < listColumnRow.get(0) * 2; j++) {
//						System.out.println("En indexFOAltN " + indexForAlternativeN + "-- posicion (" + indexForDecisors + "," + j +")   Pegue lo que esta en  " + listMatricesN.get(i)[h][j]  );
						listMatricesPorAlternativaN.get(indexForAlternativeN)[indexForDecisors][j] = listMatricesN
								.get(i)[h][j];
					}
					indexForAlternativeN++;
				}
				indexForDecisors++;
			}

		}
		for (int g = 0; g < listMatricesPorAlternativaN.size(); g++) {
			System.out.println("-----------------------------------------------------------------"
					+ "matriz por altenativa  " + g);
			System.out.println("queda....");
			for (int i = 0; i < numberDecisors; i++) {
				for (int j = 0; j < listColumnRow.get(0) * 2; j++) {
					if (j % 2 == 0) {
						System.out.print("|");
						System.out.print("  " + listMatricesPorAlternativaN.get(g)[i][j]);
					} else {
						System.out.print("  " + listMatricesPorAlternativaN.get(g)[i][j]);
					}

				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------------");

		}

		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-______Las matrice convertidas quedan:::_______________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");

		this.convertAssesAllMatrices();
	}

	private void convertAssesAllMatrices() {
		listMatricesPorAlternativaNConvert = new ArrayList<Double[][]>();
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		for (int i = 0; i < listMatricesPorAlternativaN.size(); i++) {
			listMatricesPorAlternativaNConvert.add(new Double[numberDecisors][numberCriterios * 2 + 2]);
		}
		for (int i = 0; i < listMatricesPorAlternativaN.size(); i++) {

			for (int h = 0; h < numberDecisors; h++) {
				for (int j = 0; j < numberCriterios * 2 + 2; j++) {
					if (listMatricesPorAlternativaN.get(i)[h][j] == null) {
						listMatricesPorAlternativaNConvert.get(i)[h][j] = null;
					} else {
						if (j % 2 == 0) {
							listMatricesPorAlternativaNConvert.get(i)[h][j] = Math
									.pow((1 - listMatricesPorAlternativaN.get(i)[h][j]), listPesoDecisor.get(h));
						} else {
							listMatricesPorAlternativaNConvert.get(i)[h][j] = Math
									.pow((listMatricesPorAlternativaN.get(i)[h][j]), listPesoDecisor.get(h));
						}
					}
				}
			}

		}

		for (int g = 0; g < listMatricesPorAlternativaNConvert.size(); g++) {
			System.out.println("-----------------------------------------------------------------"
					+ "matriz por altenativa  " + g);
			System.out.println("queda....");
			for (int i = 0; i < numberDecisors; i++) {
				for (int j = 0; j < numberCriterios * 2 + 2; j++) {
					if (j % 2 == 0) {
						System.out.print("|");
						System.out.print("  " + listMatricesPorAlternativaNConvert.get(g)[i][j]);
					} else {
						System.out.print("  " + listMatricesPorAlternativaNConvert.get(g)[i][j]);
					}

				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------------");

		}

		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-____________________________________eNTONCES SE CREAN ARREGLOS A B Y Z PARA CADA N ANTERIOR_________________________________________________________");
		this.createListABandZForAlternativesNConvert();
	}

	private void createListABandZForAlternativesNConvert() {
		listAofAlternatives = new ArrayList<ArrayList<Double>>();
		listBofAlternatives = new ArrayList<ArrayList<Double>>();
		listZofAlternatives = new ArrayList<ArrayList<Double>>();
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		for (int i = 0; i < listMatricesPorAlternativaNConvert.size(); i++) {
			listAofAlternatives.add(new ArrayList<Double>());
		}
		for (int i = 0; i < listAofAlternatives.size(); i++) {
			listBofAlternatives.add(new ArrayList<Double>());
		}
		for (int i = 0; i < listAofAlternatives.size(); i++) {
			listZofAlternatives.add(new ArrayList<Double>());
		}

		for (int i = 0; i < listMatricesPorAlternativaNConvert.size(); i++) {
			Double valueforA = 1.0;
			for (int h = 0; h < (numberCriterios * 2) + 2; h++) {
				valueforA = 1.0;
				if (h % 2 == 0) {
					for (int j = 0; j < numberDecisors; j++) {
						if (listMatricesPorAlternativaNConvert.get(i)[j][h] != null) {
							valueforA = (valueforA * listMatricesPorAlternativaNConvert.get(i)[j][h]);
						}
					}
					listAofAlternatives.get(i).add(valueforA);
					listBofAlternatives.get(i).add(1 - valueforA);
				}
			}
			listAofAlternatives.get(i).remove(0);
			listBofAlternatives.get(i).remove(0);
		}

		System.out.println("LISTA A DE LAS ALTERNATIVAS N ES ES.." + listAofAlternatives.toString());
		System.out.println("LISTA B DE LAS ALTERNATIVAS N ES ES.." + listBofAlternatives.toString());

		for (int i = 0; i < listAofAlternatives.size(); i++) {
			Double valueforA = 1.0;
			for (int h = 0; h < (numberCriterios * 2) + 2; h++) {
				valueforA = 1.0;
				if (h % 2 != 0) {
					for (int j = 0; j < numberDecisors; j++) {
						if (listMatricesPorAlternativaNConvert.get(i)[j][h] != null) {
							valueforA = (valueforA * listMatricesPorAlternativaNConvert.get(i)[j][h]);
						}
					}
					listZofAlternatives.get(i).add(valueforA);
				}
			}
			listZofAlternatives.get(i).remove(0);
		}
		System.out.println("LISTA Z DE LAS ALTERNATIVAS N ES ES.." + listZofAlternatives.toString());
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-____________________________Ahora creando Matriz unica_________________________________________________________________");
		this.createMatrizUnica();
	}

	public void createMatrizUnica() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		matrizUnica = new Double[numberAlternatives][numberCriterios * 2];
		int indexForAlternatives = 0;
		int indexForCriterios = 0;
		for (int i = 0; i < listBofAlternatives.size(); i++) {
			indexForCriterios = 0;
			for (int j = 0; j < listBofAlternatives.get(i).size(); j++) {
				if (indexForCriterios % 2 == 0) {
					matrizUnica[indexForAlternatives][indexForCriterios] = listBofAlternatives.get(i).get(j);
					indexForCriterios++;
					matrizUnica[indexForAlternatives][indexForCriterios] = listZofAlternatives.get(i).get(j);
				} else {
				}
				indexForCriterios++;
			}
			indexForAlternatives++;
		}

		System.out.println("queda................................................................");
		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < numberCriterios * 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizUnica[i][j]);
				} else {
					System.out.print("  " + matrizUnica[i][j]);
				}

			}
			System.out.println();
		}

		System.out.println("................................................................");
		System.out.println(".............................................................");
		System.out.println("................................................................");
		System.out.println("......................Creando arreglo S..........................................");
		this.createListS();
	}

	private void createListS() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		int indexForCriterios = 0;
		listS = new ArrayList<Double>();
		ArrayList<Double> listForSendMaxOrMin = new ArrayList<Double>();
		for (int i = 0; i < listBenfitCostText.size(); i++) {
			if (listBenfitCostText.get(i).equals("Benfit")) {
				if (indexForCriterios % 2 == 0) {

					for (int j = 0; j < numberAlternatives; j++) {
						listForSendMaxOrMin.add(matrizUnica[j][indexForCriterios]);
						// aqui es el maximo de esos
					}
					listS.add(returnValueMax(listForSendMaxOrMin));
					listForSendMaxOrMin.clear();
					indexForCriterios++;
					for (int j = 0; j < numberAlternatives; j++) {
						listForSendMaxOrMin.add(matrizUnica[j][indexForCriterios]);
						// aqui es el minimo de esos
					}
					listS.add(returnValueMin(listForSendMaxOrMin));
					listForSendMaxOrMin.clear();
					indexForCriterios++;
				}

			} else if (listBenfitCostText.get(i).equals("Cost")) {
				if (indexForCriterios % 2 == 0) {

					for (int j = 0; j < numberAlternatives; j++) {
						listForSendMaxOrMin.add(matrizUnica[j][indexForCriterios]);
						// aqui es el maximo de esos
					}
					listS.add(returnValueMin(listForSendMaxOrMin));
					listForSendMaxOrMin.clear();
					indexForCriterios++;
					for (int j = 0; j < numberAlternatives; j++) {
						listForSendMaxOrMin.add(matrizUnica[j][indexForCriterios]);
						// aqui es el minimo de esos
					}
					listS.add(returnValueMax(listForSendMaxOrMin));
					listForSendMaxOrMin.clear();
					indexForCriterios++;
				}

			}
		}

		System.out.println("Imprimiendo lista S" + listS.toString());
		System.out.println("................................................................");
		System.out.println(".............................................................");
		System.out.println("................................................................");
		System.out.println("....................creando matriz XjSj...........................................");
		this.createMatrizXjSj();
	}

	private Double returnValueMax(ArrayList<Double> list) {
		Collections.sort(list);
		return list.get(list.size() - 1);
	}

	private Double returnValueMin(ArrayList<Double> list) {
		Collections.sort(list);
		return list.get(0);
	}

	private void createMatrizXjSj() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		matrizXjSj = new Double[numberAlternatives][numberCriterios * 2];
		int indexForCriterios = 0;
		for (int i = 0; i < listBenfitCostText.size(); i++) {
			if (listBenfitCostText.get(i).equals("Benfit")) {
				if (indexForCriterios % 2 == 0) {

					for (int j = 0; j < numberAlternatives; j++) {
						matrizXjSj[j][indexForCriterios] = (matrizUnica[j][indexForCriterios]
								/ listS.get(indexForCriterios));
						// aqui es el maximo de esos
					}
					indexForCriterios++;
					for (int j = 0; j < numberAlternatives; j++) {
						matrizXjSj[j][indexForCriterios] = ((matrizUnica[j][indexForCriterios]
								- listS.get(indexForCriterios)) / (1 - listS.get(indexForCriterios)));
					}
					indexForCriterios++;
				}

			} else if (listBenfitCostText.get(i).equals("Cost")) {
				if (indexForCriterios % 2 == 0) {

					for (int j = 0; j < numberAlternatives; j++) {
						matrizXjSj[j][indexForCriterios] = (listS.get(indexForCriterios)
								/ matrizUnica[j][indexForCriterios]);
					}
					indexForCriterios++;
					for (int j = 0; j < numberAlternatives; j++) {
						matrizXjSj[j][indexForCriterios] = ((listS.get(indexForCriterios)
								- matrizUnica[j][indexForCriterios]) / (1 - matrizUnica[j][indexForCriterios]));
					}
					indexForCriterios++;
				}

			}
		}

		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < numberCriterios * 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizXjSj[i][j]);
				} else {
					System.out.print("  " + matrizXjSj[i][j]);
				}

			}
			System.out.println();
		}

		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-____________________________Creandoo matrizXjSjConW_________________________________________________________________");
		this.createMatrizXjSjConW();
	}

	private void createMatrizXjSjConW() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		matrizXjSjConW = new Double[numberAlternatives][numberCriterios * 2];
		int indexForListBenfitCostNumeric = 0;
		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < numberCriterios * 2; j++) {
				if (j % 2 == 0) {
					matrizXjSjConW[i][j] = Math.pow(matrizXjSj[i][j],
							listBenfitCostNumeric.get(indexForListBenfitCostNumeric));
				} else {
					matrizXjSjConW[i][j] = (1 - Math.pow((1 - matrizXjSj[i][j]),
							listBenfitCostNumeric.get(indexForListBenfitCostNumeric)));
					indexForListBenfitCostNumeric++;
				}

			}
			indexForListBenfitCostNumeric = 0;
		}

		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < numberCriterios * 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizXjSjConW[i][j]);
				} else {
					System.out.print("  " + matrizXjSjConW[i][j]);
				}

			}
			System.out.println();
		}

		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-____________________________Creandoo matrizUVFinal_________________________________________________________________");
		this.createMatrizUVFinal();
	}

	private void createMatrizUVFinal() {
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		matrizUVFinal = new Double[numberAlternatives][2];
		Double valueForU = 1.0;
		Double valueForV = 1.0;
		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < numberCriterios * 2; j++) {
				if (j % 2 == 0) {
					valueForU = (valueForU * matrizXjSjConW[i][j]);
				} else {
					valueForV = (valueForV * (1 - matrizXjSjConW[i][j]));
				}
			}
			matrizUVFinal[i][0] = valueForU;
			matrizUVFinal[i][1] = 1 - valueForV;
			valueForU = 1.0;
			valueForV = 1.0;
		}

		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizUVFinal[i][j]);
				} else {
					System.out.print("  " + matrizUVFinal[i][j]);
				}

			}
			System.out.println();
		}
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-_____________________________________________________________________________________________");
		System.out.println(
				"-____________________________Creandoo matrizUVFinal_________________________________________________________________");
		this.createMatrizResultados();
	}

	private void createMatrizResultados() {
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		matrizResultados = new double[numberAlternatives][2];
		ArrayList<Double> listForAssignRanking = new ArrayList<Double>();
		for (int i = 0; i < numberAlternatives; i++) {
			matrizResultados[i][0] = matrizUVFinal[i][0] - matrizUVFinal[i][1];
			listForAssignRanking.add(matrizResultados[i][0]);
		}
		ArrayList<Integer> listRanked = this.assignRanking(listForAssignRanking);
		for (int i = 0; i < numberAlternatives; i++) {
//			matrizResultados[i][1] = Double.parseDouble(String.valueOf(listRanked.get(i)));
			matrizResultados[i][1] = listRanked.get(i);
		}

		for (int i = 0; i < numberAlternatives; i++) {
			for (int j = 0; j < 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizResultados[i][j]);
				} else {
					System.out.print("  " + matrizResultados[i][j]);
				}

			}
			System.out.println();
		}

		io.openResultadosFinales(numberAlternatives, 2, matrizResultados);
	}

	private ArrayList<Integer> assignRanking(ArrayList<Double> list) {
		ArrayList<Double> listCloned = (ArrayList<Double>) list.clone();
		ArrayList<Integer> listRanking = new ArrayList<Integer>();
		Collections.sort(list);
		for (int i = 0; i < listCloned.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (listCloned.get(i) == list.get(j)) {
					listRanking.add(list.size() - j);
				}
			}
		}
		return listRanking;
	}

	// lo de aqui abajo es un metodo auxiliar para convertir la matriz en la que
	// cada decisor da su calificacion en la misma matriz pero con valores u y v
	private Double[][] convertMatrizEnMatrizConvertidaUV(String[][] matrizInString,
			ArrayList<VariableLinguistica> listForCompareVariable) {
		ArrayList<Integer> listColumnRow = io.getColumnCountAndRowCountMatrizNumberN();
		Double[][] matrizConvertidaVariablesLing = new Double[listColumnRow.get(1)][(listColumnRow.get(0)) * 2];
		// llenando la matriz que acabe de inicializar
		int columnUV = 0;
		for (int i = 0; i < listColumnRow.get(1); i++) {
			for (int j = 0; j < listColumnRow.get(0); j++) {
				String criterio = matrizInString[j][i].toString();
				for (int k = 0; k < listForCompareVariable.size(); k++) {
					if (criterio.equals(listForCompareVariable.get(k).toString())) {
						matrizConvertidaVariablesLing[i][columnUV] = listForCompareVariable.get(k).getU();
						matrizConvertidaVariablesLing[i][columnUV + 1] = listForCompareVariable.get(k).getV();
						break;
					} else {

					}
				}
				if (columnUV == listColumnRow.get(0) * 2 - 2) {
					columnUV = 0;
				} else {
					columnUV += 2;
				}
			}
		}
		return matrizConvertidaVariablesLing;
	}

	// FIN EVALUANDO TODAS LAS
	// MATRICES----------------------_______________________________________________________________________________
	private void processAcceptPesoCriterio() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		this.matrizPesoCriterios();
		io.createNumberMatrizN(numberAlternatives, numberCriterios, numberDecisors, this.createVarLing().toArray(),
				listNameCriteriosAndBenfitCost.toArray());
		io.openShowMatriz(0);
	}

	private void verifyOptionsSelectedIFDACriterios() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
//		if (io.getListSelectedOptionsCriterios().size() == numberCriterios) {
		io.openPesoCriterios(numberDecisors, numberCriterios, this.createCriterios().toArray(),
				listNameCriteriosAndBenfitCost.toArray());
//		}else {
//			io.sendMessageAlert("¡Error!", "<html>Usted Ha seleccionado " + numberCriterios + " Criterios, y esta agregando: <br>"
//					+ io.getListSelectedOptionsCriterios().size() + " Criterios, verifique e intente denuevo. ", true);
//		}
	}

	private void verifyOptionsSelectedIFDADecisors() {
		int numberCriterios = Integer.parseInt(io.getNumberCriterios());
		int numberDecisors = Integer.parseInt(io.getNumberDecisors());
		listBenfitCostTextForSend = new ArrayList<String>();
		listBenfitCostTextForSend.add("Benfit");
		listBenfitCostTextForSend.add("Cost");
		if (io.getListSelectedOptionsDecisors().size() == numberDecisors) {
//			this.assignDecisorsSelected();f
			io.openNameAndTypeOfCriterios(numberCriterios, listBenfitCostTextForSend.toArray());
//			io.openIFDASelectOptionsCriterios();
//			io.setListOptionsCriterios(this.listCriterios.toArray());
		} else {
			io.sendMessageAlert("¡Error!",
					"<html>Usted Ha seleccionado " + numberDecisors + " Decisores, y esta agregando: <br>"
							+ io.getListSelectedOptionsDecisors().size() + " Decisores, verifique e intente denuevo. ",
					true);
		}
	}
// METODOS DEL CALCULO DEL ALGORITMO-----------------------------------------____________________________________________________________________________________________________________

	private void assignDecisorsSelected() {
		ArrayList<String> listDecisorsSelectedInString = io.getListSelectedOptionsDecisors();
		listDecisorsSelected = new ArrayList<Decisor>();
		for (int i = 0; i < listDecisorsSelectedInString.size(); i++) {
			int codeDecisor = Character.getNumericValue(listDecisorsSelectedInString.get(i).charAt(0));
			for (int j = 0; j < listDecisors.size(); j++) {
				if (listDecisors.get(j).getIdDecisor() == codeDecisor) {
					listDecisorsSelected.add(listDecisors.get(j));
					break;
				}
			}
		}
		System.out.println(listDecisorsSelected.toString());
		this.assignPesoDecisors();
	}

	private void assignPesoDecisors() {
		double totalPeso = 0;
		for (int i = 0; i < listDecisorsSelected.size(); i++) {
			totalPeso += listDecisorsSelected.get(i).getCharge().getPesoProvisional();
		}
		listPesoDecisor = new ArrayList<Double>();
		for (int i = 0; i < listDecisorsSelected.size(); i++) {
			listPesoDecisor.add(listDecisorsSelected.get(i).getCharge().getPesoProvisional() / totalPeso);
		}
		System.out.println(listPesoDecisor.toString());
		// peso de los decisores

	}

	private void matrizPesoCriterios() {
		matrizpesoCriterios = io.getMatrizPesoCriterios();
		ArrayList<Integer> listColumnRow = io.getColumnCountAndRowCountMatrizPesoCriterios();
		for (int i = 0; i < listColumnRow.get(1); i++) {
			for (int j = 0; j < listColumnRow.get(0); j++) {
				System.out.print(matrizpesoCriterios[j][i].toString());
			}
			System.out.println();
		}
		System.out.println("siguiente");
		this.matrizPesoCriteriosUV();
	}

	private void matrizPesoCriteriosUV() {
		ArrayList<Integer> listColumnRow = io.getColumnCountAndRowCountMatrizPesoCriterios();
		matrizPesoCriteriosUV = new Double[listColumnRow.get(1)][(listColumnRow.get(0)) * 2];
		// llenando la matriz que acabe de inicializar
		int columnUV = 0;
		for (int i = 0; i < listColumnRow.get(1); i++) {
			for (int j = 0; j < listColumnRow.get(0); j++) {
				String criterio = matrizpesoCriterios[j][i].toString();
				for (int k = 0; k < this.createCriterios().size(); k++) {
					if (criterio.equals(createCriterios().get(k).toString())) {
						matrizPesoCriteriosUV[i][columnUV] = this.createCriterios().get(k).getU();
						matrizPesoCriteriosUV[i][columnUV + 1] = this.createCriterios().get(k).getV();
						break;
					} else {

					}
				}
				if (columnUV == listColumnRow.get(0) * 2 - 2) {
					columnUV = 0;
				} else {
					columnUV += 2;
				}
			}
		}
		System.out.println("queda....");
		for (int i = 0; i < listColumnRow.get(1); i++) {
			for (int j = 0; j < listColumnRow.get(0) * 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizPesoCriteriosUV[i][j]);
				} else {
					System.out.print("  " + matrizPesoCriteriosUV[i][j]);
				}

			}
			System.out.println();
		}
		System.out.println("Convirtiendo a paso 4");
		this.matrizPesoCriteriosUVConvertida();

	}

	private void matrizPesoCriteriosUVConvertida() {
		ArrayList<Integer> listColumnRow = io.getColumnCountAndRowCountMatrizPesoCriterios();
		matrizPesoCriteriosUVConvertida = new Double[listColumnRow.get(1)][(listColumnRow.get(0)) * 2];
		for (int i = 0; i < listColumnRow.get(1); i++) {
			for (int j = 0; j < listColumnRow.get(0) * 2; j++) {
				if (matrizPesoCriteriosUV[i][j] == null) {
					matrizPesoCriteriosUVConvertida[i][j] = null;
				} else {
					if (j % 2 == 0) {
						matrizPesoCriteriosUVConvertida[i][j] = Math.pow((1 - matrizPesoCriteriosUV[i][j]),
								listPesoDecisor.get(i));
					} else {
						matrizPesoCriteriosUVConvertida[i][j] = Math.pow((matrizPesoCriteriosUV[i][j]),
								listPesoDecisor.get(i));
					}
				}
			}
		}
		System.out.println("queda....");
		for (int i = 0; i < listColumnRow.get(1); i++) {
			for (int j = 0; j < listColumnRow.get(0) * 2; j++) {
				if (j % 2 == 0) {
					System.out.print("|");
					System.out.print("  " + matrizPesoCriteriosUVConvertida[i][j]);
				} else {
					System.out.print("  " + matrizPesoCriteriosUVConvertida[i][j]);
				}

			}
			System.out.println();
		}
		System.out.println("Creando array lista a b y z");
		this.createListABandZ();
	}

	private void createListABandZ() {
		ArrayList<Integer> listColumnRow = io.getColumnCountAndRowCountMatrizPesoCriterios();
		listA = new ArrayList<Double>();
		listB = new ArrayList<Double>();
		listZ = new ArrayList<Double>();
		Double valueforA = 1.0;
		for (int i = 0; i < listColumnRow.get(0) * 2; i++) {
			valueforA = 1.0;
			if (i % 2 == 0) {
				for (int j = 0; j < listColumnRow.get(1); j++) {
					if (matrizPesoCriteriosUVConvertida[j][i] != null) {
						valueforA = (valueforA * matrizPesoCriteriosUVConvertida[j][i]);
					}
				}
				listA.add(valueforA);
			}
		}
		listA.remove(0);
		System.out.println("LISTA A ES.." + listA.toString());
		for (int i = 0; i < listA.size(); i++) {
			listB.add(1 - listA.get(i));
		}
		System.out.println("Lista B Es..." + listB.toString());
		for (int i = 0; i < listColumnRow.get(0) * 2; i++) {
			valueforA = 1.0;
			if (i % 2 != 0) {
				for (int j = 0; j < listColumnRow.get(1); j++) {
					if (matrizPesoCriteriosUVConvertida[j][i] != null) {
						valueforA = (valueforA * matrizPesoCriteriosUVConvertida[j][i]);
					}
				}
				listZ.add(valueforA);
			}
		}
		listZ.remove(0);
		System.out.println("LISTA Z ES.." + listZ.toString());
		System.out.println("Creando lista Alfa");
		this.createListAlfa();
	}

	private void createListAlfa() {
		listAlfa = new ArrayList<Double>();
		int sizeListB = listB.size();
		int sizeListZ = listZ.size();
		for (int i = 0; i < listB.size(); i++) {
			Double b = listB.get(i);
			Double z = listZ.get(i);
			listAlfa.add(b + ((1 - (b + z)) * ((b) / (b + z))));
		}
		System.out.println("lista alfa es....." + listAlfa.toString());
		System.out.println("creando arreglo benfitcost");
		this.createListBenfitCost();
	}

	private void createListBenfitCost() {
		listBenfitCostNumeric = new ArrayList<Double>();
		Double totalListAlfa = 0.0;
		for (int i = 0; i < listAlfa.size(); i++) {
			totalListAlfa += listAlfa.get(i);
		}
		System.out.println("total listAlfa ---- " + totalListAlfa);
		for (int i = 0; i < listAlfa.size(); i++) {
			listBenfitCostNumeric.add(listAlfa.get(i) / totalListAlfa);
		}
		System.out.println(listBenfitCostNumeric.toString());
	}

//FIN METODOS ALGORITMO

	private void processIFDA() {
		try {
			int numberDecisors = Integer.parseInt(io.getNumberDecisors());
			int numberCriterios = Integer.parseInt(io.getNumberCriterios());
			int numberAlternatives = Integer.parseInt(io.getNumberAlternatives());
			io.openIFDASelectOptionsDecisors();
			io.setListOptionsDecisors(this.listDecisors.toArray());
		} catch (Exception e) {
			io.sendMessageAlert("¡Error!", "Uno de los campos contiene valores no numericos", true);
		}

	}

	private void openIFDA() {
		io.openIFDA();
		io.cleanAllCampsIFDA();
	}

	// FIN PROCESO IFDA

	private void openCreateDecisor() {
		io.cleanAllCampsCreateDecisor();
		io.openCreateDecisor();
		io.setListCharges(this.listCharges.toArray());
	}

//	private Object[] setListCharges() {
//		ArrayList<String> listCharges = new ArrayList<String>();
//		listCharges.add("Beginner (B)");
//		listCharges.add("Practitioner (Pr)");
//		listCharges.add("Proficient (Pt)");
//		listCharges.add("Expert (E)");
//		listCharges.add("Master (M)");
//		return listCharges.toArray();
//	}

	private void processAddCriterio() {
		System.out.println("Agregando Criterio");
	}

	private void processAddVarling() {
		System.out.println("Agregando varLing");
	}

	private void processDeleteVarling() {
		System.out.println("Eliminando VariableLing");
	}

	private void processDeleteCriterio() {
		System.out.println("Eliminando Criterio");
	}

	private void processModifyVarling() {
		System.out.println("Modificando variableling seleccionado");
	}

	private void processModifyCriterio() {
		System.out.println("Modificando criterio seleccionado");
	}

	private void openAddVarLing() {
		io.openAddVarLing();
	}

	private void openModifyVarLing() {
		io.openModifyVarLing();
		io.setListVarLingForModify(this.listVarLing.toArray());
	}

	private void OpenDeleteVarLing() {
		io.OpenDeleteVarLing();
		io.setListVarLingForDelete(this.listVarLing.toArray());
	}

	private void openModifyCriterio() {
		io.openModifyCriterio();
		io.setListCriteriosForModify(this.listCriterios.toArray());
	}

	private void OpenDeleteCriterio() {
		io.OpenDeleteCriterio();
		io.setListCriteriosForDelete(this.listCriterios.toArray());
	}

	private void openAddCriterio() {
		io.openAddCriterio();
	}

	private void openOptionSelectd() {
		try {
			String option = io.getOptionSelectedModifyData();
			switch (option) {
			case "Criterios":
				this.openOptionEditCriterios();
				break;
			case "Variables Linguisticas":
				this.openOptionEditVariableLinguis();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			io.sendMessageAlert("¡Error!", "No ha seleccionado una opción ", true);
		}
	}

	private void openOptionEditCriterios() {
		io.openViewCriterios();
//		io.setListCriterios(this.listCriterios.toArray());
		ArrayList<String> listCriteriosForSend = new ArrayList<String>();
		for (int i = 0; i < listCriterios.size(); i++) {
			listCriteriosForSend.add(listCriterios.get(i).toString2());
		}
		io.setListCriterios(listCriteriosForSend.toArray());
	}

	private void openOptionEditVariableLinguis() {
		io.openViewVarLing();
		ArrayList<String> listVarLingForSend = new ArrayList<String>();
		for (int i = 0; i < listVarLing.size(); i++) {
			listVarLingForSend.add(listVarLing.get(i).toString2());
		}
		io.setListVarLing(listVarLingForSend.toArray());
	}

	private void openModifyData() {
		io.cleanAllCampsAddCriterio();
		io.cleanAllCampsAddVarLing();
		io.openModifyData();
		io.setOptionsModify(this.listOptionsEdit());
	}

	public Object[] listOptionsEdit() {
		ArrayList<String> listOptionsEdit = new ArrayList<String>();
		listOptionsEdit.add("Criterios");
		listOptionsEdit.add("Variables Linguisticas");
		return listOptionsEdit.toArray();
	}

//	public Object[] listCriterios() {
//		ArrayList<String> listOptionsEdit = new ArrayList<String>();
//		listOptionsEdit.add("Very Unimportat (VU)");
//		listOptionsEdit.add("Unimportat (U)");
//		listOptionsEdit.add("Medium (M)");
//		listOptionsEdit.add("Important (I)");
//		listOptionsEdit.add("Very Important (VI)");
//		listOptionsEdit.add("Bad (B)");
//		return listOptionsEdit.toArray();
//	}

//	public Object[] listVariablesLing() {
//		ArrayList<String> listOptionsEdit = new ArrayList<String>();
//		listOptionsEdit.add("VeryEEE Unimportat (VU)");
//		listOptionsEdit.add("Unimporta33t (U)");
//		listOptionsEdit.add("MediumEE (M)");
//		listOptionsEdit.add("Import33ant (I)");
//		listOptionsEdit.add("Very Important33 (VI)");
//		listOptionsEdit.add("Bad 33(B)");
//		return listOptionsEdit.toArray();
//	}

	private void processRegisterUser() {
//		io.processRegisterUser();
		io.cleanCampsInitAccount();
	}

	private void closeInformation() {
		io.closeInformation();
	}

	private void processCancelRegister() {
		io.processForInitAccount();
		io.cleanCampsInitAccount();
	}

}