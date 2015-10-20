package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Created observable array List. When it adds item it will populate new item into view list(listView)
    ObservableList<ToDoItem> items = FXCollections.observableArrayList();

    @FXML
    TextField textField;
    @FXML
    ListView listView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(items);
    }//End of Initialize method

    public void addItem(){
        ToDoItem newItem = new ToDoItem(textField.getText(), false);
        items.add(newItem);
        textField.setText("");
    }//End of AddItem method

    public void toggleItem(){
        ToDoItem item = (ToDoItem) listView.getSelectionModel().getSelectedItem();
        if(item != null){
            item.isDone = !item.isDone;

            //force listView to refresh
            listView.setItems(null);
            listView.setItems(items);
        }//End of if
    }//End of toggleItem

}//End of Controller Class
