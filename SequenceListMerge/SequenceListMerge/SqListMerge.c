#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <malloc.h>

#define LISTSIZEMAX 50

//定义线性表结构
typedef struct SeqList {
	int* elem;
	int length;
	int listsize;
}SeqList;

//初始化结构体，为线性表分配存储空间
void InitSqlist(SeqList *L) {
	L->elem = (int*)malloc(LISTSIZEMAX * sizeof(int));
	L->length = 0;
	L->listsize = LISTSIZEMAX;
}

//定义输入数据元素函数
void Input(SeqList *L, int count) {
	for (int i = 0; i < count; count++) {
		scanf("%d", L->elem[i]);
		L->length++;
	}
}

//定义获取线性表长度函数
int getSqListLength(SeqList *L) {
	return L->length;
}

//打印线性表中元素
void printSqList(SeqList *L) {
	for (int i = 0; i < L->length; i++) {
		printf("%d ", L->elem[i]);
	}
	printf("\n");
}

//合并函数
void MergeSqList(SeqList *L1, SeqList *L2, SeqList *L3) {

}



int main() {
	SeqList L1;
	SeqList L2;
	SeqList L3;
	InitSqlist

	return 0;
}
