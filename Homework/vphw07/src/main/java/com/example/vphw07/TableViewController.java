package com.example.vphw07;

import com.example.vphw07.Model.Person;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.scene.paint.Color;

public class TableViewController {

    @FXML
    private TableColumn<Person, Color> favoriteColorCol;

    @FXML
    private TableColumn<Person, String> fullNameCol;

    @FXML
    private TableView<Person> mainTV;

    @FXML
    private TableColumn<Person, String> sportCol;

    @FXML
    private TableColumn<Person, Boolean> vegetarianCol;

    @FXML
    private TableColumn<Person, String> yearCol;

    @FXML
    void initialize() {
        assert favoriteColorCol != null : "fx:id=\"favoriteColorCol\" was not injected: check your FXML file 'table-dialog-edit-demo.fxml'.";
        assert fullNameCol != null : "fx:id=\"fullNameCol\" was not injected: check your FXML file 'table-dialog-edit-demo.fxml'.";
        assert mainTV != null : "fx:id=\"mainTV\" was not injected: check your FXML file 'table-dialog-edit-demo.fxml'.";
        assert sportCol != null : "fx:id=\"sportCol\" was not injected: check your FXML file 'table-dialog-edit-demo.fxml'.";
        assert vegetarianCol != null : "fx:id=\"vegetarianCol\" was not injected: check your FXML file 'table-dialog-edit-demo.fxml'.";
        assert yearCol != null : "fx:id=\"yearCol\" was not injected: check your FXML file 'table-dialog-edit-demo.fxml'.";

        ObservableList<Person> personList = FXCollections.observableArrayList();
        personList.add(new Person("Kathy Smith", Color.ORANGE, "Snowboarding", "5", false));
        personList.add(new Person("John Doe", Color.BLUE, "Rowing", "3", true));
        personList.add(new Person("Sue Black", Color.GREEN, "Knitting", "2", false));
        personList.add(new Person("Jane White", Color.RED, "Speed reading", "20", true));
        personList.add(new Person("Joe Brown", Color.PINK, "Pool", "10", false));

        //Columns styles
        yearCol.setStyle("-fx-alignment: CENTER-RIGHT;");
        vegetarianCol.setStyle("-fx-alignment: CENTER;");
        favoriteColorCol.setStyle("-fx-alignment: CENTER;");

        //cellValueFactory and cellFactory
        fullNameCol.setText("");
        Label firstNameLabel = new Label("Full Name");
        firstNameLabel.setTooltip(new Tooltip("This column shows the full name"));
        fullNameCol.setGraphic(firstNameLabel);
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        fullNameCol.setCellFactory
                (
                        column ->
                        {
                            return new TableCell<Person, String>()
                            {
                                @Override
                                protected void updateItem(String item, boolean empty)
                                {
                                    super.updateItem(item, empty);
                                    setText( item );
                                    setTooltip(new Tooltip("value: " + item));
                                }
                            };
                        });
        fullNameCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> event) -> {
            TablePosition<Person, String> pos = event.getTablePosition();

            String newFullName = event.getNewValue();

            int row = pos.getRow();
            Person person = event.getTableView().getItems().get(row);

            person.setFullName(newFullName);
        });

        favoriteColorCol.setText("");
        Label favoriteColorLabel = new Label("Favorite Color");
        favoriteColorLabel.setTooltip(new Tooltip("This column shows the favorite color"));
        favoriteColorCol.setGraphic(favoriteColorLabel);
        Callback factory = new Callback<TableColumn<Person, Color>, TableCell<Person, Color>>() {
            @Override
            public TableCell<Person, Color> call(TableColumn<Person, Color> param) {
                return new TableCell<Person, Color>() {
                    private ColorPicker colorPicker;

                    public void ColorTableCell(TableColumn<Person, Color> column, Color item) {
                        this.colorPicker = new ColorPicker();
                        this.colorPicker.editableProperty().bind(column.editableProperty());
                        this.colorPicker.disableProperty().bind(column.editableProperty().not());
                        this.colorPicker.setOnShowing(event -> {
                            TableView<Person> tableView = getTableView();
                            tableView.getSelectionModel().select(getTableRow().getIndex());
                            tableView.edit(tableView.getSelectionModel().getSelectedIndex(), favoriteColorCol);
                        });
                        this.colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
                            if(isEditing()) {
                                commitEdit(newValue);
                            }
                        });
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    }

                    @Override
                    protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);
                        ColorTableCell(favoriteColorCol, item);


//                        this.colorPicker = new ColorPicker();
//                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//
//                        if (empty || item == null) {
//                            setText(null);
//                        } else {
//                            setText("");
//
//                            this.setStyle("-fx-background-color: " + item + ";");
//                        }

                        setText(null);
                        if(empty) {
                            setGraphic(null);
                        } else {
                            this.colorPicker.setValue(item);
                            this.setGraphic(this.colorPicker);
                        }
                    }

                };
            }
        };
        favoriteColorCol.setCellValueFactory(new PropertyValueFactory<>("favColor"));
        favoriteColorCol.setCellFactory(factory);

        sportCol.setText("");
        Label sportColLabel = new Label("Sport");
        sportColLabel.setTooltip(new Tooltip("This column shows the sport"));
        sportCol.setGraphic(sportColLabel);
        ObservableList<String> sportsList = FXCollections.observableArrayList("Snowboarding", "Rowing", "Knitting", "Speed reading", "Pool", "None of the above");
        sportCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> param) {
                Person person = param.getValue();
                String favSport = person.getFavSport();
                return new SimpleStringProperty(favSport);
            }
        });
        sportCol.setCellFactory(ComboBoxTableCell.forTableColumn(sportsList));
        sportCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> event) -> {
            TablePosition<Person, String> pos = event.getTablePosition();

            String newFavSport = event.getNewValue();

            int row = pos.getRow();
            Person person = event.getTableView().getItems().get(row);

            person.setFavSport(newFavSport);
        });

        yearCol.setText("");
        Label yearColLabel = new Label("# of Years");
        yearColLabel.setTooltip(new Tooltip("This column shows years"));
        yearCol.setGraphic(yearColLabel);
        yearCol.setCellValueFactory(new PropertyValueFactory<Person, String>("years"));
        yearCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
        yearCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> event) -> {
            TablePosition<Person, String> pos = event.getTablePosition();

            String newYear = event.getNewValue();

            int row = pos.getRow();
            Person person = event.getTableView().getItems().get(row);

            person.setYears(newYear);
        });

        vegetarianCol.setText("");
        Label vegetarianColLabel = new Label("Vegetarian");
        vegetarianColLabel.setTooltip(new Tooltip("This column shows whether is vegetarian"));
        vegetarianCol.setGraphic(vegetarianColLabel);
        vegetarianCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Person, Boolean> param) {
                Person person = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(person.isVegetarian());

                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        person.setVegetarian(newValue);
                    }
                });
                return booleanProp;
            }
        });


        vegetarianCol.setCellFactory(new Callback<TableColumn<Person, Boolean>, //
                TableCell<Person, Boolean>>() {
            @Override
            public TableCell<Person, Boolean> call(TableColumn<Person, Boolean> p) {
                CheckBoxTableCell<Person, Boolean> cell = new CheckBoxTableCell<Person, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        mainTV.setItems(personList);
    }
}
