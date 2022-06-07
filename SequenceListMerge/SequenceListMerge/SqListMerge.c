//˳���ĺϲ�

#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <malloc.h>

#define LENGTHMAX 50

//�������Ա�ṹ
typedef struct SeqList {
	int* elem;
	int length;
}SeqList;

//��ʼ���ṹ�壬Ϊ���Ա����洢�ռ�
void InitSeqlist(SeqList *L) {
	L->elem = (int*)malloc(LENGTHMAX * sizeof(int));
	L->length = 0;
}

//������������Ԫ�غ���
void InputSeqListLength(SeqList *L) {
	int len = 0;
	printf("����˳���ĳ��ȣ�");
	scanf("%d", &len);
	printf("����˳����Ԫ�أ�");
	for (int i = 0; i < len; i++) {
		scanf("%d", &L->elem[i]);
		L->length++;
	}
}

//�����ȡ���Ա��Ⱥ���
int getSeqListLength(SeqList *L) {
	return L->length;
}

//��ӡ���Ա���Ԫ��
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

//�ϲ�˳�����
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
	//��L2�Ѿ�����
	while (i < L1->length) {
		L3->elem[k++] = L1->elem[i++];
		L3->length++;
	}
	//��L1�Ѿ�����
	while (j < L2->length) {
		L3->elem[k++] = L2->elem[j++];
		L3->length++;
	}
}


int Menu() {
	printf("********* please choose **********\n");
	printf("**********************************\n");
	printf("******* 1��mergeSeqList **********\n");
	printf("******* 0��exit         **********\n");
	printf("**********************************\n");
	int choose = 0;
	scanf("%d", &choose);
	return choose;
}


int main() {
	int choose = Menu();
	switch (choose) {
	case 1:
		printf("ʹ��˳���ϲ�\n");
		//����˳���
		SeqList L1;
		SeqList L2;
		SeqList L3;
		//��ʼ��˳���L1, L2
		InitSeqlist(&L1);
		InitSeqlist(&L2);
		//����˳�������L1, L2
		printf("��ʼ��ʼ����һ��˳���\n");
		InputSeqListLength(&L1);
		printf("��ʼ��ʼ���ڶ���˳���\n");
		InputSeqListLength(&L2);
		//��ӡδ�ϲ�ǰ˳���L1, L2
		printf("δ�ϲ�ǰ˳���:\n");
		printSeqList(&L1);
		printSeqList(&L2);
		//��ʼ��˳���L3���ϲ�˳���L1��L2
		InitSeqlist(&L3);
		MergeSeqList(&L1, &L2, &L3);
		//��ӡ˳���L3
		printf("�ϲ���˳���:\n");
		printSeqList(&L3);
		break;
	case 0:
		printf("�˳�����\n");
		break;
	default:
		printf("�������\n");
		break;
	}
	return 0;
}
