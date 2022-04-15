module com.example.projetoip2 {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
        
    opens br.ufrpe.habitact to javafx.fxml;
    exports br.ufrpe.habitact;
}