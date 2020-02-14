import numpy
#Enter the original studied sets
feature_count, n = [int(i) for i in input().strip().split(" ")]
set_X = []
set_Y = []
for i in range(n):
    data = input().strip().split(" ")
    set_X.append(data[:feature_count])
    set_Y.append(data[feature_count:])
#Enter additional feature sets to query for
q = int(input().strip())
X_new = []
for x in range(q):
    X_new.append(input().strip().split(" "))
set_X = numpy.array(set_X, float)
set_Y = numpy.array(set_Y, float)
X_new = numpy.array(X_new, float)

#center
X_R = set_X-numpy.mean(set_X, axis=0)
Y_R = set_Y-numpy.mean(set_Y)

#calculate beta using matrix operations
beta = numpy.dot(
    numpy.linalg.inv(
        numpy.dot(X_R.T,X_R)),
        numpy.dot(X_R.T,Y_R))

#predict
X_new_R = X_new-numpy.mean(set_X,axis=0)
Y_new_R = numpy.dot(X_new_R,beta)
Y_new = Y_new_R + numpy.mean(set_Y)

#print
for i in Y_new:
    print(round(float(i),2))
