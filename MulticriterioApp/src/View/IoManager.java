package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.peer.PanelPeer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Control.Controller;

public class IoManager extends JFrame {
	private PanelAccount panelAccount;
	private PanelBar panelBar;
	private PanelOptions panelOptions;
	private PanelModifyData panelModifyData;
	private PanelEditCriterio panelEditCriterio;
	private PanelAddCriterio panelAddCriterio;
	private PanelModifyCriterio panelModifyCriterio;
	private PanelDeleteCriterio panelDeleteCriterio;
	private PanelEditCriterio panelEditVarLing;
	private PanelAddCriterio panelAddVarLing;
	private PanelModifyCriterio panelModifyVarLing;
	private PanelDeleteCriterio panelDeleteVarLing;
	private PanelCreateDecisor panelCreateDecisor;
	private PanelIFDA panelIFDA;
	private PanelIFDASelectOptions panelIFDASelectOptionsDecisors;
	private PanelIFDASelectOptions panelIFDASelectOptionsCriterios;
	private PanelShowMatriz panelShowMatriz;
	private ArrayList<PanelShowMatriz> listPanelsShowMatriz;
	private PanelShowMatriz panelShowResultadosFinales;
	private PanelRegisterAccount panelRegisterAccount;
	private PanelEditAccount panelEditAccount;
	private PanelShowMatriz panelMatrizPesoCriterios;
	private PanelShowMatriz panelIFDASelectOptionsCriteriosName;
	private Graficas graficas;
	public static final String CLOSE_INFORMATION = "Cancel_Visualization_Info";
	public static final String MODIFY_DATA = "MODIFY_DATA";
	public static final String ACCEPT_OPTION_EDIT = "ACCEPT_OPTION_EDIT";
	public static final String OPEN_MODIFY_CRITERIO = "OPEN_MODIFY_CRITERIO";
	public static final String OPEN_DELETE_CRITERIO = "OPEN_DELETE_CRITERIO";
	public static final String OPEN_ADD_CRITERIO = "OPEN_ADD_CRITERIO";
	public static final String OPEN_MODIFY_VARLING = "OPEN_MODIFY_VARLING";
	public static final String OPEN_DELETE_VARLING = "OPEN_DELETE_VARLING";
	public static final String OPEN_ADD_VARLING = "OPEN_ADD_VARLING";
	public static final String ACCEPT_DELETE_CRITERIO = "ACCEPT_DELETE_CRITERIO";
	public static final String ACCEPT_DELETE_VARLING = "ACCEPT_DELETE_VARLING";
	public static final String ACCEPT_MODIFY_CRITERIO = "ACCEPT_MODIFY_CRITERIO";
	public static final String ACCEPT_MODIFY_VARLING = "ACCEPT_MODIFY_VARLING";
	public static final String ACCEPT_ADD_CRITERIO = "ACCEPT_ADD_CRITERIO";
	public static final String ACCEPT_ADD_VARLING = "ACCEPT_ADD_VARLING";
	public static final String CREATE_DECISOR = "CREATE_DECISOR";
	public static final String IFDA = "IFDA";
	public static final String ACCEPT_IFDA = "ACCEPT_IFDA";
	public static final String ACCEPT_SELECTED_DECISORS = "ACCEPT_SELECTED_DECISORS";
	public static final String ACCEPT_SELECTED_CRITERIO = "ACCEPT_SELECTED_CRITERIO";
	public static final String START_SESION = "START_SESION";
	public static final String REGISTER_USER = "REGISTER_USER";
	public static final String LOG_OUT = "LOG_OUT";
	public static final String SELECT_OPTION_APP = "SELECT_OPTION_APP";
	public static final String EDIT_ACCOUNT = "EDIT_ACCOUNT";
	public static final String CONFIRM_PSW_ACTUAL = "CONFIRM_PSW_ACTUAL";
	public static final String ACCEPT_CHANGE_PASSWORD = "ACCEPT_CHANGE_PASSWORD";
	public static final String SAVE_CHANGES_EDIT = "SAVE_CHANGES_EDIT";
	public static final String ACCEPT_PESO_CRITERIO = "ACCEPT_PESO_CRITERIO";
	public static final String SAVE_RESULTADOS_TOPSIS = "SAVE_RESULTADOS_TOPSIS";
	public static final String SAVE_AND_CREATE_DECISOR = "SAVE_AND_CREATE_DECISOR";
	public static final String CANCEL_REGISTER_USER = "CANCEL_REGISTER_USER";
	public static final String REGISTER_USER_SAVE = "REGISTER_USER_SAVE";
	public static final String VIEW_GRAPHIC = "VIEW_GRAPHIC";
	public static final String SAVE_GRAPHIC = "SAVE_GRAPHIC";
	//los cancelar
	public static final String CANCEL_FIRST_PROCESS = "CANCEL_IFDA";
	public static final String CANCEL_SELECT_DECISORS = "CANCEL_SELECT_DECISORS";
	public static final String CANCEL_SELECT_CRITERIOS = "CANCEL_SELECT_CRITERIOS";
	public static final String CANCEL_PESO_CRITERIOS = "CANCEL_PESO_CRITERIOS";
	public static final String CANCEL_SHOW_RESULTADOS = "CANCEL_SHOW_RESULTADOS";
	public static final String CANCEL_EDIT_VARLING = "CANCEL_EDIT_VARLING";
	public static final String CANCEL_EDIT_CRITERIO = "CANCEL_EDIT_CRITERIO";
	public static final String CANCEL_AND_SHOW_VARLING = "CANCEL_AND_SHOW_VARLING";
	public static final String CANCEL_AND_SHOW_CRITERIOS = "CANCEL_AND_SHOW_CRITERIOS";
	public static final String CANCEL_VIEW_GRAPHIC = "CANCEL_VIEW_GRAPHIC";
	private ArrayList<JPanel> listPanels;
	private PanelInformation visualizeInformation;
	private Controller control;
	private GridBagConstraints gbc;

