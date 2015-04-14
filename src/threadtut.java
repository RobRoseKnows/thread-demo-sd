import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class threadtut extends JPanel
{
	private JButton b1;
	private JButton b2;
	private Color bg;
	private WorkThread wt;
	private BigDecimal solution;
	
	public threadtut()
	{
		b1 = new JButton("Start");
		b2 = new JButton("Print");
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				wt = new WorkThread();
				bg = Color.GREEN;
				setBackground(bg);
				wt.start();
			}
		
		});
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new threadtut());
		frame.setVisible(true);
		frame.pack();
	}
	
	public class WorkThread extends Thread
	{
		
		public void run(){
			BigDecimal curCeiling = new BigDecimal(2);
			BigDecimal curFloor = new BigDecimal(0);
			BigDecimal curSolution = new BigDecimal(1);
			for(int i = 0; i < 100; i++){
				curSolution = curFloor.add(curCeiling.subtract(curFloor).divide(new BigDecimal(2)));
				
				
				if(curSolution.compareTo(new BigDecimal(2)) > 0)
					curCeiling = curSolution;
				else if(curSolution.compareTo(new BigDecimal(2)) < 0)
					curFloor = curSolution;
				else
				{
					System.out.println("you broke math :<");
						break;
				}
			}
			solution = curSolution;
			System.out.println(solution.toString());
			bg = Color.RED;
			setBackground(bg);
		}
	}
}