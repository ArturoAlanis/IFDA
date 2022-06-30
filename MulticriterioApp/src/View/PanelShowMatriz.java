package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Control.Controller;

public class PanelShowMatriz extends JPanel {
	private JLabel lblNameApp;
	private JLabel lblDescription;
	private JTextField txtNumberDecisors;
	private JTextField txtNumberCriterios;
	private JTextField txtNumberAlternatives;
	private DefaultListModel<String> defaultListModel;
	private JList<String> list2;
	private JTable tabla;
	private JTable tabla2;
	private JTable tabla3;
	private JTable tabla4;
	private ButtonGeneral btnAcceptOption;
	private ButtonGeneral btnCancelOption;
	private ButtonGeneral btnViewGraphic;
	private GridBagConstraints gbc;

	public PanelShowMatriz(Controller control, String actionSelect, String actionCancel, String nameApp,  String mssDescription, int rows, int columns, Object[] listOptions, Object[] listNameCriteriosBenfitCost) {
		lblNameApp = new JLabel(nameApp);
		lblDescription = new JLabel(mssDescription);
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(actionSelect);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionCancel);
		btnCancelOption.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init(this.panelSelectOptions(rows, columns, listOptions, listNameCriteriosBenfitCost));
		if (rows == 6 && columns == 6) {
			//mientras tanto
			System.out.println("mientras tanto");
			this.mientrasTanto(listOptions);
		}
	}
	
	private void mientrasTanto(Object[] listOptions) {
		JComboBox  cbxOptions = new JComboBox(listOptions);
		tabla.setValueAt(cbxOptions.getItemAt(4), 0, 1);
		tabla.setValueAt(cbxOptions.getItemAt(3), 1, 1);
		tabla.setValueAt(cbxOptions.getItemAt(3), 2, 1);
		tabla.setValueAt(cbxOptions.getItemAt(3), 3, 1);
		tabla.setValueAt(cbxOptions.getItemAt(6), 4, 1);
		tabla.setValueAt(cbxOptions.getItemAt(3), 5, 1);
		tabla.setValueAt(cbxOptions.getItemAt(3), 0, 2);
		tabla.setValueAt(cbxOptions.getItemAt(4), 1, 2);
		tabla.setValueAt(cbxOptions.getItemAt(6), 2, 2);
		tabla.setValueAt(cbxOptions.getItemAt(6), 3, 2);
		tabla.setValueAt(cbxOptions.getItemAt(6), 4, 2);
		tabla.setValueAt(cbxOptions.getItemAt(6), 5, 2);
		tabla.setValueAt(cbxOptions.getItemAt(6), 0, 3);
		tabla.setValueAt(cbxOptions.getItemAt(6), 1, 3);
		tabla.setValueAt(cbxOptions.getItemAt(6), 2, 3);
		tabla.setValueAt(cbxOptions.getItemAt(5), 3, 3);
		tabla.setValueAt(cbxOptions.getItemAt(4), 4, 3);
		tabla.setValueAt(cbxOptions.getItemAt(4), 5, 3);
		tabla.setValueAt(cbxOptions.getItemAt(3), 0, 4);
		tabla.setValueAt(cbxOptions.getItemAt(6), 1, 4);
		tabla.setValueAt(cbxOptions.getItemAt(8), 2, 4);
		tabla.setValueAt(cbxOptions.getItemAt(5), 3, 4);
		tabla.setValueAt(cbxOptions.getItemAt(5), 4, 4);
		tabla.setValueAt(cbxOptions.getItemAt(3), 5, 4);
		tabla.setValueAt(cbxOptions.getItemAt(2), 0, 5);
		tabla.setValueAt(cbxOptions.getItemAt(2), 1, 5);
		tabla.setValueAt(cbxOptions.getItemAt(5), 2, 5);
		tabla.setValueAt(cbxOptions.getItemAt(6), 3, 5);
		tabla.setValueAt(cbxOptions.getItemAt(7), 4, 5);
		tabla.setValueAt(cbxOptions.getItemAt(4), 5, 5);
		tabla.setValueAt(cbxOptions.getItemAt(6), 0, 6);
		tabla.setValueAt(cbxOptions.getItemAt(6), 1, 6);
		tabla.setValueAt(cbxOptions.getItemAt(4), 2, 6);
		tabla.setValueAt(cbxOptions.getItemAt(7), 3, 6);
		tabla.setValueAt(cbxOptions.getItemAt(8), 4, 6);
		tabla.setValueAt(cbxOptions.getItemAt(6), 5, 6);
	}
	
	public PanelShowMatriz(Controller control, String actionSelect, String actionCancel, String nameApp,  String mssDescription, int rows, int columns, Object[] listOptions, String option2Constructor,  Object[] listNameCriteriosBenfitCost) {
		removeAll();
		lblNameApp = new JLabel(nameApp);
		lblDescription = new JLabel(mssDescription);
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(actionSelect);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionCancel);
		btnCancelOption.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.init(panelSelectOptions2Constructor(rows, columns, listOptions, listNameCriteriosBenfitCost));
		System.out.println(rows + "- " + columns);
		if (rows == 5 && columns == 6) {
			//mientras tanto
			System.out.println("mientras tanto 2 Constructor");
			this.mientrasTanto2Constructor(listOptions);
		}
	}
	
	private void mientrasTanto2Constructor(Object[] listOptions) {
		JComboBox  cbxOptions = new JComboBox(listOptions);
		tabla2.setValueAt(cbxOptions.getItemAt(3), 0, 1);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 1, 1);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 2, 1);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 3, 1);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 4, 1);
		tabla2.setValueAt(cbxOptions.getItemAt(0), 0, 2);
		tabla2.setValueAt(cbxOptions.getItemAt(4), 1, 2);
		tabla2.setValueAt(cbxOptions.getItemAt(3), 2, 2);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 3, 2);
		tabla2.setValueAt(cbxOptions.getItemAt(4), 4, 2);
		tabla2.setValueAt(cbxOptions.getItemAt(3), 0, 3);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 1, 3);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 2, 3);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 3, 3);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 4, 3);
		tabla2.setValueAt(cbxOptions.getItemAt(0), 0, 4);
		tabla2.setValueAt(cbxOptions.getItemAt(4), 1, 4);
		tabla2.setValueAt(cbxOptions.getItemAt(3), 2, 4);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 3, 4);
		tabla2.setValueAt(cbxOptions.getItemAt(4), 4, 4);
		tabla2.setValueAt(cbxOptions.getItemAt(4), 0, 5);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 1, 5);
		tabla2.setValueAt(cbxOptions.getItemAt(3), 2, 5);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 3, 5);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 4, 5);
		tabla2.setValueAt(cbxOptions.getItemAt(1), 0, 6);
		tabla2.setValueAt(cbxOptions.getItemAt(3), 1, 6);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 2, 6);
		tabla2.setValueAt(cbxOptions.getItemAt(4), 3, 6);
		tabla2.setValueAt(cbxOptions.getItemAt(2), 4, 6);
	}
	
	public PanelShowMatriz(Controller control, String actionSelect, String actionCancel, String actionViewGraphic, String mssDescriptionResults, int rows, int columns, double[][] listOptions) {
		lblNameApp = new JLabel("Final results");
		lblDescription = new JLabel(mssDescriptionResults);
		btnAcceptOption = new ButtonGeneral("Save results ", 190, 30);
		btnAcceptOption.setActionCommand(actionSelect);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionCancel);
		btnCancelOption.addActionListener(control);
		btnViewGraphic = new ButtonGeneral("Show Graphic", 150, 30);
		btnViewGraphic.setActionCommand(actionViewGraphic);
		btnViewGraphic.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		this.initfForResults(this.panelWithResults(rows, columns, listOptions));
		if (rows == 6 && columns == 6) {
			//mientras tanto
			System.out.println("mientras tanto");
			this.mientrasTanto(listOptions);
		}
	}
	
	public PanelShowMatriz(Controller control, String actionSelect, String actionCancel, String mssDescriptionSelectCriterios, int rows, Object[] listOptionsBenfitCost) {
		lblNameApp = new JLabel("IFDA - Criteria Selection");
		lblDescription = new JLabel(mssDescriptionSelectCriterios);
		btnAcceptOption = new ButtonGeneral("Accept ", 150, 30);
		btnAcceptOption.setActionCommand(actionSelect);
		btnAcceptOption.addActionListener(control);
		btnCancelOption = new ButtonGeneral(150, 30, null, "Cancel");
		btnCancelOption.setActionCommand(actionCancel);
		btnCancelOption.addActionListener(control);
		AbstractBorder border = new TextBubbleBorder(Color.BLACK, 3, 0);
		setBorder(border);
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		this.assignValues(border);
		
		this.init(this.panelSelectOptions4Constructor(rows, listOptionsBenfitCost));
//		if (rows == 6 && columns == 6) {
//			//mientras tanto
//			System.out.println("mientras tanto");
//			this.mientrasTanto(listOptions);
//		}
	}

	private void assignValues(AbstractBorder brd) {
		Font fuente = new Font("Calibri", 3, 14);
		fuente = new Font("Arial Black", 3, 14);
		lblNameApp.setFont(fuente);
		fuente = new Font("Arial Rounded MT Bold", 3, 14);
		lblDescription.setFont(fuente);
	}
	
	public ArrayList<String> getListOptionsSelected() {
		ArrayList<String> listOptionsSelected = new ArrayList<String>();
		for (int i = 0; i < list2.getModel().getSize(); i++) {
			listOptionsSelected.add(list2.getModel().getElementAt(i));
		}
		return listOptionsSelected;
	}
	
	private JPanel panelSelectOptions(int rows, int columns, Object[] listOptions, Object[] listNameCriteriosBenfitCost) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		DefaultTableModel tableModel = new DefaultTableModel(rows, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (0 == column)
					return false;
				return super.isCellEditable(row, column);
			}
		};
		ArrayList<String> listColumns = new ArrayList<String>();
		listColumns.add("Alternative / Criteria");
		// Titulos para la cabecera superior. El primero es vacio,
		for (int i = 0; i < columns; i++) {
			listColumns.add(listNameCriteriosBenfitCost[i].toString());
		}
