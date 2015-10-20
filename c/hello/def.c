#include <stdio.h>
#include <stdlib.h>

typedef struct Person Person;
struct Person{
  char name[20];
  int age;
};

int main()
{
    Person* wingle;

    wingle = malloc(sizeof(Person));
    wingle->age  = 20;

    printf("%d\n",wingle->age);

    return 0;
}