	public IoManager(String messageJFrame, Controller control) {
		super(messageJFrame);
		this.control = control;
		setLayout(new BorderLayout());
		panelBar = new PanelBar(control);
		panelOptions = new PanelOptions(control);
		this.getContentPane().setBackground(Color.orange);
//		setSize(530, 740);
		setExtendedState(this.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);
		ImageIcon ImageIcon = new ImageIcon("data/ff.jpg");
		Image image = ImageIcon.getImage();
		this.setIconImage(image);
		this.getContentPane().setBackground(Color.WHITE);
		this.assignValues(control);
		this.init();
//		add(panelBar, BorderLayout.NORTH);
//		add(panelOptions, BorderLayout.WEST);
		this.pack();
        setVisible(true);
	}

	public void assignValues(Controller control) {
		panelAccount = new PanelAccount(control);
		panelModifyData = new PanelModifyData(control);
		panelEditVarLing = new PanelEditCriterio(control, "Modificar Variable Linguistica ", CANCEL_EDIT_VARLING, OPEN_ADD_VARLING, OPEN_DELETE_VARLING, OPEN_MODIFY_VARLING, "Lista de variables Ling");
		panelEditCriterio = new PanelEditCriterio(control, "Modificar Criterio ", CANCEL_EDIT_CRITERIO, OPEN_ADD_CRITERIO, OPEN_DELETE_CRITERIO, OPEN_MODIFY_CRITERIO, "Lista de Criterios");
		panelAddCriterio = new PanelAddCriterio(control, "Agregar Criterio ",CANCEL_AND_SHOW_CRITERIOS, "Crear Criterio", "Nombre del criterio", "Abreviación del criterio", "Valor U (Verdad)", "Valor de V (No verdad)", "Valor de Pi", ACCEPT_ADD_CRITERIO);
		panelModifyCriterio = new PanelModifyCriterio(control, "Modificar Criterio ", CANCEL_AND_SHOW_CRITERIOS, "Escoja el criterio que desea modificar", ACCEPT_MODIFY_CRITERIO);
		panelDeleteCriterio = new PanelDeleteCriterio(control, "Eliminar criterio ",CANCEL_AND_SHOW_CRITERIOS, "Escoja el criterio que desea Eliminar", ACCEPT_DELETE_CRITERIO);
		panelAddVarLing = new PanelAddCriterio(control, "Agregar Variable Linguistica",CANCEL_AND_SHOW_VARLING, "Crear Variable Linguistica", "Nombre de la Var. Ling.", "Abreviación de Var. Ling.", "Valor U (Verdad)", "Valor de V (No verdad)", "Valor de Pi", ACCEPT_ADD_VARLING);
		panelModifyVarLing = new PanelModifyCriterio(control, "Modificar Variable Linguistica",CANCEL_AND_SHOW_VARLING, "Escoja la Variable Ling. que desea Modificar", ACCEPT_MODIFY_VARLING);
		panelDeleteVarLing = new PanelDeleteCriterio(control, "Eliminar Variable Linguistica",CANCEL_AND_SHOW_VARLING, "Escoja La variable Ling. que desea Eliminar", ACCEPT_DELETE_VARLING);
		panelCreateDecisor = new PanelCreateDecisor(control);
		panelIFDA = new PanelIFDA(control);
		panelIFDASelectOptionsDecisors = new PanelIFDASelectOptions(control, ACCEPT_SELECTED_DECISORS, CANCEL_SELECT_DECISORS, null,"IFDA - Decision makers selection", "Please select the decision makers to perform the calculations");
		panelIFDASelectOptionsCriterios = new PanelIFDASelectOptions(control, ACCEPT_SELECTED_CRITERIO, CANCEL_SELECT_CRITERIOS, null,"IFDA - Criteria Selection", "Please select the criteria to perform the calculations");
//		panelShowMatriz = new PanelShowMatriz(control, "ACTION..............", "Completar Datos", "Por favor rellene la matriz, para realizar los calculos", 0, 0, null);
		panelRegisterAccount = new PanelRegisterAccount(control);
		panelEditAccount = new PanelEditAccount(control);
//		panelMatrizPesoCriterios = new PanelShowMatriz(control, "ACCEPT_PESO_CRITERIO", "Determinación peso de los criterios", "Por favor seleccione una opción según corresponda con el peso de cada criterio por cada decisor", 0, 0, null , "d");
		listPanels = new ArrayList<JPanel>();
		listPanelsShowMatriz = new ArrayList<PanelShowMatriz>();
	}

