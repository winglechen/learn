# encoding=utf-8

from .trie import *
import copy

# 仅支持utf-8编码
class Matcher(object):
    def match(self,sentence):
        pass


class ForwardMaxMatcher(Matcher):
    queue   = []
    def match(self,sentence):
        length = len(sentence)
        if length == 0: 
            return self.result

        isLast = False
        for idx,word in enumerate(sentence):
            if idx >= length - 1:
                isLast = True
            self.addWords(word,idx,isLast)
        return self.queue

    def addWords(self,word,idx=0,isLast=False):
        self.addWord(word,idx)
        self.matching(word,idx,isLast)

    def matching(self,word,idx=0,isLast=False):
        result      = []
        match_start = -1
        match_end   = -1

        for words in self.queue:
            result = Trie.match(words)

            if self.cantContinue(result):
                continue
            if self.isInnerWord(words,match_start,match_end):
                continue
            if -1 == words['end_pos']:
                result.append(words)

            if isLast or result['isWord']:
                match_end = idx
            
            if result['isWord'] and words['start_pos'] > match_start :
                match_start     = words['start_pos']

            words['dict']    = result['dict']
            words['words']  += word
            result.append(words)

            if result['isWord'] and result['continue']:
                temp = copy.copy(words)
                temp['end_pos']= idx
                result.append(temp)
        self.queue = result

    def cantContinue(self,result):
        if not result['match']:
            return True 

        if isLast and not result['isWord']:
            return True

        return False

    def isInnerWord(self,words,start,end):
        if -1 == start || -1 == end:
            return False

        if words['start_pos'] > start:
            return True

        if words['end_pos'] < end:
            return True

        return False



    def addWord(self,word,idx=0):
        self.queue.append({
            'start_pos' : idx,
            'end_pos'   : -1,
            'words'     : '',
            'dict'      : None
        })


        
class ForwardMinMatcher(Matcher):
    def match(self,sentence):
        pass

class ForwardAllMatcher(Matcher):
    def match(self,sentence):
        pass

class BackwardMaxMatcher(Matcher):
    def match(self,sentence):
        pass

class BackwardMinMatcher(Matcher):
    def match(self,sentence):
        pass

class BackwardAllMatcher(Matcher):
    def match(self,sentence):
        pass

