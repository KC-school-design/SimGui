package westview.csa.p1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;

public class Person {
	
	protected int status = 6;
	protected int width = 40, height = 50;
	protected int x, y;							//position of the object
	private int speedX = 3;						//speed in x-dir
	private int speedY = 4;						//speed in y-dir
	private int duration = 5000; // duration of specific states
	/*
	 * Add a non-deaul constructor for person
	 * such that you can set the location and status
	 * attributes during creation
	 */
	public Person(int newX, int newY, int newStatus) {
		this(); // calldefault constructor to set all all vars first
		
		// now assign the values from parameters
		this.x = newX; //this.x is the same as x
		this.y = newY;
		this.status = newStatus;
	}
	
	
	
	
	/*
	 * Update this code so that our Person stays within the 
	 * bounds of the frame
	 */
	public void update() {
		this.x += speedX;
		this.y += speedY;
	
		if (this.x <= 0 || this.x >= SimGui.screenWidth-40 ) {
			speedX *= -1;
		}
		if (this.y <= 0 || this.y >= SimGui.screenHeight-75 ) {
			speedY *= -1;
		}
		
		
		if (status == 4 && duration <= 0) {
			
			
			if (Math.random() < 0.70) {
				status = 5;
			} else {
				status = 1;
			}
			
			duration = 5000;
			
		} // if it hasn't been the full x- amount of time 
		else if (status == 4 && duration > 0) {
			duration -= 16;
		}
		
		if (status == 4 && duration <= 0) {
			
		}
		
		
		
		
	}
	
	
	
	
	/*
	 * To be complete by student. Change status of 
	 * the objects
	 */
	
	
	
	
	
		public boolean colliding(Person otherPerson) {

		//determine if this object
		// is colliding with otherPerson
		
		
		Rectangle thisObj = new Rectangle(this.x, this.y, this.width, this.height);
		
		Rectangle otherObj = new Rectangle(otherPerson.x, otherPerson.y, otherPerson.width, otherPerson.height);
		
	// represent each object as Rectangle objects
		// and use the intersects method for a REctangle 
		//to set if they are colliding!
		
		//1) Create a Rectangle based on this object's attributes

		
		
		
//2) create a Rectangle based on other Person's attributes
		
		// write the if-statement to check if the two Rectangles
		// are intersecting
		if(thisObj.intersects(otherObj)) {
			if (this.status == 0 && otherPerson.status == 4) {}
			this.status = 4;
		
		if (this.status == 0 && otherPerson.status == 4) {
		this.status = 4;	
		}
		
		
		
		
	// this object infects other p=object
		if (otherPerson.status == 0 && this.status == 4) {
			otherPerson.status = 4; // otherperson getst infected by this object
			
		}
		
		return true;
		}
	
	return false;
	
		}	
		
		
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		update();
		switch(status) {
			case 0:
				img = healthy;
				break;
			case 1:
				img = recovered;
				break;
			case 2: 
				img = dead;
				break;
			case 3:
				img = ghost;
				break;
			case 4:
				img = sick;
				break;
			case 5:
				img = zombie;
		}
		init(x,y);
		g2.drawImage( img,  tx,  null);

		// draw hit box for the object
		// helps make sure our Rectanle collision later is correct
		g.setColor(Color.red);
		g.drawRect(this.x, this.y, 40, 50);
			
	
	}

	/*
	 * Not used in this lab but needed
	 * 
	 */
	private AffineTransform tx;
	private Image healthy, recovered, dead, ghost, sick, zombie, img; 	

	public Person() {
		SimGui.population += 1;
		
		
		healthy 	= getImage("/images/"+"Healthy.png");    
		recovered 	= getImage("/images/"+"Recovered.png");  
		dead 		= getImage("/images/"+"Dead.png");  
		ghost 		= getImage("/images/"+"Ghost.png");  
		sick 		= getImage("/images/"+"Sick.png");  
		zombie 		= getImage("/images/"+"Zombie.png");  
		
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
		tx.scale(width/122.0, height/161.0);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Person.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
