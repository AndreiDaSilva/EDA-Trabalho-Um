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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tf_Calculo;
	private JRadioButton rdbtnDinamica;
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
		
		tf_Calculo = new JTextField();
		tf_Calculo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char entrada = e.getKeyChar();
				if(!Calculadora.isDigitoValido(entrada)) {
					e.consume();
				}
			}
		});
		tf_Calculo.setBounds(147, 19, 277, 20);
		frame.getContentPane().add(tf_Calculo);
		tf_Calculo.setColumns(10);
		
		rdbtnDinamica = new JRadioButton("Din\u00E2mica");
		rdbtnDinamica.setSelected(true);
		rdbtnDinamica.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				if(rdbtnDinamica.isSelected()) {
					rdbtnVetor.setSelected(false);
				} else {
					rdbtnVetor.setSelected(true);
				}
			}
		});
		rdbtnDinamica.setBounds(255, 46, 89, 23);
		frame.getContentPane().add(rdbtnDinamica);
		
		rdbtnVetor = new JRadioButton("Vetor");
		rdbtnVetor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				if(rdbtnVetor.isSelected()) {
					rdbtnDinamica.setSelected(false);
				} else {
					rdbtnDinamica.setSelected(true);
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
			public void actionPerformed(ActionEvent ae) {
				try {					
					Calculadora cVetor = new Calculadora(rdbtnDinamica.isSelected(), tf_Calculo.getText().length());
					cVetor.validar(tf_Calculo.getText());
					float resultado = cVetor.calcular(tf_Calculo.getText());
					textPane.setText(String.valueOf(resultado));
				} catch (Exception exeception) {
					textPane.setText(exeception.getMessage());
				}
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
