"""
Writing programming interview questions hasn't made me rich yet ... so I might give up and start trading Apple stocks
all day instead.

First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.

So I grabbed Apple's stock prices from yesterday and put them in a list called stock_prices, where:

The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
The values are the price (in US dollars) of one share of Apple stock at that time.
So if the stock cost $500 at 10:30am, that means stock_prices[60] = 500.

Write an efficient function that takes stock_prices and returns the best profit I could have made from one purchase and
one sale of one share of Apple stock yesterday.

For example:

  stock_prices = [10, 7, 5, 8, 11, 9]
  get_max_profit(stock_prices) # Returns 6 (buying for $5 and selling for $11)

No "shorting"—you need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute
has to pass.

Problem Statement: https://www.interviewcake.com/question/python3/stock-price
"""


def get_max_profit1(stock_prices):
    """
    - Time: O(n^2)
    - Space: O(1)
    * n is len(stock_prices)
    """
    length = len(stock_prices)
    assert length > 1, 'Getting a profit requires at least 2 prices'

    profit = stock_prices[1] - stock_prices[0]
    length = len(stock_prices)

    for i in range(length):
        for j in range(i + 1, length):
            if stock_prices[j] - stock_prices[i] > profit:
                profit = stock_prices[j] - stock_prices[i]

    return profit


def get_max_profit2(stock_prices):
    """
    - Time: O(n)
    - Space: O(1)
    * n is len(stock_prices)
    """
    length = len(stock_prices)
    assert length > 1, 'Getting a profit requires at least 2 prices'

    min_price = stock_prices[0]
    max_profit = stock_prices[1] - stock_prices[0]

    for i in range(1, length):
        price = stock_prices[i]
        profit = price - min_price
        max_profit = max(profit, max_profit)
        min_price = min(price, min_price)

    return max_profit


if __name__ == '__main__':
    print(get_max_profit1([10, 7, 5, 8, 11, 9]))
    print(get_max_profit1([10, 7, 5, 8, 11, 9, 20, 3, 10]))
    print(get_max_profit1([10, 8, 6, 3, 2, 1]))

    print("===")

    print(get_max_profit2([10, 7, 5, 8, 11, 9]))
    print(get_max_profit2([10, 7, 5, 8, 11, 9, 20, 3, 10]))
    print(get_max_profit2([10, 8, 6, 3, 2, 1]))
