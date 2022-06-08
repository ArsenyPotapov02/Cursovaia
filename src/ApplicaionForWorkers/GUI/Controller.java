package ApplicaionForWorkers.GUI;

import ApplicaionForWorkers.utility.DataBase.DB;
import ApplicaionForWorkers.utility.Security.Encryption;
import ApplicaionForWorkers.GUI.TableModel.DetailTableModel;
import ApplicaionForWorkers.GUI.TableModel.ReportTableModel;
import ApplicaionForWorkers.GUI.TableModel.WorkerTableModel;
import ApplicaionForWorkers.GUI.Window.*;
import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.Workers;



import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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


        view.getListOfTasks().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = 1;
                view.getTable().setModel(reportTableModel);
                view.getAddButton().setVisible(false);
                view.getUpdateButton().setVisible(true);
            }
        });
        view.getListOfDetails().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = 2;
                view.getTable().setModel(detailTableModel);
                view.getAddButton().setVisible(true);
                view.getUpdateButton().setVisible(false);
            }
        });

        view.getListOfWorkers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFlag = 3;
                view.getTable().setModel(workerTableModel);
                view.getAddButton().setVisible(true);
                view.getUpdateButton().setVisible(false);
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
        view.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = view.getTable().getSelectedRow();
                    if(row == -1) {
                        throw new Exception("Строка не выбрана");
                    }

                    if (selectFlag == 2) {
                        executeUpdateDetailWindow(new UpdateDetailWindow(), row);
                    } else if (selectFlag == 3) {
                        executeUpdateWorkerWindow(new UpdateWorkerWindow(), row);
                    } else if (selectFlag == 1) {
                        executeUpdateWorkWindow(new UpdateWorkWindow(), row);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(view,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }
            }
        });
        view.getMenuUserManual().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view,
                        ("<html>"+  "Авторизация" + "<br>" +
                                " "+"<br>"+
                        "1. На окне авторизации в поля ввода (Логин) нужно вписать номер работника предприятия, а пароль обязан сообщить начальник отдела к которому работник привязан." +"<br>" +
                                " "+"<br>"+
                        "Взаимодействие с интерфейсом: удаление, редактирование, добавление записи. " +"<br>"+
                                " "+"<br>"+
                        "1. Для того чтобы удалить какую либо запись, нужно выделить курсором необходимую строку и нажать на кнопку (Удалить)." +"<br>"+
                        "2. Чтобы отредактровать какую либо  запись, нужно выделить курсором необходимую строку и нажать на кнопку (Редактировать)."+"<br>"+
                        "После нажатия на кнопку перед вами появится окно для редактирования. Изменения должны сопровождаться сохранением типа данных!!! "+"<br>"+
                        "Как нужные изменения будут внесены, сохраните изменённую запись, нажав на кнопку (Внести изменения)."+"<br>"+
                        "3. Добавление записи в заданную таблицу производится с помощью нажатия кнопки (Добавить). При добавлении данных в поля, следует учитывать значения, которые вы вносите."+"<br>"+
                        "В поле ввода номера телефона работника данные необходимо вводить через символы (+7)."+"<br>"+
                                "</html>"),
                        "Руководство пользователя", JOptionPane.INFORMATION_MESSAGE );
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

        view.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeAddWorkInputWindow(new AddWorkInputWindow());
            }
        });