	public void init() {
		listPanels.add(panelAccount);
		listPanels.add(panelModifyData);
		listPanels.add(panelEditCriterio);
		listPanels.add(panelAddCriterio);
		listPanels.add(panelModifyCriterio);
		listPanels.add(panelDeleteCriterio);
		listPanels.add(panelEditVarLing);
		listPanels.add(panelAddVarLing);
		listPanels.add(panelDeleteVarLing);
		listPanels.add(panelModifyVarLing);
		listPanels.add(panelCreateDecisor);
		listPanels.add(panelIFDA);
		listPanels.add(panelIFDASelectOptionsDecisors);
		listPanels.add(panelIFDASelectOptionsCriterios);
//		listPanels.add(panelShowMatriz);
		listPanels.add(panelRegisterAccount);
		listPanels.add(panelEditAccount);
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		add(obtainJPanel(panelAccount), BorderLayout.CENTER);
	}
	
//OBTENER LOS PANELES DE FORMA DINAMICA
	
	private JPanel obtainJPanel(JPanel panel) {
		for (int i = 0; i < listPanels.size(); i++) {
			if (panel.getClass().getName().equalsIgnoreCase(listPanels.get(i).getClass().getName())) {
				return listPanels.get(i);
			}
		}
		return null;
	}
	
	private void activeVisibleFor(JPanel panel) {
		for (int i = 0; i < listPanels.size(); i++) {
			if (panel.getClass().getName().equalsIgnoreCase(listPanels.get(i).getClass().getName())) {
				listPanels.get(i).setVisible(true);
			} else {
				listPanels.get(i).setVisible(false);
			}
		}
	}
	
	private void enableVisibleAll() {
		for (int i = 0; i < listPanels.size(); i++) {
			listPanels.get(i).setVisible(false);
		}
	}
	
	private void ifEnableVisibleThenActive(JPanel panel) {
		panel.setVisible(true);
		add(panel, BorderLayout.CENTER);
	}
	
	private void addJPanelToFrame(JPanel panel) {
		for (int i = 0; i < listPanels.size(); i++) {
			if (panel.getClass().getName().equalsIgnoreCase(listPanels.get(i).getClass().getName())) {
				add(listPanels.get(i), BorderLayout.CENTER);
				break;
			}
		}
	}
	
