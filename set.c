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

int main (int argc, char * argv[]) {
    Set s = newSet();
    setInsert(s, 'a');
    setInsert(s, 'b');
    setInsert(s, 'b');
    setInsert(s, 'a');
    setInsert(s, 'c');
    setInsert(s, 'd');
    showSet(s);
    Set t = setCopy(s);
    showSet(t);
    
    setDelete(s, 'e');
    showSet(s);

    dropSet(s);
    dropSet(t);
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














