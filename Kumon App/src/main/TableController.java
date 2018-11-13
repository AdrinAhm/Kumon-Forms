/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.CellStyle;

/**
 * FXML Controller class
 *
 * @author User
 */

public class TableController implements Initializable {
        @FXML
         private TableView<person>tableView;
         @FXML
         private TableColumn<person, String>firstNameColumn;
         @FXML
         private TableColumn<person, String>lastNameColumn;
         @FXML
         private TableColumn<person, LocalDate>birthdayColumn;
         @FXML
         public Button cancelButton;
    /**
     * Initializes the controller class.
     */
            @FXML
   public void action(ActionEvent event) throws IOException{  
           
            
             
        }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                
    }  
        public static void Excel() throws FileNotFoundException, IOException{
           
        }
        
}