		//ACTIVAR Y DESACTIVAR PARA LOS PANELES QUE MUESTRAN UNA MATRIZ DE N DECISORES
	
	public void enableVisiblePanelMatriz() {
		for (int i = 0; i < listPanelsShowMatriz.size(); i++) {
			listPanelsShowMatriz.get(i).setVisible(false);
		}
	}
	
	public void ifEnableVisibleMatrizThenActive(JPanel panel) {
		panel.setVisible(true);
		add(panel, BorderLayout.CENTER);
	}
		//FIN-- ACTIVAR Y DESACTIVAR PARA LOS PANELES QUE MUESTRAN UNA MATRIZ DE N DECISORES
	
	
	//Crenado desactivación de todo
	
	public void enableVisibleAllPanels() {
		this.enableVisibleAll();
		this.enableVisiblePanelMatriz();
		if (panelMatrizPesoCriterios != null) {
			panelMatrizPesoCriterios.setVisible(false);
		}
		if (panelShowResultadosFinales != null) {
			panelShowResultadosFinales.setVisible(false);
		}
		if (panelIFDASelectOptionsCriteriosName != null) {
			panelIFDASelectOptionsCriteriosName.setVisible(false);
		}
		if(graficas != null) {
			graficas.setVisible(false);
		}
	}
	
//FIN-- OBTENER LOS PANELES DE FORMA DINAMICA
	
	

//	public void processRegisterUser() {
//		this.activeVisibleFor(panelRegisterAccount);
//		this.addJPanelToFrame(panelRegisterAccount);
//	}
	
	
//GRAFICAS PERMITE MOSTRAR LAS GRAFICAS E LOS RESULTADOS OBTENIDOS
	
	public void openGrafica(ArrayList<String> listDatos) {
		graficas = new Graficas(control, SAVE_GRAPHIC, CANCEL_VIEW_GRAPHIC, "Grafica de resultados", "A continuación usted vera la grafica correspondiente de los resultados anteriores", listDatos);
		enableVisibleAllPanels();
		enableVisiblePanelMatriz();
		graficas.setVisible(true);
		add(graficas, BorderLayout.CENTER);
	}
	
	public void saveGraphic(String url) throws IOException {
		graficas.saveGraphic(url);
	}
	
	public Component getComponent() {
		return this.getContentPane();
	}
	
	
//FIN GRAFICAS
	
	
// Abrir una Matriz que me permite darle un peso a los criterios	PANEL PESO CRITERIOS
	
	
	public void openPesoCriterios(int rows, int columns, Object[] listOptions,  Object[] listNameCriteriosBenfitCost) {
		panelMatrizPesoCriterios = new PanelShowMatriz(control, ACCEPT_PESO_CRITERIO,CANCEL_PESO_CRITERIOS,  "Determination of the weight of the criteria", "Please select an option according to the weight of each criterion for each decision maker", rows, columns, listOptions, "d", listNameCriteriosBenfitCost);
		enableVisibleAll();
		enableVisibleAllPanels();
		enableVisiblePanelMatriz();
		panelMatrizPesoCriterios.setVisible(true);
		add(panelMatrizPesoCriterios, BorderLayout.CENTER);
	}

	public String[][] getMatrizPesoCriterios() {
		return panelMatrizPesoCriterios.getDataOfMatriz2Constructor();
	}
	
	public ArrayList<Integer> getColumnCountAndRowCountMatrizPesoCriterios(){
		return panelMatrizPesoCriterios.getColumnCountAndRowCount2Constructor();
	}
	
//FIN-- Abrir una Matriz que me permite darle un peso a los criterios	
	
//listOanlesShowMatriz N  CADA DECISOR PUEDE DAR SU ASIGNACION A LA MATRIZ
	
		public void createNumberMatrizN(int rows, int columns, int numberDecisors, Object[] listOptions,  Object[] listNameCriteriosBenfitCost) {
			for (int i = 0; i < numberDecisors; i++) {
				listPanelsShowMatriz.add(new PanelShowMatriz(control, "PROCESS_MATRIZ_"+i, "CANCEL_VIEW_MATRIZ_"+i, "Complete data of decision maker matrix " + (i+1), "Please fill the matrix, to perform the calculations", rows, columns, listOptions, listNameCriteriosBenfitCost));
			}
		}
		
