package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.inventario.model.Product;
import com.inventario.model.ProductTableModel;

public class ProductRegistrationFrame extends JFrame {
    private JTextField idField, nameField, priceField, quantityField;
    private JButton saveButton;
    private JTable productTable;
    private ProductTableModel tableModel;

    public ProductRegistrationFrame() {
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Precio:"));
        priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("Cantidad:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        saveButton = new JButton("Guardar");
        panel.add(saveButton);

        tableModel = new ProductTableModel();
        productTable = new JTable(tableModel);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });
    }

    private void saveProduct() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(id, name, price, quantity);
            tableModel.addProduct(product);

            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }
}