//		tableModel.setColumnIdentifiers(new String[] { "", "A", "B", "C", "D"," ", "holaa" });
		tableModel.setColumnIdentifiers(listColumns.toArray());
		// Valores para la primera columna, que es la cabecera lateral.
		for (int i = 0; i < rows; i++) {
			tableModel.setValueAt("Alternative"+ (i+1), i, 0);
		}
		// JTable al que se le pasa el modelo recien creado y se
		// sobreescribe el metodo changeSelection para que no permita
		// seleccionar la primera columna.
		tabla = new JTable(tableModel) {
			@Override
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
				if (columnIndex == 0)
					super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
				else
					super.changeSelection(rowIndex, columnIndex, toggle, extend);
			}
		};
		// Se pone a la primera columna el render del JTableHeader
		// superior.
		tabla.getColumnModel().getColumn(0).setCellRenderer(
		tabla.getTableHeader().getDefaultRenderer());
		tabla.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabla.setShowHorizontalLines( true );
		tabla.setRowSelectionAllowed( true );
		tabla.setColumnSelectionAllowed( true );
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.getTableHeader().setResizingAllowed(false);
		//--
		tabla.setSelectionForeground( Color.white );
		tabla.setSelectionBackground( Color.red );
		tabla.setRowHeight(20);
		tabla.setBackground(Color.WHITE);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JComboBox  cbxOptions = new JComboBox(listOptions);
		Dimension tableSize =  tabla.getPreferredSize();
		for (int i = 1; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(cbxOptions));
			tabla.getColumnModel().getColumn(i).setPreferredWidth(270);
