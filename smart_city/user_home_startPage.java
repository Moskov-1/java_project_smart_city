
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;

class user_home_startPage{
    public static void main(String args[]){
		var obj1 = new usr_home();
		
	}
}
class usr_home implements Serializable, MouseListener{
	static persons usr_data_from_persons;
	static String USER = "";
	JFrame frame;
	JPanel menu_panel;
	JPanel lower_panel;
	JLabel menu_home_label;
	JLabel white_space_label;
	JLabel menu_logout_label;
	JLabel menu_browse_label;
	JLabel menu_profile_label;
	JLabel menu_necessity_label;
	JLabel menu_bill_label;
	
	home_panel wowcity_homePanel;
	browse_panel browse_table_panel;
	profile_panel profile_table_panel;
	Necessity_panel necessity_content_panel;
	bills bill_panel;
	
	usr_home(){
		try{	 
				usr_home.usr_data_from_persons = new  FileRecord().getData();
				System.out.println(usr_home.usr_data_from_persons.usrs);
				usr_home.USER = Register.getName();
				System.out.println("Just got it "+usr_home.USER);
			}catch(Exception ex){ex.printStackTrace();System.out.println("The exception's from here// loading from files");}
		menu_home_label = new JLabel("<HTML><U>HOME</U></HTML>");
		menu_home_label.setVerticalAlignment(JLabel.CENTER);
		menu_home_label.setHorizontalAlignment(JLabel.CENTER);
		menu_home_label.setForeground(Color.black);
		menu_home_label.setFont(new Font(null,Font.PLAIN,20));
		menu_home_label.setBounds(0,0,100,50);
		menu_home_label.setBackground(new Color(173,216,230));
		menu_home_label.setOpaque(true);
		menu_home_label.addMouseListener(this);
		
		menu_browse_label = new JLabel("<HTML><U>BROWSE</U></HTML>");
		menu_browse_label.setFont(new Font(null,Font.PLAIN,20));
		menu_browse_label.setVerticalAlignment(JLabel.CENTER);
		menu_browse_label.setHorizontalAlignment(JLabel.CENTER);
		menu_browse_label.setForeground(Color.black);
		menu_browse_label.setBounds(102,0,130,50);
		menu_browse_label.setBackground(new Color(173,216,230));
		menu_browse_label.setOpaque(true);
		menu_browse_label.addMouseListener(this);
		
		menu_profile_label = new JLabel("<HTML><U>PROFILE</U></HTML>");
		menu_profile_label.setFont(new Font(null,Font.PLAIN,20));
		menu_profile_label.setVerticalAlignment(JLabel.CENTER);
		menu_profile_label.setHorizontalAlignment(JLabel.CENTER);
		menu_profile_label.setForeground(Color.black);
		menu_profile_label.setBounds(234,0,130,50);
		menu_profile_label.setBackground(new Color(173,216,230));
		menu_profile_label.setOpaque(true);
		menu_profile_label.addMouseListener(this);
		
		menu_necessity_label = new JLabel("<HTML><U>NECESSITY</U></HTML>");
		menu_necessity_label.setFont(new Font(null,Font.PLAIN,20));
		menu_necessity_label.setVerticalAlignment(JLabel.CENTER);
		menu_necessity_label.setHorizontalAlignment(JLabel.CENTER);
		menu_necessity_label.setForeground(Color.black);
		menu_necessity_label.setBounds(366,0,130,50);
		menu_necessity_label.setBackground(new Color(173,216,230));
		menu_necessity_label.setOpaque(true);
		menu_necessity_label.addMouseListener(this);
		
		menu_bill_label = new JLabel("<HTML><U>BILLS</U></HTML>");
		menu_bill_label.setFont(new Font(null,Font.PLAIN,20));
		menu_bill_label.setVerticalAlignment(JLabel.CENTER);
		menu_bill_label.setHorizontalAlignment(JLabel.CENTER);
		menu_bill_label.setForeground(Color.black);
		menu_bill_label.setBounds(498,0,130,50);
		menu_bill_label.setBackground(new Color(173,216,230));
		menu_bill_label.setOpaque(true);
		menu_bill_label.addMouseListener(this);
		
		white_space_label = new JLabel();
		white_space_label.setBounds(630,0,135,50);// 2 pixels extra ase
		white_space_label.setBackground(new Color(173,216,230));//new Color(173,216,230)
		white_space_label.setOpaque(true);
		
		menu_logout_label = new JLabel("<HTML><U>LOG OUT</U></HTML>");
		menu_logout_label.setVerticalAlignment(JLabel.CENTER);
		menu_logout_label.setHorizontalAlignment(JLabel.CENTER);
		menu_logout_label.setForeground(Color.black);
		menu_logout_label.setFont(new Font("MV Boli",Font.PLAIN,20));
		menu_logout_label.setBounds(765,0,135,50);
		menu_logout_label.setBackground(new Color(173,216,230));
		menu_logout_label.setOpaque(true);
		menu_logout_label.addMouseListener(this);
		
		menu_panel = new JPanel();
		menu_panel.setPreferredSize(new Dimension(900,50));
		menu_panel.setBackground(new Color(30,144,255));
		menu_panel.setLayout(null);
		
		menu_panel.add(menu_home_label);
		menu_panel.add(menu_browse_label);
		menu_panel.add(menu_profile_label);
		menu_panel.add(menu_necessity_label);
		menu_panel.add(menu_bill_label);
		menu_panel.add(white_space_label);
		menu_panel.add(menu_logout_label);
		
		lower_panel =new JPanel();
		lower_panel.setPreferredSize(new Dimension(900,50));
		lower_panel.setBackground(Color.white);
		
		frame = new JFrame("SMART CITY");
		frame.setSize(900,600);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.setBackground(Color.blue);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		browse_table_panel = new browse_panel();
		
		profile_table_panel = new profile_panel();
		
		necessity_content_panel = new Necessity_panel();
		bill_panel = new bills();
		
		wowcity_homePanel= new home_panel();
		wowcity_homePanel.panelBuilder();
		wowcity_homePanel.repaint();
		
		frame.add(menu_panel,BorderLayout.NORTH);
		//frame.add(wowcity_homePanel,BorderLayout.CENTER);
		frame.add(lower_panel,BorderLayout.SOUTH);
		frame.getContentPane().add(wowcity_homePanel,BorderLayout.CENTER);
		
		frame.invalidate();
		frame.validate();
	}
	public void mousePressed(MouseEvent event){
		
	}public void mouseReleased(MouseEvent event){
		if(event.getSource() == menu_browse_label){
				//frame.getContentPane().remove(wowcity_homePanel);
				wowcity_homePanel.setVisible(false);
				profile_table_panel.setVisible(false);
				necessity_content_panel.setVisible(false);
				bill_panel.setVisible(false);
				browse_table_panel.setVisible(true);
                frame.getContentPane().add(browse_table_panel);
                frame.revalidate();
		}else if(event.getSource() == menu_home_label){
				browse_table_panel.setVisible(false);
				profile_table_panel.setVisible(false);
				necessity_content_panel.setVisible(false);
				bill_panel.setVisible(false);
				wowcity_homePanel.setVisible(true);
		}else if(event.getSource() == menu_profile_label){
				browse_table_panel.setVisible(false);
				wowcity_homePanel.setVisible(false);
				necessity_content_panel.setVisible(false);
				bill_panel.setVisible(false);
				frame.getContentPane().add(profile_table_panel);
				profile_table_panel.setVisible(true);
                frame.revalidate();
		}else if(event.getSource() == menu_necessity_label){
				browse_table_panel.setVisible(false);
				bill_panel.setVisible(false);
				wowcity_homePanel.setVisible(false);
				profile_table_panel.setVisible(false);
				frame.getContentPane().add(necessity_content_panel);
				necessity_content_panel.setVisible(true);
		}else if(event.getSource() == menu_bill_label){
				browse_table_panel.setVisible(false);
				wowcity_homePanel.setVisible(false);
				profile_table_panel.setVisible(false);
				necessity_content_panel.setVisible(false);
				frame.getContentPane().add(bill_panel);
				bill_panel.setVisible(true);
				
		}else if(event.getSource() == menu_logout_label){
				usr_home.usr_data_from_persons.usrs_log_time.replace(usr_home.USER,profile_panel.currentLogTime);
				frame.dispose();
		}
		
	}public void mouseClicked(MouseEvent event){
		
	}public void mouseEntered(MouseEvent event){
		if(event.getSource() == menu_home_label){
			menu_home_label.setForeground(Color.red);
		}else if(event.getSource() == menu_logout_label){
			menu_logout_label.setForeground(Color.red);
		}else if(event.getSource() == menu_browse_label){
			menu_browse_label.setForeground(Color.red);
		}else if(event.getSource() == menu_profile_label){
			menu_profile_label.setForeground(Color.red);
		}else if(event.getSource() == menu_necessity_label){
			menu_necessity_label.setForeground(Color.red);
		}else if(event.getSource() == menu_bill_label){
			menu_bill_label.setForeground(Color.red);
		}
		
	}public void mouseExited(MouseEvent event){
		if(event.getSource() == menu_home_label){
			menu_home_label.setForeground(Color.black);
		}else if(event.getSource() == menu_logout_label){
			menu_logout_label.setForeground(Color.black);
		}else if(event.getSource() == menu_browse_label){
			menu_browse_label.setForeground(Color.black);
		}else if(event.getSource() == menu_profile_label){
			menu_profile_label.setForeground(Color.black);
		}else if(event.getSource() == menu_necessity_label){
			menu_necessity_label.setForeground(Color.black);
		}else if(event.getSource() == menu_bill_label){
			menu_bill_label.setForeground(Color.black);
		}
	}
}
class home_panel extends JPanel{
	
