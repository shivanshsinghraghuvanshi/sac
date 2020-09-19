package com.ilab.safety.sac.revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSerchTester {

	public static void BFS(Vertex root) {

		Queue<Vertex> queue = new LinkedList<>();
		root.isVisited = true;

		queue.add(root);

		while (!queue.isEmpty()) {
			Vertex curr = queue.remove();
			for (Vertex v : curr.adjancyList) {
				if (!v.isVisited) {
					v.isVisited = true;
					queue.add(v);
				}
			}
		}
	}

	public static void DFS(Vertex root) {
		root.isVisited = true;
		for (Vertex v : root.adjancyList) {
			if (!v.isVisited) {
				DFS(v);
			}
		}
	}
}

class Vertex {
	public String label;
	public boolean isVisited;
	public List<Vertex> adjancyList;

	public Vertex(String name) {
		this.label = name;
		adjancyList = new ArrayList<>();
	}

}
