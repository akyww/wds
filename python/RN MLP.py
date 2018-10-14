
# coding: utf-8

# In[3]:


import numpy as np
import pandas as pd

class RL:
    umbral = 0.01
    alfa = 0.007
    error = 0
    NumH =0
    NumO =0
    Wih = []
    WhO = []
    x = []
    y = []
    o = []
    shBias = []
    neta = []
    sh = []
    
    def __init__(self,filename,NumH,NumO):
        data = pd.read_csv(filename, header=None)
        bias = np.array(data[4])
        df =data.loc[:,0:3]
        new_col=np.ones(len(bias))
        df.insert(loc=0, column=-1, value=new_col)
        self.x =  np.array(df)
        dfy = data.loc[:,4:6]
        self.y = np.array(dfy)
        self.NumH = NumH
        self.NumO = NumO
        self.Wih = np.array(np.random.rand(5,NumH))
        self.WhO = np.array(np.random.rand(NumH+1, NumO))
        
    def prin(self):
        print(self.x)
        print(self.y)
        print(self.Wih)
        
    def prediction(self,x,y):     
        
        sh = self.S(np.matmul(x,self.Wih))
        self.shBias = np.insert(sh,0,1,axis = 0)
        self.o = self.S(np.matmul(self.shBias,self.WhO))
        print(self.o)
        print(y)
        error = [] 
        for i in range(len(self.o)):
            error.append((y[i] - self.o[i])**2)
        
        print('la prediccion es --> ',error)
        
    def S(self,neta):
        return 1.0/(1.0+np.exp(-neta))
        
    def propagation(self,x,y):
        self.sh = self.S(np.matmul(x,self.Wih))
        self.shBias = np.insert(self.sh,0,1,axis = 0)
        self.o = self.S(np.matmul(self.shBias,self.WhO))
        return self.Error(y,self.o)
    
    def Error(self,sd,so):
        suma = 0
        for i in range(len(so)):
            suma = suma + (sd[i] - so[i])**2
        return suma/2
    
    def retropropagar(self,x,y):
                
        delta = [-(e[0] - e[1]) * (e[1]*(1 - e[1])) for e in zip(y, self.o)]
        
        for i in range(self.NumH+1):
            for j in range(self.NumO):
                self.WhO[i][j] = self.WhO[i][j]- self.alfa*delta[j]*self.shBias[i]
        
        
        deltaSum = np.matmul(delta,self.WhO.T)
        
        shPrima = []
        
        for i in self.shBias:
            shPrima.append(i*(1-i))
    
        
        deltaO = [ e[0] * e[1] * e[2] for e in zip(deltaSum,shPrima,x) ]
        
        for i in range(len(deltaO)):
            for j in range(self.NumH):
                self.Wih[i][j] = self.Wih[i][j]- self.alfa*deltaO[j]
        
        

    def GetRandomX(self):
        arr = self.x[:]
        rd = np.random.randint(0,149)
        print(rd)
        return arr[rd], self.y[rd]

    def Train(self):
        (x,y) = self.GetRandomX()
        error =  self.propagation(x,y)
        print(error)
        i=0

        while(error > self.umbral):
            self.retropropagar(x,y)
            error = self.propagation(x,y)
            print(error)
            i += 1
#             print(i)
#             print(self.Wih)
#             print(self.WhO)

a = RL('iris.csv',4,3)
a.Train()

(x,y) = a.GetRandomX();

a.prediction(x,y)


# while(j<3):
#     (x,y) = self.GetRandomX()
#     error =  self.propagation(x,y)
#     print(error)
#     i=0
    


# In[2]:


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
    umbral = 0.05
    alfa = 0.005
    error = 0
    NumH =0
    NumO =0
    Wih = []
    WhO = []
    x = []
    y = []
    o = []
    shBias = []
    neta = []
    data = []
    dt = []
    
    def __init__(self,filename,NumH,NumO):
        data = pd.read_csv(filename, header=None)
        bias = np.array(data[4])
        df =data.loc[:,0:3]
        new_col=np.ones(len(bias))
        df.insert(loc=0, column=-1, value=new_col)
        self.x =  np.array(df)
        dfy = data.loc[:,4:6]
        self.y = np.array(dfy)
        self.dt = data.loc[:]
