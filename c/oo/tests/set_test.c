#include <stdio.h>

#include "Oo.h"
#include "Set.h"

int main()
{
    void* s = new(Set);
    void* a = add(s, new(Object));
    void* b = add(s, new(Object));
    void* c = new(Object);

    if (contains(s, a) && contains(s, b)  ) {
        puts("ok");
    }
}
