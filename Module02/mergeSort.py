
#Function for merge operation
def merge(left_half, right_half):
    result_lst = []
    while len(left_half) != 0 and len(right_half) != 0:
        if left_half[0] < right_half[0]:
            result_lst.append(left_half[0])
            left_half.remove(left_half[0])
        else:
            result_lst.append(right_half[0])
            right_half.remove(right_half[0])

    result_lst += right_half if len(left_half) == 0 else left_half
    #print("Current result list value : ", result_lst)
    return result_lst

# Function for dividing an list and return final sorted list
def merge_sort(unsorted_list):
    if len(unsorted_list) <= 1:
        return unsorted_list

    # Find the middle point and divide it
    middle = len(unsorted_list) // 2
    left_list = unsorted_list[:middle]
    right_list = unsorted_list[middle:]

    left_list = merge_sort(left_list)
    right_list = merge_sort(right_list)
    return list(merge(left_list, right_list))


def main():
    lst = [8, 17, 3, 9]
    print("Initial Unsorted List:", lst)
    print("After Sorting:", merge_sort(lst))


if __name__ == "__main__":
    main()