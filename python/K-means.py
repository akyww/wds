
# coding: utf-8

# In[190]:


import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import random
from sklearn.decomposition import PCA
from scipy.spatial import distance
import os


iris = pd.read_csv('iris.csv')
vinos = pd.read_csv('vinos.txt')

data = np.matrix(iris)
x = PCA(n_components=2)

datasets = x.fit_transform(data)

dataV = np.matrix(vinos)
dataVinos = x.fit_transform(dataV)

# print(dataVinos)
# print(datasets)

def cluster_colors(lists,data):
    
    colors = []
    for i in data:
        for j in range(len(lists)):
            condition = any([compa.all() for compa in i == lists[j]])
            if condition: 
                tmp = j
                break
        colors.append(tmp)
    
    return colors

def clustering(data,centroids,num_clusters):
    
    print('s')
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

def graph(x,y,cColors,cont,centroids,folder):
    
    plt.scatter(x, y, c=cColors)
    for c in centroids:
        plt.scatter(c[0],c[1],s=100,c='r',marker='X')
    output_path = os.path.join(folder,str(cont)+'.png')
    plt.savefig(output_path)
    plt.show()
    plt.close()

def k_means(data,num_clusters,folder,x,y):
    
    k = 0
    end = False
    centroids = random.sample(list(data), num_clusters)
    #centroids = np.random.randint(0, 10, (num_clusters, 2))
    print(centroids)
    temp_random = centroids
    while(end!=True):
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
        if k is 0:
            graph(x, y, colors,k,temp_random,folder)
        graph(x, y, colors,k,centroids,folder)
        k+=1
        
        
#k_means(datasets,3,'D:\kmeans_iris',datasets[:, 0],datasets[:, 1])

k_means(dataVinos,3,'D:\kmeans_vinos',dataVinos[:,0],dataVinos[:,1])



# In[168]:


x = [1,2,3]
y = [3, 2,1]


C = [4,1,2]
area = [2000,2000,2000]
centroid = [1,3]

plt.scatter(x,y,s=area,c=C)

cen = [[ 1.27799588, -0.32739624], [ 2.33165373, -0.04311693], [3.4724999 , 1.16855166]]

for c in cen:
    plt.scatter(c[0],c[1],c='k',marker='X')
    
    
centroids = random.sample(range(1,149), 3)

randomc = np.random.randint(0, 150, (3, 2))

print(randomc)

