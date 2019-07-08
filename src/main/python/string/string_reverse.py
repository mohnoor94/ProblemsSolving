from typing import List


def reverse(s: str) -> str:
    """
    Reverse a string.
    - Time Complexity: O(len(s))
    - Space Complexity: O(len(s))

    :param s: a string
    :return: a reversed string
    """
    length = len(s)
    rlist: List[str] = [''] * length

    for i in range(length):
        rlist[length - i - 1] = s[i]

    return ''.join(rlist)


if __name__ == '__main__':
    print(reverse('hello'))
    print(reverse(''))
    print(reverse('X'))
