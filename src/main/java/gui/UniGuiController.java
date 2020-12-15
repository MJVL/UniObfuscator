package gui;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import utility.Obfuscator;

public class UniGuiController implements Initializable {

    public JFXTextArea txtSourceCode;
    public JFXTextArea txtObfuscatedCode;
    public JFXTextArea txtExtraText;
    public JFXCheckBox chkComment;
    public JFXCheckBox chkTODO;
    public ImageView imgCopy;
    public ImageView imgClear;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tooltip.install(imgClear, new Tooltip("Clear"));
        Tooltip.install(imgCopy, new Tooltip("Copy"));
        chkComment.setSelected(true);
        txtObfuscatedCode.setText(Obfuscator.obfuscate(""));
        txtSourceCode.textProperty().addListener((observable, oldText, newText) -> updateText());
        txtExtraText.textProperty().addListener((observable, oldText, newText) -> updateText());
        imgCopy.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> copyToClipboard());
        imgClear.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> txtSourceCode.setText(""));
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

    public void copyToClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(txtObfuscatedCode.getText()), null);
    }

}
