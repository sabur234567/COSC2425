package biginteger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JPanel;

public class BigIntegerView extends JPanel 
{
	BigIntegerEngine engine;
	final int MYWIDTH=BigIntegerFrame.FRAME_WIDTH;
	final int MYHEIGHT=BigIntegerFrame.FRAME_HEIGHT-150;
	public BigIntegerView(BigIntegerEngine theEngine)
	{ 
		super();
		this.engine = theEngine;
		this.setBackground(new Color(137, 236, 67));
		this.setPreferredSize(new Dimension(MYWIDTH, MYHEIGHT));
		
		this.repaint();
	}
	public void paintComponent(Graphics g)
	{
		String theOperands = engine.toString(); // get all operands
	    // set up a way to walk through each operand in the engine
		// using StringTokenizer class with delimiter "\n" between operands
		StringTokenizer tkn = new StringTokenizer(theOperands, "\n");
		
		g.setFont(new Font("default", Font.BOLD, 16));
		int size = BigIntegerEngine.MAX_OPERANDS;
		if(size == 0)
		{
			g.drawString("OPERAND List is EMPTY", 20,  20);
			return;
		}
		
		int ht = MYHEIGHT/BigIntegerEngine.MAX_OPERANDS;
		int height= 20;
		int width = 10;
		// draw the stack element container as rectangles
		for(int i=0; i<BigIntegerEngine.MAX_OPERANDS; i++)
		{   
			g.drawRect(20, height-10,MYWIDTH/2-50,ht );
			
			height += ht;
		}
		// now draw the values in the stack in the contains from top to bottom
		height= (BigIntegerEngine.MAX_OPERANDS-size)*ht+25;
		for(int i=0; i<size; i++)
		{  
			String out = tkn.nextToken();
			out = "["+(i+1)+"]  " + out;
			g.drawString(out, width+15,  height);
			height += ht;
		}
		String sum = engine.getSum();
		g.setColor(Color.CYAN);
		g.fillRect(MYWIDTH/2, 20, MYWIDTH/2-50, 50);
		g.setColor(Color.BLACK);
		g.drawString("SUM: " + sum, MYWIDTH/2+10,  60);
		Font font = new Font("Comic Sans MS", Font.BOLD, 12);
		g.setFont(font);
		g.drawString("Instructor copy", MYWIDTH-200, MYHEIGHT-10);
		}
}
