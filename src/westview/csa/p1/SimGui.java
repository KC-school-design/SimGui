package westview.csa.p1;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimGui extends JPanel implements ActionListener, MouseListener{
	/* change these two numbers to alter the size of the JFrame */
	public static int screenWidth = 1280;		 
	public static int screenHeight = 720;
	
	Background bg = new Background();
	
	// container for all the person objects
	Person[] people = new Person[1000];
	
	public static int population = 0; 
	
	
	
	
	public void paint(Graphics g) {
		 super.paintComponent(g);
		 bg.paint(g);

		// traverse the act the non-null elements inpeople array
		 for (int i = 0; i < population; i++) {
			 people[i].paint(g);
		 }
		 
		 
	
	
	for (int i = 0; i< population; i++) {
		for (int j = i +1; j < population; j++) {
			people[i].colliding(people[j]);
		}
	}
	}
	
	
	
	/*
	 * Add code that requires setting up objects or arrays here
	 * This code runs before the GUI displays hence why it is called setup.
	 */
	public void setup() {
		// write a loop that will create 25 person objects
		//add these objects to the people array
		for (int i = 0; i < 25; i++) {
			int randX = (int)(Math.random() * SimGui.screenWidth) + 10;
			int randY = (int)(Math.random() *(SimGui.screenHeight - 100)) + 80;
			Person newObj = new Person(randX, randY, 0); // 0 statys = healthy
			
			
			// add the obj in the array using population as the index
			people[population - 1] = newObj; 
		}
		
		

	}
	
	
	
	/**
	 * The code below sets up the GUI. Not required to change.
	 */
	//Constructor for the GUI class
	Timer animationTimer; //animation timer
	public SimGui() {
		JFrame frame = new JFrame("Simulation");
		frame.setSize(screenWidth, screenHeight);
		
		animationTimer = new Timer(16, this);
		frame.add(this);
		frame.addMouseListener(this);
		setup();
		animationTimer.start();
		
		//center the jframe
		frame.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - screenWidth/2),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 - screenHeight/2) );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// Run the GUI program
		new SimGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//use the MouseEvent e object'slocation
		//to create an infected person
		Person infected = new Person(e.getX(), e.getY(), 4); 
		
		people[population-1] = infected;
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

}
