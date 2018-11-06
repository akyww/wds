
# coding: utf-8

# In[119]:


import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import random
from sklearn.decomposition import PCA
from scipy.spatial import distance
import os


iris = pd.read_csv('iris.csv')
vinos = 0

data = np.matrix(iris)
x = PCA(n_components=2)

datasets = x.fit_transform(data)

#print(datasets)

def cluster_colors(lists,data):
    
    colors = []
    for i in data:
        for j in lists:
            condition = any([compa.all() for compa in i == j])
            if condition:
                tmp = lists.index(j)
        colors.append(tmp)
    
    return colors

def clustering(data,centroids,num_clusters):
    
    lists = [[centroids[i]] for i in range(num_clusters)] 
    for i in data:
        flag   = 0
        minimo = 0
        for j in range(len(centroids)):
            dis  = distance.euclidean(i,centroids[j])
            if(minimo == 0):
                minimo = dis
                
            if(dis<minimo):
                minimo = dis
                flag = j
        lists[flag].append(i)
    return lists

def graph(x,y,cColors,cont):
    
    plt.scatter(x, y, c=cColors)
    output_path = os.path.join('D:\kmeans_iris',str(cont)+'.png')
    plt.savefig(output_path)
    plt.show()
    plt.close()

def k_means(data,num_clusters):
    
    k = 0
    end = False
    centroids = random.sample(list(data), num_clusters)
    
    while(end!=True):
        k+=1
        print(k)
        lists = clustering(data,centroids,num_clusters)
        
        cont = 0
        newCentroids = []
        for i in range(len(lists)):
            mean = (np.mean(lists[i], axis=0))
            if(np.array_equal(mean,centroids[i])):
                cont+= 1
            if(cont == num_clusters):
                end  = True;
            newCentroids.append(mean)

        centroids = newCentroids
        colors = cluster_colors(lists,data)
    
        print(colors)
        graph(datasets[:, 0], datasets[:, 1], colors,k)
        

k_means(datasets,3)





# In[ ]:


import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import random
from sklearn.cluster import KMeans
from sklearn.decomposition import PCA
from scipy.spatial import distance


iris = pd.read_csv('iris.csv')

data = np.matrix(iris)
x = PCA(n_components=2)

datasets = x.fit_transform(data)

#print(datasets)

#plt.figure(figsize=(12, 12))

y_pred = KMeans(n_clusters=3).fit_predict(datasets)

def euclidian_distance(data,num_clusters):
    k = 0
    end = False
    random_centroids = random.sample(list(data), num_clusters)
    while(end!=True):
        k+=1
        print(k)
        lists = distance_E(data,random_centroids,num_clusters)
#         lists = [[random_centroids[i]] for i in range(num_clusters)] 
# #         for i in lists:
# #             print(i, 'another list')


#        
#         for i in data:
#             disTmp = 0
#             flag   = 0
#             for j in range(len(random_centroids)):
#                 temp = disTmp
#                 dis = distance.euclidean(i,random_centroids[j])
#                 disTmp = dis
#                 if(dis<temp):
#                     tmp  = dis
#                     flag = j
#         #         print(flag)
#             lists[flag].append(i)


#         suma = 0
#         for i in lists:
#             suma = suma + len(i)
#             print(i,"asdf---------------------------->",len(i))
#         print(suma)
        cont = 0
        newCentroids = []
        for i in range(len(lists)):
            mean = (np.mean(lists[i], axis=0))
            if(np.array_equal(mean,random_centroids[i])):
                cont += 1
            if(cont==num_clusters):
                end = True;
            #print(mean)
            newCentroids.append(mean)

        random_centroids = newCentroids
        
        
        

def kMeans(n_clusters,data):

    random_centroids = random.sample(list(data), n_clusters)
    
    a = [2,3,4,2]
    b = [1,-2,1,3]

    dis  = distance.euclidean(a,b)
    
    suma = 0
    for i in range(len(a)):
        suma = suma + np.power(a[i]-b[i],2)
    

    euclidean = np.sqrt(suma)
    print(euclidean)
    print(dis,np.power(3,3))
    

#plt.subplot(221)
#plt.scatter(datasets[:, 0], datasets[:, 1], c=y_pred)
#plt.title("Incorrect Number of Blobs")

#kMeans(3,datasets)


euclidian_distance(datasets,3)


