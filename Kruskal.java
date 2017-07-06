import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* Kruskal class - contains an Edge class and the main function*/
public class Kruskal {

	/*
	 * kruskal function - Takes in a List of edges and returns the list of
	 * kruskal edges - the MST.
	 */
	public static List<Edge> kruskal(List<Edge> edges, int numVertices) {

		int uset, vset;
		int vertex1, vertex2;
		String source, destination;

		DisjointSets ds = new DisjointSets(numVertices);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(edges);
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();

		/* Maintaining a separate Priority Queue of distances */
		Iterator<Edge> itr = pq.iterator();
		while (itr.hasNext()) {
			e2 = itr.next();
			pq2.add(e2.distance);
		}

		List<Edge> mst = new ArrayList<Edge>();

		while (mst.size() != numVertices - 1) {

			//Removing the smallest distance from the priority queue//
			low = pq2.remove();

			//Finding the edge corresponding to the smallest distance//
			e2 = findminEdge(pq, low);
			pq.remove(e2);

			source = e2.source;
			destination = e2.destination;

			vertex1 = e2.vertex(source);
			vertex2 = e2.vertex(destination);

			uset = ds.find(vertex1);
			vset = ds.find(vertex2);
			if (uset != vset) {
				// Accept the edge
				mst.add(e2);
				ds.union(uset, vset);
			}
		}
		return mst;
	}

	/*
	 * kruskalsum - finds the sum of all the edges in the List of kruskal edges,
	 * that is, the MST.
	 */
	public static int kruskalsum(List<Edge> edges) {
		int sum = 0;
		Iterator<Edge> itr = edges.iterator();
		while (itr.hasNext()) {
			e2 = itr.next();
			sum += e2.distance;
		}
		return sum;
	}

	/* findminEdge - Find the edge corresponding to the minimum distance */
	public static Edge findminEdge(PriorityQueue<Edge> pq, int low) {
		Iterator<Edge> itr = pq.iterator();
		while (itr.hasNext()) {
			e4 = itr.next();
			if (e4.distance == low) {
				return e4;
			}
		}
		return e4;
	}

	/* Class edge - contains source, destination and distance */
	public static class Edge implements Comparable<Edge> {
		public Edge(String a, String b, int c) {
			source = a;
			destination = b;
			distance = c;
		}

		String source, destination;
		int distance;

		/* vertex - Returns the vertex of the city corresponding to it */
		public int vertex(String v) {
			if (v.equals("Abilene"))
				return 0;
			else if (v.equals("Amarillo"))
				return 1;
			else if (v.equals("Austin"))
				return 2;
			else if (v.equals("Brownsville"))
				return 3;
			else if (v.equals("Bryan"))
				return 4;
			else if (v.equals("Corpus Christi"))
				return 5;
			else if (v.equals("Dallas"))
				return 6;
			else if (v.equals("El Paso"))
				return 7;
			else if (v.equals("Houston"))
				return 8;
			else if (v.equals("Killeen"))
				return 9;
			else if (v.equals("Laredo"))
				return 10;
			else if (v.equals("Longview"))
				return 11;
			else if (v.equals("Lubbock"))
				return 12;
			else if (v.equals("McAllen"))
				return 13;
			else if (v.equals("Midland"))
				return 14;
			else if (v.equals("San Angelo"))
				return 15;
			else if (v.equals("San Antonio"))
				return 16;
			else if (v.equals("Texarkana"))
				return 17;
			else if (v.equals("Tyler"))
				return 18;
			else if (v.equals("Waco"))
				return 19;
			else if (v.equals("Wichita Falls"))
				return 20;
			else
				return 0;
		}

		// Dummy compareTo to make PriorityQueue(Edges) comparable.
		@Override
		public int compareTo(Edge o) {
			return 0;
		}
	}

	public static Edge e2, e4, e6;
	public static int low;

	/* printEdges - prints the Edges */
	public static void printEdges(List<Edge> edge) {
		for (Edge e6 : edge) {
			System.out.println(e6.source + " -> " + e6.destination + " = "
					+ e6.distance);
		}
	}

	/*
	 * Main function - creates the graph of all the edges and vertices and calls
	 * the kruskal algorithm
	 */
	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<Edge>();
		List<Edge> kruskaledges = new ArrayList<Edge>();
		Edge edge;
		int sum;

		// Adding the routes - source + destination + distance (Edge)

