package system.project;

import system.link.Link;
import system.link.LinkType;
import system.task.TaskManager;


public abstract class ProjectManager{
    public static Project createProject1(){
        Project project = new Project(); 

        project.addTask(TaskManager.createTask("A", 3));
        project.addTask(TaskManager.createTask("B", 4));
        project.addTask(TaskManager.createTask("C", 2));
        project.addTask(TaskManager.createTask("D", 5));
        project.addTask(TaskManager.createTask("E", 1));
        project.addTask(TaskManager.createTask("F", 2));
        project.addTask(TaskManager.createTask("G", 4));
        project.addTask(TaskManager.createTask("H", 3));

        project.addTask(TaskManager.createTask("X", 1));
        project.addTask(TaskManager.createTask("Z", 1));


        TaskManager.addPredecessor(project.getTask("B"), project.getTask("A"));
        TaskManager.addPredecessor(project.getTask("C"), project.getTask("A"));
        TaskManager.addPredecessor(project.getTask("D"), project.getTask("B"));
        TaskManager.addPredecessor(project.getTask("E"), project.getTask("C"));
        TaskManager.addPredecessor(project.getTask("F"), project.getTask("C"));
        TaskManager.addPredecessor(project.getTask("G"), project.getTask("D"));
        TaskManager.addPredecessor(project.getTask("G"), project.getTask("E"));
        TaskManager.addPredecessor(project.getTask("H"), project.getTask("F"));
        TaskManager.addPredecessor(project.getTask("H"), project.getTask("G"));

        TaskManager.addPredecessor(project.getTask("C"), project.getTask("Z"));
        TaskManager.addPredecessor(project.getTask("Z"), project.getTask("X"));

        project.confirm();

        return project;
    }


    public static Project createProject2(){
        Project project = new Project(); 

        project.addTask(TaskManager.createTask("A", 3));
        project.addTask(TaskManager.createTask("B", 4));
        project.addTask(TaskManager.createTask("C", 3));

        TaskManager.addPredecessor(project.getTask("B"), project.getTask("A"));
        TaskManager.addPredecessor(project.getTask("C"), project.getTask("B"), new Link(LinkType.FS, 2));

        project.confirm();

        return project;
    }


    public static Project createProject3(){
        Project project = new Project(); 

        project.addTask(TaskManager.createTask("A", 2));
        project.addTask(TaskManager.createTask("B", 3));
        project.addTask(TaskManager.createTask("C", 4));
        project.addTask(TaskManager.createTask("D", 3));

        TaskManager.addPredecessor(project.getTask("B"), project.getTask("A"), new Link(LinkType.SS));
        TaskManager.addPredecessor(project.getTask("C"), project.getTask("B"));
        TaskManager.addPredecessor(project.getTask("D"), project.getTask("C"), new Link(LinkType.SS, 2));

        project.confirm();

        return project;
    }
    

    public static Project createProject4(){
        Project project = new Project(); 

        project.addTask(TaskManager.createTask("A", 3));
        project.addTask(TaskManager.createTask("B", 2));
        project.addTask(TaskManager.createTask("C", 3));
        project.addTask(TaskManager.createTask("D", 3));

        TaskManager.addPredecessor(project.getTask("B"), project.getTask("A"), new Link(LinkType.FF));
        TaskManager.addPredecessor(project.getTask("C"), project.getTask("B"), new Link(LinkType.FF, 2));
        TaskManager.addPredecessor(project.getTask("D"), project.getTask("C"));

        project.confirm();

        return project;
    }


    public static Project createProject5(){
        Project project = new Project(); 

        project.addTask(TaskManager.createTask("A", 3));
        project.addTask(TaskManager.createTask("B", 3));
        project.addTask(TaskManager.createTask("C", 4));

        TaskManager.addPredecessor(project.getTask("B"), project.getTask("A"), new Link(LinkType.SF, 5));
        TaskManager.addPredecessor(project.getTask("C"), project.getTask("B"));

        project.confirm();

        return project;
    }
}
