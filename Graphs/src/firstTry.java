import javax.swing.JFrame;

import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Schema;
import prefuse.demos.GraphView;
import prefuse.util.ui.UILib;


public class firstTry {
	public static void main(String args[])throws Exception {
        UILib.setPlatformLookAndFeel();
        
        // create graphview
        String datafile = null;
        String label = "label";
        if ( args.length > 1 ) {
            datafile = args[0];
            label = args[1];
        }
        System.out.println(datafile);
        
        JFrame frame = GraphView.demo(createGraph(), label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static Graph createGraph() {
        Graph g = new Graph();
        g.getNodeTable().addColumns(LABEL_SCHEMA);
        
        int totalNodes = 9;
        
        Node[] nodes = new Node[totalNodes];
        for ( int i = 0; i < totalNodes; ++i ) {
            nodes[i] = g.addNode();
            nodes[i].setString("label", String.valueOf(i));
            
//            if ( i >= n )
//                g.addEdge(nodes[i-n], nodes[i]);
//            if ( i % n != 0 )
//                g.addEdge(nodes[i-1], nodes[i]);
        }
        g.addEdge(nodes[0], nodes[1]);
        g.addEdge(nodes[1], nodes[2]);
        g.addEdge(nodes[2], nodes[3]);
        g.addEdge(nodes[3], nodes[4]);
        g.addEdge(nodes[4], nodes[5]);
        g.addEdge(nodes[5], nodes[6]);
        g.addEdge(nodes[6], nodes[7]);
        g.addEdge(nodes[7], nodes[8]);
        g.addEdge(nodes[6], nodes[8]);
        g.addEdge(nodes[2], nodes[8]);
        g.addEdge(nodes[2], nodes[5]);
        g.addEdge(nodes[3], nodes[5]);
        g.addEdge(nodes[1], nodes[7]);
        g.addEdge(nodes[0], nodes[7]);
        return g;
	}
	
	public static final Schema LABEL_SCHEMA = new Schema();
    static {
        LABEL_SCHEMA.addColumn("label", String.class, "");
    }
}
