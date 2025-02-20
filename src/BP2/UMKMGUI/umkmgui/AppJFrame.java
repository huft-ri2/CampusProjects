package umkmgui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

/**
 *
 * @author NUZUL CHOIRI
 */
public class AppJFrame extends javax.swing.JFrame {
	
	static LoginJFrame log = new LoginJFrame();

	cPembeliBiasa pb = new cPembeliBiasa();
	cPembeliVIP pv = new cPembeliVIP();
	cTransaksi tr = new cTransaksi();
	cMenuGerobakA m[];
	cMenuGerobakB m1[];
	cPembeliBiasa pbb[]; 
	cPembeliVIP pbv[];
	cTransaksi tra[];
	cTransaksi dt[];//data riwayat transaksi
	int jmn, jmn1, jm, jpb, jpb1, jtr, jdt, jt; //indeks array
	int mmn, mmn1, mpb, mpb1, mtr, mdt; //nilai maksimal array
	int x, y;//indeks yang dicari di tab transaksi
	int jmlhItem, jmlhHg, biayaAkh, tempOutcome;
	int ma1, ma2, ma3, ma4, ma5, ma6, ma7, ma8, ma9, ma10;
	int mb1, mb2, mb3, mb4, mb5, mb6, mb7, mb8, mb9, mb10;
	String alm = "-", jns = "Pelanggan umum", tempNama;
	boolean sign/*tanda golongan menu yang dicari di tab transaksi*/, terdaftar;
	
