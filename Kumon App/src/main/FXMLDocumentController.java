/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;


/**
 * @author User
 */
public class FXMLDocumentController implements Initializable {


    public static Stage stage;
    public static Parent root;
    public ToggleGroup gender, grade, knowKumon, reason, parentOne, parentTwo, emailNoOne, emailNoTwo, payment, bankOption;
    @FXML
    public RadioButton female;
    @FXML
    public RadioButton male;
    @FXML
    public RadioButton gradeOther;
    @FXML
    public RadioButton pk_3;
    @FXML
    public RadioButton pk_2;
    @FXML
    public RadioButton pk_1;
    @FXML
    public RadioButton k;
    @FXML
    public RadioButton one;
    @FXML
    public RadioButton two;
    @FXML
    public RadioButton three;
    @FXML
    public RadioButton four;
    @FXML
    public RadioButton five;
    @FXML
    public RadioButton six;
    @FXML
    public RadioButton seven;
    @FXML
    public RadioButton eight;
    @FXML
    public RadioButton nine;
    @FXML
    public RadioButton ten;
    @FXML
    public RadioButton eleven;
    @FXML
    public RadioButton fatherOne;
    @FXML
    public RadioButton motherOne;
    @FXML
    public RadioButton otherOne;
    @FXML
    public RadioButton emailnotOne;
    @FXML
    public RadioButton emailChooseNotOne;
    @FXML
    public RadioButton fatherTwo;
    @FXML
    public RadioButton motherTwo;
    @FXML
    public RadioButton otherTwo;
    @FXML
    public RadioButton emailnotTwo;
    @FXML
    public RadioButton emailChooseNotTwo;
    @FXML
    public RadioButton radio;
    @FXML
    public RadioButton newspaper;
    @FXML
    public RadioButton tv;
    @FXML
    public RadioButton magazine;
    @FXML
    public RadioButton yellowpages;
    @FXML
    public RadioButton web;
    @FXML
    public RadioButton kumonweb;
    @FXML
    public RadioButton friend;
    @FXML
    public RadioButton educator;
    @FXML
    public RadioButton knowOther;
    @FXML
    public TextField knowOtherDescription;
    @FXML
    public RadioButton review;
    @FXML
    public RadioButton enrichment;
    @FXML
    public RadioButton sat;
    @FXML
    public RadioButton reasonOther;
    @FXML
    public TextField reasonOtherDescription;

    //Banking
    @FXML
    public RadioButton bankOpt1;
    @FXML
    public RadioButton bankOpt2;
    @FXML
    public RadioButton bankOpt3;
    @FXML
    public RadioButton checking;
    @FXML
    public RadioButton saving;
    @FXML
    public RadioButton consumer;
    @FXML
    public RadioButton business;
    @FXML
    public TextField opt1Day;
    @FXML
    public TextField opt1Amount;
    @FXML
    public TextField opt2Day1;
    @FXML
    public TextField opt2DayOf;
    @FXML
    public TextField opt2Day2;
    @FXML
    public TextField opt2Amount;
    @FXML
    public TextField opt3Day;
    @FXML
    public TextField opt3Amount;
    @FXML
    public TextField rountingNo;
    @FXML
    public TextField accountNo;

