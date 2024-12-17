package system.task;

import system.link.Link;

import java.util.HashMap;
import java.util.Map;


public class Task {
    private String name;
    private int duration;
    private Map<Task, Link> successor;    

    public Task(String name, int duration){
        this.name = name;
        this.duration = duration;

        successor = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Map<Task, Link> getSuccessor() {
        return successor;
    }

    @Override
    public String toString(){
        StringBuffer buff = new StringBuffer("[");

        if(!successor.isEmpty()){
            for(Task task : successor.keySet()){
                buff.append(task.getName() + " ");
            }

            buff.replace(buff.length() -1, buff.length(), "");
        }

        buff.append("]");

        return name;
    }
}
