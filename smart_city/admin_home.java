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

class admin_home{
	public static void main(String args[]){
		new admin_log_home();
	}
}
class admin_log_home implements MouseListener,Serializable{
	JFrame frame;
	
	JPanel top_panel;
	admin_home_panel mid_panel;
	user_list_panel list_Panel;
	adm_list admins_table_panel;
	JPanel bottom_panel;
	
	JLabel tool_home_label;
	JLabel tool_userList_label;
	JLabel tool_admins_data_label;
	JLabel tool_logOut_label;
	
	static persons admin_usealbe_data;
	
	admin_log_home(){
		try{	 
				admin_log_home.admin_usealbe_data = new  FileRecord().getData();
				System.out.println(admin_log_home.admin_usealbe_data.usrs);
				
			}catch(Exception ex){ex.printStackTrace();System.out.println("The exception's from here// loading from files");}
		
		
		tool_home_label = new JLabel("<HTML><U>HOME</U></HTML>");
		tool_home_label.setBounds(0,0,200,70);
		tool_home_label.setHorizontalAlignment(JLabel.CENTER);
		tool_home_label.setFont(new Font(null,Font.PLAIN,27));
		tool_home_label.setBackground(Color.yellow);
		tool_home_label.setOpaque(true);
		tool_home_label.addMouseListener(this);
		
		tool_userList_label = new JLabel("<HTML><U>USER LIST</U></HTML>");
		tool_userList_label.setBounds(200,0,200,70);
		tool_userList_label.setHorizontalAlignment(JLabel.CENTER);
		tool_userList_label.setFont(new Font(null,Font.PLAIN,27));
		tool_userList_label.setBackground(Color.yellow);
		tool_userList_label.setOpaque(true);
		tool_userList_label.addMouseListener(this);
		
		tool_admins_data_label = new JLabel("<HTML><U>ADMIN LIST</U></HTML>");
		tool_admins_data_label.setBounds(440,0,200,70);
		tool_admins_data_label.setHorizontalAlignment(JLabel.CENTER);
		tool_admins_data_label.setFont(new Font(null,Font.PLAIN,27));
		tool_admins_data_label.setBackground(Color.yellow);
		tool_admins_data_label.setOpaque(true);
		tool_admins_data_label.addMouseListener(this);
		
		tool_logOut_label = new JLabel("<HTML><U>LOG OUT</U></HTML>");
		tool_logOut_label.setBounds(800,0,200,70);
		tool_logOut_label.setHorizontalAlignment(JLabel.CENTER);
		tool_logOut_label.setFont(new Font(null,Font.PLAIN,27));
		tool_logOut_label.setBackground(Color.yellow);
		tool_logOut_label.setOpaque(true);
		tool_logOut_label.addMouseListener(this);
		
		top_panel = new JPanel();
		
		top_panel.setBounds(0,0,1000,70);
		top_panel.setBackground(Color.yellow);
		top_panel.setLayout(null);
		
		top_panel.add(tool_home_label);
		top_panel.add(tool_userList_label);
		top_panel.add(tool_admins_data_label);
		top_panel.add(tool_logOut_label);
		
		mid_panel = new admin_home_panel();
		list_Panel = new user_list_panel();
		admins_table_panel = new adm_list();
		
		bottom_panel = new JPanel();
		
		bottom_panel.setBounds(0,570,1000,80);
		bottom_panel.setBackground(Color.yellow);
		
		frame = new JFrame();
		
		frame.setSize(1000,650);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.add(top_panel);
		frame.add(mid_panel);
		frame.add(bottom_panel);
	}
	public void mousePressed(MouseEvent event){
		
	}public void mouseReleased(MouseEvent event){
		if(event.getSource() == tool_logOut_label){
			frame.dispose();
		}else if(event.getSource() == tool_userList_label){
			mid_panel.setVisible(false);
			admins_table_panel.setVisible(false);
			frame.getContentPane().add(list_Panel);
			list_Panel.setVisible(true);
			
		}else if(event.getSource() == tool_home_label){
			list_Panel.setVisible(false);
			admins_table_panel.setVisible(false);
			mid_panel.setVisible(true);
		}else if(event.getSource() == tool_admins_data_label){
			list_Panel.setVisible(false);
			mid_panel.setVisible(false);
			frame.getContentPane().add(admins_table_panel);
			admins_table_panel.setVisible(true);
		}
		
	}public void mouseClicked(MouseEvent event){
		
	}public void mouseEntered(MouseEvent event){
		if(event.getSource() == tool_userList_label){
			tool_userList_label.setForeground(Color.red);
		}else if(event.getSource() == tool_logOut_label){
			tool_logOut_label.setForeground(Color.red);
		}else if(event.getSource() == tool_home_label){
			tool_home_label.setForeground(Color.red);
		}else if(event.getSource() == tool_admins_data_label){
			tool_admins_data_label.setForeground(Color.red);
		}
	}public void mouseExited(MouseEvent event){
		if(event.getSource() == tool_userList_label){
			tool_userList_label.setForeground(Color.black);
		}else if(event.getSource() == tool_logOut_label){
			tool_logOut_label.setForeground(Color.black);
		}else if(event.getSource() == tool_home_label){
			tool_home_label.setForeground(Color.black);
		}else if(event.getSource() == tool_admins_data_label){
			tool_admins_data_label.setForeground(Color.black);
		}
	}
	
	
}
class admin_home_panel extends JPanel{
	static String admin_is ;
	admin_home_panel(){
		var imgICon = new ImageIcon("/home/rony/Pictures/buildings.jpg");
		if(admin_is == null){
			admin_is = "null";
		}
		
		String use_admin = "WELCOME ADMIN USER "+admin_is.toUpperCase();
		JLabel welcome_label = new JLabel(use_admin);
		welcome_label.setBounds(0,0,1000,45);
		welcome_label.setBackground(Color.lightGray);
		welcome_label.setForeground(Color.darkGray);
		welcome_label.setFont(new Font(null,Font.BOLD,25));
		welcome_label.setHorizontalAlignment(JLabel.CENTER);
		//welcome_label.setOpaque(true);
		//mid_panel = new JPanel();
		var img = this.getScaledImage(imgICon,1000,500);
		var abar_img = new ImageIcon(img);
		
		JLabel abar_img_label = new JLabel(abar_img);
		abar_img_label.setBounds(0,0,1000,500);
		
		this.setBounds(0,70,1000,500);
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		this.add(welcome_label);
		this.add(abar_img_label);
		
	}
	public static Image getScaledImage(ImageIcon icon, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(icon.getImage(), 0, 0, w, h, null);
        g2.dispose();/*from w  w w .  ja va 2  s .c o  m*/

        return resizedImg;
    }
}
class user_list_panel extends JPanel{
	JPanel user_table_panel;
	Object [][]nullRow2 = null;
	String columnList[] = {"Serial","ID","Name","Gender","ocupation","location","Contact","Email"};
	DefaultTableModel user_model = new DefaultTableModel(nullRow2,columnList);
	JTable usrs_forAdmin_table; 
	
