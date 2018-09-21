/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncyball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author zdv5950
 */
public class Ball {
    
    private Color color;
    private int ballSize;
    private int x;
    private int y;
    private float moveX;
    private float moveY;
    private static Random rand = new Random();
    
    public Ball(int panelWidth, int panelHeight) {
        ballSize = ((rand.nextInt(14) + 11) * 10);
        x = rand.nextInt(panelWidth - ballSize);
        y = rand.nextInt(panelHeight - ballSize);
        
        moveX = (rand.nextInt(4) + 1) * ((rand.nextInt(1) == 0) ? -1 : 1);
        moveY = (rand.nextInt(4) + 1) * ((rand.nextInt(1) == 0) ? -1 : 1);
        moveX = moveX;
        moveY = moveY;
        color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }
    
    public void drawBall(Graphics g) {
        g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
        g.fillRect(x, y, ballSize, ballSize);
        g.setColor(color);
        g.fillOval(x, y, ballSize, ballSize);
        g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
        g.drawOval(x, y, ballSize, ballSize);
        
    }
    
    public void move(int panelWidth, int panelHeight) {
        if (x < 0) {
            moveX = -1 * moveX;
            x = 0;
        }
        if (x > panelWidth - ballSize) {
            moveX = -1 * moveX;
            x = panelWidth - ballSize;
        }
        if (y < 0) {
            moveY = -1 * moveY;
            y = 0;
        }
        if (y > panelHeight - ballSize) {
            moveY = -1 * moveY;
            y = panelHeight - ballSize;
        }
        
        int max = rand.nextInt(50) + rand.nextInt(50) + 1;
        //int max = 10;
        if (Math.abs(moveX) > max) {
            moveX = Math.signum(moveX) * max;
        }
        else {
            moveX += 1 * Math.signum(moveX);
        }
        if (Math.abs(moveY) > max) {
            moveY = Math.signum(moveY) * max;
        }
        else {
            moveY += 1 * Math.signum(moveX);
        }
        /*moveX += 0.1f * Math.signum(moveX);
        moveY += 0.05f * Math.signum(moveX);*/
        moveX = moveX + rand.nextInt(10) - 5;
        moveY = moveY + rand.nextInt(10) - 5;
        x += moveX;
        y += moveY;
    }
}
