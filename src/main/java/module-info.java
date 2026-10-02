module org.example.imc_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.imc_2 to javafx.fxml, javafx.base;
    exports org.example.imc_2;
}