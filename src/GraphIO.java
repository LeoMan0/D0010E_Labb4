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

    static public void readFile1(Graph g, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // Read and ignore the first line (number of nodes/entries).

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Splits the line by whitespace.

                // Node lines have three parts: ID, x-coordinate, y-coordinate
                // Edge lines have three parts: from-node, to-node, weight
                // If the third part is "1", we assume it's an edge
                if (parts.length == 3 && parts[2].equals("1")) {
                    // It's an edge
                    int fromNode = Integer.parseInt(parts[0]);
                    int toNode = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    g.addEdge(fromNode, toNode, weight);
                } else if (parts.length == 3) {
                    // It's a node
                    int nodeID = Integer.parseInt(parts[0]);
                    int xCoord = Integer.parseInt(parts[1]);
                    int yCoord = Integer.parseInt(parts[2]);
                    g.addNode(nodeID, xCoord, yCoord);
                }
            }
        } catch (NumberFormatException | NoSuchElementException e) {
            // Handle exceptions related to parsing integers and adding nodes/edges.
            e.printStackTrace();
            throw e;
        }
    }

    // ...
}
