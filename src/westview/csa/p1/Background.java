package westview.csa.p1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;

public class Background {
	
	protected int status = 6;
	protected int width = 40, height = 50;
	protected int x, y;							//position of the object


	public boolean colliding(Background otherPerson) {
		return false;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		init(x,y);
		g2.drawImage( img,  tx,  null);
 	}

	/*
	 * Not used in this lab but needed
	 * 
	 */
	private AffineTransform tx;
	private Image healthy, recovered, dead, ghost, sick, zombie, img; 	


		

	
	
	
	
	
	
	
	
	public Background() {
		healthy 	= getImage("/images/"+"grass.png");    
		img = healthy;
		
		//alter these
		x = 0;
		y = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 3);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
