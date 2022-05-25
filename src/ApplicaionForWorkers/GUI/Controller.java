package ApplicaionForWorkers.GUI;

import ApplicaionForWorkers.GUI.TableModel.DetailTableModel;
import ApplicaionForWorkers.GUI.TableModel.WorkerTableModel;
import ApplicaionForWorkers.GUI.Window.DetailInputWindow;
import ApplicaionForWorkers.GUI.Window.View;
import ApplicaionForWorkers.GUI.Window.WorkerInputWindow;
import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.Workers;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private WorkerTableModel workerTableModel;
    private DetailTableModel detailTableModel;
    private TableRowSorter<AbstractTableModel> sorter;
    private Company company;
    private boolean selectFlag = true;//выбран список работников

    public void execute(View view){
        company = new Company();
        workerTableModel = new WorkerTableModel(company);
        detailTableModel = new DetailTableModel(company);
        view.getTable().setModel(workerTableModel);
        company.addDetail(new Detail(1,"диск", 56));
        view.getListOfProducts().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = false;
                view.getTable().setModel(detailTableModel);
            }
        });

        view.getListOfWorkers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = true;
                view.getTable().setModel(workerTableModel);
            }
        });

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFlag){
                    executeWorkerInputWindow(new WorkerInputWindow());
                }else {
                    executeDetailInputWindow(new DetailInputWindow());
                }
            }
        });

        view.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFlag){
                    workerTableModel.fireTableDataChanged();
                }else {
                    detailTableModel.fireTableDataChanged();
                }
            }
        });

        view.getDelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = -1;
                try{
                    index = view.getTable().getSelectedRow();

                    if (index == -1)
                        throw new Exception("Не выбрана строка");
                    if (selectFlag){
                        company.deleteWorker(index);
                    }else {
                        company.deleteDetail(index);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }
            }
        });

        view.getSearchField().getDocument().addDocumentListener(new DocumentListener() {

            public void newFilter(){
                if (selectFlag){
                    sorter = new TableRowSorter<>(workerTableModel);
                }else {
                    sorter = new TableRowSorter<>(detailTableModel);
                }

                view.getTable().setRowSorter(sorter);
                RowFilter<AbstractTableModel,Object> rf = null;

                try {
                    rf = RowFilter.regexFilter("(?i)" + view.getSearchField().getText());

                }
                catch(java.util.regex.PatternSyntaxException e) {
                    return;
                }
                sorter.setRowFilter(rf);
            }
            @Override
            public void insertUpdate(DocumentEvent de) {
                newFilter();

            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                newFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                newFilter();
            }
        });

    }

    public void executeDetailInputWindow(DetailInputWindow window){
        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int code = Integer.parseInt(window.getCodeField().getText());
                    String title = window.getTitleField().getText();
                    int quantity = Integer.parseInt(window.getQuantityField().getText());
                    company.addDetail(new Detail(code, title, quantity));
                    window.dispose();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    public void executeWorkerInputWindow(WorkerInputWindow window){
        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullname = window.getFullnameField().getText();
                    String position = window.getPositionField().getText();
                    String education = window.getEducationField().getText();
                    String address = window.getAddressField().getText();
                    String phoneNumber = window.getPhoneNumberField().getText();
                    int salary = Integer.parseInt(window.getSalaryField().getText());
                    company.addWorker(new Workers(fullname, position, education, address, phoneNumber, salary));
                    window.dispose();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
