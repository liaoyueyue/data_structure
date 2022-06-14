#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>

void QuickSort(int arr[], int L, int R)
{
	if (L >= R)
	{
		return;
	}
	int left = L, right = R;
	int pivot = arr[left];
	while (left < right)
	{
		while (left < right && arr[right] >= pivot)
		{
			right--;
		}
		if (left < right)
		{
			arr[left] = arr[right];
		}
		while (left < right && arr[left] <= pivot)
		{
			left++;
		}
		if (left < right)
		{
			arr[right] = arr[left];
		}
		if (left >= right)
		{
			arr[left] = pivot;
		}
	}
	QuickSort(arr, L, right - 1);
	QuickSort(arr, right+1, R);
}

int main()
{
	int arr[] = { 2, 4, 6, 8, 10, 1, 3, 5, 7, 9 };
	int sz = sizeof(arr) / sizeof(arr[0]);
	int L = 0;
	int R = sz-1;
	QuickSort(arr, L, R);
	for (int i = 0; i < sz; i++)
	{
		printf("%d ", arr[i]);
	}
	return 0;
}