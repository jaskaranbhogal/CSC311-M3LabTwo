module com.example.csc311m3labtwo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc311m3labtwo to javafx.fxml;
    exports com.example.csc311m3labtwo;
}