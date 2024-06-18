package org.example.util;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ModernButton extends JButton {
    private int cornerRadius;

    public ModernButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(new Color(41, 128, 185)); // Modern blue color
        setForeground(Color.WHITE); // White text color
        this.cornerRadius = 20; // Rounded corners
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the background
        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Draw the label
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        Rectangle stringBounds = fm.getStringBounds(getText(), g2).getBounds();
        int textX = (getWidth() - stringBounds.width) / 2;
        int textY = (getHeight() - stringBounds.height) / 2 + fm.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        FontMetrics fm = getFontMetrics(getFont());
        int width = fm.stringWidth(getText()) + 40;
        int height = fm.getHeight() + 20;
        return new Dimension(width, height);
    }

    @Override
    public boolean contains(int x, int y) {
        RoundRectangle2D rectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        return rectangle.contains(x, y);
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Modern Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        ModernButton button = new ModernButton("Click Me");
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.getContentPane().add(button);

        frame.setVisible(true);
    }
}
