package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.*;

public class DetailInputWindow extends JFrame {
    private JLabel codeLabel = new JLabel("Код детали");
    private JLabel titleLabel = new JLabel("Название детали");
    private JLabel departmentLabel = new JLabel("Номер отдела");
    private JLabel quantityLabel = new JLabel("Количество");
    private JLabel headLabel = new JLabel("Деталь");
    private JTextField codeField;
    private JTextField titleField;
    private JTextField quantityField;
    private JTextField departmentField;
    private JButton addButton;
    private Container container;

    public DetailInputWindow(){
        setTitle("Добавление");
        container = new Container();
        container.setLayout(new GridLayout(4, 2, 1,5));
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        codeField = new JTextField();
        titleField = new JTextField();
        departmentField = new JTextField();
        quantityField = new JTextField();
        addButton = new JButton("Добавить");
        headLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headLabel);
        container.add(codeLabel);
        container.add(codeField);
        container.add(titleLabel);
        container.add(titleField);
        container.add(departmentLabel);
        container.add(departmentField);
        container.add(quantityLabel);
        container.add(quantityField);
        add(container);
        addButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(addButton);
        setVisible(true);
        pack();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getCodeField() {
        return codeField;
    }

    public JTextField getQuantityField() {
        return quantityField;
    }

    public JTextField getTitleField() {
        return titleField;
    }
    public JTextField getDepartmentField(){
        return departmentField;
    }

}
