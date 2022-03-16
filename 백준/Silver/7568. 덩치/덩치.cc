#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    
    int n;
    cin >> n;
    pair<int, int> body[n];
    
    for(int i=0 ; i<n; i++) {
        cin >> body[i].first >> body[i].second;
    }
    
    for(int i=0; i< n; i++) {
        pair<int, int> my = body[i];
        int score = 0;
        for(int j=0; j<n; j++) {
            if(i!=j) {
                pair<int, int> your = body[j];
                if(my.first < your.first && my.second <  your.second) {
                    score++;
                }
            }
        }
        cout << score + 1 << " ";
    }
    cout << endl;
    return 0;
}