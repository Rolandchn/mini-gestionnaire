import graphic.Menu;


public class Application {
    private Menu menu;

    public Application(){
        menu = new Menu();
    }

    public void run(){
        boolean running = true;
        
        while(running){
            running = menu.run();
        }

        menu.close();
    }
}