package ApplicaionForWorkers.GUI.window;

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
    private JPanel panelRight;
    private JLabel searchLabel;
    private JTextField searchField;


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

        panelRight = new JPanel();
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(100,20));
        searchLabel = new JLabel("Поиск");
        panelRight.setLayout(new GridLayout(1,1,1,1));
        panelRight.add(searchField);
        panelRight.add(searchLabel);


        scrollPane = new JScrollPane();

        setJMenuBar(menuBar);
        menuBar.add(Box.createHorizontalGlue());
        add(scrollPane, BorderLayout.CENTER);
        add(panelRight,BorderLayout.EAST);
        setVisible(true);
        setSize(1500,500);


    }
}
