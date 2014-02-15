#encoding=utf-8
__author__ = 'winglechen'

import socket,select

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR, 1)
s.bind(('localhost',1934))
s.listen(1)
s.setblocking(0)
epoll = select.epoll()
epoll.register(s.fileno(),select.EPOLLIN)

try:
    clients  = {}
    requests = {}
    responses= {}
    while True:
        events = epoll.poll(1)
        for fileno,event in events:
            if fileno == s.fileno():
                client, address = s.accept()
                client.setblocking(0)
                epoll.register(client.fileno(),select.EPOLLIN)
                clients[client.fileno()] = client
            elif event & select.EPOLLIN:
                conn = clients[fileno]
                request = conn.recv(1024)
                epoll.modify(fileno,select.EPOLLOUT)
                conn.setsockopt(socket.IPPROTO_TCP,socket.TCP_CORK,1)
                responses[fileno] = "response:" + request
                requests[fileno] = request
            elif event & select.EPOLLOUT:
                if requests[fileno]:
                    clients[fileno].send(responses[fileno])
                    requests[fileno] = None
                    epoll.modify(fileno,select.EPOLLIN)
            elif event & select.EPOLLHUP:
                epoll.unregister(fileno)
                clients[fileno].close()
                del clients[fileno]

finally:
    epoll.unregister(s.fileno())
    epoll.close()
    s.close()
