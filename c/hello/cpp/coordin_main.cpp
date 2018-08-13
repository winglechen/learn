#include <iostream>

#include "coordin.h"

using namespace std;

int main() {
    rect r;
    polar p;

    cout << "Enter the x and Y values: ";
    while(cin >> r.x >> r.y) {
        p = rect_to_polar(r);
        show_polar(p);
        cout << "Next two numbers (q to quit): ";
    }

    cout << "Bye!" << endl;

    return 0;
}
