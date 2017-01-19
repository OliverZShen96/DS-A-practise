#include <stdio.h>
#include <stdlib.h>
#include "item.h"

typedef struct ListNode {
    Item value;
    struct ListNode* next;
    struct ListNode* prev;
} ListNode;

typedef struct ListRep {
    ListNode* head;
    ListNode* tail;
} ListRep;

typedef ListRep* List;
typedef ListNode* Node;

List newList();
Node newNode(Item);
void appendNode(List, Item);
void printList(List);
void prependNode(List, Item);
List zipList(List, List);

int main(int argc, char * argv[]) {
    List l1 = newList();
    appendNode(l1, 'a');
    appendNode(l1, 'b');
    appendNode(l1, 'c');
    appendNode(l1, 'd');
    appendNode(l1, 'e');

    List l2 = newList();
    appendNode(l2, '1');
    appendNode(l2, '2');
    appendNode(l2, '3');


    printList(l1);
    printList(l2);
    
    List l3 = zipList(l1,l2);

    printList(l3);
    return EXIT_SUCCESS;
}

Node newNode(Item it) {
    Node n;
    n = malloc(sizeof(Node));
    n->prev = n->next = NULL;
    n->value = it;
    return n;
}

List newList() {
    List l = malloc(sizeof(List));
    l->head = l->tail = NULL;
    return l;
}

void prependNode(List l, Item it) {
    Node new = newNode(it);
    new->next = l->head;
    l->head = new;
    if (l->tail == NULL) l->tail = new;
}

void appendNode(List l, Item it) {
    if(l->head == NULL) {
        prependNode(l, it);
        return;    
    }

    Node n = newNode(it);
    n->prev = l->tail;
    n->next = NULL;

    l->tail->next = n;
    l->tail = n;
}

List zipList(List l1, List l2) {
    List new = newList();
    Node curr1 = l1->head;
    Node curr2 = l2->head;
    while(curr1 != NULL && curr2 != NULL) {
        appendNode(new, curr1->value);
        appendNode(new, curr2->value);
        curr1 = curr1->next;
        curr2 = curr2->next;
    }
    while (curr1 != NULL) {
        appendNode(new, curr1->value);
        curr1 = curr1->next;
    }
    while (curr2 != NULL) {
        appendNode(new, curr2->value);
        curr2 = curr2->next;
    }

    return new;
}

/*void removeNthNode(List l, int n) {
    Node curr = l->head;    
    for (int i = 0; i < n; i++) {
        if(curr != NULL) curr = curr->next;
    }
    if (curr == NULL) return;

}*/

void printList(List l) {
    Node curr = l->head;
    printf("[");
    while(curr->next != NULL) {
        printf("%c, ", curr->value);
        curr = curr->next;
    }
    printf("%c]\n", curr->value);
}










