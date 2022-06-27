import static org.junit.Assert.fail;

import java.util.*;


public class allHamiltonianPaths{

    

   
    static class Edge {
        int src;
        int nbr;
        // int wt;


        Edge(int src,int nbr)
        {
            this.src = src;
            this.nbr = nbr;
            // this.wt = wt;
        }

        public void ToString()
        {
            System.out.println("src "+this.src+" ->nbr "+this.nbr);
        }
    }

    public static void main(String[] args)
    {  
        int vrtx=7;
        ArrayList<Edge> gr[]= new ArrayList[vrtx];

        for(int i=0;i<vrtx;i++)
            gr[i] = new ArrayList<>();

            gr [0].add( new Edge ( 0 , 3 ) ) ;
            gr [0].add( new Edge ( 0 , 1 ) ) ;
            gr [1].add( new Edge ( 1 , 0 ) ) ;
            gr [1].add( new Edge ( 1 , 2 ) ) ;
    
            gr [ 2 ] .add ( new Edge ( 2 , 3 ) ) ;
            gr [ 2 ] .add ( new Edge ( 2 , 5 ) ) ;
            gr [ 2 ] .add ( new Edge ( 2 , 1 ) ) ;
            gr [ 3 ] .add ( new Edge ( 3 , 0 ) ) ;
            gr [ 3 ] .add ( new Edge ( 3 , 2 ) ) ;
            gr [ 3 ] .add ( new Edge ( 3 , 4 ) ) ;
    
            
            gr [ 4 ] .add ( new Edge ( 4 , 3  ) ) ;
            gr [ 4 ] .add ( new Edge ( 4 , 5  ) ) ;
            gr [ 4 ] .add ( new Edge ( 4 , 6  ) ) ;
            gr [ 5 ] .add ( new Edge ( 5 , 4  ) ) ;
            gr [ 5 ] .add ( new Edge ( 5 , 2  ) ) ;
            gr [ 5 ] .add ( new Edge ( 5 , 6  ) ) ;
            gr [ 6 ] .add ( new Edge ( 6 , 5  ) ) ;
            gr [ 6 ] .add ( new Edge ( 6 , 4  ) ) ;

        boolean visi[] = new boolean[vrtx];
        int ct =0;
        getAllPaths(gr,0,vrtx-1,visi,""+0,ct);
    }

    private static void getAllPaths(ArrayList<Edge>[] gr, int src, int dest, boolean[] visi,String psf,int ct) {
        if(ct==6)
        {
            System.out.println(psf);
            return;
        }
        visi[src]=true;
        ct++;
        for(Edge e:gr[src])
        {
            if(visi[e.nbr] == false)
            {
                getAllPaths(gr, e.nbr, dest, visi, psf+"->"+e.nbr,ct);
            }
        }
        visi[src] = false;

    }

}