	JLabel hello_label = new JLabel();
	Image home_img;
	JLabel img_label ;
	home_panel(){
		//this.repaint();
	}
	void panelBuilder(){
		var IMG = new ImageIcon("/home/rony/Pictures/wow_city.jpg").getImage();
		//ImageIcon home_imgIcon = new ImageIcon(new ImageIcon("/home/rony/Pictures/wow_city.jpg").getImage().getScaledInstance(900,550,Image.SCALE_DEFAULT));
		IMG = this.getScaledImage(IMG,900,550);
		
		var home_imgIcon = new ImageIcon(IMG);
		
		img_label = new JLabel(home_imgIcon);
		img_label.setBounds(0,0,900,550);
		
		hello_label.setBounds(0,45,400,35);
		hello_label.setFont(new Font(null,Font.PLAIN,35));
		hello_label.setForeground(Color.white);
		hello_label.setText("Hello user "+usr_home.USER);// user name
		
		this.setPreferredSize(new Dimension(900,550));
		this.setBackground(Color.yellow);
		this.setLayout(null);
		this.add(hello_label);
		this.add(img_label);
	}
	private Image getScaledImage(Image srcImg, int w, int h){
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
	
}
class browse_panel extends JPanel{ //  implements ChangeListener
	Object [][]nullRow = null;
	
	String columns_1[] = {"serial","ID","Name","Gender","ocupation","Email"};
	//String columns_2[] = {"ID","Name","Gender","ocupation","address","Contact","Email"};
	DefaultTableModel model_1 = new DefaultTableModel(nullRow,columns_1);
	//DefaultTableModel model_2 = new DefaultTableModel(nullRow,columns_2);
	JTable table; 
	JScrollPane scroll_pane;
	JLabel search_label;
	JButton btn1;
	JPanel sub_panel_1;
	JComboBox Gender_select,job_select;
	browse_panel(){
		search_label = new JLabel("Search based on Attribute:");
		search_label.setBounds(260,60,280,50);
		search_label.setFont(new Font(null,Font.PLAIN,20));
		
		JLabel gender_label = new JLabel("Gender");
		gender_label.setBounds(690,30,65,20);
		
		String []give_gender = {"All","Male","Female"};
		Gender_select = new JComboBox(give_gender);
		Gender_select.setBounds(680,60,80,50);
		
		JLabel job_label = new JLabel("Designation");
		job_label.setBounds(787,30,95,20);
		
		String []give_job = {"All","Business","Student","Govt","Freelance","others"};
		job_select = new JComboBox(give_job);
		job_select.setBounds(780,60,100,50);
		
		String key = "";
		String single_row[] = new String[6];
		int i =1;
		Iterator<String> itr = usr_home.usr_data_from_persons.usrs.keySet().iterator();
		while(itr.hasNext()){
			key = itr.next();
			single_row[0] = String.valueOf(i);
			single_row[1]= key;
			single_row[2]= usr_home.usr_data_from_persons.usrs_name.get(key);
			single_row[3]= usr_home.usr_data_from_persons.usrs_gender.get(key);
			single_row[4]= usr_home.usr_data_from_persons.usrs_job.get(key);
			single_row[5]= usr_home.usr_data_from_persons.usrs_mail.get(key);
			model_1.addRow(single_row);
			i++;
		}
		
		table = new JTable(model_1){
				public boolean isCellEditable(int data,int columns){
					return false;
				}
				public Component prepareRenderer(TableCellRenderer r,int data,int columns){
					//      awt                           swing.table
					Component c = super.prepareRenderer(r,data,columns);
			
					if(data%2 ==0){
						c.setBackground(Color.white);
					}else{
						c.setBackground(Color.yellow);
					}if(isCellSelected(data,columns)){
						c.setBackground(Color.yellow);
					}
						return c;	
				}
		};
		
		table.setPreferredScrollableViewportSize(new Dimension(600,100));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		
		scroll_pane = new JScrollPane(table);
		
		sub_panel_1 = new JPanel();
		sub_panel_1.setBounds(0,150,900,250);
		sub_panel_1.setBackground(Color.green);
		sub_panel_1.setLayout(new BorderLayout());
		sub_panel_1.add(scroll_pane);
		//sub_panel_1.repaint();
		
		btn1 = new JButton("look up");
		btn1.setBounds(540,60,100,50);
		btn1.setVisible(true);
		btn1.setFocusable(false);
		btn1.setContentAreaFilled(false);
		btn1.setBackground(Color.yellow);
		btn1.setBorder(new LineBorder(Color.black));
		btn1.setFont(new Font("tahoma",Font.BOLD,16));
		btn1.setFocusPainted(false);
		btn1.setOpaque(true);
		
		ButtonModel b_model = btn1.getModel(); 
		b_model.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(b_model.isPressed()){
						btn1.setBackground(Color.blue);
						btn1.setForeground(Color.yellow);
						String s = "\"s\"";
						System.out.println(s);
					}else if(b_model.isRollover()){
						btn1.setBackground(new Color(255,165,0));
						btn1.setForeground(Color.white);
					}else {
						btn1.setBackground(Color.yellow);
						btn1.setForeground(Color.black);
					}
				}
			});
		btn1.addActionListener(new ActionListener(){
				String getGender;
				String getJob;
				boolean  Fflag, Mflag;
				public void actionPerformed(ActionEvent event){
					getGender = Gender_select.getSelectedItem().toString();
					getJob = job_select.getSelectedItem().toString();
					Fflag = true; Mflag = true;
					System.out.println(getGender+" "+getJob+" "+Mflag+" "+Fflag);
					//boolean Fflag = true, Mflag = true;
					if(getGender.equals("Female"))Mflag = false;
					if(getGender.equals("Male"))Fflag = false;
					model_1.setRowCount(0);
					String key = "";
					String is_gender = "";
					String is_job = "";
					String single_row[] = new String[6];
					int z= 1;
					// so i need an iteerator ..."ID","Name","Gender","ocupation","Email"
					Iterator<String> itr = usr_home.usr_data_from_persons.usrs.keySet().iterator();
					while(itr.hasNext()){
						key = itr.next();
						single_row[0] = String.valueOf(z);
						single_row[1] = key;
						single_row[2] = usr_home.usr_data_from_persons.usrs_name.get(key);
						is_gender =  usr_home.usr_data_from_persons.usrs_gender.get(key);
						single_row[3] = is_gender;
						is_job = usr_home.usr_data_from_persons.usrs_job.get(key);
						single_row[4] = is_job;
						single_row[5] = usr_home.usr_data_from_persons.usrs_mail.get(key);
						if(getGender.equals("All") && getJob.equals("All")){
							model_1.addRow(single_row);
							z++;
						}else if(getGender.equals("All") && is_job.equals(getJob)){
							model_1.addRow(single_row);
							z++;
						}
						else if(is_gender.equals("Female") && getJob.equals("All") && Fflag==true){
							model_1.addRow(single_row);
							z++;
						}else if(is_gender.equals("Male") && getJob.equals("All") && Mflag==true){
							model_1.addRow(single_row);
							z++;
						}else if(is_gender.equals(getGender) && is_job.equals(getJob)){
							model_1.addRow(single_row);
							z++;
						}
						
						//model_1.addRow(single_row);
					}
				}
			});
		
		this.setPreferredSize(new Dimension(900,550));
		this.setBackground(Color.yellow);
		this.setLayout(null);
		this.setVisible(false);
		this.add(btn1);
		this.add(search_label);
		this.add(gender_label);
		this.add(Gender_select);
		this.add(job_label);
		this.add(job_select);
		this.add(sub_panel_1);
		//this.repaint();
	}
}
class profile_panel extends JPanel implements ActionListener{
	JLabel name_box;
	JLabel id_box;
	JLabel gender_box;
	JLabel address_box;
	JLabel email_box;
	JLabel age_box;
	JLabel grp_box;
	JLabel doner_box;
	JLabel member_box;
	JLabel log_box;
	
	JButton update_btn;
	static Date currentLogTime;
	
