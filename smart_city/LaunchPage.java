import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
class LaunchPage{
	static private ImageIcon getScaledImage(Image srcImg, int w, int h){
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return new ImageIcon(resizedImg);
	}
	LaunchPage(){
		ImageIcon img = new ImageIcon("/home/rony/Pictures/buildings2.jpeg");// -- > nice but have to add more
		
		var label = new JLabel(img);
		label.setVerticalAlignment(JLabel.TOP);
		label.setPreferredSize(new Dimension(400,220));
		
		var x_admin_label = new JLabel("<HTML><U><B>admin</B></U></HTML>");
		x_admin_label.setPreferredSize(new Dimension(100,25));
		x_admin_label.setHorizontalAlignment(JLabel.CENTER);
		x_admin_label.setForeground(Color.black);
		x_admin_label.addMouseListener(new MouseListener(){ // for sign in
				public void mouseClicked(MouseEvent event){
				}public void mousePressed(MouseEvent event){
					new sudo_admin_logIn();
				}public void mouseReleased(MouseEvent event){
				}
				public void mouseEntered(MouseEvent event){
					x_admin_label.setForeground(Color.red);
					
				}public void mouseExited(MouseEvent event){
					x_admin_label.setForeground(Color.black);
				}
			});
		
		var btn1 = new JLabel("<HTML><U><B>Log in</B></U></HTML>");
		btn1.setPreferredSize(new Dimension(100,25));
		btn1.setForeground(Color.black);
		btn1.setHorizontalAlignment(JLabel.CENTER);
		btn1.addMouseListener(new MouseListener(){// for log in
				public void mouseClicked(MouseEvent event){	
				}public void mousePressed(MouseEvent event){
					new Register();
				}public void mouseReleased(MouseEvent event){
				}
				public void mouseEntered(MouseEvent event){
					btn1.setForeground(Color.red);
					
				}public void mouseExited(MouseEvent event){
					btn1.setForeground(Color.black);
				}
			});
		
		var btn2 = new JLabel("<HTML><U><B>Sign Up</B></U></HTML>");
		btn2.setPreferredSize(new Dimension(100,25));
		btn2.setHorizontalAlignment(JLabel.CENTER);
		btn2.setForeground(Color.black);
		btn2.addMouseListener(new MouseListener(){ // for sign in
				public void mouseClicked(MouseEvent event){
				}public void mousePressed(MouseEvent event){
					new Sign();
				}public void mouseReleased(MouseEvent event){
				}
				public void mouseEntered(MouseEvent event){
					btn2.setForeground(Color.red);
					
				}public void mouseExited(MouseEvent event){
					btn2.setForeground(Color.black);
				}
			});
	
		var label2 = new JLabel("<HTML><B>about</B><HTML>");
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setForeground(Color.black);
		label2.addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent event){
				}public void mousePressed(MouseEvent event){
					new abouts();
				}public void mouseReleased(MouseEvent event){
				}
				public void mouseEntered(MouseEvent event){
					label2.setForeground(Color.red);
					
				}public void mouseExited(MouseEvent event){
					label2.setForeground(Color.black);
				}
			});
		
		
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,700));
		panel1.setBackground( Color.yellow);
		panel1.add(x_admin_label);
		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(label2);
		
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(400,600));
		//panel2.setBackground(new Color(255,160,122));// light salman
		panel2.setBackground(new Color(60,149,228));//
		
		
		ImageIcon imgl = LaunchPage.getScaledImage(new ImageIcon("/home/rony/Downloads/logo.jpg").getImage(),400,300);
		var Img_Label = new JLabel( imgl);
		
		
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(400,300));
		panel3.setBackground(new Color(236,151,162)); // lavender blush
		panel3.setLayout(new BorderLayout());
		panel3.add(Img_Label,BorderLayout.CENTER);
		
		panel2.add(label);
		panel2.add(panel3);
		
		
		JFrame frame = new JFrame("launch");
		
		frame.setSize(500,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel1,BorderLayout.WEST);
		c.add(panel2,BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
		
	}
	public static void main(String args[]){
		new LaunchPage();
		//new abouts();
	}
}
class abouts extends JFrame{
	abouts(){
		this.setTitle("ABOUT SMART-CITY");
		String nonsense = "No longer is Smart city just a concept"+
		 "or a dream of the future. We have now successfully created a city"+
		 " with the ICT framework with an intelligent network of connected objects"+
		 " and machines transmitting data using wireless technology and the cloud. This is a framework"+
		 " to develop, deploy, and promote sustainable development practices to address growing urbanization"+
		 " challenges. You can find here all the information at your beck and call. Need a donor? "+
		" Fret not, just type and look. You can easily get the blood type you want. Forgot to pay bill? "+
		" Again, sit at home and relax. Just with the help of an internet connection you can now pay"+
		" your electricity,water amd gas bills online. Keep your information secure in this Smart City where no "+
		"one but you can have access. Here privacy is well maintained and extra security can be provided if needed."+
		" Check the total number of citizens and their gender in your Smart City for any need."+
		"To get this amenity Please sign up, or if you already have an account, log in to check and update your information.";
		
		JTextArea area = new JTextArea();
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		//area.setEditable(false);
		area.setFont(new Font("tahoma",Font.PLAIN,20));
		area.setPreferredSize(new Dimension(500,700));
		area.setBackground(Color.yellow);
		area.setText("                                 SMART CITY\n");
		area.append("                            --------------------------\n\n");
		area.append(nonsense);
		JScrollPane pane = new JScrollPane(area);
		
		this.setVisible(true);
		this.setSize(500,400);
		this.add(pane);
		this.setLocationRelativeTo(null);
	}
}