#         self.data = np.array(dt)
        self.NumH = NumH
        self.NumO = NumO
        self.Wih = np.array(np.random.rand(5,NumH))
        self.WhO = np.array(np.random.rand(NumH+1, NumO))
        
    def prin(self):
        print(self.x)
        print(self.y)
        print(self.Wih)
        
    def prediction(self,x,y):     
        
        so = []
        for i in x:
            sh = self.S(np.matmul(i,self.Wih))
            self.shBias = np.insert(sh,0,1,axis = 0)
            self.o = self.S(np.matmul(self.shBias,self.WhO))
            so.append(self.o)

        sd = []
        predicciones = []
        cont = 0
        
        for i in y:
            tmp = []
            for j in range(len(self.o)):
                tmp.append((i[j] - self.o[j]))
            predicciones.append(tmp)
            
        for i in range(len(y)):
            print('Prediccion de --> ',predicciones[i], ' de ',y[i] )
            for j in range(3):
                if(y[i][j] == 1):
                    if(predicciones[i][j]>0.5):
                        cont += 1
        
        print(cont,' de ',len(y))
        
    def S(self,neta):
        return 1.0/(1.0+np.exp(-neta))
        
    def propagation(self,x,y):
        sh = self.S(np.matmul(x,self.Wih))
        self.shBias = np.insert(sh,0,1,axis = 0)
        self.o = self.S(np.matmul(self.shBias,self.WhO))
        return self.Error(y,self.o)
        
    def Error(self,sd,so):
        suma = 0
        for i in range(len(so)):
            suma = suma + (sd[i] - so[i])**2
        return suma/2
    
    def retropropagar(self,x,y):
                
        delta = [-(e[0] - e[1]) * (e[1]*(1 - e[1])) for e in zip(y, self.o)]
        
        deltaSum = np.matmul(delta,self.WhO.T)
        
        for i in range(self.NumH):
            for j in range(self.NumO):
                self.WhO[i][j] = self.WhO[i][j]- self.alfa*delta[j]*self.shBias[i]
        
        shPrima = []
        
        for i in self.shBias:
            shPrima.append(i*(1-i))
    
        deltaO = [ e[0] * e[1] * e[2] for e in zip(deltaSum,shPrima,x) ]
        
        for i in range(len(deltaO)):
            for j in range(self.NumH):
                self.Wih[i][j] = self.Wih[i][j]- self.alfa*deltaO[j]

    def GetRandomX(self):
        arr = self.x[:]
        rd = np.random.randint(0,90)
        return arr[rd], self.y[rd]
        
    def Train(self):
        (x,y) = self.GetRandomX()
        error =  self.propagation(x,y)
        print(error)
        i = 0
        while(error > self.umbral and i< 10000):
            self.retropropagar(x,y)
            (x,y) = self.GetRandomX()
            error = self.propagation(x,y)
            print(error)
            i += 1

# print('Porcentaje de acierto: ', ((cont1+cont0)*100)/len(x) ,'%')

a = RL('train.txt',3,3)
# (x,y) = a.GetRandomX()
# prepareData('iris.csv')
a.Train()
data = pd.read_csv('test.txt',header = None)
dy = data.loc[:,5:7]
y = np.array(dy)
df = data.loc[:,0:4]
x = np.array(df)

a.prediction(x,y)


# In[4]:


import numpy as np

class MLP:
    X = []
    Y = []
    O = []
    NumI=0
    NumH =0
    NumO =0
    Wih = []
    WhO = []
    alfa = 0.5
    umbral = 0.01
    shBias = []
    sh = []
    
    def __init__(self,NumI,NumH, NumO,x,y):
        #(self.X,self.Y)=self.preprocesar(file)
        self.NumI = NumI
        self.NumH = NumH
        self.NumO = NumO
        self.Wih =  np.array([[0.15,0.20,0.35],[0.25,0.30,0.35]])
        self.WhO = np.array([[0.40,0.45,0.60],[0.50,0.55,0.60]]) 
        print(self.WhO)
        
    def S(self,neta):
        return 1.0/(1.0+np.exp(-neta))
        
        
    def propagation(self,x,y):
        self.sh = self.S(np.matmul(x,self.Wih.T))
        self.shBias = np.insert(self.sh,2,1,axis = 1)
        self.shBias = np.squeeze(np.asarray(self.shBias))
        netOut = np.matmul(self.shBias,self.WhO.T)
        self.O = self.S(netOut)
        print(self.shBias[0],'bias')
        self.O = np.squeeze(np.asarray(self.O))
        return self.Error(y,self.O)
       
    def retropropagar(self,x,y):
                
        delta = [-(e[0] - e[1]) * (e[1]*(1 - e[1])) for e in zip(y, self.O)]
        
        print(delta,'delta')
        
        deltArray = np.array(delta)
        print(deltArray, deltArray.shape)
        
        deltaSum = np.matmul(delta,self.WhO)
        
        for i in range(self.NumO):
            for j in range(self.NumH+1):
                self.WhO[i][j] = self.WhO[i][j]- self.alfa*delta[i]*self.shBias[j]
        
#         print(self.WhO)
        
        shPrima = []
        
        print(deltaSum, 'deltaSum')
        
        for i in self.shBias:
            shPrima.append(i*(1-i))
            
        print(shPrima, 'shPrima')
    
        deltaO = [ e[0] * e[1] * e[2] for e in zip(deltaSum,shPrima,x) ]
        deltaO = np.squeeze(np.asarray(deltaO))
        
        print(deltaO,'deltaO')
        
        for i in range(self.NumH):
            for j in range(len(deltaO)):
                self.Wih[i][j] = self.Wih[i][j]- self.alfa*deltaO[j]
                
                
        print(self.Wih)
    
    def Error(self,so,sd):
        suma = 0
        for i in range(len(so)):
            suma = suma + (sd[i] - so[i])**2
        return suma/2
        
    def GetRandomX():
        return 0
        
    def Train():
        (x,y) = self.GetRandomX()
        error =  self.propagation(x,y)
        while(error > umbral):
            self.retropropagar()
            (x,y) = self.GetRandomX()
            error = self.propagation(x,y)

            
    def predecir(self, X):
        return self.propagation(x)
    
    def test(self):
        print(self.propagation(x,y))
        self.retropropagar(x,y)

x=np.matrix([0.05,0.1,1])
y=np.array([0.01,0.99])

print(y.shape)
a = MLP(2,2,2,x,y)
print('->',-0.03809823651655623 * 0.5)
print('->',0.13849856162855698 * 0.4)
print('-> wih', 0.25 - 0.5 * 0.00043857 )
print('dSum1->',0.05539942465142279 + -0.019049118258278114)
a.test()


