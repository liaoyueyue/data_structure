#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <malloc.h>

#define LISTSIZEMAX 50

//�������Ա�ṹ
typedef struct SeqList {
	int* elem;
	int length;
	int listsize;
}SeqList;

//��ʼ���ṹ�壬Ϊ���Ա����洢�ռ�
void InitSqlist(SeqList *L) {
	L->elem = (int*)malloc(LISTSIZEMAX * sizeof(int));
	L->length = 0;
	L->listsize = LISTSIZEMAX;
}

//������������Ԫ�غ���
void Input(SeqList *L, int count) {
	for (int i = 0; i < count; count++) {
		scanf("%d", L->elem[i]);
		L->length++;
	}
}

//�����ȡ���Ա��Ⱥ���
int getSqListLength(SeqList *L) {
	return L->length;
}

//��ӡ���Ա���Ԫ��
void printSqList(SeqList *L) {
	for (int i = 0; i < L->length; i++) {
		printf("%d ", L->elem[i]);
	}
	printf("\n");
}

//�ϲ�����
void MergeSqList(SeqList *L1, SeqList *L2, SeqList *L3) {

}



int main() {
	SeqList L1;
	SeqList L2;
	SeqList L3;
	InitSqlist

	return 0;
}
