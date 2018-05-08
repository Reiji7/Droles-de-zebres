package hud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class hud extends JFrame {

	private JPanel contentPane;

	//Supprimez les caractères de commentaires pour lancer l'interface!
	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hud frame = new hud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/ 
	
	/**
	 * Create the frame.
	 */
	public hud() {
		setTitle("Drôles de zèbres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 0, 130, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		contentPane.setBackground(new Color(70,70,255));
		
		JPanel infoPartieP = new JPanel();
		GridBagConstraints gbc_infoPartieP = new GridBagConstraints();
		gbc_infoPartieP.insets = new Insets(0, 0, 0, 5);
		gbc_infoPartieP.fill = GridBagConstraints.BOTH;
		gbc_infoPartieP.gridx = 0;
		gbc_infoPartieP.gridy = 0;
		contentPane.add(infoPartieP, gbc_infoPartieP);
		infoPartieP.setOpaque(false);
		GridBagLayout gbl_infoPartieP = new GridBagLayout();
		gbl_infoPartieP.columnWidths = new int[]{0, 0};
		gbl_infoPartieP.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_infoPartieP.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_infoPartieP.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		infoPartieP.setLayout(gbl_infoPartieP);
		
		JLabel icone = new JLabel(new ImageIcon("src/img/logo_ddz.gif"));
		GridBagConstraints gbc_icone = new GridBagConstraints();
		gbc_icone.insets = new Insets(0, 0, 5, 0);
		gbc_icone.gridx = 0;
		gbc_icone.gridy = 0;
		infoPartieP.add(icone, gbc_icone);
		
		JLabel lblJoueur = new JLabel("Joueur 1");
		GridBagConstraints gbc_lblJoueur = new GridBagConstraints();
		gbc_lblJoueur.insets = new Insets(0, 0, 5, 0);
		gbc_lblJoueur.gridx = 0;
		gbc_lblJoueur.gridy = 1;
		infoPartieP.add(lblJoueur, gbc_lblJoueur);
		
		JLabel lblJoueur_1 = new JLabel("Joueur 2");
		GridBagConstraints gbc_lblJoueur_1 = new GridBagConstraints();
		gbc_lblJoueur_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblJoueur_1.gridx = 0;
		gbc_lblJoueur_1.gridy = 2;
		infoPartieP.add(lblJoueur_1, gbc_lblJoueur_1);
		
		JPanel panel_56 = new JPanel();
		GridBagConstraints gbc_panel_56 = new GridBagConstraints();
		gbc_panel_56.fill = GridBagConstraints.BOTH;
		gbc_panel_56.gridx = 0;
		gbc_panel_56.gridy = 3;
		infoPartieP.add(panel_56, gbc_panel_56);
		
		JLabel dernCoup = new JLabel(new ImageIcon("src/img/de_dernierscoups.gif"));
		panel_56.setOpaque(false);
		panel_56.add(dernCoup);
		
		JPanel jeuP = new JPanel();
		GridBagConstraints gbc_jeuP = new GridBagConstraints();
		gbc_jeuP.insets = new Insets(0, 0, 0, 5);
		gbc_jeuP.fill = GridBagConstraints.BOTH;
		gbc_jeuP.gridx = 1;
		gbc_jeuP.gridy = 0;
		jeuP.setOpaque(false);
		contentPane.add(jeuP, gbc_jeuP);
		GridBagLayout gbl_jeuP = new GridBagLayout();
		gbl_jeuP.columnWidths = new int[]{0, 0};
		gbl_jeuP.rowHeights = new int[]{46, 0, 0};
		gbl_jeuP.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jeuP.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		jeuP.setLayout(gbl_jeuP);
		
		JPanel pionP = new JPanel();
		GridBagConstraints gbc_pionP = new GridBagConstraints();
		gbc_pionP.insets = new Insets(0, 0, 5, 0);
		gbc_pionP.fill = GridBagConstraints.BOTH;
		gbc_pionP.gridx = 0;
		gbc_pionP.gridy = 0;
		jeuP.add(pionP, gbc_pionP);
		
		pionP.setOpaque(false);
		JLabel lblVosPions = new JLabel("Vos pions:");
		pionP.add(lblVosPions);
		
		JLabel lbCroco = new JLabel(new ImageIcon("src/img/v_cro.gif"));
		pionP.add(lbCroco);
		
		JLabel lbEle = new JLabel(new ImageIcon("src/img/v_ele.gif"));
		pionP.add(lbEle);
		
		JLabel lbLion = new JLabel(new ImageIcon("src/img/v_lio.gif"));
		pionP.add(lbLion);
		
		JLabel lbZebre = new JLabel(new ImageIcon("src/img/v_zeb.gif"));
		pionP.add(lbZebre);
		
		JLabel lbGazelle = new JLabel(new ImageIcon("src/img/v_gaz.gif"));
		pionP.add(lbGazelle);
		
		JPanel plateauP = new JPanel();
		plateauP.setMaximumSize(new Dimension(300,300));
		GridBagConstraints gbc_plateauP = new GridBagConstraints();
		gbc_plateauP.fill = GridBagConstraints.BOTH;
		gbc_plateauP.gridx = 0;
		gbc_plateauP.gridy = 1;
		jeuP.add(plateauP, gbc_plateauP);
		GridBagLayout gbl_plateauP = new GridBagLayout();
		gbl_plateauP.columnWidths = new int[]{50, 17, 0, 0, 0, 0, 0, 49, 0};
		gbl_plateauP.rowHeights = new int[]{50, 0, 0, 0, 0, 0, 45, 0};
		gbl_plateauP.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_plateauP.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		plateauP.setLayout(gbl_plateauP);
		plateauP.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		plateauP.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		plateauP.add(panel_1, gbc_panel_1);
		
		JLabel lbImpala = new JLabel(new ImageIcon("src/img/impalajones.gif"));
		panel_1.add(lbImpala);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		plateauP.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		plateauP.add(panel_3, gbc_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 0;
		plateauP.add(panel_4, gbc_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 0;
		plateauP.add(panel_5, gbc_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 6;
		gbc_panel_6.gridy = 0;
		plateauP.add(panel_6, gbc_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 7;
		gbc_panel_7.gridy = 0;
		plateauP.add(panel_7, gbc_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(128, 0, 0));
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 0, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		plateauP.add(panel_8, gbc_panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 0, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 1;
		plateauP.add(panel_9, gbc_panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_10.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 0, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 2;
		gbc_panel_10.gridy = 1;
		plateauP.add(panel_10, gbc_panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 0, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 3;
		gbc_panel_11.gridy = 1;
		plateauP.add(panel_11, gbc_panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_12.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 0, 0);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 4;
		gbc_panel_12.gridy = 1;
		plateauP.add(panel_12, gbc_panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_13.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 0, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 5;
		gbc_panel_13.gridy = 1;
		plateauP.add(panel_13, gbc_panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_14.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 0, 0);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 6;
		gbc_panel_14.gridy = 1;
		plateauP.add(panel_14, gbc_panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_15.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(0, 0, 0, 0);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 7;
		gbc_panel_15.gridy = 1;
		plateauP.add(panel_15, gbc_panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_16.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.insets = new Insets(0, 0, 0, 0);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 2;
		plateauP.add(panel_16, gbc_panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_17.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(0, 0, 0, 0);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 1;
		gbc_panel_17.gridy = 2;
		plateauP.add(panel_17, gbc_panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 0, 0, 0);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 2;
		gbc_panel_18.gridy = 2;
		plateauP.add(panel_18, gbc_panel_18);
		panel_18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(0, 0, 0, 0);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 3;
		gbc_panel_19.gridy = 2;
		plateauP.add(panel_19, gbc_panel_19);
		panel_19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.insets = new Insets(0, 0, 0, 0);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 4;
		gbc_panel_20.gridy = 2;
		plateauP.add(panel_20, gbc_panel_20);
		panel_20.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.insets = new Insets(0, 0, 0, 0);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 5;
		gbc_panel_21.gridy = 2;
		plateauP.add(panel_21, gbc_panel_21);
		panel_21.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_22.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.insets = new Insets(0, 0, 0, 0);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 6;
		gbc_panel_22.gridy = 2;
		plateauP.add(panel_22, gbc_panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_23.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.insets = new Insets(0, 0, 0, 0);
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 7;
		gbc_panel_23.gridy = 2;
		plateauP.add(panel_23, gbc_panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_24.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(0, 0, 0, 0);
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 0;
		gbc_panel_24.gridy = 3;
		plateauP.add(panel_24, gbc_panel_24);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.insets = new Insets(0, 0, 0, 0);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 1;
		gbc_panel_25.gridy = 3;
		plateauP.add(panel_25, gbc_panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_26.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.insets = new Insets(0, 0, 0, 0);
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.gridx = 2;
		gbc_panel_26.gridy = 3;
		plateauP.add(panel_26, gbc_panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_27.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_27 = new GridBagConstraints();
		gbc_panel_27.insets = new Insets(0, 0, 0, 0);
		gbc_panel_27.fill = GridBagConstraints.BOTH;
		gbc_panel_27.gridx = 3;
		gbc_panel_27.gridy = 3;
		plateauP.add(panel_27, gbc_panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_28.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.insets = new Insets(0, 0, 0, 0);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 4;
		gbc_panel_28.gridy = 3;
		plateauP.add(panel_28, gbc_panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_29.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.insets = new Insets(0, 0, 0, 0);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 5;
		gbc_panel_29.gridy = 3;
		plateauP.add(panel_29, gbc_panel_29);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_30.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(0, 0, 0, 0);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 6;
		gbc_panel_30.gridy = 3;
		plateauP.add(panel_30, gbc_panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_31.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_31 = new GridBagConstraints();
		gbc_panel_31.insets = new Insets(0, 0, 0, 0);
		gbc_panel_31.fill = GridBagConstraints.BOTH;
		gbc_panel_31.gridx = 7;
		gbc_panel_31.gridy = 3;
		plateauP.add(panel_31, gbc_panel_31);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_32.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_32 = new GridBagConstraints();
		gbc_panel_32.insets = new Insets(0, 0, 0, 0);
		gbc_panel_32.fill = GridBagConstraints.BOTH;
		gbc_panel_32.gridx = 0;
		gbc_panel_32.gridy = 4;
		plateauP.add(panel_32, gbc_panel_32);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_33.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.insets = new Insets(0, 0, 0, 0);
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.gridx = 1;
		gbc_panel_33.gridy = 4;
		plateauP.add(panel_33, gbc_panel_33);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_34.setBackground(new Color(255, 215, 0));
		GridBagConstraints gbc_panel_34 = new GridBagConstraints();
		gbc_panel_34.insets = new Insets(0, 0, 0, 0);
		gbc_panel_34.fill = GridBagConstraints.BOTH;
		gbc_panel_34.gridx = 2;
		gbc_panel_34.gridy = 4;
		plateauP.add(panel_34, gbc_panel_34);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_35.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_35 = new GridBagConstraints();
		gbc_panel_35.insets = new Insets(0, 0, 0, 0);
		gbc_panel_35.fill = GridBagConstraints.BOTH;
		gbc_panel_35.gridx = 3;
		gbc_panel_35.gridy = 4;
		plateauP.add(panel_35, gbc_panel_35);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_36.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_36 = new GridBagConstraints();
		gbc_panel_36.insets = new Insets(0, 0, 0, 0);
		gbc_panel_36.fill = GridBagConstraints.BOTH;
		gbc_panel_36.gridx = 4;
		gbc_panel_36.gridy = 4;
		plateauP.add(panel_36, gbc_panel_36);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_37.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_37 = new GridBagConstraints();
		gbc_panel_37.insets = new Insets(0, 0, 0, 0);
		gbc_panel_37.fill = GridBagConstraints.BOTH;
		gbc_panel_37.gridx = 5;
		gbc_panel_37.gridy = 4;
		plateauP.add(panel_37, gbc_panel_37);
		
		JPanel panel_38 = new JPanel();
		panel_38.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_38.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_38 = new GridBagConstraints();
		gbc_panel_38.insets = new Insets(0, 0, 0, 0);
		gbc_panel_38.fill = GridBagConstraints.BOTH;
		gbc_panel_38.gridx = 6;
		gbc_panel_38.gridy = 4;
		plateauP.add(panel_38, gbc_panel_38);
		
		JPanel panel_39 = new JPanel();
		panel_39.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_39.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_39 = new GridBagConstraints();
		gbc_panel_39.insets = new Insets(0, 0, 0, 0);
		gbc_panel_39.fill = GridBagConstraints.BOTH;
		gbc_panel_39.gridx = 7;
		gbc_panel_39.gridy = 4;
		plateauP.add(panel_39, gbc_panel_39);
		
		JPanel panel_40 = new JPanel();
		panel_40.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_40.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_40 = new GridBagConstraints();
		gbc_panel_40.insets = new Insets(0, 0, 0, 0);
		gbc_panel_40.fill = GridBagConstraints.BOTH;
		gbc_panel_40.gridx = 0;
		gbc_panel_40.gridy = 5;
		plateauP.add(panel_40, gbc_panel_40);
		
		JPanel panel_41 = new JPanel();
		panel_41.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_41.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_41 = new GridBagConstraints();
		gbc_panel_41.insets = new Insets(0, 0, 0, 0);
		gbc_panel_41.fill = GridBagConstraints.BOTH;
		gbc_panel_41.gridx = 1;
		gbc_panel_41.gridy = 5;
		plateauP.add(panel_41, gbc_panel_41);
		
		JPanel panel_42 = new JPanel();
		panel_42.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_42.setBackground(new Color(255, 69, 0));
		GridBagConstraints gbc_panel_42 = new GridBagConstraints();
		gbc_panel_42.insets = new Insets(0, 0, 0, 0);
		gbc_panel_42.fill = GridBagConstraints.BOTH;
		gbc_panel_42.gridx = 2;
		gbc_panel_42.gridy = 5;
		plateauP.add(panel_42, gbc_panel_42);
		
		JPanel panel_43 = new JPanel();
		panel_43.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_43.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_43 = new GridBagConstraints();
		gbc_panel_43.insets = new Insets(0, 0, 0, 0);
		gbc_panel_43.fill = GridBagConstraints.BOTH;
		gbc_panel_43.gridx = 3;
		gbc_panel_43.gridy = 5;
		plateauP.add(panel_43, gbc_panel_43);
		
		JPanel panel_44 = new JPanel();
		panel_44.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_44.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_44 = new GridBagConstraints();
		gbc_panel_44.insets = new Insets(0, 0, 0, 0);
		gbc_panel_44.fill = GridBagConstraints.BOTH;
		gbc_panel_44.gridx = 4;
		gbc_panel_44.gridy = 5;
		plateauP.add(panel_44, gbc_panel_44);
		
		JPanel panel_45 = new JPanel();
		panel_45.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_45.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_45 = new GridBagConstraints();
		gbc_panel_45.insets = new Insets(0, 0, 0, 0);
		gbc_panel_45.fill = GridBagConstraints.BOTH;
		gbc_panel_45.gridx = 5;
		gbc_panel_45.gridy = 5;
		plateauP.add(panel_45, gbc_panel_45);
		
		JPanel panel_46 = new JPanel();
		panel_46.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_46.setBackground(new Color(0, 100, 0));
		GridBagConstraints gbc_panel_46 = new GridBagConstraints();
		gbc_panel_46.insets = new Insets(0, 0, 0, 0);
		gbc_panel_46.fill = GridBagConstraints.BOTH;
		gbc_panel_46.gridx = 6;
		gbc_panel_46.gridy = 5;
		plateauP.add(panel_46, gbc_panel_46);
		
		JPanel panel_47 = new JPanel();
		panel_47.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_47.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_47 = new GridBagConstraints();
		gbc_panel_47.insets = new Insets(0, 0, 0, 0);
		gbc_panel_47.fill = GridBagConstraints.BOTH;
		gbc_panel_47.gridx = 7;
		gbc_panel_47.gridy = 5;
		plateauP.add(panel_47, gbc_panel_47);
		
		JPanel panel_48 = new JPanel();
		panel_48.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_48.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_48 = new GridBagConstraints();
		gbc_panel_48.insets = new Insets(0, 0, 0, 0);
		gbc_panel_48.fill = GridBagConstraints.BOTH;
		gbc_panel_48.gridx = 0;
		gbc_panel_48.gridy = 6;
		plateauP.add(panel_48, gbc_panel_48);
		
		JPanel panel_49 = new JPanel();
		panel_49.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_49.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_49 = new GridBagConstraints();
		gbc_panel_49.insets = new Insets(0, 0, 0, 0);
		gbc_panel_49.fill = GridBagConstraints.BOTH;
		gbc_panel_49.gridx = 1;
		gbc_panel_49.gridy = 6;
		plateauP.add(panel_49, gbc_panel_49);
		
		JPanel panel_50 = new JPanel();
		panel_50.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_50.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_50 = new GridBagConstraints();
		gbc_panel_50.insets = new Insets(0, 0, 0, 0);
		gbc_panel_50.fill = GridBagConstraints.BOTH;
		gbc_panel_50.gridx = 2;
		gbc_panel_50.gridy = 6;
		plateauP.add(panel_50, gbc_panel_50);
		
		JPanel panel_51 = new JPanel();
		panel_51.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_51.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_51 = new GridBagConstraints();
		gbc_panel_51.insets = new Insets(0, 0, 0, 0);
		gbc_panel_51.fill = GridBagConstraints.BOTH;
		gbc_panel_51.gridx = 3;
		gbc_panel_51.gridy = 6;
		plateauP.add(panel_51, gbc_panel_51);
		
		JPanel panel_52 = new JPanel();
		panel_52.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_52.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_52 = new GridBagConstraints();
		gbc_panel_52.insets = new Insets(0, 0, 0, 0);
		gbc_panel_52.fill = GridBagConstraints.BOTH;
		gbc_panel_52.gridx = 4;
		gbc_panel_52.gridy = 6;
		plateauP.add(panel_52, gbc_panel_52);
		
		JPanel panel_53 = new JPanel();
		panel_53.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_53.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_53 = new GridBagConstraints();
		gbc_panel_53.insets = new Insets(0, 0, 0, 0);
		gbc_panel_53.fill = GridBagConstraints.BOTH;
		gbc_panel_53.gridx = 5;
		gbc_panel_53.gridy = 6;
		plateauP.add(panel_53, gbc_panel_53);
		
		JPanel panel_54 = new JPanel();
		panel_54.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_54.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_54 = new GridBagConstraints();
		gbc_panel_54.insets = new Insets(0, 0, 0, 0);
		gbc_panel_54.fill = GridBagConstraints.BOTH;
		gbc_panel_54.gridx = 6;
		gbc_panel_54.gridy = 6;
		plateauP.add(panel_54, gbc_panel_54);
		
		JPanel panel_55 = new JPanel();
		panel_55.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_55.setBackground(new Color(128, 0, 0));
		GridBagConstraints gbc_panel_55 = new GridBagConstraints();
		gbc_panel_55.fill = GridBagConstraints.BOTH;
		gbc_panel_55.gridx = 7;
		gbc_panel_55.gridy = 6;
		plateauP.add(panel_55, gbc_panel_55);
		
		JPanel chatP = new JPanel();
		GridBagConstraints gbc_chatP = new GridBagConstraints();
		gbc_chatP.fill = GridBagConstraints.BOTH;
		gbc_chatP.gridx = 2;
		gbc_chatP.gridy = 0;
		contentPane.add(chatP, gbc_chatP);
		GridBagLayout gbl_chatP = new GridBagLayout();
		gbl_chatP.columnWidths = new int[]{0, 0};
		gbl_chatP.rowHeights = new int[]{0, 0, 0, 0};
		gbl_chatP.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_chatP.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		chatP.setLayout(gbl_chatP);
		
		JLabel lblMiniForum = new JLabel("Mini forum");
		GridBagConstraints gbc_lblMiniForum = new GridBagConstraints();
		gbc_lblMiniForum.insets = new Insets(0, 0, 5, 0);
		gbc_lblMiniForum.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMiniForum.gridx = 0;
		gbc_lblMiniForum.gridy = 0;
		chatP.add(lblMiniForum, gbc_lblMiniForum);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 1;
		chatP.add(textPane, gbc_textPane);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.gridx = 0;
		gbc_btnEnvoyer.gridy = 2;
		chatP.add(btnEnvoyer, gbc_btnEnvoyer);
		
		chatP.setOpaque(false);
		setVisible(true);
	}

}
