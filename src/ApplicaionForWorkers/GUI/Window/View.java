package ApplicaionForWorkers.GUI.Window;

import ApplicaionForWorkers.GUI.TableModel.ReportTableModel;

import javax.swing.*;
import java.awt.*;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import javax.swing.table.TableCellRenderer;

public class View extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu menuEdit;
    private JMenu  reference;
    private JMenuItem menuUserManual;
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
        reference = new JMenu("Справка");
        menuUserManual = new JMenuItem("Руководство пользователя");
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

        reference.add(menuUserManual);
        menuBar.add(reference);

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
        topPanel.add(editButton);
        topPanel.add(updateButton);
        topPanel.add(searchField);
        topPanel.add(searchLabel);
        add(topPanel, BorderLayout.NORTH);

        table = new JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                if(!isRowSelected(row) ){
                if ( getModel()instanceof ReportTableModel) {
                    if (table.getColumnCount() >= 0) {
                        String type = (String)getModel().getValueAt(row, 6);
                        if (type.equalsIgnoreCase("+" )) {
                            c.setBackground(new Color(146, 234, 106));
                        } else if (type.equalsIgnoreCase("-")) {
                            c.setBackground(new Color(0xE56778));
                        }
                    }
                }else {c.setBackground( Color.white);}
                }

                return c;
            }



        };
        table.setEnabled(true);

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

    public JMenuItem getMenuUserManual() {
        return menuUserManual;
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
