"""
    Roads and Libraries Problem

    Full Documentation:
    https://www.hackerrank.com/challenges/torque-and-development/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
"""


def roads_and_libraries(n, c_lib, c_road, cities):
    if c_lib <= c_road:
        return n * c_lib

    cache = {i: i for i in range(1, n + 1)}
    groups = {i: {i} for i in range(1, n + 1)}

    for c1, c2 in cities:
        g1, g2 = cache[c1], cache[c2]

        if g1 != g2:
            groups[g1] = groups[g1].union(groups[g2])
            for c in groups[g2]:
                cache[c] = g1
            del groups[g2]

    return c_lib * len(groups) + c_road * sum([len(g) - 1 for g in groups.values()])


if __name__ == '__main__':
    print(roads_and_libraries(3, 2, 1, [[1, 2], [3, 1], [2, 3]]))
    # All test cases on hackerrank passed.
