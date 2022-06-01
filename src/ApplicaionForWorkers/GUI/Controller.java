package ApplicaionForWorkers.GUI;

import ApplicaionForWorkers.GUI.DataBase.DB;
import ApplicaionForWorkers.GUI.TableModel.DetailTableModel;
import ApplicaionForWorkers.GUI.TableModel.ReportTableModel;
import ApplicaionForWorkers.GUI.TableModel.WorkerTableModel;
import ApplicaionForWorkers.GUI.Window.DetailInputWindow;
import ApplicaionForWorkers.GUI.Window.View;
import ApplicaionForWorkers.GUI.Window.WorkerInputWindow;
import ApplicaionForWorkers.GUI.Window.AddWorkInputWindow;
import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.ReportAboutWorks;
import ApplicaionForWorkers.Model.Workers;
import jdk.nashorn.internal.parser.DateParser;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    private WorkerTableModel workerTableModel;
    private DetailTableModel detailTableModel;
    private ReportTableModel reportTableModel;
    private TableRowSorter<AbstractTableModel> sorter;
    private Company company;
    private int selectFlag = 1;//выбран список работников
    private DB db;

    public Controller(Company company, DB db){
        this.company = company;
        this.db = db;
    }

    public void execute(View view){
        reportTableModel = new ReportTableModel(company);
        workerTableModel = new WorkerTableModel(company);
        detailTableModel = new DetailTableModel(company);
        view.getTable().setModel(reportTableModel);
        view.getListOfTasks().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = 1;
                view.getTable().setModel(reportTableModel);
            }
        });
        view.getListOfDetails().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = 2;
                view.getTable().setModel(detailTableModel);
            }
        });

        view.getListOfWorkers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = 3;
                view.getTable().setModel(workerTableModel);
            }
        });
        view.getAddWorker().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                executeWorkerInputWindow(new WorkerInputWindow());
            }
        });
        view.getAddProduct().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                executeDetailInputWindow(new DetailInputWindow());
            }
        });



        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFlag == 3) {
                    executeWorkerInputWindow(new WorkerInputWindow());
                }  else   {
                    executeDetailInputWindow(new DetailInputWindow());
                }
            }
        });

//        view.getUpdateButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                executeAddWorkInputWindow(new AddWorkInputWindow());
//            }
//        });

        view.getDelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = -1;
                try{
                    db.openDB();
                    index = view.getTable().getSelectedRow();

                    if (index == -1)
                        throw new Exception("Не выбрана строка");
                    if (selectFlag == 3){
                        db.deleteWorker(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow()));
                        company.deleteWorker(index);
                        workerTableModel.fireTableDataChanged();
                        db.closeDB();
                    } else if(selectFlag == 2) {
                        db.deleteDetail(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow()));
                        company.deleteDetail(index);
                        detailTableModel.fireTableDataChanged();
                        db.closeDB();
                    } else if (selectFlag == 1){

                    }
                    db.closeDB();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }
            }
        });

        view.getSearchField().getDocument().addDocumentListener(new DocumentListener() {

            public void newFilter(){
                if (selectFlag == 3){
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
                    db.openDB();
                    int code = Integer.parseInt(window.getCodeField().getText());
                    String title = window.getTitleField().getText();
                    int departmentNumberForDetail = Integer.parseInt(window.getDepartmentField().getText());
                    int quantity = Integer.parseInt(window.getQuantityField().getText());
                    Detail d = new Detail(code, title, departmentNumberForDetail, quantity);
                    db.createDetail(d);
                    company.addDetail(d);
                    window.dispose();
                    detailTableModel.fireTableDataChanged();
                    db.closeDB();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

            }
        });
    }
//    public void executeAddWorkInputWindow(AddWorkInputWindow window){
//        window.getAddButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    db.openDB();
//                    int idWorker = Integer.parseInt(window.getIdWorkerField().getText());
//                    String workWithDetails = window.getWorkWithDetailField().getText();
//                    int codeDetail = Integer.parseInt(window.getCodeDetailField().getText());
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date dateOfCompleteWork = new Date(window.getCompleteDateField().getText());
//                      ReportAboutWorks r = new ReportAboutWorks(idWorker, workWithDetails, codeDetail, dateOfCompleteWork);
//                    db.createWorker(w);
//                    company.addWorker(w);
//                    window.dispose();
//                    workerTableModel.fireTableDataChanged();
//                    db.closeDB();
//                }catch (Exception ex){
//                    System.out.println(ex.getMessage());
//                }
//
//            }
//        });
//    }

    public void executeWorkerInputWindow(WorkerInputWindow window){
        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int  departmentNumber = Integer.parseInt(window.getDepartmentNumberField().getText());
                    String fullname = window.getFullnameField().getText();
                    String position = window.getPositionField().getText();
                    String address = window.getAddressField().getText();
                    String phoneNumber = window.getPhoneNumberField().getText();
                    int salary = Integer.parseInt(window.getSalaryField().getText());
                    Workers w = new Workers(departmentNumber,fullname, position, address, phoneNumber, salary);
                    db.createWorker(w);
                    company.addWorker(w);
                    window.dispose();
                    workerTableModel.fireTableDataChanged();
                    db.closeDB();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

            }
        });
    }
    public void setDataBase(DB db){
        this.db = db;
    }
}
