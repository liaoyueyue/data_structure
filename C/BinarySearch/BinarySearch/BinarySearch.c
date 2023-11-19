#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>

int BinarySearch(int arr[], int high, int key)
{
    int low = 0;//������С����ֵ
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
    //low>high����������������key��ֵ����arr������Ԫ��ֵ����key��ֵС��arr����С��Ԫ��ֵ
}

int main()
{
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int sz = sizeof(arr) / sizeof(arr[0]);
    int high = sz - 1;
    int key = 6;
    int ret = BinarySearch(arr, high, key);
    printf("�±�Ϊ%d", ret);
    return 0;
}