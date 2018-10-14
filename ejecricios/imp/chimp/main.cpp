#include <iostream>
using namespace std;

int main()
{
    int N = 50000;
    int m, a[N];

    cin>>m;
    int h=0;
    while(m)
    {
        cin>>a[h];
        h++;
        m--;
    }

    int i, v ,mid, h2;
    cin>>m;
    while (m)
    {
        cin>>h2;
        for (i=0, v=h-1; i<v;)
        {
            mid = (i+v)/2;
            if (a[mid]<h2) i = mid+1;
            else v = mid;
        }

        if(a[i]<h2) cout<<a[i];
        else if (i-1>=0 and a[i-1]<h2) cout<<a[i-1];
        else cout<<" X"<<endl;

        if (a[i]>h2) cout<<" "<<a[i]<<endl;
        else if (i+1<h) cout<<" "<<a[i+1]<<endl;
        else cout<<" X"<<endl;
        m--;
    }
}
