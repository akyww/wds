#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

bool esPalindromo(string word){
    for(int i=0; i<=word.size()/2;i++){
        if(word[i] == word[word.size()-i-1]) return true;
        else return false;
    }
}

int combinaciones(string s){

    int c=0;

    string r = s;
  //  cout<<r;

    for(int i=0; i<s.size();i++){
            r=r+s[i];
    //    if(esPalindromo(s)) c++;
    for(int j=0; j<r.length();j++){
        if(esPalindromo(r)) c++;
        r= r + s[i+1];

    }
     return c;
}
}


int Retorna_Palindrome(string s)
{
    int C=0;
    if (esPalindromo(s))
        C++;


    for(int i=0;i<s.size();i++)
    {

        string R;
        for(int j=0;j<R.size();j++)
            if(s[i]!=R[j])
            R= R + s[j];


        if (esPalindromo(R))  C++;
    }

    return C;
}


int main()
{



  std::string cadena;
    int i =0;
    while(cin>>cadena){
    for(int i = 0; i<cadena.size();i++){
    std::next_permutation(cadena.begin(), cadena.end());
    std::next_permutation(cadena.begin(), cadena.end());

    if(esPalindromo(cadena)) i++;
    std::cout << cadena << std::endl;
    }
    cout<<i;
    }

  //cout<<combinaciones(s);

//    cout<<esPalindromo(s);

/*
    string S= "aba";
    cout<<S<<endl;
    cout<<Retorna_Palindrome(S);

 /*
    int num;
    string word;
    int c=0;
    cin>>num;
/*
    while(num){
        cin>>word;
    int size=word.length();
    int j=0;
    for(int i=0; i<size;i++){
        if(esPalindromo(word)){
            c++;
        }
    }
    cout<<c;
    num--;
}

*/
      return 0;
}

