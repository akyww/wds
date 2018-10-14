
# coding: utf-8

# In[4]:


import matplotlib.pyplot as plt
import numpy as np
import os.path
import random
import math
#sci-learn

class RL:
    theta = []
    umbral = 0.5
    alfa = 0.007
    error = 0
    x = []
    y = []
    xi = []
    xii = []
    lamda = 0
    
    def __init__(self, xx,yy, thetas):
        self.x = xx
        self.y = yy
        self.lamda = 2*len(yy)
        self.theta = thetas
        
        for i in self.x:
            arr = []
            for j in range(len(self.x)):
                arr.append(pow(i,j))
            self.xii.append(arr)

        
    def H(self):
        arr = []
        for c in self.xii:
            hx = sum([ e[0] * e[1] for e in zip (self.theta, c)])
            arr.append(hx)
        return arr
    
    def Error(self):
        error = sum((e[0]-e[1])**2 for e in zip(self.y, self.H()))/ (2*len(self.y)) + sum([self.lamda * e * e for e in self.theta])/2*len(self.y)
        return error
    
    def changeTheta(self):
        temp = self.theta
        arr = []
        for c in self.xii:
            hx = sum([ e[0] * e[1] for e in zip (temp, c)])
            arr.append(hx)
            
        sumParte1 = sum(e[0] - e[1] for e in zip (self.y,self.H()))/len(self.y)
        for c in range (len(temp)):
            derivada_theta =  sum((e[0] - e[1] ) * (- self.x[c]) for e in zip (self.y,self.H())) +  (self.lamda *  temp[c])/ len(self.y) 
            self.theta[c] = self.theta[c]- self.alfa*derivada_theta/len(self.y) 
        #print('-> ',derivada_theta)
    
    def graficar(self,cont):
        
        plt.scatter(self.x, self.y)
        plt.plot(self.x, self.H(), '-', color = 'red')
        plt.axis('tight')
        plt.grid(True)
        plt.xlim(0, max(self.x)+2)
        plt.ylim(0, max(self.y)+2) #self.theta0 + self.theta1*35)
        output_path = os.path.join('D:\graficosRegresion',str(cont)+'.png')
        #plt.savefig(output_path)
        plt.show()
        
        plt.close()

    def entrenar(self):
        i = 1
        err = self.Error()
        self.graficar(i)
        
        while(err>self.umbral):
            if(i%20==0):
                self.graficar(i)    
            self.changeTheta()
            print('ttt-> ',self.theta)
            print(err)
            err = self.Error()
            i = i+1

xx = [1,2,3,4,6]
yy = [2,1,4,2,2]
thetas = []

for c in range (5):
    thetas.append(np.random.random())


# for c in range (10):
#     ax.append(random.randint(2,4)+c-1)
#     ay.append(random.randint(3,5)+c-1)

a = RL(xx,yy,thetas)
#a.graficar(0)
a.entrenar()
#a.Error()
#a.changeTheta()
#a.H()