//			tabla.setSelectedIndex(2);
		}
		for (int i = 1; i < tabla.getColumnCount(); i++) {
			for (int j = 0; j < tabla.getRowCount(); j++) {
				tabla.setValueAt(cbxOptions.getItemAt(1), j, i);
			}
		}
		// Creación y visualización de la ventana completa.
//		JFrame v = new JFrame("Cabecera lateral");
		tabla.repaint();
		tabla.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane( tabla);
//		scroll.setPreferredSize(new Dimension(400,300));
		scroll.setBackground(Color.WHITE);
		scroll.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
		scroll.setPreferredSize(new Dimension(800,300));
		scroll.repaint();
		panel.add(scroll);
		panel.repaint();
        return panel;
    }
	
	private JPanel panelSelectOptions2Constructor(int rows, int columns, Object[] listOptions, Object[] listNameCriteriosBenfitCost) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		DefaultTableModel tableModel = new DefaultTableModel(rows, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (0 == column)
					return false;
				return super.isCellEditable(row, column);
			}
		};
		ArrayList<String> listColumns = new ArrayList<String>();
		listColumns.add("Decision Makers ");
		// Titulos para la cabecera superior. El primero es vacio,
		for (int i = 0; i < columns; i++) {
			listColumns.add(listNameCriteriosBenfitCost[i].toString());
		}
