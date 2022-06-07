package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.*;

public class WorkerInputWindow extends JFrame {
    private JLabel departmentNumberLabel = new JLabel("Номер отдела");
    private JLabel fullnameLabel = new JLabel("Фио работника");
    private JLabel  positionLabel= new JLabel("Должность");
    private JLabel addressLabel = new JLabel("Адрес");
    private JLabel phoneNumberLabel = new JLabel("Номер телефона");
    private JLabel salaryLabel = new JLabel("Зарплата");
    private JLabel passwordLabel = new JLabel("Пароль");
    private JLabel headLabel = new JLabel("Работник");
    private  JTextField fullnameField;
    private  JTextField positionField;
    private  JTextField departmentNumberField;
    private  JTextField addressField;
    private  JTextField phoneNumberField;
    private JTextField salaryField;
    private JTextField passwordField;
    private JButton addButton;
    private Container container;

    public WorkerInputWindow(){
        setTitle("Добавление");
        container = new Container();
        container.setLayout(new GridLayout(7, 2, 1, 5));
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        fullnameField = new JTextField();
        positionField = new JTextField();
        departmentNumberField = new JTextField();
        addressField = new JTextField();
        phoneNumberField = new JTextField();
        salaryField = new JTextField();
        passwordField = new JTextField();
        addButton = new JButton("Добавить");
        headLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headLabel);
        container.add(departmentNumberLabel);
        container.add(departmentNumberField);
        container.add(fullnameLabel);
        container.add(fullnameField);
        container.add(positionLabel);
        container.add(positionField);
        container.add(addressLabel);
        container.add(addressField);
        container.add(phoneNumberLabel);
        container.add(phoneNumberField);
        container.add(salaryLabel);
        container.add(salaryField);
        container.add(passwordLabel);
        container.add(passwordField);
        add(container);
        addButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(addButton);

        setVisible(true);
        pack();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getDepartmentNumberField() {
        return departmentNumberField;
    }

    public JTextField getFullnameField() {
        return fullnameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JTextField getPositionField() {
        return positionField;
    }

    public JTextField getSalaryField() {
        return salaryField;
    }
}
