package git.markvn2.controllers;

import git.markvn2.models.Aluno;
import git.markvn2.models.HistoricoPeso;
import git.markvn2.utils.DBUtils;
import git.markvn2.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryEditController implements Initializable {
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_cpf;
    @FXML
    private DatePicker dp_entry;
    @FXML
    private TextField tf_height;
    @FXML
    private TextField tf_weight;
    @FXML
    private Button btn_return;
    @FXML
    private Button btn_edit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        HistoricoPeso hsc = StudentsController.selectedCPF;

        tf_name.setText(hsc.getStudent().getName());
        tf_name.setEditable(false);
        tf_name.setFocusTraversable(false);

        tf_cpf.setText(hsc.getStudent().getCPF());
        tf_cpf.setEditable(false);
        tf_cpf.setFocusTraversable(false);

        dp_entry.setValue(hsc.getEntryDate());

        tf_height.setText(String.valueOf(hsc.getStudent().getHeight()));
        tf_weight.setText(String.valueOf(hsc.getStudent().getWeight()));

        btn_return.setOnAction(event -> {
            GUIUtils.changeScene(event, "/fxml/history.fxml", "Student history");
        });
    }
}
