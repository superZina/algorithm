//
//  max.swift
//  211006
//
//  Created by 이진하 on 2021/10/06.
//

import Foundation

var result:Int = -1
func back(cnt:Int ,n:Int, arr:[Int] , list:inout [Int]){
    if cnt == n {
        let num = Int(list.map({String($0)}).joined())!
        result = max(result, num)

    }else{
        for i in 0..<n {
            if !list.contains(arr[i]) {
                list.append(arr[i])
                back(cnt: cnt+1, n: n, arr: arr, list: &list)
                list.removeLast()
            }
        }
    }
}

func solution(_ numbers:[Int]) -> String {
    
    var list:[Int] = numbers.sorted { num1 , num2 in
        return String(num1) + String(num2) > String(num2) + String(num1)
    }
    if list.first! == 0 {
        return "0"
    }
    return list.map({String($0)}).joined()
    
}
