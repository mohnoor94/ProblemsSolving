def find_longest_consecutive_characters(seq):
    """
    Problem statement: https://youtu.be/qRNB8CV3_LU
    """
    if len(seq) < 1:
        return '', 1

    prv = seq[0]
    answer = (prv, 1)
    count = 1

    seq = seq[1:]
    for c in seq:
        if c == prv:
            count += 1
        else:
            count = 1
        if count > answer[1]:
            answer = (prv, count)
        prv = c

    return answer


if __name__ == '__main__':
    print(find_longest_consecutive_characters("AABCDDBBBEA"))
    print(find_longest_consecutive_characters("abcccccdefgg"))
    print(find_longest_consecutive_characters(""))
    print(find_longest_consecutive_characters("a"))
    print(find_longest_consecutive_characters("aa"))
    print(find_longest_consecutive_characters("abc"))
    print(find_longest_consecutive_characters("abcccddddd"))
