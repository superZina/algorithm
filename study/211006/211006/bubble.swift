//
//  bubble.swift
//  211006
//
//  Created by 이진하 on 2021/10/06.
//

import Foundation
//bubble sort : 당장 옆에것과 비교하여 바꿔줌
//한번 반복했을때, 가장 큰 값이 뒤로 가있음.
//두번째부터는 1~n-i번째까지 비교하면 됨.
func bubbleSort(arr: [Int]) -> [Int] {

    var sorted = arr
    let len = arr.count
    
    (0..<len).forEach { i in
        (0..<len-i-1).forEach { j in
            if sorted[j] > sorted[j+1] {
                sorted.swapAt(j, j+1)
            }
        }
    }
    
   return sorted
}
