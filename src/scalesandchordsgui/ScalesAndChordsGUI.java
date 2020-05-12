/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scalesandchordsgui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Luis Carlos A. Rojas Torres <luiscarlos.bsf@oceanica.ufrj.br>
 */
public class ScalesAndChordsGUI extends Application {
    Scales escalaTest = new Scales("C");
    
    Chord chordC  = new Chord("C");
    Chord chordDb = new Chord("Db");
    Chord chordD  = new Chord("D");
    Chord chordEb = new Chord("Eb");
    Chord chordE  = new Chord("E");
    Chord chordF  = new Chord("F");
    Chord chordGb = new Chord("Gb");
    Chord chordG  = new Chord("G");
    Chord chordAb = new Chord("Ab");
    Chord chordA  = new Chord("A");
    Chord chordBb = new Chord("Bb");
    Chord chordB  = new Chord("B");
    //Grupos de circulos
    groupNotes groupC  = new groupNotes("C" ,escalaTest);
    groupNotes groupDb = new groupNotes("Db",escalaTest);
    groupNotes groupD  = new groupNotes("D" ,escalaTest);
    groupNotes groupEb = new groupNotes("Eb",escalaTest);
    groupNotes groupE  = new groupNotes("E" ,escalaTest);
    groupNotes groupF  = new groupNotes("F" ,escalaTest);
    groupNotes groupGb = new groupNotes("Gb",escalaTest);
    groupNotes groupG  = new groupNotes("G" ,escalaTest);
    groupNotes groupAb = new groupNotes("Ab",escalaTest);
    groupNotes groupA  = new groupNotes("A" ,escalaTest);
    groupNotes groupBb = new groupNotes("Bb",escalaTest);
    groupNotes groupB  = new groupNotes("B" ,escalaTest);
    
    
    @Override
    public void start(Stage primaryStage) {
////////INICIO COMBO BOX DE ESCALA Y NOTAS
        ComboBox<String> cbNota = new ComboBox<>();
        cbNota.getItems().addAll("A","Bb","B","C","Db","D","Eb","E","F","Gb","G","Ab");
        cbNota.setValue("Note");
        
                        
        ComboBox<String> cbEscala = new ComboBox<>();
        cbEscala.getItems().addAll("Major","Major Pentatonic",
                "Minor","Minor Pentatonic",
                "Ionian","Dorian","Phrygian","Lydian","Mixolydian","Aeolian","Locrian");
        cbEscala.setValue("Scales");
        
        HBox hboxComboBoxes = new HBox(10);
        hboxComboBoxes.setAlignment(Pos.TOP_LEFT);
        
        hboxComboBoxes.getChildren().addAll(cbNota,cbEscala);
////////FIN COMBO BOX DE ESCALA Y NOTAS
        
////////INICIO TABLA DE ACORDES COMPATIBLES
        TableColumn tableA  = new TableColumn("A");
        tableA.setPrefWidth(75);
        TableColumn tableBb = new TableColumn("Bb");
        tableBb.setPrefWidth(75);
        TableColumn tableB  = new TableColumn("B");
        tableB.setPrefWidth(75);
        TableColumn tableC  = new TableColumn("C");
        tableC.setPrefWidth(75);
        TableColumn tableDb = new TableColumn("Db");
        tableDb.setPrefWidth(75);
        TableColumn tableD  = new TableColumn("D");
        tableD.setPrefWidth(75);
                
        TableColumn tableE  = new TableColumn("E");
        tableE.setPrefWidth(75);
        TableColumn tableEb = new TableColumn("Eb");
        tableEb.setPrefWidth(75);
        TableColumn tableF  = new TableColumn("F");
        tableF.setPrefWidth(75);
        TableColumn tableGb = new TableColumn("Gb");
        tableGb.setPrefWidth(75);
        TableColumn tableG  = new TableColumn("G");
        tableG.setPrefWidth(75);
        TableColumn tableAb = new TableColumn("Ab");
        tableAb.setPrefWidth(75);
        //tablaAb.setMinWidth(75);
        //tablaAb.setMaxWidth(75);
                      
        TableView tableChords = new TableView();
        tableChords.getColumns().addAll(tableA,tableBb,tableB,tableC,tableDb,tableD,
                tableE,tableEb,tableF,tableGb,tableG,tableAb);
        tableChords.setMaxSize(900, 400);
        tableChords.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        
        VBox vBoxTables = new VBox(0);
        vBoxTables.setAlignment(Pos.CENTER_LEFT);
        vBoxTables.getChildren().addAll(hboxComboBoxes,tableChords);
        
////////FIN TABLA DE ACORDES COMPATIBLES
        
////////INICIO TABLA DE ACORDES COMPATIBLES        
        Image trastero = new Image("strat22.png");
        ImageView imagenTrastero = new ImageView(trastero);
          
        Group grupo = new Group(imagenTrastero);
        
        //COMBOBOXES
        cbNota.setOnAction(e -> {
            escalaTest.setKey(cbNota.getValue());
            groupC.setGroupNotesColours(escalaTest);
            groupDb.setGroupNotesColours(escalaTest);
            groupD.setGroupNotesColours(escalaTest);
            groupEb.setGroupNotesColours(escalaTest);
            groupE.setGroupNotesColours(escalaTest);
            groupF.setGroupNotesColours(escalaTest);
            groupGb.setGroupNotesColours(escalaTest);
            groupG.setGroupNotesColours(escalaTest);
            groupAb.setGroupNotesColours(escalaTest);
            groupA.setGroupNotesColours(escalaTest);
            groupBb.setGroupNotesColours(escalaTest);
            groupB.setGroupNotesColours(escalaTest);
            
        String[] dummyArray;
            switch(cbEscala.getValue()){
                case "Major":
                    dummyArray = escalaTest.getMajorScaleArray();
                    break;
                case "Major Pentatonic":
                    dummyArray = escalaTest.getMajorPentatonicScaleArray();
                    break;
                case "Minor":
                    dummyArray = escalaTest.getMinorScaleArray();
                    break;
                case "Minor Pentatonic":
                    dummyArray = escalaTest.getMinorPentatonicScaleArray();
                    break;
                case "Ionian":
                    dummyArray = escalaTest.getIonianScaleArray();
                    break;
                case"Dorian":
                    dummyArray = escalaTest.getDorianScaleArray();
                    break;
                case "Phrygian":
                    dummyArray = escalaTest.getPhrygianScaleArray();
                    break;
                case "Lydian":
                    dummyArray = escalaTest.getLydianScaleArray();
                    break;
                case "Mixolydian":
                    dummyArray = escalaTest.getMixolydianScaleArray();
                    break;
                case "Aeolian":
                    dummyArray = escalaTest.getAeolianScaleArray();
                    break;
                case "Locrian":
                    dummyArray = escalaTest.getLocrianScaleArray();
                    break;
                default:
                    dummyArray = escalaTest.getMajorScaleArray();
                    break;
            }
            
            chordA.verify_ALL(dummyArray);
            chordBb.verify_ALL(dummyArray);
            chordB.verify_ALL(dummyArray);
            chordC.verify_ALL(dummyArray);
            chordDb.verify_ALL(dummyArray);
            chordD.verify_ALL(dummyArray);
            chordEb.verify_ALL(dummyArray);
            chordE.verify_ALL(dummyArray);
            chordF.verify_ALL(dummyArray);
            chordGb.verify_ALL(dummyArray);
            chordG.verify_ALL(dummyArray);
            chordAb.verify_ALL(dummyArray);
            System.out.println("ACORDES CONTENIDOS EN LA ESCALA");
            chordA.showArrayList();
            chordBb.showArrayList();
            chordB.showArrayList();
            chordC.showArrayList();
            chordDb.showArrayList();
            chordD.showArrayList();
            chordEb.showArrayList();
            chordE.showArrayList();
            chordF.showArrayList();
            chordGb.showArrayList();
            chordG.showArrayList();
            chordAb.showArrayList();
            System.out.println("------------------------------------------------");
            
            
            //GRAPHIC PART
            grupo.getChildren().clear();
            grupo.getChildren().add(imagenTrastero);
            
            for(String i: dummyArray){
                
            switch(i){
                case "C":
                    grupo.getChildren().add(groupC.getGroupNote());
                    break;
                case "D":
                    grupo.getChildren().add(groupD.getGroupNote());
                    break;
                case "E":
                    grupo.getChildren().add(groupE.getGroupNote());
                    break;
                case "F":
                    grupo.getChildren().add(groupF.getGroupNote());
                    break;
                case "G":
                    grupo.getChildren().add(groupG.getGroupNote());
                    break;
                case "A":
                    grupo.getChildren().add(groupA.getGroupNote());
                    break;
                case "B":
                    grupo.getChildren().add(groupB.getGroupNote());
                    break;
                case "Db": //C#
                    grupo.getChildren().add(groupDb.getGroupNote());
                    break;
                case "Eb": //D#
                    grupo.getChildren().add(groupEb.getGroupNote());
                    break; 
                case "Gb": //F#
                    grupo.getChildren().add(groupGb.getGroupNote());
                    break;
                case "Ab": //G#
                    grupo.getChildren().add(groupAb.getGroupNote());
                    break;
                case "Bb": //A#
                    grupo.getChildren().add(groupBb.getGroupNote());
                    break;
                default:
                    break;
            }
            }
            
            
        });
        
        
        cbEscala.setOnAction(e ->{
            String[] dummyArray;
            switch(cbEscala.getValue()){
                case "Major":
                    dummyArray = escalaTest.getMajorScaleArray();
                    break;
                case "Major Pentatonic":
                    dummyArray = escalaTest.getMajorPentatonicScaleArray();
                    break;
                case "Minor":
                    dummyArray = escalaTest.getMinorScaleArray();
                    break;
                case "Minor Pentatonic":
                    dummyArray = escalaTest.getMinorPentatonicScaleArray();
                    break;
                case "Ionian":
                    dummyArray = escalaTest.getIonianScaleArray();
                    break;
                case"Dorian":
                    dummyArray = escalaTest.getDorianScaleArray();
                    break;
                case "Phrygian":
                    dummyArray = escalaTest.getPhrygianScaleArray();
                    break;
                case "Lydian":
                    dummyArray = escalaTest.getLydianScaleArray();
                    break;
                case "Mixolydian":
                    dummyArray = escalaTest.getMixolydianScaleArray();
                    break;
                case "Aeolian":
                    dummyArray = escalaTest.getAeolianScaleArray();
                    break;
                case "Locrian":
                    dummyArray = escalaTest.getLocrianScaleArray();
                    break;
                default:
                    dummyArray = escalaTest.getMajorScaleArray();
                    break;
            }
                       
            chordA.verify_ALL(dummyArray);
            chordBb.verify_ALL(dummyArray);
            chordB.verify_ALL(dummyArray);
            chordC.verify_ALL(dummyArray);
            chordDb.verify_ALL(dummyArray);
            chordD.verify_ALL(dummyArray);
            chordEb.verify_ALL(dummyArray);
            chordE.verify_ALL(dummyArray);
            chordF.verify_ALL(dummyArray);
            chordGb.verify_ALL(dummyArray);
            chordG.verify_ALL(dummyArray);
            chordAb.verify_ALL(dummyArray);
            
            System.out.println("ACORDES CONTENIDOS EN LA ESCALA");
            chordA.showArrayList();
            chordBb.showArrayList();
            chordB.showArrayList();
            chordC.showArrayList();
            chordDb.showArrayList();
            chordD.showArrayList();
            chordEb.showArrayList();
            chordE.showArrayList();
            chordF.showArrayList();
            chordGb.showArrayList();
            chordG.showArrayList();
            chordAb.showArrayList(); 
            System.out.println("------------------------------------------------");
            
            grupo.getChildren().clear();
            grupo.getChildren().add(imagenTrastero);
            for(String i: dummyArray){
                
            switch(i){
                case "C":
                    grupo.getChildren().add(groupC.getGroupNote());
                    break;
                case "D":
                    grupo.getChildren().add(groupD.getGroupNote());
                    break;
                case "E":
                    grupo.getChildren().add(groupE.getGroupNote());
                    break;
                case "F":
                    grupo.getChildren().add(groupF.getGroupNote());
                    break;
                case "G":
                    grupo.getChildren().add(groupG.getGroupNote());
                    break;
                case "A":
                    grupo.getChildren().add(groupA.getGroupNote());
                    break;
                case "B":
                    grupo.getChildren().add(groupB.getGroupNote());
                    break;
                case "Db": //C#
                    grupo.getChildren().add(groupDb.getGroupNote());
                    break;
                case "Eb": //D#
                    grupo.getChildren().add(groupEb.getGroupNote());
                    break; 
                case "Gb": //F#
                    grupo.getChildren().add(groupGb.getGroupNote());
                    break;
                case "Ab": //G#
                    grupo.getChildren().add(groupAb.getGroupNote());
                    break;
                case "Bb": //A#
                    grupo.getChildren().add(groupBb.getGroupNote());
                    break;
                default:
                    break;
            }
            }            
                    
        });
        
        
        
        //
        
////////FIN TABLA DE ACORDES COMPATIBLES        
        
        
        VBox root = new VBox(50);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBoxTables,grupo);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Scales & Chords v1.0 2020");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
