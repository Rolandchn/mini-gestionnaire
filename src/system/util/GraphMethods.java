package system.util;

import system.task.Task;
import system.link.Link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public abstract class GraphMethods {
    public static int dfs(int index_result, Task task, boolean [] visited, Task[] result, List<Task> tasks){
        visited[tasks.indexOf(task)] = true;

        for(Task successorTask : task.getSuccessor().keySet()){
            if(visited[tasks.indexOf(successorTask)] == false){
                index_result = dfs(index_result, successorTask, visited, result, tasks);
            }
        }

        result[index_result] = task;

        return index_result - 1;
    }


    public static Task [] topSort(List<Task> tasks, List<Task> sources){
        int nbTask = tasks.size();

        boolean [] visited = new boolean[nbTask];
        Task [] result = new Task[nbTask];
        
        // initialize table
        for(int i = 0; i < nbTask; i++){
            visited[i] = false;
            result[i] = null;
        }
        
        int index_result = nbTask - 1;

        for(Task source : sources){
            index_result = dfs(index_result, source, visited, result, tasks);
        }

        return result;
    }

    public static List<Task> longestPath(List<Task> tasks, List<Task> sources, List<Task> destinations){
        Task [] topSort = topSort(tasks, sources);
        
        int nbTask = tasks.size();

        int [] distance = new int[nbTask];
        Task [] predecessor = new Task[nbTask];
        
        // pour initialiser les tableaux
        for(int i = 0; i < nbTask; i++){
            distance[i] = 0;
            predecessor[i] = null;
        }
        
        for(Task source : sources){
            distance[tasks.indexOf(source)] = source.getDuration();
        }

        // pour calculer le chemin le plus long
        int newDistance;
        for(Task task : topSort){
            for(Map.Entry<Task, Link> successor : task.getSuccessor().entrySet()){
                newDistance = distance[tasks.indexOf(task)] 
                                + successor.getKey().getDuration() 
                                + successor.getValue().getLag();

                if(distance[tasks.indexOf(successor.getKey())] < newDistance){
                    distance[tasks.indexOf(successor.getKey())] = newDistance;
                    
                    // pour enregistrer le chemin 
                    predecessor[tasks.indexOf(successor.getKey())] = task;
                }
            }
        }

        // reconstruit le chemin le plus long
        List<Task> result = new ArrayList<>();

        Task task = destinations.get(0);

        while(task != null){
            result.add(task);
            task = predecessor[tasks.indexOf(task)];
        }
        
        Collections.reverse(result);

        return result;
    }

    public static int readPath(List<Task> path){
        int result = 0;
        
        for(int i = 0; i < path.size(); i++){
            int lag = 0;

            if(i != path.size() - 1){
                lag = path.get(i).getSuccessor().get(path.get(i + 1)).getLag();
            }
            
            result += path.get(i).getDuration() + lag; 
        }

        return result;
    }
}
