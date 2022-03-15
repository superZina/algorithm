//
//  main.cpp
//  20220315
//
//  Created by 이진하 on 2022/03/15.
//

#include <iostream>
#include <algorithm>
using namespace std;
// 최대공약수
int GCD(int a, int b) {
    while(a%b != 0){
        int tmp = a%b;
        a = b;
        b = tmp;
    }
    return  b;
}

int main(int argc, const char * argv[]) {
    int n = 0;
    cin >> n;
    for(int i=0; i<n; i++) {
        int a,b;
        cin >> a >> b;
        int gcd = GCD(a, b);
        
        if (gcd == 0) { gcd = 1; }
        
        cout << a*b/gcd << " " << GCD(a, b) << endl;
    }
    return 0;
}
