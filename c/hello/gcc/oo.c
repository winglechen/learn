#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>


#define class(type)                 \
typedef struct type type;           \
struct type

#define extends(type) struct type* type


class(Animal)
{
    int age;
};

class(Dog)
{
    extends(Animal);
    int gender;
};

int main(void)
{

    Dog* d;
    d = (Dog*)malloc(sizeof(Dog));
    d->Animal->age = 10;
    d->gender = 1;

    printf("Dog.age=%d\nDog.gender=%d\n", d->Animal->age, d->gender);

    return 0;
}
