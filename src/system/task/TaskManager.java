package system.task;

import system.link.Link;
import system.link.LinkType;


public abstract class TaskManager {
    public static Task createTask(String name, int duration){
        return new Task(name, duration);
    }

    public static void addPredecessor(Task task, Task predecessorTask){
        addPredecessor(task, predecessorTask, new Link(LinkType.FS));
    }

    public static void addPredecessor(Task task, Task predecessorTask, Link link){
        predecessorTask.getSuccessor().put(task, link);
    }
}
