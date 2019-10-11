package test.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Menu {
    private String imageURL;

    public Menu(String imageURL, String label, EventHandler<ActionEvent> eventHandler) {
        this.imageURL = imageURL;
        this.eventHandler = eventHandler;
        this.label = label;
    }

    public EventHandler<ActionEvent> getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler<ActionEvent> eventHandler) {
        this.eventHandler = eventHandler;
    }

    private EventHandler<ActionEvent> eventHandler;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String label;
}
