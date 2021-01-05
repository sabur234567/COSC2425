package asg7;
// main program that runs the Stack and Queue Gui testing
// uses the Model-View-Controller paradigm
// the controller is StackQueueViewImpl 
// the models are StackEngine and QueueEngine instances
// the view is part of the controller in StackQueueViewImpl class

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;



public class StackQueueFrame {

	public static final int FRAME_WIDTH=800;
	public static final int FRAME_HEIGHT=600;
	public static void main(String[]args)
	{
	StackEngine stackEngine = new StackEngineImpl(4);
	QueueEngine queueEngine = new QueueEngineImpl(4);
	StackQueueController controller = new StackQueueController(stackEngine,queueEngine);
	JFrame frame = new JFrame("Stack and Queue Gui Example -- Sabur Khan");
	frame.setLayout(new FlowLayout());
	frame.addWindowListener( new WindowAdapter() {
		public void windowClosing(WindowEvent windowEvent)
		{
			System.exit(0);
		}
	});
	frame.getContentPane().add(controller);
	frame.setSize(StackQueueFrame.FRAME_WIDTH,StackQueueFrame.FRAME_HEIGHT);
	frame.setVisible(true);
   }

}
