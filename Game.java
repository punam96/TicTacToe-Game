package tictactoe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame
{

	private JPanel contentPane;
	Board board;
	private int player =1;
	private final JButton [][]button = new JButton[3][3];
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
    protected void setButtonReferences()
    {
    	button[0][0] = btn1;
    	button[0][1] = btn2;
    	button[0][2] = btn3;
    	button[1][0] = btn4;
    	button[1][1] = btn5;
    	button[1][2] = btn6;
    	button[2][0] = btn7;
    	button[2][1] = btn8;
    	button[2][2] = btn9;
    }
	public void setPlayer(int value)
	{
		player = value;
	}
	public void refreshBoardDisplay()
	{
	       for(int i=0;i<=2;i++)
	           for(int j=0;j<=2;j++)
	           {
	               switch(board.getBoardValue(i, j))
	               {
	                   case 2:
	                       button[i][j].setEnabled(true);
	                       button[i][j].setText("");
	                       break;
	                   case 3:
	                       button[i][j].setEnabled(false);
	                       button[i][j].setText("X");
	                       break;
	                   case 5:
	                       button[i][j].setEnabled(false);
	                       button[i][j].setText("O");
	                       break;
	               }
	           }
	}
	public void playComputer()
	{
        int buttonNumber;
             buttonNumber=board.possibleWin(player);
             if(buttonNumber==0)
                 buttonNumber=board.possibleWin(3-player);
             if(buttonNumber==0)
                 buttonNumber=board.randomBlankButton();
        if(buttonNumber!=0)
        {
            switch(buttonNumber)
            {
                case 1:
                    if(player==1)
                        board.setBoardValue(0,0,3 );
                    else
                        board.setBoardValue(0,0,5 );
                    refreshBoardDisplay();
                    break;
                case 2:
                    if(player==1)
                        board.setBoardValue(0,1, 3);
                    else
                        board.setBoardValue(0,1, 5);
                    refreshBoardDisplay();
                    break;
                case 3:
                    if(player==1)
                        board.setBoardValue(0,2,3);
                    else
                        board.setBoardValue(0,2,5 );
                    refreshBoardDisplay();
                    break;
                case 4:
                    if(player==1)
                        board.setBoardValue(1,0,3);
                    else
                        board.setBoardValue(1,0,5 );
                    refreshBoardDisplay();
                    break;
                case 5:
                    if(player==1)
                        board.setBoardValue(1,1,3);
                    else
                        board.setBoardValue(1,1,5 );
                    refreshBoardDisplay();
                    break;
                case 6:
                    if(player==1)
                        board.setBoardValue(1,2,3);
                    else
                        board.setBoardValue(1,2,5 );
                    refreshBoardDisplay();
                    break;
                case 7:
                    if(player==1)
                        board.setBoardValue(2,0, 3);
                    else
                        board.setBoardValue(2,0,5 );
                    refreshBoardDisplay();
                    break;
                case 8:
                    if(player==1)
                        board.setBoardValue(2,1, 3);
                    else
                        board.setBoardValue(2,1,5 );
                    refreshBoardDisplay();
                    break;
                case 9:
                    if(player==1)
                        board.setBoardValue(2,2,3);
                    else
                        board.setBoardValue(2,2,5 );
                    refreshBoardDisplay();
                    break;
            }
            if(board.checkWin(player))
            {
                JOptionPane.showMessageDialog(this,"Computer won the game");
                board.initializeBoard();
                refreshBoardDisplay();
                setPlayer(1);
            }
            else if(board.isBoardFilled())
            {
                JOptionPane.showMessageDialog(this,"Game Draw");
                board.initializeBoard();
                refreshBoardDisplay();
                setPlayer(1);
            }
            else
            {
                setPlayer(3-player);
            }
        }
	}

	/**
	 * Create the frame.
	 */
	public Game() 
	{
		setResizable(false);
		initComponents();
	}
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 360, 23);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 23, 373);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 329, 337, 30);
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(337, 13, 23, 325);
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(23, 23, 100, 97);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		btn1 = new JButton("");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(0,0,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(0,0,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
		            
		    }
		});
		btn1.setBackground(Color.WHITE);
		btn1.setBounds(-1, -1, 101, 101);
		panel_4.add(btn1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(130, 23, 100, 97);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		btn2 = new JButton("");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(0,1,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(0,1,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(0, -1, 100, 101);
		panel_5.add(btn2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(24, 23, 94, 97);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(237, 23, 100, 97);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		btn3 = new JButton("");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1)
				{
		            board.setBoardValue(0,2,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(0,2,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(0, -1, 101, 101);
		panel_7.add(btn3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(23, 127, 100, 97);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		btn4 = new JButton("");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(1,0,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(1,0,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn4.setBackground(Color.WHITE);
		btn4.setBounds(-1, -1, 101, 101);
		panel_8.add(btn4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(130, 127, 100, 97);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		btn5 = new JButton("");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(1,1,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(1,1,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn5.setBackground(Color.WHITE);
		btn5.setBounds(0, -1, 100, 101);
		panel_9.add(btn5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(237, 127, 100, 97);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
		
		btn6 = new JButton("");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(player==1){
		            board.setBoardValue(1,2,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(1,2,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn6.setBackground(Color.WHITE);
		btn6.setBounds(0, -1, 101, 101);
		panel_10.add(btn6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(23, 232, 100, 97);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		btn7 = new JButton("");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(2,0,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(2,0,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn7.setBackground(Color.WHITE);
		btn7.setBounds(-1, -1, 101, 101);
		panel_11.add(btn7);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(130, 232, 100, 97);
		contentPane.add(panel_12);
		panel_12.setLayout(null);
		
		btn8 = new JButton("");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(2,1,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(2,1,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn8.setBackground(Color.WHITE);
		btn8.setBounds(0, 0, 100, 100);
		panel_12.add(btn8);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(237, 232, 100, 97);
		contentPane.add(panel_13);
		panel_13.setLayout(null);
		
		btn9 = new JButton("");
		btn9.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player==1){
		            board.setBoardValue(2,2,3);
		            refreshBoardDisplay();
		            if(board.checkWin(1))
		            {
		            	JOptionPane.showMessageDialog(btn5," Congrats!! You Won");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		                
		                
		        }
		        else{
		             board.setBoardValue(2,2,5);
		            refreshBoardDisplay();
		            if(board.checkWin(2))
		            {
		                JOptionPane.showMessageDialog(btn5,"Congrats!!,You Win");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else if(board.isBoardFilled())
		            {
		                JOptionPane.showMessageDialog(btn5,"Game Draw");
		                board.initializeBoard();
		                refreshBoardDisplay();
		                setPlayer(1);
		            }
		            else
		            {
		                setPlayer(3-player);
		                playComputer();
		            }
		        }
			}
		});
		btn9.setBackground(Color.WHITE);
		btn9.setBounds(0, 0, 101, 100);
		panel_13.add(btn9);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					Game game = new Game();
					game.setButtonReferences();
					game.setVisible(true);
					game.board = new Board();
					game.board.initializeBoard();
					game.setPlayer(1);
					game.refreshBoardDisplay();
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	

}
