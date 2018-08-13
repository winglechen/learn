#include <iostream>
#include <cmath>

#include "coordin.h"

using namespace std;

polar rect_to_polar(rect r) {
    polar answer;
    
    answer.distance = sqrt(r.x * r.x + r.y + r.y);
    answer.angle = atan2(r.y, r.x);

    return answer;
}

void show_polar(polar p) {
    const double rad_to_deg = 57.29577951;

    cout << "distance = " << p.distance << ", ";
    cout << "angle = " << p.angle * rad_to_deg << " degrees" << endl;

}
