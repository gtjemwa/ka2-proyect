/*
 * WordominatonApp.java
 */

package wordominaton;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class WordominatonApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        WordominatonView wv = new WordominatonView(this);
        this.show(wv);
        this.getMainFrame().setBounds(210, 210, 356, 254);
        
    }


    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of WordominatonApp
     */
    public static WordominatonApp getApplication() {
        return Application.getInstance(WordominatonApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(WordominatonApp.class, args);
    }
}
