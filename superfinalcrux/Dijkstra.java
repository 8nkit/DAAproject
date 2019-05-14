package finalcrux;
import java.io.*;
import java.util.*;
public class Dijkstra{
   void startdij(){
    Dijkstra obj = new Dijkstra();
    Graph g = new Graph(10);
    g.addEdge(0, 1, 589);g.addEdge(0, 2, 874); g.addEdge(0, 6, 2181); g.addEdge(1, 0, 589); g.addEdge(1, 2, 281);g.addEdge(1, 5, 1417);
    g.addEdge(9, 1, 42);g.addEdge(1, 9, 42); g.addEdge(2, 1, 281); g.addEdge(2, 7, 2045);g.addEdge(2, 0, 874);g.addEdge(3, 5, 803);
    g.addEdge(3, 4, 1214); g.addEdge(4, 8, 1674);g.addEdge(4, 3, 1214); g.addEdge(5, 3, 803); g.addEdge(5, 7, 984);
    g.addEdge(5, 1, 1417);g.addEdge(6, 0, 2181); g.addEdge(6, 8, 625); g.addEdge(7, 2, 2045); g.addEdge(7, 5, 984);
    g.addEdge(7, 8, 347); g.addEdge(8, 4, 1674); g.addEdge(8, 6, 625); g.addEdge(8, 7, 347);    
    try{
        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
        out.close();
        }
  catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
    obj.calculate(g.getVertex(9));
        for(Vertex v:g.getVertices()){
              try{
                    FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                  out.write("Distance - ");
                    out.close();
                    }
              catch (Exception e){//Catch exception if any
                  System.err.println("Error: " + e.getMessage());
                }
String kr = Double.toString(v.minDistance);
              try{
                    FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                  out.write(kr);
                  out.write(" ");
                  out.close();
                    }
              catch (Exception e){//Catch exception if any
                  System.err.println("Error: " + e.getMessage());
                }
              try{
                    FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                  out.write("  Path - ");
                    out.close();
                    }
              catch (Exception e){//Catch exception if any
                  System.err.println("Error: " + e.getMessage());
                }
            for(Vertex pathvert:v.path) {
                if(pathvert.toString().equals("0"))
                    {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("KASHMIR ");
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                    
                    }
                    if(pathvert.toString().equals("1")) {
                          try{
                                FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                    BufferedWriter out = new BufferedWriter(fstream);
                              out.write("DELHI ");
                                out.close();
                                }
                          catch (Exception e){//Catch exception if any
                              System.err.println("Error: " + e.getMessage());
                            }
                
                    }
                if(pathvert.toString().equals("2")) {
                    
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("JAIPUR ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }
                    
                }
                if(pathvert.toString().equals("3")) {
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("NAGPUR ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }
                }
                if(pathvert.toString().equals("4")) {
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("KOLKATA ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }
                    
                }
                if(pathvert.toString().equals("5")) {
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("MUMBAI ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }
                }
                if(pathvert.toString().equals("6")) {
                    
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("HYDERABAD ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }
                    
                }
                if(pathvert.toString().equals("7")) {
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("BENGALURU ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }
                }
                if(pathvert.toString().equals("8")) {
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("CHENNAI ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }                   
                }
                if(pathvert.toString().equals("9")) {
                    try{
                        FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                      out.write("GURGAON ");
                        out.close();
                        }
                  catch (Exception e){//Catch exception if any
                      System.err.println("Error: " + e.getMessage());
                    }   
                }
            }{
                if(v.toString().equals("0")) {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("KASHMIR");
                          out.write(System.lineSeparator());
                          out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                                        
                }
                if(v.toString().equals("1")) {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("DELHI");
                          out.write(System.lineSeparator());
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                }
                if(v.toString().equals("2"))
                {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("JAIPUR");
                          out.write(System.lineSeparator());
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                }
                    if(v.toString().equals("3"))
                    {//   System.out.println("NAGPUR");
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("NAGPUR");
                          out.write(System.lineSeparator());
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                    }
                    if(v.toString().equals("4"))
                    {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("KOLKATA");
                          out.write(System.lineSeparator());
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                    
                    }
                    if(v.toString().equals("5"))
                    {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("MUMBAI");
                          out.write(System.lineSeparator());
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                    }
                    if(v.toString().equals("6"))
                    {
                      try{
                            FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                BufferedWriter out = new BufferedWriter(fstream);
                          out.write("HYDERABAD");
                          out.write(System.lineSeparator());
                            out.close();
                            }
                      catch (Exception e){//Catch exception if any
                          System.err.println("Error: " + e.getMessage());
                        }
                    
                    }     
                    if(v.toString().equals("7"))
                    {
               
                          try{
                                FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                    BufferedWriter out = new BufferedWriter(fstream);
                              out.write("BENGALURU");
                              out.write(System.lineSeparator());
                                out.close();
                                }
                          catch (Exception e){//Catch exception if any
                              System.err.println("Error: " + e.getMessage());
                            }
                    
                    }
                    if(v.toString().equals("8"))
                    {
                          try{
                                FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                    BufferedWriter out = new BufferedWriter(fstream);
                              out.write("CHENNAI");
                              out.write(System.lineSeparator());
                                out.close();
                                }
                          catch (Exception e){//Catch exception if any
                              System.err.println("Error: " + e.getMessage());
                            }
                    }
                    if(v.toString().equals("9"))
                    {
                          try{
                                FileWriter fstream = new FileWriter("E:\\8nkit\\out.txt",true);
                                    BufferedWriter out = new BufferedWriter(fstream);
                              out.write("GURGAON");
                              out.write(System.lineSeparator());
                                out.close();
                                }
                          catch (Exception e){//Catch exception if any
                              System.err.println("Error: " + e.getMessage());
                            }
                    }
            }
            
        
        }
    }
    public void calculate(Vertex source){
        
        source.minDistance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        queue.add(source);
        
        while(!queue.isEmpty()){
            
            Vertex u = queue.poll();
        
            for(Edge neighbour:u.neighbours){
                Double newDist = u.minDistance+neighbour.weight;
                
                if(neighbour.target.minDistance>newDist){
                    queue.remove(neighbour.target);
                    neighbour.target.minDistance = newDist;
                    neighbour.target.path = new LinkedList<Vertex>(u.path);
                    neighbour.target.path.add(u);
                    queue.add(neighbour.target);                    
                }
            }
        }
    }
}