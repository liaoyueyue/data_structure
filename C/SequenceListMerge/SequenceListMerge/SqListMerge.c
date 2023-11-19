//顺序表的合并

#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <malloc.h>

#define LENGTHMAX 50

//定义线性表结构
typedef struct SeqList {
	int* elem;
	int length;
}SeqList;

//初始化结构体，为线性表分配存储空间
void InitSeqlist(SeqList *L) {
	L->elem = (int*)malloc(LENGTHMAX * sizeof(int));
	L->length = 0;
}

//定义输入数据元素函数
void InputSeqListLength(SeqList *L) {
	int len = 0;
	printf("输入顺序表的长度：");
	scanf("%d", &len);
	printf("输入顺序表的元素：");
	for (int i = 0; i < len; i++) {
		scanf("%d", &L->elem[i]);
		L->length++;
	}
}

//定义获取线性表长度函数
int getSeqListLength(SeqList *L) {
	return L->length;
}

//打印线性表中元素
void printSeqList(SeqList *L) {
	printf("[");
	for (int i = 0; i < L->length; i++) {
		if (i != L->length - 1) {
			printf("%d, ", L->elem[i]);
		}
		else {
			printf("%d", L->elem[i]);
		}
		
	}
	printf("]\n");
}

//合并顺序表函数
void MergeSeqList(SeqList *L1, SeqList *L2, SeqList *L3) {
	int i=0;
	int j=0;
	int k=0;
	while (i < L1->length && j < L2->length) {
		if (L1->elem[i] < L2->elem[j]) {
			L3->elem[k++] = L1->elem[i++];
			L3->length++;
		}
		else {
			L3->elem[k++] = L2->elem[j++];
			L3->length++;
		}
	}
	//当L2已经存完
	while (i < L1->length) {
		L3->elem[k++] = L1->elem[i++];
		L3->length++;
	}
	//当L1已经存完
	while (j < L2->length) {
		L3->elem[k++] = L2->elem[j++];
		L3->length++;
	}
}


int Menu() {
	printf("********* please choose **********\n");
	printf("**********************************\n");
	printf("******* 1、mergeSeqList **********\n");
	printf("******* 0、exit         **********\n");
	printf("**********************************\n");
	int choose = 0;
	scanf("%d", &choose);
	return choose;
}


int main() {
	int choose = Menu();
	switch (choose) {
	case 1:
		printf("使用顺序表合并\n");
		//创建顺序表
		SeqList L1;
		SeqList L2;
		SeqList L3;
		//初始化顺序表L1, L2
		InitSeqlist(&L1);
		InitSeqlist(&L2);
		//输入顺序表数据L1, L2
		printf("开始初始化第一个顺序表：\n");
		InputSeqListLength(&L1);
		printf("开始初始化第二个顺序表：\n");
		InputSeqListLength(&L2);
		//打印未合并前顺序表L1, L2
		printf("未合并前顺序表:\n");
		printSeqList(&L1);
		printSeqList(&L2);
		//初始化顺序表L3，合并顺序表L1，L2
		InitSeqlist(&L3);
		MergeSeqList(&L1, &L2, &L3);
		//打印顺序表L3
		printf("合并后顺序表:\n");
		printSeqList(&L3);
		break;
	case 0:
		printf("退出程序\n");
		break;
	default:
		printf("输入错误\n");
		break;
	}
	return 0;
}
