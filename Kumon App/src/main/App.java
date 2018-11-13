/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class App implements Initializable {

    public ToggleGroup gender,grade;
     
    @FXML
    public RadioButton male, female;

    @FXML
    public RadioButton pk_3, pk_2, pk_1, k, one, two, three, four, five, six, seven, eight, nine, ten, eleven, gradeOther;

    @FXML
    public Button back;
    
   

    @FXML
    private void Action(ActionEvent event) throws IOException {

        if (event.getSource() == back) {
            FXMLDocumentController.stage = (Stage) back.getScene().getWindow();
            FXMLDocumentController.root = FXMLLoader.load(getClass().getResource("FXML/Registration.fxml"));
        }
    }
    public void radioButtons(){
        //Gender
        gender = new ToggleGroup();
        this.male.setToggleGroup(gender);
        this.female.setToggleGroup(gender);
        
        //Grades
        grade = new ToggleGroup();
        this.pk_3.setToggleGroup(grade);
        this.pk_2.setToggleGroup(grade);
        this.pk_1.setToggleGroup(grade);
        this.k.setToggleGroup(grade);
        this.one.setToggleGroup(grade);
        this.two.setToggleGroup(grade);
        this.three.setToggleGroup(grade);
        this.four.setToggleGroup(grade);
        this.five.setToggleGroup(grade);
        this.six.setToggleGroup(grade);
        this.seven.setToggleGroup(grade);
        this.eight.setToggleGroup(grade);
        this.nine.setToggleGroup(grade);
        this.ten.setToggleGroup(grade);
        this.eleven.setToggleGroup(grade);
        this.gradeOther.setToggleGroup(grade);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
