/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncyball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author zdv5950
 */
public class BouncyBall extends JPanel implements ActionListener{

    public final int PANEL_WIDTH = 1000;
    public final int PANEL_HEIGHT = 700;
    private ArrayList<Ball> ballArray;
    
    private JButton addBall;
    private JButton removeBall;
    public BouncyBall() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.white);
        ballArray = new ArrayList<>();
        
        JPanel buttons = new JPanel();
        addBall = new JButton("add");
        addBall.addActionListener(this);
        buttons.add(addBall);
        removeBall = new JButton("remove");
        removeBall.addActionListener(this);
        buttons.add(removeBall);
        
        add(buttons, BorderLayout.SOUTH);
        Timer timer = new Timer(14, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ballArray.forEach((b) -> {
            b.drawBall(g);
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BouncyBall myPanel = new BouncyBall();
        
        JFrame frame = new JFrame("Bouncy"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(myPanel);  //add instance of MyGUI to the frame
        
        frame.pack(); //resize frame to fit our Jpanel
        frame.setResizable(true);
        //Position frame on center of screen 
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
	//show the frame	
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            //ballArray.add(new Ball(getWidth(), getHeight() - 40));
            ballArray.forEach((b) -> {
            b.move(getWidth(), getHeight() - 40);
        });
            repaint();
        }
        if (e.getSource() instanceof JButton) {
            System.out.println("JButton");
        }
        if (e.getSource() == addBall) {
            System.out.println("add");
            ballArray.add(new Ball(getWidth(), getHeight() - 40));
        }
        if (e.getSource() == removeBall) {
            System.out.println("remove");
            ballArray.remove(ballArray.size() - 1);
        }
    }
    
}
