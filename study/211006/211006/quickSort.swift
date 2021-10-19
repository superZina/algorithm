//
//  quickSort.swift
//  211006
//
//  Created by 이진하 on 2021/10/06.
//

import Foundation

//pivot을 기준으로 작으값들은 pivot 왼쪽으로 옮겨지고 , 큰 값들은 pivot의 오른쪽으로 옮겨진다.
//왼쪽에서 훑을때는 큰값을 찾아야하고, 오른쪽에서 훑을때는 작은값을 찾아야한다.
//start가 end를 넘었을때 피봇값과 교체함
//피봇 기준으로 왼쪽 오른쪽 다시 진행해줌 (재귀)
func quickSort(s:Int , e:Int , arr: inout [Int]) {
    //원소가 1개인 경우
    if s >= e { return }
    // 첫번째 원소로 피봇을 설정
    var key = s
    //i,j : 왼쪽과 오른쪽 움직이는 인덱스
    var i = s + 1
    var j = e
    
    //엇갈릴때까지 반복
    while(i <= j) {
        //왼쪽에서 출발한 인덱스가 key위치에 있는 값보다 큰값을 만날때까지 이동함
        while arr[i] <= arr[key] {
            i += 1
        }
        //j위치에 있는 값이 key위치에 있는 값보다 작은값을 만날때까지 이동
        while arr[j] >= arr[key] && j > s {
            j -= 1
        }
        //엇갈렸다면, key값과 교체
        if i > j {
            arr.swapAt(j, key)
        //엇갈리지 않았다면 왼쪽과 오른쪽 값을 교체
        }else{
            arr.swapAt(i, j)
        }
        
        
        quickSort(s: s, e: j-1, arr: &arr)
        quickSort(s: j+1, e: e, arr: &arr)        
    }
    
}
