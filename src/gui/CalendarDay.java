import javax.swing.JPanel;

import GUI.Screen;
import Logic.ActionController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

import java.awt.SystemColor;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.multi.MultiLabelUI;

import java.awt.Color;

public class CalendarDay extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String WEEK = "week";
	public static final String NOTE = "note";
	public static final String SET = "set";
	public static final String CREATEEVE = "createeve";
	public static final String DELETEEVE = "deleteeve";
	public static final String DELNOTE = "delnote";
	
	private JLabel lblDayView;
	private JPanel eventPanel;
	private JPanel activePanel;
	private JTable eventTable;
	private JScrollPane eventScroll;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnBack;
	private JButton btnNote;
	private JButton btnSet;
	private JButton btnDelNote;
	private JTextArea forecastTxt;
	private JTextArea noteTxt;
	private JPanel bottomPanel;
	private JPanel infoPanel;
	private JPanel notePanel;
	
	public CalendarDay () {
		setSize(Screen.WIDTH,Screen.HEIGHT);
		setLayout(new BorderLayout());
		setBackground(new Color(199, 21, 133));
	
		
		lblDayView = new JLabel("Day view");
		lblDayView.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayView, BorderLayout.NORTH);
		
		
		eventPanel = new JPanel();
		add(eventPanel, BorderLayout.CENTER);
		eventPanel.setLayout(new BorderLayout(0, 0));
		setBackground(new Color(199, 21, 133));
	
		
		notePanel = new JPanel();
		notePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(199, 21, 133), SystemColor.textHighlight, SystemColor.textHighlight, SystemColor.textHighlight));
//		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		notePanel.setMaximumSize(new Dimension(1000, 100));
		notePanel.setPreferredSize(new Dimension(300, 100));
		notePanel.setMinimumSize(new Dimension(1, 100));
		notePanel.setVisible(false);
		eventPanel.add(notePanel, BorderLayout.EAST);
		setBackground(new Color(199, 21, 133));
		
		
		noteTxt = new JTextArea("");
		noteTxt.setBackground(SystemColor.control);
		noteTxt.setEditable(false);
		noteTxt.setWrapStyleWord(true);
	    noteTxt.setLineWrap(true);
	    noteTxt.setVisible(false);
		notePanel.add(noteTxt);
		
		
		bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		setBackground(new Color(199, 21, 133));
		
		
		activePanel = new JPanel();
		bottomPanel.add(activePanel, BorderLayout.SOUTH);
		setBackground(new Color(199, 21, 133));
		
		
		btnCreate = new JButton("Add event");
		btnCreate.setActionCommand(CREATEEVE);
		activePanel.add(btnCreate);
		
		btnDelete = new JButton("Delete event");
		btnDelete.setActionCommand(DELETEEVE);
		activePanel.add(btnDelete);
		
		btnBack = new JButton("Week View");
		btnBack.setActionCommand(WEEK);
		activePanel.add(btnBack);
		
		btnNote = new JButton("View note");
		btnNote.setActionCommand(NOTE);
		activePanel.add(btnNote);
		
		infoPanel = new JPanel();
		bottomPanel.add(infoPanel, BorderLayout.NORTH);
		infoPanel.setLayout(new GridLayout(0, 4, 0, 0));
		setBackground(new Color(199, 21, 133));
		
		
		forecastTxt = new JTextArea("");
		forecastTxt.setEditable(false);
		forecastTxt.setWrapStyleWord(true);
		forecastTxt.setLineWrap(true);
		forecastTxt.setBackground(SystemColor.control);
		infoPanel.add(forecastTxt);
		
		btnSet = new JButton("Add note");
		infoPanel.add(btnSet);
		btnSet.setVisible(false);
		btnSet.setActionCommand(SET);
		
		btnDelNote = new JButton("Delete Note");
		btnDelNote.setVisible(false);
		btnDelNote.setActionCommand(DELNOTE);
		infoPanel.add(btnDelNote);
		
	
		
	}

	

	public void updateEvents(Object[][] data,String[] header) {
		
		if(eventTable != null){
			eventPanel.remove(eventTable);
			eventPanel.remove(eventScroll);
		}
		eventTable = new JTable(data,header);
		eventTable.setPreferredScrollableViewportSize(new Dimension(800,70));
		eventTable.setFillsViewportHeight(true);
		
		eventScroll = new JScrollPane(eventTable);
		eventScroll.setBounds(26,30,930,280);
		eventPanel.add(eventScroll);
		
	}
	
	public void removeTable() {
		eventPanel.remove(eventTable);
		eventPanel.remove(eventScroll);
	}
	
	public JLabel getLblDayView() {
		return lblDayView;
	}

	public void setLblDayView(JLabel lblDayView) {
		this.lblDayView = lblDayView;
	}

	public JPanel getEventPanel() {
		return eventPanel;
	}

	public void setEventPanel(JPanel eventPanel) {
		this.eventPanel = eventPanel;
	}

	public JPanel getActivePanel() {
		return activePanel;
	}
	public JTextArea getForecastTxt() {
		return forecastTxt;
	}

	public void setForecastTxt(JTextArea forecastTxt) {
		this.forecastTxt = forecastTxt;
	}

	public void setActivePanel(JPanel activePanel) {
		this.activePanel = activePanel;
	}

	public JTextArea getNoteLbl() {
		return noteTxt;
	}

	public void setNoteTxt(JTextArea noteTxt) {
		this.noteTxt = noteTxt;
	}

	public JButton getBtnSet() {
		return btnSet;
	}

	public void setBtnSet(JButton btnSet) {
		this.btnSet = btnSet;
	}

	



	public JPanel getNotePanel() {
		return notePanel;
	}



	public void setNotePanel(JPanel notePanel) {
		this.notePanel = notePanel;
	}



	public JButton getBtnDelNote() {
		return btnDelNote;
	}



	public void setBtnDelNote(JButton btnDelNote) {
		this.btnDelNote = btnDelNote;
	}

}