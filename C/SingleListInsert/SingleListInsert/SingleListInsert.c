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

//�������ĺ�����p������elem�ǲ���Ľ���������add�ǲ����λ��
link* insertElem(link* p, int elem, int add) {
	link* temp = p;//������ʱ���temp
	//�����ҵ�Ҫ����λ�õ���һ�����
	for (int i = 1; i < add; i++) {
		if (temp == NULL) {
			printf("����λ����Ч\n");
			return p;
		}
		temp = temp->next;
	}
	//����������c
	link* c = (link*)malloc(sizeof(link));
	c->elem = elem;
	//�������в�����
	c->next = temp->next;
	temp->next = c;
	return  p;
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
	printf("�ڵ�4��λ�ò���Ԫ��5��\n");
	p = insertElem(p, 5, 4);
	display(p);
	return 0;
}