		public void openShowMatriz(int position) {
			this.enableVisibleAll();
			this.enableVisibleAllPanels();
			this.enableVisiblePanelMatriz();
			this.panelMatrizPesoCriterios.setVisible(false);
			this.ifEnableVisibleMatrizThenActive(listPanelsShowMatriz.get(position));
		}		
		
		public String[][] obtainMatrizN(int i) {
			return listPanelsShowMatriz.get(i).getDataOfMatriz();
		}
		
		public ArrayList<Integer> getColumnCountAndRowCountMatrizNumberN(){
			return listPanelsShowMatriz.get(0).getColumnCountAndRowCount();
		}
		
		public int getSizeListPanelsShowMatriz() {
			return listPanelsShowMatriz.size();
		}
		
//Fin-- ListPanelsShowMatriz CADA DECISOR PUEDE DAR SU ASIGNACION A LA MATRIZ	
	
	
//	PARA MOSTRAR LOS REUSLTADOS FINALES..........................................
	
	public void openResultadosFinales(int rows, int columns, double[][] matrizResultados) {
		panelShowResultadosFinales = new PanelShowMatriz(control, SAVE_RESULTADOS_TOPSIS, CANCEL_SHOW_RESULTADOS, VIEW_GRAPHIC, "The results of having used the IFDA method", rows, columns, matrizResultados);
		enableVisibleAll();
		enableVisibleAllPanels();
		enableVisiblePanelMatriz();
		panelShowResultadosFinales.setVisible(true);
		add(panelShowResultadosFinales, BorderLayout.CENTER);
	}
	
//FIN-- PARA MOSTRAR LOS REUSLTADOS FINALES..........................................
	
	
//Panel EDIT ACCOUNT	
	
	public void openEditAccount() {
		this.activeVisibleFor(panelEditAccount);
		this.addJPanelToFrame(panelEditAccount);
	}
	
	public void setDataForEditAccount(String name, String lastName, String birthday, String phone, String email, String password) {
		panelEditAccount.setData(name, lastName, birthday, phone, email, password);
	}
	
	public void cleanAllCampsEditAccount() {
		panelEditAccount.cleanAllCamps();
	}

// FIN-- PANEL EDIT ACCOUNT
	
	
//Panel RegisterAccount
	
	public void openRegisterAccount() {
		activeVisibleFor(panelRegisterAccount);
		this.addJPanelToFrame(panelRegisterAccount);
	}
	
	public void cleanAllCampsRegisterAccount() {
		panelRegisterAccount.cleanAllCamps();
	}
	
//fin Panel RegisterAccount
	
	
//Panel Account
	
	public void startSelectorApps() {
		enableVisibleAll();
		panelAccount.selectApp();
		activeVisibleFor(panelAccount);
		this.addJPanelToFrame(panelAccount);

	}
	
	public void cleanCampsInitAccount() {
		panelAccount.cleanAllsCamps();
	}
	
	public String getOptionSelectedApps() throws IOException{
		return panelAccount.getOptionSelected();
	}
	
	public String getUser() {
		return panelAccount.getUser();
	}

	public String getPassword() {
		return panelAccount.getPassword();
	}
	
	public String getDataInitAccountUser() {
		return panelAccount.getUser();
	}

	public String getDataInitAccountPassword() {
		return panelAccount.getPassword();
	}
	
	public void processForInitAccount() {
		this.activeVisibleFor(panelAccount);
		this.addJPanelToFrame(panelAccount);
	}

//FIN-- PANELACCOUNT
	
//INICIAR SESION Y CERRAR SESION
	
	public void startSesion() {
		enableVisibleAll();
		activeVisibleFor(panelBar);
		activeVisibleFor(panelOptions);
		panelAccount.startSesion();
		activeVisibleFor(panelAccount);
		panelBar.setVisible(true);
		panelOptions.setVisible(true);
		add(panelBar, BorderLayout.NORTH);
		add(panelOptions, BorderLayout.WEST);
		add(panelAccount, BorderLayout.CENTER);
	}
	
