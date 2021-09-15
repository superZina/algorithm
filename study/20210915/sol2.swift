//
//  sol2.swift
//  algorithm
//
//  Created by 이진하 on 2021/09/15.
//

import Foundation

//MARK: - 프린터
func solution(_ priorities:[Int], _ location:Int) -> Int {
    var dict:[(Int,Int)] = []
    
    (0..<priorities.count).forEach { i in
        dict.append((priorities[i] , i))
    }
    
    var results:[(Int , Int)] = []
    
    while !dict.isEmpty {
        
        let first = dict.removeFirst()
        
        if dict.isEmpty { results.append(first) }
        else {
            if let idx = dict.firstIndex(where: {$0.0 > first.0}) {
                //지금 꺼낸것보다 큰게 있다면
                dict.append(first)
            }else{
                //큰게 없다면
                results.append(first)
            }
        }
         
    }
    
    let idx = results.firstIndex(where: {$0.1 == location}) ?? 0
    
    return idx + 1
}

//print(solution([2,1,3,2], 2))
//print(solution([1, 1, 9, 1, 1, 1], 0))
