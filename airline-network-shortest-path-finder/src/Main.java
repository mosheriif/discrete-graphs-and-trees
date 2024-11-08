import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Graph graph = new Graph();

        System.out.print("Enter the list of airports: ");
        String airports = in.nextLine();
        String[] airportList = airports.split(", ");

        for(String airport: airportList){
            graph.addVertex(airport.charAt(0));
        }

        System.out.print("Enter the flights: ");
        String flights = in.nextLine();
        String[] flightList = flights.split(", ");

        System.out.println("the distance for each flight is (in miles): ");

        for (String s : flightList) {
            String distance = in.nextLine();
            char source = s.charAt(0);
            char destination = s.charAt(2);
            int weight = Integer.parseInt(distance.split(": ")[1]);
            graph.addEdge(source, destination, weight);
        }

        System.out.print("Enter the source airport: ");
        char source = in.nextLine().charAt(0);
        System.out.print("Enter the destination airport: ");
        char destination = in.nextLine().charAt(0);

        List<String> shortestPathList = graph.getShortestPath(source, destination);
        StringBuilder shortestPath = new StringBuilder();


        for(int i = 0; i < shortestPathList.size()-1; i++){
            String s = shortestPathList.get(i);
            if(i == shortestPathList.size()-2) shortestPath.append(s);
            else shortestPath.append(s).append(" -> ");
        }
        if(shortestPathList.get(0).equals("No path found")) System.out.println("No path found");
        else{
            System.out.println("The shortest path from " + source + " to " + destination + " is: " + shortestPath);
            System.out.println("The total distance is: " + shortestPathList.get(shortestPathList.size()-1) + " miles");
        }


    }
}