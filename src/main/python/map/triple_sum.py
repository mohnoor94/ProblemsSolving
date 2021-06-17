"""
Given 3 arrays a, b, c of different sizes, find the number of f distinct triplets (p, q, r) where p is an element in a,
written as p in a, q in b, and r in c, satisfying the criteria: p <= q and q >= r.

For example, given:
    a = [3, 5, 7],
    b = [3, 6],
    c = [4, 6, 9]
we find four distinct triplets:
    (3, 6, 4),
    (3, 6, 6),
    (5, 6, 4),
    (5, 6, 6)

https://www.hackerrank.com/challenges/triple-sum/
"""


def triplets(a, b, c):
    """
    Time: O(n)
    Space: O(n lg n), for sorting
    -
    n = a_len + b_len + c_len
    """
    a = list(sorted(set(a)))
    b = list(sorted(set(b)))
    c = list(sorted(set(c)))

    ai = bi = ci = 0
    a_len, c_len = len(a), len(c)
    answer = 0

    while bi < len(b):
        while ai < a_len and a[ai] <= b[bi]:
            ai += 1
        while ci < c_len and b[bi] >= c[ci]:
            ci += 1

        answer += ai * ci
        bi += 1

    return answer


if __name__ == '__main__':
    # light testing, tested on hackerrank.
    print(triplets([1, 3, 5], [2, 4], [1, 2, 3]) == 8)
    print(triplets([1, 4, 5], [2, 3, 3], [1, 2, 3]) == 5)
    print(triplets([1, 3, 5, 7], [5, 7, 9], [7, 9, 11, 13]) == 12)
