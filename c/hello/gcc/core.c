//
// Created by winglechen on 16/1/6.
//

#include <stdio.h>
int test(int* p);

int main(void)
{
    int* p = 0;


    return test(p);
}

int test(int* p)
{
    int y = *p;

    return y;
}