//        view.getEditButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                try {
//                    if (selectFlag == 1) {
//                        int row = view.getTable().getSelectedRow();
//                        int codeDetail = company.getReportList().get(row).getCodeDetail();
//                        int iDWork = company.getReportList().get(row).getiDWork();
//                        int iDWorker = company.getReportList().get(row).getiDWorker();
//
//
//                        String cell5 = view.getTable().getModel().getValueAt(row, 4).toString();
//                        String cell7 = view.getTable().getModel().getValueAt(row, 6).toString();
//                        try {
//                            db.updateAccomplishment(iDWorker, cell5, cell7, codeDetail, iDWork);
//                        } catch (Exception ex) {
//
//
//                        }
//                    } else if(selectFlag == 2){
//                        int row = view.getTable().getSelectedRow();
//                        int codeDetail = company.getAllDetailsList().get(row).getCode();
//                        int departmentNumber = company.getAllDetailsList().get(row).getDepartmentNumberForDetail();
//                        int quantity = company.getAllDetailsList().get(row).getQuantity();
//
//
//                        String cell2 = view.getTable().getModel().getValueAt(row,1).toString();
//
//                        try {
//                            db.updateDetails(codeDetail,cell2,departmentNumber,quantity);
//                        } catch (Exception ex){
//
//                        }
//
//
//                    }else if(selectFlag == 3){
//
//                    }
//                }catch (Exception ex){}
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
                        throw new Exception("Строка не выбрана");
                    if (selectFlag == 3){
                        Workers w = company.getWorker(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow()));
                        db.deleteWorker(w.getIdWorker());
                        company.setWorkersList(db.getWorketsList(company.getDepartmentNumber()));
                        workerTableModel.fireTableDataChanged();
                        db.closeDB();
                    } else if(selectFlag == 2) {
                        Detail d =company.getDetail(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow()));
                        db.deleteDetail(d.getCode());
                        company.setDetailList(db.getDetailsList(company.getDepartmentNumber()));
                        detailTableModel.fireTableDataChanged();
                        db.closeDB();
                    } else if (selectFlag == 1){
                        int iDWork =  company.getReportList().get(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow())).getiDWork();
                        int iDWorker = company.getReportList().get(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow())).getiDWorker();
                        int code = company.getReportList().get(view.getTable().convertRowIndexToModel(view.getTable().getSelectedRow())).getCodeDetail();
                        db.deleteWork(iDWork);
                        company.setReportList(db.getReportList(company.getDepartmentNumber()));
                        reportTableModel.fireTableDataChanged();
                        db.closeDB();
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
                }else if(selectFlag == 2){
                    sorter = new TableRowSorter<>(detailTableModel);
                } else if(selectFlag == 1){
                    sorter = new TableRowSorter<>(reportTableModel);
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
        window.getDepartmentField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getCodeField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getQuantityField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });

        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int code =0;
                    int departmentNumberForDetail = 0;
                    int quantity= 0;
                    if (window.getCodeField().getText().isEmpty()){
                        throw new Exception("Значение код детали не введено");
                    }
                    else {
                        code = Integer.parseInt(window.getCodeField().getText());
                    }
                    String title = window.getTitleField().getText();
                    if (title.equals("")){
                        throw new Exception("Введите значение в поле 'Название'");
                    }

                    if (window.getDepartmentField().getText().isEmpty()){
                        throw new Exception("Значение код детали не введено");
                    }
                    else {
                        departmentNumberForDetail = Integer.parseInt(window.getDepartmentField().getText());
                    }

                    if (window.getQuantityField().getText().isEmpty()){
                        throw new Exception("Значение количество не введено");
                    }
                    else {
                        quantity = Integer.parseInt(window.getQuantityField().getText());
                    }
                    Detail d = new Detail(code, title, departmentNumberForDetail, quantity);
                    db.createDetail(d);
                    company.setDetailList(db.getDetailsList(company.getDepartmentNumber()));
                    detailTableModel.fireTableDataChanged();
                    db.closeDB();
                    window.dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(window,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }

            }
        });
    }
    public void executeUpdateDetailWindow(UpdateDetailWindow window, int row) throws Exception {

        window.getCodeField().setText(Integer.toString(company.getDetail(row).getCode()));
        window.getTitleField().setText(company.getDetail(row).getTitle());
        window.getDepartmentField().setText(Integer.toString(company.getDetail(row).getDepartmentNumberForDetail()));
        window.getQuantityField().setText(Integer.toString(company.getDetail(row).getQuantity()));

        window.getDepartmentField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getCodeField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getQuantityField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int code = 0;
                    int quantity = 0;
                    int departmentNumberForDetail = 0;
                    if (window.getCodeField().getText().isEmpty()){
                        throw new Exception("Значение код детали не введено");
                    }
                    else {
                        code = Integer.parseInt(window.getCodeField().getText());
                    }
                    String title = window.getTitleField().getText();
                    if (title.equals("")){
                        throw new Exception("Введите значение в поле 'Название'");
                    }

                    if (window.getDepartmentField().getText().isEmpty()){
                        throw new Exception("Значение код детали не введено");
                    }
                    else {
                        departmentNumberForDetail = Integer.parseInt(window.getDepartmentField().getText());
                    }

                    if (window.getQuantityField().getText().isEmpty()){
                        throw new Exception("Значение количество не введено");
                    }
                    else {
                        quantity = Integer.parseInt(window.getQuantityField().getText());
                    }

                    db.updateDetails(code,title,departmentNumberForDetail,quantity);
                    company.getDetail(row).setCode(code);
                    company.getDetail(row).setTitle(title);
                    company.getDetail(row).setDepartmentNumberForDetail(departmentNumberForDetail);
                    company.getDetail(row).setQuantity(quantity);

                    detailTableModel.fireTableDataChanged();
                    db.closeDB();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(window,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }
                window.dispose();
            }
        });
    }

    public void executeUpdateWorkWindow(UpdateWorkWindow window,int row) throws Exception {

        String a[] = company.getPosition().split(" ");
        for(int i = 0; i<a.length; i++) {
            if (a[i].equalsIgnoreCase("Начальник")) {

                break;
            } else {
                window.getWorkWithDetailField().setEnabled(false);
                window.getCodeDetailField().setEnabled(false);
                window.getIdWorkerField().setEnabled(false);
            }
        }
        int iDWork = company.getReportList().get(row).getiDWork();
        int iDworker = company.getReportList().get(row).getiDWorker();
        int codeDetail = company.getReportList().get(row).getCodeDetail();

        window.getIdWorkerField().setText(Integer.toString(iDworker));
        window.getCodeDetailField().setText(Integer.toString(codeDetail));
        window.getWorkWithDetailField().setText(company.getReportAboutWorks(row).getWorkWithDetails());
        window.getCompleteCheckField().setText(company.getReportAboutWorks(row).getCheckOfCompleteWork());

        window.getCodeDetailField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)  ) {
                    e.consume();
                }
            }
        });
        window.getIdWorkerField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)  ) {
                    e.consume();
                }
            }
        });

        window.getWorkWithDetailField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getCompleteCheckField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c == '+' || c == '-')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });

        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int iDworker = 0;
                    int codeDetail = 0;
                    if (window.getIdWorkerField().getText().isEmpty()){
                        throw new Exception("Значение ID работника не введено");
                    }
                    else {
                        iDworker = Integer.parseInt(window.getIdWorkerField().getText());
                    }

                    if (window.getCodeDetailField().getText().isEmpty()){
                        throw new Exception("Значение код детали не введено");
                    }else{
                        codeDetail = Integer.parseInt(window.getCodeDetailField().getText());
                    }

                    String workWithDetail = window.getWorkWithDetailField().getText();
                    if (workWithDetail.equals("")){
                        throw new Exception("Введите значение в поле 'Работа с деталью'");
                    }
                    String checkOfWork =window.getCompleteCheckField().getText();
                    if (checkOfWork.equals("")){
                        throw new Exception("Введите значение в поле 'Статус'");
                    }

                    db.updateAccomplishment(iDworker,workWithDetail,checkOfWork,codeDetail,iDWork);
                    company.getReportAboutWorks(row).setiDWorker(iDworker);
                    company.getReportAboutWorks(row).setWorkWithDetails(workWithDetail);
                    company.getReportAboutWorks(row).setCheckOfCompleteWork(checkOfWork);
                    company.getReportAboutWorks(row).setCodeDetail(codeDetail);

                    company.getReportAboutWorks(row).setiDWork(iDWork);

                    company.setReportList(db.getReportList(company.getDepartmentNumber()));

                    reportTableModel.fireTableDataChanged();

                    db.closeDB();
                    window.dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(window,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );

                }

            }
        });
    }
    public void executeUpdateWorkerWindow(UpdateWorkerWindow window, int row) throws Exception {

        String passwordOld = company.getWorker(row).getPassword();
        window.getDepartmentNumberField().setText(Integer.toString(company.getWorker(row).getDepartmentNumber()));
        window.getFullnameField().setText(company.getWorker(row).getFullName());
        window.getPositionField().setText(company.getWorker(row).getPosition());
        window.getAddressField().setText(company.getWorker(row).getAddress());
        window.getPhoneNumberField().setText(company.getWorker(row).getPhoneNumber());
        window.getSalaryField().setText(Integer.toString(company.getWorker(row).getSalary()));

        window.getSalaryField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });

        window.getPhoneNumberField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '+')) {
                    e.consume();
                }
            }
        });
        window.getDepartmentNumberField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getFullnameField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getPositionField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });


        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int salary = 0;
                    int departmentNumber = company.getDepartmentNumber();
                    int idWorker = company.getWorker(row).getIdWorker();


                    String fullName = window.getFullnameField().getText();
                    if (fullName.equals("")){
                        throw new Exception("Введите значение в поле 'ФИО работника'");
                    }
                    String position = window.getPositionField().getText();
                    if (position.equals("")){
                        throw new Exception("Введите значение в поле 'Должность'");
                    }
                    String adress = window.getAddressField().getText();
                    if (adress.equals("")){
                        throw new Exception("Введите значение в поле 'Адрес'");
                    }
                    String phoneNumber = window.getPhoneNumberField().getText();
                    if (phoneNumber.equals("") ){
                        throw new Exception("Введите значение в поле 'Номер телефона'");
                    }
                    if (window.getSalaryField().getText().isEmpty()){
                        throw new Exception("Значение зарплата не введено");
                    }else{
                        salary = Integer.parseInt(window.getSalaryField().getText());
                    }
                    String password = window.getPasswordField().getText();

                    if(password.equals("")){
                        db.updateWorker(idWorker,departmentNumber,fullName,position,adress,phoneNumber,salary,passwordOld);
                    } else{
                        db.updateWorker(idWorker,departmentNumber,fullName,position,adress,phoneNumber,salary,Encryption.encrypt(password));
                        company.getWorker(row).setPassword(Encryption.encrypt(password));
                    }

                    company.getWorker(row).setIdWorker(idWorker);
                    company.getWorker(row).setDepartmentNumber(departmentNumber);
                    company.getWorker(row).setFullName(fullName);
                    company.getWorker(row).setPosition(position);
                    company.getWorker(row).setAddress(adress);
                    company.getWorker(row).setPhoneNumber(phoneNumber);
                    company.getWorker(row).setSalary(salary);

                    workerTableModel.fireTableDataChanged();
                    db.closeDB();
                    window.dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(window,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }

            }
        });
    }
    public void executeAddWorkInputWindow(AddWorkInputWindow window){
        window.getCodeDetailField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)  ) {
                    e.consume();
                }
            }
        });
        window.getIdWorkerField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)  ) {
                    e.consume();
                }
            }
        });
        window.getWorkWithDetailField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getCompleteCheckField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c == '+' || c == '-')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });


        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int idWorker = 0;
                    int codeDetail = 0;
                    if (window.getIdWorkerField().getText().isEmpty()){
                        throw new Exception("Значение ID работника не введено");
                    }
                    else {
                        idWorker = Integer.parseInt(window.getIdWorkerField().getText());
                    }
                    String workWithDetails = window.getWorkWithDetailField().getText();
                    if (workWithDetails.equals("")){
                        throw new Exception("Введите значение в поле 'Работа с деталью'");
                    }
                    if (window.getCodeDetailField().getText().isEmpty()){
                        throw new Exception("Значение код детали не введено");
                    }else{
                        codeDetail = Integer.parseInt(window.getCodeDetailField().getText());
                    }
                    String checkOfCompleteWork = window.getCompleteCheckField().getText();
                    if (checkOfCompleteWork.equals("")){
                        throw new Exception("Введите значение в поле 'Статус'");
                    }

                    db.createAccoplishment(idWorker,workWithDetails,checkOfCompleteWork,codeDetail);

                    company.setReportList(db.getReportList(company.getDepartmentNumber()));
                    reportTableModel.fireTableDataChanged();
                    db.closeDB();
                    window.dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(window,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }

            }
        });
    }

    public void executeWorkerInputWindow(WorkerInputWindow window){
        window.getSalaryField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });

        window.getPhoneNumberField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '+')) {
                    e.consume();
                }
            }
        });
        window.getDepartmentNumberField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getFullnameField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getPositionField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });
        window.getPositionField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });



        window.getDepartmentNumberField().setText(Integer.toString(company.getDepartmentNumber()));

        window.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    db.openDB();
                    int salary = 0;
                    int  departmentNumber = company.getDepartmentNumber();
                    if (departmentNumber<0){
                        throw new Exception("Значение должно быть больше нуля!");
                    }
                    String fullname = window.getFullnameField().getText();
                    if (fullname.equals("")){
                        throw new Exception("Введите значение в поле 'ФИО работника'");
                    }
                    String position = window.getPositionField().getText();
                    if (position.equals("")){
                        throw new Exception("Введите значение в поле 'Должность'");
                    }
                    String address = window.getAddressField().getText();
                    if (address.equals("")){
                        throw new Exception("Введите значение в поле 'Адрес'");
                    }
                    String phoneNumber = window.getPhoneNumberField().getText();
                    if (phoneNumber.equals("")){
                        throw new Exception("Введите значение в поле 'Номер телефона'");
                    }

                    if (window.getSalaryField().getText().isEmpty()){
                        throw new Exception("Значение зарплата не введено");
                    }else{
                        salary = Integer.parseInt(window.getSalaryField().getText());
                    }
                    String password = Encryption.encrypt(window.getPasswordField().getText());
                    if (password.equals("")){
                        throw new Exception("Введите значение в поле 'Пароль'");
                    }

                    Workers w = new Workers(departmentNumber,fullname, position, address, phoneNumber, salary, password);
                    db.createWorker(w);
                    company.setWorkersList(db.getWorketsList(company.getDepartmentNumber()));
                    workerTableModel.fireTableDataChanged();
                    db.closeDB();
                    window.dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(window,
                            ex.getMessage(),
                            "Предупреждение", JOptionPane.WARNING_MESSAGE );
                }

            }
        });
    }
    public void executeAuthenticationWindow(AuthentacationWindow window,View view){
        window.getAuthenticationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean login = false;
                try {
                    login = login(Integer.parseInt(window.getLoginField().getText()), window.getPasswordField().getText());
                    if (login){

                        int departmentNumber = company.getDepartmentNumber();
                        db.openDB();
                        company.setReportList(db.getReportList(departmentNumber));
                        company.setWorkersList(db.getWorketsList(departmentNumber));
                        company.setDetailList(db.getDetailsList(departmentNumber));
                        view.getTable().setModel(reportTableModel);
                        reportTableModel.fireTableDataChanged();
                        view.getAddButton().setVisible(false);
                        view.getUpdateButton().setVisible(true);
                        String a[] = company.getPosition().split(" ");
                        for(int i = 0; i<a.length; i++){
                            if (a[i].equalsIgnoreCase("Начальник")){
                                break;
                            }else{
                                view.getDelButton().setEnabled(false);
                                view.getAddProduct().setEnabled(false);
                                view.getAddWorker().setEnabled(false);
                                view.getListOfTasks().setEnabled(false);
                                view.getListOfDetails().setEnabled(false);
                                view.getListOfWorkers().setEnabled(false);
                                view.getUpdateButton().setEnabled(false);

                                TableColumn tcol = view.getTable().getColumnModel().getColumn(0);
                                view.getTable().removeColumn(tcol);
                                tcol = view.getTable().getColumnModel().getColumn(0);
                                view.getTable().removeColumn(tcol);

                            }
                        }
                        db.closeDB();
                        view.setVisible(true);

                        window.dispose();
                    }else{
                        JOptionPane.showMessageDialog(view,
                                "Вы ввели неверный пароль!!",
                                "Окно сообщения", JOptionPane.INFORMATION_MESSAGE, null);
                        window.getPasswordField().setText("");
                    }
                } catch (Exception e) {
                    window.getLoginField().setText("");
                    JOptionPane.showMessageDialog(view,
                            "Работник не найден!!",
                            "Окно сообщения", JOptionPane.INFORMATION_MESSAGE, null);
                }
            }
        });
    }
    private boolean login(int id, String password) throws Exception{
        boolean checkFlag = false;
        Workers workers = db.getAuthentacationWorker(id);

        if (workers.getPassword().equals(Encryption.encrypt(password))){
            company.setPosition(workers.getPosition());
            company.setDepartmentNumber(workers.getDepartmentNumber());
            checkFlag = true;
        }
        return checkFlag;
    }

}
