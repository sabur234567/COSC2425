package biginteger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import biginteger.BigIntegerView;

import biginteger.BigIntegerFrame;

public class BigIntegerController extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton getSum;
	JButton setOperand;
	JButton clear;
	

	JPanel stackButtonPanel ;

	BigIntegerView stackPanel;
	BigIntegerEngine bigintEngine;

	ChangeListener bigintEngineListener;


	// default constructor, receives the stack engine model it is displaying and controlling
	public BigIntegerController(BigIntegerEngine aBigIntEngine)
	{
		super();
		this.setPreferredSize(new Dimension(BigIntegerFrame.FRAME_WIDTH-20, BigIntegerFrame.FRAME_HEIGHT - 100));
		this.setLayout(new BorderLayout());
		this.bigintEngine = aBigIntEngine;
		
		//create a "listener" for the stack engine, so if that engine changes, it can respond
		bigintEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		this.bigintEngine.addChangeListener(bigintEngineListener); // add listener to stackEngine for notification
		init();
	}
	
	private void init() 
	{
		this.clear = new JButton("Clear");
		this.setOperand = new JButton("Set Operand");
		this.getSum = new JButton("Get the Sum");
	
		this.stackPanel = new BigIntegerView(bigintEngine);  // create a Stack Panel (view) and send it the engine it is "modeling"

		stackButtonPanel = new JPanel();		  // used to hold all stack operation buttons
		stackButtonPanel.setLayout(new GridLayout(2,4));  // 1 row of 6 (change as more or less buttons are used)
		stackButtonPanel.add(clear);			// now add buttons to the panel
		stackButtonPanel.add(setOperand);
		stackButtonPanel.add(getSum);
	
		this.add(stackButtonPanel, BorderLayout.NORTH);  // this is the controller panel, add the stack button panel to the top across
		this.add(stackPanel,  BorderLayout.EAST);		  // add remaining components to this controller panel
		this.add(stackPanel, BorderLayout.WEST);
		this.add(stackButtonPanel,  BorderLayout.SOUTH);  // add big ints button panel to the bottom
		
		getSum.addActionListener(this); 
		setOperand.addActionListener(this);
		clear.addActionListener(this);


	}
	//method called when an ChangeEvent is fired in the model
		// updates data on the view which will reflect any changes made to the model
	private void update() 
	{			// repaint all models (engines)
		repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// HANDLES all button actions, listeners for each button
	
	}

}
