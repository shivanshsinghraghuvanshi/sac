package com.ilab.safety.sac.sample.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;

public class BFS {
	public static void main(String[] args) {

		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");

		a.addNeighbour(b);
		a.addNeighbour(f);
		a.addNeighbour(g);

		b.addNeighbour(a);
		b.addNeighbour(c);
		b.addNeighbour(d);

		c.addNeighbour(b);

		d.addNeighbour(b);
		d.addNeighbour(e);

		f.addNeighbour(a);

		g.addNeighbour(a);
		g.addNeighbour(h);

		h.addNeighbour(g);
		DFSTraverse(a);
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		// find all edges of graph
		int nr = grid.length;
		int nc = grid[0].length;
		int num_islands = 0;
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					++num_islands;
					dfs(grid, r, c);
				}
			}
		}

	}

	public static void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;
		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}

	}

	public static void BFSTraverse(Vertex root) {
		// LinkedList impelment the Queue Abstraction Datatype
		Queue<Vertex> queue = new LinkedList<>();
		root.setVisited(true);
		queue.add(root);
		while (!queue.isEmpty()) {
			// remove the first item
			Vertex current = queue.remove();
			System.out.println("Actual visited vertex: " + current);
			// loop through all the adancy list and add it to queue

			for (Vertex x : current.getAdjacencyList()) {
				if (!x.isVisited()) {
					x.setVisited(true);
					queue.add(x);
				}
			}
		}
	}

	public static void DFSTraverse(Vertex v) {
		// v.setVisited(true);
		System.out.println(v);
		for (Vertex x : v.getAdjacencyList()) {
			if (!x.isVisited()) {
				v.setVisited(true);
				DFSTraverse(x);
			}
		}
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rc = grid.length;
		int cc = grid[0].length;
		int islandCount = 0;

		for (int i = 0; i < rc; i++) {
			for (int j = 0; j < cc; j++) {
				if (grid[i][j] == '1') {
					islandCount++;
					DFS(grid, i, j);
				}
			}
		}
		return islandCount;
	}

	public static void DFS(char[][] grid, int rc, int cc) {

		int nr = grid.length;
		int nc = grid[0].length;

		if (rc < 0 || cc < 0 || rc >= nr || cc >= nc || grid[rc][cc] == '0') {
			return;
		}
		grid[rc][cc] = '0';
		DFS(grid, rc - 1, cc);
		DFS(grid, rc + 1, cc);
		DFS(grid, rc, cc - 1);
		DFS(grid, rc, cc + 1);
	}

	public int orangesRotting(int[][] grid) {
		Queue<SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
		int nr = grid.length;
		int nc = grid[0].length;
		int freshOranges = 0;
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (grid[r][c] == 2) {
					queue.add(new SimpleEntry(r, c));
				}
			}
		}
	}
}

class Vertex {
	private int name;
	private boolean visited;
	private List<Vertex> adjacencyList;

	public Vertex(int name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}

	public void addNeighbour(Vertex v) {
		this.adjacencyList.add(v);
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<Vertex> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

}

class LRUCache extends LinkedHashMap<Integer, Integer> {

	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}