
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
    theta = []


    def __init__(self, xx,yy, tetas):
        self.theta = tetas
        self.x = xx
        self.y = yy
        
    def H(self):
        arr = []
        for i in self.x:
            hx = sum([ e[0] * e[1] for e in zip(self.theta,i)])
            arr.append(hx)
        return arr
    
    def Error(self):
        H2 = zip(self.y, self.H())
        error = sum((e[0]-e[1]) for  e in H2)**2 / (2*len(self.y))
        return error
    
    def changeTheta(self):
        temp = self.theta
        arr = []
        for i in self.x:
            hipotesis = sum([ e[0] * e[1] for e in zip(temp,i)])
            arr.append(hipotesis)
        
        ##adsf
        for j in range(len(self.theta)):
            suma = 0
            for i in range(len(self.y)):
                suma  = suma +((self.y[i] - arr[i]) * (- self.x[i][j]))
            self.theta[j] = self.theta[j] - self.alfa * suma/len(self.y)
        
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
filas = 6
columnas = 6

for c in range (6):
    #ax.append(random.randint(2,4)+c-1)
    ay.append(random.randint(3,5)+c-1)
    
thetas = []
for c in range (6):
    thetas.append(np.random.random())
    
for i in range (filas):
    ax.append([0] * columnas)

for i in range (filas):
    for j in range (columnas):
        ax[i][0] = 1
        ax[i][j] = random.randint(1,9)



a = RL(ax,ay,thetas)
a.entrenar()


# In[57]:


import matplotlib.pyplot as plt
import numpy as np
import os.path
import random

matriz = []
filas = 5
columnas = 5

for i in range (filas):
    matriz.append([0] * columnas)

for i in range (filas):
    for j in range (columnas):
        matriz[i][0] = 1
        matriz[i][j] = random.randint(1,9)



h = 0.25790716219342236 * 1 + 0.9569021733188342 * 8 + 0.22355069252814153 * 9 + 0.06397700958216068* 6 + 0.8701354547392419* 3
h2 = 0.25790716219342236 * 1 + 0.9569021733188342 * 3 + 0.22355069252814153 * 5 + 0.06397700958216068* 2 + 0.8701354547392419* 4
h3 = 0.25790716219342236 * 1 + 0.9569021733188342 * 7 + 0.22355069252814153 * 2 + 0.06397700958216068* 2 + 0.8701354547392419* 3
h4 = 0.25790716219342236 * 1 + 0.9569021733188342 * 4 + 0.22355069252814153 * 7 + 0.06397700958216068* 5 + 0.8701354547392419* 4
h5 = 0.25790716219342236 * 1 + 0.9569021733188342 * 1 + 0.22355069252814153 * 7 + 0.06397700958216068* 9 + 0.8701354547392419* 3
print(h)
print(h2)
print(h3)
print(h4)
print(h5)

