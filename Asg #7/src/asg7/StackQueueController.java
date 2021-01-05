package asg7;
/**  implementation of the view of two different stack implementations
 *   modeled with a stack engine
 *  that models/uses two stacks and allows a few operations on those stacks
 *  @author: LJBaker
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StackQueueController extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton pushButton;
	JButton popButton;
	JButton frontButton;
	JButton addButton;
	JButton removeButton;
	JButton fullButton;
	JButton emptyButton;
	JButton peekButton;
	JButton clearButton;
	JButton showSizeButton;
	JButton maxButton;
	JButton rearButton;
	JButton clearQueueButton;

	JPanel stackButtonPanel ;
	JPanel queueButtonPanel;
	StackViewImpl stackPanel;
	QueueViewImpl queuePanel;
	StackEngine stackEngine;
	QueueEngine queueEngine;

	ChangeListener stackEngineListener;
	ChangeListener queueEngineListener;

	// default constructor, receives the stack engine model it is displaying and controlling
	public StackQueueController(StackEngine aStackEngine, QueueEngine aQueueEngine)
	{
		super();
		this.setPreferredSize(new Dimension(StackQueueFrame.FRAME_WIDTH-20, StackQueueFrame.FRAME_HEIGHT - 100));
		this.setLayout(new BorderLayout());
		this.stackEngine = aStackEngine;
		this.queueEngine = aQueueEngine;
		//create a "listener" for the stack engine, so if that engine changes, it can respond
		stackEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		this.stackEngine.addChangeListener(stackEngineListener); // add listener to stackEngine for notification
		queueEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		//create a "listener" for the queue engine, so if that engine changes, we can respond
		this.queueEngine.addChangeListener(queueEngineListener);
		init();
	}
	// initializes the view - all the widgets and listeners, sets up the view
	private void init() 
	{
		this.pushButton = new JButton("Push");
		this.popButton = new JButton("Pop");
		this.frontButton = new JButton("Get Front");
		this.addButton = new JButton("Add to Queue");
		this.removeButton = new JButton("Remove from Queue");
		this.peekButton= new JButton("Peek");
		this.clearButton = new JButton("Clear Stack");
		this.showSizeButton = new JButton("Get Queue Size");
		this.maxButton = new JButton("Get Max Size(both)");
		this.rearButton = new JButton("Get Rear");
		this.clearQueueButton = new JButton("Clear Queue");
		
		this.emptyButton = new JButton("Check Empty(both)");
		this.fullButton = new JButton("Check Full(both)");
		this.stackPanel = new StackViewImpl(stackEngine);  // create a Stack Panel (view) and send it the engine it is "modeling"
		this.queuePanel = new QueueViewImpl(queueEngine);  // create a Queue Panel (view) and send it the engine it is "modeling"

		stackButtonPanel = new JPanel();		  // used to hold all stack operation buttons
		stackButtonPanel.setLayout(new GridLayout(2,4));  // 1 row of 6 (change as more or less buttons are used)
		stackButtonPanel.add(pushButton);			// now add buttons to the panel
		stackButtonPanel.add(popButton);
		stackButtonPanel.add(fullButton);
		stackButtonPanel.add(emptyButton);
		stackButtonPanel.add(peekButton);
		stackButtonPanel.add(clearButton);
		stackButtonPanel.add(maxButton);
		
		
		queueButtonPanel = new JPanel();			// used to hold all queue operation buttons - currently 3 but more should be added
		queueButtonPanel.setLayout(new GridLayout(2,4));
		queueButtonPanel.add(addButton);
		queueButtonPanel.add(removeButton);
		queueButtonPanel.add(frontButton);
		queueButtonPanel.add(showSizeButton);
		queueButtonPanel.add(rearButton);
		queueButtonPanel.add(clearQueueButton);


		this.add(stackButtonPanel, BorderLayout.NORTH);  // this is the controller panel, add the stack button panel to the top across
		this.add(queuePanel,  BorderLayout.EAST);		  // add remaining components to this controller panel
		this.add(stackPanel, BorderLayout.WEST);
		this.add(queueButtonPanel,  BorderLayout.SOUTH);  // add queue button panel to the bottom

		pushButton.addActionListener(this); 
		popButton.addActionListener(this);
		frontButton.addActionListener(this);
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		fullButton.addActionListener(this);
		emptyButton.addActionListener(this);
		peekButton.addActionListener(this);
		clearButton.addActionListener(this);
		showSizeButton.addActionListener(this);
		maxButton.addActionListener(this);
		rearButton.addActionListener(this);
		clearQueueButton.addActionListener(this);
		
	}
	//method called when an ChangeEvent is fired in the model
	// updates data on the view which will reflect any changes made to the model
	private void update() 
	{
		// repaint all models (engines)
		repaint();
	}

	// HANDLES all button actions, listeners for each button
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(pushButton))
		{  
			String item = JOptionPane.showInputDialog(this, "Enter value to push", "");
			if(item != null&& item.length() != 0)
				stackEngine.push(item);
		}
		else if (e.getSource().equals(popButton))
		{
			stackEngine.pop();  // note we popped the engine and it recovers the value popped	
		}

		else if (e.getSource().equals(addButton))
		{
			String item = JOptionPane.showInputDialog(this, "Enter value to add to queue:", "");
			if(item != null && item.length() != 0)
			     queueEngine.add(item);
		}
		else if (e.getSource().equals(removeButton))
		{
			queueEngine.remove();  // note we remove
		}
		else if (e.getSource().equals(frontButton))
		{
			queueEngine.showFront();
		}
		else if (e.getSource().equals(fullButton))
		{
			queueEngine.testFull();  
			stackEngine.testFull();
		}
		else if(e.getSource().equals(emptyButton))
		{
			queueEngine.testEmpty();
			stackEngine.testEmpty();
		}
		else if(e.getSource().equals(peekButton))
		{
			stackEngine.peek();
		}
		else if(e.getSource().equals(clearButton))
		{
			stackEngine.clear();
		}
		else if(e.getSource().equals(showSizeButton))
		{
			queueEngine.showSize();
		}
		else if(e.getSource().equals(maxButton))
		{
			queueEngine.showMaxSize();
			stackEngine.showMaxSize();
		}
		else if(e.getSource().equals(rearButton))
		{
			queueEngine.showRear();
		}
		else if(e.getSource().equals(clearQueueButton))
		{
			queueEngine.clear();
		}
		

		//stackArea.setText(actionText);
	}

} // end of StackQueueViewImpl class


