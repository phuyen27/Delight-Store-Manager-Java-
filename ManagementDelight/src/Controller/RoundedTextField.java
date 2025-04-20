/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author USER
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundedTextField extends JTextField {

    // Khai báo bán kính bo tròn
    private int radius = 20;

    public RoundedTextField(int columns) {
        super(columns);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Vẽ phần nền của text field
        super.paintComponent(g);
        
        // Đảm bảo vẽ trong vùng của các góc bo tròn
        if (getBorder() == null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Vẽ nền bo tròn
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Tùy chỉnh viền của TextField
        super.paintBorder(g);
        if (getBorder() == null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.GRAY);  // Màu viền của textfield
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }
    }
}

