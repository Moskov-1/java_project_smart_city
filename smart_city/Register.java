import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class persons implements Serializable{ // ---------------------------------------------> user tamplate
	HashMap<String,String> usrs = new HashMap<String,String>();
	HashMap<String,String> usrs_name = new HashMap<String,String>();
	HashMap<String,String> usrs_address = new HashMap<String,String>();
	HashMap<String,String> usrs_age = new HashMap<String,String>();
	HashMap<String,String> usrs_bio = new HashMap<String,String>();
	HashMap<String,String> usrs_actual_address = new HashMap<String,String>();
	HashMap<String,String> usrs_gender = new HashMap<String,String>();
	HashMap<String,String> usrs_phone = new HashMap<String,String>();
	HashMap<String,String> usrs_job = new HashMap<String,String>();
	HashMap<String,String> usrs_mail = new HashMap<String,String>();
	HashMap<String,String> usrs_blood_grp = new HashMap<String,String>();
	HashMap<String,String> usrs_doner = new HashMap<String,String>();
	
	HashMap<String,Date> usrs_sign_time = new HashMap<String,Date>();
	HashMap<String,Date> usrs_log_time = new HashMap<String,Date>();
	persons(){
		usrs.put("root","root");
		usrs_name.put("root","rony");
		usrs_address.put("root","ECB");
		usrs_age.put("root","21");
		usrs_bio.put("root","Hi I am user name root. I am also one of the admins for this application.We hope you are satisfied with our services");
		usrs_actual_address.put("root","manikdi,madrasha road");
		usrs_gender.put("root","Male");
		usrs_phone.put("root","01747992866");
		usrs_job.put("root","Student");
		usrs_mail.put("root","ronyraihan123@gmail.com");
		usrs_blood_grp.put("root","O+ve");
		usrs_doner.put("root","Yes");
		Calendar c = Calendar.getInstance();
		usrs_sign_time.put("root",c.getTime());
		usrs_log_time.put("root",c.getTime());
	}
}
class Register implements Serializable,ActionListener{
	//HashMap<String,String> usrs = new HashMap<String,String>();
	private static String the_user;
	JFrame frame = new JFrame("LOG In");
	JLabel warning_label;
	JButton sign_btn ;
	JButton login_btn;
	JTextField usr_id;
	JPasswordField pass_id;
	persons person_obj;
	Register(){
		try{	 
				person_obj = new  FileRecord().getData();
				System.out.println(person_obj.usrs);
			}catch(Exception ex){ex.printStackTrace();}
		JLabel usr_label = new JLabel("user id");
		usr_label.setBounds(100,15,200,35);
		
		usr_id = new JTextField(); 
		usr_id.setBounds(100,40,200,35);
		
		var pass_label = new JLabel("password");
		pass_label.setBounds(100,90,200,35);
		
		pass_id = new JPasswordField(); 
		pass_id.setBounds(100,115,200,35);
		
		login_btn = new JButton("LOG IN");
		login_btn.setBounds(100,165,100,35);
		login_btn.setFocusable(false);
		login_btn.addActionListener(this);
		
		var reset_btn = new JButton("reset");
		reset_btn.setBounds(100,200,100,35);
		reset_btn.setFocusable(false);
		reset_btn.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent event){
					//frame.getContentPane().setBackground(Color.white);
					//System.out.println(usr_id.getText());
					warning_label.setText("");
					usr_id.setText("");
					pass_id.setText("");
				}
			});
		
		sign_btn = new JButton("sign in");
		sign_btn.setBounds(200,165,100,70);
		sign_btn.setFocusable(false);
		sign_btn.addActionListener(this);
		
		warning_label = new JLabel();
		warning_label.setBounds(100,250,300,120);
		warning_label.setForeground(Color.red);
		warning_label.setFont(new Font(null,Font.PLAIN,30));
		warning_label.setBackground(Color.yellow);
		warning_label.setOpaque(true);
		
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.green);
		
		frame.add(usr_label);
		frame.add(usr_id);
		frame.add(pass_label);
		frame.add(pass_id);
		frame.add(login_btn); 
		frame.add(reset_btn);
		frame.add(sign_btn);
		frame.add(warning_label);
		
		frame.setVisible(true);
			
	}
	public void actionPerformed(ActionEvent event){
		
		if(event.getSource() == sign_btn){
			frame.dispose();
			var sing_obj = new Sign();
		}if(event.getSource() == login_btn){
			String usr_name = usr_id.getText();
			String usr_pass = String.valueOf(pass_id.getPassword());
					System.out.println(usr_name+" "+usr_pass);
					if( person_obj.usrs.containsKey(usr_name) ){
						System.out.println(usr_name);
						if(person_obj.usrs.get(usr_name).equals(usr_pass)){
							frame.getContentPane().setBackground(Color.green);
							the_user=usr_name;
							Calendar c = Calendar.getInstance();
							profile_panel.currentLogTime = c.getTime();
							frame.dispose();
							new usr_home();
						}else{
							warning_label.setText("<HTML>PASSWORD INVLAID</HTML>");
						}
					}else{
							warning_label.setText("<HTML>USER NAME INVLAID</HTML>");
					}
		}
	}
	public static String getName(){
		return the_user;
	}
	public static void main(String args[]){
			
			new Register();
	}
}
class Sign{
	//HashMap<String,String> users;
	
