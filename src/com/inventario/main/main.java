package com.inventario.main;

import com.inventario.gui.ProductRegistrationFrame;
import javax.swing.SwingUtilities;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductRegistrationFrame frame = new ProductRegistrationFrame();
            frame.setVisible(true);
        });
    }
}