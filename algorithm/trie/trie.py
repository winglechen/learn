# encoding=utf-8

class Trie(object):
    tree    = {}
    
    @staticmethod
    def match(words):
        return {
            'match'     : False,
            'isWord'    : False,
            'continue'  : False,
            'dict'      : None
        }



