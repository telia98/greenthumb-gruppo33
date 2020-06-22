package general;

import javax.swing.JFrame;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame=new JFrame(); //per far partire la simulazione del dispositivo scelto
		frame.add(new Homepage(frame));
		frame.setSize(340,580);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

}