	public void logOut() {
		this.cleanAllCampsFirstProcess();
		enableVisibleAllPanels();
		panelBar.setVisible(false);
		panelOptions.setVisible(false);
		panelAccount.init();
		panelAccount.cleanAllsCamps();
		activeVisibleFor(panelAccount);
		add(panelAccount, BorderLayout.CENTER);
		
	}
	
	public void setNameAccount(String nameAccount) {
		panelOptions.setNameAccount(nameAccount);
	}

//FIN-- INICIAR SESION Y CERRAR SESION
	
	
//PANEL IFDA: PERMITE ESCOGER CUANTOS CRITERIOS DECISORES Y ALTERNATIVAS SE VAN A USAR	
	
	public void openIFDA() {
		enableVisibleAllPanels();
		this.activeVisibleFor(panelIFDA);
		this.addJPanelToFrame(panelIFDA);
	}
	
	public String getNumberDecisors() {
		return panelIFDA.getNumberDecisor();
	}
	
	public String getNumberCriterios() {
		return panelIFDA.getNumberCriterios();
	}
	
	public String getNumberAlternatives() {
		return panelIFDA.getNumberAlternatives();
	}
	
	public void cleanAllCampsIFDA() {
		panelIFDA.cleanAllCamps();
	}
	
//FIN-- PANEL IFDA	 PERMITE ESCOGER CUANTOS CRITERIOS DECISORES Y ALTERNATIVAS SE VAN A USAR	
	
	
//PanelIFDASelectDecisors: Permite escoger que decisores van a participar....	
	
	public void openIFDASelectOptionsDecisors() {
		this.enableVisibleAllPanels();
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelIFDASelectOptionsDecisors);
	}
	
	public void setListOptionsDecisors(Object[] listLeft) {
		panelIFDASelectOptionsDecisors.setListOptions(listLeft);
	}
	
	public ArrayList<String> getListSelectedOptionsDecisors() {
		return panelIFDASelectOptionsDecisors.getListOptionsSelected();
	}
	
//Fin-- PanelIFDASelectDecisors: Permite escoger que decisores van a participar....	
	
	
//PanelIFDASelectCriterios: Permite seleccionar los criterios que se VAN A USAR 
	
	public void openIFDASelectOptionsCriterios() {
		this.enableVisibleAllPanels();
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelIFDASelectOptionsCriterios);
	}

	public ArrayList<String> getListSelectedOptionsCriterios() {
		return panelIFDASelectOptionsCriterios.getListOptionsSelected();
	}
	
	public void setListOptionsCriterios(Object[] listLeft) {
		panelIFDASelectOptionsCriterios.setListOptions(listLeft);
	}
	
//FIN-- PanelIFDASelectCriterios: Permite seleccionar los criterios que se VAN A USAR 
	
	public void openNameAndTypeOfCriterios(int rows, Object[] listOptionsBenfitCost) {
		panelIFDASelectOptionsCriteriosName = new PanelShowMatriz(control, ACCEPT_SELECTED_CRITERIO, "SI CANCELO", "Please assign a name to the criterion and choose the type of criteria, as you consider", rows, listOptionsBenfitCost);
		enableVisibleAll();
		enableVisibleAllPanels();
		enableVisiblePanelMatriz();
		panelIFDASelectOptionsCriteriosName.setVisible(true);
		add(panelIFDASelectOptionsCriteriosName, BorderLayout.CENTER);
	}
	
	public String[][] getDataOfCriteriosNameAndType(){
		return panelIFDASelectOptionsCriteriosName.getDataOfMatriz4Constructor();
	}
	
	

	
//2FIN-- DE LO MISMO
	
//PanelCreateDecisor: permite agregar un decisor con su cargo respectivo	

	public void openCreateDecisor() {
		this.activeVisibleFor(panelCreateDecisor);
		this.addJPanelToFrame(panelCreateDecisor);
	}
	
	public void setListCharges(Object[] list) {
		panelCreateDecisor.setCharges(list);
	}
	
	public void cleanAllCampsCreateDecisor() {
		panelCreateDecisor.cleanAllCamps();
	}
	
	public String getCharge() {
		return panelCreateDecisor.getCharge();
	}
	
	public String getNameDecisor() {
		return panelCreateDecisor.getNameDecisor();
	}
	
	public String getLastNameDecisor() {
		return panelCreateDecisor.getLastNameDecisor();
	}
	
	public String getEmail() {
		return panelCreateDecisor.getEmail();
	}
	