	JButton adminSearch_btn;
	
	user_list_panel(){
		
		String key = "";
		String single_row[] = new String[8];
		int i =1;
		// so i need an iteerator ..."ID","Name","Gender","ocupation","location","Contact","Email" -7
		Iterator<String> itr = admin_log_home.admin_usealbe_data.usrs.keySet().iterator();
		while(itr.hasNext()){
			key = itr.next();
			single_row[0] = String.valueOf(i);
			single_row[1]= key;
			single_row[3]= admin_log_home.admin_usealbe_data.usrs_name.get(key);
			single_row[3]= admin_log_home.admin_usealbe_data.usrs_gender.get(key);
			single_row[4]= admin_log_home.admin_usealbe_data.usrs_job.get(key);
			single_row[5]= admin_log_home.admin_usealbe_data.usrs_address.get(key);
			single_row[6]= admin_log_home.admin_usealbe_data.usrs_phone.get(key);
			single_row[7]= admin_log_home.admin_usealbe_data.usrs_mail.get(key);
			user_model.addRow(single_row);
			i++;
		}
		usrs_forAdmin_table = new JTable(user_model){
				public boolean isCellEditable(int data,int columns){
					return false;
				}
				public Component prepareRenderer(TableCellRenderer r,int data,int columns){
					//      awt                           swing.table
					Component c = super.prepareRenderer(r,data,columns);
			
					if(data%2 ==0){
						c.setBackground(Color.white);
					}else{
						c.setBackground(Color.gray);
					}if(isCellSelected(data,columns)){
						c.setBackground(Color.yellow);
					}
						return c;	
				}
		};
		
		usrs_forAdmin_table.setPreferredScrollableViewportSize(new Dimension(1000,420));
		usrs_forAdmin_table.setFillsViewportHeight(true);
		usrs_forAdmin_table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scroll_pane2 = new JScrollPane(usrs_forAdmin_table);
		
		adminSearch_btn = new JButton("look up");
		adminSearch_btn.setBounds(850,10,100,30);
		
		JLabel searchLabel = new JLabel("<HTML><U>Search:</U></HTML>");
		searchLabel.setBounds(100,0,100,50);
		searchLabel.setFont(new Font(null,Font.PLAIN,20));
		searchLabel.setForeground(Color.yellow);
		//searchLabel.setOpaque(true);
		
		JLabel genL = new JLabel("<HTML>GEN:</HTML>");
		genL.setBounds(240,0,60,50);
		genL.setFont(new Font(null,Font.BOLD,16));
		genL.setForeground(Color.yellow);
		//genL.setOpaque(true);
		
		String gender[] = {"All","Male","Female"};
		JComboBox genBx = new JComboBox(gender);
		genBx.setBounds(300,10,100,30);
		
		JLabel jobL = new JLabel("<HTML>JOB:</HTML>");
		jobL.setBounds(410,0,50,50);
		jobL.setFont(new Font(null,Font.BOLD,16));
		jobL.setForeground(Color.yellow);
		//jobL.setOpaque(true);
		
		String jobs[] = {"All","Business","Student","Govt","Freelance","others"};
		JComboBox jobBx = new JComboBox(jobs);
		jobBx.setBounds(460,10,100,30);
		
		
		
		JLabel hmeL = new JLabel("<HTML>Location:</HTML>");
		hmeL.setBounds(570,0,100,50);
		hmeL.setFont(new Font(null,Font.BOLD,16));
		hmeL.setForeground(Color.yellow);
		//hmeL.setOpaque(true);
		
		String locs[] = {"All","ECB","FarmGate","DOHS-Mirpur","Uttora","Motijhil","MogBazar","Dhanmondi"};
		JComboBox locBx = new JComboBox(locs);
		locBx.setBounds(670,10,100,30);
		
		adminSearch_btn.addActionListener(new ActionListener(){
				String getGender,getLocation,getJob;	
				String isGender,isLocation,isJob;
				
				public void actionPerformed(ActionEvent event){
					getGender = String.valueOf(genBx.getSelectedItem());
					getLocation = String.valueOf(locBx.getSelectedItem());
					getJob = String.valueOf(jobBx.getSelectedItem());
					
					user_model.setRowCount(0);
					System.out.println(getGender+" "+getJob+" "+getLocation);
					//"All","Business","Student","Govt'","Freelance","others"
					
					
					
					String key = "";
					String single_row[] = new String[8];
					int i =1;
					// so i need an iteerator ..."ID","Name","Gender","ocupation","location","Contact","Email" -7
					Iterator<String> itr = admin_log_home.admin_usealbe_data.usrs.keySet().iterator();
					while(itr.hasNext()){
						key = itr.next();
						single_row[0] = String.valueOf(i);
						single_row[1]= key;
						single_row[2]= admin_log_home.admin_usealbe_data.usrs_name.get(key);
						single_row[3]= admin_log_home.admin_usealbe_data.usrs_gender.get(key);
						isGender =single_row[3];
						single_row[4]= admin_log_home.admin_usealbe_data.usrs_job.get(key);
						isJob = single_row[4];
						single_row[5]= admin_log_home.admin_usealbe_data.usrs_address.get(key);
						isLocation = single_row[5]; 
						single_row[6]= admin_log_home.admin_usealbe_data.usrs_phone.get(key);
						single_row[7]= admin_log_home.admin_usealbe_data.usrs_mail.get(key);
						
						if(getGender.equals("All") && getLocation.equals("All") && getJob.equals("All")){
								user_model.addRow(single_row);
								i++;
						}
						
						else if(getGender.equals(isGender) && getLocation.equals("All") && getJob.equals("All")){
							user_model.addRow(single_row);
							i++;
						}
						
						else if(getGender.equals("All") && getLocation.equals(isLocation) && getJob.equals("All")){
							user_model.addRow(single_row);
							i++;
						}
						else if(getGender.equals("All") && getLocation.equals("All") && getJob.equals(isJob)){
								user_model.addRow(single_row);
								i++;
						}
						
						else if(getGender.equals(isGender) && getLocation.equals(isLocation) && getJob.equals("All")){
							user_model.addRow(single_row);
							i++;
						}
						
						
						else if(getGender.equals("All")  && getLocation.equals(isLocation) && getJob.equals(isJob)){
							user_model.addRow(single_row);
							i++;
						}
						else if(getGender.equals(isGender) && getLocation.equals("All") && getJob.equals(isJob)){
								user_model.addRow(single_row);
								i++;
						}
						
						else if(getGender.equals(isGender) && getLocation.equals(isLocation) && getJob.equals(isJob)){
							    user_model.addRow(single_row);
							    i++;
						}
						
						
					}
				                                  //"All","Business","Student","Govt","Freelance","others"
				    //busJob=false,stdJob=false,govJob=false,freeJob=false,odJob=false;
				}
			});
		
		user_table_panel = new JPanel();
		user_table_panel.setBounds(0,50,1000,420);
		user_table_panel.setLayout(new BorderLayout());
		user_table_panel.setBackground(Color.blue);
		user_table_panel.add(scroll_pane2);
		
		
		
		this.setBounds(0,70,1000,500);
		this.setBackground(new Color(96,125,178));
		this.setLayout(null);
		this.setVisible(false);
		
		
		this.add(searchLabel);
		this.add(user_table_panel);
		this.add(genL);
		this.add(genBx);
		this.add(jobL);
		this.add(adminSearch_btn);
		this.add(jobBx);
		this.add(hmeL);
		this.add(locBx);
		
	}
}
class adm_list extends JPanel{
	sudo_admin sudo = new sudo_admin();
	Object [][]nullRow3 = null;
	String adminColumnList[] = {"Serial","ID","Name","Gender","ocupation","location","Contact","Email"};
	DefaultTableModel admin_model = new DefaultTableModel(nullRow3,adminColumnList);
	JTable this_isAdmin_table; 
	adm_list(){
		String key = "";
		String single_row[] = new String[8];
		int i=1 ;
		// so i need an iteerator ..."ID","Name","Gender","ocupation","location","Contact","Email" -7
		Iterator<String> itr = sudo.admin.keySet().iterator();
		while(itr.hasNext()){
			key = itr.next();
			single_row[0]=String.valueOf(i);
			single_row[1]= key;
			single_row[2]= sudo.admin_name.get(key);
			single_row[3]= sudo.admin_gender.get(key);
			single_row[4]= sudo.admin_job.get(key);
			single_row[5]= sudo.admin_address.get(key);
			single_row[6]= sudo.admin_phone.get(key);
			single_row[7]= sudo.admin_mail.get(key);
			admin_model.addRow(single_row);
			i++;
		}
		this_isAdmin_table = new JTable(admin_model){
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
		
		this_isAdmin_table.setPreferredScrollableViewportSize(new Dimension(1000,420));
		this_isAdmin_table.setFillsViewportHeight(true);
		this_isAdmin_table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scroll_pane2 = new JScrollPane(this_isAdmin_table);
		
		
			
		JPanel extra = new JPanel();
		extra.setBounds(0,100,1000,300);
		extra.setLayout(new BorderLayout());
		extra.add(scroll_pane2);
			
			
		this.setBounds(0,70,1000,500);
		this.setBackground(new Color(96,125,178));
		this.setLayout(null);
		this.setVisible(false);
			
		this.add(extra);
	}
}
