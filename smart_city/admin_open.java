
import java.util.HashMap;
import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class admin_open{
	public static void main(String arhs[]){
		new sudo_admin_logIn();
	}
}
class sudo_admin implements Serializable{ // -----------------------------------------> admin template
	HashMap<String,String> admin = new HashMap<String,String>();
	HashMap<String,String> admin_name = new HashMap<String,String>();
	HashMap<String,String> admin_address = new HashMap<String,String>();
	HashMap<String,String> admin_gender = new HashMap<String,String>();
	HashMap<String,String> admin_phone = new HashMap<String,String>();
	HashMap<String,String> admin_job = new HashMap<String,String>();
	HashMap<String,String> admin_mail = new HashMap<String,String>();
	
	sudo_admin(){
		admin.put("root","root");
		admin_name.put("root","rony");
		admin_address.put("root","ECB");
		admin_gender.put("root","Male");
		admin_phone.put("root","01747992866");
		admin_job.put("root","admin");
		admin_mail.put("root","ronyraihan123@gmail.com");
		
		admin.put("proxy","1234");
		admin_name.put("proxy","zarin");
		admin_address.put("proxy","Mirpur");
		admin_gender.put("proxy","Female");
		admin_phone.put("proxy","01747992866");
		admin_job.put("proxy","admin");
		admin_mail.put("proxy","zarin@gmail.com");
		
		admin.put("proxyma","1234");
		admin_name.put("proxyma","arnima");
		admin_address.put("proxyma","Mirpur");
		admin_gender.put("proxyma","Female");
		admin_phone.put("proxyma","01747992866");
		admin_job.put("proxyma","admin");
		admin_mail.put("proxyma","arnima@gmail.com");
	}
}
class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(ImageIcon image) {
        this.image = this.getScaledImage(image,900,500);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
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
class sudo_admin_logIn implements ActionListener{
	ImageIcon background = new ImageIcon("/home/rony/Pictures/buildings.jpg");
	JFrame frame = new JFrame("LOG IN");
	JButton logIn_button = new JButton("log in");
	JButton reset_button = new JButton("reset");
	JTextField id_field = new JTextField();  // ID
	JPasswordField pass_field = new JPasswordField(); // PASS
	JLabel user_label = new JLabel("admin ID:");
	JLabel pass_label = new JLabel("Password:");
	JLabel warning_label = new JLabel();
	
	sudo_admin proxys = new sudo_admin();
	public sudo_admin_logIn(){
		JLabel HEADER_label =  new JLabel("SMART CITY");
		HEADER_label.setBounds(276,0,380,80);
		HEADER_label.setBackground(Color.lightGray);
		//HEADER_label.setOpaque(true);
		HEADER_label.setFont(new Font(null,Font.PLAIN,50));
		HEADER_label.setHorizontalAlignment(JLabel.CENTER);
		
		user_label.setBounds(325,100,75,25);
		user_label.setBackground(Color.yellow);
		user_label.setOpaque(true);
		id_field.setBounds(400,100,200,25);//125,,,
		
		pass_label.setBounds(325,150,75,25);
		pass_label.setBackground(Color.yellow);
		pass_label.setOpaque(true);
		pass_field.setBounds(400,150,200,25);
		
		logIn_button.setBounds(400,200,100,25);
		logIn_button.setFocusable(false);
		logIn_button.addActionListener(this);
		logIn_button.setBackground(Color.yellow);
		
		reset_button.setBounds(500,200,100,25);
		reset_button.setFocusable(false);
		reset_button.addActionListener(this);   
		reset_button.setBackground(Color.yellow);
			
		warning_label.setBounds(0,410,900,70);//0,300,900,70
		warning_label.setFont(new Font(null,Font.BOLD,32));
		warning_label.setBackground(Color.yellow);
		warning_label.setOpaque(true);
		warning_label.setHorizontalAlignment(JLabel.CENTER);
		
		Image image = background.getImage();
		frame.setContentPane(new ImagePanel(background));
		
		frame.add(HEADER_label);
		frame.add(user_label);
		frame.add(id_field);
		frame.add(pass_label);
		frame.add(pass_field);
		frame.add(logIn_button); frame.add(reset_button);
		frame.add(warning_label);
		
		frame.setSize(900,500);//420,420
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == reset_button){
			id_field.setText("");
			pass_field.setText("");
			warning_label.setText("");
		}
		if(event.getSource() == logIn_button){
			String usr_id = id_field.getText();
			String usr_pass = String.valueOf(pass_field.getPassword());
			System.out.println("log in first layer");
			
			if(proxys.admin.containsKey(usr_id)){       //this.log_info.containsKey(usr_id)
				System.out.println("log in second layer ---x user match");
				if(proxys.admin.get(usr_id).equals(usr_pass)){ //this.log_info.get(usr_id).equals(usr_pass)
					System.out.println("log in third layer");
					admin_home_panel.admin_is = usr_id;
					new admin_log_home();
					frame.dispose();
					//WelcomePage welcome_page = new WelcomePage(usr_id);
				}else{
					warning_label.setForeground(Color.black);
					warning_label.setText("Wrong password !");
				}
			}else{
				warning_label.setForeground(Color.black);
				warning_label.setText("Invalid user ID !");
			}
		}
	}
}

