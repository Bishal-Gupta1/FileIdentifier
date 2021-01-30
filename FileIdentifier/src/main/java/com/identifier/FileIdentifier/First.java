package com.identifier.FileIdentifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class First extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public First() {
		initComponents();
	}

	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField2 = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		canvas1 = new java.awt.Canvas();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextField1.setFont(new java.awt.Font("Clarendon BT", 0, 14));
		jTextField1.setForeground(new java.awt.Color(153, 153, 153));
		jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		jTextField1.setText(" Enter Extension (For eg:  pdf)");
		jTextField1.setBorder(null);

		jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextField1FocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jTextField1FocusLost(evt);
			}
		});
		getContentPane().add(jTextField1);
		jTextField1.setBounds(10, 130, 330, 30);
		getContentPane().add(canvas1);
		canvas1.setBounds(380, 70, 0, 0);

		jButton1.setForeground(new java.awt.Color(51, 51, 255));
		jButton1.setText("Search");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setForeground(new java.awt.Color(51, 51, 255));
		jButton2.setText("Upload file");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Submit");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jTextField2))
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(153, 153, 153)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
														.addComponent(jButton3))
												.addComponent(jButton2)))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(150, 150, 150).addComponent(
										jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(57, 57, 57).addComponent(
										jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 267,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(jPanel1Layout
						.createSequentialGroup().addGap(23, 23, 23).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addGap(31, 31, 31)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jButton1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(12, 12, 12).addComponent(jButton2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton3)
						.addGap(32, 32, 32)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
		if (jTextField1.getText().equals(" Enter Extension (For eg:  pdf)")) {
			jTextField1.setText("");
		}
	}

	private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {
		if (jTextField1.getText().equals("")) {
			jTextField1.setText(" Enter Extension (For eg:  pdf)");
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String inputExtension = jTextField1.getText();
			if (inputExtension == null || inputExtension == "") {
				JOptionPane.showMessageDialog(null, "Enter Valid Input");
			}
			if (inputExtension.charAt(0) == '.')
				inputExtension = inputExtension.substring(1);
			Second frame2 = new Second(inputExtension);
			frame2.setVisible(true);
			frame2.pack();
			jTextField1.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		int i = fc.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			try {
				jTextField2.setText(f.getAbsolutePath());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		BufferedReader br = null;
		try {
			String input = jTextField2.getText();
			if (input == null || input.length() == 0) {
				JOptionPane.showMessageDialog(null, "Enter Valid Input");
				return;
			}
			File f1 = new File(input);
			br = new BufferedReader(new FileReader(f1));

			ArrayList<String> items = new ArrayList<>();
			String line;
			line = br.readLine();
			while (line != null) {
				if (line.charAt(0) == '.') {
					line = line.substring(1);
				}
				items.add(line);
				line = br.readLine();
			}
			Second frame3 = new Second();
			frame3.setVisible(true);
			frame3.pack();
			jTextField1.setText("");
			jTextField2.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new First().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField jTextField2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private java.awt.Canvas canvas1;
	// End of variables declaration//GEN-END:variables
}
