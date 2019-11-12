package rebotes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

class PanelPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	public void add(Pelota pelota){	
		pelotas.add(pelota);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota p: pelotas){	
			g2.fill(p.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}