	/**
	 * Creates new form AppJFrame
	 */
	public AppJFrame() {
		m = new cMenuGerobakA[10];
		m1 = new cMenuGerobakB[10];
		pbb = new cPembeliBiasa[20];
		pbv = new cPembeliVIP[20];
		tra = new cTransaksi[10];
		dt = new cTransaksi[1000];
		jmn=jmn1=jm=jpb=jpb1=jtr=jdt=jt=0;
		mmn=10;mmn1=10; mpb=20; mpb1=20; mtr=10; mdt=1000;
		
		m[0] = new cMenuGerobakA("Pangsit Basah",15000,"KA1",0);
		m[1] = new cMenuGerobakA("Pangsit Goreng",15000,"KA2",0);
		m[2] = new cMenuGerobakA("Bakso Goreng Mekar",10000,"KA3",0);
		m[3] = new cMenuGerobakA("Gohyoung Ayam",20000,"KA4",0);
		
		m1[0] = new cMenuGerobakB("Baby Crab",10000,"KB1",0);
		m1[1] = new cMenuGerobakB("Jamur Crispy",10000,"KB2",0);
		m1[2] = new cMenuGerobakB("Usus Crispy",10000,"KB3",0);
		m1[3] = new cMenuGerobakB("Kentang Crispy",10000,"KB4",0);
		m1[4] = new cMenuGerobakB("Tahu Crispy",10000,"KB5",0);
		
		pbb[0] = new cPembeliBiasa("0001","Firman","Ketintang");
		pbb[1] = new cPembeliBiasa("0002","Vano","Buduran");
		pbb[2] = new cPembeliBiasa("0003","Abdul","Krian");
		
		pbv[0] = new cPembeliVIP("0004","Dimbud","Waru");
		pbv[1] = new cPembeliVIP("0005","Hanif","Surabaya");
		pbv[2] = new cPembeliVIP("0006","Umar","Gedangan");
		
		readIndexRT();
		initComponents();
		
		for (int i = 0;i < 4;i++) {
			String row[][] = new String[1][4];
			row[0][0] = String.valueOf(jmn + 1);
			row[0][1] = m[i].getNama();
			row[0][2] = String.valueOf(m[i].getHarga());
			row[0][3] = m[i].getKode();
			DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel();
			model1.addRow(row[0]);
			DefaultTableModel model3 = (DefaultTableModel)jTable3.getModel();
			model3.addRow(row[0]);
			jmn++;
			jm++;
		}
		
		for (int i = 0;i < 5;i++) {
			String row[][] = new String[1][4];
			row[0][0] = String.valueOf(jmn1 + 1);
			row[0][1] = m1[i].getNama();
			row[0][2] = String.valueOf(m1[i].getHarga());
			row[0][3] = m1[i].getKode();
			DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
			model2.addRow(row[0]);
			DefaultTableModel model4 = (DefaultTableModel)jTable4.getModel();
			model4.addRow(row[0]);
			jmn1++;
			jm++;
		}
		
		for (int i = 0;i < 3;i++) {
			String row[][] = new String[1][4];
			row[0][0] = String.valueOf(jpb + 1);
			row[0][1] = pbb[i].getID();
			row[0][2] = pbb[i].getNama();
			row[0][3] = pbb[i].getAlamat();
			DefaultTableModel model = (DefaultTableModel)jTPbbiasa.getModel();
			model.addRow(row[0]);
			jpb++;
		}
		
		for (int i = 0;i < 3;i++) {
			String row[][] = new String[1][4];
			row[0][0] = String.valueOf(jpb1 + 1);
			row[0][1] = pbv[i].getID();
			row[0][2] = pbv[i].getNama();
			row[0][3] = pbv[i].getAlamat();
			DefaultTableModel model = (DefaultTableModel)jTPbVIP.getModel();
			model.addRow(row[0]);
			jpb1++;
		}
		
		//Tab_Menu
		jTFMnUbahNm.setEnabled(false);
		jTFMnUbahHg.setEnabled(false);
		jBtnMnUbh.setEnabled(false);
		jBtnMnHps.setEnabled(false);
		
		//Tab_Pembeli
		jTFPbUbahNm.setEnabled(false); jTFPbUbahNm1.setEnabled(false);
		jTFPbUbahAlm.setEnabled(false); jTFPbUbahAlm1.setEnabled(false);
		jBtnPbUbah.setEnabled(false); jBtnPbUbah1.setEnabled(false);
		jCBPbUbahJns.setEnabled(false); jCBPbUbahJns1.setEnabled(false);
		jBtnPbHps.setEnabled(false); jBtnPbHps1.setEnabled(false);
		
		//Tab_Transaksi
		jTFTrTmbhCrKd.setEnabled(false);
		jBtnTrTmbhCrKd.setEnabled(false);
		jBtnTrTmbh.setEnabled(false); jSpinner1.setEnabled(false);
		jBtnTrUbah.setEnabled(false); jSpinner2.setEnabled(false);
		jBtnTrHps.setEnabled(false);
		jBtnCetak.setEnabled(false);
		jBtnCatatNominal.setEnabled(false);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFMnTmbhNm = new javax.swing.JTextField();
        jTFMnTmbhHg = new javax.swing.JTextField();
        jBtnMnTmbh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jBtnMnTmbh1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTFMnUbahNm = new javax.swing.JTextField();
        jTFMnUbahHg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBtnMnUbh = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jTFMnUbahCr = new javax.swing.JTextField();
        jBtnMnUbahCr = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTFMnHpsCr = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabelNmHpsDk = new javax.swing.JLabel();
        jBtnMnHps = new javax.swing.JButton();
        jLabelNmHpsHg = new javax.swing.JLabel();
        jLabelNmHpsNm = new javax.swing.JLabel();
        jBtnMnHpsCr = new javax.swing.JButton();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFPbTmbhID = new javax.swing.JTextField();
        jTFPbTmbhNm = new javax.swing.JTextField();
        jTFPbTmbhAlm = new javax.swing.JTextField();
        jBtnPbTmbh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTFPbUbahNm = new javax.swing.JTextField();
        jTFPbUbahAlm = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jBtnPbUbah = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jBtnPbUbahCr = new javax.swing.JButton();
        jTFPbUbahCr = new javax.swing.JTextField();
        jCBPbUbahJns = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jBtnPbHpsCr = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jTFPbHpsCr = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabelPbHpsAlm = new javax.swing.JLabel();
        jLabelPbHpsNm = new javax.swing.JLabel();
        jLabelPbHpsID = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabelPbHpsJns = new javax.swing.JLabel();
        jBtnPbHps = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTPbbiasa = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTFPbTmbhID1 = new javax.swing.JTextField();
        jTFPbTmbhNm1 = new javax.swing.JTextField();
        jTFPbTmbhAlm1 = new javax.swing.JTextField();
        jBtnPbTmbh1 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTFPbUbahNm1 = new javax.swing.JTextField();
        jTFPbUbahAlm1 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jBtnPbUbah1 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jBtnPbUbahCr1 = new javax.swing.JButton();
        jTFPbUbahCr1 = new javax.swing.JTextField();
        jCBPbUbahJns1 = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jBtnPbHpsCr1 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jTFPbHpsCr1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabelPbHpsAlm1 = new javax.swing.JLabel();
        jLabelPbHpsNm1 = new javax.swing.JLabel();
        jLabelPbHpsID1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabelPbHpsJns1 = new javax.swing.JLabel();
        jBtnPbHps1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTPbVIP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTTr1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel24 = new javax.swing.JPanel();
        jLabelTrTmbhTot = new javax.swing.JLabel();
        jBtnTrTmbhCrKd = new javax.swing.JButton();
        jTFTrTmbhCrKd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtnTrTmbhCrID = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTFTrTmbhCrID = new javax.swing.JTextField();
        jTFTrTmbhNm = new javax.swing.JTextField();
        jBtnTrTmbh = new javax.swing.JButton();
        jBtnCatat = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel39 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabelTrTmbhMn = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabelTrTmbhHg = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTTr2 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jBtnTrUbah = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabelTrUbahTot = new javax.swing.JLabel();
        jTFTrUbahMnCr = new javax.swing.JTextField();
        jBtnTrUbahCr = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabelTrUbahMn = new javax.swing.JLabel();
        jLabelTrUbahHg = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTTr3 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jBtnTrHps = new javax.swing.JButton();
        jTFTrHpsMnCr = new javax.swing.JTextField();
        jBtnTrHpsCr = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabelTrHps2 = new javax.swing.JLabel();
        jLabelTrHps1 = new javax.swing.JLabel();
        jLabelTrHps3 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jBtnCetak = new javax.swing.JButton();
        jBtnTulisStruk = new javax.swing.JButton();
        jBtnCatatNominal = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jTFNominal = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTTrRiwayat = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KING Cashier App");
        setResizable(false);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel1.setText("Nama:");

        jLabel2.setText("Harga:");

        jTFMnTmbhNm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFMnTmbhNmKeyTyped(evt);
            }
        });

        jTFMnTmbhHg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFMnTmbhHgKeyTyped(evt);
            }
        });

        jBtnMnTmbh.setText("Tambah Ke Gerobak A");
        jBtnMnTmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMnTmbhActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Tambahkan menu ke dalam daftar,");

        jBtnMnTmbh1.setText("Tambah Ke Gerobak B");
        jBtnMnTmbh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMnTmbh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jBtnMnTmbh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                            .addComponent(jBtnMnTmbh1))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTFMnTmbhHg, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                                .addComponent(jTFMnTmbhNm, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTFMnTmbhNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFMnTmbhHg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnMnTmbh)
                    .addComponent(jBtnMnTmbh1))
                .addGap(14, 14, 14))
        );

        jTabbedPane2.addTab("Tambah", jPanel4);

        jLabel10.setText("Harga:");

        jTFMnUbahNm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFMnUbahNmKeyTyped(evt);
            }
        });

        jTFMnUbahHg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFMnUbahHgKeyTyped(evt);
            }
        });

        jLabel12.setText("Nama:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Ubah menu di dalam daftar,");

        jBtnMnUbh.setText("Konfirmasi");
        jBtnMnUbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMnUbhActionPerformed(evt);
            }
        });

        jLabel31.setText("Cari Kode:");

        jTFMnUbahCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFMnUbahCrKeyTyped(evt);
            }
        });

        jBtnMnUbahCr.setText("Cari");
        jBtnMnUbahCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMnUbahCrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFMnUbahCr, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jBtnMnUbahCr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFMnUbahNm)
                            .addComponent(jTFMnUbahHg)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtnMnUbh)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel31)
                    .addComponent(jTFMnUbahCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTFMnUbahNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFMnUbahHg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnMnUbh)
                    .addComponent(jBtnMnUbahCr))
                .addGap(14, 14, 14))
        );

        jTabbedPane2.addTab("Ubah", jPanel5);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Hapus menu dari dalam daftar,");

        jLabel17.setText("Cari Kode:");

        jTFMnHpsCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFMnHpsCrKeyTyped(evt);
            }
        });

        jLabel29.setText("Menu berikut akan dihapus:");

        jLabel30.setText("Nama:");

        jLabel44.setText("Harga:");

        jLabel45.setText("Kode:");

        jLabelNmHpsDk.setText(" ");

        jBtnMnHps.setText("Konfirmasi");
        jBtnMnHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMnHpsActionPerformed(evt);
            }
        });

        jLabelNmHpsHg.setText(" ");

        jLabelNmHpsNm.setText(" ");

        jBtnMnHpsCr.setText("Cari");
        jBtnMnHpsCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMnHpsCrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jBtnMnHpsCr))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNmHpsDk, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jLabelNmHpsHg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNmHpsNm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jBtnMnHps))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jTFMnHpsCr, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTFMnHpsCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabelNmHpsNm))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNmHpsHg)
                    .addComponent(jLabel44))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnMnHps)
                            .addComponent(jBtnMnHpsCr)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jLabelNmHpsDk))))
                .addGap(21, 21, 21))
        );

        jTabbedPane2.addTab("Hapus", jPanel6);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama", "Harga", "Kode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(21);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane7.addTab("Gerobak A", jPanel20);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama", "Harga", "Kode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(21);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane7.addTab("Gerobak B", jPanel21);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", jPanel1);

        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel4.setText("ID:");

        jLabel5.setText("Nama:");

        jLabel6.setText("Alamat:");

        jTFPbTmbhID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPbTmbhIDKeyTyped(evt);
            }
        });

        jBtnPbTmbh.setText("Konfirmasi");
        jBtnPbTmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbTmbhActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Tambahkan pelanggan biasa ke dalam daftar,");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnPbTmbh)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFPbTmbhID, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFPbTmbhNm)
                                    .addComponent(jTFPbTmbhAlm, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPbTmbhID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPbTmbhNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFPbTmbhAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnPbTmbh)
                .addGap(14, 14, 14))
        );

        jTabbedPane3.addTab("Tambah", jPanel7);

        jLabel16.setText("Alamat:");

        jLabel18.setText("Jenis:");

        jLabel19.setText("Nama:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Edit pelanggan dalam daftar,");

        jBtnPbUbah.setText("Konfirmasi");
        jBtnPbUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbUbahActionPerformed(evt);
            }
        });

        jLabel32.setText("Cari ID:");

        jBtnPbUbahCr.setText("Cari");
        jBtnPbUbahCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbUbahCrActionPerformed(evt);
            }
        });

        jTFPbUbahCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPbUbahCrKeyTyped(evt);
            }
        });

        jCBPbUbahJns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biasa", "VIP" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtnPbUbahCr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnPbUbah))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPbUbahCr))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFPbUbahNm, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFPbUbahAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBPbUbahJns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel32))
                    .addComponent(jTFPbUbahCr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTFPbUbahNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPbUbahAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCBPbUbahJns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPbUbah)
                    .addComponent(jBtnPbUbahCr))
                .addGap(14, 14, 14))
        );

        jTabbedPane3.addTab("Ubah", jPanel8);

        jLabel47.setText("ID:");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setText("Hapus data pelanggan dari dalam daftar,");

        jBtnPbHpsCr.setText("Cari");
        jBtnPbHpsCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbHpsCrActionPerformed(evt);
            }
        });

        jLabel51.setText("Cari ID:");

        jTFPbHpsCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPbHpsCrKeyTyped(evt);
            }
        });

        jLabel52.setText("Data berikut akan dihapus:");

        jLabel48.setText("Nama:");

        jLabel49.setText("Alamat:");

        jLabelPbHpsAlm.setText(" ");

        jLabelPbHpsNm.setText(" ");

        jLabelPbHpsID.setText(" ");

        jLabel46.setText("Jenis:");

        jLabelPbHpsJns.setText(" ");

        jBtnPbHps.setText("Konfirmasi");
        jBtnPbHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbHpsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jBtnPbHpsCr))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel47))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPbHpsID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPbHpsNm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPbHpsAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPbHpsJns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnPbHps)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPbHpsCr, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTFPbHpsCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel47)
                    .addComponent(jLabelPbHpsID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabelPbHpsNm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabelPbHpsAlm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnPbHpsCr)
                        .addComponent(jBtnPbHps))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jLabelPbHpsJns)))
                .addGap(21, 21, 21))
        );

        jTabbedPane3.addTab("Hapus", jPanel9);

        jTPbbiasa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID", "Nama", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTPbbiasa.setRowHeight(21);
        jScrollPane6.setViewportView(jTPbbiasa);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Biasa", jPanel15);

        jTabbedPane6.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel21.setText("ID:");

        jLabel22.setText("Nama:");

        jLabel54.setText("Alamat:");

        jTFPbTmbhID1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPbTmbhID1KeyTyped(evt);
            }
        });

        jBtnPbTmbh1.setText("Konfirmasi");
        jBtnPbTmbh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbTmbh1ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setText("Tambahkan pelanggan VIP ke dalam daftar ,");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnPbTmbh1)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFPbTmbhID1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFPbTmbhNm1)
                                    .addComponent(jTFPbTmbhAlm1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPbTmbhID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPbTmbhNm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jTFPbTmbhAlm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnPbTmbh1)
                .addGap(14, 14, 14))
        );

        jTabbedPane6.addTab("Tambah", jPanel17);

        jLabel57.setText("Alamat:");

        jLabel58.setText("Jenis:");

        jLabel59.setText("Nama:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel60.setText("Edit pelanggan dalam daftar,");

        jBtnPbUbah1.setText("Konfirmasi");
        jBtnPbUbah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbUbah1ActionPerformed(evt);
            }
        });

        jLabel61.setText("Cari ID:");

        jBtnPbUbahCr1.setText("Cari");
        jBtnPbUbahCr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbUbahCr1ActionPerformed(evt);
            }
        });

        jTFPbUbahCr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPbUbahCr1KeyTyped(evt);
            }
        });

        jCBPbUbahJns1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biasa", "VIP" }));
        jCBPbUbahJns1.setSelectedIndex(1);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jBtnPbUbahCr1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnPbUbah1))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel57))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFPbUbahNm1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFPbUbahAlm1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBPbUbahJns1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPbUbahCr1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jTFPbUbahCr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTFPbUbahNm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPbUbahAlm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jCBPbUbahJns1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPbUbah1)
                    .addComponent(jBtnPbUbahCr1))
                .addGap(14, 14, 14))
        );

        jTabbedPane6.addTab("Ubah", jPanel18);

        jLabel62.setText("ID:");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setText("Hapus data pelanggan dari dalam daftar,");

        jBtnPbHpsCr1.setText("Cari");
        jBtnPbHpsCr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbHpsCr1ActionPerformed(evt);
            }
        });

        jLabel64.setText("Cari ID:");

        jTFPbHpsCr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPbHpsCr1KeyTyped(evt);
            }
        });

        jLabel65.setText("Data berikut akan dihapus:");

        jLabel66.setText("Nama:");

        jLabel67.setText("Alamat:");

        jLabelPbHpsAlm1.setText(" ");

        jLabelPbHpsNm1.setText(" ");

        jLabelPbHpsID1.setText(" ");

        jLabel53.setText("Jenis:");

        jLabelPbHpsJns1.setText(" ");

        jBtnPbHps1.setText("Konfirmasi");
        jBtnPbHps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPbHps1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jBtnPbHpsCr1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPbHpsAlm1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel62))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPbHpsNm1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPbHpsID1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPbHpsJns1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jBtnPbHps1))))
                    .addComponent(jLabel63)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFPbHpsCr1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnPbHps1))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(jTFPbHpsCr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(jLabel62)
                            .addComponent(jLabelPbHpsID1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jLabelPbHpsNm1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(jLabelPbHpsAlm1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnPbHpsCr1)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel53)
                                .addComponent(jLabelPbHpsJns1)))))
                .addGap(21, 21, 21))
        );

        jTabbedPane6.addTab("Hapus", jPanel19);

        jTPbVIP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID", "Nama", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTPbVIP.setRowHeight(21);
        jScrollPane7.setViewportView(jTPbVIP);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane6)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Vip", jPanel16);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        jTabbedPane1.addTab("Pembeli", jPanel2);

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane4StateChanged(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel24.setText("Tambah menu ke keranjang,");

        jTTr1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Menu", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTTr1);

        jLabelTrTmbhTot.setText(" ");

        jBtnTrTmbhCrKd.setText("Cari Menu");
        jBtnTrTmbhCrKd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrTmbhCrKdActionPerformed(evt);
            }
        });

        jTFTrTmbhCrKd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTrTmbhCrKdKeyTyped(evt);
            }
        });

        jLabel7.setText("ID:");

        jBtnTrTmbhCrID.setText("Cari ID");
        jBtnTrTmbhCrID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrTmbhCrIDActionPerformed(evt);
            }
        });

        jLabel8.setText("Kode:");

        jLabel23.setText("Jumlah:");

        jTFTrTmbhCrID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTrTmbhCrIDKeyTyped(evt);
            }
        });

        jBtnTrTmbh.setText("Tambahkan");
        jBtnTrTmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrTmbhActionPerformed(evt);
            }
        });

        jBtnCatat.setText("Catat");
        jBtnCatat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCatatActionPerformed(evt);
            }
        });

        jLabel34.setText("Nama:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel39.setText("Total:");

        jLabel68.setText("Menu:");

        jLabelTrTmbhMn.setText(" ");

        jLabel71.setText("Harga:");

        jLabelTrTmbhHg.setText(" ");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabelTrTmbhTot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnTrTmbh))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel34))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTFTrTmbhCrKd)
                                .addComponent(jTFTrTmbhCrID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFTrTmbhNm, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnTrTmbhCrKd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnTrTmbhCrID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCatat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71)
                            .addComponent(jLabel68))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTrTmbhMn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTrTmbhHg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFTrTmbhNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCatat)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jBtnTrTmbhCrID)
                    .addComponent(jTFTrTmbhCrID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTFTrTmbhCrKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnTrTmbhCrKd))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabelTrTmbhMn))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jLabelTrTmbhHg))
                .addGap(17, 17, 17)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabelTrTmbhTot)
                    .addComponent(jBtnTrTmbh))
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel24);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Tambah", jPanel10);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Ubah jumlah pembelian dalam keranjang,");

        jTTr2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Menu", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTTr2);

        jLabel25.setText("Kode:");

        jLabel26.setText("Jumlah:");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        jBtnTrUbah.setText("Konfirmasi");
        jBtnTrUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrUbahActionPerformed(evt);
            }
        });

        jLabel27.setText("Total:");

        jLabelTrUbahTot.setText(" ");

        jTFTrUbahMnCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTrUbahMnCrKeyTyped(evt);
            }
        });

        jBtnTrUbahCr.setText("Cari Kode Menu");
        jBtnTrUbahCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrUbahCrActionPerformed(evt);
            }
        });

        jLabel70.setText("Menu:");

        jLabel73.setText("Harga:");

        jLabelTrUbahMn.setText(" ");

        jLabelTrUbahHg.setText(" ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jBtnTrUbahCr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnTrUbah))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTrUbahHg, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel70))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTrUbahMn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFTrUbahMnCr)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelTrUbahTot, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTFTrUbahMnCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jLabelTrUbahMn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jLabelTrUbahHg))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabelTrUbahTot))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnTrUbah)
                            .addComponent(jBtnTrUbahCr)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jTabbedPane4.addTab("Ubah", jPanel11);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setText("Hapus item pembelian dalam keranjang,");

        jTTr3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Menu", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTTr3);

        jLabel43.setText("Kode:");

        jBtnTrHps.setText("Konfirmasi");
        jBtnTrHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrHpsActionPerformed(evt);
            }
        });

        jTFTrHpsMnCr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTrHpsMnCrKeyTyped(evt);
            }
        });

        jBtnTrHpsCr.setText("Cari Kode Menu");
        jBtnTrHpsCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTrHpsCrActionPerformed(evt);
            }
        });

        jLabel35.setText("Menu:");

        jLabel38.setText("Jumlah:");

        jLabel40.setText("Total:");

        jLabelTrHps2.setText(" ");

        jLabelTrHps1.setText(" ");

        jLabelTrHps3.setText(" ");

        jLabel72.setText("Akan dihapus:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jBtnTrHpsCr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnTrHps))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFTrHpsMnCr, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelTrHps1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelTrHps3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelTrHps2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jTFTrHpsMnCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabelTrHps1)
                            .addComponent(jLabel72))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabelTrHps2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabelTrHps3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnTrHps)
                            .addComponent(jBtnTrHpsCr)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Hapus", jPanel12);

        jTextPane1.setEditable(false);
        jScrollPane12.setViewportView(jTextPane1);

        jBtnCetak.setText("Cetak Dan Kosongkan Struk");
        jBtnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCetakActionPerformed(evt);
            }
        });

        jBtnTulisStruk.setText("Tulis Struk");
        jBtnTulisStruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTulisStrukActionPerformed(evt);
            }
        });

        jBtnCatatNominal.setText("Catat");
        jBtnCatatNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCatatNominalActionPerformed(evt);
            }
        });

        jLabel74.setText("Nominal Bayar:");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jBtnTulisStruk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNominal, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCatatNominal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCetak)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCetak)
                    .addComponent(jBtnTulisStruk)
                    .addComponent(jBtnCatatNominal)
                    .addComponent(jLabel74)
                    .addComponent(jTFNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane4.addTab("Lihat Struk", jPanel25);

        jTTrRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Kode Transaksi", "ID", "Nama", "Jenis", "Harga Total", "Biaya Akhir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTTrRiwayat);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Riwayat Transaksi", jPanel13);

        jLabel37.setText("Rekap pemasukan menu:");

        jLabel41.setText("Rekap pembelian pelanggan:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane15.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane16.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addGap(103, 103, 103))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Rekap", jPanel26);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama", "Harga", "Kode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(21);
        jScrollPane10.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane8.addTab("Gerobak A", jPanel22);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama", "Harga", "Kode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(21);
        jScrollPane11.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane8.addTab("Gerobak B", jPanel23);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transaksi", jPanel3);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/umkmgui/pp.jpg"))); // NOI18N
        jLabel33.setText(" ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("KING STORE,");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Admin KING");

        jLabel36.setText("App Version: 1.00");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)))
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel33))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(1, 1, 1)
                .addComponent(jLabel36))
        );

        jTabbedPane1.addTab("Profil", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnMnTmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMnTmbhActionPerformed
		if (jTFMnTmbhNm.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom nama!");
		} else if (jTFMnTmbhHg.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom harga!");
		} else {
			if (jmn < mmn) {
				//cek kesamaan nama
				boolean ada = false;
				for (int i = 0; i < jmn; i++) {
					if (m[i].getNama().equalsIgnoreCase(jTFMnTmbhNm.getText())){
						ada = true;
						break;
					}
				}
				if(ada){
					JOptionPane.showMessageDialog(this, "Nama menu sudah ada!");
				} else if (dialogKonfirmasi("Yakin menambah?")) {
					String a = jTFMnTmbhNm.getText();
					int b = Integer.parseInt(jTFMnTmbhHg.getText());
					String c = "KA"+ (jmn+1);
					m[jmn] = new cMenuGerobakA(a,b,c,0);

					//Array String untuk ditampilkan di tabel
					String row[][] = new String[1][4];
					row[0][0] = String.valueOf(jmn + 1);
					row[0][1] = m[jmn].getNama();
					row[0][2] = String.valueOf(m[jmn].getHarga());
					row[0][3] = m[jmn].getKode();
					DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel();
					model1.addRow(row[0]);
					DefaultTableModel model3 = (DefaultTableModel)jTable3.getModel();
					model3.addRow(row[0]);
					jmn++;
					jm++;
					JOptionPane.showMessageDialog(this, "Penambahan sukses...");

					//Kosongkan text field
					jTFMnTmbhNm.setText("");
					jTFMnTmbhHg.setText("");
				} else 
					JOptionPane.showMessageDialog(this, "Penambahan batal...");
			} else {
				JOptionPane.showMessageDialog(this, "Kapasitas penuh!");
				//Kosongkan text field
				jTFMnTmbhNm.setText("");
				jTFMnTmbhHg.setText("");
			}
		}
    }//GEN-LAST:event_jBtnMnTmbhActionPerformed

    private void jBtnMnUbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMnUbhActionPerformed
        for (int i = 0; i < jmn; i++) {
			//Gerobak A
			if (m[i].getKode().equalsIgnoreCase(jTFMnUbahCr.getText())){
				if (dialogKonfirmasi("Yakin mengubah?")) {
					m[i].setNama(jTFMnUbahNm.getText());
					m[i].setHarga(Integer.parseInt(jTFMnUbahHg.getText()));
					//m[i].setKode(jTFMnUbahDk.getText());
					DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel();
					model1.setValueAt(m[i].getNama(), i, 1);
					model1.setValueAt(m[i].getHarga(), i, 2);
					DefaultTableModel model3 = (DefaultTableModel)jTable3.getModel();
					model3.setValueAt(m[i].getNama(), i, 1);
					model3.setValueAt(m[i].getHarga(), i, 2);
					JOptionPane.showMessageDialog(this, "Ubah sukses...");
				} else  
					JOptionPane.showMessageDialog(this, "Ubah batal...");
				break;
			}
		}
		for (int i = 0; i < jmn1; i++) {
			//Gerobak B
			if (m1[i].getKode().equalsIgnoreCase(jTFMnUbahCr.getText())){
				if (dialogKonfirmasi("Yakin mengubah?")) {
					m1[i].setNama(jTFMnUbahNm.getText());
					m1[i].setHarga(Integer.parseInt(jTFMnUbahHg.getText()));
					DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
					model2.setValueAt(m1[i].getNama(), i, 1);
					model2.setValueAt(m1[i].getHarga(), i, 2);
					DefaultTableModel model4 = (DefaultTableModel)jTable4.getModel();
					model4.setValueAt(m1[i].getNama(), i, 1);
					model4.setValueAt(m1[i].getHarga(), i, 2);
					JOptionPane.showMessageDialog(this, "Ubah sukses...");
				} else  
					JOptionPane.showMessageDialog(this, "Ubah batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFMnUbahCr.setText(""); jTFMnUbahCr.setEditable(true);
		jTFMnUbahNm.setText(""); jTFMnUbahNm.setEnabled(false);
		jTFMnUbahHg.setText(""); jTFMnUbahHg.setEnabled(false);
		jBtnMnUbh.setEnabled(false); jBtnMnUbahCr.setEnabled(true);
    }//GEN-LAST:event_jBtnMnUbhActionPerformed

    private void jBtnTrUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrUbahActionPerformed
        for (int i = 0; i < jtr; i++) {
			if (tra[i].getKode().equalsIgnoreCase(jTFTrUbahMnCr.getText())){
				if (dialogKonfirmasi("Yakin mengubah?")) {
					int hg = tra[i].getHarga() / tra[i].getJumlah();
					tra[i].setJumlah((int) jSpinner2.getValue());
					tra[i].setHarga(hg * (int) jSpinner2.getValue());
					DefaultTableModel model1 = (DefaultTableModel)jTTr1.getModel();
					model1.setValueAt(tra[i].getJumlah(), i, 2);
					model1.setValueAt(tra[i].getHarga(), i, 3);
					DefaultTableModel model2 = (DefaultTableModel)jTTr2.getModel();
					model2.setValueAt(tra[i].getJumlah(), i, 2);
					model2.setValueAt(tra[i].getHarga(), i, 3);
					DefaultTableModel model3 = (DefaultTableModel)jTTr3.getModel();
					model3.setValueAt(tra[i].getJumlah(), i, 2);
					model3.setValueAt(tra[i].getHarga(), i, 3);
					JOptionPane.showMessageDialog(this, "Ubah sukses...");
				} else  
					JOptionPane.showMessageDialog(this, "Ubah batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFTrUbahMnCr.setEditable(true); jTFTrUbahMnCr.setText("");
		jBtnTrUbah.setEnabled(false); jBtnTrUbahCr.setEnabled(true);
		jSpinner2.setEnabled(false); jSpinner2.setValue(1);
		jLabelTrUbahMn.setText(" ");
		jLabelTrUbahHg.setText(" ");
		jLabelTrUbahTot.setText(" ");
    }//GEN-LAST:event_jBtnTrUbahActionPerformed

    private void jBtnTrHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrHpsActionPerformed
        for (int i = 0; i < jtr; i++) {
			if (tra[i].getMenu().equals(jLabelTrHps1.getText())){
				if (dialogKonfirmasi("Yakin menghapus?")) {
					for (int j = i; j < jtr; j++) {
						if (j == jtr - 1)
							tra[j] = null;
						else
							tra[j] = tra[j + 1];
					}
					jtr--;
					//update isi tabel
					DefaultTableModel model1 = (DefaultTableModel)jTTr1.getModel();
					model1.removeRow(i);
					DefaultTableModel model2 = (DefaultTableModel)jTTr2.getModel();
					model2.removeRow(i);
					DefaultTableModel model3 = (DefaultTableModel)jTTr3.getModel();
					model3.removeRow(i);
					JOptionPane.showMessageDialog(this, "Berhasil dihapus...");
				} else  
					JOptionPane.showMessageDialog(this, "Hapus batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFTrHpsMnCr.setText("");
		jLabelTrHps1.setText(" ");
		jLabelTrHps2.setText(" ");
		jLabelTrHps3.setText(" ");
		jBtnTrHps.setEnabled(false);
    }//GEN-LAST:event_jBtnTrHpsActionPerformed

    private void jBtnMnUbahCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMnUbahCrActionPerformed
        if (m[0] != null) {
			//cari nama
			boolean ada = false;
			for (int i = 0; i < jmn; i++) {
				//Gerobak A
				if (m[i].getKode().equalsIgnoreCase(jTFMnUbahCr.getText())){
					ada = true;
					jTFMnUbahCr.setEditable(false); jBtnMnUbh.setEnabled(true);
					jTFMnUbahNm.setText(m[i].getNama()); jTFMnUbahNm.setEnabled(true);
					jTFMnUbahHg.setText(String.valueOf(m[i].getHarga())); jTFMnUbahHg.setEnabled(true);
					//jTFMnUbahDk.setText(m[i].getKode()); jTFMnUbahDk.setEnabled(true);
					jBtnMnUbahCr.setEnabled(false);
					break;
				}
			}
			for (int i = 0; i < jmn1; i++) {
				//Gerobak B
				if (m1[i].getKode().equalsIgnoreCase(jTFMnUbahCr.getText())){
					ada = true;
					jTFMnUbahCr.setEditable(false); jBtnMnUbh.setEnabled(true);
					jTFMnUbahNm.setText(m1[i].getNama()); jTFMnUbahNm.setEnabled(true);
					jTFMnUbahHg.setText(String.valueOf(m1[i].getHarga())); jTFMnUbahHg.setEnabled(true);
					//jTFMnUbahDk.setText(m1[i].getKode()); jTFMnUbahDk.setEnabled(true);
					jBtnMnUbahCr.setEnabled(false);
					break;
				}
			}
			if (!ada) {
				JOptionPane.showMessageDialog(this, "Kode menu tidak ditemukan!");
				jTFMnUbahCr.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada menu sama sekali!");
			jTFMnUbahCr.setText("");
		}
    }//GEN-LAST:event_jBtnMnUbahCrActionPerformed

    private void jBtnMnHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMnHpsActionPerformed
        for (int i = 0; i < jmn; i++) {
			//Gerobak A
			if (m[i].getKode().equalsIgnoreCase(jLabelNmHpsDk.getText())){
				if (dialogKonfirmasi("Yakin menghapus?")) {
					for (int j = i; j < jmn; j++) {
						if (j == jmn - 1)
							m[j] = null;
						else
							m[j] = m[j + 1];
					}
					jmn--;
					//update isi tabel
					DefaultTableModel model1 = (DefaultTableModel)jTable1.getModel();
					model1.removeRow(i);
					DefaultTableModel model3 = (DefaultTableModel)jTable3.getModel();
					model3.removeRow(i);
					if (jmn>i) {
						model1.setValueAt(i + 1, i, 0);
						model3.setValueAt(i + 1, i, 0);
					}
					//Tulis ulang kode menu
					for (int j = 0;j < jmn;j++) {
						m[j].setKode("KA" + (j+1));
						model1.setValueAt("KA" + (j+1), j, 3);
						model3.setValueAt("KA" + (j+1), j, 3);
					}
					JOptionPane.showMessageDialog(this, "Berhasil dihapus...");
				} else  {
					JOptionPane.showMessageDialog(this, "Hapus batal...");
				}
				break;
			}
		}
		for (int i = 0; i < jmn1; i++) {
			//Gerobak B
			if (m1[i].getKode().equalsIgnoreCase(jLabelNmHpsDk.getText())){
				if (dialogKonfirmasi("Yakin menghapus?")) {
					for (int j = i; j < jmn1; j++) {
						if (j == jmn1 - 1)
							m1[j] = null;
						else
							m1[j] = m1[j + 1];
					}
					jmn1--;
					DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
					model2.removeRow(i);
					DefaultTableModel model4 = (DefaultTableModel)jTable4.getModel();
					model4.removeRow(i);
					if (jmn1>i) {
						model2.setValueAt(i + 1, i, 0);
						model4.setValueAt(i + 1, i, 0);
					}
					//Tulis ulang kode menu
					for (int j = 0;j < jmn1;j++) {
						m1[j].setKode("KB" + (j+1));
						model2.setValueAt("KB" + (j+1), j, 3);
						model4.setValueAt("KB" + (j+1), j, 3);
					}
					JOptionPane.showMessageDialog(this, "Berhasil dihapus...");
				} else  {
					JOptionPane.showMessageDialog(this, "Hapus batal...");
				}
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFMnHpsCr.setText("");
		jLabelNmHpsNm.setText("");
		jLabelNmHpsHg.setText("");
		jLabelNmHpsDk.setText("");
		jBtnMnHps.setEnabled(false);
    }//GEN-LAST:event_jBtnMnHpsActionPerformed

    private void jBtnMnHpsCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMnHpsCrActionPerformed
        if (m[0] != null) {
			//cari nama
			boolean ada = false;
			for (int i = 0; i < jmn; i++) {
				//Gerobak A
				if (m[i].getKode().equalsIgnoreCase(jTFMnHpsCr.getText())){
					ada = true;
					jBtnMnHps.setEnabled(true);
					jLabelNmHpsNm.setText(m[i].getNama());
					jLabelNmHpsHg.setText(String.valueOf(m[i].getHarga()));
					jLabelNmHpsDk.setText(m[i].getKode());
					break;
				}
			}
			for (int i = 0; i < jmn1; i++) {
				//Gerobak B
				if (m1[i].getKode().equalsIgnoreCase(jTFMnHpsCr.getText())){
					ada = true;
					jBtnMnHps.setEnabled(true);
					jLabelNmHpsNm.setText(m1[i].getNama());
					jLabelNmHpsHg.setText(String.valueOf(m1[i].getHarga()));
					jLabelNmHpsDk.setText(m1[i].getKode());
					break;
				}
			}
			if (!ada) {
				JOptionPane.showMessageDialog(this, "Nama menu tidak ditemukan!");
				jTFMnUbahCr.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada menu sama sekali!");
			jTFMnUbahCr.setText("");
		}
    }//GEN-LAST:event_jBtnMnHpsCrActionPerformed

    private void jBtnPbHpsCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbHpsCrActionPerformed
        if (pbb[0] != null) {
			//cari ID di daftar biasa
			boolean ada = false;
			for (int i = 0; i < jpb; i++) {
				if (pbb[i].getID().equals(jTFPbHpsCr.getText())){
					ada = true;
					jBtnPbHps.setEnabled(true);
					jLabelPbHpsID.setText(pbb[i].getID());
					jLabelPbHpsNm.setText(pbb[i].getNama());
					jLabelPbHpsAlm.setText(pbb[i].getAlamat());
					jLabelPbHpsJns.setText(pb.getJenis());
					break;
				}
			}
			if (!ada) {
				//cari ID di daftar VIP
				if (pbv[0] != null) {
					for (int i = 0; i < jpb1; i++) {
						if (pbv[i].getID().equals(jTFPbHpsCr.getText())){
							JOptionPane.showMessageDialog(this, "Nomor ID "+ jTFPbHpsCr.getText() +" ditemukan di daftar VIP."
															+ "\nSilakan pergi ke tab daftar VIP!");
							break;
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Nomor ID tidak ditemukan!");
				}
				jTFPbHpsCr.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada data pelanggan sama sekali di daftar biasa."
											+ "\nSilakan coba di daftar VIP!");
			jTFPbHpsCr.setText("");
		}
    }//GEN-LAST:event_jBtnPbHpsCrActionPerformed

    private void jBtnPbUbahCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbUbahCrActionPerformed
        if (pbb[0] != null) {
			//cari ID di daftar biasa
			boolean ada = false;
			for (int i = 0; i < jpb; i++) {
				if (pbb[i].getID().equals(jTFPbUbahCr.getText())){
					ada = true;
					jTFPbUbahCr.setEditable(false); jBtnPbUbahCr.setEnabled(false); 
					jBtnPbUbah.setEnabled(true);
					jTFPbUbahNm.setText(pbb[i].getNama()); jTFPbUbahNm.setEnabled(true);
					jTFPbUbahAlm.setText(pbb[i].getAlamat()); jTFPbUbahAlm.setEnabled(true);
					jCBPbUbahJns.setEnabled(true);
					break;
				}
			}
			if (!ada) {
				//cari ID di daftar VIP
				if (pbv[0] != null) {
					for (int i = 0; i < jpb1; i++) {
						if (pbv[i].getID().equals(jTFPbUbahCr.getText())){
							JOptionPane.showMessageDialog(this, "Nomor ID "+ jTFPbUbahCr.getText() +" ditemukan di daftar VIP."
															+ "\nSilakan pergi ke tab daftar VIP!");
							break;
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Nomor ID tidak ditemukan!");
				}
				jTFPbUbahCr.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada data pelanggan sama sekali di daftar biasa."
											+ "\nSilakan coba di daftar VIP!");
			jTFPbUbahCr.setText("");
		}
    }//GEN-LAST:event_jBtnPbUbahCrActionPerformed

    private void jBtnPbUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbUbahActionPerformed
        for (int i = 0; i < jpb; i++) {
			if (pbb[i].getID().equals(jTFPbUbahCr.getText())){
				if (dialogKonfirmasi("Yakin mengubah?")) {
					pbb[i].setNama(jTFPbUbahNm.getText());
					pbb[i].setAlamat(jTFPbUbahAlm.getText());
					//cek apakah ganti jenis
					if (jCBPbUbahJns.getSelectedItem().equals("VIP")) {
						//Tambah data pelanggan di tabel VIP
						String a = pbb[i].getID();
						String b = pbb[i].getNama();
						String c = pbb[i].getAlamat();
						pbv[jpb1] = new cPembeliVIP(a,b,c);
						String row[][] = new String[1][4];
						row[0][0] = String.valueOf(jpb1 + 1);
						row[0][1] = pbv[jpb1].getID();
						row[0][2] = pbv[jpb1].getNama();
						row[0][3] = pbv[jpb1].getAlamat();
						DefaultTableModel model = (DefaultTableModel)jTPbVIP.getModel();
						model.addRow(row[0]);
						jpb1++;
						
						//Hapus data pelanggan di tabel biasa
						for (int j = i; j < jpb; j++) {
							if (j == jpb - 1)
								pbb[j] = null;
							else
								pbb[j] = pbb[j + 1];
						}
						jpb--;
						DefaultTableModel modell = (DefaultTableModel)jTPbbiasa.getModel();
						modell.removeRow(i);
						if (jpb>i) {
							modell.setValueAt(i + 1, i, 0);
						}
						JOptionPane.showMessageDialog(this, "Ubah sukses...");
					} else {
						DefaultTableModel model = (DefaultTableModel)jTPbbiasa.getModel();
						model.setValueAt(jTFPbUbahNm.getText(), i, 2);
						model.setValueAt(jTFPbUbahAlm.getText(), i, 3);
						JOptionPane.showMessageDialog(this, "Ubah sukses...");
					}
				} else  
					JOptionPane.showMessageDialog(this, "Ubah batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFPbUbahCr.setText(""); jTFPbUbahCr.setEditable(true);
		jTFPbUbahNm.setText(""); jTFPbUbahNm.setEnabled(false);
		jTFPbUbahAlm.setText(""); jTFPbUbahAlm.setEnabled(false);
		jCBPbUbahJns.setSelectedIndex(0); jCBPbUbahJns.setEnabled(false);
		jBtnPbUbahCr.setEnabled(true); jBtnPbUbah.setEnabled(false);
    }//GEN-LAST:event_jBtnPbUbahActionPerformed

    private void jBtnPbTmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbTmbhActionPerformed
        if (jTFPbTmbhID.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom ID!");
        } else if (jTFPbTmbhNm.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom nama!");
        } else if (jTFPbTmbhAlm.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom alamat!");
        } else {
            if (jpb < mpb) {
                boolean ada = false;
				//cek kesamaan ID di daftar pelanggan biasa
				for (int i = 0; i < jpb; i++) {
					if (pbb[i].getID().equals(jTFPbTmbhID.getText())){
						ada = true;
						break;
					}
				}
				//cek kesamaan ID di daftar pelanggan VIP
				for (int i = 0; i < jpb1; i++) {
					if (pbv[i].getID().equals(jTFPbTmbhID.getText())){
						ada = true;
						break;
					}
				}
				if(ada){
					JOptionPane.showMessageDialog(this, "Nomor ID sudah ada!");
				} else if (dialogKonfirmasi("Yakin menambah '"+jTFPbTmbhNm.getText()+"' ke daftar biasa?")) {
					String a = jTFPbTmbhID.getText();
					String b = jTFPbTmbhNm.getText();
					String c = jTFPbTmbhAlm.getText();
					pbb[jpb] = new cPembeliBiasa(a,b,c);

					//Array String untuk ditampilkan di tabel
					String row[][] = new String[1][4];
					row[0][0] = String.valueOf(jpb + 1);
					row[0][1] = pbb[jpb].getID();
					row[0][2] = pbb[jpb].getNama();
					row[0][3] = pbb[jpb].getAlamat();
					DefaultTableModel model = (DefaultTableModel)jTPbbiasa.getModel();
					model.addRow(row[0]);
					jpb++;
					JOptionPane.showMessageDialog(this, "Penambahan sukses...");

					//Kosongkan text field
					jTFPbTmbhID.setText("");
					jTFPbTmbhNm.setText("");
					jTFPbTmbhAlm.setText("");
				} else 
					JOptionPane.showMessageDialog(this, "Penambahan batal...");
			} else {
				JOptionPane.showMessageDialog(this, "Kapasitas penuh!");
				//Kosongkan text field
				jTFPbTmbhID.setText("");
				jTFPbTmbhNm.setText("");
				jTFPbTmbhAlm.setText("");
			}
		}
    }//GEN-LAST:event_jBtnPbTmbhActionPerformed

    private void jBtnPbTmbh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbTmbh1ActionPerformed
        if (jTFPbTmbhID1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom ID!");
        } else if (jTFPbTmbhNm1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom nama!");
        } else if (jTFPbTmbhAlm1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom alamat!");
        } else {
            if (jpb1 < mpb1) {
                boolean ada = false;
				//cek kesamaan ID di daftar pelanggan biasa
				for (int i = 0; i < jpb; i++) {
					if (pbb[i].getID().equals(jTFPbTmbhID1.getText())){
						ada = true;
						break;
					}
				}
				//cek kesamaan ID di daftar pelanggan VIP
				for (int i = 0; i < jpb1; i++) {
					if (pbv[i].getID().equals(jTFPbTmbhID1.getText())){
						ada = true;
						break;
					}
				}
				if(ada){
					JOptionPane.showMessageDialog(this, "Nomor ID sudah ada!");
				} else if (dialogKonfirmasi("Yakin menambah '"+jTFPbTmbhNm1.getText()+"' ke daftar VIP?")) {
					String a = jTFPbTmbhID1.getText();
					String b = jTFPbTmbhNm1.getText();
					String c = jTFPbTmbhAlm1.getText();
					pbv[jpb1] = new cPembeliVIP(a,b,c);

					//Array String untuk ditampilkan di tabel
					String row[][] = new String[1][4];
					row[0][0] = String.valueOf(jpb1 + 1);
					row[0][1] = pbv[jpb1].getID();
					row[0][2] = pbv[jpb1].getNama();
					row[0][3] = pbv[jpb1].getAlamat();
					DefaultTableModel model = (DefaultTableModel)jTPbVIP.getModel();
					model.addRow(row[0]);
					jpb1++;
					JOptionPane.showMessageDialog(this, "Penambahan sukses...");

					//Kosongkan text field
					jTFPbTmbhID1.setText("");
					jTFPbTmbhNm1.setText("");
					jTFPbTmbhAlm1.setText("");
				} else 
					JOptionPane.showMessageDialog(this, "Penambahan batal...");
			} else {
				JOptionPane.showMessageDialog(this, "Kapasitas penuh!");
				//Kosongkan text field
				jTFPbTmbhID1.setText("");
				jTFPbTmbhNm1.setText("");
				jTFPbTmbhAlm1.setText("");
			}
		}
    }//GEN-LAST:event_jBtnPbTmbh1ActionPerformed

    private void jBtnPbUbah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbUbah1ActionPerformed
        for (int i = 0; i < jpb1; i++) {
			if (pbv[i].getID().equals(jTFPbUbahCr1.getText())){
				if (dialogKonfirmasi("Yakin mengubah?")) {
					pbv[i].setNama(jTFPbUbahNm1.getText());
					pbv[i].setAlamat(jTFPbUbahAlm1.getText());
					//cek apakah ganti jenis
					if (jCBPbUbahJns1.getSelectedItem().equals("Biasa")) {
						//Tambah data pelanggan di tabel biasa
						String a = pbv[i].getID();
						String b = pbv[i].getNama();
						String c = pbv[i].getAlamat();
						pbb[jpb] = new cPembeliBiasa(a,b,c);
						String row[][] = new String[1][4];
						row[0][0] = String.valueOf(jpb + 1);
						row[0][1] = pbb[jpb].getID();
						row[0][2] = pbb[jpb].getNama();
						row[0][3] = pbb[jpb].getAlamat();
						DefaultTableModel model = (DefaultTableModel)jTPbbiasa.getModel();
						model.addRow(row[0]);
						jpb++;
						
						//Hapus data pelanggan di tabel VIP
						for (int j = i; j < jpb1; j++) {
							if (j == jpb1 - 1)
								pbv[j] = null;
							else
								pbv[j] = pbv[j + 1];
						}
						jpb1--;
						DefaultTableModel modell = (DefaultTableModel)jTPbVIP.getModel();
						modell.removeRow(i);
						if (jpb1>i) {
							modell.setValueAt(i + 1, i, 0);
						}
						JOptionPane.showMessageDialog(this, "Ubah sukses...");
					} else {
						DefaultTableModel model = (DefaultTableModel)jTPbVIP.getModel();
						model.setValueAt(jTFPbUbahNm1.getText(), i, 2);
						model.setValueAt(jTFPbUbahAlm1.getText(), i, 3);
						JOptionPane.showMessageDialog(this, "Ubah sukses...");
					}
				} else  
					JOptionPane.showMessageDialog(this, "Ubah batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFPbUbahCr1.setText(""); jTFPbUbahCr1.setEditable(true);
		jTFPbUbahNm1.setText(""); jTFPbUbahNm1.setEnabled(false);
		jTFPbUbahAlm1.setText(""); jTFPbUbahAlm1.setEnabled(false);
		jCBPbUbahJns1.setSelectedIndex(1); jCBPbUbahJns1.setEnabled(false);
		jBtnPbUbahCr1.setEnabled(true); jBtnPbUbah1.setEnabled(false);
    }//GEN-LAST:event_jBtnPbUbah1ActionPerformed

    private void jBtnPbUbahCr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbUbahCr1ActionPerformed
        if (pbv[0] != null) {
			//cari ID di daftar VIP
			boolean ada = false;
			for (int i = 0; i < jpb1; i++) {
				if (pbv[i].getID().equals(jTFPbUbahCr1.getText())){
					ada = true;
					jTFPbUbahCr1.setEditable(false); jBtnPbUbahCr1.setEnabled(false);
					jBtnPbUbah1.setEnabled(true);
					jTFPbUbahNm1.setText(pbv[i].getNama()); jTFPbUbahNm1.setEnabled(true);
					jTFPbUbahAlm1.setText(pbv[i].getAlamat()); jTFPbUbahAlm1.setEnabled(true);
					jCBPbUbahJns1.setEnabled(true);
					break;
				}
			}
			if (!ada) {
				//cari ID di daftar biasa
				if (pbb[0] != null) {
					for (int i = 0; i < jpb; i++) {
						if (pbb[i].getID().equals(jTFPbUbahCr1.getText())){
							JOptionPane.showMessageDialog(this, "Nomor ID "+ jTFPbUbahCr1.getText() +" ditemukan di daftar biasa."
															+ "\nSilakan pergi ke tab daftar biasa!");
							break;
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Nomor ID tidak ditemukan!");
				}
				jTFPbUbahCr1.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada data pelanggan sama sekali di daftar VIP."
											+ "\nSilakan coba di daftar biasa!");
			jTFPbUbahCr1.setText("");
		}
    }//GEN-LAST:event_jBtnPbUbahCr1ActionPerformed

    private void jBtnPbHpsCr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbHpsCr1ActionPerformed
        if (pbv[0] != null) {
			//cari ID di daftar VIP
			boolean ada = false;
			for (int i = 0; i < jpb1; i++) {
				if (pbv[i].getID().equals(jTFPbHpsCr1.getText())){
					ada = true;
					jBtnPbHps1.setEnabled(true);
					jLabelPbHpsID1.setText(pbv[i].getID());
					jLabelPbHpsNm1.setText(pbv[i].getNama());
					jLabelPbHpsAlm1.setText(pbv[i].getAlamat());
					jLabelPbHpsJns1.setText(pv.getJenis());
					break;
				}
			}
			if (!ada) {
				//cari ID di daftar biasa
				if (pbb[0] != null) {
					for (int i = 0; i < jpb; i++) {
						if (pbb[i].getID().equals(jTFPbHpsCr1.getText())){
							JOptionPane.showMessageDialog(this, "Nomor ID "+ jTFPbHpsCr1.getText() +" ditemukan di daftar Biasa."
															+ "\nSilakan pergi ke tab daftar biasa!");
							break;
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Nomor ID tidak ditemukan!");
				}
				jTFPbHpsCr1.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada data pelanggan sama sekali di daftar VIP."
											+ "\nSilakan coba di daftar biasa!");
			jTFPbHpsCr1.setText("");
		}
    }//GEN-LAST:event_jBtnPbHpsCr1ActionPerformed

    private void jTFMnTmbhNmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMnTmbhNmKeyTyped
    /*    char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
        }*/
    }//GEN-LAST:event_jTFMnTmbhNmKeyTyped

    private void jTFMnTmbhHgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMnTmbhHgKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFMnTmbhHgKeyTyped

    private void jTFMnUbahCrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMnUbahCrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFMnUbahCrKeyTyped

    private void jTFMnUbahNmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMnUbahNmKeyTyped
    /*    char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
        }*/
    }//GEN-LAST:event_jTFMnUbahNmKeyTyped

    private void jTFMnUbahHgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMnUbahHgKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFMnUbahHgKeyTyped

    private void jTFMnHpsCrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMnHpsCrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFMnHpsCrKeyTyped

    private void jTFPbTmbhIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPbTmbhIDKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPbTmbhIDKeyTyped

    private void jTFPbUbahCrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPbUbahCrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPbUbahCrKeyTyped

    private void jTFPbHpsCrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPbHpsCrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPbHpsCrKeyTyped

    private void jTFPbTmbhID1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPbTmbhID1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPbTmbhID1KeyTyped

    private void jTFPbUbahCr1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPbUbahCr1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPbUbahCr1KeyTyped

    private void jTFPbHpsCr1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPbHpsCr1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPbHpsCr1KeyTyped

    private void jTFTrUbahMnCrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTrUbahMnCrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFTrUbahMnCrKeyTyped

    private void jTFTrHpsMnCrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTrHpsMnCrKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFTrHpsMnCrKeyTyped

    private void jBtnPbHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbHpsActionPerformed
        for (int i = 0; i < jpb; i++) {
			if (pbb[i].getID().equals(jLabelPbHpsID.getText())){
				if (dialogKonfirmasi("Yakin menghapus?")) {
					for (int j = i; j < jpb; j++) {
						if (j == jpb - 1)
							pbb[j] = null;
						else
							pbb[j] = pbb[j + 1];
					}
					jpb--;
					//update isi tabel
					DefaultTableModel model = (DefaultTableModel)jTPbbiasa.getModel();
					model.removeRow(i);
					if (jpb>i) {
						model.setValueAt(i + 1, i, 0);
					}
					JOptionPane.showMessageDialog(this, "Berhasil dihapus...");
				} else  
					JOptionPane.showMessageDialog(this, "Hapus batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFPbHpsCr.setText(" ");
		jLabelPbHpsID.setText(" ");
		jLabelPbHpsNm.setText(" ");
		jLabelPbHpsAlm.setText(" ");
		jLabelPbHpsJns.setText(" ");
		jBtnPbHps.setEnabled(false);
    }//GEN-LAST:event_jBtnPbHpsActionPerformed

    private void jBtnPbHps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPbHps1ActionPerformed
        for (int i = 0; i < jpb1; i++) {
			if (pbv[i].getID().equals(jLabelPbHpsID1.getText())){
				if (dialogKonfirmasi("Yakin menghapus?")) {
					for (int j = i; j < jpb1; j++) {
						if (j == jpb1 - 1)
							pbv[j] = null;
						else
							pbv[j] = pbv[j + 1];
					}
					jpb1--;
					//update isi tabel
					DefaultTableModel model = (DefaultTableModel)jTPbVIP.getModel();
					model.removeRow(i);
					if (jpb1>i) {
						model.setValueAt(i + 1, i, 0);
					}
					JOptionPane.showMessageDialog(this, "Berhasil dihapus...");
				} else  
					JOptionPane.showMessageDialog(this, "Hapus batal...");
				break;
			}
		}
		//Kembalikan ke kondisi semula
		jTFPbHpsCr1.setText(" ");
		jLabelPbHpsID1.setText(" ");
		jLabelPbHpsNm1.setText(" ");
		jLabelPbHpsAlm1.setText(" ");
		jLabelPbHpsJns1.setText(" ");
		jBtnPbHps1.setEnabled(false);
    }//GEN-LAST:event_jBtnPbHps1ActionPerformed

    private void jBtnMnTmbh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMnTmbh1ActionPerformed
        if (jTFMnTmbhNm.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom nama!");
		} else if (jTFMnTmbhHg.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Anda belum mengisi kolom harga!");
		} else {
			if (jmn1 < mmn1) {
				//cek kesamaan nama
				boolean ada = false;
				for (int i = 0; i < jmn1; i++) {
					if (m1[i].getNama().equalsIgnoreCase(jTFMnTmbhNm.getText())){
						ada = true;
						break;
					}
				}
				if(ada){
					JOptionPane.showMessageDialog(this, "Nama menu sudah ada!");
				} else if (dialogKonfirmasi("Yakin menambah?")) {
					String a = jTFMnTmbhNm.getText();
					int b = Integer.parseInt(jTFMnTmbhHg.getText());
					String c = "KB"+ (jmn1+1);
					m1[jmn1] = new cMenuGerobakB(a,b,c,0);

					//Array String untuk ditampilkan di tabel
					String row[][] = new String[1][4];
					row[0][0] = String.valueOf(jmn1 + 1);
					row[0][1] = m1[jmn1].getNama();
					row[0][2] = String.valueOf(m1[jmn1].getHarga());
					row[0][3] = m1[jmn1].getKode();
					DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
					model2.addRow(row[0]);
					DefaultTableModel model4 = (DefaultTableModel)jTable4.getModel();
					model4.addRow(row[0]);
					jmn1++;
					jm++;
					JOptionPane.showMessageDialog(this, "Penambahan sukses...");

					//Kosongkan text field
					jTFMnTmbhNm.setText("");
					jTFMnTmbhHg.setText("");
				} else 
					JOptionPane.showMessageDialog(this, "Penambahan batal...");
			} else {
				JOptionPane.showMessageDialog(this, "Kapasitas penuh!");
				//Kosongkan text field
				jTFMnTmbhNm.setText("");
				jTFMnTmbhHg.setText("");
			}
		}
    }//GEN-LAST:event_jBtnMnTmbh1ActionPerformed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        for (int i = 0; i < jtr; i++) {
			if (tra[i].getKode().equalsIgnoreCase(jTFTrUbahMnCr.getText())){
				jLabelTrUbahTot.setText(String.valueOf((tra[i].getHarga() / tra[i].getJumlah()) * (int) jSpinner2.getValue()));
				break;
			}
		}
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jBtnTrUbahCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrUbahCrActionPerformed
        boolean ada = false;
		if (tra[0] != null) {
			for (int i = 0; i < jtr; i++) {
				if (tra[i].getKode().equalsIgnoreCase(jTFTrUbahMnCr.getText())){
					ada = true;
					JOptionPane.showMessageDialog(this, "Berikut adalah data isi keranjang dengan kode '"+ tra[i].getKode() +"':"
													+ "\nNama Menu  : "+ tra[i].getMenu()
													+ "\nJumlah     : "+ tra[i].getJumlah()
													+ "\nTotal      : "+ tra[i].getHarga()
													+ "\n"
													+ "\nSilakan ubah jumlah satuan yang akan dibeli!");
					jSpinner2.setValue(tra[i].getJumlah());
					jTFTrUbahMnCr.setEditable(false);
					jBtnTrUbah.setEnabled(true); jBtnTrUbahCr.setEnabled(false);
					jSpinner2.setEnabled(true);
					jLabelTrUbahMn.setText(tra[i].getMenu());
					jLabelTrUbahHg.setText(String.valueOf(tra[i].getHarga() / tra[i].getJumlah()));
					jLabelTrUbahTot.setText(String.valueOf(tra[i].getHarga()));
					break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada menu yang ditambahkan ke daftar isi keranjang!"
											+ "\nSilakan tambahkan menu yang akan dibeli di tab tambah!");
			jBtnTrUbah.setEnabled(false);
		}
		if (!ada) {
			JOptionPane.showMessageDialog(this, "Kode menu '"+ jTFTrUbahMnCr.getText() +"' tidak ditemukan!"
											+ "\nSilakan masukkan ulang kode isi keranjang yang akan diubah!");
			jBtnTrUbah.setEnabled(false);
		}
    }//GEN-LAST:event_jBtnTrUbahCrActionPerformed

    private void jBtnTrHpsCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrHpsCrActionPerformed
        boolean ada = false;
		if (tra[0] != null) {
			for (int i = 0; i < jtr; i++) {
				if (tra[i].getKode().equalsIgnoreCase(jTFTrHpsMnCr.getText())){
					ada = true;
					jBtnTrHps.setEnabled(true);
					jLabelTrHps1.setText(tra[i].getMenu());
					jLabelTrHps2.setText(String.valueOf(tra[i].getJumlah()));
					jLabelTrHps3.setText(String.valueOf(tra[i].getHarga()));
					break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Belum ada menu yang ditambahkan ke daftar isi keranjang!"
											+ "\nSilakan tambahkan menu yang akan dibeli di tab tambah!");
			jBtnTrHps.setEnabled(false);
		}
		if (!ada) {
			JOptionPane.showMessageDialog(this, "Kode menu '"+ jTFTrUbahMnCr.getText() +"' tidak ditemukan!"
											+ "\nSilakan masukkan ulang kode isi keranjang yang akan dihapus!");
			jBtnTrHps.setEnabled(false);
		}
    }//GEN-LAST:event_jBtnTrHpsCrActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        if (sign) {
            jLabelTrTmbhTot.setText(String.valueOf(m[x].getHarga() * (int) jSpinner1.getValue()));
        } else {
            jLabelTrTmbhTot.setText(String.valueOf(m1[x].getHarga() * (int) jSpinner1.getValue()));
        }
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jBtnCatatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCatatActionPerformed
        tr.setNama(jTFTrTmbhNm.getText());
        jTFTrTmbhCrKd.setEnabled(true);
        jBtnTrTmbhCrKd.setEnabled(true);
        jTFTrTmbhNm.setEditable(false);
        jBtnCatat.setEnabled(false);
		jTextArea1.setText("");
		jTextArea2.setText("");
    }//GEN-LAST:event_jBtnCatatActionPerformed

    private void jBtnTrTmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrTmbhActionPerformed
        if (jtr < mtr) {
            if (dialogKonfirmasi("Yakin menambah?")) {
                if (sign) {
                    String a = m[x].getKode();
                    String b = m[x].getNama();
                    int c = (int) jSpinner1.getValue();
                    int d = c * m[x].getHarga();
                    tra[jtr] = new cTransaksi(a,b,c,d);
                } else {
                    String a = m1[x].getKode();
                    String b = m1[x].getNama();
                    int c = (int) jSpinner1.getValue();
                    int d = c * m1[x].getHarga();
                    tra[jtr] = new cTransaksi(a,b,c,d);
                }

                //Array String untuk ditampilkan di tabel
                String row[][] = new String[1][4];
                row[0][0] = tra[jtr].getKode();
                row[0][1] = tra[jtr].getMenu();
                row[0][2] = String.valueOf(tra[jtr].getJumlah());
                row[0][3] = String.valueOf(tra[jtr].getHarga());
                DefaultTableModel model1 = (DefaultTableModel)jTTr1.getModel();
                model1.addRow(row[0]);
                DefaultTableModel model2 = (DefaultTableModel)jTTr2.getModel();
                model2.addRow(row[0]);
                DefaultTableModel model3 = (DefaultTableModel)jTTr3.getModel();
                model3.addRow(row[0]);
                jtr++;
                jBtnTrTmbh.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Penambahan sukses...");
            } else
            JOptionPane.showMessageDialog(this, "Penambahan batal...");
        } else {
            JOptionPane.showMessageDialog(this, "Keranjang penuh!");
        }
        //Kosongkan text field
        jTFTrTmbhCrID.setText("");
        jTFTrTmbhCrKd.setText("");
        jSpinner1.setValue(1); jSpinner1.setEnabled(false);
		jLabelTrTmbhMn.setText(" ");
		jLabelTrTmbhHg.setText(" ");
        jLabelTrTmbhTot.setText(" ");
        //jTFTrTmbhNm.setEditable(true);
        //jBtnCatat.setEnabled(true);
    }//GEN-LAST:event_jBtnTrTmbhActionPerformed

    private void jTFTrTmbhCrIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTrTmbhCrIDKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFTrTmbhCrIDKeyTyped

    private void jBtnTrTmbhCrIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrTmbhCrIDActionPerformed
        tr.setID(jTFTrTmbhCrID.getText());
        boolean ada = false;
        if (pbb[0] != null) {
            //cari ID di daftar biasa
            for (int i = 0; i < jpb; i++) {
                if (pbb[i].getID().equalsIgnoreCase(jTFTrTmbhCrID.getText())){
                    ada = true;
					y = i;
					alm = pbb[i].getAlamat();
					jns = "Member biasa";
					tr.setJenis("Biasa");
					tr.setID(pbb[i].getID());
					tr.setNama(pbb[i].getNama());
                    tr.dptDk = false;
                    JOptionPane.showMessageDialog(this, "Nomor ID '"+ tr.getID() +"' terdaftar dalam pelanggan biasa!"
                        + "\nTidak ada diskon yang didapatkan.");
                    break;
                }
            }
        }
        if (pbv[0] != null) {
            for (int i = 0; i < jpb1; i++) {
                if (pbv[i].getID().equalsIgnoreCase(jTFTrTmbhCrID.getText())){
                    ada = true;
					y = i;
					alm = pbv[i].getAlamat();
					jns = "Member VIP";
                    tr.setJenis("VIP");
					tr.setID(pbv[i].getID());
					tr.setNama(pbv[i].getNama());
					tr.dptDk = true;
                    JOptionPane.showMessageDialog(this, "Nomor ID '"+ tr.getID() +"' terdaftar dalam pelanggan VIP!"
                        + "\nDiskon sebesar 10% akan didapatkan.");
                    break;
                }
            }
        }
        if (!ada) {
            tr.dptDk = false;
            tr.setID("-");
			tr.setNama(jTFTrTmbhCrID.getText());
			tr.setJenis("Umum");
			jns = "Pelanggan umum";
            JOptionPane.showMessageDialog(this, "Nomor ID '"+ jTFTrTmbhCrID.getText() +"' belum terdaftar dalam daftar pelanggan!"
                + "\nTidak ada diskon yang didapatkan.");
        }
    }//GEN-LAST:event_jBtnTrTmbhCrIDActionPerformed

    private void jTFTrTmbhCrKdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTrTmbhCrKdKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTFTrTmbhCrKdKeyTyped

    private void jBtnTrTmbhCrKdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTrTmbhCrKdActionPerformed
        //cek kesamaan kode menu
        boolean sama = false;
        for (int i = 0; i < jtr; i++) {
            if (tra[i].getKode().equalsIgnoreCase(jTFTrTmbhCrKd.getText())){
                sama = true;
                break;
            }
            if (tra[i].getKode().equalsIgnoreCase(jTFTrTmbhCrKd.getText())){
                sama = true;
                break;
            }
        }
        if(sama){
            JOptionPane.showMessageDialog(this, "Kode menu '"+ jTFTrTmbhCrKd.getText() +"' sudah ada dalam daftar isi keranjang!"
                + "\nSilakan pergi ke tab ubah jika ingin menambahkan jumlah satuan!");
            jTFTrTmbhCrKd.setText("");
        } else {
            boolean ada = false;
            if (m[0] != null) {
                //cari kode di menu gerobak A
                for (int i = 0; i < jmn; i++) {
                    if (m[i].getKode().equalsIgnoreCase(jTFTrTmbhCrKd.getText())){
                        ada = true;
                        x = i;
                        sign = true;
                        JOptionPane.showMessageDialog(this, "Berikut adalah data menu dengan kode '"+ m[i].getKode() +"':"
                            + "\nNama Menu        : "+ m[i].getNama()
                            + "\nHarga per satuan : "+ m[i].getHarga()
                            + "\n"
                            + "\nSilakan menentukan jumlah satuan yang akan dibeli!");
						jLabelTrTmbhMn.setText(m[i].getNama());
						jLabelTrTmbhHg.setText(String.valueOf(m[i].getHarga()));
                        jLabelTrTmbhTot.setText(String.valueOf(m[i].getHarga()));
                        break;
                    }
                }
            }
            if (m1[0] != null) {
                for (int i = 0; i < jmn1; i++) {
                    if (m1[i].getKode().equalsIgnoreCase(jTFTrTmbhCrKd.getText())){
                        ada = true;
                        x = i;
                        sign = false;
                        JOptionPane.showMessageDialog(this, "Berikut adalah data menu dengan kode '"+ m1[i].getKode() +"':"
                            + "\nNama Menu        : "+ m1[i].getNama()
                            + "\nHarga per satuan : "+ m1[i].getHarga()
                            + "\n"
                            + "\nSilakan menentukan jumlah satuan yang akan dibeli!");
						jLabelTrTmbhMn.setText(m1[i].getNama());
						jLabelTrTmbhHg.setText(String.valueOf(m1[i].getHarga()));
                        jLabelTrTmbhTot.setText(String.valueOf(m1[i].getHarga()));
                        break;
                    }
                }
            }
            if (!ada) {
                JOptionPane.showMessageDialog(this, "Kode menu '"+ jTFTrTmbhCrKd.getText() +"' tidak ditemukan!"
                    + "\nSilakan masukkan ulang kode menu yang akan dibeli!");
                jBtnTrTmbh.setEnabled(false);
            } else {
                jSpinner1.setEnabled(true);
                if (tr.getNama()== null) {
                    jBtnTrTmbh.setEnabled(false);
                } else {
                    jBtnTrTmbh.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_jBtnTrTmbhCrKdActionPerformed

    private void jTabbedPane4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane4StateChanged
		if (jTabbedPane4.getSelectedIndex()==5) {
			//Tampilan rekap menu
			String[] name = new String[(jmn) + (jmn1)]; String temp;
			int indeks = 0;
			for (int i = 0; i < jmn; i++) {
				name[indeks] = m[i].getKode() + "   " + m[i].getNama()+" : ";
				indeks++;System.out.println(indeks);
			}
			for (int i = 0; i < jmn1; i++) {
				name[indeks] = m1[i].getKode() + "   " + m1[i].getNama()+" : ";
				indeks++;System.out.println(indeks);
			}
			
			int[] income = new int[(jmn) + (jmn1)]; int temp1;
			int indek = 0;
			for (int i = 0; i < jmn; i++) {
				income[indek] = m[i].getPemasukan();
				indek++;
			}
			for (int i = 0; i < jmn1; i++) {
				income[indek] = m1[i].getPemasukan();
				indek++;
			}
			
			for (int i=0;i<indeks;i++) {
				for (int j=0;j<indeks-1;j++) {
					if (income[j] < income[j+1]) {
						temp1 = income[j];
						income[j] = income[j + 1];
						income[j + 1] = temp1;
						temp = name[j];
						name[j] = name[j + 1];
						name[j + 1] = temp;
					}
				}
			}
			for (int i = 0;i<indeks;i++){
				jTextArea1.append(name[i] + income[i]+"\n");
			}
			
			//Rekap pembeli
			
			//Tampilan rekap pembeli
			String[] namee = new String[jdt];
			indeks = 0;
			for (int i = 0; i < jdt; i++) {
				namee[indeks] = dt[i].getID()+" ("+dt[i].getJenis()+")   " + dt[i].getNama()+" : ";
				indeks++;
			}
			int[] outcome = new int[jdt];
			indek = 0;
			for (int i = 0; i < jdt; i++) {
				outcome[indek] = dt[i].getHarga();
				indek++;
			}
			for (int i=0;i<indeks;i++) {
				for (int j=0;j<indeks-1;j++) {
					if (outcome[j] < outcome[j+1]) {
						temp1 = outcome[j];
						outcome[j] = outcome[j + 1];
						outcome[j + 1] = temp1;
						temp = namee[j];
						namee[j] = namee[j + 1];
						namee[j + 1] = temp;
					}
				}
			}
			for (int i = 0;i<indeks;i++){
				jTextArea2.append(namee[i] + outcome[i]+"\n");
			}
		} else if (jTabbedPane4.getSelectedIndex()==3) {
			jTextPane1.setText("");
		}
    }//GEN-LAST:event_jTabbedPane4StateChanged

    private void jBtnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCetakActionPerformed
        if (jdt < mdt) {
			if (dialogKonfirmasi("Silakan Konfirmasi")) {
				//Rekap Pemasukan Menu
				for (int i=0;i<jmn;i++) {
					for (int j=0;j<jtr;j++) {
						if (m[i].getKode().equalsIgnoreCase(tra[j].getKode())) {
							m[i].setPemasukan(m[i].getPemasukan() + tra[j].getHarga());
						}
					}
				}
				for (int i=0;i<jmn1;i++) {
					for (int j=0;j<jtr;j++) {
						if (m1[i].getKode().equalsIgnoreCase(tra[j].getKode())) {
							m1[i].setPemasukan(m1[i].getPemasukan() + tra[j].getHarga());
						}
					}
				}
				
				String a = tr.getKodeTr();
				String b = tr.getID();
				String c = tr.getNama();
				String d = tr.getJenis();
				int e = tr.getHarga();
				int f = tr.getBiaya();
				dt[jdt] = new cTransaksi(a,b,c,d,e,f);

				//Array String untuk ditampilkan di tabel
				String row[][] = new String[1][7];
				row[0][0] = String.valueOf(jdt + 1);
				row[0][1] = dt[jdt].getKodeTr();
				row[0][2] = dt[jdt].getID();
				row[0][3] = dt[jdt].getNama();
				row[0][4] = dt[jdt].getJenis();
				row[0][5] = String.valueOf(dt[jdt].getHarga());
				row[0][6] = String.valueOf(dt[jdt].getBiaya());
				DefaultTableModel model = (DefaultTableModel)jTTrRiwayat.getModel();
				model.addRow(row[0]);
				jdt++;
				jt++;
				writeRiwayatTr();
				cetakStruk("src/umkmgui/Struk/Struk"+jt+".txt");
				JOptionPane.showMessageDialog(this, "Cetak struk berhasil...");
				jTextPane1.setText("");
				tr.setID("-");
				tr.setNama(null);
				tr.setJenis("Umum");
				alm = "-";
				jns = "Pelanggan umum";
				tr.setKodeTr(null);
				jmlhItem = 0;
				tr.setHarga(0);
				tr.setBiaya(0);
				tr.dptDk = false;
				jTFTrTmbhNm.setEditable(true); jBtnCatat.setEnabled(true); jTFTrTmbhNm.setText("");
				
				//Hapus isi elemen array tra dan isi tabel
				for (int i = jtr - 1; i >= 0; i--) {
					tra[i] = null;
					DefaultTableModel model1 = (DefaultTableModel)jTTr1.getModel();
					model1.removeRow(i);
					DefaultTableModel model2 = (DefaultTableModel)jTTr2.getModel();
					model2.removeRow(i);
					DefaultTableModel model3 = (DefaultTableModel)jTTr3.getModel();
					model3.removeRow(i);
				}
				jtr = 0;
			} else 
				JOptionPane.showMessageDialog(this, "Cetak struk batal...");
		} else {
			JOptionPane.showMessageDialog(this, "Transaksi telah mencapai batas!");
			jTextPane1.setText("");
		}
    }//GEN-LAST:event_jBtnCetakActionPerformed
	
    private void jBtnTulisStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTulisStrukActionPerformed
                jmlhItem = 0;
                jmlhHg = 0;
                jTextPane1.setText("");
		tr.setKodeTr("KST-" + (jt + 1));
		tambahTeks("KING\n", Color.BLACK, true, false);
		tambahTeks("Jl. Ahmad Yani No.319, Dukuh Menanggal, Kec. Gayungan\n", Color.BLACK, true, false);
		tambahTeks("Surabaya, Jawa Timur 60234\n", Color.BLACK, true, false);
		tambahTeks("Sedia aneka snack lezat\n", Color.BLACK, false, true);
		tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
		tambahTeks("Pelanggan   ID     : "+tr.getID()+"\n", Color.BLACK, false, false);
		tambahTeks("            Nama   : "+tr.getNama()+"\n", Color.BLACK, false, false);
		tambahTeks("            Alamat : "+alm+"\n", Color.BLACK, false, false);
		tambahTeks("            Jenis  : "+jns+"\n", Color.BLACK, false, false);
		tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
		tambahTeks("No. Transaksi      : "+tr.getKodeTr()+"\n", Color.BLACK, false, false);
		tambahTeks("Kasir              : AdminKing\n", Color.BLACK, false, false);
		tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
		tambahTeks("[Kode]   [Nama menu]   [Qty]   [Harga]   [Total]\n", Color.BLACK, false, false);
		tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
		for (int i=0; i<jtr; i++) {
			tambahTeks(keranjangToString(i)+"\n", Color.BLACK, false, false);
			jmlhItem = jmlhItem + tra[i].getJumlah();
			jmlhHg = jmlhHg + tra[i].getHarga();
		}
		tr.setHarga(jmlhHg);
		biayaAkh = jmlhHg;
		if (tr.dptDk) {
			biayaAkh = (int) (biayaAkh - (biayaAkh * 0.1));
			tr.setBiaya(biayaAkh);
		} else {
			tr.setBiaya(biayaAkh);
		}
		tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
		tambahTeks("Jumlah item        : "+jmlhItem+" item\n", Color.BLACK, false, false);
		tambahTeks("Total harga        : "+tr.getHarga()+"\n", Color.BLACK, false, false);
		if (tr.dptDk) tambahTeks("Diskon             : 10%\n", Color.BLACK, false, false);
		else tambahTeks("Diskon             : -\n", Color.BLACK, false, false);
		tambahTeks("Biaya akhir        : "+tr.getBiaya()+"\n", Color.BLACK, false, false);
		tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
		jBtnCatatNominal.setEnabled(true);
    }//GEN-LAST:event_jBtnTulisStrukActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new LoginJFrame().setVisible(true);
		setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBtnCatatNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCatatNominalActionPerformed
        if (jTFNominal.getText().length()!=0) {
			int bayar = Integer.parseInt(jTFNominal.getText());
			tambahTeks("Bayar              : "+bayar+"\n", Color.BLACK, true, false);
			tambahTeks("Kembalian          : "+(bayar-tr.getBiaya())+"\n", Color.BLACK, true, false);
			tambahTeks("==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==-==\n", Color.BLACK, true, false);
			tambahTeks("Mendaftar sebagai pelanggan dan sering-sering berbelanja\n", Color.BLACK, false, false);
			tambahTeks("membuat Anda memiliki peluang untuk menjadi pelanggan VIP\n", Color.BLACK, false, false);
			tambahTeks("dan memberikan Anda diskon sebesar 10% dari biaya akhir!\n", Color.BLACK, false, false);
			jBtnCetak.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "Masukkan nominal bayar terlebih dahulu!");
			jBtnCetak.setEnabled(false);
		}
		jBtnCatatNominal.setEnabled(false);
		jTFNominal.setText("");
    }//GEN-LAST:event_jBtnCatatNominalActionPerformed

	private static void tambahTeks(String teks, Color color, boolean bold, boolean italic) {
        StyledDocument doc = jTextPane1.getStyledDocument();
        Style style = jTextPane1.addStyle("Style", null);
        StyleConstants.setForeground(style, color);
        StyleConstants.setBold(style, bold);
        StyleConstants.setItalic(style, italic);
        
        try {
            doc.insertString(doc.getLength(), teks, style);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private String keranjangToString(int index){
        return "["+tra[index].getKode()+"]   ["+tra[index].getMenu()+"]   ["+tra[index].getJumlah()+"]   ["+tra[index].getHarga()/tra[index].getJumlah()+"]   ["+tra[index].getHarga()+"]";
    }
	
	private void readIndexRT() {
        String namaFile = "src/umkmgui/index riwayat transaksi.txt";
        try {
            File file = new File(namaFile);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
				jt = Integer.parseInt(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }
	
	private void writeRiwayatTr() {
		String file1 = "src/umkmgui/data riwayat transaksi.txt";
		String file2 = "src/umkmgui/index riwayat transaksi.txt";
		try {
            FileWriter fileWriter1 = new FileWriter(file1, true);
            fileWriter1.append(String.format("%s%n", tr.transaksiToString()));
            fileWriter1.close();
			
			FileWriter fileWriter2 = new FileWriter(file2);
            fileWriter2.write(String.valueOf(jt));
            fileWriter2.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
	}
	
	private static void cetakStruk(String namaFile) {
        try (FileWriter writer = new FileWriter(namaFile)) {
            StyledDocument doc = jTextPane1.getStyledDocument();//Dapatkan StyledDocument dari TextPane
            writer.write(doc.getText(0, doc.getLength()));//Ambil teks dari dokumen dan tulis ke file
        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
        }
    }
	
	private boolean dialogKonfirmasi(String pesanKonf){
		boolean confirm = false;
		int jawab = JOptionPane.showOptionDialog(this, 
                    pesanKonf, 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
    
		if(jawab == JOptionPane.YES_OPTION){
			confirm = true;
		}
		return confirm;
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AppJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				if (log.loginValid) {
					new AppJFrame().setVisible(true);
				} else {
					new LoginJFrame().setVisible(true);
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCatat;
    private javax.swing.JButton jBtnCatatNominal;
    private javax.swing.JButton jBtnCetak;
    private javax.swing.JButton jBtnMnHps;
    private javax.swing.JButton jBtnMnHpsCr;
    private javax.swing.JButton jBtnMnTmbh;
    private javax.swing.JButton jBtnMnTmbh1;
    private javax.swing.JButton jBtnMnUbahCr;
    private javax.swing.JButton jBtnMnUbh;
    private javax.swing.JButton jBtnPbHps;
    private javax.swing.JButton jBtnPbHps1;
    private javax.swing.JButton jBtnPbHpsCr;
    private javax.swing.JButton jBtnPbHpsCr1;
    private javax.swing.JButton jBtnPbTmbh;
    private javax.swing.JButton jBtnPbTmbh1;
    private javax.swing.JButton jBtnPbUbah;
    private javax.swing.JButton jBtnPbUbah1;
    private javax.swing.JButton jBtnPbUbahCr;
    private javax.swing.JButton jBtnPbUbahCr1;
    private javax.swing.JButton jBtnTrHps;
    private javax.swing.JButton jBtnTrHpsCr;
    private javax.swing.JButton jBtnTrTmbh;
    private javax.swing.JButton jBtnTrTmbhCrID;
    private javax.swing.JButton jBtnTrTmbhCrKd;
    private javax.swing.JButton jBtnTrUbah;
    private javax.swing.JButton jBtnTrUbahCr;
    private javax.swing.JButton jBtnTulisStruk;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBPbUbahJns;
    private javax.swing.JComboBox<String> jCBPbUbahJns1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNmHpsDk;
    private javax.swing.JLabel jLabelNmHpsHg;
    private javax.swing.JLabel jLabelNmHpsNm;
    private javax.swing.JLabel jLabelPbHpsAlm;
    private javax.swing.JLabel jLabelPbHpsAlm1;
    private javax.swing.JLabel jLabelPbHpsID;
    private javax.swing.JLabel jLabelPbHpsID1;
    private javax.swing.JLabel jLabelPbHpsJns;
    private javax.swing.JLabel jLabelPbHpsJns1;
    private javax.swing.JLabel jLabelPbHpsNm;
    private javax.swing.JLabel jLabelPbHpsNm1;
    private javax.swing.JLabel jLabelTrHps1;
    private javax.swing.JLabel jLabelTrHps2;
    private javax.swing.JLabel jLabelTrHps3;
    private javax.swing.JLabel jLabelTrTmbhHg;
    private javax.swing.JLabel jLabelTrTmbhMn;
    private javax.swing.JLabel jLabelTrTmbhTot;
    private javax.swing.JLabel jLabelTrUbahHg;
    private javax.swing.JLabel jLabelTrUbahMn;
    private javax.swing.JLabel jLabelTrUbahTot;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTFMnHpsCr;
    private javax.swing.JTextField jTFMnTmbhHg;
    private javax.swing.JTextField jTFMnTmbhNm;
    private javax.swing.JTextField jTFMnUbahCr;
    private javax.swing.JTextField jTFMnUbahHg;
    private javax.swing.JTextField jTFMnUbahNm;
    private javax.swing.JTextField jTFNominal;
    private javax.swing.JTextField jTFPbHpsCr;
    private javax.swing.JTextField jTFPbHpsCr1;
    private javax.swing.JTextField jTFPbTmbhAlm;
    private javax.swing.JTextField jTFPbTmbhAlm1;
    private javax.swing.JTextField jTFPbTmbhID;
    private javax.swing.JTextField jTFPbTmbhID1;
    private javax.swing.JTextField jTFPbTmbhNm;
    private javax.swing.JTextField jTFPbTmbhNm1;
    private javax.swing.JTextField jTFPbUbahAlm;
    private javax.swing.JTextField jTFPbUbahAlm1;
    private javax.swing.JTextField jTFPbUbahCr;
    private javax.swing.JTextField jTFPbUbahCr1;
    private javax.swing.JTextField jTFPbUbahNm;
    private javax.swing.JTextField jTFPbUbahNm1;
    private javax.swing.JTextField jTFTrHpsMnCr;
    private javax.swing.JTextField jTFTrTmbhCrID;
    private javax.swing.JTextField jTFTrTmbhCrKd;
    private javax.swing.JTextField jTFTrTmbhNm;
    private javax.swing.JTextField jTFTrUbahMnCr;
    private javax.swing.JTable jTPbVIP;
    private javax.swing.JTable jTPbbiasa;
    private javax.swing.JTable jTTr1;
    private javax.swing.JTable jTTr2;
    private javax.swing.JTable jTTr3;
    private javax.swing.JTable jTTrRiwayat;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private static javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