		// Abilene
		edge = new Edge("Abilene", "Dallas", 184);
		edges.add(edge);
		edge = new Edge("Abilene", "San Angelo", 90);
		edges.add(edge);
		edge = new Edge("Abilene", "Waco", 184);
		edges.add(edge);
		edge = new Edge("Abilene", "Wichita Falls", 142);
		edges.add(edge);

		// Amarillo
		edge = new Edge("Amarillo", "El Paso", 440);
		edges.add(edge);
		edge = new Edge("Amarillo", "Lubbock", 123);
		edges.add(edge);
		edge = new Edge("Amarillo", "Wichita Falls", 225);
		edges.add(edge);

		// Austin
		edge = new Edge("Austin", "Bryan", 103);
		edges.add(edge);
		edge = new Edge("Austin", "Killeen", 68);
		edges.add(edge);
		edge = new Edge("Austin", "San Antonio", 80);
		edges.add(edge);

		// Brownsville
		edge = new Edge("Brownsville", "Corpus Christi", 161);
		edges.add(edge);
		edge = new Edge("Brownsville", "McAllen", 60);
		edges.add(edge);

		// Bryan
		edge = new Edge("Bryan", "Houston", 100);
		edges.add(edge);
		edge = new Edge("Bryan", "Tyler", 146);
		edges.add(edge);
		edge = new Edge("Bryan", "Waco", 86);
		edges.add(edge);

		// Corpus Christi
		edge = new Edge("Corpus Christi", "Houston", 217);
		edges.add(edge);
		edge = new Edge("Corpus Christi", "Laredo", 143);
		edges.add(edge);
		edge = new Edge("Corpus Christi", "McAllen", 154);
		edges.add(edge);
		edge = new Edge("Corpus Christi", "San Antonio", 143);
		edges.add(edge);

		// Dallas
		edge = new Edge("Dallas", "Longview", 126);
		edges.add(edge);
		edge = new Edge("Dallas", "Texarkana", 177);
		edges.add(edge);
		edge = new Edge("Dallas", "Tyler", 95);
		edges.add(edge);
		edge = new Edge("Dallas", "Wichita Falls", 142);
		edges.add(edge);

		// El Paso
		edge = new Edge("El Paso", "Laredo", 606);
		edges.add(edge);
		edge = new Edge("El Paso", "Midland", 305);
		edges.add(edge);

		// Houston
		edge = new Edge("Houston", "San Antonio", 197);
		edges.add(edge);
		edge = new Edge("Houston", "Tyler", 199);
		edges.add(edge);

		// Killeen
		edge = new Edge("Killeen", "San Angelo", 184);
		edges.add(edge);
		edge = new Edge("Killeen", "Waco", 63);
		edges.add(edge);

		// Laredo
		edge = new Edge("Laredo", "McAllen", 144);
		edges.add(edge);
		edge = new Edge("Laredo", "Midland", 418);
		edges.add(edge);
		edge = new Edge("Laredo", "San Antonio", 156);
		edges.add(edge);

		// Longview
		edge = new Edge("Longview", "Texarkana", 90);
		edges.add(edge);
		edge = new Edge("Longview", "Tyler", 38);
		edges.add(edge);

		// Lubbock
		edge = new Edge("Lubbock", "Midland", 118);
		edges.add(edge);
		edge = new Edge("Lubbock", "Wichita Falls", 210);
		edges.add(edge);

		// Midland
		edge = new Edge("Midland", "San Angelo", 112);
		edges.add(edge);

		// San Angelo
		edge = new Edge("San Angelo", "San Antonio", 212);
		edges.add(edge);
		edge = new Edge("San Angelo", "Waco", 215);
		edges.add(edge);
		edge = new Edge("San Angelo", "Wichita Falls", 239);
		edges.add(edge);

		// Texarkana
		edge = new Edge("Texarkana", "Wichita Falls", 272);
		edges.add(edge);

		// Tyler
		edge = new Edge("Tyler", "Waco", 132);
		edges.add(edge);

		// Uncomment below to print all edges
		// System.out.println("Printing all the edges:");
		// printEdges(edges);
		// System.out.println(" ");

		kruskaledges = kruskal(edges, 21);

		System.out
				.println("After performing Kruskal's algorithm, the minimum spanning tree is:");

		printEdges(kruskaledges);

		sum = kruskalsum(kruskaledges);

		System.out.println(" ");
		System.out
				.println("The sum of the edges in the minimum spanning tree is: "
						+ sum);
	}
}
