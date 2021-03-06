import static org.junit.Assert.fail;

import java.util.*;


public class getConnectedComponents {

    static class Pair {
        int v;
        ArrayList<Integer> psf;
        // int wt;
        
        Pair(int v,ArrayList<Integer> psf)
        {
            this.v = v;
            this.psf = psf;
            // this.wt = wt;
        }

        public void ToString()
        {
            System.out.println("v "+this.v+" ->psf "+this.psf);
        }
    }
    

   
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
            // gr [ 2 ] .add ( new Edge ( 2 , 5 ) ) ;
            gr [ 2 ] .add ( new Edge ( 2 , 1 ) ) ;
            gr [ 3 ] .add ( new Edge ( 3 , 0 ) ) ;
            gr [ 3 ] .add ( new Edge ( 3 , 2 ) ) ;
            gr [ 3 ] .add ( new Edge ( 3 , 4 ) ) ;
    
            
            gr [ 4 ] .add ( new Edge ( 4 , 3  ) ) ;
            gr [ 4 ] .add ( new Edge ( 4 , 5  ) ) ;
            gr [ 4 ] .add ( new Edge ( 4 , 6  ) ) ;
            gr [ 5 ] .add ( new Edge ( 5 , 4  ) ) ;
            // gr [ 5 ] .add ( new Edge ( 5 , 2  ) ) ;
            gr [ 5 ] .add ( new Edge ( 5 , 6  ) ) ;
            gr [ 6 ] .add ( new Edge ( 6 , 5  ) ) ;
            gr [ 6 ] .add ( new Edge ( 6 , 4  ) ) ;

        boolean visi[] = new boolean[vrtx];

        ArrayDeque<Pair> dq = new ArrayDeque<>();
        ArrayList<Integer> pls = new ArrayList<>();
        pls.add(2);
        dq.add(new Pair(2,pls));
        
        while(!dq.isEmpty())
        {
            Pair p = dq.pollFirst();
        
            System.out.println(p.psf);
            for(Edge e:gr[p.v])
            {
                if(!(p.psf).contains(e.nbr))
                {
                    ArrayList<Integer> pls1 = new ArrayList<>();
                    pls1.addAll(p.psf);
                    pls1.add(e.nbr);
                    dq.add(new Pair(e.nbr,pls1));
                }
                else
                {
                    if(p.psf.size()>=3 && e.nbr==p.psf.get(0))
                        System.out.println(p.psf+" contains cycle");
                }
            }

        }




        // int ct =0;
        // getAllPaths(gr,0,vrtx-1,visi,""+0,ct);

        // ArrayList<ArrayList<Integer>> lls = new ArrayList<>();
        // for(int i=0;i<vrtx;i++)
        // {
        //     if(visi[i]==false)
        //     {
        //         ArrayList<Integer> ls = new ArrayList<>();
        //         connected(gr,i,visi,ls);
        //         lls.add(ls);
        //     }
        // }
        // for(ArrayList<Integer> l : lls)
        //     System.out.println(l);

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

    private static void connected(ArrayList<Edge>[] gr, int i, boolean[] visi, ArrayList<Integer> ls) {

        visi[i] = true;
        ls.add(i);
        for(Edge e:gr[i])
        {
            if(visi[e.nbr]==false)
            {   
                connected(gr, e.nbr, visi, ls);
            }
        }

    }


}
