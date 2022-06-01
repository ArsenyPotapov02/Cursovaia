package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
    private JMenuItem listOfDetails;
    private JMenuItem listOfTasks;
    private JPanel topPanel;
    private JTextField searchField;
    private JButton addButton;
    private JButton delButton;
    private JButton updateButton;
    private JButton editButton;
    private JLabel searchLabel;

    public  View(){
        menuBar = new JMenuBar();
        menuEdit = new JMenu("Добавление");
        addProduct = new JMenuItem("Добавление детали");
        addWorker = new JMenuItem("Добавление работника");

        menuEdit.add(addProduct);
        menuEdit.add(addWorker);
        menuBar.add(menuEdit);

        menuShowTables = new JMenu("Список");
        listOfDetails = new JMenuItem("Детали");
        listOfWorkers = new JMenuItem("Работники");
        listOfTasks = new JMenuItem("Задачи");

        menuShowTables.add(listOfDetails);
        menuShowTables.add(listOfWorkers);
        menuShowTables.add(listOfTasks);

        menuBar.add(menuShowTables);

        setJMenuBar(menuBar);
        menuBar.add(Box.createHorizontalGlue());

        topPanel = new JPanel();
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200,25));
        addButton = new JButton("Добавить");
        editButton = new JButton("Редактировать");
        delButton = new JButton("Удалить");
        updateButton = new JButton("Cоздать задачу для работника");
        searchLabel = new JLabel("Поиск");
        topPanel.add(addButton);
        topPanel.add(delButton);
        topPanel.add(updateButton);
        topPanel.add(editButton);
        topPanel.add(searchField);
        topPanel.add(searchLabel);
        add(topPanel, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        setPreferredSize(new Dimension(855,500));
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

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JMenuItem getAddProduct() {
        return addProduct;
    }

    public JMenuItem getAddWorker() {
        return addWorker;
    }

    public JMenuItem getListOfDetails() {
        return listOfDetails;
    }

    public JMenuItem getListOfWorkers() {
        return listOfWorkers;
    }
    public JMenuItem getListOfTasks(){return listOfTasks;}

    public JTable getTable() {
        return table;
    }

    public JTextField getSearchField() {
        return searchField;
    }
}
