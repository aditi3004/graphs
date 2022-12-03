package graphs;
import java.util.*;

class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }

}

class graph {
    Scanner sc = new Scanner(System.in);
    node head[] = new node[10]; // number of heads for creating adjacency list
    int v=0;// number of vertices total in graph
    int e=0;// number of edges
    
    //for matrix representation
    int adjMatrix[][];

    public void listCreate() {
        System.out.println("enter the number of vertices: ");
        v = sc.nextInt();
        System.out.println("enter the number of edges: ");
        e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            System.out.println("enter the starting vertex: ");
            int sv = sc.nextInt();
            System.out.println("enter the ending vertex: ");
            int ev = sc.nextInt();

            // since undirected graph then we have both direction relation
            insert(sv, ev);
            insert(ev, sv);
        }

    }

    public void insert(int u, int v) {
        node temp = new node(v);
        if (head[u] == null) {
            head[u] = temp;
        }

        else {
            node curr = head[u]; // node created for traversal
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp; // added the new node at the last of linked list
        }
    }

    // displaying the adjacency list
    public void displayList() {
    	System.out.println("Adjacency List: ");
        for (int i = 0; i < v; i++) {
            node curr = head[i];
            System.out.print(i + " ");
            while (curr != null) {
                System.out.print("-->" + curr.data);
                curr = curr.next;
            }
            System.out.println();
        }
    }
    
    public void createMatrix() {
    	
    	System.out.println("enter the numer of vertices: ");
    	v=sc.nextInt();
    	System.out.println("enter the number of edges: ");
    	e=sc.nextInt();
    	adjMatrix=new int[v][v];
    	for( int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                adjMatrix[i][j]=0;
            }
        }
    	for(int i=0;i<e;i++)
        {
    		System.out.println("enter the starting vertex: ");
            int sv = sc.nextInt();
            System.out.println("enter the ending vertex: ");
            int ev = sc.nextInt();
            
            adjMatrix[sv][ev]=1;
            adjMatrix[ev][sv]=1;
        
        }
    }
    
    public void displayMat() {
    	System.out.println("Adjacency Matrix: ");
    	for( int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    
    public void bfs(int n,int v) {
    	//n=no of vertices in the graph
    	//v=starting vertex
    	int[] visited=new int[n];
    	for(int i=0;i<n;i++) {
    		visited[i]=0;
    	}
    	
    	 Queue<Integer> q = new LinkedList<>();
    	 q.add(v);
    	 visited[v]=1;
    	 System.out.print(v+" ");
    	 
    	 while(q.size()>0) {
    		 int tempIndex=q.remove();
    		 node curr=head[tempIndex];
    		 while(curr!=null) {
    			 if(visited[curr.data]!=1) {
    				 q.add(curr.data);
    				 visited[curr.data]=1;
    				 System.out.print(curr.data+" ");
    			 }
    			 
    			 curr=curr.next;
    		 }
    	 
    	 }
    	
    	
    	
    }

}
public class bfsGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph g = new graph();
        g.listCreate();
        g.displayList();
        //g.createMatrix();
        //g.displayMat();
        g.bfs(5, 0);
	}

}