	profile_panel(){
		JLabel userName_tag = new JLabel("User Name:");
		JLabel userID_tag = new JLabel("User ID:");
		JLabel userGender_tag = new JLabel("Gender:");
		JLabel userAdd_tag = new JLabel("User Location:");
		JLabel userEmail_tag = new JLabel("User Email:");
		JLabel userActualAddress =  new JLabel("User Address:");
		JLabel userBio_tag =  new JLabel("User BIO:");
		JLabel age_tag = new JLabel("User Age:");
		JLabel blood_tag = new JLabel("Blood Group:");
		JLabel doner_tag = new JLabel("Doner:");
		JLabel member_tag = new JLabel("Member Since:");
		JLabel last_login_tag = new JLabel("Last logged in:");
		
		//usr_home.usr_data_from_persons.usrs_doner.get(usr_home.USER);
		String NAW = usr_home.usr_data_from_persons.usrs_actual_address.get(usr_home.USER);
		if(NAW==null)NAW ="N/A";
		JTextArea add_text =  new JTextArea(NAW);
		NAW =usr_home.usr_data_from_persons.usrs_bio.get(usr_home.USER);
		if(NAW==null)NAW ="N/A";
		JTextArea add_bio = new JTextArea(NAW);
		
		userName_tag.setBounds(20,20,110,50);
		userID_tag.setBounds(20,70,80,50);
		userGender_tag.setBounds(20,120,80,50);
		userAdd_tag.setBounds(20,170,135,50);
		userEmail_tag.setBounds(20,210,105,50);
		userActualAddress.setBounds(20,260,130,50);
		add_text.setBounds(20,310,600,40);
		userBio_tag.setBounds(20,350,105,50);
		
		JScrollPane txtScroll = new JScrollPane(add_bio);
		txtScroll.setBounds(20,400,600,60);
		age_tag.setBounds(500,20,110,50);
		blood_tag.setBounds(500,70,130,50);
		doner_tag.setBounds(500,120,100,50);
		member_tag.setBounds(500,170,160,50);
		last_login_tag.setBounds(500,210,160,50);
		
		userName_tag.setFont(new Font(null,Font.BOLD,16));
		userID_tag.setFont(new Font(null,Font.BOLD,16));
		userGender_tag.setFont(new Font(null,Font.BOLD,16));
		userAdd_tag.setFont(new Font(null,Font.BOLD,16));
		userEmail_tag.setFont(new Font(null,Font.BOLD,16));
		userActualAddress.setFont(new Font(null,Font.BOLD,16));
		add_text.setFont(new Font(null,Font.BOLD,16));
		userBio_tag.setFont(new Font(null,Font.BOLD,16));
		add_bio.setFont(new Font(null,Font.BOLD,16));
		age_tag.setFont(new Font(null,Font.BOLD,16));
		blood_tag.setFont(new Font(null,Font.BOLD,16));
		doner_tag.setFont(new Font(null,Font.BOLD,16));
		member_tag.setFont(new Font(null,Font.BOLD,16));
		last_login_tag.setFont(new Font(null,Font.BOLD,16));
		
		userName_tag.setBackground(Color.white);
		userID_tag.setBackground(Color.white);
		userGender_tag.setBackground(Color.white);
		userEmail_tag.setBackground(Color.white);
		userActualAddress.setBackground(Color.white);
		add_text.setBackground(Color.yellow);
		userBio_tag.setBackground(Color.white);
		add_bio.setBackground(Color.yellow);
		age_tag.setBackground(Color.white);
		blood_tag.setBackground(Color.white);
		doner_tag.setBackground(Color.white);
		member_tag.setBackground(Color.white);
		last_login_tag.setBackground(Color.white);
		
		name_box = new JLabel(usr_home.usr_data_from_persons.usrs_name.get(usr_home.USER));//usr_data_from_persons.usrs()
		id_box = new JLabel(usr_home.USER);
		gender_box = new JLabel(usr_home.usr_data_from_persons.usrs_gender.get(usr_home.USER));
		address_box = new JLabel(usr_home.usr_data_from_persons.usrs_address.get(usr_home.USER));
		email_box = new JLabel(usr_home.usr_data_from_persons.usrs_mail.get(usr_home.USER));
		
		String NA = usr_home.usr_data_from_persons.usrs_age.get(usr_home.USER);
		if(NA == null){
			NA = "N/A";
		}
		age_box = new JLabel(NA);
		grp_box = new JLabel(usr_home.usr_data_from_persons.usrs_blood_grp.get(usr_home.USER));
		NA = (String)usr_home.usr_data_from_persons.usrs_doner.get(usr_home.USER);
		System.out.println(NA);
		
		
		doner_box = new JLabel();
		if(NA==null){
			NA = "N/A";
			doner_box.setText(NA);
			
		}
		else if(NA.equals("Yes")) 
		{
			NA = "Active";
			doner_box.setText(NA);
			doner_box.setForeground(new Color(38,216,38));
		}
		else if(NA.equals("No")){
			 NA = "Inactive";
			doner_box.setText(NA);
			doner_box.setForeground(Color.red);//30,210,30
		}
		
		Date c1 = usr_home.usr_data_from_persons.usrs_sign_time.get(usr_home.USER);
		String signDate = new SimpleDateFormat("dd-MMMM-yyyy").format(c1);
		member_box = new JLabel(signDate);//signDate
		Date c2 = usr_home.usr_data_from_persons.usrs_log_time.get(usr_home.USER);
		signDate = new SimpleDateFormat("dd-MMMM-yyyy").format(c2);
		log_box = new JLabel(signDate);//signDate
		
		name_box.setBounds(130,20,300,50);
		name_box.setHorizontalAlignment(JLabel.RIGHT);
		id_box.setBounds(100,70,330,50);
		id_box.setHorizontalAlignment(JLabel.RIGHT);
		gender_box.setBounds(100,120,330,50);
		gender_box.setHorizontalAlignment(JLabel.RIGHT);
		address_box.setBounds(155,170,275,50);
		address_box.setHorizontalAlignment(JLabel.RIGHT);
		email_box.setBounds(125,210,305,50);
		email_box.setHorizontalAlignment(JLabel.RIGHT);
		age_box.setBounds(730,20,100,50);
		grp_box.setBounds(750,70,80,50);
		doner_box.setBounds(720,120,110,50);
		member_box.setBounds(630,170,200,50);
		log_box.setBounds(630,210,200,50);
		
		name_box.setFont(new Font(null,Font.BOLD,16));
		id_box.setFont(new Font(null,Font.BOLD,16));
		gender_box.setFont(new Font(null,Font.BOLD,16));
		address_box.setFont(new Font(null,Font.BOLD,16));
		email_box.setFont(new Font(null,Font.BOLD,16));
		age_box.setFont(new Font(null,Font.BOLD,16));
		grp_box.setFont(new Font(null,Font.BOLD,16));
		doner_box.setFont(new Font(null,Font.BOLD,16));
		member_box.setFont(new Font(null,Font.BOLD,16));
		log_box.setFont(new Font(null,Font.BOLD,16));
				
		name_box.setBackground(Color.green);
		id_box.setBackground(Color.green);
		gender_box.setBackground(Color.green);
		address_box.setBackground(Color.green);
		email_box.setBackground(Color.green);
		age_box.setBackground(Color.green);
		grp_box.setBackground(Color.green);
		doner_box.setBackground(Color.green);
		member_box.setBackground(Color.green);
		log_box.setBackground(Color.green);
		
		age_box.setHorizontalAlignment(JLabel.RIGHT);
		grp_box.setHorizontalAlignment(JLabel.RIGHT);
		doner_box.setHorizontalAlignment(JLabel.RIGHT);
		member_box.setHorizontalAlignment(JLabel.RIGHT);
		log_box.setHorizontalAlignment(JLabel.RIGHT);
		
		add_text.setBorder(new BevelBorder(0,Color.black,Color.black));
		add_bio.setBorder(new BevelBorder(0,Color.black,Color.black));
		
		add_text.setLineWrap(true);
		add_text.setWrapStyleWord(true);
		add_text.setEditable(false);
		add_text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		add_bio.setLineWrap(true);
		add_bio.setWrapStyleWord(true);add_bio.setLineWrap(true);
		add_bio.setWrapStyleWord(true);
		add_bio.setEditable(false);
		add_bio.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		update_btn = new JButton("UPDATE");
		update_btn.setBounds(705,410,150,50);
		update_btn.setFocusable(false);
		update_btn.setForeground(Color.black);
		update_btn.setContentAreaFilled(false);
		update_btn.setBackground(Color.yellow);
		update_btn.setBorder(new LineBorder(Color.black));
		update_btn.setFont(new Font("tahoma",Font.BOLD,16));
		update_btn.setFocusPainted(false);
		update_btn.setOpaque(true);
		ButtonModel back_model = update_btn.getModel();
		back_model.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(back_model.isPressed()){
						update_btn.setBackground(Color.blue);
						update_btn.setForeground(Color.yellow);
					}else if(back_model.isRollover()){
						update_btn.setBackground(new Color(255,165,0));
						update_btn.setForeground(Color.white);
					}else {
						update_btn.setBackground(Color.yellow);
						update_btn.setForeground(Color.black);
					}
				}
			});
		update_btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
						JFrame fe = new JFrame("UPDATE");
						
						String id = usr_home.USER;
						
						JLabel err_arrow = new JLabel("Error-->");
						err_arrow.setBounds(70,10,100,30);
						err_arrow.setForeground(Color.red);
						err_arrow.setFont(new Font(null,Font.BOLD,20));
						//err_arrow.setOpaque(true);
						err_arrow.setVisible(false);
						
						JLabel disply = new JLabel();
						disply.setBounds(0,445,600,80);
						disply.setBackground(Color.yellow);
						disply.setForeground(Color.red);
						disply.setHorizontalAlignment(JLabel.CENTER);
						disply.setFont(new Font(null,Font.BOLD,22));
						disply.setOpaque(true);
						
						JLabel age_lb = new JLabel("Age");
						age_lb.setBounds(170,10,100,30);
						age_lb.setBackground(Color.yellow);
						age_lb.setFont(new Font("tahoma",Font.BOLD,16));
						age_lb.setOpaque(true);
						age_lb.setBorder(new LineBorder(Color.black));
						
						JLabel op_lb1 = new JLabel("Optional");
						op_lb1.setBounds(470,10,100,30);
						op_lb1.setForeground(Color.yellow);
						op_lb1.setHorizontalAlignment(JLabel.CENTER);
						op_lb1.setFont(new Font("tahoma",Font.BOLD,14));
						//op_lb1.setOpaque(true);
						
						
						JTextField age_tx = new JTextField();
						age_tx.setText(usr_home.usr_data_from_persons.usrs_age.get(id));
						age_tx.setBounds(270,10,200,30);
						age_tx.setBackground(Color.white);
						age_tx.setFont(new Font("tahoma",Font.BOLD,16));
						age_tx.setOpaque(true);
						age_tx.setBorder(new LineBorder(Color.black));
						
						
						JLabel loc_lb = new JLabel("Location:");
						loc_lb.setBounds(170,50,100,30);
						loc_lb.setBackground(Color.yellow);
						loc_lb.setFont(new Font("tahoma",Font.BOLD,16));
						loc_lb.setOpaque(true);
						loc_lb.setBorder(new LineBorder(Color.black));
						
						String locs[] = {"","ECB","FarmGate","DOHS-Mirpur","Uttora","Motijhil","MogBazar","Dhanmondi"};
						JComboBox loc_cmbox = new JComboBox(locs); 
						loc_cmbox.setBounds(270,50,200,30);
						loc_cmbox.setSelectedItem(usr_home.usr_data_from_persons.usrs_address.get(id));
						loc_cmbox.setFont(new Font(null,Font.BOLD,16));
						loc_cmbox.setBackground(Color.white);
						
						
						JLabel op_lb3 = new JLabel("Optional");
						op_lb3.setBounds(470,100,100,30);
						op_lb3.setForeground(Color.yellow);
						op_lb3.setHorizontalAlignment(JLabel.CENTER);
						op_lb3.setFont(new Font("tahoma",Font.BOLD,14));
						//op_lb1.setOpaque(true);
						
						JLabel add_lb = new JLabel("address:");
						add_lb.setBounds(170,100,100,30);
						add_lb.setBackground(Color.yellow);
						add_lb.setFont(new Font("tahoma",Font.BOLD,16));
						add_lb.setOpaque(true);
						add_lb.setBorder(new LineBorder(Color.black));
						
						JTextField add_tx = new JTextField(); 
						add_tx.setBounds(270,100,200,30);
						add_tx.setText(usr_home.usr_data_from_persons.usrs_actual_address.get(id));
						add_tx.setFont(new Font(null,Font.BOLD,12));
						add_tx.setBackground(Color.white);
						
						
						JLabel phn_lb = new JLabel("Phone:");
						phn_lb.setBounds(170,150,100,30);
						phn_lb.setBackground(Color.yellow);
						phn_lb.setFont(new Font("tahoma",Font.BOLD,16));
						phn_lb.setOpaque(true);
						phn_lb.setBorder(new LineBorder(Color.black));
						
						JTextField phn_tx = new JTextField(); 
						phn_tx.setBounds(270,150,200,30);
						phn_tx.setText(usr_home.usr_data_from_persons.usrs_phone.get(id));
						phn_tx.setFont(new Font(null,Font.BOLD,16));
						phn_tx.setBackground(Color.white);
						
						JLabel mail_lb = new JLabel("E-mail:");
						mail_lb.setBounds(170,200,100,30);
						mail_lb.setBackground(Color.yellow);
						mail_lb.setFont(new Font("tahoma",Font.BOLD,16));
						mail_lb.setOpaque(true);
						mail_lb.setBorder(new LineBorder(Color.black));
						
						JTextField mail_tx = new JTextField(); 
						mail_tx.setBounds(270,200,200,30);//260
						mail_tx.setText(usr_home.usr_data_from_persons.usrs_mail.get(id));
						mail_tx.setFont(new Font(null,Font.BOLD,12));
						mail_tx.setBackground(Color.white);
						
						JLabel bio_lb = new JLabel("BIO:");
						bio_lb.setBounds(170,250,70,30); //200
						bio_lb.setBackground(Color.yellow);
						bio_lb.setFont(new Font("tahoma",Font.BOLD,16));
						bio_lb.setOpaque(true);
						bio_lb.setBorder(new LineBorder(Color.black));
						
						JTextArea bio_tx = new JTextArea(); 
					//	bio_tx.setBounds(170,280,300,70);//320
						bio_tx.setText(usr_home.usr_data_from_persons.usrs_bio.get(id));
						bio_tx.setFont(new Font(null,Font.BOLD,16));
						bio_tx.setBackground(Color.white);
						bio_tx.setBorder(new LineBorder(Color.black));
						bio_tx.setLineWrap(true);
						bio_tx.setWrapStyleWord(true);
						
						JScrollPane txtScroll = new JScrollPane(bio_tx);
						txtScroll.setBounds(170,280,300,70);
						
						JLabel op_lb2 = new JLabel("Optional");
						op_lb2.setBounds(470,300,100,30);
						op_lb2.setForeground(Color.yellow);
						op_lb2.setHorizontalAlignment(JLabel.CENTER);
						op_lb2.setFont(new Font("tahoma",Font.BOLD,14));
						//op_lb2.setOpaque(true);
						
						JButton cfm_btn = new JButton("Confirm");
						cfm_btn.setBounds(170,380,100,30);
						cfm_btn.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event){
									boolean flag = true;
									String getAge = age_tx.getText();
									String getLoc = String.valueOf(loc_cmbox.getSelectedItem());
									String getPhn = phn_tx.getText();
									String getMail = mail_tx.getText();
									String getBio = bio_tx.getText();
									String getAdd = add_tx.getText();
									
									
									err_arrow.setBackground(Color.red);
									System.out.println("cfm: "+getAge+" "+getLoc+" "+getPhn+" "+getMail+" "+getBio);
									int age = 0;
									if(getAge.equals("")==false){
										try{
											age = Integer.parseInt(getAge);
											System.out.println("age "+getAge);
										}catch(Exception e){
											//System.out.println(e);
											flag = false;
											disply.setText("INVALID AGE");
											err_arrow.setBounds(70,50,100,30);
											err_arrow.setVisible(true);
											
											//err_arrow.setOpaque(true);
										}
									}
									if(getAge.equals("")==false && age<18){
										flag = false;
										disply.setText("AGE IS SET TOO LOW");
										err_arrow.setBounds(70,10,100,30);
										err_arrow.setVisible(true);
									}else if(age>90){
										flag = false;
										disply.setText("AGE IS SET TOO HIGH");
										err_arrow.setBounds(70,10,100,30);
										err_arrow.setVisible(true);
									}
									if(getLoc.equals("")){
										flag = false;
										disply.setText("LOCATION MUST BE SELECTED");
										err_arrow.setBounds(70,50,100,30);
										err_arrow.setVisible(true);
									}if(!Sign.checkPhone(getPhn)){
										flag = false;
										disply.setText("INVALID PHONE NUMBER");
										err_arrow.setBounds(70,150,100,30);
										err_arrow.setVisible(true);
									}if(!Sign.checkMail(getMail)){
										flag = false;
										disply.setText("INVALID MAIL ADDRESS");
										err_arrow.setBounds(70,200,100,30);
										err_arrow.setVisible(true);
									}
									if(flag ==true){
										System.out.println("flag "+flag+" getAge "+age);
										usr_home.usr_data_from_persons.usrs_age.replace(usr_home.USER,String.valueOf(age));
										System.out.println(usr_home.usr_data_from_persons.usrs_age.get(usr_home.USER));
										usr_home.usr_data_from_persons.usrs_address.replace(usr_home.USER,getLoc);
										usr_home.usr_data_from_persons.usrs_phone.replace(usr_home.USER,getPhn);
										usr_home.usr_data_from_persons.usrs_mail.replace(usr_home.USER,getMail);
										usr_home.usr_data_from_persons.usrs_bio.replace(usr_home.USER,getBio);
										usr_home.usr_data_from_persons.usrs_actual_address.replace(usr_home.USER,getAdd);
										err_arrow.setBackground(Color.green);
										disply.setText("PROFILE UPDATED");
									}
									
								}
							});
						
						
						JButton cnl_btn = new JButton("Cancel");
						cnl_btn.setBounds(270,380,100,30);
						cnl_btn.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event){
									fe.dispose();
								}
							});
						
						JButton rst_btn = new JButton("Reset");
						rst_btn.setBounds(370,380,100,30);
						rst_btn.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event){
									age_tx.setText("");
									phn_tx.setText("");
									mail_tx.setText("");
									err_arrow.setVisible(false);
									disply.setText("");
								}
							});
						
						
						
						
						fe.setSize(600,550);
						fe.setVisible(true);
						fe.setLayout(null);
						fe.setLocationRelativeTo(null);
						fe.getContentPane().setBackground(new Color(68,133,227));
						
						fe.add(op_lb1);
						fe.add(op_lb2);
						fe.add(op_lb3);
						fe.add(disply);
						fe.add(age_lb);
						fe.add(age_tx);
						
						fe.add(loc_cmbox);
						fe.add(loc_lb);
						fe.add(add_lb);
						fe.add(add_tx);
						fe.add(phn_lb);
						fe.add(phn_tx);
						fe.add(mail_lb);
						fe.add(mail_tx);
						fe.add(bio_lb);
						fe.add(txtScroll);
						//fe.add(bio_tx);
						fe.add(cfm_btn);
						fe.add(rst_btn);
						fe.add(cnl_btn);
						fe.add(err_arrow);
						
				}
			});
		
		JLabel hor_line = new JLabel();
		hor_line.setBounds(0,260,900,2);
		hor_line.setBackground(Color.blue);
		hor_line.setOpaque(true);
		
		JLabel var_line1 = new JLabel();
		var_line1.setBounds(450,0,2,261);
		var_line1.setBackground(Color.blue);
		var_line1.setOpaque(true);
		
		JLabel var_line2 = new JLabel();
		var_line2.setBounds(680,30,2,200);
		var_line2.setBackground(Color.blue);
		var_line2.setOpaque(true);
		
		JLabel var_line3 = new JLabel();
		var_line3.setBounds(660,260,2,220);
		var_line3.setBackground(Color.blue);
		var_line3.setOpaque(true);
		
		JTextArea update_txt = new JTextArea();
		update_txt.setBounds(680,270,205,120);
		update_txt.setBackground(Color.yellow);
		update_txt.setForeground(Color.black);
		update_txt.setBorder(new BevelBorder(0,Color.black,Color.black));
		update_txt.setEditable(false);
		update_txt.setFont(new Font(null,Font.BOLD,16));
		update_txt.append("  .Changes & Update.\n");
		update_txt.append(" 1.Location & Address\n");
		update_txt.append(" 2.Age\n");
		update_txt.append(" 3.Phone Number\n");
		update_txt.append(" 4.E-Mail\n");
		update_txt.append(" 5.BIO\n");
		
		this.setPreferredSize(new Dimension(900,550));
		this.setBackground(Color.yellow);
		this.setLayout(null);
		this.setVisible(false);
		
		this.add(update_txt);
		this.add(hor_line);
		this.add(var_line1);
		this.add(var_line2);
		this.add(var_line3);
		this.add(userName_tag);this.add(age_tag);
		this.add(userID_tag);this.add(blood_tag);
		this.add(userGender_tag);this.add(doner_tag);
		this.add(userAdd_tag);this.add(member_tag);
		this.add(userEmail_tag);
		this.add(last_login_tag);
		this.add(name_box);
		this.add(id_box);
		this.add(gender_box);
		this.add(address_box);
		this.add(email_box);
		this.add(age_box);
		this.add(grp_box);
		this.add(doner_box);
		this.add(member_box);
		this.add(userActualAddress);
		this.add(add_text);
		this.add(userBio_tag);
		this.add(txtScroll);
		this.add(log_box);
		this.add(update_btn);
		
	}
	@Override
	public void actionPerformed(ActionEvent event){
		
	}
}
class Necessity_panel extends JPanel{
	DefaultTableModel blood_model;
	JTable blood_table; 
	JScrollPane blood_scroll_pane;
	JPanel blood_panel;
	JPanel need_panel;
	
