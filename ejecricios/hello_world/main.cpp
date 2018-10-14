#include <iostream>
using namespace std;

int main(){

    int num, sum= 1, c=0;

    while(cin>>num){
    if(num == -1) break;
        for(int i = 1;i < num; i++){
            sum = sum *i;
            c++;
        if(sum > num) break;

        }
         cout<<c;
        }




    return 0;
}
