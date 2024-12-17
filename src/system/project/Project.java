package system.project;

import java.util.ArrayList;
import java.util.List;

import system.task.Task;
import system.util.GraphMethods;


public class Project {
    private List<Task> tasks;

    private List<Task> startingTasks;
    private List<Task> endingTasks;

    private int duration;
    private List<Task> criticalPath;

    public Project(){
        duration = 0;
        
        tasks = new ArrayList<>();

        startingTasks = new ArrayList<>();
        endingTasks = new ArrayList<>();
        
        criticalPath = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);

        startingTasks.add(task);
        endingTasks.add(task);
    }

    public void findStartingTasks(){
        for(Task task : tasks){
            for(Task successorTask : task.getSuccessor().keySet()){
                startingTasks.remove(successorTask);
            }
        }
    }


    public void findEndingTasks(){
        for(Task task : tasks){
            if(!task.getSuccessor().isEmpty()){
                endingTasks.remove(task);
            }
        }
    }


    public void confirm(){
        findStartingTasks();
        findEndingTasks();

        criticalPath = GraphMethods.longestPath(tasks, startingTasks, endingTasks);
        duration = GraphMethods.readPath(criticalPath);
    }


    public Task getTask(String name){
        for(Task task : tasks){
            if(task.getName().equals(name)){
                return task;
            }
        }

        return null;
    }


    public String toString(){
        return tasks.toString();
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    public void setCriticalPath(List<Task> criticalPath) {
        this.criticalPath = criticalPath;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getStartingTasks() {
        return startingTasks;
    }
    

    public List<Task> getEndingTasks() {
        return endingTasks;
    }

    public int getDuration() {
        return duration;
    }

    public List<Task> getCriticalPath() {
        return criticalPath;
    }
}