//FIN-- PanelCreateDecisor: permite agregar un decisor con su cargo respectivo	
	

//PanelModifyData: permite seleccionar si se desea modificar alguna variable linguistica o criterio o cargo (aún no implementado)	
	
	public void openModifyData() {
		enableVisibleAllPanels();
		this.activeVisibleFor(panelModifyData);
		this.addJPanelToFrame(panelModifyData);
	}
	
	public String getOptionSelectedModifyData() throws IOException {
		return panelModifyData.getOptionSelected();
	}
	
	public void setOptionsModify(Object[] listOptions) {
		panelModifyData.setOptionsModify(listOptions);
	}
	
//FIN-- PanelModifyData: permite seleccionar si se desea modificar alguna variable linguistica o criterio o cargo (aún no implementado)	
	

//PanelEditCriterio: Permite editar un criterio visualizar y ver si agregar modificar o otro
	
	public void openViewCriterios() {
		this.enableVisibleAll();
		this.enableVisibleAllPanels();
		this.ifEnableVisibleThenActive(panelEditCriterio);
	}
	
	public void setListCriterios(Object[] listOptions) {
		panelEditCriterio.setOptionsModify(listOptions);
	}
	
	public void openAddCriterio() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelAddCriterio);
	}
	
	public void cleanAllCampsAddCriterio() {
		panelAddCriterio.cleanAllCamps();
	}
	
	public void openModifyCriterio() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelModifyCriterio);
	}
	
	public void setListCriteriosForModify(Object[] list) {
		panelModifyCriterio.setListCriterios(list);
	}
	
	public void OpenDeleteCriterio() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelDeleteCriterio);
	}
	
	public void setListCriteriosForDelete(Object[] list) {
		panelDeleteCriterio.setListCriterios(list);
	}

//FIN-- PanelEditCriterio: Permite editar un criterio visualizar y ver si agregar modificar o otro
	

//PanelEditVarLing: Permite editar una Variable Linguistica visualizar y ver si agregar modificar o otro
	
	public void openViewVarLing() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelEditVarLing);
	}
	
	public void setListVarLing(Object[] listOptions) {
		panelEditVarLing.setOptionsModify(listOptions);
	}
	
	public void openAddVarLing() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelAddVarLing);
	}
	
	public void cleanAllCampsAddVarLing() {
		panelAddVarLing.cleanAllCamps();
	}
	
	public void openModifyVarLing() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelModifyVarLing);
	}
	
	public void setListVarLingForModify(Object[] list) {
		panelModifyVarLing.setListCriterios(list);
	}
	
	public void OpenDeleteVarLing() {
		this.enableVisibleAll();
		this.ifEnableVisibleThenActive(panelDeleteVarLing);
	}
	
	public void setListVarLingForDelete(Object[] list) {
		panelDeleteVarLing.setListCriterios(list);
	}

//FIN-- PanelEditVarLing: Permite editar una Variable Linguistica visualizar y ver si agregar modificar o otro
	
	
	
	
//PanelVisualizeInformation: Panel que meustra de forma generica mensajes
	
	public void sendMessageAlert(String message1, String message2, boolean isError) {
		visualizeInformation = new PanelInformation(control, message1, message2, isError);
		visualizeInformation.setVisible(true);
	}
	
	public void closeInformation() {
		visualizeInformation.dispose();
	}
	
//FIN-- PanelVisualizeInformation: Panel que meustra de forma generica mensajes
	
	
//Panel para limpiar campos generico
	
	public void cleanAllCampsFirstProcess() {
		this.cleanAllCampsEditAccount();
		this.cleanAllCampsIFDA();
		this.cleanAllCampsCreateDecisor();
	}
	
	public void cleanAllCampsForAll() {
		this.cleanAllCampsEditAccount();
		this.cleanAllCampsIFDA();
		this.cleanAllCampsCreateDecisor();
		this.cleanAllCampsAddVarLing();
		this.cleanAllCampsAddCriterio();
	}
	
//FIN-- PANEL PARA LIMPIAR CAMPOS GENERICO

	
}