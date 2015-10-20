#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char name[50];
    int age;    
    int gender;
    char intro[100];
} Person;

int main(){
    char* tmpStr;
    Person* wingle;

    tmpStr = malloc(200);
    strcpy(tmpStr,"I am content of tmpStr, Ha Ha!\n");
    printf("tmpStr value: %s\n", tmpStr);


    memset(tmpStr, 0, strlen(tmpStr));
    printf("tmpStr value: %s\n", tmpStr);

    wingle = (Person*)tmpStr;
    wingle->age      = 20;
    wingle->gender   = 1;

    printf("wingle age value : %d\n",wingle->age);
    printf("wingle gender value : %d\n",wingle->gender);

    printf("tmpStr value: %s\n", tmpStr);

    return 0;
}