//
//  main.swift
//  211006
//
//  Created by 이진하 on 2021/10/06.
//

import Foundation

print("Hello, World!")

//print(bubbleSort(arr: [10,3,2,5,6,8,4,9,7,1]))
//print(solution([1, 5, 2, 6, 3, 7, 4]    , [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))
//print(solution([3, 30, 34, 5, 9]))

var arr:[Int] = [9,1,3,2,4,5,10,8,7,6]
//quickSort(s: 0, e: 9, arr: &arr)
print(InsertSort(arr: &arr))
print(arr)
