package ApplicaionForWorkers.GUI;

import ApplicaionForWorkers.GUI.TableModel.DetailTableModel;
import ApplicaionForWorkers.GUI.TableModel.WorkerTableModel;
import ApplicaionForWorkers.GUI.Window.View;
import ApplicaionForWorkers.Model.Company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
 private WorkerTableModel workerTableModel;
 private DetailTableModel detailTableModel;
    private Company company;
    public void execute(View view){
        workerTableModel = new WorkerTableModel();
        detailTableModel = new DetailTableModel();
        view.getListOfProducts().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTable().setModel(detailTableModel);
            }
        });

        view.getListOfWorkers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTable().setModel(workerTableModel);
            }
        });
    }
}
