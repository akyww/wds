
# coding: utf-8

# In[1]:


import matplotlib.pyplot as plt
import numpy as np
import os.path
import random

class RL:
    theta0 = 0
    theta1 = 0
    umbral = 0.01
    alfa = 0.005
    error = 0
    x = []
    y = []
    
    def __init__(self, xx,yy):
        self.x = xx
        self.y = yy
        self.theta0 = -15#np.random.random()
        self.theta1 = -10#np.random.random()
        
    def H(self):
        return [ self.theta0 + self.theta1*e for e in self.x]
    
    def Error(self):
        H2 = zip(self.y, self.H())
        error = sum((e[0]-e[1]) for  e in H2)**2 / (2*len(self.y))
        return error
    
    def changeTheta(self):
        temp = self.theta0
        derivada_theta0 = sum([self.theta0 + self.theta1 * e[0] - e[1] for e in zip(self.x,self.y)]) / len(self.y)
        derivada_theta1 = sum([(temp + self.theta1 * e[0] - e[1])* e[0] for e in zip(self.x,self.y)]) / len(self.y)
        #print('tehta0', derivada_theta0)
        #print('tehta1', derivada_theta1)
        self.theta0 = temp - self.alfa*derivada_theta0
        self.theta1 = self.theta1 - self.alfa*derivada_theta1
    
    def graficar(self,cont):
        
        plt.scatter(self.x, self.y)
        plt.plot(self.x, self.H(), '-', color = 'red')
        #plt.plot([0,35],[self.theta0 + self.theta1*0,self.theta0 + self.theta1*35],c="red")
        plt.axis('tight')
        plt.grid(True)
        plt.xlim(0, max(self.x)+2)
        plt.ylim(0, max(self.y)+2) #self.theta0 + self.theta1*35)
        output_path = os.path.join('D:\graficosRegresion',str(cont)+'.png')
        plt.savefig(output_path)
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
            print(err)
            err = self.Error()
            i = i+1

ax = []
ay = []
   
for c in range (30):
    ax.append(random.randint(2,4)+c-1)
    ay.append(random.randint(3,5)+c-1)
    
print(ax)
print(ay)
a = RL(ax,ay)
#a.entrenar()
a.H()
    

