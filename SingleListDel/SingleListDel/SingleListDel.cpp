#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>

//����������
typedef struct Link {
	int  elem;
	struct Link* next;
}link;

//�����ʼ������
link* initLink() {
	link* p = (link*)malloc(sizeof(link));//����һ��ͷ���
	link* temp = p;//����һ��ָ��ָ��ͷ��㣬���ڱ�������
	//��������
	for (int i = 1; i < 5; i++) {
		link* a = (link*)malloc(sizeof(link));
		a->elem = i;
		a->next = NULL;
		temp->next = a;
		temp = temp->next;
	}
	return p;
}

//ɾ�����ĺ�����p�����������add����ɾ���ڵ��λ��
link* delElem(link* p, int add) {
	link* temp = p;
	//��������ɾ��������һ�����
	for (int i = 1; i < add; i++) {
		temp = temp->next;
	}
	link* del = temp->next;//��������һ��ָ��ָ��ɾ����㣬�Է���ʧ
	temp->next = temp->next->next;//ɾ��ĳ�����ķ������Ǹ���ǰһ������ָ����
	free(del);//�ֶ��ͷŸý�㣬��ֹ�ڴ�й©
	return p;
}

//��ʾ��ǰ����
void display(link* p) {
	link* temp = p;//��tempָ������ָ��ͷ���
	//ֻҪtempָ��ָ��Ľ���next����Null����ִ�������䡣
	while (temp->next) {
		temp = temp->next;
		printf("%d", temp->elem);
	}
	printf("\n");
}

int main() {
	//��ʼ������1��2��3��4��
	printf("��ʼ������Ϊ��\n");
	link* p = initLink();
	display(p);
	printf("ɾ��Ԫ��3:\n");
	p = delElem(p, 3);
	display(p);
	return 0;
}