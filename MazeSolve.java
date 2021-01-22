import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;


public class MazeSolve{
  private Maze maze;

  
  public MazeSolve(Maze maze){
    this.maze = maze;
  }

 
  public boolean traverse(){
    Scanner scan = new Scanner(System.in);
    boolean done = false;
    int row, column;
    Position pos = new Position();
    Deque<Position> stack = new LinkedList<Position>();
    stack.push(pos);
    
    while (!(done) && !stack.isEmpty()){
      pos = stack.pop();
      if (pos.getx() == maze.getRows()-1 && pos.gety() == maze.getColumns()-1){
        done = true;  // the maze is solved
      }else{
        push_new_pos(pos.getx() - 1,pos.gety(),  stack); 
        push_new_pos(pos.getx() + 1,pos.gety(),  stack);
        push_new_pos(pos.getx(),pos.gety() - 1,  stack);
        push_new_pos(pos.getx(),pos.gety() + 1,  stack); 
      }
      maze.tryPosition(pos.getx(),pos.gety());  // this cell has been tried
      //System.out.println(maze);
    }
   
    return done;
  }

 
   public boolean traverse_rc(int row, int column){ 
    boolean result = false;
    
    if (row ==- maze.getRows()-1 && column == maze.getColumns()-1){
      result = true;
    }
    else if(maze.validPosition(row,column)){
      result = traverse_rc(row-1,column) || traverse_rc(row + 1, column) || 
      traverse_rc(row,column -1) || traverse_rc(row,column+1);
    }
    if(result == true){
      maze.markPath(row,column);
    }
    return result;
   }




  private void push_new_pos(int x, int y, Deque<Position> stack){
    Position npos = new Position();
    npos.setx(x);
    npos.sety(y);
    if (maze.validPosition(x,y)){
      stack.push(npos);
    }
  }
}
