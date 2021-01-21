"""
    Sherlock and Anagrams Problem

    Full Documentation:
    https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
"""

cache = {}


def are_anagrams(s1, s2):
    if f'{s1}+{s2}' in cache:
        return cache[f'{s1}+{s2}']
    if f'{s2}+{s1}' in cache:
        return cache[f'{s2}+{s1}']

    if len(s1) == len(s2) == 1:
        return s1 == s2

    if sorted(s1) == sorted(s2):
        cache[f'{s1}+{s2}'] = True
        return True

    cache[f'{s2}+{s1}'] = False
    return False


def sherlock_and_anagrams2(s):
    anagrams_count = 0
    for window in range(1, len(s)):
        for start in range(len(s)):
            s1 = s[start: start + window]
            for offset in range(start + 1, len(s) - window + 1):
                s2 = s[offset: window + offset]
                if are_anagrams(s1, s2):
                    anagrams_count += 1

    return anagrams_count


def sherlock_and_anagrams(s):
    signatures = {}
    zero_index = ord('a')

    for start in range(len(s)):
        for finish in range(start, len(s)):
            signature = [0] * 26  # 26 English letters
            for letter in s[start: finish + 1]:
                signature[ord(letter) - zero_index] += 1
            signature = tuple(signature)
            signatures[signature] = signatures.get(signature, 0) + 1

    return sum([c * (c - 1) / 2 for c in signatures.values()])


if __name__ == '__main__':
    print(sherlock_and_anagrams("abba"))
