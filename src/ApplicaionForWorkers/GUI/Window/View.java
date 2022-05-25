package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class View extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu menuEdit;
    private JMenu menuShowTables;
    private JMenuItem addWorker;
    private JMenuItem addProduct;
    private JMenuItem listOfWorkers;
    private JMenuItem listOfProducts;
    private JPanel topPanel;
    private JTextField searchField;
    private JButton addButton;
    private JButton delButton;
    private JButton updateButton;
    private JButton editButton;
    private JButton searchButton;

    public  View(){
        menuBar = new JMenuBar();
        menuEdit = new JMenu("Редактирование");
        addProduct = new JMenuItem("Добавление детали");
        addWorker = new JMenuItem("Добавление работника");

        menuEdit.add(addProduct);
        menuEdit.add(addWorker);
        menuBar.add(menuEdit);

        menuShowTables = new JMenu("Список");
        listOfProducts = new JMenuItem("Детали");
        listOfWorkers = new JMenuItem("Работники");

        menuShowTables.add(listOfProducts);
        menuShowTables.add(listOfWorkers);
        menuBar.add(menuShowTables);

        setJMenuBar(menuBar);
        menuBar.add(Box.createHorizontalGlue());

        topPanel = new JPanel();
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200,25));
        addButton = new JButton("Добавить");
        editButton = new JButton("Редактировать");
        delButton = new JButton("Удалить");
        updateButton = new JButton("Обновить");
        searchButton = new JButton("Поиск");
        topPanel.add(addButton);
        topPanel.add(delButton);
        topPanel.add(updateButton);
        topPanel.add(editButton);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDelButton() {
        return delButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JMenuItem getAddProduct() {
        return addProduct;
    }

    public JMenuItem getAddWorker() {
        return addWorker;
    }

    public JMenuItem getListOfProducts() {
        return listOfProducts;
    }

    public JMenuItem getListOfWorkers() {
        return listOfWorkers;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getSearchField() {
        return searchField;
    }
}
