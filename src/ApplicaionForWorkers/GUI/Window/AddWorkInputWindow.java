package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.*;

public class AddWorkInputWindow extends JFrame {
    private JLabel idWorkerLabel = new JLabel("ID работника");
    private JLabel workWithDetailLabel = new JLabel("Работа с деталью");
    private JLabel codeDetailLabel = new JLabel("ID детали");
    private JLabel completeCheckLabel = new JLabel("Статус");
    private JLabel headLabel = new JLabel("Задача");

    private JTextField idWorkerField;
    private JTextField workWithDetailField;
    private JTextField codeDetailField;
    private JTextField completeCheckField;

    private JButton addButton;
    private Container container;

    public AddWorkInputWindow(){
        setTitle("Добавление работы");
        container = new Container();
        container.setLayout(new GridLayout(4,2,1,5));
        this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        idWorkerField = new JTextField();
        codeDetailField = new JTextField();
        workWithDetailField = new JTextField();
        completeCheckField = new JTextField();
        addButton = new JButton("Добавить");
        headLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headLabel);

        container.add(idWorkerLabel);
        container.add(idWorkerField);
        container.add(workWithDetailLabel);
        container.add(workWithDetailField);
        container.add(codeDetailLabel);
        container.add(codeDetailField);
        container.add(completeCheckLabel);
        container.add(completeCheckField);
        add(container);
        addButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(addButton);
        setVisible(true);
        pack();
    }

    public JTextField getCodeDetailField() {
        return codeDetailField;
    }

    public JTextField getIdWorkerField() {
        return idWorkerField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getCompleteCheckField() {
        return completeCheckField;
    }

    public JTextField getWorkWithDetailField() {
        return workWithDetailField;
    }

}
