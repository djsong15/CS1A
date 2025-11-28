package edu.foothill.cs1a;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * An application for viewing posters for movies and TV/Internet shows.
 * 
 * @author Baba Kofi Weusijana
 * @author Daniel Song
 *
 */
public class PosterViewer extends Application {
    private static final double APP_SPACING = 10;
    private static final double APP_WIDTH = 800;
    private static final double APP_HEIGHT = 400;
    private static final boolean DEBUG = true;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * TODO: Make sure you adhere to the following JavaDoc specification for this
     * helper method:<br/>
     * If the url parameter is null, invalid, or unsupported, the returned Image
     * object will be null and the posterLabel's text will be set to the localized
     * error message. Otherwise the posterLabel's text will be set to the url.
     * 
     * @param url         String object
     * @param posterLabel Label object for the posterImageView
     * @return Image object for the posterImageView
     */
    private Image getPosterImage(String url, Label posterLabel) {
        // TODO: You MUST complete the try-catch code below to handle if the
        // posterImage's URL is null, invalid, or unsupported.
        // This means you must at least catch:
        // NullPointerException - if URL is null
        // IllegalArgumentException - if URL is invalid or unsupported
        // Do NOT simply catch a general Exception or Throwable!
        // Each catch block must print the stack trace of the caught exception.
        Image posterImage = null;
        try {
            posterImage = new Image(url);
            if (posterImage != null) {
                if (DEBUG) {
                    System.out.println("posterImage.getUrl():" + posterImage.getUrl());
                    System.out.println("posterImage.isError():" + posterImage.isError());
                    System.out.println("posterImage.isBackgroundLoading():" + posterImage.isBackgroundLoading());
                }
                posterLabel.setText(url);
                if (posterImage.isError()) {
                    posterLabel.setText(posterImage.getException().getLocalizedMessage());
                } else if (posterImage.isBackgroundLoading()) {
                    posterLabel.setText("Background is loading...");
                }
            }
            // TODO: Call getLocalizedMessage and printStackTrace on each exception caught
        } catch (NullPointerException e) {
            e.printStackTrace();
            posterLabel.setText(e.getLocalizedMessage());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            posterLabel.setText(e.getLocalizedMessage());
        }

        return posterImage;
    }

    /**
     * @param stage The Stage object for this Application
     */
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
        final ComboBox<String> posterComboBox = new ComboBox<String>();
        final ImageView posterImageView = new ImageView();
        // TODO: You must find and use 10 posters (and also include the 4 problematic
        // URLS at the end so you can show what happens during an exceptional error
        // event).
        // https://libremdb.iket.me/find is a good place to find fair use and open
        // licensed poster images.
        // posterNames is an array of poster names that will be shown in the
        // posterComboBox so users can select which poster to view.
        String[] posterNames = {
                "Back to the Future",
                "Blade Runner",
                "The Breakfast Club",
                "The Empire Strikes Back",
                "Ferris Bueller's Day Off",
                "The Goonies",
                "The Princess Bride",
                "Raiders of the Lost Ark",
                "The Terminator",
                "Top Gun",
                "Bad URL",
                "null URL",
                "URL to an HTML page",
                "Empty URL"
        };
        // posterURLs is an array of URLs to the poster images that each match the
        // poster name in the same index position inside the posterNames array.
        // NOTE: External URLs are blocked with 403 errors, so we use local resources
        // instead.
        // Download poster images and save them in src/main/resources/images/ folder
        String[] posterURLs = {
                getClass().getResource("/images/Back_to_the_Future.jpg") != null
                        ? getClass().getResource("/images/Back_to_the_Future.jpg").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/Blade_Runner_(1982_poster).png") != null
                        ? getClass().getResource("/images/Blade_Runner_(1982_poster).png").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/The_Breakfast_Club_poster.jpg") != null
                        ? getClass().getResource("/images/The_Breakfast_Club_poster.jpg").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/The_Empire_Strikes_Back_(1980_film).jpg") != null
                        ? getClass().getResource("/images/The_Empire_Strikes_Back_(1980_film).jpg").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/Ferris_Bueller's_Day_Off.jpg") != null
                        ? getClass().getResource("/images/Ferris_Bueller's_Day_Off.jpg").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/The_Goonies.jpg") != null
                        ? getClass().getResource("/images/The_Goonies.jpg").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/Princess_bride.jpg") != null
                        ? getClass().getResource("/images/Princess_bride.jpg").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/Raiders_of_the_Lost_Ark_Theatrical_Poster.jpg") != null
                        ? getClass().getResource("/images/Raiders_of_the_Lost_Ark_Theatrical_Poster.jpg")
                                .toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/The_Terminator.png") != null
                        ? getClass().getResource("/images/The_Terminator.png").toExternalForm()
                        : "file-not-found",
                getClass().getResource("/images/Top_Gun_Movie.jpg") != null
                        ? getClass().getResource("/images/Top_Gun_Movie.jpg").toExternalForm()
                        : "file-not-found",
                "badURL", // For testing IllegalArgumentException
                null, // For testing NullPointerException
                "https://www.google.com", // HTML page - will cause error
                "" // Empty URL
        };

        // Setup posterLabel and posterImageView
        Label posterLabel = new Label();
        posterLabel.setLabelFor(posterImageView);
        posterImageView.setPreserveRatio(true);
        posterImageView.setSmooth(true);
        posterImageView.setCache(true);

        // Setup posterComboBox
        posterComboBox.getItems().setAll(posterNames);
        posterComboBox.setPromptText("Posters");
        posterComboBox.setEditable(false);
        posterComboBox.getSelectionModel().select(0);
        posterComboBox.setOnAction((ActionEvent actionEvent) -> {
            if (DEBUG) {
                System.out.println(actionEvent.toString());
                System.out.println("Target:" + actionEvent.getTarget());
                System.out.println(posterComboBox.getSelectionModel().getSelectedItem());
            }
            int selectedIndex = posterComboBox.getSelectionModel().getSelectedIndex();
            // TODO: Load the nextPosterImage by calling getPosterImage with the correct URL
            // String from the posterURLs array and the posterLabel object.
            Image nextPosterImage = this.getPosterImage(posterURLs[selectedIndex], posterLabel);
            posterImageView.setImage(nextPosterImage);

        });
        // By firing an ActionEvent, the listener defined above will be called and
        // thus load the first poster Image.
        posterComboBox.fireEvent(new ActionEvent());

        // Arrange the graphic components into the scene and show the stage
        VBox posterVBox = new VBox();
        posterVBox.setAlignment(Pos.CENTER);
        posterVBox.getChildren().addAll(posterLabel, posterImageView);

        VBox controlsVBox = new VBox();
        controlsVBox.setSpacing(APP_SPACING);
        controlsVBox.getChildren().addAll(posterComboBox);

        HBox sceneHBox = new HBox();
        sceneHBox.setSpacing(APP_SPACING);
        sceneHBox.setAlignment(Pos.CENTER);
        sceneHBox.getChildren().addAll(controlsVBox, posterVBox);

        Scene scene = new Scene(sceneHBox, APP_WIDTH, APP_HEIGHT);
        stage.setTitle("Poster Viewer");
        stage.setWidth(APP_WIDTH);
        stage.setHeight(APP_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
}