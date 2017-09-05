//
// Created by winglechen on 16/1/1.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char* string;

int main(void)
{
    string name;

    name = malloc(200);
    strcpy(name, "I am wingle\n");

    printf("Msg: %s", name);
    return 0;
}