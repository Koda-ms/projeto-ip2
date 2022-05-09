module com.example.projetoip2 {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;

    opens br.ufrpe.habitact to javafx.fxml;
    exports br.ufrpe.habitact;
    exports br.ufrpe.habitact.gui;
    opens br.ufrpe.habitact.gui to javafx.fxml;
    opens br.ufrpe.habitact.gui.modelos to javafx.base;
}