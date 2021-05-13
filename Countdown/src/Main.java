import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author Koraiko
 * A Program to visualize the Countdown until EidI
 */
class Main {
	//time
	int hour = 14;
	int min = 15;
	int sec = 0;
	
	//size of the window
	int width = 1280;
	int height = 720;
	
	//Labels & CO
	JFrame frame;
	JLabel time;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	boolean timeBiggerThanZero = true;
	
	/**
	 * main method
	 * @param args parameter from starting the program
	 */
	public static void main(String[] args) {
		new Main().main();
	}
	
	/**
	 * makes the window
	 */
	void main() {
		frame = new JFrame("EidI Countdown");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new MyListener());
		
//		double scale = 1;
//		BufferedImage myPicture;
		try {
			time = new JLabel("HH:mm:ss");
			time.setSize(450, 100);
			time.setFont(new Font("Miriam Mono CLM", Font.PLAIN, 90));
			frame.getContentPane().add(time);
			time.setLocation(width-(130+time.getWidth()), height-(135+time.getHeight()));
			
			JPanel white = new JPanel();
			white.setBackground(new Color(255, 255, 255, 150));		//wei�
//			white.setBackground(new Color(72, 209, 204, 150));		//blau-wei�	
			white.setSize(time.getWidth()+20, time.getHeight()+20);
			frame.getContentPane().add(white);
			white.setLocation(time.getLocation().x-10, time.getLocation().y-10);
			
			Image pic = getPicture();
			ImageIcon img = new ImageIcon(pic);
			JLabel picLabel = new JLabel(img);
			frame.getContentPane().add(picLabel);
			
		} catch (IOException e) { 
			System.out.print("no .jpg found.");
			System.exit(0);
		}
		
		frame.setSize(width, height);
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		counter();
	}

	private Image getPicture() throws IOException {
		int i = (int) (Math.random()*18);
		if(i==17) {
			int month = LocalDateTime.now().getMonth().getValue();
			String picPath = "/uUlmSued.jpg";
			
			if (month > 10 || month<3) {
				picPath = "/uUlmSuedWinter.jpg";
			}
			
			BufferedImage myPicture = ImageIO.read(getClass().getResource(picPath));
			return myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		}
		BufferedImage myPicture = ImageIO.read(getClass().getResource("/"+i+".jpg"));
		return myPicture.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

	/**
	 * counts the time until its the wanted time and prints it on the JLabel 'time'
	 */
	void counter() {
		while (timeBiggerThanZero) {
			time.setText(getTime());
			frame.getContentPane().validate();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) { e.printStackTrace(); }
		System.exit(0);
	}
	
	/**
	 * calculates the time until event
	 * @return time as a string HH:MM:SS
	 */
	String getTime() {
		LocalDateTime now = LocalDateTime.now();
		

		int timeDiffS = 1*(sec-now.getSecond());
		if(timeDiffS>59) timeDiffS -=60;
		if(timeDiffS<0) timeDiffS +=60;
		
		int timeDiffM = 1*(min-now.getMinute());
		if(timeDiffS>0 && timeDiffM>0) timeDiffM--;
		if(timeDiffM>59) timeDiffM -=60; 
		if(timeDiffM<0)	timeDiffM +=60;

		int timeDiffH = hour-now.getHour();
		if(hour<now.getHour()) timeDiffH = (24-now.getHour())+hour;
		if(timeDiffM>0 && timeDiffH>0) timeDiffH--;
		if(timeDiffH>23) timeDiffH -= 24;
		if(timeDiffH<0) timeDiffH += 24;
		
		if(timeDiffH==0 && timeDiffM==0 && timeDiffS==0) timeBiggerThanZero = false;
		
		return format.format(LocalDateTime.of(2020, 11, 9, timeDiffH, timeDiffM, timeDiffS));
	}
}