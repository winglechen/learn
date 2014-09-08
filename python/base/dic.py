#encoding=utf-8

from collections import OrderedDict

'''
od  = {
    'a' : 1,
    'd' : 4,
    'c' : 3,
    'b' : 2,
}
od['n'] = 2
od['s'] = 1
od = OrderedDict(sorted(od.items(),key=lambda t:t[1]))
print od
'''


class zipList(object):
    container = {}
    @staticmethod
    def push(key,value):
        zipList.container[key] = value
        zipList.container = OrderedDict(sorted(zipList.container.items(), key=lambda t:t[1]))

    @staticmethod
    def pop():
        pass