    //Student
    public ArrayList<TextField> studentAllInfo = new ArrayList<>();
    @FXML
    public TextField studentLast;
    @FXML
    public TextField studentFirst;
    @FXML
    public TextField schoolYear;
    @FXML
    public TextField address;
    @FXML
    public TextField city;
    @FXML
    public TextField state;
    @FXML
    public TextField apt;
    @FXML
    public TextField homeTelephone;
    @FXML
    public TextField zip;
    @FXML
    public TextField email;
    @FXML
    public TextField schoolName;
    //Emergency
    public ArrayList<TextField> emergency = new ArrayList<>();
    @FXML
    public TextField EmergencyName;
    @FXML
    public TextField EmergencyTelephone;
    //Parent 1
    public ArrayList<TextField> parentOneAllInfo = new ArrayList<>();
    @FXML
    public TextField parentLastOne;
    @FXML
    public TextField parentFirstOne;
    @FXML
    public TextField addressOne;
    @FXML
    public TextField cityOne;
    @FXML
    public TextField stateOne;
    @FXML
    public TextField aptOne;
    @FXML
    public TextField homeTelephoneOne;
    @FXML
    public TextField zipOne;
    @FXML
    public TextField emailOne;
    @FXML
    public TextField mobileOne;
    //Parent 2
    public ArrayList<TextField> parentTwoAllInfo = new ArrayList<>();
    @FXML
    public TextField parentLastTwo;
    @FXML
    public TextField parentFirstTwo;
    @FXML
    public TextField addressTwo;
    @FXML
    public TextField cityTwo;
    @FXML
    public TextField stateTwo;
    @FXML
    public TextField aptTwo;
    @FXML
    public TextField homeTelephoneTwo;
    @FXML
    public TextField zipTwo;
    @FXML
    public TextField emailTwo;
    @FXML
    public TextField mobileTwo;
    @FXML
    public Button submitData;
    @FXML
    public Button Setting;
    @FXML
    public Button ss;
    @FXML
    public Button Excel;
    @FXML
    public Button bCancel, closeButton, bank, Re, cButton, btn2, okdsdf, studentBack, table, registration, bBank, appBack, startSigning, studentApp, backInfo;
    @FXML
    public PasswordField pass;
    public int a = 0;
    @FXML
    public WebView webview;
    public WebEngine webEngine;
    JSInterface jsinterface;
    @FXML
    public Pane pane;
    @FXML
    private TableView<person> tableView;
    @FXML
    private TableColumn<person, String> firstNameColumn;
    @FXML
    private TableColumn<person, String> lastNameColumn;
    @FXML
    private TableColumn<person, LocalDate> birthdayColumn;
    private Path path;
    @FXML
    private Label label, alarm, errorLabel;
    private Group lineGroup;

    private String filename;
    private HSSFWorkbook workbook = new HSSFWorkbook();
    private HSSFSheet sheet = workbook.createSheet("Student Form");




    public FXMLDocumentController() {

        this.lineGroup = new Group();
    }

