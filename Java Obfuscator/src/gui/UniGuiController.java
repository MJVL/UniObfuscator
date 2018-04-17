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
    public JFXTextArea txtExtraText;
    public JFXCheckBox chkComment;
    public JFXCheckBox chkTODO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chkComment.setSelected(true);
        txtObfuscatedCode.setText(Obfuscator.obfuscate(""));
        txtSourceCode.textProperty().addListener((observable, oldText, newText) -> {
            updateText();
        });
        txtExtraText.textProperty().addListener((observable, oldText, newText) -> {
            updateText();
        });
    }

    public void updateText() {
        if (chkTODO.isSelected()) {
            txtObfuscatedCode.setText(Obfuscator.obfuscate(txtSourceCode.getText(), ((txtExtraText.getText()).length() > 0) ? (" " + txtExtraText.getText() + " ") : "", Obfuscator.Modifier.TODO));
        }
        else if (chkComment.isSelected()){
            txtObfuscatedCode.setText(Obfuscator.obfuscate(txtSourceCode.getText(), ((txtExtraText.getText()).length() > 0) ? (" " + txtExtraText.getText() + " ") : "", Obfuscator.Modifier.COMMENT));
        }
        else {
            txtObfuscatedCode.setText(Obfuscator.obfuscate(txtSourceCode.getText(), "", Obfuscator.Modifier.NONE));
        }
    }

}
