package test.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import java.io.IOException;


public class MenuCardController {
    @FXML
    private ImageView imageView;
    @FXML
    private Label name;
    @FXML
    private ListView listView;
    @FXML
    private HBox hBox;

    public void setMenuCard(MenuCard menuCard) {
        //hBox.getStylesheets().add(getClass().getResource("Menu.fxml").toExternalForm());
        this.menuCard = menuCard;

        imageView.setImage(new Image(getClass().getResource(menuCard.getImagePath()).toExternalForm()));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        name.setText(menuCard.getName());
        menuCard.getList().stream().map(m -> {
                    Button button = new Button(m.getLabel());
                    button.getStyleClass().add("button");
                    ImageView imageView = new ImageView(getClass().getResource(m.getImageURL()).toExternalForm());
                    imageView.setFitWidth(30);
                    imageView.setFitHeight(30);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    button.setGraphic(imageView);

                    button.setOnAction(m.getEventHandler());
                    return button;
                }
        ).forEach(menu -> listView.getItems().add(menu));
    }

    private MenuCard menuCard;

    public static Parent load(MenuCard menuCard) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuCardController.class.getResource("Menu.fxml"));
            Parent parent = fxmlLoader.load();
            MenuCardController menuCardController = fxmlLoader.getController();
            menuCardController.setMenuCard(menuCard);
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
