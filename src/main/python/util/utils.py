from typing import List, Tuple, TypeVar

T = TypeVar('T')


def test_all(test_cases: List[Tuple[str, T, T]]):
    all_passed = True

    for test_title, expected, actual in test_cases:
        if actual != expected:
            print(f"TEST FAILED -> '{test_title}':: actual: {actual} != expected: {expected}")
            all_passed = False

    return all_passed
