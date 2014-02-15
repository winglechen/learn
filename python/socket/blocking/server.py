#encoding=utf-8
__author__ = 'winglechen'

import socket,select
import time
import os

host = "localhost"
port = 1934
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind((host,port))
s.listen(5)

try:
    client, address = s.accept()
    while True:
        request = client.recv(1024)
        if request:
            client.send("response:"+request)
finally:
    s.close();