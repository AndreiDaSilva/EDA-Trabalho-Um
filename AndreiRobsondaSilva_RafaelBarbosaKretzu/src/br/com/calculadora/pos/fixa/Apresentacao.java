package br.com.calculadora.pos.fixa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnVetor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Digite seu calculo aqui:");
		lblNewLabel_1.setBounds(10, 22, 138, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(147, 19, 277, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Din\u00E2mica");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnVetor.setSelected(false);
				} else {
					rdbtnVetor.setSelected(true);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(255, 46, 89, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnVetor = new JRadioButton("Vetor");
		rdbtnVetor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnVetor.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
				} else {
					rdbtnNewRadioButton.setSelected(true);
				}
			}
		});
		rdbtnVetor.setBounds(348, 46, 76, 23);
		frame.getContentPane().add(rdbtnVetor);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 70, 414, 146);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// verificar se o numero de operandos - 1 � == que o numero de operadores
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
