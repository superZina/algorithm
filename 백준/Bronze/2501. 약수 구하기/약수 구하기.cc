#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    
    int n, k;
    cin >> n >> k;
    bool arr[n+1];

    for(int i=1; i<=n; i++) {
        arr[i] = false;
    }
    
    for(int i=1; i<= n; i++) {
        
        if((n%i == 0) && !arr[i]) {
            arr[i] = true;
            arr[n/i] = true;
        }
    }
    
    int count = 0;
    
    for(int i=1; i <= n; i++) {
        
        if (arr[i]) {
            count++;
        }
        
        if (count == k) {
            cout << i << endl;
            break;
        }
    }
    
    if (count < k) {
        cout << "0" << endl;
    }
    
    return 0;
}
