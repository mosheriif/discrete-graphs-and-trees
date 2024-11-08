import java.util.*;

public class Graph {
    private Map<Character, List<Node>> adjacencyList;
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }
    public void addVertex(Character vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(char source,char destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
    }


    public List<String> getShortestPath(char start, char end) {
        if(!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end))
            return Collections.singletonList("No path found");

       Map<Character,Character> parents = new HashMap<>();  //parent of each vertex
       Map<Character,Integer> distance = dijkstra(start,parents); //min distance from start to all other vertices

       List<String> path = new ArrayList<>();
       char current = end;

       //if there is no path from start to end

       if(distance.get(end) == Integer.MAX_VALUE){
           path.add("No path found");
           return path;
       }

       while(current != start){
           path.add(String.valueOf(current));
           current = parents.get(current);
       }

       path.add(String.valueOf(start));
       Collections.reverse(path);

       path.add(distance.get(end).toString());

       return path;
    }

    private Map<Character, Integer> dijkstra(char start, Map<Character, Character> parents) {
        Map<Character,Integer> distance = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight)); //priority queue to get the vertex with the smallest weight

        for (Character vertex : adjacencyList.keySet()) {
            distance.put(vertex, Integer.MAX_VALUE);  //set distance to infinity
            parents.put(vertex, null);             //set parents to null
        }
        distance.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
           char current = pq.poll().getVertex();

           for(Node neighbor: adjacencyList.get(current)){
               int newDistance = distance.get(current) + neighbor.getWeight();
               if(newDistance < distance.get(neighbor.getVertex())){
                     distance.put(neighbor.getVertex(), newDistance);
                     parents.put(neighbor.getVertex(), current);
                     pq.add(new Node(neighbor.getVertex(), newDistance));
               }
           }
        }

        return distance;
    }


    private static class Node {
        private Character vertex;
        private int weight;

        public Node(Character vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public Character getVertex() {
            return vertex;
        }
        public int getWeight() {
            return weight;
        }
    }
}
