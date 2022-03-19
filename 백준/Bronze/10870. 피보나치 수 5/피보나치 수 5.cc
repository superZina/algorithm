#include <iostream>
#include <algorithm>

using namespace std;

int dp[20];

int fibo(int n) {
    if(n == 0) {
        return  0;
    }
    
    if(n==1) {
        return  1;
    }

    if(dp[n]!=0 ) {
        return dp[n];
    }
    
    dp[n] = fibo(n-1) + fibo(n-2);
    
    return dp[n];
}

int main(int argc, const char * argv[]) {
    
    int n;
    
    dp[0] = 0;
    dp[1] = 1;
    
    cin >> n;
    
    cout << fibo(n);
    return  0;
    
}