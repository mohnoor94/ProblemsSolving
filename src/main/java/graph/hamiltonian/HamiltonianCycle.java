package graph.hamiltonian;

import graph.implementation.UndirectedAdjacencyMatrixGraph;

class HamiltonianCycle {

    private int numberOfVertices;
    private int[] hamiltonianPath;
    private UndirectedAdjacencyMatrixGraph graph;

    HamiltonianCycle(UndirectedAdjacencyMatrixGraph graph) {
        int size = graph.size();
        this.numberOfVertices = size;
        this.hamiltonianPath = new int[size];
        this.graph = graph;
    }

    void solve() {
        this.hamiltonianPath[0] = 0;

        if (findFeasibleSolution(1)) printHamiltonianCycle();
        else System.out.println("No feasible solution...");
    }

    private void printHamiltonianCycle() {
        for (int e : hamiltonianPath) {
            System.out.print(e + ", ");
        }
        System.out.println(hamiltonianPath[0]);
    }

    private boolean findFeasibleSolution(int position) {
        if (position == numberOfVertices) return graph.isConnected(hamiltonianPath[position - 1], hamiltonianPath[0]);

        for (int vi = 1; vi < numberOfVertices; vi++) {
            if (isFeasible(vi, position)) {
                hamiltonianPath[position] = vi;

                if (findFeasibleSolution(position + 1)) return true;
            }
        }

        return false;
    }

    private boolean isFeasible(int vertexIndex, int position) {
        if (!graph.isConnected(hamiltonianPath[position - 1], vertexIndex)) return false; // not connected
        for (int i = 0; i < position; i++) if (hamiltonianPath[i] == vertexIndex) return false; // already visited

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        var graph1 = new UndirectedAdjacencyMatrixGraph(3);
        graph1.connect(0, 1);
        graph1.connect(1, 2);

        var cycle1 = new HamiltonianCycle(graph1);
        cycle1.solve();

        boolean[][] matrix = {
                {false, true, true, true, false, false},
                {true, false, true, false, true, false},
                {true, true, true, true, false, true},
                {true, false, true, false, false, true},
                {false, true, false, false, false, true},
                {false, true, true, true, true, true}
        };

        var cycle2 = new HamiltonianCycle(new UndirectedAdjacencyMatrixGraph(matrix));
        cycle2.solve();
    }
}
