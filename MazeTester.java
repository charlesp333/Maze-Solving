import java.util.*;
import java.io.*;


public class MazeTester{
 
  public static void main(String[] args) throws FileNotFoundException{
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the name of the file containing the maze: ");
    String filename = scan.nextLine();
    System.out.print("Enter the row you wish to start on: ");
    int row = scan.nextInt();

    System.out.print("Enter the column you wish to start on: ");
    int column = scan.nextInt();

    Maze labyrinth = new Maze(filename);

    System.out.println(labyrinth);

    MazeSolver solver = new MazeSolver(labyrinth);

    if (solver.traverse_rc(row,column)){
      System.out.println("The maze was successfully traversed!");
    }else{
      System.out.println("There is no possible path from this location");
    }
    System.out.println(labyrinth);
  }
}
