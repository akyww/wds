#include<cmath>
#include<cstdio>
#include<iostream>
#define N 0.000000001
using namespace std;

int p, q, r, s, t, u;

float ecuacion(float x) {
    return p * exp(-x) + q * sin(x) + r * cos(x) + s * tan(x) + t * pow(x, 2.0) + u;
}

int main() {

    while(cin>> p>> q>> r>> s>> t>> u)
    {
        double low = 0.0, high = 1.0;
        double emid, ehigh;
        double mid;

        while(high - low > N)
        {
            mid = (low + high)/2;
            emid = ecuacion(mid);
            ehigh = ecuacion(high);
            if((ehigh < 0 and emid > 0) or (ehigh >= 0 and emid > ehigh) or (ehigh <= 0 and ehigh > emid))
            {
                low = mid;
            } else {
                high = mid;
            }
        }
        if(abs(emid) <= 0.0001)
            printf("%1.4f\n", mid);
        else
            cout<<"No solution"<<endl;
    }
    return 0;
}

