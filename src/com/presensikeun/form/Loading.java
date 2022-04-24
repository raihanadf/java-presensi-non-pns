package com.presensikeun.form;

import javax.swing.JOptionPane;

public class Loading extends javax.swing.JFrame {

	public Loading() {
		initComponents();

	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                loading_label = new javax.swing.JLabel();
                loading_value = new javax.swing.JLabel();
                loading_bar = new javax.swing.JProgressBar();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/login/7.PNG"))); // NOI18N

                loading_label.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
                loading_label.setText("Loading ...");

                loading_value.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
                loading_value.setText("0 %");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(loading_label, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(173, 173, 173)
                                                .addComponent(loading_value, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(loading_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(loading_label)
                                        .addComponent(loading_value))
                                .addGap(5, 5, 5)
                                .addComponent(loading_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		Loading apes = new Loading();
		apes.setVisible(true);

		try {

			for (int i = 0; i <= 100; i++) {
				Thread.sleep(3);
				apes.loading_value.setText(i + "%");

				if (i == 10) {
					apes.loading_label.setText("Memuat Component...");
				}
				if (i == 20) {
					apes.loading_label.setText("Membuat Tampilan...");
				}
				if (i == 50) {
					apes.loading_label.setText("Memuat Component Berhasil");
				}
				if (i == 70) {
					apes.loading_label.setText("Memuat Tampilan Berhasil");
				}
				if (i == 80) {
					apes.loading_label.setText("Memuat Aplikasi Berhasil");
				}
				if (i == 100) {
					new Auth().setVisible(true);
					apes.setVisible(false);
				}
				apes.loading_bar.setValue(i);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JProgressBar loading_bar;
        private javax.swing.JLabel loading_label;
        private javax.swing.JLabel loading_value;
        // End of variables declaration//GEN-END:variables

}
