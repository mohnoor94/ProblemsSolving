"""
Given a list of integers, find the highest product you can get from three of the integers.
The input list_of_ints will always have at least three integers.

***

https://www.interviewcake.com/question/python3/highest-product-of-3?course=fc1&section=greedy
"""

import unittest


def highest_product_of_3(ints):
    if len(ints) < 3:
        raise ValueError('Less than 3 items!')

    highest = max(ints[0], ints[1])
    lowest = min(ints[0], ints[1])

    highest_product_of_2 = ints[0] * ints[1]
    lowest_product_of_2 = ints[0] * ints[1]

    highest_product_of_3_ = ints[0] * ints[1] * ints[2]

    for num in ints[2:]:
        highest_product_of_3_ = max(highest_product_of_3_, num * highest_product_of_2, num * lowest_product_of_2)

        highest_product_of_2 = max(highest_product_of_2, num * highest, num * lowest)
        lowest_product_of_2 = min(lowest_product_of_2, num * highest, num * lowest)

        highest = max(highest, num)
        lowest = min(lowest, num)

    return highest_product_of_3_


class Test(unittest.TestCase):

    def test_short_list(self):
        actual = highest_product_of_3([1, 2, 3, 4])
        expected = 24
        self.assertEqual(actual, expected)

    def test_longer_list(self):
        actual = highest_product_of_3([6, 1, 3, 5, 7, 8, 2])
        expected = 336
        self.assertEqual(actual, expected)

    def test_list_has_one_negative(self):
        actual = highest_product_of_3([-5, 4, 8, 2, 3])
        expected = 96
        self.assertEqual(actual, expected)

    def test_list_has_two_negatives(self):
        actual = highest_product_of_3([-10, 1, 3, 2, -10])
        expected = 300
        self.assertEqual(actual, expected)

    def test_list_is_all_negatives(self):
        actual = highest_product_of_3([-5, -1, -3, -2])
        expected = -6
        self.assertEqual(actual, expected)

    def test_error_with_empty_list(self):
        with self.assertRaises(Exception):
            highest_product_of_3([])

    def test_error_with_one_number(self):
        with self.assertRaises(Exception):
            highest_product_of_3([1])

    def test_error_with_two_numbers(self):
        with self.assertRaises(Exception):
            highest_product_of_3([1, 1])


if __name__ == '__main__':
    unittest.main(verbosity=2)
