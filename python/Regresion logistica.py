
# coding: utf-8

# In[21]:


import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import os.path
import random

def prepareData(filename):
    data = pd.read_csv(filename, header=None)
    y = np.array(data[4])
    df =data.loc[:]
    new_col=np.ones(len(y))
    df.insert(loc=0, column=-1, value=new_col)
    a = np.array(df)
    np.random.shuffle(a)
    dataTrain=[]
    dataTest=[]

    trainData = int(len(a) * 0.6)

    for i in range(trainData):
        dataTrain.append(a[i])
    
    for i in range(trainData,len(a)):
        dataTest.append(a[i])
        
    matTr = np.matrix(dataTrain)
    matTs = np.matrix(dataTest)

    with open('train.txt','wb') as f:
        for line in matTr:
            np.savetxt(f, line, fmt='%.1f',delimiter=',')

    with open('test.txt','wb') as f:
        for line in matTs:
            np.savetxt(f, line, fmt='%.1f',delimiter=',')


class RL:
    umbral = 0.03
    alfa = 0.007
    error = 0
    x = []
    y = []
    theta = []

    def __init__(self,filename):
        data = pd.read_csv(filename, header=None)
        self.y = np.array(data[5])
        df =data.loc[:,0:4]
        self.x =  np.array(df)
        self.theta = [np.random.random(5)]
        
    def H(self):
        return  [np.dot(self.theta,e) for e in self.x]
    
    def S(self):
        
        return 1.0/(1.0 +np.exp( [ -1*e for e in self.H()] ))
    
    def Error(self):
        return  -sum((e[0] * np.log(e[1])) + ((1- e[0]) * np.log(1-e[1])) for e in zip(self.y, self.S()))/len(self.y)
        
    def changeTheta(self):
        
        h = self.S()
        
        for j in range(len(self.theta)):
            suma = 0
            for i in range(len(self.y)):
                suma  = suma +((self.y[i] - h[i]) * (-1*self.x[i][j]))
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
        err = self.Error()
        #self.graficar(i)
        cont = 0
        while(err>self.umbral):
            #if(i%20==0):
                #self.graficar(i)    
            self.changeTheta()
            print(err)
            temp = err;
            err = self.Error()
            if(temp==err):
                cont = cont+1
            else:
                cont = 0
                
            if(cont==30):
                break
                
    def prediction(self,x):
        p=1/(1+ np.exp(-1*np.dot(self.theta,x)))
        return (p)
    
    
prepareData('data.txt')
a = RL('train.txt')
a.entrenar()

data = pd.read_csv('test.txt',header = None)
y = np.array(data[5])

df = data.loc[:,0:4]
x = np.array(df)
print('predicciones')

cont0=0
cont1=0
for i in range(len(x)):
    var = a.prediction(x[i])
    if(y[i]==0 and var<0.5):
        cont0=cont0+1

    if(y[i]==1 and var>0.5):
        cont1=cont1+1
        
    print(var, ' -> ' ,y[i] )
    
print(cont1,cont0)
print('Porcentaje de acierto: ', ((cont1+cont0)*100)/len(x) ,'%')


# In[110]:


import numpy as np
import pandas as pd


def prepareData(filename):
    data = pd.read_csv(filename, header=None)
    y = np.array(data[4])

    df =data.loc[:]
    new_col=np.ones(len(y))
    df.insert(loc=0, column=-1, value=new_col)
    a = np.array(df)
    np.random.shuffle(a)
    print(len(df))
    dataTrain=[]
    dataTest=[]

    trainData = int(len(a) * 0.6)

    for i in range(trainData):
        dataTrain.append(a[i])
    
    for i in range(trainData,len(a)):
        dataTest.append(a[i])
        
    matTr = np.matrix(dataTrain)
    matTs = np.matrix(dataTest)

    with open('train.txt','wb') as f:
        for line in matTr:
            np.savetxt(f, line, fmt='%.1f')

    with open('test.txt','wb') as f:
        for line in matTs:
            np.savetxt(f, line, fmt='%.1f')

data = pd.read_csv('test.txt',header = None)
y = np.array(data[5])

df = data.loc[:,0:4]
x = np.array(df)


# In[158]:


import pandas as pd
import numpy as np

class RLo:
    X =[]
    Y =[]
    theta=[]
    umbral=0.1
    alfa = 0.007
    error = 0
    def __init__(self,filename):
        data = pd.read_csv(filename, header=None)
        self.Y = np.array(data[4])
        df =data.loc[:,0:3]
        new_col=np.ones(len(self.Y))
        df.insert(loc=0, column=-1, value=new_col)
        self.X =  np.array(df)
        self.theta = [np.random.random(5)]
    
    def H(self):
        return  [np.dot(self.theta,e) for e in self.X]
    def S(self):
        return 1.0/(1.0 +np.exp( [ -1*e for e in self.H()] ))

    def Error(self):
        s = self.S()
        error =0
        for i in range(len(self.Y)):
            error1 = self.Y[i]*(np.log(s[i]))
            error0 = (1.0-self.Y[i])*(np.log(1-s[i]))
            error = error + error1 + error0
        return -1*error/len(self.Y)

    def changeTheta(self):
        h = self.S()
        for j in range(len(self.theta)):
            derror =0
            for i in range(len(self.Y)):
                derror = derror + (self.Y[i] - h[i])*(-1*self.X[i][j])/len(self.Y)
            self.theta[j] = self.theta[j] -  self.alfa*derror

    def train(self):
        error = self.Error()
        while(error>0.68):
            self.changeTheta()
            print(error)
            error = self.Error()

    def prediction(self,x):
        return 1/(1+ np.exp(-1*np.dot(self.theta,x)))
    
d = RLo('data.txt') 
d.train()

#print('prediccion' + str(d.prediction([1,5.4,3.7,1.5,0.2])))

