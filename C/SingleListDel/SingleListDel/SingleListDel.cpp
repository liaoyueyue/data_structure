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

//删除结点的函数，p代表操作链表，add代表删除节点的位置
link* delElem(link* p, int add) {
	link* temp = p;
	//遍历到被删除结点的上一个结点
	for (int i = 1; i < add; i++) {
		temp = temp->next;
	}
	link* del = temp->next;//单独设置一个指针指向被删除结点，以防丢失
	temp->next = temp->next->next;//删除某个结点的方法就是更改前一个结点的指针域
	free(del);//手动释放该结点，防止内存泄漏
	return p;
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
	printf("删除元素3:\n");
	p = delElem(p, 3);
	display(p);
	return 0;
}