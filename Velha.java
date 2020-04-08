package joguinho;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Velha extends JPanel {
	char jogadorB = 'O';
    char jogadorX = 'X';
	char vencedor = ' ';
	char tabuleiro[][] = new char[3][3];
	// ou tabuleiro[] = new char[9];

	public Velha() {
		repaint();
		ManipuladorMouse mouse = new ManipuladorMouse();
		this.addMouseListener(mouse);
	}

	private class ManipuladorMouse extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getX() + "," + e.getY());
				verificaJogada(e.getX(),e.getY());		

				repaint();

				verificaVencedor();
		}
		
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
		private void verificaVencedor() {
			if (tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O' ||
				tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O' ||
	        	tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O' ||
	        	tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O' ||
	        	tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O' ||
	        	tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O' ||
	        	tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O' ||
	        	tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O' ){
				ganhouO();}
			
			else if (tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X' ||
					tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X' ||
		        	tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X' ||
		        	tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X' ||
		        	tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X' ||
		        	tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X' ||
		        	tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X' ||
		        	tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X' ){
	        	ganhouX();}
	        else if ((tabuleiro[0][0] != 0 && tabuleiro[0][1] != 0 && tabuleiro[0][2] != 0 && tabuleiro[1][0] != 0
	        		&& tabuleiro[1][1] != 0 && tabuleiro[1][2] != 0 && tabuleiro[2][0] != 0 && tabuleiro[2][1] != 0
	        		&& tabuleiro[2][2] != 0)) {
	        	velha();
	        }
			
			
			//Horizontais
			/*if ( (tabuleiro[0][0] == tabuleiro[0][1]) && (tabuleiro[0][1] == tabuleiro[0][2]))endGameX();
			if ( (tabuleiro[1][0] == tabuleiro[1][1]) && (tabuleiro[1][1] == tabuleiro[1][2]));
			if ( (tabuleiro[2][0] == tabuleiro[2][1]) && (tabuleiro[2][1] == tabuleiro[2][2]));
			//Vertical
			if ( (tabuleiro[0][0] == tabuleiro[1][0]) && (tabuleiro[1][0] == tabuleiro[2][0]));
			if ( (tabuleiro[1][0] == tabuleiro[1][1]) && (tabuleiro[1][1] == tabuleiro[1][2]));
			if ( (tabuleiro[2][0] == tabuleiro[2][1]) && (tabuleiro[2][1] == tabuleiro[2][2]));
			// horizontal
			if ( (tabuleiro[0][0] == tabuleiro[1][1]) && (tabuleiro[1][1] == tabuleiro[2][2]));
			if ( (tabuleiro[0][2] == tabuleiro[1][1]) && (tabuleiro[1][1] == tabuleiro[2][0]));	*/		
		}
		
		
		private void verificaJogada(int x, int y) {
			if(jogadorB == 'O') {
				jogadorB = 'X';
			}
            else {
            	jogadorB = 'O';
            }
			if(x < 100 && y < 100) {
				tabuleiro[0][0] = jogadorB;
            }
			else if(x< 200 && x > 100 && y < 100) {
				tabuleiro[0][1] = jogadorB;
			}
			else if(x < 300 && x > 200 && y < 100)
				tabuleiro[0][2] = jogadorB;
			else if(x < 100 && y > 100 && y < 200) {
				tabuleiro[1][0] = jogadorB;
			}
			else if(x> 100 && x < 200 && y> 100 && y < 200) {
				tabuleiro[1][1] =jogadorB;
			}
			else if(x > 200 && x < 300 && y > 100 && y < 200) {
				tabuleiro[1][2]=jogadorB;
			}
			else if(x < 100 && y > 200 && y < 300) {
				tabuleiro[2][0]=jogadorB;
			}
			else if(x > 100 && x < 200 && y > 200 && y < 300) {
				tabuleiro[2][1] =jogadorB;
			}
			else if(x > 200 && x < 300 && y > 200 && y < 300) {
				tabuleiro[2][2]=jogadorB;
			}
		}
	}

	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
			// Linha Vertical
		g.drawLine(90, 10, 90, 250);
        g.drawLine(190, 10, 190, 250); 
        	// Linhas Horizontais
        g.drawLine(10, 90, 270, 90);
        g.drawLine(10, 180, 270, 180);
		desenhaTabuleiro(g);
	}

	private void desenhaTabuleiro(Graphics g) {
		//Primeiro quadrado
		if(this.tabuleiro[0][0] == 'O'){                                  
			g.drawArc(20, 20, 50, 50, 0, 360);
        }           
        else if(this.tabuleiro[0][0] == 'X'){
            g.drawLine(30, 30, 60, 60);
            g.drawLine(60, 30, 30, 60);                 
        }         
        
        // Segundo quadrado          
        if(this.tabuleiro[0][1] == 'O'){                   
            g.drawArc(110, 20, 50, 50, 0, 360);
        }
        else if(tabuleiro[0][1] == 'X'){
            g.drawLine(120, 30, 150, 60);
            g.drawLine(150, 30, 120, 60);               
        }
                   
        // Terceiro quadrado 
        if(this.tabuleiro[0][2] == 'O'){                 
            g.drawArc(210, 20, 50, 50, 0, 360);
        }
        else if(this.tabuleiro[0][2] == 'X'){
            g.drawLine(220, 30, 250, 60);
            g.drawLine(250, 30, 220, 60); 
        }
        
        // Quarto quadrado 
        if(this.tabuleiro[1][0] == 'O'){
            g.drawArc(20, 110, 50, 50, 0, 360);   
        }
        else if(this.tabuleiro[1][0] == 'X'){
            g.drawLine(30, 120, 60, 150);
            g.drawLine(60, 120, 30, 150);
        }
        
        // Quinto quadrado
        if(this.tabuleiro[1][1] == 'O'){    
            g.drawArc(110, 110, 50, 50, 0, 360);
        }
        else if(this.tabuleiro[1][1] == 'X'){   
            g.drawLine(120, 120, 150, 150);
            g.drawLine(150, 120, 120, 150);
        }
        
        // Sexto quadrado
        if(this.tabuleiro[1][2] == 'O'){ 
            g.drawArc(210, 110, 50, 50, 0, 360);
        }
        else if(this.tabuleiro[1][2] == 'X'){
            g.drawLine(220, 120, 250, 150);
            g.drawLine(250, 120, 220, 150);
        }
        
        // Sétimo quadrado
        if(this.tabuleiro[2][0] == 'O'){
            g.drawArc(20, 200, 50, 50, 0, 360);    
        }
        else if(this.tabuleiro[2][0] == 'X'){
            g.drawLine(30, 210, 60, 240);
            g.drawLine(60, 210, 30, 240);
        }
        
        // Oitavo quadrado
        if(this.tabuleiro[2][1] == 'O'){
            g.drawArc(110, 200, 50, 50, 0, 360);
        }
        else if(this.tabuleiro[2][1] == 'X'){
            g.drawLine(120, 210, 150, 240);
            g.drawLine(150, 210, 120, 240);
        }
        
        // Nono quadrado
        if(this.tabuleiro[2][2] == 'O'){
            g.drawArc(210, 200, 50, 50, 0, 360);
        }          
        else if(this.tabuleiro[2][2] == 'X'){
            g.drawLine(220, 210, 250, 240);
            g.drawLine(250, 210, 220, 240);
        }		
	}
	
	public void ganhouX() {
        JOptionPane.showMessageDialog(null, "X VENCEU!");
        System.exit(0);
    }
	
	public void ganhouO() {
        JOptionPane.showMessageDialog(null, "O VENCEU!");
        System.exit(0);
    }
	
	public void velha() {
    	JOptionPane.showMessageDialog(null, "DEU VELHA!");
    	System.exit(0);
    }
}
