//
//  Kth.swift
//  211006
//
//  Created by 이진하 on 2021/10/06.
//

import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    
    var result:[Int] = []
    
    commands.forEach { arr in
        
        let start = arr[0]
        let end = arr[1]
        let k = arr[2]
        
        let range = (start-1)..<end
        let subArr = array[range].sorted(by: <)
        
        result.append(subArr[k-1])
        
    }
    
    return result
}
