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
            self.addWord(word,idx)
            self.matching(word,idx,isLast)
        return self.queue

    def matching(self,word,idx=0,isLast=False):
        match = {
            'result'    : [],
            'start'     : -1,
            'end'       : -1
        }
        for words in self.queue:
            result = Trie.match(words)

            if self.cantContinue(result,words,match):
                continue
            if self.addMatchedWords(words,match)
                continue

            self.setMatchBoundary(isLast,words,match,idx)
            self.addMatchingWords(words,result,match)
            self.addInnerWords(words,result,match,idx)

            self.queue = match['result']

    def addMatchedWords(self,words,match):
        if -1 != words['end']:
            match['result'].append(words)
            return True
        return False

    def addMatchingWords(self,words,result,match):
        words['dict']    = result['dict']
        words['words']  += word
        match['result'].append(words)

    def addInnerWords(self,words,result,match,idx):
        if result['isWord'] and result['continue']:
            temp = copy.copy(words)
            temp['end']= idx
            match['result'].append(temp)

    def setMatchBoundary(self,isLast,words,match,idx):
            if isLast or result['isWord']:
                match['end'] = idx
            
            if result['isWord'] and words['start'] > match['start'] :
                match['start'] = words['start']

    def cantContinue(self,result,words,match):
        if not result['match']:
            return True 

        if isLast and not result['isWord']:
            return True

        if self.isInnerWord(words,match):
            return True

        return False

    def isInnerWord(self,words,match):
        if -1 == match['start'] || -1 == match['end']:
            return False

        if words['start'] > match['start']:
            return True

        if words['end'] < match['end']:
            return True

        return False

    def addWord(self,word,idx=0):
        self.queue.append({
            'start' : idx,
            'end'   : -1,
            'words' : '',
            'dict'  : None
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

