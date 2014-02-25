
class Test(object):
    a = None
    @staticmethod
    def init():
        Test.a = 123
        print "static value ", Test.a

    def show(self):
        print "in the object: ",self.a


Test.init()

t = Test()
t.show()
