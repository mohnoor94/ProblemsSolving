import random


class RandomizedSet:
    """
    Implement the RandomizedSet class:

    - RandomizedSet() Initializes the RandomizedSet object.
    - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
    false otherwise.
    - bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false
    otherwise.
    - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
    element exists when this method is called). Each element must have the same probability of being returned.

    - You must implement the functions of the class such that each function works in average O(1) time complexity.

    ***
    https://leetcode.com/problems/insert-delete-getrandom-o1/
    """

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.numbers_list = []
        self.numbers_dict = {}

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.numbers_dict:
            return False

        self.numbers_dict[val] = len(self.numbers_list)
        self.numbers_list.append(val)

        return True

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.numbers_dict:
            return False

        index = self.numbers_dict[val]
        self.numbers_list[index] = self.numbers_list[len(self.numbers_list) - 1]
        self.numbers_dict[self.numbers_list[index]] = index

        del self.numbers_dict[val]
        self.numbers_list.pop()

        return True

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return self.numbers_list[random.randrange(len(self.numbers_list))]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
