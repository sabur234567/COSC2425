package biginteger;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import biginteger.BigIntegerEngine;
import biginteger.BigIntegerEngineImpl;
import biginteger.BigIntegerController;
import biginteger.BigIntegerFrame;

public class BigIntegerFrame {
	public static final int FRAME_WIDTH=800;
	public static final int FRAME_HEIGHT=600;
	public static void main(String[]args)
	{
	BigIntegerEngine bigintEngine = new BigIntegerEngineImpl(4);
	BigIntegerController controller = new BigIntegerController(bigintEngine);
	JFrame frame = new JFrame("Big Integer GUI -- Sabur Khan");
	frame.setLayout(new FlowLayout());
	frame.addWindowListener( new WindowAdapter() {
		public void windowClosing(WindowEvent windowEvent)
		{
			System.exit(0);
		}
	});
	frame.getContentPane().add(controller);
	frame.setSize(BigIntegerFrame.FRAME_WIDTH,BigIntegerFrame.FRAME_HEIGHT);
	frame.setVisible(true);
   }
}
