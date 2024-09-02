module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.javafxdemo to javafx.fxml;
    opens com.example.javafxdemo.controllers to javafx.fxml;
    opens com.example.javafxdemo.logic to javafx.base;

    exports com.example.javafxdemo;
    exports com.example.javafxdemo.controllers;
    exports com.example.javafxdemo.logic;
}