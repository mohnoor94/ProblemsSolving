def number_of_ways(data):
    """
    *** 'Facebook' interview question ***
    Given a mapping between characters and numbers as:
        a : 1, b : 2, c : 3, d : 4, ..., y : 25, z : 26
    you can encode any string like:
        - "ab"  ==> "12"
        - "car" ==> "3119"
        - "l"   ==> "12"
    noticing that one character could be encoded into 1 or 2 digits, multiple strings could be encoded to the same code,
    like "ab" and "l" examples above.

    The problem: given the encoded word, return the number of possibilities that this word could be decoded to.
    Examples:
        - "12" ==> 2 ("ab", "l")
        - "01" ==> 0 (no word could be encoded to this form)

    More details: https://youtu.be/qli-JCrSwuk
    """
    memo = [0] * (len(data) + 1)
    return helper(data, len(data), memo)


def helper(data, k, memo):
    if k == 0:
        return 1
    i = len(data) - k
    if data[i] == '0':
        return 0
    if memo[k] != 0:
        return memo[k]

    result = helper(data, k - 1, memo)
    if k >= 2 and data[i:i + 2] <= "26":
        result += helper(data, k - 2, memo)
    memo[k] = result

    return result


if __name__ == '__main__':
    print(number_of_ways("12"))
    print(number_of_ways("01"))
    print(number_of_ways("011"))
    print(number_of_ways("3"))
    print(number_of_ways(""))
    print(number_of_ways("12345"))
    print(number_of_ways("111111"))
