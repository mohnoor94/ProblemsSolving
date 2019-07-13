package graph.hamiltonian;

/*
    - Hamiltonian Path in an undirected graph is a path that visits every node exactly once
    - Hamiltonian Cycle is a Hamiltonian path where the first and the last node are the same vertex
        --> (Start Point = End Point)


    - Example: In the graph:

        a ---- b
        /      /
        d ---- c

    Valid Hamiltonian Paths:
        - a b c d
        - b c d a
        - d c b a
        - c d a b
        - ...

    Valid Hamiltonian Cycles:
        - a b c d a
        - b c d a b
        - d c b a d
        - c d a b c
        - ...


    - Determining whether such paths and cycles exists in the graph is the Hamiltonian Path problem
    - This is an NP-Complete problem!
    - Dirac-principle: a simple graph with N vertices is hamiltonian if every vertex has degree N/2 or greater
        - degree is the number of edges of a vertex
    - Finding Hamiltonian path is NP-Complete problem, but we can decide whether such path exists in linear time
    complexity with topological ordering

    - source: https://www.udemy.com/algorithmic-problems-in-java/
 */