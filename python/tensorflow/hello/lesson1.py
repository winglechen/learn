import tensorflow as tf

node1 = tf.constant(3.0, dtype=tf.float32)
node2 = tf.constant(4.0)

sess = tf.Session()
res1 = sess.run([node1, node2])
print(res1)

node3 = tf.add(node1, node2)
res2 = sess.run(node3)
print(res2)

a = tf.placeholder(tf.float32)
b = tf.placeholder(tf.float32)
adder_node = a + b

res3 = sess.run(adder_node, {a:3, b:4.5} )
res4 = sess.run(adder_node, {a:[1, 3], b: [2, 4]})
print(res3)
print(res4)

W = tf.Variable([0.3], dtype=tf.float32)
b = tf.Variable([-0.3], dtype=tf.float32)
x = tf.placeholder(tf.float32)
linear_model = W * x + b

init = tf.global_variables_initializer()
sess.run(init)

res5 = sess.run(linear_model, {x: [1, 2, 3, 4]})
print(res5)