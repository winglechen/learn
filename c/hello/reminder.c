#include <stdio.h>
#include <stdlib.h>
#include <string.h>



/**
 *  学习笔记
 *  1，c语言中数字转化成字符串或字符数组
 *  2, scanf的用法需要学习下
 *  3, strcmp strcat strcpy
 *  4, spintf的用法
 *
 */


#define MAX_REMIND  3
#define MSG_LENGTH  60

#define INFINITE_LOOP_START for(;;){
#define INFINITE_LOOP_END }

int read_line(char str[], int len);

int main()
{
    char *reminders[MAX_REMIND];
    char dayStr[3], msgStr[MSG_LENGTH+1];
    int day=0, i=0, j=0, numRemind=0;

    INFINITE_LOOP_START
        if(numRemind == MAX_REMIND){
            printf("--- No space left ---\n");    
            break;
        }     

        printf("Enter day and reminder: ");
        scanf("%2d", &day);

        if(0 == day){
            printf("No 0 day\n");
            break;
        }

        sprintf(dayStr, "%2d", day);
        read_line(msgStr, MSG_LENGTH);

        //检查重复 完成后i = length of reminders
        for(i=0; i<numRemind; i++){
            if(strcmp(dayStr,reminders[i]) < 0){
                break;    
            }    
        }

        for(j=numRemind; j>i; j--){
            reminders[j] = reminders[j-1];    
        }

        reminders[i] = malloc(3 + strlen(msgStr) + 1);
        if(NULL == reminders[i]){
            printf("-- No space left for reminders : %d",i);
            break;
        }

        strcpy(reminders[i],dayStr);
        strcat(reminders[i],":");
        strcat(reminders[i],msgStr);

        numRemind++;
    INFINITE_LOOP_END        

    printf("\nDay Reminder\n");
    for(i=0; i<numRemind; i++){
        printf("%s\n",reminders[i]);    
    }

    return 0;
}


int read_line(char str[], int len)
{
    int ch=0, i=0;

    while( (ch = getchar()) != '\n'){
        if(i<len){
            str[i++] = ch;    
        }     
    }
    str[i] = '\0';

    return 0;
}
