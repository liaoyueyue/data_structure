#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>

//创建单链表
typedef struct Link {
	int  elem;
	struct Link* next;
}link;

//链表初始化函数
link* initLink() {
	link* p = (link*)malloc(sizeof(link));//创建一个头结点
	link* temp = p;//声明一个指针指向头结点，用于遍历链表
	//生成链表
	for (int i = 1; i < 5; i++) {
		link* a = (link*)malloc(sizeof(link));
		a->elem = i;
		a->next = NULL;
		temp->next = a;
		temp = temp->next;
	}
	return p;
}

//链表插入的函数，p是链表，elem是插入的结点的数据域，add是插入的位置
link* insertElem(link* p, int elem, int add) {
	link* temp = p;//创建临时结点temp
	//首先找到要插入位置的上一个结点
	for (int i = 1; i < add; i++) {
		if (temp == NULL) {
			printf("插入位置无效\n");
			return p;
		}
		temp = temp->next;
	}
	//创建插入结点c
	link* c = (link*)malloc(sizeof(link));
	c->elem = elem;
	//向链表中插入结点
	c->next = temp->next;
	temp->next = c;
	return  p;
}


//显示当前链表
void display(link* p) {
	link* temp = p;//将temp指针重新指向头结点
	//只要temp指针指向的结点的next不是Null，就执行输出语句。
	while (temp->next) {
		temp = temp->next;
		printf("%d", temp->elem);
	}
	printf("\n");
}

int main() {
	//初始化链表（1，2，3，4）
	printf("初始化链表为：\n");
	link* p = initLink();
	display(p);
	printf("在第4的位置插入元素5：\n");
	p = insertElem(p, 5, 4);
	display(p);
	return 0;
}