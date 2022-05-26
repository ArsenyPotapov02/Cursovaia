package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.*;

public class WorkerInputWindow extends JFrame {
    private JLabel fullnameLabel = new JLabel("Имя рабочего");
    private JLabel positionLabel = new JLabel("Тип профессии");
    private JLabel educationLabel = new JLabel("Тип образования");
    private JLabel addressLabel = new JLabel("Адрес");
    private JLabel phoneNumberLabel = new JLabel("Номер телефона");
    private JLabel salaryLabel = new JLabel("Зарплата");
    private JLabel headLabel = new JLabel("Работник");
    private  JTextField fullnameField;
    private  JTextField positionField;
    private  JTextField educationField;
    private  JTextField addressField;
    private  JTextField phoneNumberField;
    private JTextField salaryField;
    private JButton addButton;
    private Container container;

    public WorkerInputWindow(){
        setTitle("Добавление");
        container = new Container();
        container.setLayout(new GridLayout(6, 2, 1, 5));
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        fullnameField = new JTextField();
        positionField = new JTextField();
        educationField = new JTextField();
        addressField = new JTextField();
        phoneNumberField = new JTextField();
        salaryField = new JTextField();
        addButton = new JButton("Добавить");
        headLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headLabel);
        container.add(fullnameLabel);
        container.add(fullnameField);
        container.add(positionLabel);
        container.add(positionField);
        container.add(educationLabel);
        container.add(educationField);
        container.add(addressLabel);
        container.add(addressField);
        container.add(phoneNumberLabel);
        container.add(phoneNumberField);
        container.add(salaryLabel);
        container.add(salaryField);
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

    public JTextField getEducationField() {
        return educationField;
    }

    public JTextField getFullnameField() {
        return fullnameField;
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
