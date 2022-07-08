package com.example.finalspringfx.Controller;


import com.example.finalspringfx.Helper.Calculator;
import com.example.finalspringfx.Helper.DateFormatter;
import com.example.finalspringfx.Helper.Validator.ValidateCalculatorInput;
import com.example.finalspringfx.Models.Fahrt;
import com.example.finalspringfx.MongoRepositorys.FahrtenRepository;
import com.example.finalspringfx.MongoRepositorys.UserRepository;
import com.example.finalspringfx.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@FxmlView("/chart.fxml")
public class ChartController {



    private User momUser;

    @FXML
    private Label welcomeText;
    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private Label RegisterWelcomeText;
    @FXML
    private TextField RegisterFirstNameField;
    @FXML
    private TextField RegisterLastNameField;
    @FXML
    private TextField RegisterUsernameField;
    @FXML
    private PasswordField RegisterPasswordField;
    @FXML
    private Pane loginPane;
    @FXML
    private Pane registerPane;
    @FXML
    private Pane functionsPane;
    @FXML
    private TextField minuteField;
    @FXML
    private TextField secondField;
    @FXML
    private TableView<Fahrt> table;
    @FXML
    private TableColumn minuteColumn;
    @FXML
    private TableColumn secondsColumn;
    @FXML
    private TableColumn priceColumn;
    @FXML
    private TableColumn dateColumn;
    @FXML
    private Label welcomeUserLabel;


    @Autowired
    UserRepository userRepository;

    @Autowired
    FahrtenRepository fahrtenRepository;





    @FXML
    protected void onRegisterButtonClick() {
        //Button action for Register Button
        try {
            if(isUsernameValid(RegisterUsernameField.getText())) {
                userRepository.save(new User(RegisterFirstNameField.getText(), RegisterLastNameField.getText(), RegisterUsernameField.getText(), RegisterPasswordField.getText()));
                RegisterWelcomeText.setTextFill((Paint) Color.GREEN);
                loginPane.setVisible(true);
                registerPane.setVisible(false);
            } else {
                RegisterWelcomeText.setText("Name is not available");
                RegisterWelcomeText.setTextFill((Paint) Color.RED);
            }


        } catch (Exception e) {
            RegisterWelcomeText.setTextFill((Paint) Color.RED);
            RegisterWelcomeText.setText("Username already exists");
        }

    }


    @FXML
    protected void onLoginButtonClick() {
            //Button action for Login button
        try{
            if (userRepository.findByUsernameAndPassword(LoginTextField.getText(), loginPasswordField.getText()).isPresent()){
                momUser = userRepository.findUserByUsernameIs(LoginTextField.getText());
                //Clear Text field
                LoginTextField.setText("");
                loginPasswordField.setText("");
                welcomeUserLabel.setText("Welcome " + momUser.getUsername());
                loadTrips();
                functionsPane.setVisible(true);
                loginPane.setVisible(false);
            }
            else {
                welcomeText.setTextFill((Paint) Color.RED);
                welcomeText.setText("Wrong Username or Password");
            }
        }catch(Exception e) {
            welcomeText.setTextFill((Paint) Color.RED);
            welcomeText.setText("Wrong Username or Password");
        }


    }

    @FXML
    protected void goToRegister() {
        //Button action for register label
        loginPane.setVisible(false);
        registerPane.setVisible(true);
    }

    @FXML
    protected void goToLogin() {
        //Button action for Login Label
        loginPane.setVisible(true);
        registerPane.setVisible(false);
    }

    @FXML
    protected void onCalculateButtonClick() {
        try{
            if (ValidateCalculatorInput.isCalculatorInputValid(minuteField.getText(), secondField.getText())) {
                //Button action for Calculate Button

                //Calculate Price per Trip
                double price = Calculator.calculator(Integer.parseInt(minuteField.getText()), Integer.parseInt(secondField.getText()));
                //Get the currently LoggedIn User
                User user = new User(momUser.getFirstName(), momUser.getLastName(), momUser.getUsername(), momUser.getPassword());
                //Save new Trip to MongoDB
                fahrtenRepository.save(new Fahrt(minuteField.getText(), secondField.getText(), user, price, DateFormatter.formatDate(Instant.now())));
                minuteField.setText("");
                secondField.setText("");
                loadTrips();

            }
        }catch (Exception e) {
            //Logging
        }





    }

    @FXML
    protected void onLogoutButtonClick() {
        //Button action for Logout button
        momUser = null;
        table.getItems().clear();
        welcomeUserLabel.setText("");
        loginPane.setVisible(true);
        functionsPane.setVisible(false);
        }


    @FXML
    public void initialize() {

    }




    private void loadTrips() {
        //Clear Table before adding new rows
        table.getItems().clear();
        //Connect Columns with Table
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        minuteColumn.setCellValueFactory(new PropertyValueFactory<>("Minutes"));
        secondsColumn.setCellValueFactory(new PropertyValueFactory<>("Seconds"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        //Get all Trips from currently LoggedIn User
        List<Fahrt> list = fahrtenRepository.findFahrtsByUser_Username(momUser.getUsername());
        //Add all Trips from currently LoggedIn User to the Table
        for (int i = 0; i < list.size(); i++) {
            table.getItems().add(new Fahrt(list.get(i).getMinutes(), list.get(i).getSeconds(), list.get(i).getPrice(), list.get(i).getDate()));
        }
    }

    //Proof if Username is valid
    public boolean isUsernameValid(String valid) {
        List<User> test = userRepository.findAll();
        for (int i = 0; i < userRepository.count(); i++) {
            if(valid.matches("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$") && !valid.isEmpty() && !valid.equals(test.get(i).getUsername())) {
                return true;
            }
        }

        return false;
    }






}
