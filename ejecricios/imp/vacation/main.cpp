#include <iostream>
#include <string>
using namespace std;

int main() {
    int c = 0;
    string a, b;
    int mat[100][100];

    while(getline(cin,a))
    {
    if (a=="#") break;
    c++;
    getline(cin, b);

    int sizea = a.size();
    int sizeb = b.size();

    for (int i = 0; i <= sizea; i++){
      mat[i][0] = 0;
    }

    for (int i = 0; i <= sizeb; i++){
      mat[0][i] = 0;
    }

    for (int i = 1; i <= sizea; i++) {
      for (int j = 1; j <= sizeb; j++) {
        if (a[i-1] == b[j-1])
          mat[i][j] = mat[i-1][j-1] + 1;
        else
          mat[i][j] = max(mat[i-1][j], mat[i][j-1]);
      }
    }
    cout << "Case #" << c<< ": you can visit at most " << mat[a.size()][b.size()] << " cities." << endl;
  }

  return 0;
}
