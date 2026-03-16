# Creating a basic window
Stage           Window object which displays one Scene at a time.
Scene           Container for all currently visible elements.
Scene Graph     Hierarchical structure of all visible content in a scene.
Root node       The root of the scene graph.

## Structure example
Stage
 └── Scene
      └── VBox (root node)
           ├── Button
           ├── Label
           └── HBox
                ├── TextField
                └── Button


## Basic window example

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();       // root "dir" for all visible objects in a scene
        Scene scene = new Scene(root);  // Container for all visible objects. Needs a root node

        // stage, scene settings
        
        stage.setScene(scene);          // Set the active scene within a stage(window)
        stage.show();                   // Show the window
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}



## clean version

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);

        stageSettings(stage);

        stage.setScene(scene);
        stage.show();
    }

    public static void stageSettings(Stage stage){
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Title");

        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}





# Stage methods (Window object)

// icon, title
Image icon = new Image("icon.png");
stage.getIcons().add(icon);
stage.setTitle("Demo");

// starting dimensions
stage.setWidth(700);
stage.setHeight(500);
stage.setResizable(false);

// starting position. Default: center
stage.setX(0);
stage.setY(0);

// fullscreen options
stage.setFullScreen(true);
stage.setFullScreenExitHint("Press q to exit fullscreen");
stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

## Window Management

show()                  Display the stage
hide()                  Hide the stage
close()                 Close the stage and release resources
isShowing()             Check if the stage is currently showing


## Size and Position

setWidth(double width)              Set the width of the stage
setHeight(double height)            Set the height of the stage
setX(double x)                      Set the X position of the stage
setY(double y)                      Set the Y position of the stage

getWidth()                          Get the current width of the stage
getHeight()                         Get the current height of the stage
getX()                              Get the current X position
getY()                              Get the current Y position

centerOnScreen()                    Center the stage on the screen
setResizable(boolean)               Allow or prevent the user from resizing the stage
isResizable()                       Check if stage is resizable


## Scene Management

setScene(Scene scene)               Set the scene to be displayed in the stage
getScene()                          Get the current scene of the stage


## Style and Appearance

initStyle(StageStyle style)         Set the style of the stage (decorated, transparent, etc.)
setOpacity(double opacity)          Set the opacity of the stage (0.0–1.0)
getOpacity()                        Get the current opacity


## Title and Icons

setTitle(String title)              Set the window title
getTitle()                          Get the window title

Image icon = new Image("icon.png"); | Setting an icon
stage.getIcons().add(icon);         |

getIcons()                          Get list of window icons
setIconified(boolean value)         Minimize the stage
isIconified()                       Check if stage is minimized

setFullScreen(boolean value)        Enter or exit full-screen mode
isFullScreen()                      Check if stage is full-screen
setFullScreenExitHint(String)       Set hint for exiting full-screen
setFullScreenExitKeyCombination(KeyCombination)     Set key combination to exit full-screen





# Scene methods

## constructor
Scene(Parent root)
Scene(Parent root, double width, double height, Paint fill)


## Root node
getroot()                       returns the root node of the scene
setRoot(Parent root)            sets a new root node for the scene


# Size, Bounds
setWidth(double width)          Sets the width of the scene.
setHeight(double height)        Sets the height of the scene.
getWidth()                      Returns the width of the scene.
getHeight()                     Returns the height of the scene.

setX(double x)                  Sets the X position of the scene.
setY(double y)                  Sets the Y position of the scene.
getX()                          Returns the X-pos of the scene in the window.
getY()                          Returns the Y-pos of the scene in the window.

getBoundsInLocal()              Returns the local bounds of the scene.
getBoundsInParent()             Returns the bounds relative to the parent.


# Stylesheets
getStylesheets()                            Returns a list of applied stylesheets.
setUserAgentStylesheet(String stylesheet)   Sets the user-agent stylesheet for the scene.
getUserAgentStylesheet()                    Returns the current user-agent stylesheet.


# Focus and Cursor
isFocusTraversable()            Returns whether the scene can receive focus.
requestFocus()                  Requests focus for the scene.
getCursor()                     Returns the cursor type for the scene.
setCursor(Cursor cursor)        Sets the cursor type for the scene.


# Input and Event Handling
addEventHandler     (EventType<T> eventType, EventHandler<? super T> eventHandler)
removeEventHandler  (EventType<T> eventType, EventHandler<? super T> eventHandler)

addEventFilter      (EventType<T> eventType, EventHandler<? super T> eventHandler)
removeEventFilter   (EventType<T> eventType, EventHandler<? super T> eventHandler)

setOnKeyPressed     (EventHandler<? super KeyEvent> value)  
setOnKeyReleased    (EventHandler<? super KeyEvent> value) 

setOnMouseClicked   (EventHandler<? super MouseEvent> value)
setOnMouseMoved     (EventHandler<? super MouseEvent> value) 