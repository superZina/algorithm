
#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    int n, k;
    cin >> n >> k;
    int cards[n];
    
    for(int i=0; i<n; i++) {
        cin >> cards[i];
    }
    
    int maxVal = 0;
    
    for(int i=0 ; i<n; i++) {
        for(int j=i+1; j< n; j++) {
            for(int l=j+1; l<n; l++) {
                int sum = cards[i] + cards[j] + cards[l];
                if (sum <= k) {
                    maxVal = max(maxVal, sum);
                }
            }
        }
    }
    
    cout << maxVal << endl;
    
    return 0;
}
