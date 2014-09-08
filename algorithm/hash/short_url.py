#!/usr/bin/env python
#coding=utf-8
import hashlib,os

chars = (
        "a","b","c","d","e","f","g","h",
        "i","j","k","l","m","n","o","p",
        "q","r","s","t","u","v","w","x",
        "y","z","0","1","2","3","4","5",
        "6","7","8","9","A","B","C","D",
        "E","F","G","H","I","J","K","L",
        "M","N","O","P","Q","R","S","T",
        "U","V","W","X","Y","Z"
        )

def shorten(origin):
    key = "koudaitong.com"
    hex = hashlib.md5(key + origin).hexdigest()
    res = [0 for i in range(4)]
    print hex

    for i in range(4):
        hexint = 0x3FFFFFFF & int("0x" + hex[i * 8: i*8+8], 16)
        #hexint = 0xFFFFFFFF & int("0x" + hex[i * 8: i*8+8], 16)
        #print hexint
        outChars = ""
        for j in range(6):
            #print "hexint:"+str(hexint)
            index = 0x0000003D & hexint
            #index = 0x0000003D ^ (hexint & 0x0000003F)
            #print "index:"+str(index)
            outChars += chars[index]
            hexint = hexint >> 5
        res[i] = outChars
    return res

if __name__ == '__main__':
    shorten('abc')
    exit()
    while 1:
        a = raw_input("Input a url:")
        print shorten(a)