//		tableModel.setColumnIdentifiers(new String[] { "", "A", "B", "C", "D"," ", "holaa" });
		tableModel.setColumnIdentifiers(listColumns.toArray());
		// Valores para la primera columna, que es la cabecera lateral.
		for (int i = 0; i < rows; i++) {
			tableModel.setValueAt("Decision Maker "+ (i+1), i, 0);
		}
		// JTable al que se le pasa el modelo recien creado y se
		// sobreescribe el metodo changeSelection para que no permita
		// seleccionar la primera columna.
		tabla2 = new JTable(tableModel) {
			@Override
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
				if (columnIndex == 0)
					super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
				else
					super.changeSelection(rowIndex, columnIndex, toggle, extend);
			}
		};
		// Se pone a la primera columna el render del JTableHeader
		// superior.
		tabla2.getColumnModel().getColumn(0).setCellRenderer(
		tabla2.getTableHeader().getDefaultRenderer());
		tabla2.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabla2.setShowHorizontalLines( true );
		tabla2.setRowSelectionAllowed( true );
		tabla2.setColumnSelectionAllowed( true );
		tabla2.getTableHeader().setReorderingAllowed(false);
		tabla2.getTableHeader().setResizingAllowed(false);
		//--
		tabla2.setSelectionForeground( Color.white );
		tabla2.setSelectionBackground( Color.red );
		tabla2.setRowHeight(20);
		tabla2.setBackground(Color.WHITE);
		tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JComboBox  cbxOptions = new JComboBox(listOptions);
		Dimension tableSize =  tabla2.getPreferredSize();
		for (int i = 1; i < tabla2.getColumnCount(); i++) {
			tabla2.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(cbxOptions));
			tabla2.getColumnModel().getColumn(i).setPreferredWidth(270);
//			tabla.setSelectedIndex(2);
		}
		for (int i = 1; i < tabla2.getColumnCount(); i++) {
			for (int j = 0; j < tabla2.getRowCount(); j++) {
				tabla2.setValueAt(cbxOptions.getItemAt(1), j, i);
			}
		}
		// Creación y visualización de la ventana completa.
//		JFrame v = new JFrame("Cabecera lateral");
		tabla2.repaint();
		tabla2.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane( tabla2);
//		scroll.setPreferredSize(new Dimension(400,300));
		scroll.setBackground(Color.WHITE);
		scroll.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
		scroll.setPreferredSize(new Dimension(800,300));
		scroll.repaint();
		panel.add(scroll);
		panel.repaint();
        return panel;
    }
	
	private JPanel panelWithResults(int rows, int columns, double[][] listResults) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		DefaultTableModel tableModel = new DefaultTableModel(rows, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (row == row)
					return false;
				return super.isCellEditable(row, column);
			}
		};
		ArrayList<String> listColumns = new ArrayList<String>();
		listColumns.add("Alternative/IS-TOP");
		// Titulos para la cabecera superior. El primero es vacio,
		for (int i = 0; i < columns; i++) {
			if (i%2==0) {
				listColumns.add("IS ");
			}else {
				listColumns.add("Ranking/TOP");
			}
		}
