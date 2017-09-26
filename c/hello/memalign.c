#include <stdio.h>

#pragma pack(1)

typedef struct bb {
     int id;            // 4 补齐为8
     double weight;     // 8 
     float height;      // 4  
}BB;                    // 总长要补齐为8的倍数

typedef struct aa {
    char name[2];
    int id;
    double score;
    short grade;
    BB b;
}AA;

int main() {
    
    AA a;

    printf("sizeof(a) = %d\n", (int)sizeof(a));
    printf("sizeof(AA) = %d\n", (int)sizeof(AA));
    printf("sizeof(BB) = %d\n", (int)sizeof(BB));

    printf("---------------------------------\n");
    
    printf("sizeof(short) = %d\n", (int)sizeof(short));
    printf("sizeof(int) = %d\n", (int)sizeof(int));
    printf("sizeof(double) = %d\n", (int)sizeof(double));
    printf("sizeof(float) = %d\n", (int)sizeof(float));

    return 0;
}
