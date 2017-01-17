#include <stdlib.h>
#include <stdio.h>
#include "item.h"

// Constants
#define TRUE 1
#define FALSE 0
#define MAX_SIZE 1000

// Typedefs
typedef struct setRep {
    int nElems;
    Item values[MAX_SIZE];
} setRep;

typedef setRep* Set;

// Function Declarations
Set newSet();
void dropSet(Set);
void showSet(Set);
void setInsert(Set, Item);
int setDelete(Set, Item);
Set setCopy(Set);
int setMember(Set, Item);
Set setUnion(Set, Set);
Set setIntersect(Set, Set);
int setCard(Set);

int main (int argc, char * argv[]) {
    Set s1 = newSet();
    setInsert(s1, 'a');
    setInsert(s1, 'b');
    setInsert(s1, 'c');

    Set s2 = newSet();
    setInsert(s2, '1');
    setInsert(s2, 'b');
    setInsert(s2, '3');

    Set i = setIntersect(s1, s2);
    Set u = setUnion(s1, s2);

    showSet(i);
    showSet(u);    
    
    
    return EXIT_SUCCESS;
}

// Function Implementations

// returns a newly created set
Set newSet() {
    Set s;
    s = malloc(sizeof(setRep));
    s->nElems = 0;
    return s;
}

Set setCopy(Set s) {
    Set copy = newSet();
    for (int i = 0; i < s->nElems; i++) {
        copy->values[i] = s->values[i]; 
    }
    copy->nElems = s->nElems;
    return copy;
}

void dropSet(Set s) {
    free(s);
}

void showSet(Set s) {
    printf("printing set: ");
    for (int i = 0; i < s->nElems-1; i++) {
        printf("%c, ",s->values[i]);
    }
    printf("%c\n", s->values[s->nElems-1]);
    printf("Set Elements: %d\n",s->nElems);
}

void setInsert(Set s, Item it) {
    for (int i = 0; i < s->nElems; i++) {
        if (eq(s->values[i], it)) return;
    }
    s->values[s->nElems] = it;
    s->nElems++;
}

int setDelete(Set s, Item it) {
    int delIndex = MAX_SIZE + 1;
    for(int i = 0; i < s->nElems; i++) {
        if (eq(s->values[i],it)) {
            delIndex = i;
            break;
        }
    }

    // if the item to be deleted does not exist, return false;
    if (delIndex == MAX_SIZE+1) return FALSE;

    for(int i = delIndex; i < s->nElems-1; i++) {
        s->values[i] = s->values[i+1];
    }
    s->nElems = s->nElems-1;
    return TRUE;

}

int setMember(Set s, Item it) {
    for (int i = 0; i < s->nElems; i++) {
        if (eq(it, s->values[i])) return TRUE;
    }    
    return FALSE;
}

Set setUnion(Set s1, Set s2) {
    Set u = setCopy(s1);

    for (int i = 0; i < s2->nElems; i++) {
        if (!setMember(u, s2->values[i])) setInsert(u, s2->values[i]);
    }
    return u;
}

Set setIntersect(Set s1, Set s2) {
    Set intersect = newSet();
    for (int i = 0; i < s1->nElems; i++) {
        if (setMember(s2, s1->values[i])) setInsert(intersect, s1->values[i]);
    }
    return intersect;
}

int setCard(Set s) {
    return s->nElems;
}













