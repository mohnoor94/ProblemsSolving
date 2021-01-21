"""
    Mark and Toys Problem

    Full Documentation:
    https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
"""


def maximum_toys(prices, k):
    """
    Time: O(n log n)
    Space: O(n)

    n: # of prices
    """
    if k < len(prices):
        return len(prices)

    sorted_prices = sorted(prices)
    max_toys = 0
    price = 0

    while max_toys < len(sorted_prices) and price + sorted_prices[max_toys] < k:
        price += sorted_prices[max_toys]
        max_toys += 1

    return max_toys


if __name__ == '__main__':
    print(maximum_toys([1, 12, 5, 111, 200, 1000, 10], 50))
    # All hackerrank test cases passed.
