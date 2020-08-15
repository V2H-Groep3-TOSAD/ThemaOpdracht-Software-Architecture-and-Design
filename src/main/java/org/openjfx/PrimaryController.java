package org.openjfx;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import org.domain.Operator;
import org.services.OperatorService;
import org.services.impl.OperatorServiceImpl;

public class PrimaryController {

    private OperatorService service = new OperatorServiceImpl();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        List<Operator> operators = service.getAllOperators();
        for (Operator operator : operators){
            System.out.println(operator.getName());
        }

    }
}
