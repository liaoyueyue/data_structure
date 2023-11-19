#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>

int BinarySearch(int arr[], int high, int key)
{
    int low = 0;//数组最小索引值
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] < key)
        {
            low = mid + 1;
        }
        else if (arr[mid] > key)
        {
            high = mid - 1;
        }
        else
        {
            return mid;
        }
    }
    return -1;
    //low>high的情况，这种情况下key的值大于arr中最大的元素值或者key的值小于arr中最小的元素值
}

int main()
{
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int sz = sizeof(arr) / sizeof(arr[0]);
    int high = sz - 1;
    int key = 6;
    int ret = BinarySearch(arr, high, key);
    printf("下标为%d", ret);
    return 0;
}