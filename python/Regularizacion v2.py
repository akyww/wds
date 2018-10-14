
# coding: utf-8

# In[37]:


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
    theta = []
    lamda = 0

    def __init__(self, xx,yy, tetas):
        self.theta = tetas
        self.x = xx
        self.y = yy
        
    def H(self):
        arr = []
        cont = 0
        for i in self.x:
            hx = 0
            for j in range(0,len(self.x)):
                hx = hx + (self.theta[j] * pow(i,j))
                print(hx)
            arr.append(hx)
            
        return arr
    
    def Error(self):
        error = sum((e[0]-e[1])**2 for e in zip(self.y, self.H()))/ (2*len(self.y)) + sum([self.lamda * e * e for e in self.theta])/2*len(self.y)
        return error
    
    def changeTheta(self):
        
        temp = self.theta
        arr = []
        cont = 0
        for i in self.x:
            hx = 0
            for j in range(0,len(self.x)):
                hx = hx + (temp[j] * pow(i,j))
            arr.append(hx)
            
        for c in range (1,len(self.theta)):
            derivada_theta =  sum((e[0] - e[1] ) * (- self.x[c]) for e in zip (self.y,arr))/ len(self.y) +  (self.lamda *  temp[c])/ len(self.y) 
            self.theta[c] = self.theta[c]- self.alfa*derivada_theta  
    
        
    def graficar(self,cont):
        
        plt.scatter(self.x, self.y)
        plt.plot(self.x, self.H(), '-', color = 'red')
        #plt.plot([0,35],[self.theta0 + self.theta1*0,self.theta0 + self.theta1*35],c="red")
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
        #self.graficar(i)
        while(err>self.umbral):
            #if(i%20==0):
                #self.graficar(i)    
            self.changeTheta()
            print(err)
            err = self.Error()
            i = i+1

ax = []
ay = []

for c in range (6):
    ax.append(random.randint(2,4)+c-1)
    ay.append(random.randint(3,5)+c-1)
    
thetas = []
for c in range (6):
    thetas.append(np.random.random())
    

a = RL(ax,ay,thetas)
#a.entrenar()
print(ax)
print(thetas)
print(a.H())
#print(a.Error())

