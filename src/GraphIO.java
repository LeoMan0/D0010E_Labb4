import java.io.*;

import java.util.NoSuchElementException;


import java.util.Scanner;

public class GraphIO {

    public static void main(String[] args) {
        // Make sure that there is at least one argument provided (the filename).



    }
    // ...

    static public void readFile(Graph g, String fileName){
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            int lineNumber = 1;
            int numberOfNodes = 0;
            String lineString;
            while (fileReader.hasNextInt()){
                // For the first line.
                if(lineNumber == 1){
                     numberOfNodes = fileReader.nextInt();
                    lineNumber++;
                }
                // For the nodes
                while (lineNumber <= numberOfNodes + 1){
                    int nodeID = fileReader.nextInt();
                    int xCoord = fileReader.nextInt();
                    int yCoord = fileReader.nextInt();
                    g.addNode(nodeID, xCoord, yCoord);
                    lineNumber++;
                }
                // For the edges
                int fromNode = fileReader.nextInt();
                int toNode = fileReader.nextInt();
                int weight = fileReader.nextInt();
                g.addEdge(fromNode, toNode, weight);
                lineNumber++;


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }




    // ...
}