	Necessity_panel(){
		
		JLabel emergency_header_label = new JLabel("<HTML><U>EMERGENCY CONTACT:</U></HTML>");
		emergency_header_label.setBounds(50,50,300,35);
		emergency_header_label.setBackground(Color.white);
		emergency_header_label.setVerticalAlignment(JLabel.TOP);
		//emergency_header_label.setOpaque(true);
		emergency_header_label.setFont(new Font(null,Font.PLAIN,25));
		
		JLabel blood_donation_label = new JLabel("<HTML><U>BLOOD DONATION:</U></HTML>");
		blood_donation_label.setBounds(620,50,250,35);
		blood_donation_label.setBackground(Color.white);
		blood_donation_label.setVerticalAlignment(JLabel.TOP);
		//blood_donation_label.setOpaque(true);
		blood_donation_label.setFont(new Font(null,Font.PLAIN,25));
		
		JLabel fireSerice_label_1 = new JLabel("Fire Service:                                 +8801730002232,");
		fireSerice_label_1.setBounds(50,85,500,50);
		fireSerice_label_1.setBackground(Color.white);
		fireSerice_label_1.setVerticalAlignment(JLabel.TOP);
		//fireSerice_label_1.setOpaque(true);
		fireSerice_label_1.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel fireSerice_label_2 = new JLabel("029001055.");
		fireSerice_label_2.setBounds(418,105,105,30);
		fireSerice_label_2.setBackground(Color.yellow);
		fireSerice_label_2.setVerticalAlignment(JLabel.TOP);
		//fireSerice_label_2.setOpaque(true);
		fireSerice_label_2.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel police_label_1 = new JLabel("Police:                                          +8801769690033,");
		police_label_1.setBounds(50,135,500,50);
		police_label_1.setBackground(Color.lightGray);
		police_label_1.setVerticalAlignment(JLabel.TOP);
		//police_label_1.setOpaque(true);
		police_label_1.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel police_label_2 = new JLabel("+8801320001299.");
		police_label_2.setBounds(360,155,180,25);
		police_label_2.setBackground(Color.red);
		police_label_2.setVerticalAlignment(JLabel.TOP);
		//police_label_2.setOpaque(true);
		police_label_2.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel ambulance_label_1 = new JLabel("Ambulance:");//+8801777155548,
		ambulance_label_1.setBounds(50,185,500,80);
		ambulance_label_1.setBackground(Color.lightGray);
		ambulance_label_1.setVerticalAlignment(JLabel.TOP);
		//ambulance_label_1.setOpaque(true);
		ambulance_label_1.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel num_label_1 = new JLabel("+8801777155548,");
		num_label_1.setBounds(360,185,180,25);
		num_label_1.setBackground(Color.red);
		num_label_1.setVerticalAlignment(JLabel.TOP);
		//num_label_1.setOpaque(true);
		num_label_1.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel ambulance_label_2 = new JLabel("+8801917381406,");
		ambulance_label_2.setBounds(360,205,180,25);
		ambulance_label_2.setBackground(Color.red);
		ambulance_label_2.setVerticalAlignment(JLabel.TOP);
		//ambulance_label_2.setOpaque(true);
		ambulance_label_2.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel ambulance_label_3 = new JLabel("+8801714325325.");
		ambulance_label_3.setBounds(360,225,180,25);
		ambulance_label_3.setBackground(Color.yellow);
		ambulance_label_3.setVerticalAlignment(JLabel.TOP);
		//ambulance_label_3.setOpaque(true);
		ambulance_label_3.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel all_needs_label = new JLabel("General Purpose:                                               999.");//+8801777155548,
		all_needs_label.setBounds(50,265,475,20);
		all_needs_label.setBackground(new Color(244,24,244));
		all_needs_label.setVerticalAlignment(JLabel.TOP);
		all_needs_label.setOpaque(true);
		all_needs_label.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel seperator_label = new JLabel();
		seperator_label.setBounds(580,0,3,550);
		seperator_label.setBackground(Color.blue);
		seperator_label.setOpaque(true);
		
		JLabel user_id_label = new JLabel("User ID:");
		user_id_label.setBounds(620,85,80,35);
		user_id_label.setBackground(Color.white);
		user_id_label.setVerticalAlignment(JLabel.TOP);
		//user_id_label.setOpaque(true);
		user_id_label.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel id_label = new JLabel(usr_home.USER);
		id_label.setBounds(700,85,200,35);
		id_label.setBackground(Color.lightGray);
		id_label.setVerticalAlignment(JLabel.TOP);
		//id_label.setOpaque(true);
		id_label.setFont(new Font(null,Font.PLAIN,18));
		
		JLabel user_status_label = new JLabel("Current status:");
		user_status_label.setBounds(620,120,140,35);
		user_status_label.setBackground(Color.white);
		user_status_label.setVerticalAlignment(JLabel.TOP);
		//user_status_label.setOpaque(true);
		user_status_label.setFont(new Font(null,Font.PLAIN,18));
		
		String NA = usr_home.usr_data_from_persons.usrs_doner.get(usr_home.USER);
		
		JLabel show_user_status_label = new JLabel();
		if(NA==null){
			NA ="N/A";
		}
		else if(NA.equals("Yes")){
			NA = "Active";
			show_user_status_label.setForeground(new Color(30,210,30));// active green new Color(30,210,30)
		}
		else {
			NA = "Inactive";
			show_user_status_label.setForeground(Color.red);
		}
		show_user_status_label.setBounds(760,120,100,35);
		show_user_status_label.setText(NA); 
		show_user_status_label.setBackground(Color.lightGray);
		show_user_status_label.setVerticalAlignment(JLabel.TOP);
		//show_user_status_label.setOpaque(true);
		show_user_status_label.setFont(new Font("tahoma",Font.BOLD,18));
		
		JLabel blood_search_seperator_label = new JLabel();
		blood_search_seperator_label.setBounds(580,190,320,2);
		blood_search_seperator_label.setBackground(Color.blue);
		blood_search_seperator_label.setOpaque(true);
		
		JLabel blood_search_label = new JLabel("<HTML><U>SEARCH DONAR:</U></HTML>");
		blood_search_label.setBounds(620,200,250,35);
		blood_search_label.setBackground(Color.white);
		blood_search_label.setVerticalAlignment(JLabel.TOP);
		//blood_search_label.setOpaque(true);
		blood_search_label.setFont(new Font(null,Font.PLAIN,25));
		
		JLabel gender_label = new JLabel("Location:");
		gender_label.setBounds(620,235,250,20);
		gender_label.setBackground(Color.white);
		gender_label.setVerticalAlignment(JLabel.TOP);
		//gender_label.setOpaque(true);
		gender_label.setFont(new Font(null,Font.PLAIN,18));
		
		
		String gen[] = {"All","ECB","FarmGate","DOHS-Mirpur","Uttora","Motijhil","MogBazar","Dhanmondi"};
		
		JComboBox doner_gen_box = new JComboBox(gen);
		doner_gen_box.setBounds(750,235,100,20); // 620,255,100,20
		
		JLabel blood_grp_label = new JLabel("Blood Group:");
		blood_grp_label.setBounds(620,280,250,20);
		blood_grp_label.setBackground(Color.white);
		blood_grp_label.setVerticalAlignment(JLabel.TOP);
		//blood_grp_label.setOpaque(true);
		blood_grp_label.setFont(new Font(null,Font.PLAIN,18));
		
		String grp[] = {"All","AB+ve","AB-ve","A+ve","A-ve","B+ve","B-ve","O+ve","O-ve"};
		JComboBox doner_grp_box = new JComboBox(grp);
		doner_grp_box.setBounds(750,280,100,20);//620,300,100,20
		
		JLabel donar_status_label = new JLabel("Donar status:");
		donar_status_label.setBounds(620,325,250,20);
		donar_status_label.setBackground(Color.white);
		donar_status_label.setVerticalAlignment(JLabel.TOP);
		//donar_status_label.setOpaque(true);
		donar_status_label.setFont(new Font(null,Font.PLAIN,18));
		
		String stats[] = {"All","Active","Inactive"};
		JComboBox doner_stat_box = new JComboBox(stats);
		doner_stat_box.setBounds(750,325,100,20); //620,345,100,20
		
		String doner_data_column[] = {"Serial","ID","Name","Blood","Doner","Gender","Location","Email"};
		
		blood_model = new DefaultTableModel(null,doner_data_column);
		
		String key = "";
		String stats_d ="";
		String single_row[] = new String[8];
		//// so i need an iteerator ..."ID","Name","Blood","Status","Gender","Location","Email" ---- 6 fields
		Iterator<String> itr = usr_home.usr_data_from_persons.usrs.keySet().iterator();
		int x =1;
		while(itr.hasNext()){
			key = itr.next();
			single_row[0] = String.valueOf(x);
			x++;
			single_row[1]= key;
			single_row[2]= usr_home.usr_data_from_persons.usrs_name.get(key);
			single_row[3]= usr_home.usr_data_from_persons.usrs_blood_grp.get(key);
			stats_d= usr_home.usr_data_from_persons.usrs_doner.get(key);
			if(stats_d.equals("Yes")){
				single_row[4] = "Active";
			}else{
				single_row[4] = "Inactive";
			}
			single_row[5]= usr_home.usr_data_from_persons.usrs_gender.get(key);
			single_row[6]= usr_home.usr_data_from_persons.usrs_address.get(key);
			single_row[7]= usr_home.usr_data_from_persons.usrs_mail.get(key);
			blood_model.addRow(single_row);
		}
		
		blood_table = new JTable(blood_model){
				public boolean isCellEditable(int data,int columns){
					return false;
				}
				public Component prepareRenderer(TableCellRenderer r,int data,int columns){
					//      awt                           swing.table
					Component c = super.prepareRenderer(r,data,columns);
			
					if(data%2 ==0){
						c.setBackground(Color.white);
					}else{
						c.setBackground(Color.yellow);
					}if(isCellSelected(data,columns)){
						c.setBackground(Color.yellow);
					}
						return c;	
				}		
		};
		
		blood_table.setPreferredScrollableViewportSize(new Dimension(900,300));
		blood_table.setFillsViewportHeight(true);
		blood_table.getTableHeader().setReorderingAllowed(false);
		
		blood_scroll_pane = new JScrollPane(blood_table);
		
		
		JButton need_back_btn = new JButton("<-GO Back");
		need_back_btn.setBounds(0,0,180,50);
		need_back_btn.setFocusable(false);
		need_back_btn.setContentAreaFilled(false);
		need_back_btn.setBackground(Color.yellow);
		need_back_btn.setBorder(new LineBorder(Color.black));
		need_back_btn.setFont(new Font("tahoma",Font.BOLD,16));
		need_back_btn.setFocusPainted(false);
		need_back_btn.setOpaque(true);
		ButtonModel back_model = need_back_btn.getModel();
		back_model.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(back_model.isPressed()){
						need_back_btn.setBackground(Color.blue);
						need_back_btn.setForeground(Color.yellow);
					}else if(back_model.isRollover()){
						need_back_btn.setBackground(new Color(255,165,0));
						need_back_btn.setForeground(Color.white);
					}else {
						need_back_btn.setBackground(Color.yellow);
						need_back_btn.setForeground(Color.black);
					}
				}
			});
		
		JPanel extra_panel = new JPanel();
		extra_panel.setBounds(0,0,900,50);
		extra_panel.setLayout(null);
		extra_panel.setBackground(Color.yellow);
		
		extra_panel.add(need_back_btn);
		
		blood_panel = new JPanel();
		blood_panel.setBounds(0,50,900,500);
		blood_panel.setBackground(Color.yellow);
		blood_panel.setLayout(new BorderLayout());
		blood_panel.add(blood_scroll_pane,BorderLayout.NORTH);
		
		need_panel = new JPanel();
		need_panel.setBounds(0,0,900,550);
		need_panel.setBackground(Color.yellow);
		need_panel.setLayout(null);
		need_panel.setVisible(true);
		//this.add(need_panel);
		
		
		JButton blood_btn = new JButton("look up");
		blood_btn.setBounds(690,380,100,50);
		blood_btn.setFocusable(false);
		blood_btn.setContentAreaFilled(false);
		blood_btn.setBackground(Color.yellow);
		blood_btn.setBorder(new LineBorder(Color.black));
		blood_btn.setFont(new Font("tahoma",Font.BOLD,16));
		blood_btn.setFocusPainted(false);
		blood_btn.setOpaque(true);
		ButtonModel b_model = blood_btn.getModel(); 
		
		
		b_model.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(b_model.isPressed()){
						blood_btn.setBackground(Color.blue);
						blood_btn.setForeground(Color.yellow);
					}else if(b_model.isRollover()){
						blood_btn.setBackground(new Color(255,165,0));
						blood_btn.setForeground(Color.white);
					}else {
						blood_btn.setBackground(Color.yellow);
						blood_btn.setForeground(Color.black);
					}
				}
			});
		blood_btn.addActionListener(new ActionListener(){
				String getGender,getGroup,getStatus;
				String isGender,isGroup,isStatus;
				@Override
				public void actionPerformed(ActionEvent event){
					getGender = String.valueOf(doner_gen_box.getSelectedItem());
					getGroup = String.valueOf(doner_grp_box.getSelectedItem());
					getStatus = String.valueOf(doner_stat_box.getSelectedItem());
					
					
					blood_model.setRowCount(0);
					String key = "";
					String stats ="";
					String single_row[] = new String[8];
					//// so i need an iteerator ..."ID","Name","Blood","Status","Gender","Location","Email" ---- 7 fields
					int i =1;
					Iterator<String> itr = usr_home.usr_data_from_persons.usrs.keySet().iterator();
					while(itr.hasNext()){
							key = itr.next();
							single_row[0] = String.valueOf(i);
							single_row[1]= key;
							single_row[2]= usr_home.usr_data_from_persons.usrs_name.get(key);
							single_row[3]= usr_home.usr_data_from_persons.usrs_blood_grp.get(key);
							isGroup =single_row[3];
							stats= usr_home.usr_data_from_persons.usrs_doner.get(key);
							if(stats.equals("Yes")){
								single_row[4] = "Active";
								isStatus =single_row[4];
							}else{
								single_row[4] = "Inactive";
								isStatus =single_row[4];
							}
							single_row[5]= usr_home.usr_data_from_persons.usrs_gender.get(key);
							//isGender =single_row[4];
							single_row[6]= usr_home.usr_data_from_persons.usrs_address.get(key);
							isGender = single_row[6];
							single_row[7]= usr_home.usr_data_from_persons.usrs_mail.get(key);
							
							if(getGender.equals("All") && getGroup.equals("All") && getStatus.equals("All")){
								i++;
								blood_model.addRow(single_row);
							}
							else if(getGender.equals(isGender) && getGroup.equals("All") && getStatus.equals("All")){
								blood_model.addRow(single_row);
								i++;
							}
							else if(getGender.equals("All") && getGroup.equals(isGroup) && getStatus.equals("All")){
								blood_model.addRow(single_row);
								i++;
							}
							else if(getGender.equals("All") && getGroup.equals("All") && getStatus.equals(isStatus)){
								blood_model.addRow(single_row);
								i++;
								
							}
							else if(getGender.equals(isGender) && getGroup.equals(isGroup) && getStatus.equals("All")){
								blood_model.addRow(single_row);
								i++;
							}
							else if(getGender.equals("All") && getGroup.equals(isGroup) && getStatus.equals(isStatus)){
								blood_model.addRow(single_row);
								i++;
							}
							else if(getGender.equals(isGender) && getGroup.equals("All") && getStatus.equals(isStatus)){
								blood_model.addRow(single_row);
								i++;
							}
							else if(getGender.equals(isGender) && getGroup.equals(isGroup) && getStatus.equals(isStatus)){
								blood_model.addRow(single_row);
								i++;
							}
							
					}
					
					//add(blood_panel);
					//add(extra_panel);
					
					need_panel.setVisible(false);
					blood_btn.setVisible(false);
					extra_panel.setVisible(true);
					blood_panel.setVisible(true);
					repaint();
				}
			});
			
			need_back_btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					extra_panel.setVisible(false);
					blood_panel.setVisible(false);
					need_panel.setVisible(true);
					blood_btn.setVisible(true);
				}
			});
		
		this.setPreferredSize(new Dimension(900,550));
		this.setBackground(Color.yellow);
		this.setLayout(null);
		
		
		//this.add(need_panel);
		need_panel.add(emergency_header_label);
		need_panel.add(blood_donation_label);
		need_panel.add(user_id_label);
		need_panel.add(id_label);
		need_panel.add(user_status_label);
		need_panel.add(show_user_status_label);
		need_panel.add(blood_search_seperator_label);
		need_panel.add(blood_search_label);
		need_panel.add(gender_label);
		need_panel.add(doner_gen_box);
		need_panel.add(blood_grp_label);
		need_panel.add(doner_grp_box);
		need_panel.add(donar_status_label);
		need_panel.add(doner_stat_box);
		need_panel.add(blood_btn);
		
		need_panel.add(fireSerice_label_2);
		need_panel.add(fireSerice_label_1);
		need_panel.add(police_label_2);
		need_panel.add(police_label_1);
		need_panel.add(ambulance_label_3);
		need_panel.add(ambulance_label_2);
		need_panel.add(num_label_1);
		need_panel.add(ambulance_label_1);
		need_panel.add(all_needs_label);
		need_panel.add(seperator_label);
		
		this.add(need_panel);
		this.add(blood_panel);
		this.add(extra_panel);
		
	}
}
class bills extends JPanel{
	
