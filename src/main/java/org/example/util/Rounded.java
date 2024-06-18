package org.example.util;

import javax.swing.*;
import java.awt.*;

// Custom button with rounded corners
public class Rounded extends JButton {
    public Rounded(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        g2.dispose();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setUI(new RoundedUI());
    }
}

class RoundedUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JButton button = (JButton) c;
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}