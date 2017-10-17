//
// Created by 陈思源 on 2017/10/9.
//

#ifndef MONITOR_OBJECT_RAII_H
#define MONITOR_OBJECT_RAII_H


class Raii {
public:
    Raii(Resource &resource) :m_pRes (&resource) {
        m_pRes->initialize();
    }

private:
    Resource *m_pRes;
};


#endif //MONITOR_OBJECT_RAII_H
