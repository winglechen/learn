#include <iostream>

using namespace std;

int main() {
    cout << "Hello Cpp!" << endl;

    int i,j;
    cout << "未初始化的int i 的值是：" << i << endl;
    
    j = 1;
    j = i + j;
    cout << "is it correct" << j << endl;

    i = 10;
    cout << "初始化后的int i 的值是：" << i << endl;


    string s;
    cout << "未初始化的int s 的值是：" << s << endl;

    s = "wingle";
    cout << "初始化后的int s 的值是：" << s << endl;

    return 0;
}
