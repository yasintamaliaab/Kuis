/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis;

import java.util.*;
import java.net.URL;
import javax.swing.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.lang.reflect.InvocationTargetException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Fajar Ikhromi
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea hasil;

    @FXML
    private TextField hasilberat;

    @FXML
    private TextArea saran;

    @FXML
    private JFXTextField nama;

    @FXML
    private JFXTextField tinggi;

    @FXML
    private JFXTextField berat;

    @FXML
    private JFXRadioButton laki;

    @FXML
    private JFXRadioButton perempuan;

    @FXML
    void hapus(ActionEvent event) {
        nama.setText("");
        tinggi.setText("");
        berat.setText("");
        laki.setSelected(false);
        perempuan.setSelected(false);
        hasilberat.setText("");
        saran.setText("");
        hasil.setText("");
    }

    @FXML
    void proses(ActionEvent event) {
        JOptionPane.showMessageDialog(new JFrame(), "Berhasil....");
        int beratIdeal = 0;
        String analisa = null;
        String analisasaran = null;
        if(laki.isSelected()){
            beratIdeal = parseInt(tinggi.getText().toString()) - 105;
        }
        if(perempuan.isSelected()) {
            beratIdeal = parseInt(tinggi.getText().toString()) - 110;
        }
        
        hasilberat.setText(""+beratIdeal);
        
        if(beratIdeal == parseInt(tinggi.getText())){
            analisa = "Ideal";
            analisasaran = "Berat anda sudah ideal\njaga berat anda dan makan anda.";
        }else if(beratIdeal > parseInt(tinggi.getText())){
            analisa = "Overweight";
            analisasaran = "Anda sedang mengalami Overweight\nkurangi pola makan anda\njaga kesehatan anda";
        }else if(beratIdeal < parseInt(tinggi.getText())){
            analisa = "Underweight";
            analisasaran = "Anda sedang mengalami Underweight\nAtur pola makan anda hingga mencapai berat ideal\njaga kesehatan anda";
        }
        
        hasil.setText("Nama "+nama.getText()+", Anda "+analisa);
        saran.setText(analisasaran);
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