	bills(){
		String rc_no = "Receipt No :                            ";
		String us_id = "User ID :                                   ";
		String us_name = "\nUser Name :                            ";
		String location_txt = "\nLocation :                                ";
		String category = "\n\nCategory :                               ";
		String unit_no = "\nUnit No :                                 ";
		String unit_price ="\n\nUnit Price :                             ";
		String months = "\nMonths :                                   ";
		String amount ="\nAmount :                                "; 
		String date = "\nDate :                                     ";
		String KBASH_PAID = "                        | ";
		String Phone_ck ="Phone :                                  ";
		
		
		
		JTextArea bills_area = new JTextArea();
		bills_area.setBounds(550,20,300,400);
		bills_area.setFont(new Font(null,Font.PLAIN,14));
		bills_area.setBorder(new BevelBorder(0,Color.black,Color.black));
		bills_area.setEditable(false);
		
		bills_area.setText("-----------------------------------------------------------\n");
		bills_area.append("                            Smart City\n");
		bills_area.append("------------------------------------------------------------\n");
		
		JLabel loc_lb = new JLabel("Location:");
		loc_lb.setBounds(130,50,100,30);
		loc_lb.setHorizontalAlignment(JLabel.CENTER);
		loc_lb.setFont(new Font(null,Font.PLAIN,18));
		
		String locs[] = {"ECB","FarmGate","DOHS-Mirpur","Uttora","Motijhil","MogBazar","Dhanmondi"};
		JComboBox location = new JComboBox(locs); 
		location.setBounds(230,50,200,30);
		location.setSelectedItem(usr_home.usr_data_from_persons.usrs_address.get(usr_home.USER));
		location.setBackground(Color.white);
		
		JLabel cat_lb = new JLabel("Category:");
		cat_lb.setBounds(130,100,100,30);
		cat_lb.setHorizontalAlignment(JLabel.CENTER);
		cat_lb.setFont(new Font(null,Font.PLAIN,18));
		
		String bll_type[] = {"","Electricity Bill","Gas Bill","Water Bill"};
		JComboBox cat_box = new JComboBox(bll_type); 
		cat_box.setBounds(230,100,200,30);
		cat_box.setBackground(Color.white);
		
		JLabel unitNo_lb = new JLabel("Unit No:");
		unitNo_lb.setBounds(130,150,100,30);
		unitNo_lb.setHorizontalAlignment(JLabel.CENTER);
		unitNo_lb.setFont(new Font(null,Font.PLAIN,18));
		
		JTextField unitNo_box = new JTextField(); 
		unitNo_box.setBounds(230,150,200,30);
		unitNo_box.setBackground(Color.white);
		
		JLabel month_lb = new JLabel("Months:");
		month_lb.setBounds(130,200,100,30);
		month_lb.setHorizontalAlignment(JLabel.CENTER);
		month_lb.setFont(new Font(null,Font.PLAIN,18));
		
		String month_type[] = {"0","1","2","3","4","5","6"};
		JComboBox month_box = new JComboBox(month_type); 
		month_box.setBounds(230,200,200,30);
		month_box.setBackground(Color.white);
		
		JLabel method_lb = new JLabel("Payment Method:");
		method_lb.setBounds(60,250,160,30);
		method_lb.setFont(new Font(null,Font.PLAIN,18));
		
		String method_type[] = {"","BKASH","ROCKET","NOGOT"};
		JComboBox method_box = new JComboBox(method_type); 
		method_box.setBounds(230,250,200,30);
		method_box.setBackground(Color.white);
		
		JLabel phn_lb = new JLabel("Phone:");
		phn_lb.setBounds(130,300,100,30);
		phn_lb.setHorizontalAlignment(JLabel.CENTER);
		phn_lb.setFont(new Font(null,Font.PLAIN,18));
		
		JTextField phn_box = new JTextField(); 
		phn_box.setBounds(230,300,200,30);
		phn_box.setText(usr_home.usr_data_from_persons.usrs_phone.get(usr_home.USER));
		phn_box.setBackground(Color.white);
		
		JLabel err_label = new JLabel();
		err_label.setBounds(130,350,400,50);
		err_label.setForeground(Color.red);
		err_label.setHorizontalAlignment(JLabel.CENTER);
		err_label.setFont(new Font(null,Font.PLAIN,18));
		
		JButton gen_btn = new JButton("Generate");
		JButton cfm_btn = new JButton("Confirm");
		
		cfm_btn.setBounds(320,420,120,30);
		cfm_btn.setEnabled(false);
		cfm_btn.setFocusable(false);
		cfm_btn.setContentAreaFilled(false);
		cfm_btn.setBackground(Color.yellow);
		cfm_btn.setBorder(new LineBorder(Color.black));
		cfm_btn.setFont(new Font("tahoma",Font.BOLD,16));
		cfm_btn.setFocusPainted(false);
		cfm_btn.setOpaque(true);
		cfm_btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					err_label.setText("<HTML>PAYMENT SUCCESSFUL<HTML>");
					err_label.setForeground(Color.green);
					cfm_btn.setEnabled(false);
					gen_btn.setEnabled(false);
				}
			});
		ButtonModel back_model2 = cfm_btn.getModel();
		back_model2.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(back_model2.isPressed()){
						cfm_btn.setBackground(Color.blue);
						cfm_btn.setForeground(Color.yellow);
					}else if(back_model2.isRollover()){
						cfm_btn.setBackground(new Color(255,165,0));
						cfm_btn.setForeground(Color.white);
					}else {
						cfm_btn.setBackground(Color.yellow);
						cfm_btn.setForeground(Color.black);
					}
				}
			});		
		
		gen_btn.setBounds(80,420,120,30);
		gen_btn.setFocusable(false);
		gen_btn.setContentAreaFilled(false);
		gen_btn.setBackground(Color.yellow);
		gen_btn.setBorder(new LineBorder(Color.black));
		gen_btn.setFont(new Font("tahoma",Font.BOLD,16));
		gen_btn.setFocusPainted(false);
		gen_btn.setOpaque(true);
		gen_btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
				
					String getLoc = String.valueOf(location.getSelectedItem());
					String getCat = String.valueOf(cat_box.getSelectedItem());
					String getUnit = unitNo_box.getText();
					String getMonth = String.valueOf(month_box.getSelectedItem());
					String getMethod = String.valueOf(method_box.getSelectedItem());
					String getPhn = phn_box.getText();
					
					boolean flag = true;
					
					if(getCat.equals("")){
						flag = false;
						err_label.setText("<HTML>PLEASE SELECT CATEGORY</HTML>");
					}
					int unit = 0;
					try{
						unit = Integer.parseInt(getUnit);
					}catch(Exception e){
						flag = false;
						err_label.setText("<HTML>INVALID UNIT NUMBER</HTML>");
					}
					if(getUnit.equals("")){
						flag = false;
						err_label.setText("<HTML>PLEASE SELECT UNIT NO.</HTML>");
					}else if(unit < 10){
						flag = false;
						err_label.setText("<HTML>INVALID UNIT NUMBER</HTML>");
					}
					if(getMonth.equals("0")){
						flag = false;
						err_label.setText("<HTML>PLEASE SELECT THE MONTHS</HTML>");
					}
					if(getMethod.equals("")){
						flag = false;
						err_label.setText("<HTML>PLEASE SELECT PAYMENT METHOD</HTML>");
					}
					if(Sign.checkPhone(getPhn)==false){
						flag = false;
						err_label.setText("<HTML>INVALID PHONE NUMBER</HTML>");
					}
					if(flag == true){
						
							int Gprice = 100;
							if(getLoc.equals("ECB")){
								Gprice = 200;
							}else if(getLoc.equals("FarmGate")){
								Gprice = 400;
							}else if(getLoc.equals("DOHS-MirPur")){
								Gprice = 300;
							}else if(getLoc.equals("Uttora")){
								Gprice = 300;
							}else if(getLoc.equals("Motijhil")){
								Gprice = 400;
							}else if(getLoc.equals("MogBazar")){
								Gprice = 400;
							}else if(getLoc.equals("Dhanmondi")){
								Gprice = 500;
							}
							int Wprice = 100;
							if(getLoc.equals("ECB")){
								Wprice = 200;
							}else if(getLoc.equals("FarmGate")){
								Wprice = 400;
							}else if(getLoc.equals("DOHS-MirPur")){
								Wprice = 400;
							}else if(getLoc.equals("Uttora")){
								Wprice = 200;
							}else if(getLoc.equals("Motijhil")){
								Wprice = 500;
							}else if(getLoc.equals("MogBazar")){
								Wprice = 500;
							}else if(getLoc.equals("Dhanmondi")){
								Wprice = 400;
							}
							int Eprice = 600;
							if(getLoc.equals("ECB")){
								Eprice = 600;
							}else if(getLoc.equals("FarmGate")){
								Eprice = 700;
							}else if(getLoc.equals("DOHS-MirPur")){
								Eprice = 800;
							}else if(getLoc.equals("Uttora")){
								Eprice = 500;
							}else if(getLoc.equals("Motijhil")){
								Eprice = 800;
							}else if(getLoc.equals("MogBazar")){
								Eprice = 700;
							}else if(getLoc.equals("Dhanmondi")){
								Eprice = 900;
							}
							int m = Integer.parseInt(getMonth);
							int u_p = 0;
							int xamount = 0;
							if(getCat.equals("Gas Bill")){
								u_p = Gprice;
								xamount = m*u_p;
							}else if(getCat.equals("Water Bill")){
								u_p = Wprice;
								xamount = m*u_p;
							}else if(getCat.equals("Electricity Bill")){
								u_p = Eprice;
								xamount = m*u_p;
							} 
							
							int x = (int)Math.floor(Math.random()*(9999-1111+1)+1111);
							
							Calendar cal = Calendar.getInstance();
							
							String rc_clone = rc_no+String.valueOf(x);
							String userClone = us_id+usr_home.USER;
							String nameClone = us_name+usr_home.usr_data_from_persons.usrs_name.get(usr_home.USER);
							String locationClone = location_txt+getLoc;
							String catClone = category+getCat;
							String unitClone = unit_no+getUnit;
							String priceClone = unit_price+String.valueOf(u_p)+" tk";
							String monthClone = months+getMonth;
							String amountClone = amount+String.valueOf(xamount)+" tk";
							String dateClone = date+String.valueOf(new SimpleDateFormat("dd-MMMM-yyyy").format(cal.getTime())); 
							String kashClone = KBASH_PAID + getMethod+" | | PAID |";
							String phnClone = Phone_ck+getPhn;
							
							
							bills_area.append(rc_clone);// plus random
							bills_area.append("\n------------------------------------------------------------\n");
							bills_area.append(userClone);// plus id
							bills_area.append(nameClone);
							bills_area.append(locationClone);
							bills_area.append(catClone);
							bills_area.append(unitClone);
							bills_area.append(priceClone);
							bills_area.append(monthClone);
							bills_area.append(amountClone);
							bills_area.append(dateClone);
							bills_area.append("\n------------------------------------------------------------\n");
							bills_area.append(kashClone);
							bills_area.append("\n------------------------------------------------------------\n");
							bills_area.append(phnClone);
		                  
							bills_area.append("\n------------------------------------------------------------\n");
							bills_area.append("           Thank you for using our service");
		
							cfm_btn.setEnabled(true);
					}
				}
			});
			
		ButtonModel back_model1 = gen_btn.getModel();
		back_model1.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(back_model1.isPressed()){
						gen_btn.setBackground(Color.blue);
						gen_btn.setForeground(Color.yellow);
					}else if(back_model1.isRollover()){
						gen_btn.setBackground(new Color(255,165,0));
						gen_btn.setForeground(Color.white);
					}else {
						gen_btn.setBackground(Color.yellow);
						gen_btn.setForeground(Color.black);
					}
				}
			});	
		
		JButton rst_btn = new JButton("Reset");
		rst_btn.setBounds(200,420,120,30);
		rst_btn.setFocusable(false);
		rst_btn.setContentAreaFilled(false);
		rst_btn.setBackground(Color.yellow);
		rst_btn.setBorder(new LineBorder(Color.black));
		rst_btn.setFont(new Font("tahoma",Font.BOLD,16));
		rst_btn.setFocusPainted(false);
		rst_btn.setOpaque(true);
		rst_btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					location.setSelectedItem(usr_home.usr_data_from_persons.usrs_address.get(usr_home.USER));
					cat_box.setSelectedItem("");
					unitNo_box.setText("");
					month_box.setSelectedItem("0");
					method_box.setSelectedItem("");	
					phn_box.setText(usr_home.usr_data_from_persons.usrs_phone.get(usr_home.USER));
					cfm_btn.setEnabled(false);
					err_label.setText("");
					gen_btn.setEnabled(true);
					err_label.setForeground(Color.red);
				}
			});
		ButtonModel back_model = rst_btn.getModel();
		back_model.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent evt){
					if(back_model.isPressed()){
						rst_btn.setBackground(Color.blue);
						rst_btn.setForeground(Color.yellow);
					}else if(back_model.isRollover()){
						rst_btn.setBackground(new Color(255,165,0));
						rst_btn.setForeground(Color.white);
					}else {
						rst_btn.setBackground(Color.yellow);
						rst_btn.setForeground(Color.black);
					}
				}
			});
		
		
		this.setSize(900,550);
		this.setBackground(Color.yellow);
		this.setLayout(null);
		this.setVisible(true);
		
		this.add(bills_area);
		this.add(loc_lb);
		this.add(location);
		this.add(cat_lb);
		this.add(cat_box);
		this.add(unitNo_lb);
		this.add(unitNo_box);
		this.add(month_lb);
		this.add(month_box);
		this.add(method_lb);
		this.add(method_box);
		this.add(phn_lb);
		this.add(phn_box);
		this.add(gen_btn);
		this.add(rst_btn);
		this.add(cfm_btn);
		this.add(err_label);
		
		this.revalidate();
		this.repaint();
	}
		
}

