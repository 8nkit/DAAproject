package finalproject;
import java.io.*;
import java.util.*;

public class Dijkstra{

   void startdij(){
		
	    
	  Dijkstra obj = new Dijkstra();
		
		// Create a new graph.
		Graph g = new Graph(10);
		
		// Add the required edges.
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

	
		// Calculate Dijkstra.
	obj.calculate(g.getVertex(9));	

	// Print the minimum Distance.
		for(Vertex v:g.getVertices()){
	//		System.out.print(" Dist - "+ +" , Path - ");
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
//					System.out.print(" DELHI ");
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
					//System.out.print(" JAIPUR ");
					
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
					//System.out.print(" MUMBAI ");
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
					//System.out.print(" BENGALURU ");
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
			//		System.out.print(" GURGAON ");
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
//				System.out.print(pathvert+" ");

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
                 //   System.out.println("DELHI");

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
                   // System.out.println("JAIPUR");

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
                    { //System.out.println("KOLKATA");

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
                    	//System.out.println("MUMBAI");

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
                    	//System.out.println("HYDERABAD");

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
                    { //System.out.println("BENGALURU");
               

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
                    	//System.out.println("CHENNAI");

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
                    	//System.out.println("GURGAON");


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
                    	
				//System.out.println(""+v);
			}
			
		
		}

	}

	public void calculate(Vertex source){
		// Algo:
		// 1. Take the unvisited node with minimum weight.
		// 2. Visit all its neighbours.
		// 3. Update the distances for all the neighbours (In the Priority Queue).
		// Repeat the process till all the connected nodes are visited.
		
		source.minDistance = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			
			Vertex u = queue.poll();
		
			for(Edge neighbour:u.neighbours){
				Double newDist = u.minDistance+neighbour.weight;
				
				if(neighbour.target.minDistance>newDist){
					// Remove the node from the queue to update the distance value.
					queue.remove(neighbour.target);
					neighbour.target.minDistance = newDist;
					
					// Take the path visited till now and add the new node.s
					neighbour.target.path = new LinkedList<Vertex>(u.path);
					neighbour.target.path.add(u);
					
					//Reenter the node with new distance.
					queue.add(neighbour.target);					
				}
			}
		}
	}

}