	persons proxy_obj;
	String name,address,phone,isGender;
	String []gender = {"","Male","Female"};
	String []job = {"","Business","Student","Govt","Freelance","others"};
	String []house = {"","ECB","FarmGate","DOHS-Mirpur","Uttora","Motijhil","MogBazar","Dhanmondi"};
	Sign(){
		
		try{	 
				proxy_obj = new  FileRecord().getData();
				System.out.println(proxy_obj.usrs);
			}catch(Exception ex){ex.printStackTrace();}
		JFrame frame = new JFrame("SIGN UP");
		
		var name_id_label = new JLabel("user ID");
		name_id_label.setBounds(100,20,200,30);
		var id_field = new JTextField();
		id_field.setBounds(100,50,200,30);
		
		var pass_id_label = new JLabel("password");
		pass_id_label.setBounds(100,100,100,25); 
		var pass_field = new JTextField();
		pass_field.setBounds(100,125,200,30);
		
		var name_label = new JLabel("name");
		name_label.setBounds(100,160,100,25);
		var name_field = new JTextField();
		name_field.setBounds(100,185,200,30);
		
		var add_label = new JLabel("Location");
		add_label.setBounds(100,215,100,25);
		JComboBox add_field = new JComboBox(house);
		add_field.setBounds(100,240,200,30);
		
		var age_label = new JLabel("Gender");
		age_label.setBounds(100,270,100,25);
		var comboBox = new JComboBox(gender);//---------------
		comboBox.setBounds(100,290,200,30);
		
		var phone_label = new JLabel("phone number");
		phone_label.setBounds(100,320,200,25);
		var phone_field = new JTextField();
		phone_field.setBounds(100,355,200,30);
		
		var ocupation_label = new JLabel("Occupation");
		ocupation_label.setBounds(100,385,200,25);
		var ocupation_box = new JComboBox(job);
		ocupation_box.setBounds(100,410,200,30);
		
		
		var mail_label = new JLabel("E-mail");
		mail_label.setBounds(100,440,200,25);
		var mail_field = new JTextField();
		mail_field.setBounds(100,465,200,30);
		
		JLabel bld_grp_label = new JLabel("Blood Group");
		bld_grp_label.setBounds(100,495,200,25);
		
		String  grp[] = {"","AB+ve","AB-ve","A+ve","A-ve","B+ve","B-ve","O+ve","O-ve"};
		JComboBox bld_grp_box = new JComboBox(grp);
		bld_grp_box.setBounds(100,520,200,30);
		
		var doner_label = new JLabel("Doner?");
		doner_label.setBounds(100,550,200,20);
		String  stats[] = {"","Yes","No"};
		JComboBox doner_box = new JComboBox(stats);
		doner_box.setBounds(100,570,200,30);
		
		var done_btn = new JButton("Done");
		done_btn.setBounds(100,620,100,20);
		done_btn.setFocusable(false);
		done_btn.addActionListener(new ActionListener(){
			JLabel warning_label = new JLabel();
			boolean flag;
				public void actionPerformed(ActionEvent event){
					flag = true;
					warning_label.setText("");
					warning_label.setBounds(310,420,200,100);
					warning_label.setFont(new Font(null,Font.PLAIN,30));
					warning_label.setForeground(Color.red);
					frame.add(warning_label);
					name = String.valueOf(name_field.getText());
					if(name.equals("")){
						flag = false;
						warning_label.setBounds(310,160,200,100);
						warning_label.setText("Invalid name");
					}
					address = String.valueOf(add_field.getSelectedItem());
					if(address.equals("")){
						flag  = false;
						warning_label.setBounds(310,215,200,100);
						warning_label.setText("<HTML>Invalid address<HTML>");
					}
					try{
						isGender = comboBox.getSelectedItem().toString();
						System.out.println(isGender);
						if(isGender.equals("")){
							flag = false;
							warning_label.setBounds(300,270,200,100);
							warning_label.setText("select Gender");
						}
					}catch(Exception e){
						flag = false;
						warning_label.setText("Invalid gender");
					}
					phone = phone_field.getText();
					if( phone.length() != 11){
							flag = false;
							warning_label.setBounds(300,320,200,100);
							warning_label.setText("<HTML>invalid digits for a phone number<HTML>");
					}if( phone.indexOf('-') != -1){
							flag = false;
							warning_label.setBounds(300,320,200,100);
							warning_label.setText("<HTML>phone number can't be negative <HTML>");
					}
					if(Sign.checkPhone(phone) != true){
						flag = false;
						warning_label.setBounds(300,320,200,100);
						warning_label.setText("<HTML>invalid phone number<HTML>");
					}
					String job = ocupation_box.getSelectedItem().toString();
					if(job.equals("")){
						flag = false;
						warning_label.setBounds(300,385,200,100);
						warning_label.setText("<HTML>select an Ocupation <HTML>");
					}
					String mail = mail_field.getText();
					if(mail.equals("")){
						flag = false;
						warning_label.setBounds(300,440,200,100);
						warning_label.setText("<HTML>enter mail address <HTML>");
					}if(!Sign.checkMail(mail)){
						flag = false;
						warning_label.setBounds(300,440,200,100);
						warning_label.setText("<HTML>invalid mail address <HTML>");
					}
					String blood = String.valueOf(bld_grp_box.getSelectedItem());
					System.out.println(blood);
					String doner = String.valueOf(doner_box.getSelectedItem());
					System.out.println(doner);
					if(blood.equals("")){
						flag = false;
						warning_label.setBounds(300,495,200,100);
						warning_label.setText("<HTML>select blood group <HTML>");
					}
					if(doner.equals("")){
						flag = false;
						warning_label.setBounds(300,550,200,100);
						warning_label.setText("<HTML>select doner status <HTML>");
					}
					
					String id = id_field.getText();
					String pass = pass_field.getText();
					if(id.equals("")){
						flag = false;
						warning_label.setBounds(310,20,200,100);
						warning_label.setText("<HTML>please write an user ID<HTML>");
					}if(pass.equals("")){
						flag = false;
						warning_label.setBounds(310,100,200,100);
						warning_label.setText("<HTML>please write down your password<HTML>");
					}
					if((proxy_obj.usrs.containsKey(id)!=false)){
						warning_label.setText("<HTML>User ID is already taken<HTML>");
						flag = false;
					}
					if((proxy_obj.usrs.containsKey(id)==false) && flag == true){
						System.out.println("Gonna add");
						Calendar c =  Calendar.getInstance();
						proxy_obj.usrs.put(id,pass);
						proxy_obj.usrs_name.put(id,name);
						proxy_obj.usrs_address.put(id,address);
						proxy_obj.usrs_gender.put(id,isGender);
						proxy_obj.usrs_phone.put(id,phone);
						proxy_obj.usrs_job.put(id,job);
						proxy_obj.usrs_mail.put(id,mail);
						proxy_obj.usrs_blood_grp.put(id,blood);
						proxy_obj.usrs_doner.put(id,doner);
						proxy_obj.usrs_sign_time.put(id,c.getTime());
						proxy_obj.usrs_log_time.put(id,c.getTime());
						frame.dispose();
						FileRecord obj_x = new FileRecord();
						try{obj_x.setData(proxy_obj);}catch(Exception ex){ex.printStackTrace();}
						new Register();
					}
					// add some [hashmaps] for age phone 
					// name and address as well
					System.out.println(flag);
					System.out.println(proxy_obj.usrs);
				}
			});
		var back_btn =new JButton("back");
		back_btn.setBounds(200,620,100,20);
		back_btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					frame.dispose();
					new Register();
				}
			});
		
		frame.setSize(500,700);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(100,255,255));
		frame.setVisible(true);
		
		frame.add(name_id_label);
		frame.add(id_field);
		frame.add(pass_id_label);
		frame.add(pass_field);
		frame.add(name_label);
		frame.add(name_field);
		frame.add(add_label);
		frame.add(add_field);
		frame.add(age_label);
		frame.add(comboBox);
		frame.add(phone_label);
		frame.add(phone_field);
		frame.add(ocupation_label);
		frame.add(ocupation_box);
		frame.add(mail_label);
		frame.add(mail_field);
		frame.add(bld_grp_label);
		frame.add(bld_grp_box);
		frame.add(doner_label);
		frame.add(doner_box);
		frame.add(done_btn);
		frame.add(back_btn);
		
		frame.add(done_btn);
		frame.add(back_btn);
	}
	public static boolean checkPhone(String arr){
		if(arr.matches("[0-9]{11}")){
			if(arr.charAt(0)=='0' && (arr.charAt(1) == '1' || arr.charAt(1) == '2' || arr.charAt(1) == '4') )
				return true;
		}
		return false;
	}
	public static boolean checkMail(String arr){
		if(arr.indexOf("@gmail.com") !=-1 || arr.indexOf("@yahoo.com") !=-1 || arr.indexOf("@yahoo.com") !=-1){
				return true;
		}
		return false;
	}
}


