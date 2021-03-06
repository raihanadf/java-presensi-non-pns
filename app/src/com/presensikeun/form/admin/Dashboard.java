package com.presensikeun.form.admin;

import com.presensikeun.chart.ModelChart;
import com.presensikeun.chart.ModelPieChart;
import com.presensikeun.chart.PieChart;
import com.presensikeun.controller.DataDashboard;
import com.presensikeun.controller.Koneksi;
import com.presensikeun.model.ModelCard;
import com.presensikeun.model.WhatOS;
import com.presensikeun.model.WindowButton;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class Dashboard extends javax.swing.JPanel {

	WindowButton w = new WindowButton();
	JFrame f3 = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public Dashboard() {
		this.con = Koneksi.getKoneksi();
		initComponents();

		showWinButton();
		setData();
	}

	private void showWinButton() {
		if (WhatOS.isWindows()) {
			min.setVisible(true);
			max.setVisible(true);
		} else {
			// i use arch btw + wm hahahahahahahahhahahahahha
			min.setVisible(false);
			max.setVisible(false);
		}
	}

	public void setData() {
		// card
		card1.setData(new ModelCard(new ImageIcon(getClass().getResource("/com/presensikeun/images/icon/presensi.png")), "Total Presensi", DataDashboard.getTotalPresensi()));
		card2.setData(new ModelCard(new ImageIcon(getClass().getResource("/com/presensikeun/images/icon/karyawan.png")), "Karyawan", DataDashboard.getUser("user")));
		card3.setData(new ModelCard(new ImageIcon(getClass().getResource("/com/presensikeun/images/icon/admin.png")), "Admin", DataDashboard.getUser("admin")));
		// diagram chart 
		chart.addLegend("Minggu 1", new Color(245, 189, 135));
		chart.addLegend("Minggu 2", new Color(135, 189, 245));
		chart.addLegend("Minggu 3", new Color(189, 135, 245));
		chart.addLegend("Minggu 4", new Color(245, 135, 189));

		// ^ data
		chart.addData(new ModelChart("Jan", new double[]{DataDashboard.getWeekly(1, 1), DataDashboard.getWeekly(1, 2), DataDashboard.getWeekly(1, 3), DataDashboard.getWeekly(1, 4)}));
		chart.addData(new ModelChart("Feb", new double[]{DataDashboard.getWeekly(2, 1), DataDashboard.getWeekly(2, 2), DataDashboard.getWeekly(2, 3), DataDashboard.getWeekly(2, 4)}));
		chart.addData(new ModelChart("Mar", new double[]{DataDashboard.getWeekly(3, 1), DataDashboard.getWeekly(3, 2), DataDashboard.getWeekly(3, 3), DataDashboard.getWeekly(3, 4)}));
		chart.addData(new ModelChart("Apr", new double[]{DataDashboard.getWeekly(4, 1), DataDashboard.getWeekly(4, 2), DataDashboard.getWeekly(4, 3), DataDashboard.getWeekly(4, 4)}));
		chart.addData(new ModelChart("Mei", new double[]{DataDashboard.getWeekly(5, 1), DataDashboard.getWeekly(5, 2), DataDashboard.getWeekly(5, 3), DataDashboard.getWeekly(5, 4)}));
		chart.addData(new ModelChart("Juni", new double[]{DataDashboard.getWeekly(6, 1), DataDashboard.getWeekly(6, 2), DataDashboard.getWeekly(6, 3), DataDashboard.getWeekly(6, 4)}));
		chart.addData(new ModelChart("Juli", new double[]{DataDashboard.getWeekly(7, 1), DataDashboard.getWeekly(7, 2), DataDashboard.getWeekly(7, 3), DataDashboard.getWeekly(7, 4)}));
		chart.addData(new ModelChart("Agu", new double[]{DataDashboard.getWeekly(8, 1), DataDashboard.getWeekly(8, 2), DataDashboard.getWeekly(8, 3), DataDashboard.getWeekly(8, 4)}));
		chart.addData(new ModelChart("Sep", new double[]{DataDashboard.getWeekly(9, 1), DataDashboard.getWeekly(9, 2), DataDashboard.getWeekly(9, 3), DataDashboard.getWeekly(9, 4)}));
		chart.addData(new ModelChart("Okt", new double[]{DataDashboard.getWeekly(10, 1), DataDashboard.getWeekly(10, 2), DataDashboard.getWeekly(10, 3), DataDashboard.getWeekly(10, 4)}));
		chart.addData(new ModelChart("Nov", new double[]{DataDashboard.getWeekly(11, 1), DataDashboard.getWeekly(11, 2), DataDashboard.getWeekly(11, 3), DataDashboard.getWeekly(11, 4)}));
		chart.addData(new ModelChart("Des", new double[]{DataDashboard.getWeekly(12, 1), DataDashboard.getWeekly(12, 2), DataDashboard.getWeekly(12, 3), DataDashboard.getWeekly(12, 4)}));

		// pie chart
		// telat hadir sakit izin alpa
		pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
		pieChart1.addData(new ModelPieChart("Jan - Mar", DataDashboard.getMonth("1", "3"), new Color(227, 148, 0)));
		pieChart1.addData(new ModelPieChart("Apr - Jun", DataDashboard.getMonth("4", "6"), new Color(92, 204, 150)));
		pieChart1.addData(new ModelPieChart("Jul - Sept", DataDashboard.getMonth("7", "9"), new Color(179, 161, 230)));
		pieChart1.addData(new ModelPieChart("Okt - Des", DataDashboard.getMonth("10", "12"), new Color(0, 163, 204)));
	}

//	public void get 
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                min = new javax.swing.JLabel();
                max = new javax.swing.JLabel();
                card1 = new com.presensikeun.component.Card();
                card2 = new com.presensikeun.component.Card();
                card3 = new com.presensikeun.component.Card();
                panelShadow1 = new com.presensikeun.swing.PanelShadow();
                chart = new com.presensikeun.chart.Chart();
                jLabel3 = new javax.swing.JLabel();
                panelShadow2 = new com.presensikeun.swing.PanelShadow();
                jLabel2 = new javax.swing.JLabel();
                pieChart1 = new com.presensikeun.chart.PieChart();

                setBackground(new java.awt.Color(250, 250, 250));

                jPanel1.setBackground(new java.awt.Color(85, 65, 118));
                jPanel1.setMinimumSize(new java.awt.Dimension(100, 90));
                jPanel1.setPreferredSize(new java.awt.Dimension(173, 100));

                jLabel1.setBackground(new java.awt.Color(240, 236, 227));
                jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(240, 236, 227));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icons/icons8-home-36.png"))); // NOI18N
                jLabel1.setText("Dashboard");
                jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 8, Short.MAX_VALUE)
                );

                min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icon/windows-button/icons8-minus-18.png"))); // NOI18N
                min.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                minMouseClicked(evt);
                        }
                });

                max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icon/windows-button/icons8-maximized-18.png"))); // NOI18N
                max.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                maxMouseClicked(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(22, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                );

                card1.setBackground(new java.awt.Color(252, 254, 255));
                card1.setForeground(new java.awt.Color(85, 65, 118));

                card2.setBackground(new java.awt.Color(252, 254, 255));
                card2.setForeground(new java.awt.Color(85, 65, 118));

                card3.setBackground(new java.awt.Color(252, 254, 255));
                card3.setForeground(new java.awt.Color(85, 65, 118));

                panelShadow1.setBackground(new java.awt.Color(252, 254, 255));

                chart.setOpaque(false);

                jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(85, 65, 118));
                jLabel3.setText("Diagram Batang");

                javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
                panelShadow1.setLayout(panelShadow1Layout);
                panelShadow1Layout.setHorizontalGroup(
                        panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                );
                panelShadow1Layout.setVerticalGroup(
                        panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addContainerGap())
                );

                panelShadow2.setBackground(new java.awt.Color(252, 254, 255));

                jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(85, 65, 118));
                jLabel2.setText("Pie Chart");

                pieChart1.setForeground(new java.awt.Color(85, 65, 118));
                pieChart1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

                javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
                panelShadow2.setLayout(panelShadow2Layout);
                panelShadow2Layout.setHorizontalGroup(
                        panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                        .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                panelShadow2Layout.setVerticalGroup(
                        panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
        }// </editor-fold>//GEN-END:initComponents

        private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
		// TODO add your handling code here:
		w.setWindow("min", (JFrame) SwingUtilities.getWindowAncestor(this), null);
        }//GEN-LAST:event_minMouseClicked

        private void maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseClicked
		// TODO add your handling code here:
		w.setWindow("max", (JFrame) SwingUtilities.getWindowAncestor(this), max);
        }//GEN-LAST:event_maxMouseClicked

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private com.presensikeun.component.Card card1;
        private com.presensikeun.component.Card card2;
        private com.presensikeun.component.Card card3;
        private com.presensikeun.chart.Chart chart;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JLabel max;
        private javax.swing.JLabel min;
        private com.presensikeun.swing.PanelShadow panelShadow1;
        private com.presensikeun.swing.PanelShadow panelShadow2;
        private com.presensikeun.chart.PieChart pieChart1;
        // End of variables declaration//GEN-END:variables
}
