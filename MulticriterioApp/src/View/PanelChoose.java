package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class PanelChoose extends JPanel{
	private JLabel lblNameApp;
	private PanelChooseOptions panelChooseOptions;
	private JScrollPane scroll;
	private GridBagConstraints gbc;
	
	public PanelChoose(String nameChoose, Object[] listOption) {
		panelChooseOptions = new PanelChooseOptions(listOption);
		lblNameApp = new JLabel(nameChoose);
		scroll = new JScrollPane( panelChooseOptions, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(new TextBubbleBorder(Color.BLACK, 3, 0));
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(35,168,176);
		    }
		    
		    @Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
		});
		this.setPreferredSize(new Dimension(200,300));
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		init(nameChoose);
		
	}
	
	public void init(String nameChoose) {
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(lblNameApp, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}
	
	public void setOptionsModify(Object[] listOptions) {
		panelChooseOptions.assignOptions(listOptions);
	}
	
	public String getOptionSelected() throws IOException  {
		return panelChooseOptions.getOptionSelected();
	}
}
