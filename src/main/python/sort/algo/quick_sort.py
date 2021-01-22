def quicksort(values):
    def qsort(start, end):
        if start >= end:
            return

        pivot = values[(start + end) // 2]
        index = partition(start, end, pivot)
        qsort(start, index - 1)
        qsort(index, end)

    def partition(start, end, pivot):
        while start <= end:
            while values[start] < pivot:
                start += 1

            while values[end] > pivot:
                end -= 1

            if start <= end:
                swap(start, end)
                start += 1
                end -= 1

        return start

    def swap(first, second):
        temp = values[first]
        values[first] = values[second]
        values[second] = temp

    qsort(0, len(values) - 1)


if __name__ == '__main__':
    values1 = [9, 7, 16, 20, 13, 100, -5, 34, 2, 27]
    print(values1)
    quicksort(values1)
    print(values1)
