package gui;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.Initializable;
import utility.Obfuscator;

import java.net.URL;
import java.util.ResourceBundle;

public class UniGuiController implements Initializable {

    public JFXTextArea txtSourceCode;
    public JFXTextArea txtObfuscatedCode;
    public JFXCheckBox chkComment;
    public JFXCheckBox chkTODO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chkComment.setSelected(true);
        txtObfuscatedCode.setText(Obfuscator.obfuscate(""));
        txtSourceCode.textProperty().addListener((observable, oldText, newText) -> {
            txtObfuscatedCode.setText(Obfuscator.obfuscate(newText));
        });
    }

}
