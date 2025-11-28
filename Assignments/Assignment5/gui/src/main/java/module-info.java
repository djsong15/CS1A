module edu.foothill.cs1a {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.foothill.cs1a to javafx.fxml;
    exports edu.foothill.cs1a;
}
