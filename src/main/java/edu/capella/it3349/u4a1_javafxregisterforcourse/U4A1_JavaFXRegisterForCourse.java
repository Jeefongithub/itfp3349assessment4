/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.capella.it3349.u4a1_javafxregisterforcourse;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author omora
 */
public class U4A1_JavaFXRegisterForCourse extends Application {
    
    
    GridPane grid = new GridPane();
    Label selectPromptLabel = new Label("Please select a course for which you want to register");
    ComboBox<Course> coursesComboBox = new ComboBox<>();   
    Label confirmPromptLabel = new Label("");
    Label registeredCoursesPromptLabel = new Label("You are currently registered for");
    Label creditHourPromptLabel = new Label("Current total Credit Hours");            
    Label registeredCoursesLabel = new Label("");
    Label creditHoursLabel = new Label("0");

    Course choice;
    int totalCredit = 0;
       
           
    @Override
    public void start(Stage primaryStage) {

    /*
        grid.setHgap(0);
        grid.setVgap(500);

        grid.setGridLinesVisible(true);
    */
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        
        
        row0.setPercentHeight(5);
        row1.setPercentHeight(50);
        row2.setPercentHeight(10);
        row3.setPercentHeight(5);
        row4.setPercentHeight(15);
         
        grid.getRowConstraints().addAll(row0, row1,row2, row3, row4);

        grid.setAlignment(Pos.CENTER);

        grid.setHgap(5);
        grid.setVgap(5);
 
        
        grid.add(selectPromptLabel, 0, 0);
        GridPane.setHalignment(selectPromptLabel, HPos.LEFT); 
        

        coursesComboBox.getItems().addAll(
                new Course("IT4782"), 
                new Course("IT4784"),
                new Course("IT4786"),
                new Course("IT4789"),
                new Course("IT2230"),
                new Course("IT3345"),
                new Course("IT3349") );
        coursesComboBox.setMaxWidth(Double.MAX_VALUE);

        grid.add(coursesComboBox, 0, 1);
        GridPane.setValignment(coursesComboBox, VPos.TOP); 

        confirmPromptLabel.setTextFill(Color.RED);
        grid.add(confirmPromptLabel, 0, 2);  
        grid.setHalignment(confirmPromptLabel, HPos.LEFT); 
        grid.setValignment(confirmPromptLabel, VPos.TOP); 


        grid.add(registeredCoursesPromptLabel, 0, 3);  
        grid.setHalignment(registeredCoursesPromptLabel, HPos.LEFT); 
        grid.setValignment(registeredCoursesPromptLabel, VPos.TOP); 
        
 
        grid.add(creditHourPromptLabel, 1, 3);  
        grid.setHalignment(creditHourPromptLabel, HPos.LEFT);  
        grid.setValignment(creditHourPromptLabel, VPos.TOP);
       
        
        grid.add(registeredCoursesLabel, 0, 4);
        grid.setHalignment(registeredCoursesLabel, HPos.LEFT);  
        grid.setValignment(registeredCoursesLabel, VPos.TOP);
        registeredCoursesLabel.setStyle("-fx-background-color: #fff600;");
  
        grid.add(creditHoursLabel, 1, 4); 
        grid.setHalignment(creditHoursLabel, HPos.LEFT);   
        grid.setValignment(creditHoursLabel, VPos.TOP);
        creditHoursLabel.setStyle("-fx-background-color: #fff600;");
         
        Scene scene = new Scene(grid, 500, 500, Color.RED);
        
        primaryStage.setTitle("JavaFX Register for Course");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        coursesComboBox.setOnAction(e -> {
                  
            choice = coursesComboBox.getValue();
            
            String courseCode = choice.toString();
            
            // TO DO - Add Code to:
            // Validate user selection (the choice Course object)
            // Display a confirmation or error message accordingly
            // Update display of registered courses and the total credit hours as appropriate
            
            if(choice.getIsRegisteredFor())
            {
                confirmPromptLabel.setText("Already Registered for " + courseCode);
                return;
            }
            if(totalCredit>=9)
            {
                confirmPromptLabel.setText("Already reached total credits");
                return;
            }
            confirmPromptLabel.setText("Registered for " + courseCode);
            registeredCoursesLabel.setText(registeredCoursesLabel.getText() + courseCode + "\n");
            totalCredit += 3;
            creditHoursLabel.setText(totalCredit + "");
            choice.setIsRegisteredFor(true);

        });
          
    }
      


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