//		tableModel.setColumnIdentifiers(new String[] { "", "A", "B", "C", "D"," ", "holaa" });
		tableModel.setColumnIdentifiers(listColumns.toArray());
		// Valores para la primera columna, que es la cabecera lateral.
		for (int i = 0; i < rows; i++) {
			tableModel.setValueAt("Alternative"+ (i+1), i, 0);
		}
		// JTable al que se le pasa el modelo recien creado y se
		// sobreescribe el metodo changeSelection para que no permita
		// seleccionar la primera columna.
		tabla3 = new JTable(tableModel) {
			@Override
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
				if (columnIndex == 0)
					super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
				else
					super.changeSelection(rowIndex, columnIndex, toggle, extend);
			}
		};
		// Se pone a la primera columna el render del JTableHeader
		// superior.
		tabla3.getColumnModel().getColumn(0).setCellRenderer(
		tabla3.getTableHeader().getDefaultRenderer());
		tabla3.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabla3.setShowHorizontalLines( true );
		tabla3.setRowSelectionAllowed( true );
		tabla3.setColumnSelectionAllowed( true );
		tabla3.getTableHeader().setReorderingAllowed(false);
		tabla3.getTableHeader().setResizingAllowed(false);
		//--
		tabla3.setSelectionForeground( Color.white );
		tabla3.setSelectionBackground( Color.red );
		tabla3.setRowHeight(20);
		tabla3.setBackground(Color.WHITE);
		tabla3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension tableSize =  tabla3.getPreferredSize();
		for (int i = 1; i < tabla3.getColumnCount(); i++) {
//			tabla.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(cbxOptions));//aqui va algo-------------------------------pero no se que
			tabla3.getColumnModel().getColumn(i).setPreferredWidth(270);
		}
		for (int i = 1; i < tabla3.getColumnCount(); i++) {
			for (int j = 0; j < tabla3.getRowCount(); j++) {
				if (i==tabla3.getColumnCount()-1) {
					tabla3.setValueAt((int)(listResults[j][i-1]), j, i);
				}else {
					tabla3.setValueAt(listResults[j][i-1], j, i);
				}
			}
		}
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tabla3.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		// Creación y visualización de la ventana completa.
//		JFrame v = new JFrame("Cabecera lateral");
		tabla3.repaint();
		tabla3.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane( tabla3);
//		scroll.setPreferredSize(new Dimension(400,300));
		scroll.setBackground(Color.WHITE);
		scroll.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
		scroll.setPreferredSize(new Dimension(800,300));
		scroll.repaint();
		panel.add(scroll);
//		ButtonGeneral btnGen = new ButtonGeneral("Ver Grafica", 150, 30);
//		btnGen.addActionListener(control);
//		btnGen.setActionCommand("RR");
		panel.repaint();
        return panel;
    }
	
	private JPanel panelSelectOptions4Constructor(int rows, Object[] listOptionsBenfitCost) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		DefaultTableModel tableModel = new DefaultTableModel(rows, 2) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (0 == column)
					return false;
				return super.isCellEditable(row, column);
			}
			
			
		};
		JComboBox  cbxOptions = new JComboBox(listOptionsBenfitCost);
		ArrayList<String> listColumns = new ArrayList<String>();
		listColumns.add("Characteristic ");
		listColumns.add("Name ");
		listColumns.add("Criteria Type ");
		// Titulos para la cabecera superior. El primero es vacio,
		for (int i = 0; i < rows; i++) {
			tableModel.setValueAt("Criteria "+ (i+1), i, 0);
		}
		tableModel.setColumnIdentifiers(listColumns.toArray());
		// JTable al que se le pasa el modelo recien creado y se
		// sobreescribe el metodo changeSelection para que no permita
		// seleccionar la primera columna.
		tabla4 = new JTable(tableModel) {
			@Override
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
				if (columnIndex == 0)
					super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
				else
					super.changeSelection(rowIndex, columnIndex, toggle, extend);
			}
		};
		
		
		
		// Se pone a la primera columna el render del JTableHeader
		// superior.
		tabla4.getColumnModel().getColumn(0).setCellRenderer(
		tabla4.getTableHeader().getDefaultRenderer());
		tabla4.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabla4.setShowHorizontalLines( true );
		tabla4.setRowSelectionAllowed( true );
		tabla4.setColumnSelectionAllowed( true );
		tabla4.getTableHeader().setReorderingAllowed(false);
		tabla4.getTableHeader().setResizingAllowed(false);
		//--
		tabla4.setSelectionForeground( Color.white );
		tabla4.setSelectionBackground( Color.red );
		tabla4.setRowHeight(20);
		tabla4.setBackground(Color.WHITE);
		tabla4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Dimension tableSize =  tabla4.getPreferredSize();
		for (int i = 1; i < tabla4.getColumnCount(); i++) {
			tabla4.getColumnModel().getColumn(i).setPreferredWidth(270);
		}
		tabla4.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cbxOptions));
		for (int i = 0; i < rows; i++) {
			tabla4.setValueAt("Criterio  df " + (i+1), i, 1);
			tabla4.setValueAt(cbxOptions.getItemAt(0), i, 2);
		}
		// Creación y visualización de la ventana completa.
//		JFrame v = new JFrame("Cabecera lateral");
		tabla4.repaint();
		tabla4.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane( tabla4);
