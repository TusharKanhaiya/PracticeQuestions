import java.util.*;


public class getConnectedComponents {

    

   
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

        gr[0].add(new Edge(0,1));
        gr[1].add(new Edge(1,0));
        gr[2].add(new Edge(2,3));
        gr[3].add(new Edge(3,2));
        gr[4].add(new Edge(4,5));
        gr[4].add(new Edge(4,6));
        gr[5].add(new Edge(5,6));
        gr[5].add(new Edge(5,4));
        gr[6].add(new Edge(6,5));
        gr[6].add(new Edge(6,4));

        boolean visi[] = new boolean[vrtx];

        ArrayList<ArrayList<Integer>> lls = new ArrayList<>();
        for(int i=0;i<vrtx;i++)
        {
            if(visi[i]==false)
            {
                ArrayList<Integer> ls = new ArrayList<>();
                connected(gr,i,visi,ls);
                lls.add(ls);
            }
        }
        for(ArrayList<Integer> l : lls)
            System.out.println(l);

    }

    private static void connected(ArrayList<getConnectedComponents.Edge>[] gr, int i, boolean[] visi, ArrayList<Integer> ls) {

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
