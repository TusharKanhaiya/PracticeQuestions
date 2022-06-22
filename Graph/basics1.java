import java.util.*;


public class newarray {

    static TreeSet<oEdge> ts;

    static class oEdge {
        String path;
        int wt;

        oEdge(String path,int wt)
        {
            this.path = path;
            this.wt = wt;
        }

        public void ToString()
        {
            System.out.println("path "+this.path+" = "+this.wt);
        }

    }

    public static class mycompare implements Comparator
    {

        @Override
        public int compare(Object o1, Object o2) {
            oEdge e1 = (oEdge) o1;
            oEdge e2 = (oEdge) o2;
            if(e1.wt>e2.wt)
                return 1;
            else 
                return -1;
        }
        
    }

    static class Edge {
        int src;
        int nbr;
        int wt;


        Edge(int src,int nbr,int wt)
        {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        public void ToString()
        {
            System.out.println("src "+this.src+" ->nbr "+this.nbr+" -> "+this.wt);
        }
    }

    public static void main(String[] args)
    {  

        ts = new TreeSet<>(new mycompare());

        int vrtx = 7;
        ArrayList<Edge>[] graph = new ArrayList[vrtx];
        for(int i=0;i<vrtx;i++)
            graph[i] = new ArrayList<Edge>();

        graph [0].add( new Edge ( 0 , 3 , 40 ) ) ;
        graph [0].add( new Edge ( 0 , 1 , 10 ) ) ;
        graph [1].add( new Edge ( 1 , 0 , 10 ) ) ;
        graph [1].add( new Edge ( 1 , 2 , 10 ) ) ;

        graph [ 2 ] .add ( new Edge ( 2 , 3 , 10 ) ) ;
        graph [ 2 ] .add ( new Edge ( 2 , 1 , 10 ) ) ;
        graph [ 3 ] .add ( new Edge ( 3 , 0 , 40 ) ) ;
        graph [ 3 ] .add ( new Edge ( 3 , 2 , 10 ) ) ;
        graph [ 3 ] .add ( new Edge ( 3 , 4 , 2 ) ) ;

        
        graph [ 4 ] .add ( new Edge ( 4 , 3 , 2 ) ) ;
        graph [ 4 ] .add ( new Edge ( 4 , 5 , 3 ) ) ;
        graph [ 4 ] .add ( new Edge ( 4 , 6 , 3 ) ) ;
        graph [ 5 ] .add ( new Edge ( 5 , 4 , 3 ) ) ;
        graph [ 5 ] .add ( new Edge ( 5 , 6 , 3 ) ) ;
        graph [ 6 ] .add ( new Edge ( 6 , 5 , 3 ) ) ;
        graph [ 6 ] .add ( new Edge ( 6 , 4 , 8 ) ) ;

        for(int i=0;i<graph.length;i++)
        {
            for(Edge edge:graph[i])
            {
                edge.ToString();
            }
        }
        
        boolean visi [] = new boolean[vrtx];
        hasPath(graph, 0, vrtx-1, visi, "", 0);
        
        // int ct = 0;
        // for(int i=0;i<vrtx;i++)
        // {
        //     if(visi[i]!=true)
        //     {
        //         connected(graph,i,visi,i+"",0);
        //         ct++;
        //     }
            
        // }
        // System.out.println(ct);

        ts.floor(new oEdge("", 40)).ToString();
        ts.first().ToString();
        ts.last().ToString();
        int k=3;
        while(!ts.isEmpty() && k>1)
        {
            ts.pollFirst();
            k--;
        }
        ts.pollFirst().ToString();
        
        
    }

    public static void connected(ArrayList<Edge> graph[] , int src,boolean [] visi,String psf,int wt)
    {
        visi[src] = true;
        int flag = 0;
        for(Edge edge : graph[src])
        {
            if(visi[edge.nbr]!=true)
            {
                flag=1;
                connected(graph, edge.nbr,visi,psf+"->"+edge.nbr,wt+edge.wt);
            }
        }
        if(flag==0)
                System.out.println("path "+psf+" = "+wt);

    }

    public static void hasPath(ArrayList<Edge> graph[] , int src,int des,boolean [] visi,String psf,int wt)
    {
        if(src==des)
        {
            // System.out.println(psf);
            ts.add(new oEdge(psf, wt));
            // return true;
        }
        visi[src] = true;
        for(Edge edge : graph[src])
        {
            if(visi[edge.nbr]!=true)
            {
                hasPath(graph, edge.nbr, des,visi,psf+"->"+edge.nbr,wt+edge.wt);
            }
        }
        visi[src] = false;
        // return false;
    }
    

}
