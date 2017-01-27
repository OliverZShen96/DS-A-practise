#include <stdio.h>
#include <stdlib.h>
#include "item.h"

typedef struct BSTNode {
    Item value;
    struct BSTNode* left;
    struct BSTNode* right;
} BSTNode;
typedef BSTNode* BSTree;

BSTree newTree();
BSTree insert(BSTree t, Item it);
void TraverseLNR(BSTree t);
void TraverseLRN(BSTree t);
void TraverseNLR(BSTree t);

int main (int argc, char* argv[]) {
    BSTree t = newTree();
    t = insert(t, 'a');
    t = insert(t, 'f');
    t = insert(t, 'g');
    t = insert(t, 'e');
    
    t = insert(t, 'h');
    t = insert(t, 'b');
    t = insert(t, 'c');
    t = insert(t, 'd');

    TraverseLNR(t);

    return EXIT_SUCCESS;
}

static BSTree newBSTNode(Item it) {
    BSTree new = malloc(sizeof(BSTNode));
    new->value = it;
    new->left = new->right = NULL;
    return new;
}

BSTree newTree() {
    return NULL;
}


BSTree insert(BSTree t, Item it) {
    if (t == NULL) {
        return newBSTNode(it);    
    } else if (lt(it, t->value)) {
        t->left = insert(t->left, it);
    } else if (gt(it, t->value)) {
        t->right = insert(t->right, it);
    }
    return t;
}

void TraverseNLR(BSTree t) {
    if (t != NULL) {     
        printf("%c", t->value);
        TraverseLNR(t->left);
        TraverseLNR(t->right);
    }
}
void TraverseLNR(BSTree t) {
    if (t != NULL) {
        TraverseLNR(t->left);
        printf("%c", t->value);
        TraverseLNR(t->right);
    }
}
void TraverseLRN(BSTree t) {
    if (t != NULL) {
        TraverseLNR(t->left);
        TraverseLNR(t->right);
        printf("%c", t->value);

    }
}
