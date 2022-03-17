#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    int n ;
    cin >> n;
    int num = 666;
    
    while(n>0){
        string text = to_string(num);
        if( text.find("666") != string::npos ) {
            n--;
        }
        num++;
    }
    cout << num - 1 << endl;
    return 0;
}
