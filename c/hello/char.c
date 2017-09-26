#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    //len:50
    char* name = "";
    name = malloc(50);

    strcpy(name,"hello world! haha!\n");
    printf("name:%s", name);

    return 0;
}
