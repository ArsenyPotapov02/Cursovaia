package ApplicaionForWorkers.GUI.Window;

import javax.swing.*;
import java.awt.*;

public class UpdateWorkWindow extends JFrame {




    private JLabel idWorkerLabel = new JLabel("ID работника");
    private JLabel workWithDetailLabel = new JLabel("Работа с деталью");
    private JLabel codeDetailLabel = new JLabel("ID детали");
    private JLabel completeCheckLabel = new JLabel("Статус");
    private JLabel headLabel = new JLabel("Редактирование");

    private  JTextField workWithDetailField;
    private  JTextField completeCheckField;
    private  JTextField codeDetailField;
    private JTextField idWorkerField;


    private JButton addButton;
    private Container container;

    public UpdateWorkWindow(){
        setTitle("Добавление");
        container = new Container();
        container.setLayout(new GridLayout(5, 2, 1, 5));
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        completeCheckField = new JTextField();
        codeDetailField = new JTextField();
        idWorkerField = new JTextField();
        workWithDetailField = new JTextField();


        addButton = new JButton("Внести изменения");
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

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getWorkWithDetailField() {
        return workWithDetailField;
    }

    public JTextField getCompleteCheckField() {
        return completeCheckField;
    }

    public JTextField getIdWorkerField() {
        return idWorkerField;
    }

    public JTextField getCodeDetailField() {
        return codeDetailField;
    }
}
