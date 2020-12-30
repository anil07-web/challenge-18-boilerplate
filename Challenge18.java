import java.util.Arrays;
public class Challenge18 {
    static int R,C;
    public static void main(String[] args) {
     String[] a= {"#S###########",
                "# # # #     #",
                "# #   # ### #",
                "#   ###     #",
                "# #     ### #",
                "# # ### #   #",
                "# # #   ### #",
                "# # ### # # #",
                "#         #E#",
                "#############"
            };
Challenge18 t=new Challenge18();
int i=0,j=0;
char[][] maze=new char[a.length][];
for(i=0;i<a.length;i++)
{
    maze[i]=a[i].toCharArray();
    System.out.println(maze[i]);
}
R=maze.length;
C=maze[0].length;
hi:
for(i=0;i<R;i++)
{
    for(j=0;j<C;j++)
    {
        if(maze[i][j]=='S')
        break hi;
    }
}
boolean[][] visited=new boolean[R][C];
t.solve(i,j,maze,visited);
}
void solve(int i,int j,char[][] maze,boolean[][] visited)
{
    if(i<0||i>R||j<0||j>C||maze[i][j]=='#')
    {
        return;
    }
    if(maze[i][j]=='E')
    {
        printmaze(maze);
    }
    if(visited[i][j]==false)
    {
        char temp;
        temp=maze[i][j];
        maze[i][j]='*';
        visited[i][j]=true;
        solve(i-1, j, maze, visited);    //towards North
        solve(i+1, j, maze, visited);    //towards South
        solve(i, j+1, maze, visited);    //towards East
        solve(i, j-1, maze, visited);    //towards West
        maze[i][j]=temp;
        visited[i][j]=false;
    }
}
    public static void printmaze(char[][] maze)
    {
        int i;
        System.out.println("Solved Maze");
        for(i=0;i<R;i++)
        {
            System.out.println(maze[i]);
        }
    }
}