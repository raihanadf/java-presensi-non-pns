package com.presensikeun.form.admin;

import com.presensikeun.controller.DataReport;
import com.presensikeun.controller.Koneksi;
import com.presensikeun.controller.ReportCSV;
import com.presensikeun.model.WhatOS;
import com.presensikeun.model.WindowButton;
import com.presensikeun.swing.Notification;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class Report extends javax.swing.JPanel {

	WindowButton w = new WindowButton();

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public Report() {
		this.con = Koneksi.getKoneksi();
		initComponents();

		// initialize
		showWinButton();
		table1.scroll(jScrollPane1);
		DataReport.setTable(table1);
		tableReport(null, null, null);

		// get
		DataReport.getNIK(nik);
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

	public void tableReport(String dari, String sampai, String nik) {

		// filter cuy
		if (dari != null && sampai != null && nik.equals("Semua")) {
			DataReport.addTableQuery(" where p.tanggal between '" + dari + "' and DATE_ADD('" + sampai + "', INTERVAL 1 DAY)");
		} else if (dari != null && sampai != null && nik != null) {
			DataReport.addTableQuery(" where p.tanggal between '" + dari + "' and DATE_ADD('" + sampai + "', INTERVAL 1 DAY) and k.nik = '" + nik + "'");
		}

		DataReport.getTable(dari, sampai, nik);
		DataReport.resetQuery();
	}

	private void notify(String version, String msg) {
		Notification panel;
		switch (version) {
			case "success":
				panel = new Notification((Frame) SwingUtilities.getWindowAncestor(this), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, msg);
				break;
			case "warning":
				panel = new Notification((Frame) SwingUtilities.getWindowAncestor(this), Notification.Type.WARNING, Notification.Location.TOP_CENTER, msg);
				break;
			case "info":
				panel = new Notification((Frame) SwingUtilities.getWindowAncestor(this), Notification.Type.INFO, Notification.Location.TOP_CENTER, msg);
				break;
			default:
				panel = new Notification((Frame) SwingUtilities.getWindowAncestor(this), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Maksud?");
				break;
		}
		panel.showNotification();
	}

	private void getInfo(String type) {
		String sql = null;
		try {
			switch (type) {
				case "karyawan":
					if (!nik.getSelectedItem().equals("Semua")) {
						sql = "select k.nama, j.nama from tb_karyawan as k join tb_jabatan as j on k.id_jabatan = j.id where k.nik = " + nik.getSelectedItem();
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						if (rs.next()) {
							notify("info", rs.getString(1) + ": " + rs.getString(2));
						}
					}
					break;
				default:
					break;
			}
		} catch (NullPointerException | SQLException ex) {
			notify("info", "Mohon isi NIK terlebih dahulu.");
		}

	}

	private void reset() {
		dateChooser.toDay();
		dateChooser1.toDay();
	}

	private boolean compareDate() {
		boolean isAfter = false;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = format.parse(dari.getText());
			Date date2 = format.parse(sampai.getText());

			// ngereturn boolean kalo date1 itu sama apa ngga sama date2 atau lebih dari
			isAfter = date1.equals(date2) || date1.after(date2);

		} catch (ParseException ex) {

		}
		return isAfter;
	}

	private void verifyFields(String type) {
		if (nik.getSelectedIndex() == -1) {
			notify("warning", "Mohon isi NIK");
		} else if (dari.getText().length() == 0 || sampai.getText().length() == 0) {
			notify("warning", "Mohon isi rentang jadwal terlebih dahulu");
		} else if (compareDate()) {
			notify("warning", "Tanggal lebih atau sama");
		} else {
			switch (type) {
				case "filtered":
					getPDF("filtered");
					break;
				case "preview":
					tableReport(dari.getText(), sampai.getText(), (String) nik.getSelectedItem());
					notify("success", "Data tabel telah difilter!");
					break;
			}
		}

	}

	private void getPDF(String type) {
		try {
			switch (type) {
				case "filtered":
					ReportCSV.getPDF("filtered", dari.getText(), sampai.getText(), (String) nik.getSelectedItem());
					break;
				case "all":
					ReportCSV.getPDF("all", null, null, null);
					break;
				default:
					break;
			}
			notify("success", "Tersimpan!");
		} catch (Exception ex) {
			notify("warning", "Gagal Menyimpan");
		}
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                dateChooser = new com.presensikeun.swing.datechooser.DateChooser();
                dateChooser1 = new com.presensikeun.swing.datechooser.DateChooser();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                max = new javax.swing.JLabel();
                min = new javax.swing.JLabel();
                panelShadow1 = new com.presensikeun.swing.PanelShadow();
                button2 = new com.presensikeun.swing.Button();
                jLabel3 = new javax.swing.JLabel();
                labelTable1 = new javax.swing.JLabel();
                dari = new com.presensikeun.swing.TextField();
                sampai = new com.presensikeun.swing.TextField();
                getDari = new com.presensikeun.swing.Button();
                getSampai = new com.presensikeun.swing.Button();
                nik = new com.presensikeun.swing.Combobox();
                filter = new com.presensikeun.swing.Button();
                jLabel2 = new javax.swing.JLabel();
                panelShadow2 = new com.presensikeun.swing.PanelShadow();
                jScrollPane1 = new javax.swing.JScrollPane();
                table1 = new com.presensikeun.swing.Table();
                labelTable = new javax.swing.JLabel();

                dateChooser.setForeground(new java.awt.Color(85, 65, 118));
                dateChooser.setDateFormat("yyyy-MM-dd");
                dateChooser.setTextRefernce(dari);

                dateChooser1.setForeground(new java.awt.Color(85, 65, 118));
                dateChooser1.setDateFormat("yyyy-MM-dd");
                dateChooser1.setTextRefernce(sampai);

                setBackground(new java.awt.Color(250, 250, 250));

                jPanel1.setBackground(new java.awt.Color(85, 65, 118));
                jPanel1.setMinimumSize(new java.awt.Dimension(100, 90));
                jPanel1.setPreferredSize(new java.awt.Dimension(173, 100));

                jLabel1.setBackground(new java.awt.Color(240, 236, 227));
                jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(240, 236, 227));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icons/icons8-presentation-36.png"))); // NOI18N
                jLabel1.setText("Report");
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

                max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icon/windows-button/icons8-maximized-18.png"))); // NOI18N
                max.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                maxMouseClicked(evt);
                        }
                });

                min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icon/windows-button/icons8-minus-18.png"))); // NOI18N
                min.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                minMouseClicked(evt);
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

                panelShadow1.setBackground(new java.awt.Color(252, 254, 255));

                button2.setBackground(new java.awt.Color(51, 153, 0));
                button2.setForeground(new java.awt.Color(255, 255, 255));
                button2.setText("Export All");
                button2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                button2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                button2ActionPerformed(evt);
                        }
                });

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icon/icons8-reset-24.png"))); // NOI18N
                jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabel3MouseClicked(evt);
                        }
                });

                labelTable1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
                labelTable1.setForeground(new java.awt.Color(85, 65, 118));
                labelTable1.setText("Filter:");

                dari.setEditable(false);
                dari.setBackground(new java.awt.Color(252, 254, 255));
                dari.setForeground(new java.awt.Color(85, 65, 118));
                dari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                dari.setToolTipText("");
                dari.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                dari.setLabelText("Dari");
                dari.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                dariMouseClicked(evt);
                        }
                });
                dari.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                dariKeyReleased(evt);
                        }
                });

                sampai.setEditable(false);
                sampai.setBackground(new java.awt.Color(252, 254, 255));
                sampai.setForeground(new java.awt.Color(85, 65, 118));
                sampai.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                sampai.setToolTipText("");
                sampai.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                sampai.setLabelText("Sampai");
                sampai.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                sampaiMouseClicked(evt);
                        }
                });
                sampai.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                sampaiKeyReleased(evt);
                        }
                });

                getDari.setBackground(new java.awt.Color(85, 65, 118));
                getDari.setForeground(new java.awt.Color(255, 255, 255));
                getDari.setText("D");
                getDari.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                getDari.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                getDariActionPerformed(evt);
                        }
                });

                getSampai.setBackground(new java.awt.Color(85, 65, 118));
                getSampai.setForeground(new java.awt.Color(255, 255, 255));
                getSampai.setText("D");
                getSampai.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                getSampai.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                getSampaiActionPerformed(evt);
                        }
                });

                nik.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                nik.setLabeText("NIK");
                nik.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
                        public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                        }
                        public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                                nikPopupMenuWillBecomeInvisible(evt);
                        }
                        public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                        }
                });
                nik.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nikActionPerformed(evt);
                        }
                });

                filter.setBackground(new java.awt.Color(102, 102, 0));
                filter.setForeground(new java.awt.Color(255, 255, 255));
                filter.setText("Export Filtered");
                filter.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
                filter.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                filterActionPerformed(evt);
                        }
                });

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/presensikeun/images/icon/icons8-search-24.png"))); // NOI18N
                jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabel2MouseClicked(evt);
                        }
                });

                javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
                panelShadow1.setLayout(panelShadow1Layout);
                panelShadow1Layout.setHorizontalGroup(
                        panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTable1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dari, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getDari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sampai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nik, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                panelShadow1Layout.setVerticalGroup(
                        panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sampai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(getDari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(getSampai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                );

                panelShadow2.setBackground(new java.awt.Color(252, 254, 255));

                jScrollPane1.setBackground(new java.awt.Color(252, 254, 255));
                jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

                table1.setBackground(new java.awt.Color(252, 254, 255));
                table1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                table1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
                table1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                table1MousePressed(evt);
                        }
                });
                jScrollPane1.setViewportView(table1);

                labelTable.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
                labelTable.setForeground(new java.awt.Color(85, 65, 118));
                labelTable.setText("Rekapan Absen");

                javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
                panelShadow2.setLayout(panelShadow2Layout);
                panelShadow2Layout.setHorizontalGroup(
                        panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(panelShadow2Layout.createSequentialGroup()
                                                .addComponent(labelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                panelShadow2Layout.setVerticalGroup(
                        panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                                .addComponent(labelTable)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
        }// </editor-fold>//GEN-END:initComponents

        private void table1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MousePressed
		// TODO add your handling code here:
        }//GEN-LAST:event_table1MousePressed

        private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
		// TODO add your handling code here:
		getPDF("all");
        }//GEN-LAST:event_button2ActionPerformed

        private void maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseClicked
		// TODO add your handling code here:
		w.setWindow("max", (JFrame) SwingUtilities.getWindowAncestor(this), max);
        }//GEN-LAST:event_maxMouseClicked

        private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
		// TODO add your handling code here:
		w.setWindow("min", (JFrame) SwingUtilities.getWindowAncestor(this), null);
        }//GEN-LAST:event_minMouseClicked

        private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
		// TODO add your handling code here:
		reset();
        }//GEN-LAST:event_jLabel3MouseClicked

        private void dariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dariKeyReleased
		// TODO add your handling code here:
        }//GEN-LAST:event_dariKeyReleased

        private void sampaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sampaiKeyReleased
		// TODO add your handling code here:
        }//GEN-LAST:event_sampaiKeyReleased

        private void nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nikActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_nikActionPerformed

        private void nikPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nikPopupMenuWillBecomeInvisible
		// TODO add your handling code here:
		getInfo("karyawan");
        }//GEN-LAST:event_nikPopupMenuWillBecomeInvisible

        private void dariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dariMouseClicked
		// TODO add your handling code here:
		getDari.doClick();
        }//GEN-LAST:event_dariMouseClicked

        private void getDariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getDariActionPerformed
		// TODO add your handling code here:
		dateChooser.showPopup();
        }//GEN-LAST:event_getDariActionPerformed

        private void sampaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sampaiMouseClicked
		// TODO add your handling code here:
		getSampai.doClick();
        }//GEN-LAST:event_sampaiMouseClicked

        private void getSampaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSampaiActionPerformed
		// TODO add your handling code here:
		dateChooser1.showPopup();
        }//GEN-LAST:event_getSampaiActionPerformed

        private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
		// TODO add your handling code here:
		verifyFields("filtered");
        }//GEN-LAST:event_filterActionPerformed

        private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
		// TODO add your handling code here:
		verifyFields("preview");
        }//GEN-LAST:event_jLabel2MouseClicked

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private com.presensikeun.swing.Button button2;
        private com.presensikeun.swing.TextField dari;
        private com.presensikeun.swing.datechooser.DateChooser dateChooser;
        private com.presensikeun.swing.datechooser.DateChooser dateChooser1;
        private com.presensikeun.swing.Button filter;
        private com.presensikeun.swing.Button getDari;
        private com.presensikeun.swing.Button getSampai;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel labelTable;
        private javax.swing.JLabel labelTable1;
        private javax.swing.JLabel max;
        private javax.swing.JLabel min;
        private com.presensikeun.swing.Combobox nik;
        private com.presensikeun.swing.PanelShadow panelShadow1;
        private com.presensikeun.swing.PanelShadow panelShadow2;
        private com.presensikeun.swing.TextField sampai;
        private com.presensikeun.swing.Table table1;
        // End of variables declaration//GEN-END:variables
}
