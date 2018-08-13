import tensorflow as tf

hello = tf.constant('Hello World!')
sess = tf.Session();

print(hello)
print(sess.run(hello))