#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int n;
    cin >> n;
    
    int nums[n];
    int count[8001];
    double sum = 0;
    for(int i=0; i <= 8000; i++) {
        count[i] = 0;
    }
    
    for(int i=0; i<n; i++) {
        cin >> nums[i];
        
        if(nums[i] <= 0) {
            count[abs(nums[i])]++;
        }else {
            count[nums[i]+4000]++;
        }
        sum += nums[i];
    }
    double avg = round( sum / n);
    if(avg == -0) {
        avg = 0;
    } 
    // 산술 평균
    cout << avg << endl;
    
    // 정렬
    sort(nums, nums + n);
    // 중앙값
    cout << nums[n/2] << endl;
    
    int maxIdx = 0;
    int max = 0;
    bool changed = false;
    
    for(int i=4000; i>=0; i--) {
        if(count[i] == 0) { continue; }
        if (max < count[i]) {
            maxIdx = i;
            max = count[i];
            changed = false;
        }else if(max == count[i]) {
            if(changed) {continue;}
            else {
                // 최빈값이 여러개면 두번째로 작은값을 출력
                maxIdx = i;
                changed = true;
            }
        }
    }
    
    for(int i=4001; i<8001; i++) {
        if(count[i] == 0) { continue; }
        if (max < count[i]) {
            maxIdx = i;
            max = count[i];
            changed = false;
        }else if(max == count[i]) {
            if(changed) {continue;}
            else {
                // 최빈값이 여러개면 두번째로 작은값을 출력
                maxIdx = i;
                changed = true;
            }
        }
    }
    
    // 최빈값
    if(maxIdx <= 4000) {
        cout << -maxIdx << endl;
    }else{
        cout << maxIdx - 4000 << endl;
    }
    
    // 범위
    cout << nums[n-1] - nums[0] << endl;
    
    return  0;
    
}
