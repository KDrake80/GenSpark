module com.gui.guigame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.gui.guigame to javafx.fxml;
    opens com.gui.guigame.Game to javafx.graphics;
    exports com.gui.guigame;
    exports com.gui.guigame.Game;
}