package rebotes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MarcoRebote extends JFrame{
	
	private PanelPelota panel;
	
	public MarcoRebote(){
		
		setBounds(600,300,400,350);
		setTitle ("Pelota rebotando");
		panel=new PanelPelota();
		add(panel, BorderLayout.CENTER);
		JPanel panelBotones=new JPanel();
		
		ponerBoton(panelBotones, "Empezar!", new ActionListener(){	
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego();
			}
		});
		ponerBoton(panelBotones, "Salir", new ActionListener(){
			public void actionPerformed(ActionEvent evento){	
				System.exit(0);			
			}	
		});
		
		add(panelBotones, BorderLayout.SOUTH);
	}
	

	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 3000 veces
	public void comienza_el_juego (){
				
			Pelota pelota=new Pelota();
			panel.add(pelota);
			for (int i=1; i<=3000; i++){	
				pelota.mueve_pelota(panel.getBounds());	
				panel.paint(panel.getGraphics());
				
					
			}			
	}
		
}