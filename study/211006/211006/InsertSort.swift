//
//  InsertSort.swift
//  211006
//
//  Created by 이진하 on 2021/10/08.
//

import Foundation

func InsertSort(arr: inout [Int]) -> [Int] {
    
    var j:Int = 0
    
    (0..<arr.count-1).forEach { i in
        j = i
        while arr[j] > arr[j+1] {
            arr.swapAt(j, j+1)
            j -= 1
            if j < 0 { break }
        }
    }
    
    return arr
}
