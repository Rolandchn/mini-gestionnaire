package graphic;

import java.util.Scanner;

import system.project.Project;
import system.project.ProjectManager;


public class Menu {
    private Saisir saisir;

    public Menu(){
        saisir = new Saisir(new Scanner(System.in));
    }

    public boolean run(){
        return chooseAction();
    }

    public boolean chooseAction(){
        System.out.println("\n");

        switch(saisir.saisirInt("Choisir une option: \n" +
                                "[1] Regarder un projet pré-fait \n" + 
                                "[2] Quitter",
                                "Erreur - Commande invalide.")) {
            case 1: 
                displayProject(chooseProject());
                break;
            
            case 2: 
                return false;
            
            default: 
                System.out.println("Erreur - Option invalide.");
                break;
        }

        return true;
    }

    
    public Project chooseProject(){
        Project project = new Project();
        
        boolean running = true;
        while(running){
            switch(saisir.saisirInt("Entrez le numéro du projet (1, 2, 3, 4, 5): ", "Erreur - Ecrivez un numéro")) {
                case 1:
                    project = ProjectManager.createProject1();
                    running = false;

                    break;

                case 2:
                    project = ProjectManager.createProject2();
                    running = false;

                    break;
                case 3:

                    project = ProjectManager.createProject3();
                    running = false;

                    break;
                
                case 4:
                    project = ProjectManager.createProject4();
                    running = false;

                    break;
                
                case 5:
                    project = ProjectManager.createProject5();
                    running = false;
                    break;
            
                default:
                    System.out.println("Erreur - Ce projet n'existe pas.");
                    break;
            }
        }

        return project;
    }

    public void displayProject(Project project){
        System.out.println("[Project]");
        System.out.print("Duration: ");
        displayDuration(project);

        System.out.print("Critical path: ");
        displayCriticalPath(project);
    }

    public void displayDuration(Project project){
        System.out.println(project.getDuration());
    }

    public void displayCriticalPath(Project project){
        System.out.println(project.getCriticalPath());
    }


    public void close(){
        saisir.closeSaisir();
    }

    public Saisir getSaisir() {
        return saisir;
    }
}