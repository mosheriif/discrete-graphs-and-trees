import java.util.ArrayList;
import java.util.Arrays;

public class Scheduling {
    private int[][] adjacencyMatrixCreator (String[] classes, ArrayList<String[]> conflicts) {
        int[][] adjacencyMatrix = new int[classes.length][classes.length];
        for (int i = 0; i < conflicts.size(); i++){
            String[] c = conflicts.get(i);
            int firstIndex = 0;
            int secondIndex = 0;
            for (int j = 0; j < classes.length; j++){
                if ( classes[j].equals(c[0]) )
                {
                    firstIndex = j;
                }
                if ( classes[j].equals(c[1]) )
                {
                    secondIndex = j;
                }
            }
            adjacencyMatrix[firstIndex][secondIndex] = 1;
            adjacencyMatrix[secondIndex][firstIndex] = 1;
        }
        return adjacencyMatrix;
    }
    public ArrayList<String> getColours(){
        return new ArrayList<>(Arrays.asList("Blue", "Red", "Green", "Yellow", "Purple",
                "Indigo", "Violet", "Mint", "Cyan", "Oxford Blue"));
    }
    public void colouring(String[] classes, ArrayList<String[]> conflicts){
        int[][] adjacencyMatrix = adjacencyMatrixCreator(classes, conflicts);
        String[][] colourings = new String[classes.length][2];
        ArrayList<String> colours = getColours();
        for (int i = 0; i < colourings.length; i++)
        {
            colourings[i][0] = classes[i];
            colourings[i][1] = colours.get(0);
        }
        colourings[1][1] = colours.get(0);
        for (int i = 0; i < classes.length; i++){
            int h = 0;
            for (int j = 0; j <= i; j++){
                while ((adjacencyMatrix[i][j] == 1) && (colourings[i][1].equals(colourings[j][1])))
                {
                    h++;
                    colourings[i][1] = colours.get(h);
                    j = 0;
                }
            }
        }
        output(colourings);
    }
    private void output(String[][] colourings)
    {
        System.out.println("Optimized Class Schedule:");
        for (int i = 0; i < colourings.length; i++)
        {
            System.out.println(colourings[i][0] + " - " + colourings[i][1]);
        }
    }
}