//		scroll.setPreferredSize(new Dimension(400,300));
		scroll.setBackground(Color.WHITE);
		scroll.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
		scroll.setPreferredSize(new Dimension(800,300));
		scroll.repaint();
		panel.add(scroll);
		panel.repaint();
        return panel;
    }
	
	public String getNumberDecisor() {
		return txtNumberDecisors.getText();
	}
	
	public String getNumberCriterios() {
		return txtNumberCriterios.getText();
	}
	
	public String getNumberAlternatives() {
		return txtNumberAlternatives.getText();
	}

	private void init(JPanel panelSelectOptions) {
		removeAll();
		gbc = new GridBagConstraints();
//		gbc.anchor = GridBagConstraints.CENTER;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		gbc.insets = new Insets(0, 0, 30, 0);
//		add(lblNameApp, gbc);
//		gbc.insets = new Insets(0, 0, 120, 0);
//		add(lblDescription, gbc);
//		gbc.insets = new Insets(0, 0, 0, 0);
//		add(panelChoose, gbc);
//		gbc.gridwidth = GridBagConstraints.RELATIVE;
//		add(btnAcceptOption, gbc);
//		add(btnCancelOption, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weighty = 0.2;
		add(lblNameApp, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0.2;
		add(lblDescription, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0.4;
		add(panelSelectOptions, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 0, 0, 10);
		add(btnAcceptOption, gbc);
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		add(btnCancelOption, gbc);
	}
	
	private void initfForResults(JPanel panelSelectOptions) {
		removeAll();
		gbc = new GridBagConstraints();
//		gbc.anchor = GridBagConstraints.CENTER;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		gbc.insets = new Insets(0, 0, 30, 0);
//		add(lblNameApp, gbc);
//		gbc.insets = new Insets(0, 0, 120, 0);
//		add(lblDescription, gbc);
//		gbc.insets = new Insets(0, 0, 0, 0);
//		add(panelSelectOptions, gbc);
//		gbc.gridwidth = GridBagConstraints.RELATIVE;
//		add(btnAcceptOption, gbc);
//		add(btnCancelOption, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weighty = 0.2;
		add(lblNameApp, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0.2;
		add(lblDescription, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = gbc.weighty = 0.4;
		add(panelSelectOptions, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.insets = new Insets(0, 50, 0, 10);
		add(btnAcceptOption, gbc);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		gbc.insets = new Insets(0, 0, 0, 100);
		add(btnViewGraphic, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty=0.7;
		gbc.gridwidth = 1;
		gbc.gridheight = 0;
		add(btnCancelOption, gbc);
	}
	
	public String[][] getDataOfMatriz(){
		String[][] datos = new String[tabla.getColumnCount()][tabla.getRowCount()];
		for (int i = 0; i < tabla.getRowCount(); i++) {
			for (int j = 0; j < tabla.getColumnCount(); j++) {
				datos[j][i] = tabla.getValueAt(i, j).toString();
			}
		}
		return datos;
	}
	
	public String[][] getDataOfMatriz2Constructor(){
		String[][] datos = new String[tabla2.getColumnCount()][tabla2.getRowCount()];
		for (int i = 0; i < tabla2.getRowCount(); i++) {
			for (int j = 0; j < tabla2.getColumnCount(); j++) {
				datos[j][i] = tabla2.getValueAt(i, j).toString();
			}
		}
		return datos;
	}
	
	public String[][] getDataOfMatriz4Constructor() { 
		String[][] datos = new String[tabla4.getRowCount()][tabla4.getColumnCount()+1];
		for (int i = 0; i < tabla4.getRowCount(); i++) {
			for (int j = 0; j < tabla4.getColumnCount(); j++) {
				if (tabla4.getValueAt(i, j) != null) {
					datos[i][j] = tabla4.getValueAt(i, j).toString();
				}else {
					datos[i][j] = " ";
				}
			}
		}
		return datos;
	}
	
	public ArrayList<Integer> getColumnCountAndRowCount(){
		ArrayList<Integer> listColumnRow = new ArrayList<Integer>();
		listColumnRow.add(tabla.getColumnCount());
		listColumnRow.add(tabla.getRowCount());
		return listColumnRow;
	}
	
	public ArrayList<Integer> getColumnCountAndRowCount2Constructor(){
		ArrayList<Integer> listColumnRow2 = new ArrayList<Integer>();
		listColumnRow2.add(tabla2.getColumnCount());
		listColumnRow2.add(tabla2.getRowCount());
		return listColumnRow2;
	}

}