    public static void Excel() throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(new File("C:/Users/User/Documents/NetBeansProjects/Kumon Manager/src/main/excel.xlsx"));
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Buttons choosing the scenes
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btn2) {
            //get reference to the button's stage
            stage = (Stage) btn2.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXML/LogIn.fxml"));
            showScene();
        } else if (event.getSource() == backInfo) {
            stage = (Stage) backInfo.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
            showScene();

        } else if (event.getSource() == registration) {
            stage = (Stage) registration.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Registration.fxml"));
            showScene();
        } else if (event.getSource() == ss) {

            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("excel files (*.xls)", "*.xls");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show saveApp file dialog
            File file = fileChooser.showSaveDialog(stage);

            filename = file.toString();

            File posFile = new File("FilePosition");
            FileWriter writer = new FileWriter(posFile);
            writer.write(filename);
            writer.close();
            saveFirst();


        } else if (event.getSource() == submitData) {
            checkFile();
            saveAsPng();
        } else if (event.getSource() == Excel) {
            Excel();
        } else if (event.getSource() == Setting) {
            stage = (Stage) Setting.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/webView.fxml"));
            showScene();
        } else if (event.getSource() == appBack) {
            stage = (Stage) appBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Registration.fxml"));
            showScene();
        } else if (event.getSource() == table) {
            stage = (Stage) table.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/StudentInfo.fxml"));
            showScene();
        } else if (event.getSource() == bank) {
            stage = (Stage) bank.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Bank.fxml"));
            showScene();
        } else if (event.getSource() == cButton) {
            stage = (Stage) cButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Confirm.fxml"));
            showScene();
        } else if (event.getSource() == bCancel) {
            stage = (Stage) bCancel.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Registration.fxml"));
            showScene();
        } else if (event.getSource() == studentBack) {
            stage = (Stage) studentBack.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Registration.fxml"));
            showScene();
        } else if (event.getSource() == studentApp) {
            stage = (Stage) studentApp.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/StudentApplication.fxml"));
            showScene();
        } else if (event.getSource() == Re) {
            stage = (Stage) Re.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
            showScene();
        } else if (event.getSource() == bBank) {
            stage = (Stage) bBank.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML/Registration.fxml"));
            showScene();
        } else if (event.getSource() == okdsdf) {
            checkPassword();
            if (checkPassword()) {
                stage = (Stage) okdsdf.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
                showScene();
            }

        } else if (a == 1) {

            root = FXMLLoader.load(getClass().getResource("FXML/Confirm.fxml"));
            showScene();
        } else if (event.getSource() == closeButton) {
            // stage.close();
        } else {
        }
    }//create a new scene with root and set the stage]

    // Connecting the radio buttons for the parents page
    @FXML
    private void radioButtons() {
        //Gender
        gender = new ToggleGroup();
        this.male.setToggleGroup(gender);
        this.female.setToggleGroup(gender);

        //Setting User Data
        male.setUserData("Male");
        female.setUserData("Female");

        //Payment Method
        bankOption = new ToggleGroup();
        this.bankOpt1.setToggleGroup(bankOption);
        this.bankOpt2.setToggleGroup(bankOption);
        this.bankOpt3.setToggleGroup(bankOption);

        bankOpt1.setUserData("Option 1");
        bankOpt2.setUserData("Option 2");
        bankOpt3.setUserData("Option 3");


        //Payment Type
        payment = new ToggleGroup();
        this.checking.setToggleGroup(payment);
        this.saving.setToggleGroup(payment);
        this.consumer.setToggleGroup(payment);
        this.business.setToggleGroup(payment);

        checking.setUserData("Checking");
        saving.setUserData("Saving");
        consumer.setUserData("Consumer");
        business.setUserData("Business");

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

        //Setting User Data
        pk_3.setUserData("PK-3");
        pk_2.setUserData("PK-2");
        pk_1.setUserData("PK-1");
        k.setUserData("K");
        one.setUserData("1");
        two.setUserData("2");
        three.setUserData("3");
        four.setUserData("4");
        five.setUserData("5");
        six.setUserData("6");
        seven.setUserData("7");
        eight.setUserData("8");
        nine.setUserData("9");
        ten.setUserData("10");
        eleven.setUserData("11");
        gradeOther.setUserData("Other");

        //Parents 1
        parentOne = new ToggleGroup();
        this.fatherOne.setToggleGroup(parentOne);
        this.motherOne.setToggleGroup(parentOne);
        this.otherOne.setToggleGroup(parentOne);

        //Setting User Data
        fatherOne.setUserData("Father");
        motherOne.setUserData("Mother");
        otherOne.setUserData("Other");

        //Parent 2
        parentTwo = new ToggleGroup();
        this.fatherTwo.setToggleGroup(parentTwo);
        this.motherTwo.setToggleGroup(parentTwo);
        this.otherTwo.setToggleGroup(parentTwo);

        //Setting User Data
        fatherTwo.setUserData("Father");
        motherTwo.setUserData("Mother");
        otherTwo.setUserData("Other");

        //Email 1
        emailNoOne = new ToggleGroup();
        this.emailChooseNotOne.setToggleGroup(emailNoOne);
        this.emailnotOne.setToggleGroup(emailNoOne);

        //Setting User Data
        emailChooseNotOne.setUserData("Prefer not to say");
        emailnotOne.setUserData("Does not have one");

        //Email 2
        emailNoTwo = new ToggleGroup();
        this.emailChooseNotTwo.setToggleGroup(emailNoTwo);
        this.emailnotTwo.setToggleGroup(emailNoTwo);

        //Setting User Data
        emailChooseNotTwo.setUserData("Prefer not to say");
        emailnotTwo.setUserData("Does not have one");

        //Know Kumon
        knowKumon = new ToggleGroup();
        this.radio.setToggleGroup(knowKumon);
        this.yellowpages.setToggleGroup(knowKumon);
        this.tv.setToggleGroup(knowKumon);
        this.web.setToggleGroup(knowKumon);
        this.kumonweb.setToggleGroup(knowKumon);
        this.newspaper.setToggleGroup(knowKumon);
        this.friend.setToggleGroup(knowKumon);
        this.educator.setToggleGroup(knowKumon);
        this.magazine.setToggleGroup(knowKumon);
        this.knowOther.setToggleGroup(knowKumon);

        //Setting User Data
        radio.setUserData("Radio");
        yellowpages.setUserData("Yellow Paper");
        tv.setUserData("TV");
        web.setUserData("Web Search");
        kumonweb.setUserData("Kumon Website");
        newspaper.setUserData("News Paper");
        friend.setUserData("Friend");
        educator.setUserData("Educator");
        magazine.setUserData("Magazine");
        knowOther.setUserData("Other");

        //Reason
        reason = new ToggleGroup();
        this.enrichment.setToggleGroup(reason);
        this.review.setToggleGroup(reason);
        this.sat.setToggleGroup(reason);
        this.reasonOther.setToggleGroup(reason);

        //Setting User Data
        enrichment.setUserData("Enrichment");
        review.setUserData("Review");
        sat.setUserData("ACT/SAT");
        reasonOther.setUserData("Other");


    }

    //Submits the answer into a text file
    private void saveFirst() {
        try {
            //Student
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("Last Name");
            rowhead.createCell(1).setCellValue("First Name");
            rowhead.createCell(2).setCellValue("Gender");
            rowhead.createCell(3).setCellValue("School year");
            rowhead.createCell(4).setCellValue("Grade");
            rowhead.createCell(5).setCellValue("Address");
            rowhead.createCell(6).setCellValue("Apt.or Suite No.");
            rowhead.createCell(7).setCellValue("Home Telephone");
            rowhead.createCell(8).setCellValue("City");
            rowhead.createCell(9).setCellValue("State/Prov.");
            rowhead.createCell(10).setCellValue("Zip/Postel Code");
            rowhead.createCell(11).setCellValue("Email");
            rowhead.createCell(12).setCellValue("Name of School");

            //Parent 1
            rowhead.createCell(13).setCellValue("P1 Type");
            rowhead.createCell(14).setCellValue("P1 Last Name");
            rowhead.createCell(15).setCellValue("P1 First Name");
            rowhead.createCell(16).setCellValue("P1 Address");
            rowhead.createCell(17).setCellValue("P1 Apt.or Suite No.");
            rowhead.createCell(18).setCellValue("P1 Home Telephone");
            rowhead.createCell(19).setCellValue("P1 City");
            rowhead.createCell(20).setCellValue("P1 State/Prov.");
            rowhead.createCell(21).setCellValue("P1 Zip/Postel Code");
            rowhead.createCell(22).setCellValue("P1 Email");
            rowhead.createCell(23).setCellValue("P1 Mobile Number");

            //Parent 2
            rowhead.createCell(24).setCellValue("P2 Type");
            rowhead.createCell(25).setCellValue("P2 Last Name");
            rowhead.createCell(26).setCellValue("P2 First Name");
            rowhead.createCell(27).setCellValue("P2 Address");
            rowhead.createCell(28).setCellValue("P2 Apt.or Suite No.");
            rowhead.createCell(29).setCellValue("P2 Home Telephone");
            rowhead.createCell(30).setCellValue("P2 City");
            rowhead.createCell(31).setCellValue("P2 State/Prov.");
            rowhead.createCell(32).setCellValue("P2 Zip/Postel Code");
            rowhead.createCell(33).setCellValue("P2 Email");
            rowhead.createCell(34).setCellValue("P2 Mobile Number");

            //Emergency
            rowhead.createCell(35).setCellValue("EM Name");
            rowhead.createCell(36).setCellValue("EM Telephone");
            rowhead.createCell(37).setCellValue("Signature Date");

            //How did you learn about kumon
            rowhead.createCell(38).setCellValue("How they know kumon");
            rowhead.createCell(39).setCellValue("Why they enolled here");
            rowhead.createCell(40).setCellValue("Routing Number");
            rowhead.createCell(41).setCellValue("Accont Number");
            rowhead.createCell(42).setCellValue("Account Type");
            rowhead.createCell(43).setCellValue("Terms of billing");

            HSSFRow row = sheet.createRow((short) 1);

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");

        } catch (Exception ex) {

            System.out.println(ex);
        }

    }

    private void saveApp() {
        if (check()) {
            try {
                FileInputStream inputStream = new FileInputStream(new File(filename));
                Workbook workbook = WorkbookFactory.create(inputStream);

                Sheet sheet = workbook.getSheetAt(0);

                int rowCount = sheet.getLastRowNum();
                int colCount = -1;
                System.out.println(grade.getSelectedToggle().getUserData());

                Row rowStudent = sheet.createRow((short) (++rowCount));
                rowStudent.createCell(++colCount).setCellValue(studentLast.getText());
                rowStudent.createCell(++colCount).setCellValue(studentFirst.getText());
                rowStudent.createCell(++colCount).setCellValue((String) gender.getSelectedToggle().getUserData());
                rowStudent.createCell(++colCount).setCellValue(schoolYear.getText());
                rowStudent.createCell(++colCount).setCellValue((String) grade.getSelectedToggle().getUserData());
                rowStudent.createCell(++colCount).setCellValue(address.getText());
                rowStudent.createCell(++colCount).setCellValue(apt.getText());
                rowStudent.createCell(++colCount).setCellValue(homeTelephone.getText());
                rowStudent.createCell(++colCount).setCellValue(city.getText());
                rowStudent.createCell(++colCount).setCellValue(state.getText());
                rowStudent.createCell(++colCount).setCellValue(zip.getText());
                rowStudent.createCell(++colCount).setCellValue(email.getText());
                rowStudent.createCell(++colCount).setCellValue(schoolName.getText());

                //Parent One
                rowStudent.createCell(++colCount).setCellValue((String) parentOne.getSelectedToggle().getUserData());
                rowStudent.createCell(++colCount).setCellValue(parentLastOne.getText());
                rowStudent.createCell(++colCount).setCellValue(parentFirstOne.getText());
                rowStudent.createCell(++colCount).setCellValue(addressOne.getText());
                rowStudent.createCell(++colCount).setCellValue(aptOne.getText());
                rowStudent.createCell(++colCount).setCellValue(homeTelephoneOne.getText());
                rowStudent.createCell(++colCount).setCellValue(cityOne.getText());
                rowStudent.createCell(++colCount).setCellValue(stateOne.getText());
                rowStudent.createCell(++colCount).setCellValue(zipOne.getText());

                if (emailOne.getText() != null) {
                    rowStudent.createCell(++colCount).setCellValue(emailOne.getText());
                } else {
                    rowStudent.createCell(++colCount).setCellValue((String) emailNoOne.getSelectedToggle().getUserData());
                }
                rowStudent.createCell(++colCount).setCellValue(mobileOne.getText());

                //Parent Two
                rowStudent.createCell(++colCount).setCellValue((String) parentTwo.getSelectedToggle().getUserData());
                rowStudent.createCell(++colCount).setCellValue(parentLastTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(parentFirstTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(addressTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(aptTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(homeTelephoneTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(cityTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(stateTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(zipTwo.getText());

                if (emailTwo.getText() != null) {
                    rowStudent.createCell(++colCount).setCellValue(emailTwo.getText());
                } else {
                    rowStudent.createCell(++colCount).setCellValue((String) emailNoTwo.getSelectedToggle().getUserData());
                }
                rowStudent.createCell(++colCount).setCellValue(mobileTwo.getText());
                rowStudent.createCell(++colCount).setCellValue(EmergencyName.getText());
                rowStudent.createCell(++colCount).setCellValue(EmergencyTelephone.getText());


                if (knowKumon.getSelectedToggle().getUserData().equals("Other")) {
                    rowStudent.createCell(++colCount).setCellValue(knowOtherDescription.getText());
                } else {
                    rowStudent.createCell(++colCount).setCellValue((String) knowKumon.getSelectedToggle().getUserData());
                }


                if (reason.getSelectedToggle().getUserData().equals("Other")) {
                    rowStudent.createCell(++colCount).setCellValue(reasonOtherDescription.getText());
                } else {
                    rowStudent.createCell(++colCount).setCellValue((String) reason.getSelectedToggle().getUserData());
                }
                rowStudent.createCell(++colCount).setCellValue(rountingNo.getText());
                rowStudent.createCell(++colCount).setCellValue(accountNo.getText());
                rowStudent.createCell(++colCount).setCellValue((String) payment.getSelectedToggle().getUserData());
                rowStudent.createCell(++colCount).setCellValue((String) bankOption.getSelectedToggle().getUserData());
                if (bankOption.getSelectedToggle().getUserData().equals("Option 1")) {
                    rowStudent.createCell(++colCount).setCellValue(opt1Day.getText());
                    rowStudent.createCell(++colCount).setCellValue(opt1Amount.getText());
                } else if (bankOption.getSelectedToggle().getUserData().equals("Option 2")) {
                    rowStudent.createCell(++colCount).setCellValue(opt2Day1.getText());
                    rowStudent.createCell(++colCount).setCellValue(opt2DayOf.getText());
                    rowStudent.createCell(++colCount).setCellValue(opt2Day2.getText());
                    rowStudent.createCell(++colCount).setCellValue(opt2Amount.getText());
                } else {
                    rowStudent.createCell(++colCount).setCellValue(opt3Day.getText());
                    rowStudent.createCell(++colCount).setCellValue(opt3Amount.getText());

                }

                System.out.println(rowCount);

                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(filename);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

            } catch (IOException | EncryptedDocumentException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void checkFile() throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("FilePosition"));
            String st;
            while ((st = br.readLine()) != null) {
                filename = st;
            }
            saveApp();

        } catch (FileNotFoundException e) {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("excel files (*.xls)", "*.xls");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show saveApp file dialog
            File file = fileChooser.showSaveDialog(stage);

            filename = file.toString();

            File posFile = new File("FilePosition");
            FileWriter writer = new FileWriter(posFile);
            writer.write(filename);
            writer.close();

            saveFirst();
            saveApp();
            System.out.println(e);
        }


    }

    private boolean check() {
        if (gender.getSelectedToggle() == null || grade.getSelectedToggle() == null || knowKumon.getSelectedToggle() == null || reason.getSelectedToggle() == null || parentOne.getSelectedToggle() == null || parentTwo.getSelectedToggle() == null || payment.getSelectedToggle() == null || bankOption.getSelectedToggle() == null) {
            errorLabel.setVisible(true);
            return false;
        } else if ((emailOne.getText() == null && emailNoOne.getSelectedToggle() == null) || (emailTwo.getText() == null && emailNoTwo.getSelectedToggle() == null)) {
            errorLabel.setVisible(true);
            return false;
        } else {
            errorLabel.setVisible(false);
            return true;
        }

    }
    @FXML
    public void saveAsPng() {
        WritableImage image = pane.snapshot(new SnapshotParameters(), null);

        // TODO: probably use a file chooser here
        File file = new File("chart.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
    }

    public void showScene() {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Radio Switches


    // Log In page, Checks the password
    private boolean checkPassword() {
        int password = 99;
        String message;
        message = pass.getText();
        int result = 0;
        try {
            result = Integer.parseInt(message);
            if (result == password) {

                return true;

            } else {
                alarm();
                return false;
            }
        } catch (NumberFormatException e) {
            alarm();
            return false;
        }
    }

    // if the password is incorrect the alarm will show up
    private void alarm() {
        alarm.setVisible(true);
    }

    public void showMenu() throws IOException {

        stage = (Stage) okdsdf.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            signature();
        } catch (Exception ignored) {
        }
    }

    //puts the student in the tables
    public ObservableList<person> getPeople() {
        ObservableList<person> people = FXCollections.observableArrayList();
        people.add(new person("Lisa", "Smith", LocalDate.of(1924, Month.JULY, 31)));
        people.add(new person("Frank", "sinatra", LocalDate.of(1954, Month.DECEMBER, 12)));
        return people;
    }
    //sets up the signature for the parents through an already made html page
    private void signature() {
        webEngine = webview.getEngine();
        final URL urlHello = getClass().getResource("signaturePage/signature.html");
        webEngine.load(urlHello.toExternalForm());

        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {

                    @Override
                    public void changed(ObservableValue<? extends State> observable, State oldValue, State newState) {
                        if (newState == State.SUCCEEDED) {
                            JSObject window = (JSObject) webEngine.executeScript("window");
                            jsinterface = new JSInterface();
                            window.setMember("JSInterface", jsinterface);
                        }
                    }
                });

    }


    //Saves the signature as an image in the download folder
    public class JSInterface {

        public void receiveSignature(String signatureAsPNGBase64) {
            signatureAsPNGBase64 = signatureAsPNGBase64.split(",")[1];
            System.out.println(signatureAsPNGBase64);
            try {
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] data = decoder.decodeBuffer(signatureAsPNGBase64);

                //byte[] data = Base64.getDecoder().decode(signatureAsPNGBase64);
                OutputStream stream = new FileOutputStream("C:/Users/User/Downloads/test.png");
                stream.write(data);
                stream.close();
            } catch (Exception ignored) {
            }
        }
    }

}
       