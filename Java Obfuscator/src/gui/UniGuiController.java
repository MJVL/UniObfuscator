package gui;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.Initializable;
import utility.Obfuscator;

import java.net.URL;
import java.util.ResourceBundle;

public class UniGuiController implements Initializable {

    public JFXTextArea txtSourceCode;
    public JFXTextArea txtObfuscatedCode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtSourceCode.textProperty().addListener((observable, oldText, newText) -> {
            txtObfuscatedCode.setText(Obfuscator.obfuscate(newText));
        });
    }

}
